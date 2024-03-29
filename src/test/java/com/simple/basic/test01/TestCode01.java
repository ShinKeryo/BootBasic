package com.simple.basic.test01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO.Builder;
import com.simple.basic.command.SimpleVO;

@SpringBootTest //스프링부트 기반에 테스트
public class TestCode01 {
	
	@Autowired
	ApplicationContext context;
	
	@Test //이 메서드를 실행함
	public void test01() {
//		System.out.println(context);
		
//		Builder builder = BuilderVO.builder();
//		
//		BuilderVO vo = builder.name("홍길동").age(20).build();
		
		BuilderVO vo = BuilderVO.builder()
						.name("홍길동")
						.age(20)
						.build();
		
		System.out.println(vo.toString());
		
		SimpleVO vo2 =SimpleVO.builder()
						.id("asd123")
						.age(20)
						.email("asd")
						.address(null)
						.build();
		
		System.out.println(vo2.toString());
	}
}
