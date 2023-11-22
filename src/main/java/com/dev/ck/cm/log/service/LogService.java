package com.dev.ck.cm.log.service;

import com.dev.ck.cm.log.LogVO;

/**
 * @User : KJS
 * @date : 2018. 5. 12.
 */
public interface LogService {
	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 삽입.
	 */
	public int insertLogOne(LogVO pvo);

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 조회.
	 */
	public LogVO selectLogOne(LogVO pvo);

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 삭제.
	 */
	public int deleteLogOne(LogVO pvo);

	/**
	 * @User : KJS
	 * @date : 2022. 8. 21.
	 */
	public int deleteLogOneByIp(LogVO pvo);

	/**
	 * @User : KJS
	 * @date : 2018. 5. 12.
	 * 로그 데이터 수정.
	 */
	public int updateLogOne(LogVO pvo);

}
