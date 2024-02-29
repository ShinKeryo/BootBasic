package com.simple.basic.command;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidVO {
	
	/*
	 @Notnull - null제외 (String, Integer, Long등등에 적용)
	 @NotEmpty - null제외, 공백 제외 (String, Map, Arrays등등에 적용)
	 @NotBlank - null제외, 공백 제외, 화이트스페이스 제외 (String에 적용)
	 	
	 @Pattern - 정규표현식에 맞는 문자열을 정할 수 있다
	 @Email - 이메일 형식, blank 허용
	 @Max - 최대값
	 @Min - 최소값 등등..
	 */
	
	
	//유효성 검사를 진행할 멤버변수는 wrapper형으로 작성합니다(형변환의 문제)
	
	@NotBlank(message = "이름은 필수 입니다")
	private String name;
	@NotNull(message = "급여는 필수 입니다")
	private Integer salary;
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "000-0000-0000 형식이 아닙니다")
	private String phone;
	@NotBlank(message = "이메일은 필수 입니다")
	@Email(message = "이메일 형식이어야 합니다") //blank통과
	private String email;
	
	
	
}
