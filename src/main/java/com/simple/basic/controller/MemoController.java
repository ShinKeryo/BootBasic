package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.MemoVO;
import com.simple.basic.service.MemoMapper;

@Controller
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	MemoMapper testMemo;
	


	@GetMapping("/memoList")
	public String memo01(Model model) {
		
		
		List<MemoVO> list = testMemo.list();
		
		model.addAttribute("vo",list);
		
		
		
		return "memo/memoList";
	}

	@GetMapping("/memoWrite")
	public String memo02() {
		
		return "memo/memoWrite";
	}
	
	@PostMapping("/memoForm")
	public String memoForm(@Valid MemoVO vo, Errors errors,Model model) {
		
		
		
		
		if(errors.hasErrors()) {
			
			List<FieldError> list = errors.getFieldErrors();
		
			for(FieldError err: list) {
				
				String field = err.getField();
				String message = err.getDefaultMessage();
				
				model.addAttribute(field,message);
				
			}
			
			model.addAttribute("vo",vo);
			
			return "memo/memoWrite";
		
		}
		
		testMemo.insert(vo);
		
		return "memo/memoList";
		
	}
	
}

