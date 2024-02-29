package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.MemberVO;
import com.simple.basic.command.ValidVO;


@Controller
@RequestMapping("/valid")
public class ValidController {

	@GetMapping("/ex01")
	public String ex01() {
		return "valid/ex01";
	}
	
	//폼요청
	@PostMapping("/validForm")
	public String validForm(@Valid ValidVO vo, Errors errors, Model model) {
		
		//유효성 검사에 실패한 목록을 Errors안에 바인딩
		
		if(errors.hasErrors()) {//error발생된 목록이 있다면 true
			List<FieldError> list = errors.getFieldErrors();
			
			for(FieldError err:list) {
				String field = err.getField(); //유효성 검사에 실패한 변수명
				String message = err.getDefaultMessage(); //유효성 검사에 실패한 변수 메시지
				
//				System.out.println(field);
//				System.out.println(message);
//				System.out.println("------------------");
				
				if(err.isBindingFailure()) { //유효성검사에 실패가 아니라 , 자바코드에 에러인경우 true
					model.addAttribute("valid_"+field,"숫자로 입력하세요");
				}else { 
					
					model.addAttribute("valid_"+field, message); //valid_이름, 메시지
				}
				
			}
			
			model.addAttribute("vo",vo); //원본데이터를 들고나감
			
			return "valid/ex01"; //다시 원래 화면
		}
		
		System.out.println(vo.toString());
		//데이터 베이스 처리~~~~~~
		
		return "valid/ex01_result";
		
	}
	
	@GetMapping("/quiz01")
	public String quiz01() {
		
		return "valid/quiz01";
	}
	
	
	@PostMapping("/quizForm")
	public String quizForm(@Valid MemberVO vo, Errors error,Model model) {
		
		if(error.hasErrors()) {
		
		List<FieldError> list2 = error.getFieldErrors();
		
		for (FieldError err2 : list2) {
			
			 String field2= err2.getField();//실패 변수
			 String message2 = err2.getDefaultMessage(); //검사 실패시 메세지
			 
			 model.addAttribute(field2,message2);
			 
			 
			 System.out.println(field2);
			 System.out.println(message2);
			 
//			 if(err2.isBindingFailure()) {
//				 
//				 model.addAttribute("valid_"+field2);
//			 }else {
//				 model.addAttribute("valid_"+field2,message2);
//			 }
		}
		 model.addAttribute("vo",vo);
		 return "valid/quiz01"; //원래 화면
		}
		return "valid/quiz01_result";
	}
	
	
}
