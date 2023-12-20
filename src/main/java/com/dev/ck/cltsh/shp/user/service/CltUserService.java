package com.dev.ck.cltsh.shp.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.entr.CltEntrDto;
import com.dev.ck.cltsh.shp.entr.service.CltEntrMapper;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Service
public class CltUserService {
	@Autowired private CltUserMapper userDao;
	@Autowired private CltEntrMapper entrDao;
	
	public CltUserDto parameterSetting(HttpServletRequest req) {
		CltUserDto pvo = new CltUserDto();
		// 파라미터 셋팅
		long usrBaseSeq = req.getParameter("usrBaseSeq") == null? 0L : Long.parseLong(req.getParameter("usrBaseSeq"));
		String usrId = req.getParameter("usrId");
		String usrNm = req.getParameter("usrNm");
		String passWd = req.getParameter("passWd");
		String usrBirth = req.getParameter("usrBirth");
		String emailAddr = req.getParameter("emailAddr");
		String cellNo = req.getParameter("cellNo");
		String landAddrBase = req.getParameter("landAddrBase");
		String landAddrDtl = req.getParameter("landAddrDtl");
		String landPostNo = req.getParameter("landPostNo");
		String loadAddrBase = req.getParameter("loadAddrBase");
		String loadAddrDtl = req.getParameter("loadAddrDtl");
		String loadPostNo = req.getParameter("loadPostNo");
		String passWdChgDate = req.getParameter("passWdChgDate");
		String lockYn = req.getParameter("lockYn");
		String rgstId = req.getParameter("rgstId");
		String rgstDate = req.getParameter("rgstDate");
		String updtId = req.getParameter("updtId");
		String updtDate = req.getParameter("updtDate");
		String useYn = req.getParameter("useYn");
		
		String userSequence = req.getParameter("userSequence") == null ? "" : req.getParameter("userSequence");

		String searchType = req.getParameter("searchType");
		String searchText = req.getParameter("searchText");
		String searchGradeUpperType = req.getParameter("searchGradeUpperType");
		String searchGradeUnderType = req.getParameter("searchGradeUnderType");
		String searchStartRgstDate = req.getParameter("searchStartRgstDate");
		String searchEndRgstDate = req.getParameter("searchEndRgstDate");

		pvo.setUsrBaseSeq(usrBaseSeq);
		pvo.setUsrId(usrId);
		pvo.setUsrNm(usrNm);
		pvo.setPassWd(passWd);
		pvo.setUsrBirth(usrBirth);
		pvo.setEmailAddr(emailAddr);
		pvo.setCellNo(cellNo);
		pvo.setLandAddrBase(landAddrBase);
		pvo.setLandAddrDtl(landAddrDtl);
		pvo.setLandPostNo(landPostNo);
		pvo.setLoadAddrBase(loadAddrBase);
		pvo.setLoadAddrDtl(loadAddrDtl);
		pvo.setLoadPostNo(loadPostNo);
		pvo.setPassWdChgDate(passWdChgDate);
		pvo.setLockYn(lockYn);
		pvo.setRgstId(rgstId);
		pvo.setRgstDate(rgstDate);
		pvo.setUpdtId(updtId);
		pvo.setUpdtDate(updtDate);
		pvo.setUseYn(useYn);
		pvo.setSearchType(searchType);
		pvo.setSearchText(searchText);
		pvo.setSearchGradeUpperType(searchGradeUpperType);
		pvo.setSearchGradeUnderType(searchGradeUnderType);
		pvo.setSearchStartRgstDate(searchStartRgstDate);
		pvo.setSearchEndRgstDate(searchEndRgstDate);
		pvo.setUserSequence(userSequence);
		
		return pvo;
	}
	
	public int userCnt() {
		return userDao.userCnt();
	}
	
	public List<CltUserDto> selectUserPagingList(CltUserDto pvo){
		return userDao.selectUserPagingList(pvo);
	}
	
	public int insertUser(CltUserDto pvo) {
		return userDao.insertUser(pvo);
	}
	
	public CltUserDto selectUserOne(CltUserDto pvo) {
		return userDao.selectUserOne(pvo);
	}
	
	public List<CltUserDto> admUserSearch(CltUserDto pvo){
		return userDao.admUserSearch(pvo);
	}

	public List<CltUserDto> selectUserList(CltUserDto pvo){
		return userDao.selectUserList(pvo);
	}
	
	public int updateUser(CltUserDto pvo) {
		return userDao.updateUser(pvo);
	}
	
	public int deleteUser(CltUserDto pvo) {
		return userDao.deleteUser(pvo);
	}
	
	public CltUserDto userLogin(CltUserDto pvo) {
		CltEntrDto entrPvo = new CltEntrDto();
		entrPvo.setUsrId(pvo.getUsrId());
		
		CltUserDto sessionVO = userDao.userLogin(pvo);
		List<CltEntrDto> entrList = null;
		if(null != sessionVO) {
			entrList = entrDao.selectEntrList(entrPvo);
			sessionVO.setEntrList(entrList);
		}
		return userDao.userLogin(pvo);
	}
	
	public CltUserDto kakaoLogin(String email) {
		return userDao.kakaoLogin(email);
	}
	
	public int deleteUserAll() {
		return userDao.deleteUserAll();
	}
	
	public int dropSeq(){
		return userDao.dropSeq();
	}
	
	public int createSeq() {
		return userDao.createSeq();
	}
}
