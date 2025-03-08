package com.dev.ck.cltsh.shp.opts.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.opts.CltOptsDto;

@Mapper
public interface CltOptsMapper {
	CltOptsDto selectOptsOne(CltOptsDto pvo);
	List<CltOptsDto> selectOptsList(CltOptsDto pvo);
	List<CltOptsDto> selectAdmOptsList(CltOptsDto pvo);
	int insertOpts(CltOptsDto pvo);
	int updateOpts(CltOptsDto pvo);
	int updatePartOpts(CltOptsDto pvo);
	int deleteOptsOne(CltOptsDto pvo);
	int deleteOptsAll();
}
