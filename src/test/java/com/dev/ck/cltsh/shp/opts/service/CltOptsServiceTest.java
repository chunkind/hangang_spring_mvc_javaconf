package com.dev.ck.cltsh.shp.opts.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dev.ck.TestApp;
import com.dev.ck.cltsh.shp.opts.CltOptsDto;

public class CltOptsServiceTest extends TestApp{
	
	@Autowired private CltOptsService optsService;
	
	/*
	 * 아이템 코드값을 그룹핑하여 리스트 조회
	 * return 
	 * {0002=[
	 * 		 {goodsCd=282, optsSeq=34, optsNm=색상, optsCd=0002, optsVal=검정색}
	 * 		,{goodsCd=282, optsSeq=35, optsNm=색상, optsCd=0002, optsVal=노란색}
	 * 		,{goodsCd=282, optsSeq=36, optsNm=색상, optsCd=0002, optsVal=파란색}
	 * ],0001=[
	 * 		 {goodsCd=282, optsSeq=28, optsNm=사이즈, optsCd=0001, optsVal=2XL}
	 * 		,{goodsCd=282, optsSeq=29, optsNm=사이즈, optsCd=0001, optsVal=XL}
	 * 		,{goodsCd=282, optsSeq=30, optsNm=사이즈, optsCd=0001, optsVal=L}
	 * 		,{goodsCd=282, optsSeq=31, optsNm=사이즈, optsCd=0001, optsVal=M}
	 * 		,{goodsCd=282, optsSeq=32, optsNm=사이즈, optsCd=0001, optsVal=S}
	 * ]}
	 */
	@Test
	public void 아이템_코드값그룹_리스() {
		// 상품정보
		int goodsCd = 282;
		
		// 상품정보: 옵션
		CltOptsDto ovo = new CltOptsDto();
		ovo.setGoodsCd(goodsCd);
		List<CltOptsDto> optList = optsService.selectAdmOptsList(ovo);

		Map<String, List<Map<String, Object>>> groupedOptions = new HashMap<>();
		for (CltOptsDto option : optList) {
		    
		    if (!groupedOptions.containsKey(option.getOptsCd())) {
		        groupedOptions.put(option.getOptsCd(), new ArrayList<Map<String, Object>>());
		    }
		    groupedOptions.get(option.getOptsCd()).add(option.toMap());
		}
		System.out.println(groupedOptions);
	}

}
