package com.dev.ck.cltsh.shp.order.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.order.CltOrderDto;

@Mapper
public interface CltOrderMapper {
	int ordCnt();
	int insertOrd(CltOrderDto pvo); //주문 기본
	CltOrderDto selectOrdOne(CltOrderDto pvo);
	List<CltOrderDto> selectOrdList(CltOrderDto pvo);
	int updateOrd(CltOrderDto pvo);
	int deleteOrd(CltOrderDto pvo);
	int insertOrdDtl(CltOrderDto pvo); //주문 상세
	CltOrderDto selectOrdDtlOne(CltOrderDto pvo);
	List<CltOrderDto> selectOrdDtlList(CltOrderDto pvo);
	int updateOrdDtl(CltOrderDto pvo);
	int deleteOrdDtl(CltOrderDto pvo);
	int admOrdStateChange(CltOrderDto pvo); //주문 상태 변경
	List<CltOrderDto> searchIdOrdList(CltOrderDto pvo);
	CltOrderDto searchOrdNoList(CltOrderDto pvo);
	List<CltOrderDto> searchOrdDtlGoods(CltOrderDto pvo);
	List<CltOrderDto> selectOrdBaseList(CltOrderDto pvo); //매출관리 통계
	int insertBasket(CltOrderDto pvo); //장바구니
	int deleteBasket(CltOrderDto pvo);
	int updateBasket(CltOrderDto pvo);
	List<CltOrderDto> selectBasketList(CltOrderDto pvo);
	CltOrderDto ordBasketSelect(CltOrderDto pvo);
	List<CltOrderDto> selectCartOrdDtlList(CltOrderDto pvo);
}