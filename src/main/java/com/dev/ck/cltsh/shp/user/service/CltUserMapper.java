package com.dev.ck.cltsh.shp.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.user.CltUserDto;

@Mapper
public interface CltUserMapper {
	int userCnt();
	List<CltUserDto> selectUserPagingList(CltUserDto pvo);
	int insertUser(CltUserDto pvo);
	CltUserDto selectUserOne(CltUserDto pvo);
	List<CltUserDto> admUserSearch(CltUserDto pvo);
	List<CltUserDto> selectUserList(CltUserDto pvo);
	int updateUser(CltUserDto pvo);
	int deleteUser(CltUserDto pvo);
	CltUserDto userLogin(CltUserDto pvo);
	int deleteUserAll();
	int dropSeq();
	int createSeq();
}
