package com.dev.ck.cltsh.shp.code.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.code.CltCodeDto;

@Mapper
public interface CltCodeMapper {
	int codeCnt();
	int insertCode(CltCodeDto pvo);
	CltCodeDto selectCodeOne(CltCodeDto pvo);
	List<CltCodeDto> selectCodeList(CltCodeDto pvo);
	List<CltCodeDto> selectSaleStatCdList(CltCodeDto pvo);
	List<CltCodeDto> selectOrdCdList(CltCodeDto pvo);
	List<CltCodeDto> selectUsrCdList(CltCodeDto pvo);
	List<CltCodeDto> selectAdmCdList(CltCodeDto pvo);
	List<CltCodeDto> selectOrdStatCdList(); //주문 상태 코드 리스트
	int updateCode(CltCodeDto pvo);
	int deleteCodeOne(CltCodeDto pvo);
	int deleteCodeAll();
	int dropSeq();
	int createSeq();
}