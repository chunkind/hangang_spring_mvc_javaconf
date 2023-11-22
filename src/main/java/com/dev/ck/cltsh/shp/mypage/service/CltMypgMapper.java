package com.dev.ck.cltsh.shp.mypage.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.mypage.CltMypgDto;

@Mapper
public interface CltMypgMapper {
	int ordCnt();
	List<CltMypgDto> selectMypgList(CltMypgDto pvo);
}