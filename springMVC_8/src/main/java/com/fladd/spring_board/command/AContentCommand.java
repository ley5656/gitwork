package com.fladd.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fladd.spring_board.dao.ADao;
import com.fladd.spring_board.dto.ADto;

public class AContentCommand implements ACommand { // 컨텐츠 보기
	
	@Override
	public void execute(Model model){
		
		Map<String, Object> map=model.asMap(); // 맵선언 및 모델에서 맵형식으로 맵 구하기
		HttpServletRequest request=(HttpServletRequest)map.get("request"); // 캐스팅 후 데이터 넘겨받기
		String aId=request.getParameter("aId"); // 아이디 구하기
		
		ADao dao=new ADao(); // 생성
		ADto dto=dao.contentView(aId); // 작업 지시
		
		model.addAttribute("content_view", dto); // 컨텐츠에 dto넣기
	}

}
