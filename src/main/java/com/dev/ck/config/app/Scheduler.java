package com.dev.ck.config.app;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Scheduler {
	
	//초 분 시 일 월 요일
//	@Scheduled(cron = "10 * * * * *")
	//1초마다 실행
	@Scheduled(fixedDelay = 10000)
	public void test() {
		log.error("내가호출된다." + this.hashCode());
	}
}