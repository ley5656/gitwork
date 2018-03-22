package com.fladd.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fladd.spring_board.dao.ADao;

public class AReplyCommand implements ACommand{ // 답글

	@Override
	public void execute(Model model) {
		
		Map<String,Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String aId=request.getParameter("aId");
		String aName=request.getParameter("aName");
		String aTitle=request.getParameter("aTitle");
		String aContent=request.getParameter("aContent");
		String aGroup=request.getParameter("aGroup");
		String aStep=request.getParameter("aStep");
		String aIndent=request.getParameter("aIndent");
		
		ADao dao=new ADao();
		dao.reply(aId,aName,aTitle,aContent,aGroup,aStep,aIndent);
		
		
	} 

}
