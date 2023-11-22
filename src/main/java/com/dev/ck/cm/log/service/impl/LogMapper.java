package com.dev.ck.cm.log.service.impl;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cm.log.LogVO;

@Mapper
public interface LogMapper {
	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 삽입.
	 */
	int insertLogOne(LogVO pvo);

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 조회.
	 */
	LogVO selectLogOne(LogVO pvo);

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 삭제.
	 */
	int deleteLogOne(LogVO pvo);

	/**
	 * @User : KJS
	 * @date : 2022. 8. 21.
	 */
	int deleteLogOneByIp(LogVO pvo);

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 수정.
	 */
	int updateLogOne(LogVO pvo);
}
