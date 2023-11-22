package com.dev.ck.study.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockitoStudyTest{
	@Mock private MockTestObj obj;
	
	@Before
	public void setup(){
//		ApplicationContext context = new Application
		log.info("start...");
	}
	
	@Test
	public void mock객체_생성(){
		MockitoAnnotations.initMocks(this);
		assertNotNull(obj);
	}
	
	@Test
	public void mock객체_생성2(){
		MockTestObj obj = mock(MockTestObj.class);
		assertNotNull(obj);
	}
	
	@Test
	public void stub테스트(){
		MockTestObj obj = mock(MockTestObj.class);
		
		//stub만들기
		when(obj.getName()).thenReturn("테스터");
		
		//검증
		assertTrue(obj.getName().equals("테스터"));
	}
	
	@Test
	public void stub테스트2(){
		MockTestObj obj = mock(MockTestObj.class);
		
		List<String> rlist = new ArrayList<String>();
		rlist.add("바나나");
		rlist.add("딸기");
		rlist.add("망고");
		
		when(obj.getList()).thenReturn(rlist);
		
		assertNotNull(rlist);
		assertEquals(rlist.size(), 3);
		
	}
	
	//에러테스트 RuntimeException을 기대한다 발생안되면 에러
	@Test(expected = RuntimeException.class)
	public void 예외발생테스트(){
		MockTestObj obj = mock(MockTestObj.class);
		//에러설정 : 20을 셋하면 에러발생
		doThrow(new RuntimeException()).when(obj).setAge(eq(20));
		
		obj.setAge(10);
		obj.setAge(20); // 여기서 에러발생
		
	}
	
	/**
	 * Mock() - 모의 객체를 생성하는 역할
	 * when() - 협력객체 메소드 반환 값을 지정해주는 역할(stub)
	 * verify() - SUT안의 협력객체 메소드가 호출 되었는지 확인
	 * times() - 지정한 횟수 만큼 협력 객체 메소드가 호출 되었는지 확인
	 * never() - 호출되지 않았는지 여부 검증
	 * atLeastOnce() - 최소 한 번은 특정 메소드가 호출되었는지 확인
	 * atLeast() - 최소 지정한 횟수 만큼 호출되었는지 확인
	 * atMost() - 최대 지정한 횟수 만큼 호출되었는지 확인
	 * clear() - 스텁을 초기화 한다
	 * timeOut() - 지정된 시간 안에 호출되었는지 확인
	 */
	@Test
	public void verify테스트(){
		MockTestObj obj = mock(MockTestObj.class);
		obj.setName("참새");
	 
		// n번 호출했는지 체크
		verify(obj, times(1)).setName(any(String.class)); // success
		// 호출 안했는지 체크
		verify(obj, never()).getName(); // success
		verify(obj, never()).setName(eq("호랑이")); // success
		verify(obj, never()).setName(eq("참새")); // fail
		// 최소한 1번 이상 호출했는지 체크
		verify(obj, atLeastOnce()).setName(any(String.class)); // success
		// 2번 이하 호출 했는지 체크
		verify(obj, atMost(2)).setName(any(String.class)); // success
		// 2번 이상 호출 했는지 체크
		verify(obj, atLeast(2)).setName(any(String.class)); // fail
		// 지정된 시간(millis)안으로 메소드를 호출 했는지 체크
		verify(obj, timeout(100)).setName(any(String.class)); // success
		// 지정된 시간(millis)안으로 1번 이상 메소드를 호출 했는지 체크
		verify(obj, timeout(100).atLeast(1)).setName(any(String.class)); // success
	}
}

@Data
class MockTestObj{
	private String name;
	private int age;
	private List<String> list;
}