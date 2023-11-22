package com.dev.ck.cltsh.shp.main.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.main.CltGoodsDetailDto;

@Mapper
public interface CltMainMapper {
	int goodsCnt();
	int searchGoodsCnt(CltGoodsDetailDto pvo);
	List<CltGoodsDetailDto> selectListMainHome(CltGoodsDetailDto pvo);
	List<CltGoodsDetailDto> selectListMainCate(CltGoodsDetailDto pvo);
}