package com.fladd.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fladd.spring_board.dao.ADao;

public class AModifyCommand implements ACommand{ // 수정

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map=model.asMap(); // 모델 넘어온 것 map으로 받기
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String aId=request.getParameter("aId");
		String aName=request.getParameter("aName");
		String aTitle=request.getParameter("aTitle");
		String aContent=request.getParameter("aContent");
		
		ADao dao = new ADao(); 
		dao.modify(aId, aName, aTitle, aContent);
		
	}

}
