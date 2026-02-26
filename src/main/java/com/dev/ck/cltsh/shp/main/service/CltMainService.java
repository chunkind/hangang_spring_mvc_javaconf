package com.dev.ck.cltsh.shp.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.cate.service.CltCateMapper;
import com.dev.ck.cltsh.shp.main.CltGoodsDetailDto;

@Service
public class CltMainService {
	@Autowired private CltMainMapper mainDao;
	@Autowired private CltCateMapper cateDao;
	
	public int goodsCnt(){
		return mainDao.goodsCnt();
	};
	
	public int searchGoodsCnt(CltGoodsDetailDto pvo){
		return mainDao.searchGoodsCnt(pvo);
	};
	
	public List<CltGoodsDetailDto> selectListMainHome(CltGoodsDetailDto pvo){
		return mainDao.selectListMainHome(pvo);
	}
	
	public List<CltGoodsDetailDto> selectListMainCate(CltGoodsDetailDto pvo){
		return mainDao.selectListMainCate(pvo);
	}

	public Map<String, Object> getCategoryData(CltGoodsDetailDto pvo, String searchType, String searchCatgryCd,
			String searchCatgryCd2, List<CltCateDto> oneDepthCateList) {
		Map<String, Object> result = new HashMap<>();
		// 1. 1차 카테고리 기본값 설정 (파라미터가 없을 때)
		if (searchCatgryCd == null || "".equals(searchCatgryCd)) {
		    if (oneDepthCateList != null && !oneDepthCateList.isEmpty()) {
		        searchCatgryCd = oneDepthCateList.get(0).getCatgryCd();
		    }
		}

		// 2. 결정된 1차 카테고리로 2차 카테고리 리스트 "다시" 조회
		// 1차 카테고리(searchCatgryCd)를 부모 코드로 갖는 하위 카테고리만 가져옵니다.
		CltCateDto cateVO = new CltCateDto();
		cateVO.setUprClassCd(searchCatgryCd);
		List<CltCateDto> twoDepthCateList = cateDao.selectCateUnList(cateVO); 

		// 3. 2차 카테고리 파라미터가 없거나, 이전 1차 카테고리의 찌꺼기 값이 남아있을 때의 방어 로직
		// 새로 가져온 2차 카테고리 리스트에 현재 searchCatgryCd2가 포함되어 있는지 확인해야 합니다.
		boolean isValidTwoDepth = false;
		if (searchCatgryCd2 != null && !"".equals(searchCatgryCd2)) {
		    for (CltCateDto dto : twoDepthCateList) {
		        if (dto.getCatgryCd().equals(searchCatgryCd2)) {
		            isValidTwoDepth = true;
		            break;
		        }
		    }
		}

		// 파라미터가 비었거나 유효하지 않은 2차 카테고리라면, 방금 조회한 리스트의 첫 번째 값으로 덮어씁니다.
		if (!isValidTwoDepth) {
		    if (twoDepthCateList != null && !twoDepthCateList.isEmpty()) {
		        searchCatgryCd2 = twoDepthCateList.get(0).getCatgryCd();
		    } else {
		        // 만약 하위 카테고리가 아예 없는 1차 카테고리라면 2차 코드를 비워줍니다.
		        searchCatgryCd2 = ""; 
		    }
		}

		// 4. PVO 검색 조건 세팅
		if (!"all".equals(searchType)) {
		    pvo.setCatgryCd(searchCatgryCd);
		    pvo.setCatgryCd2(searchCatgryCd2);
		}

		// (이하 쿼리 스트링 조립 및 데이터 포장 로직은 동일합니다)
		StringBuilder queryStr = new StringBuilder();
		if (searchType != null && !"".equals(searchType)) {
		    queryStr.append("searchType=").append(searchType);
		} else {
		    queryStr.append("searchCatgryCd=").append(searchCatgryCd);
		    queryStr.append("&searchCatgryCd2=").append(searchCatgryCd2);
		}
		pvo.setQueryStr(queryStr.toString());

		result.put("twoDepthCateList", twoDepthCateList);
		result.put("searchCatgryCd", searchCatgryCd);
		result.put("searchCatgryCd2", searchCatgryCd2);

		return result;
	}
}
