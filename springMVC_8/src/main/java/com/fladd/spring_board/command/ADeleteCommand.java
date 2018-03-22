package com.fladd.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fladd.spring_board.dao.ADao;

public class ADeleteCommand implements ACommand {
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object>map=model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String aId=request.getParameter("aId");
		ADao dao=new ADao();
		dao.delete(aId);
		
	}

}
