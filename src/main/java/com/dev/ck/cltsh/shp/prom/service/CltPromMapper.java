package com.dev.ck.cltsh.shp.prom.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.prom.CltPromDto;

@Mapper
public interface CltPromMapper {
	int promCnt();
	int insertProm(CltPromDto pvo);
	CltPromDto selectPromOne(CltPromDto pvo);
	List<CltPromDto> selectPromList(CltPromDto pvo);
	int updateProm(CltPromDto pvo);
	int deleteProm(CltPromDto pvo);
}
