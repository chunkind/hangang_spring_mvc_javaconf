package com.dev.ck.cm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CommonVO {
	private long cmCodeSeq;// 시퀀스
	private String cdName;// 코드이름
	private String cdValue;// 코드값
	private String cdType;// 분류
	private String useYn;// 사용 유무
	private String regUserId;// 등록 회원 아이디
	private Date regDate;// 등록 일자
	private String updUserId;// 수정 회원 아이디
	private Date updDate;// 수정 일자

	@Builder
	public CommonVO(long cmCodeSeq, String cdName, String cdValue, String cdType, String useYn, String regUserId, Date regDate, String updUserId, Date updDate) {
		super();
		this.cmCodeSeq = cmCodeSeq;
		this.cdName = cdName;
		this.cdValue = cdValue;
		this.cdType = cdType;
		this.useYn = useYn;
		this.regUserId = regUserId;
		this.regDate = regDate;
		this.updUserId = updUserId;
		this.updDate = updDate;
	}
}