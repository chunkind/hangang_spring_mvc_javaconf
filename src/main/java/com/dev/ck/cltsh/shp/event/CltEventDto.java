package com.dev.ck.cltsh.shp.event;

import org.springframework.web.multipart.MultipartFile;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltEventDto extends PagingVO{
	private long eventInfoSeq;/*이벤트 시퀀스*/
	private long eventNum;/*이벤트 코드*/
	private String eventName;/*이벤트 이름*/
	private String imgPath;/*이미지경로*/
	private String imgNm;/*이미지이름*/
	private String eventRegistDate;/*이벤트 등록 날짜*/
	private String eventEndDate;/*이벤트 만료 날짜*/
	private MultipartFile file1;
	
	public CltEventDto(String eventName, String imgPath, String imgNm, String eventEndDate) {
		this.eventName = eventName;
		this.imgPath = imgPath;
		this.imgNm = imgNm;
		this.eventEndDate = eventEndDate;
	}
}