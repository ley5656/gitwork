package com.fladd.spring_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.fladd.spring_board.dao.ADao;
import com.fladd.spring_board.dto.ADto;

public class AListCommand implements ACommand{

	@Override
	public void execute(Model model) {
	
		ADao dao = new ADao(); // Dao 생성
		ArrayList<ADto> dtos = dao.list(); // list
		
		model.addAttribute("list", dtos); // model에 담기
	}

}
