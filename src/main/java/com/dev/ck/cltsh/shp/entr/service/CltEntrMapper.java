package com.dev.ck.cltsh.shp.entr.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.entr.CltEntrDto;

@Mapper
public interface CltEntrMapper {
	int entrCnt();
	int insertEntr(CltEntrDto pvo);
	CltEntrDto selectEntrOne(CltEntrDto pvo);
	List<CltEntrDto> selectEntrList(CltEntrDto pvo);
	List<CltEntrDto> selectIdEntrList(CltEntrDto pvo);
	int updateEntr(CltEntrDto pvo);
	int deleteEntr(CltEntrDto pvo);
	int deleteEntrAll();
	int dropSeq();
	int createSeq();
}
