package com.dev.ck.cltsh.shp.dress.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.dress.CltDressDto;

@Mapper
public interface CltDressMapper {
	int insertDress(CltDressDto pvo);
	CltDressDto selectDressOne(CltDressDto pvo);
	List<CltDressDto> selectDressList(CltDressDto pvo);
	int updateDress(CltDressDto pvo);
	int deleteDress(CltDressDto pvo);
	List<CltDressDto> goodsDtlDressList(CltDressDto pvo);
	List<CltDressDto> selectWriteSaleRvw(CltDressDto pvo);
}