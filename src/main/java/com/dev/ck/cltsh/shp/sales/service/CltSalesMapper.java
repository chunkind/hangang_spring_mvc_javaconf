package com.dev.ck.cltsh.shp.sales.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.sales.CltSalesDto;

@Mapper
public interface CltSalesMapper {
	int insertSales(CltSalesDto pvo);
	int deleteSales(CltSalesDto pvo);
	int deleteSalesAll();
	int updateSales(CltSalesDto pvo);
	List<CltSalesDto> entrSalesList(CltSalesDto pvo);
	List<CltSalesDto> selectSalesList(CltSalesDto pvo);
	CltSalesDto selectSalesOne(CltSalesDto pvo);
	int dropSeq();
	int createSeq();
}
