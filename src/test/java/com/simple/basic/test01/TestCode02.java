package com.simple.basic.test01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCode02 {

		@Autowired
		TestMapper testMapper;
	
	@Test
	public void test01() {
		System.out.println("현재 로컬 날짜 및 시간 : "+testMapper.getTime());
	}
	
}
