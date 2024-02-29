package com.simple.basic.command;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	
	@Pattern(regexp = "[a-zA-Z0-9]{8,}",message = "아이디는 대소문자, 숫자 포함 8글자 이상이어야합니다")
	private String id;
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,}",message="비밀번호는 대소문자, 숫자, 특수문자 포함 6자 이상이어야합니다")
	private String pw;
	
}
