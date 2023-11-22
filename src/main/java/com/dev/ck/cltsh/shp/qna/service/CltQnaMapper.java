package com.dev.ck.cltsh.shp.qna.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.qna.CltQnaDto;

@Mapper
public interface CltQnaMapper {
	int qnaCnt();
	int admQnaCnt();
	List<CltQnaDto> qnaPageing(CltQnaDto pvo);
	int insertQna(CltQnaDto pvo);
	CltQnaDto selectQnaOne(CltQnaDto pvo);
	List<CltQnaDto> selectQnaList(CltQnaDto pvo);
	int updateQna(CltQnaDto pvo);
	int deleteQna(CltQnaDto pvo);
	List<CltQnaDto> searchIdQnaList(CltQnaDto pvo);
	List<CltQnaDto> searchGoodsCdQna(CltQnaDto pvo);
	List<CltQnaDto> unansweredQnaList(CltQnaDto pvo);
	int updateAnswerQna(CltQnaDto pvo);
}