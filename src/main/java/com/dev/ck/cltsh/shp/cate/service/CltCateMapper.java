package com.dev.ck.cltsh.shp.cate.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.cate.CltCateDto;

@Mapper
public interface CltCateMapper {
	int insertCate(CltCateDto pvo);
	CltCateDto selectCateOne(CltCateDto pvo);
	List<CltCateDto> selectCateAllList(CltCateDto pvo);
	List<CltCateDto> selectCateList(CltCateDto pvo);
	List<CltCateDto> selectCateUnList(CltCateDto pvo);
	int updateCate(CltCateDto pvo);
	int deleteCate(CltCateDto pvo);
	int deleteCateAll();
	int dropSeq();
	int createSeq();
}