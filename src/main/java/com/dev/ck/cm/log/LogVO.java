package com.dev.ck.cm.log;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @User : KJS
 * @date : 2018. 5. 12.
 */
@Data
@NoArgsConstructor
public class LogVO {
	private long linkLogSeq;
	private String userId;
	private String userIp;
	private String url;
	private String queryStr;
	private String memo;
	private Date regDate;
	private Date updDate;
	private String regUserId;
	private String updUserId;
	
	@Builder
	public LogVO(long linkLogSeq, String userId, String userIp, String url, String memo, Date regDate, Date updDate,
			String regUserId, String updUserId) {
		super();
		this.linkLogSeq = linkLogSeq;
		this.userId = userId;
		this.userIp = userIp;
		this.url = url;
		this.memo = memo;
		this.regDate = regDate;
		this.updDate = updDate;
		this.regUserId = regUserId;
		this.updUserId = updUserId;
	}
}