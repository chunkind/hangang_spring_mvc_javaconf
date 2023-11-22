package com.dev.ck.cltsh.shp.event.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.event.CltEventDto;

@Mapper
public interface CltEventMapper {
	int eventCnt();
	List<CltEventDto> selectEventPagingList(CltEventDto pvo);
	int insertEvent(CltEventDto pvo);
	CltEventDto selectEventOne(CltEventDto pvo);
	List<CltEventDto> selectEventList(CltEventDto pvo);
	int updateEvent(CltEventDto pvo);
	int deleteEvent(CltEventDto pvo);
	int dropSeq();
	int createSeq();
	int deleteEventAll();
}