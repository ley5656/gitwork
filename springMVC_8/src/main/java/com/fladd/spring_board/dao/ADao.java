package com.fladd.spring_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.fladd.spring_board.dto.ADto;
import com.fladd.spring_board.util.Constant;

public class ADao { // 실제로 데이터베이스에 접근하여 작업하는 곳

	DataSource dataSource;

	JdbcTemplate template = null;

	public ADao() { // 데이터 소스 구하기

		try {
			Context context = new InitialContext(); // 커넥션풀에 있는 객체 가져오기
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");// 객체를 가져오기 위해 초기화
		} catch (Exception e) {
			e.printStackTrace();
		}

		template = Constant.template;
	}

	public void write(final String aName, final String aTitle, final String aContent) {

		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				String query = "insert into mvc_board (aId,aName,aTitle,aContent,aHit,aGroup,aStep,aIndent) values (mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";

				PreparedStatement pstmt = con.prepareStatement(query);

				pstmt.setString(1, aName);
				pstmt.setString(2, aTitle);
				pstmt.setString(3, aContent);

				return pstmt;
			}
		});

	}

	public ArrayList<ADto> list() { // 리스트

		String query = "select aId,aName,aTitle,aContent,aDate,aHit,aGroup,aStep,aIndent from mvc_board order by aGroup desc, aStep asc";

		// 쿼리문과 데이터를 가져올 커맨드 객체 명시하기
		return (ArrayList<ADto>) template.query(query, new BeanPropertyRowMapper<ADto>(ADto.class));

	}

	public ADto contentView(String strID) {

		upHit(strID);

		String query = "select*from mvc_board where aId = "+strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<ADto>(ADto.class));

	}

	private void upHit(final String aId) { // 조회수 메소드 / 변경안되게 final 표기

		String query = "update mvc_board set aHit = aHit + 1 where aId=?";
		template.update(query, new PreparedStatementSetter() { // 새로운 익명 클래스 생성

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(aId));
			}
		});
	}

	public void modify(final String aId, final String aName, final String aTitle, final String aContent) {

		String query = "update mvc_board set aName = ?, aTitle = ?, aContent = ? where aId = ?";

		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aName);
				ps.setString(2, aTitle);
				ps.setString(3, aContent);
				ps.setInt(4, Integer.parseInt(aId));
			}
		});
	}

	public void delete(final String strID) {

		String query = "delete from mvc_board where aId=?";
		template.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, strID);
			}
		});
	}

	public ADto reply_view(String strID) {

		String query = "select * from mvc_board where aId = "+strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<ADto>(ADto.class));
	}

	public void reply(final String aId,final  String aName,final String aTitle, final String aContent, final String aGroup, final String aStep,
			final String aIndent) {
		
		replyShape(aGroup, aStep);

		String query = "insert into mvc_board (aId,aName,aTitle,aContent,aGroup,aStep,aIndent) values (mvc_board_seq.nextval,?,?,?,?,?,?)";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, aName);
				ps.setString(2, aTitle);
				ps.setString(3, aContent);
				ps.setInt(4, Integer.parseInt(aGroup));
				ps.setInt(5, Integer.parseInt(aStep)+1);
				ps.setInt(6, Integer.parseInt(aIndent)+1);
				
				
			}
		});
	}

	private void replyShape(final String strGroup, final String strStep) {

		String query = "update mvc_board set aStep = aStep + 1 where aGroup = ? and aStep > ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strGroup));
				ps.setInt(2, Integer.parseInt(strStep));
			}
		});
		

	}
}
