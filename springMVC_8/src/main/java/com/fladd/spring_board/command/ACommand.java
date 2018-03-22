package com.fladd.spring_board.command;

import org.springframework.ui.Model;

public interface ACommand {

	public void execute(Model model); // 실행 메소드
}
