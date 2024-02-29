package com.simple.basic.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoVO {
	
	private Integer mno;
	
	@Pattern(regexp =".{5,}",message="5글자 이상 입력하세요")
	private String memo;
	@Pattern(regexp = "[0-9]{11}",message="숫자만 입력하세요")
	private String phone;
	@Pattern(regexp = "[0-9]{4}",message="비밀번호는 숫자 4개입니다")
	private String pw;
	@NotNull
	private String secret;
}


