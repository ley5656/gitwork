package com.fladd.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fladd.spring_board.dao.ADao;

public class AWriteCommand implements ACommand{ // 쓰기

	@Override
	public void execute(Model model) {
		
		Map<String,Object> map=model.asMap(); // model을 map형태로 바꿈
		HttpServletRequest request=(HttpServletRequest) map.get("request"); // model에 담아둔 http가져오기
		
		String aName=request.getParameter("aName");
		String aTitle=request.getParameter("aTitle");
		String aContent=request.getParameter("aContent");
		
		ADao dao = new ADao(); // 객체 생성
		dao.write(aName, aTitle, aContent); // 넘길 때 받은 객체 담아 보내기
		

	}
}
