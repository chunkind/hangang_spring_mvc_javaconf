package com.dev.ck.cltsh.shp.goods.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.goods.CltGoodsDto;

@Mapper
public interface CltGoodsMapper {
	int goodsCnt();
	List<CltGoodsDto> selectGoodsPagingList(CltGoodsDto pvo);
	int insertGoods(CltGoodsDto pvo);
	CltGoodsDto selectGoodsOne(CltGoodsDto pvo);
	List<CltGoodsDto> selectMypgGoodsList(CltGoodsDto pvo);
	CltGoodsDto selectMypgGoodsOne(CltGoodsDto pvo);
	CltGoodsDto selectGoodsDetail(String seq);
	List<CltGoodsDto> selectGoodsList(CltGoodsDto pvo);
	int updateGoods(CltGoodsDto pvo);
	int deleteGoods(CltGoodsDto pvo);
	int deleteGoodsAll();
	int dropSeq();
	int createSeq();
}