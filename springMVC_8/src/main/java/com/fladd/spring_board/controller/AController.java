package com.fladd.spring_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fladd.spring_board.command.ACommand;
import com.fladd.spring_board.command.AContentCommand;
import com.fladd.spring_board.command.ADeleteCommand;
import com.fladd.spring_board.command.AListCommand;
import com.fladd.spring_board.command.AModifyCommand;
import com.fladd.spring_board.command.AReplyCommand;
import com.fladd.spring_board.command.AReplyViewCommand;
import com.fladd.spring_board.command.AWriteCommand;
import com.fladd.spring_board.util.Constant;

@Controller // 컨트롤러 어노테이션 추가
public class AController { // Model2 비슷한 방식의 작업

	ACommand command; // 객체 선언
	
	public JdbcTemplate template;
	
	
	@Autowired // 자동 스캔 및 할당시켜줌 
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template=this.template; // 언제든지 호출 가능
	}
	

	@RequestMapping("/home")
	public String home(Model model) {
		
		return "home";
	}	
	
	@RequestMapping("/list") // list 보기
	public String list(Model model) {
		
		System.out.println("list()"); // 콘솔 로그
		command=new AListCommand(); // 생성
		command.execute(model); // 호출
		
		return "list"; // list.jsp로 이동
	}
	
	@RequestMapping("/write_view") // 작성글 보기
	public String write_view(Model model) {
		
		System.out.println("write_view()"); // 콘솔 로그
		
		return "write_view"; // write_view.jsp로 이동
	}
	
	@RequestMapping("/write") // 글 작성하기
	public String write(HttpServletRequest request, Model model) { // 작성한 글 폼에 있는 데이터를 받기 위해 request객체 받기
		
		System.out.println("write()"); // 콘솔 로그
		
		model.addAttribute("request", request); // Service와 Dao에서 작업하기때문에 model에 담기
		command=new AWriteCommand(); // 생성
		command.execute(model); // 호출
		
		return "redirect:list"; // 글 작성 후 컨트롤러에서 다시 list.jsp로 이동
	}
	
	@RequestMapping("/content_view") // 작성글 내용보기
	public String content_view(HttpServletRequest request,Model model) {
		
		System.out.println("content_view()"); // 콘솔 로그
		
		model.addAttribute("request", request);
		command = new AContentCommand(); // 생성
		command.execute(model); // 호출
		
		return "content_view"; // content_view.jsp로 이동
	}
	
	// content_view.jsp에 있는 form post 하위의 모든 것이 넘어옴
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model) { 
		
		System.out.println("modify()"); // 콘솔 로그
		
		model.addAttribute("request", request); // model에 담기
		command=new AModifyCommand(); // 생성
		command.execute(model); // 호출
		
		return "redirect:list"; // 수정 후 컨트롤러에서 다시 list.jsp로 이동
	}
	
	@RequestMapping("/reply_view") // 답글 보기
	public String reply_view(HttpServletRequest request, Model model) {
		
		System.out.println("reply_view()"); // 콘솔 로그
		
		model.addAttribute("request", request); // model에 담기
		command=new AReplyViewCommand(); // 생성
		command.execute(model); // 호출
		
		return "reply_view"; // reply_view.jsp로 이동
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/reply") // 답글 작성
	public String reply(HttpServletRequest request, Model model) {
		
		System.out.println("reply()"); // 콘솔 로그
		
		model.addAttribute("request", request); // model에 담기
		command=new AReplyCommand(); // 생성
		command.execute(model); // 호출
		
		return "redirect:list"; // 답글 작성 후 컨트롤러에서 다시 list.jsp로 이동
	}
	
	@RequestMapping("/delete") // 글 삭제
	public String delete(HttpServletRequest request, Model model) {
		
		System.out.println("delete()"); // 콘솔로그
		
		model.addAttribute("request", request); // model에 담기
		command=new ADeleteCommand(); // 생성
		command.execute(model); // 호출
		return "redirect:list"; // 글 삭제 후 컨트롤러에서 다시 list.jsp로 이동
	}
}
