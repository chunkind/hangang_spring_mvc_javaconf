package com.dev.ck.cltsh.shp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.main.CltGoodsDetailDto;

@Service
public class CltMainService {
	@Autowired private CltMainMapper mainDao;
	
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

}
