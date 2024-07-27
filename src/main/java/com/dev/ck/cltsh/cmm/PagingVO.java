package com.dev.ck.cltsh.cmm;

import lombok.Data;

@Data
public class PagingVO {
	private boolean isNext;
	private int maxPage;
	private int minPage;
	private int page;
	private int totalCnt;
	private int pagePerRows = 10;
	private int startIdx = 1;
	private String html;
	private String path;
	private String paramPage;
	private String queryStr;
	
	@Override
	public String toString() {
		return html;
	}
}