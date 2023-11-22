package com.dev.ck.cltsh.cmm.util;

import com.dev.ck.cltsh.CltConfig;
import com.dev.ck.cltsh.cmm.PagingVO;

public class PagingUtil {
	public static void getPagingKeys(PagingVO pvo) {
		int totalCnt = pvo.getTotalCnt();
		String paramPage = pvo.getParamPage();
		String path = pvo.getPath();
		
		if(totalCnt == 0) {
			return;
		}
		
		int pagePerRows = CltConfig.PAGE_PER_ROWS;
		int page = 0;
		if(null == paramPage || "".equals(paramPage)) {
			page = 1;
		}else {
			page = Integer.parseInt(paramPage);
		}
		
		int x = 0;
	
		if (page > pagePerRows) {
			x = (int) (page / pagePerRows);
			if (page % 10 == 0 && page > 10) { // page가 10보다 크고 10의 배수일 경우 -1
				x--;
			}
		}
		
		pvo.setStartIdx((page-1) * 10); // x * 10
		pvo.setPagePerRows(((page-1) + 1) * pagePerRows); //(x + 1) * 10
	
		int maxPage = totalCnt / pagePerRows + 1; // 페이지 갯수
		
		if(totalCnt % pagePerRows == 0) {
			maxPage--;
		}
		
		totalCnt = maxPage;
		
		int minPage = 1;
		boolean isNext = false;
	
		if (maxPage > pagePerRows) {
			maxPage = pagePerRows + (pagePerRows * x);
			minPage = (pagePerRows * x) + 1;
			isNext = true;
		} else if (maxPage == pagePerRows) {
			maxPage = pagePerRows;
		}
		
		pvo.setPath(path);
		pvo.setPage(page);
		pvo.setNext(isNext);
		pvo.setMinPage(minPage);
		pvo.setMaxPage(maxPage);
		pvo.setTotalCnt(totalCnt);
		pvo.setParamPage(paramPage);
		
		String pagingHtml = getPagingHtml(pvo);
		pvo.setHtml(pagingHtml);
	}
	
	public static String getPagingHtml(PagingVO rvo) {
		String path = rvo.getPath(); 
		int page = rvo.getPage();
		boolean isNext = rvo.isNext();
		int minPage = rvo.getMinPage();
		int maxPage = rvo.getMaxPage();
		int totalCnt = rvo.getTotalCnt();
		String queryStr = rvo.getQueryStr();
		
		String html = "";
		if(null != queryStr && !"".equals(queryStr)) {
			html += "<div class=\"pageNav\">";
			html += "	<a href='" + path + "?" + queryStr + "&page=1'><i class=\"fa\">◀</i></a> <!-- 맨 앞 페이지로 -->";
			
			if(page == 1 && isNext == true) {
				html += "	<a href='" + path + "?" + queryStr + "&page=1'><i class=\"fa\">◀</i></a>";
			}else if(isNext == true) {
				html += "	<a href='" + path + "?" + queryStr + "&page="+(minPage - 10)+"'><i class=\"fa\">◀</i></a>";
			}
			
			for(int i=1; i<=maxPage; i++) {
				html += "	<a ";
				if(page == i) {
					html += "class=\"active\"";
				}
				html += " href='" + path + "?" + queryStr + "&page="+i+"'><i class=\"fa\">"+i+"</i></a>";
			}
			if(isNext == true) {
				html += "	<a href='" + path + "?" + queryStr + "&page="+(maxPage + 1)+"'><i class=\"fa\">▶</i></a>";
			}
			html += "	<a href='" + path + "?" + queryStr + "&page="+totalCnt+"'><i class=\"fa\">▶</i></a> <!-- 맨 뒤 페이지로 -->";
			html += "</div>";
		}else {
			html += "<div class=\"pageNav\">";
			html += "	<a href='" + path + "?page=1'><i class=\"fa\">◀</i></a> <!-- 맨 앞 페이지로 -->";
			
			if(page == 1 && isNext == true) {
				html += "	<a href='" + path + "?page=1'><i class=\"fa\">◀</i></a>";
			}else if(isNext == true) {
				html += "	<a href='" + path + "?page="+(minPage - 10)+"'><i class=\"fa\">◀</i></a>";
			}
			
			for(int i=1; i<=maxPage; i++) {
				html += "	<a ";
				if(page == i) {
					html += "class=\"active\"";
				}
				html += " href='" + path + "?page="+i+"'><i class=\"fa\">"+i+"</i></a>";
			}
			if(isNext == true) {
				html += "	<a href='" + path + "?page="+(maxPage + 1)+"'><i class=\"fa\">▶</i></a>";
			}
			html += "	<a href='" + path + "?page="+totalCnt+"'><i class=\"fa\">▶</i></a> <!-- 맨 뒤 페이지로 -->";
			html += "</div>";
		}
		
		return html;
	}
}