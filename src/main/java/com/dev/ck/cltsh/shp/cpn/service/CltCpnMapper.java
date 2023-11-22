package com.dev.ck.cltsh.shp.cpn.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.cpn.CltCpnDto;

@Mapper
public interface CltCpnMapper {
	int cpnCnt();
	int insertCpn(CltCpnDto pvo);
	CltCpnDto selectCpnOne(CltCpnDto pvo);
	List<CltCpnDto> selectCpnList(CltCpnDto pvo);
	int updateCpn(CltCpnDto pvo);
	int deleteCpn(CltCpnDto pvo);
}