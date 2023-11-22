package com.dev.ck.study.mockito;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class MockitoJUnitStudyTest{
	@Mock private MockTestObj obj;
	@Spy private StubTextObj stubObj;
	
	@Before
	public void setup(){
//		ApplicationContext context = new Application
		log.info("start...");
	}
	
	@Test
	public void mock객체_생성(){
		assertNotNull(obj);
	}
	
	
}

@Data
class StubTextObj{
	private String name;
	private int age;
	
	public void addAge(int age){
		System.out.println("축하합니다 나이먹었네요~");
		this.age += age;
	}
	
}