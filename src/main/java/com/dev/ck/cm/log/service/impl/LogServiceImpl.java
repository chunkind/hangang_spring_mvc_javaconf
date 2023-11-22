package com.dev.ck.cm.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cm.log.LogVO;
import com.dev.ck.cm.log.service.LogService;

@Service
public class LogServiceImpl implements LogService{
	@Autowired private LogMapper logMapper;
	
	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 삽입.
	 */
	@Override
	public int insertLogOne(LogVO pvo) {
		return logMapper.insertLogOne(pvo);
	}

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 조회.
	 */
	@Override
	public LogVO selectLogOne(LogVO pvo) {
		return logMapper.selectLogOne(pvo);
	}

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 삭제.
	 */
	@Override
	public int deleteLogOne(LogVO pvo) {
		return logMapper.deleteLogOne(pvo);
	}

	/**
	 * @User : KJS
	 * @date : 2022. 8. 21.
	 */
	@Override
	public int deleteLogOneByIp(LogVO pvo) {
		return logMapper.deleteLogOneByIp(pvo);
	}

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 수정.
	 */
	@Override
	public int updateLogOne(LogVO pvo) {
		return logMapper.updateLogOne(pvo);
	} 
}
