package com.dev.ck.ackwd.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Scheduler {
	
	//초 분 시 일 월 요일
	@Scheduled(cron = "0 0 0 * * *")
	public void procRankApi() {
		log.info("=procRankApi start====================================================");
		log.info("=procRankApi end====================================================");
	}
	
	//1초마다 실행
//	@Scheduled(fixedDelay = 10000)
	//초 분 시 일 월 요일
	@Scheduled(cron = "0 0 1,7,11 * * *")
	public void procNewsApi() {
		log.info("=procNewsApi start====================================================");
		log.info("=procNewsApi end====================================================");
	}
}