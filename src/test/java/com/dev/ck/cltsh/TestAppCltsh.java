package com.dev.ck.cltsh;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dev.ck.TestApp;
import com.dev.ck.cltsh.cmm.util.DateUtils;
import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.cate.service.CltCateMapper;
import com.dev.ck.cltsh.shp.code.CltCodeDto;
import com.dev.ck.cltsh.shp.code.service.CltCodeMapper;
import com.dev.ck.cltsh.shp.entr.CltEntrDto;
import com.dev.ck.cltsh.shp.entr.service.CltEntrMapper;
import com.dev.ck.cltsh.shp.event.CltEventDto;
import com.dev.ck.cltsh.shp.event.service.CltEventMapper;
import com.dev.ck.cltsh.shp.goods.CltGoodsDto;
import com.dev.ck.cltsh.shp.goods.service.CltGoodsMapper;
import com.dev.ck.cltsh.shp.sales.CltSalesDto;
import com.dev.ck.cltsh.shp.sales.service.CltSalesMapper;
import com.dev.ck.cltsh.shp.user.CltUserDto;
import com.dev.ck.cltsh.shp.user.service.CltUserMapper;

public class TestAppCltsh extends TestApp{
	@Autowired private CltEventMapper cltEventMapper;
	@Autowired private CltCodeMapper cltCodeMapper;
	@Autowired private CltCateMapper cltCateMapper;
	@Autowired private CltUserMapper cltUserMapper;
	@Autowired private CltEntrMapper cltEntrMapper;
	@Autowired private CltGoodsMapper cltGoodsMapper;
	@Autowired private CltSalesMapper cltSalesMapper;
	
	@Test
	public void 이벤트_배너_데이터_셋팅() {
		CltEventDto[] targets = getEventDataArr();
		
		cltEventMapper.deleteEventAll();
		
		for(int i=0; i<targets.length; i++) {
			cltEventMapper.insertEvent(targets[i]);
		}
	}

	@Test
	public void 기본_코드_데이터_셋팅() {
		CltCodeDto[] targets = getCodeDataArr();
		
		cltCodeMapper.deleteCodeAll();
		
		for(int i=0; i<targets.length; i++) {
			cltCodeMapper.insertCode(targets[i]);
		}
	}
	
	@Test
	public void 상품_카테고리_데이터_셋팅() {
		CltCateDto[] targets = getCateDataArr();
		
		cltCateMapper.deleteCateAll();
		
		for(int i=0; i<targets.length; i++) {
			cltCateMapper.insertCate(targets[i]);
		}
	}
	
	@Test
	public void 유저_데이터_셋팅() {
		CltUserDto[] targets = getUserDataArr();
		
		cltUserMapper.deleteUserAll();
		
		for(int i=0; i<targets.length; i++) {
			cltUserMapper.insertUser(targets[i]);
		}
	}
	
	@Test
	public void 업체_데이터_셋팅() {
		CltEntrDto[] targets = getEntrDataArr();
		
		cltEntrMapper.deleteEntrAll();
		
		for(int i=0; i<targets.length; i++) {
			cltEntrMapper.insertEntr(targets[i]);
		}
	}
	
	@Test
	public void 상품_데이터_셋팅() {
		CltGoodsDto[] targets = getGoodsDataArr();
		
		cltGoodsMapper.deleteGoodsAll();
		
		for(int i=0; i<targets.length; i++) {
			cltGoodsMapper.insertGoods(targets[i]);
		}
	}
	
	@Test
	public void 판매_게시판_데이터_셋팅() {
		CltSalesDto[] targets = getSalesDataArr();
		
		cltSalesMapper.deleteSalesAll();
		
		for(int i=0; i<targets.length; i++) {
			cltSalesMapper.insertSales(targets[i]);
		}
	}
	
	
	public CltEventDto[] getEventDataArr() {
		CltEventDto[] bannerList = {
			 new CltEventDto("이벤트1", "/img/cltsh/banner/", "banner_01.png", "9999-12-31")
			,new CltEventDto("이벤트2", "/img/cltsh/banner/", "banner_02.png", "9999-12-31")
			,new CltEventDto("이벤트3", "/img/cltsh/banner/", "banner_03.png", "9999-12-31")
		};
		return bannerList;
	}
	
	public CltCodeDto[] getCodeDataArr() {
		CltCodeDto[] codeList = {
			  new CltCodeDto("판매중","01","판매상태","STD001",1,"Y","system","system")
			, new CltCodeDto("판매중지","02","판매상태","STD001",2,"Y","system","system")
			, new CltCodeDto("품절","03","판매상태","STD001",3,"Y","system","system")
			, new CltCodeDto("재고부족","04","판매상태","STD001",4,"Y","system","system")
			, new CltCodeDto("일반회원","01","회원등급","STD002",1,"Y","system","system")
			, new CltCodeDto("VIP","02","회원등급","STD002",2,"Y","system","system")
			, new CltCodeDto("VVIP","03","회원등급","STD002",3,"Y","system","system")
			, new CltCodeDto("업체관리자","01","관리자등급","STD003",1,"Y","system","system")
			, new CltCodeDto("운영관리자","02","관리자등급","STD003",2,"Y","system","system")
			, new CltCodeDto("슈퍼관리자","03","관리자등급","STD003",3,"Y","system","system")
			, new CltCodeDto("결제대기","01","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("결제완료","02","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("상품준비중","03","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("배송중","04","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("배송완료","05","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("수취완료","06","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("반품신청","07","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("반품완료","08","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("취소신청","09","주문상태","STD004",1,"Y","system","system")
			, new CltCodeDto("취소완료","10","주문상태","STD004",1,"Y","system","system")

		};
		return codeList;
	}
	
	public CltCateDto[] getCateDataArr() {
		CltCateDto[] cateList = {
			 new CltCateDto("CT01", 0, "가방", "가방", "1", "CT01", "system", "system", "Y")
			,new CltCateDto("CT0101", 0, "백팩", "백팩", "2", "CT01", "system", "system", "Y")
			,new CltCateDto("CT02", 0, "하의", "하의", "1", "CT02", "system", "system", "Y")
			,new CltCateDto("CT0201", 0, "청바지", "청바지", "2", "CT02", "system", "system", "Y")
			,new CltCateDto("CT0202", 0, "래깅스", "래깅스", "2", "CT02", "system", "system", "Y")
			,new CltCateDto("CT0203", 0, "긴바지", "긴바지", "2", "CT02", "system", "system", "Y")
			,new CltCateDto("CT0204", 0, "반바지", "반바지", "2", "CT02", "system", "system", "Y")
			,new CltCateDto("CT03", 0, "원피스", "원피스", "1", "CT03", "system", "system", "Y")
			,new CltCateDto("CT0301", 0, "원피스", "원피스", "2", "CT03", "system", "system", "Y")
			,new CltCateDto("CT04", 0, "아우터", "아우터", "1", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0401", 0, "블레이저", "블레이저", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0402", 0, "가디건", "가디건", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0403", 0, "코트", "코트", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0404", 0, "자켓", "자켓", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0405", 0, "점퍼", "점퍼", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0406", 0, "롱패딩", "롱패딩", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0407", 0, "숏패딩", "숏패딩", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0408", 0, "무스탕", "무스탕", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT0409", 0, "집업", "집업", "2", "CT04", "system", "system", "Y")
			,new CltCateDto("CT05", 0, "신발", "신발", "1", "CT05", "system", "system", "Y")
			,new CltCateDto("CT0501", 0, "런닝화", "런닝화", "2", "CT05", "system", "system", "Y")
			,new CltCateDto("CT0502", 0, "스니커즈", "스니커즈", "2", "CT05", "system", "system", "Y")
			,new CltCateDto("CT06", 0, "스커트", "스커트", "1", "CT06", "system", "system", "Y")
			,new CltCateDto("CT0601", 0, "숏스커트", "숏스커트", "2", "CT06", "system", "system", "Y")
			,new CltCateDto("CT0602", 0, "롱스커트", "롱스커트", "2", "CT06", "system", "system", "Y")
			,new CltCateDto("CT07", 0, "상의", "상의", "1", "CT07", "system", "system", "Y")
			,new CltCateDto("CT0701", 0, "니트", "니트", "2", "CT07", "system", "system", "Y")
			,new CltCateDto("CT0702", 0, "긴팔", "긴팔", "2", "CT07", "system", "system", "Y")
			,new CltCateDto("CT0703", 0, "맨투맨", "맨투맨", "2", "CT07", "system", "system", "Y")
			,new CltCateDto("CT0704", 0, "목티", "목티", "2", "CT07", "system", "system", "Y")
			,new CltCateDto("CT0705", 0, "셔츠", "셔츠", "2", "CT07", "system", "system", "Y")
			,new CltCateDto("CT0706", 0, "반팔", "반팔", "2", "CT07", "system", "system", "Y")
			,new CltCateDto("CT0707", 0, "민소매", "민소매", "2", "CT07", "system", "system", "Y")
			,new CltCateDto("CT0708", 0, "스웨터", "스웨터", "2", "CT07", "system", "system", "Y")
			,new CltCateDto("CT08", 0, "트레이닝복", "트레이닝복", "1", "CT08", "system", "system", "Y")
			,new CltCateDto("CT0801", 0, "세트", "세트", "2", "CT08", "system", "system", "Y")
			,new CltCateDto("CT0802", 0, "상의", "상의", "2", "CT08", "system", "system", "Y")
			,new CltCateDto("CT0803", 0, "하의", "하의", "2", "CT08", "system", "system", "Y")
		};
		return cateList;
	}
	
	public CltUserDto[] getUserDataArr() {
		CltUserDto[] userList = {
			 new CltUserDto("chunkind", "김땡땡", "1", "19880420", "chunkind@naver.com", "01012341244", "경기도 부천시 소사구", "괴안동 11", "12345", "경인로 122", "1동", "12345", "system")
			,new CltUserDto("djfeis", "박떵산", "1", "19900303", "Ejdtks@naver.com", "01012341233", "경기도 부천시 소사구", "괴안동 11", "12345", "경인로 122", "1동", "12345", "system")
			,new CltUserDto("marry", "이메리", "1", "19870612", "apfl@naver.com", "01012341222", "경기도 부천시 소사구", "괴안동 11", "12345", "경인로 122", "1동", "12345", "system")
			,new CltUserDto("short", "김짧다", "1", "19750905", "Wkfqek@naver.com", "01012341211", "경기도 부천시 소사구", "괴안동 11", "12345", "경인로 122", "1동", "12345", "system")
		};
		return userList;
	}
	
	public CltEntrDto[] getEntrDataArr() {
		CltEntrDto[] entrList = {
			 new CltEntrDto("chunkind", "JShop", "123-45-67890", "김땡땡", "01012341234", "jshop@go.ir", "김담당", "01043214321", "jjdd@naver.com", 0, "경기 성남시 분당구", "삼평동 681", "13494", "경기 성남시 분당구 판교역로 235 (에어치스퀘어 엔동)", "13494", DateUtils.stringToSqlDate("2010-10-01"), null, "Y", "Y", "system", "system")
			,new CltEntrDto("djfeis", "떵싼바지", "122-44-11111", "떵바지", "01021432143", "gsshop@gs.ml", "바지", "01045318888", "efjw@naver.com", 0, "경기 성남시 분당구", "삼평동 681", "13494", "경기 성남시 분당구 판교역로 235 (에어치스퀘어 엔동)", "13494", DateUtils.stringToSqlDate("2010-10-01"), null, "Y", "Y", "system", "system")
			,new CltEntrDto("marry", "메리샵", "333-22-12345", "메리", "01011223344", "apflapfl@mary.io", "메리꼬붕", "01022113344", "marry@naver.com", 0, "경기 성남시 분당구", "삼평동 681", "13494", "경기 성남시 분당구 판교역로 235 (에어치스퀘어 엔동)", "13494", DateUtils.stringToSqlDate("2010-10-01"), null, "Y", "Y", "system", "system")
			,new CltEntrDto("short", "쇼츠", "123-21-22334", "짧다", "01010023004", "Wkfqek@naver.com", "꼬붕", "01011222211", "Rhqhd@naver.com", 0, "경기 성남시 분당구", "삼평동 681", "13494", "경기 성남시 분당구 판교역로 235 (에어치스퀘어 엔동)", "13494", DateUtils.stringToSqlDate("2010-10-01"), null, "Y", "Y", "system", "system")
		};
		return entrList;
	}
	
	public CltGoodsDto[] getGoodsDataArr() {
		CltGoodsDto[] goodsList = {
			/*가방-백팩*/
			  new CltGoodsDto(1L, "흰색가방", 250000, "CT01", "CT0101", 10, 2500, "S", "흰색", "/img/cltsh/part/bag/backpack/", "backpack_01.jpg", "흰색 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "빨간가방", 150000, "CT01", "CT0101", 5, 2500, "L", "빨간색", "/img/cltsh/part/bag/backpack/", "backpack_02.jpg", "빨간가방 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "폴로가방", 120000, "CT01", "CT0101", 15, 2500, "L", "빨간색", "/img/cltsh/part/bag/backpack/", "backpack_03.jpg", "폴로가방 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "검정가방", 100000, "CT01", "CT0101", 20, 2500, "L", "빨간색", "/img/cltsh/part/bag/backpack/", "backpack_04.jpg", "검정가방 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "청색가방", 150000, "CT01", "CT0101", 40, 2500, "L", "빨간색", "/img/cltsh/part/bag/backpack/", "backpack_05.jpg", "청색가방 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "하늘색가방", 300000, "CT01", "CT0101", 20, 2500, "L", "빨간색", "/img/cltsh/part/bag/backpack/", "backpack_06.jpg", "하늘색가방 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "검정가방2", 350000, "CT01", "CT0101", 50, 2500, "L", "빨간색", "/img/cltsh/part/bag/backpack/", "backpack_07.jpg", "검정가방 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "검정가방3", 120000, "CT01", "CT0101", 1, 2500, "L", "빨간색", "/img/cltsh/part/bag/backpack/", "backpack_08.jpg", "검정가방 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "흰색가방2", 190000, "CT01", "CT0101", 5, 2500, "L", "빨간색", "/img/cltsh/part/bag/backpack/", "backpack_09.jpg", "흰색가방 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*하의-청바지*/
			 ,new CltGoodsDto(2L, "청바지1", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_01.jpg", "청바지1 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지2", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_02.jpg", "청바지2 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지3", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_03.jpg", "청바지3 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지4", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_04.jpg", "청바지4 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지5", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_05.jpg", "청바지5 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지6", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_06.jpg", "청바지6 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지7", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_07.jpg", "청바지7 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지8", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_08.jpg", "청바지8 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지9", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_09.jpg", "청바지9 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지10", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_10.jpg", "청바지10 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "청바지11", 150000, "CT02", "CT0201", 10, 2500, "L", "빨간색", "/img/cltsh/part/down/jeans/", "jeans_11.jpg", "청바지11 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*하의-레깅스*/
			 ,new CltGoodsDto(3L, "레깅스1", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_01.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*하의-긴바지*/
			 /*하의-짧은바지*/
			 ,new CltGoodsDto(4L, "반바지1", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_01.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "반바지2", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_02.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "반바지3", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_03.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*원피스-원피스*/
			 ,new CltGoodsDto(3L, "원피스1", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_01.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스2", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_02.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스3", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_03.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스4", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_04.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스5", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_05.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스6", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_06.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스7", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_07.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스8", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_08.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스9", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_09.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스10", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_10.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스11", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_11.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스12", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_12.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스13", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_13.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스14", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_14.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "원피스15", 50000, "CT03", "CT0301", 10, 2500, "L", "검정", "/img/cltsh/part/one_piece/one_piece/", "one_piece_15.jpg", "원피스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-블레이저*/
			 ,new CltGoodsDto(1L, "블레이저1", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_01.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-가디건*/
			 ,new CltGoodsDto(1L, "가디건1", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_01.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "가디건2", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_02.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "가디건3", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_03.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "가디건4", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_04.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "가디건5", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_05.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-코트*/
			 ,new CltGoodsDto(1L, "코트1", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_01.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "코트2", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_02.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-자켓*/
			 ,new CltGoodsDto(1L, "자켓1", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_01.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓2", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_02.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓3", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_03.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓4", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_04.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓5", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_05.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓6", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_06.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓7", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_07.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓8", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_08.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓9", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_09.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓10", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_10.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓11", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_11.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓12", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_12.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓13", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_13.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓14", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_14.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓15", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_15.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓16", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_16.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "자켓17", 50000, "CT04", "CT0404", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jackets/", "jacket_17.jpg", "자켓 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-점퍼*/
			 ,new CltGoodsDto(2L, "점퍼1", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_01.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "점퍼2", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_02.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "점퍼3", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_03.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-롱패딩*/
			 ,new CltGoodsDto(2L, "롱패딩1", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_01.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩2", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_02.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩3", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_03.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩4", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_04.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩5", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_05.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩6", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_06.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩7", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_07.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩8", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_08.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩9", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_09.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩10", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_10.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩11", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_11.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩12", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_12.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩13", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_13.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩14", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_14.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "롱패딩15", 50000, "CT04", "CT0406", 10, 2500, "L", "검정", "/img/cltsh/part/outer/long_padding/", "long_padding_15.jpg", "롱패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-숏패딩*/
			 ,new CltGoodsDto(4L, "숏패딩1", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_01.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩2", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_02.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩3", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_03.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩4", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_04.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩5", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_05.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩6", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_06.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩7", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_07.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩8", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_08.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩9", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_09.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩10", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_10.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "숏패딩11", 50000, "CT04", "CT0407", 10, 2500, "L", "검정", "/img/cltsh/part/outer/short_padding/", "short_padding_11.jpg", "숏패딩 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-무스탕*/
			 ,new CltGoodsDto(3L, "무스탕1", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_01.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "무스탕2", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_02.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-집업*/
			 ,new CltGoodsDto(3L, "집업1", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_01.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업2", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_02.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업3", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_03.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업4", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_04.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업5", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_05.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업6", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_06.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업7", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_07.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업8", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_08.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업9", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_09.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "집업10", 50000, "CT04", "CT0409", 10, 2500, "L", "검정", "/img/cltsh/part/outer/zipup/", "zip_up_10.jpg", "집업 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*신발-런닝화*/
			 ,new CltGoodsDto(4L, "런닝화1", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_01.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "런닝화2", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_02.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "런닝화3", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_03.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "런닝화4", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_04.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "런닝화5", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_05.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "런닝화6", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_06.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "런닝화7", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_07.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*신발-스니커즈*/
			 ,new CltGoodsDto(4L, "스니커즈1", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_01.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "스니커즈2", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_02.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "스니커즈3", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_03.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*스커트-숏*/
			 ,new CltGoodsDto(3L, "숏스커트1", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_01.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*스커트-롱*/
			 ,new CltGoodsDto(3L, "롱스커트1", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_01.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-니트*/
			 ,new CltGoodsDto(1L, "니트1", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_01.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "니트2", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_02.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "니트3", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_03.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "니트4", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_04.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-긴팔*/
			 ,new CltGoodsDto(1L, "긴팔1", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_01.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔2", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_02.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔3", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_03.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔4", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_04.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔5", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_05.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔6", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_06.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔7", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_07.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔8", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_08.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔9", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_09.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔10", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_10.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔11", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_11.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔12", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_12.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "긴팔13", 50000, "CT07", "CT0702", 10, 2500, "L", "검정", "/img/cltsh/part/top/long_shirt/", "long_sleeves_13.jpg", "긴팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-맨투맨*/
			 ,new CltGoodsDto(1L, "맨투맨1", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_01.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "맨투맨2", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_02.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "맨투맨3", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_03.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "맨투맨4", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_04.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "맨투맨5", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_05.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "맨투맨6", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_06.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "맨투맨7", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_07.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "맨투맨8", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_08.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "맨투맨9", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_09.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-목티*/
			 ,new CltGoodsDto(1L, "목티1", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_01.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "목티2", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_02.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-셔츠*/
			 ,new CltGoodsDto(1L, "셔츠1", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_01.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "셔츠2", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_02.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "셔츠3", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_03.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "셔츠4", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_04.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "셔츠5", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_05.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-반팔*/
			 ,new CltGoodsDto(1L, "반팔티1", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_01.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티2", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_02.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티3", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_03.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티4", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_04.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티5", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_05.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티6", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_06.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티7", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_07.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티8", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_08.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티9", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_09.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티10", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_10.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티11", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_11.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티12", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_12.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티13", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_13.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티14", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_14.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티15", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_15.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "반팔티16", 50000, "CT07", "CT0706", 10, 2500, "L", "검정", "/img/cltsh/part/top/short_shirt/", "short_sleeved_shirt_16.jpg", "반팔 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-민소매*/
			 ,new CltGoodsDto(1L, "민소매티1", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_01.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-스웨터*/
			 ,new CltGoodsDto(1L, "스웨터1", 50000, "CT07", "CT0708", 10, 2500, "L", "검정", "/img/cltsh/part/top/sweater/", "sweater_01.jpg", "스웨터 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "스웨터2", 50000, "CT07", "CT0708", 10, 2500, "L", "검정", "/img/cltsh/part/top/sweater/", "sweater_02.jpg", "스웨터 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "스웨터3", 50000, "CT07", "CT0708", 10, 2500, "L", "검정", "/img/cltsh/part/top/sweater/", "sweater_03.jpg", "스웨터 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*트레이닝복-세트(CT0801)*/
			 /*트레이닝복-상의(CT0802)*/
			 /*트레이닝복-하의(CT0803)*/
			 ,new CltGoodsDto(1L, "트레이닝복바지1", 50000, "CT08", "CT0803", 10, 2500, "L", "검정", "/img/cltsh/part/training/down/", "training_pants_01.jpg", "트레이닝복바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "트레이닝복바지2", 50000, "CT08", "CT0803", 10, 2500, "L", "검정", "/img/cltsh/part/training/down/", "training_pants_02.jpg", "트레이닝복바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*하의-레깅스*/
			 ,new CltGoodsDto(3L, "레깅스2", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_02.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "레깅스3", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_03.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "레깅스4", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_04.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "레깅스5", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_05.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "레깅스6", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_06.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "레깅스7", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_07.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "레깅스8", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_08.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "레깅스9", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_09.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "레깅스10", 50000, "CT02", "CT0202", 10, 2500, "S", "검정", "/img/cltsh/part/down/leggings/", "leggings_10.jpg", "스포츠 레깅스 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*하의-짧은바지*/
			 ,new CltGoodsDto(4L, "반바지4", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_04.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "반바지5", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_05.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "반바지6", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_06.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "반바지7", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_07.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "반바지8", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_08.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "반바지9", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_09.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "반바지10", 50000, "CT02", "CT0204", 10, 2500, "L", "검정", "/img/cltsh/part/down/short_pants/", "short_pants_10.jpg", "반바지 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-블레이저*/
			 ,new CltGoodsDto(1L, "블레이저2", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_02.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "블레이저3", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_03.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "블레이저4", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_04.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "블레이저5", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_05.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "블레이저6", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_06.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "블레이저7", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_07.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "블레이저8", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_08.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "블레이저9", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_09.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "블레이저10", 50000, "CT04", "CT0401", 10, 2500, "L", "검정", "/img/cltsh/part/outer/blazer/", "blazer_10.jpg", "블레이저 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-가디건*/
			 ,new CltGoodsDto(1L, "가디건6", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_06.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "가디건7", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_07.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "가디건8", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_08.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "가디건9", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_09.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "가디건10", 50000, "CT04", "CT0402", 10, 2500, "L", "검정", "/img/cltsh/part/outer/cardigan/", "cardigan_10.jpg", "가디건 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-코트*/
			 ,new CltGoodsDto(1L, "코트3", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_03.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "코트4", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_04.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "코트5", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_05.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "코트6", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_06.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "코트7", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_07.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "코트8", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_08.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "코트9", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_09.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "코트10", 50000, "CT04", "CT0403", 10, 2500, "L", "검정", "/img/cltsh/part/outer/coat/", "coat_10.jpg", "코트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-점퍼*/
			 ,new CltGoodsDto(2L, "점퍼4", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_04.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "점퍼5", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_05.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "점퍼6", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_06.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "점퍼7", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_07.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "점퍼8", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_08.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "점퍼9", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_09.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(2L, "점퍼10", 50000, "CT04", "CT0405", 10, 2500, "L", "검정", "/img/cltsh/part/outer/jumper/", "jumper_10.jpg", "점퍼 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*아우터-무스탕*/
			 ,new CltGoodsDto(3L, "무스탕3", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_03.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "무스탕4", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_04.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "무스탕5", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_05.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "무스탕6", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_06.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "무스탕7", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_07.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "무스탕8", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_08.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "무스탕9", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_09.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "무스탕10", 50000, "CT04", "CT0408", 10, 2500, "L", "검정", "/img/cltsh/part/outer/mustang/", "mustang_10.jpg", "무스탕 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*신발-런닝화*/
			 ,new CltGoodsDto(4L, "런닝화8", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_08.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "런닝화9", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_09.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "런닝화10", 50000, "CT05", "CT0501", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/running_shoes/", "running_shoes_10.jpg", "런닝화 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*신발-스니커즈*/
			 ,new CltGoodsDto(4L, "스니커즈4", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_04.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "스니커즈5", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_05.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "스니커즈6", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_06.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "스니커즈7", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_07.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "스니커즈8", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_08.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "스니커즈9", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_09.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(4L, "스니커즈10", 50000, "CT05", "CT0502", 10, 2500, "L", "검정", "/img/cltsh/part/shoes/sneakers/", "sneakers_10.jpg", "스니커즈 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*스커트-숏*/
			 ,new CltGoodsDto(3L, "숏스커트2", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_02.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "숏스커트3", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_03.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "숏스커트4", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_04.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "숏스커트5", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_05.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "숏스커트6", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_06.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "숏스커트7", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_07.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "숏스커트8", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_08.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "숏스커트9", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_09.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "숏스커트10", 50000, "CT06", "CT0601", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/short_skirt/", "short_skirt_10.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*스커트-롱*/
			 ,new CltGoodsDto(3L, "롱스커트2", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_02.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "롱스커트3", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_03.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "롱스커트4", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_04.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "롱스커트5", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_05.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "롱스커트6", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_06.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "롱스커트7", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_07.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "롱스커트8", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_08.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "롱스커트9", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_09.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(3L, "롱스커트10", 50000, "CT06", "CT0602", 10, 2500, "L", "검정", "/img/cltsh/part/skirt/long_skirt/", "long_skirt_10.jpg", "스커트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-니트*/
			 ,new CltGoodsDto(1L, "니트5", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_05.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "니트6", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_06.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "니트7", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_07.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "니트8", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_08.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "니트9", 50000, "CT07", "CT0701", 10, 2500, "L", "검정", "/img/cltsh/part/top/knit/", "knitwear_09.jpg", "니트 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-맨투맨*/
			 ,new CltGoodsDto(1L, "맨투맨10", 50000, "CT07", "CT0703", 10, 2500, "L", "검정", "/img/cltsh/part/top/man_to_man/", "man_to_man_10.jpg", "맨투맨 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-목티*/
			 ,new CltGoodsDto(1L, "목티3", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_03.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "목티4", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_04.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "목티5", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_05.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "목티6", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_06.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "목티7", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_07.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "목티8", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_08.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "목티9", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_09.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "목티10", 50000, "CT07", "CT0704", 10, 2500, "L", "검정", "/img/cltsh/part/top/turtleneck/", "turtleneck_10.jpg", "목티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-셔츠*/
			 ,new CltGoodsDto(1L, "셔츠6", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_06.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "셔츠7", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_07.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "셔츠8", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_08.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "셔츠9", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_09.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "셔츠10", 50000, "CT07", "CT0705", 10, 2500, "L", "검정", "/img/cltsh/part/top/shirt/", "shirt_10.jpg", "셔츠 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 /*상의-민소매*/
			 ,new CltGoodsDto(1L, "민소매티2", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_02.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "민소매티3", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_03.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "민소매티4", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_04.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "민소매티5", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_05.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "민소매티6", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_06.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "민소매티7", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_07.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "민소매티8", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_08.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "민소매티9", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_09.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
			 ,new CltGoodsDto(1L, "민소매티10", 50000, "CT07", "CT0707", 10, 2500, "L", "검정", "/img/cltsh/part/top/sleeveless/", "sleeveless_shirt_10.jpg", "민소매티 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))
		};
		return goodsList;
	}
	
	public CltSalesDto[] getSalesDataArr() {
		CltSalesDto[] salesList = {
		   /*가방-백팩       업체번호 상태코드 제목                  내용          뷰카운트 좋아요  가격   할인액          수량*/
			new CltSalesDto(1, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "클래식 유로 백팩", "아주 좋은 상품 입니다", 111, 10, 130000, 15000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(2, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "맨하탄 포티지 RED", "아주 좋은 상품 입니다", 200, 111, 100000, 10000, "01", 2, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(3, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "폴로 랄프 로렌 백팩", "아주 좋은 상품 입니다", 168, 33, 70000, 5000, "01", 5, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(4, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "맨하탄 포티지 BLACK", "아주 좋은 상품 입니다", 130, 121, 50000, 5000, "01", 50, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(5, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에프씨이 백팩", "아주 좋은 상품 입니다", 103, 51, 120000, 20000, "01", 11, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(6, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "버빌리안 백팩", "아주 좋은 상품 입니다", 250, 130, 68000, 8000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(7, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 백팩", "아주 좋은 상품 입니다", 200, 25, 80000, 5000, "01", 1, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(8, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "베이직 백팩", "아주 좋은 상품 입니다", 243, 61, 70000, 10000, "01", 3, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(9, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "Ultimit 백팩", "아주 좋은 상품 입니다", 451, 100, 120000, 20000, "01", 16, "system", "system", "01", "설명 없음.")
		   /*하의-청바지*/
		   ,new CltSalesDto(10, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "플랙 청바지", "아주 좋은 상품 입니다", 551, 210, 48000, 8000, "01", 40, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(11, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "토피 청바지", "아주 좋은 상품 입니다", 548, 158, 50000, 5000, "01", 35, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(12, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "피스워커 청바지", "아주 좋은 상품 입니다", 280, 30, 88000, 8000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(13, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "브랜디드 진청바지", "아주 좋은 상품 입니다", 551, 211, 48000, 8000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(14, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "브랜디드 청바지", "아주 좋은 상품 입니다", 680, 280, 79000, 9000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(15, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 청바지", "아주 좋은 상품 입니다", 551, 100, 68000, 8000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(16, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "드로우핏 청바지", "아주 좋은 상품 입니다", 481, 100, 58000, 5800, "01", 33, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(17, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "리 청바지", "아주 좋은 상품 입니다", 380, 110, 80000, 10000, "01", 11, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(18, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "모드나인 청바지", "아주 좋은 상품 입니다", 777, 333, 100000, 20000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(19, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "페이탈리즘 청바지", "아주 좋은 상품 입니다", 550, 111, 57000, 7000, "01", 44, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(20, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "브랜디드 청바지", "아주 좋은 상품 입니다", 543, 120, 50000, 10000, "01", 50, "system", "system", "01", "설명 없음.")
		   /*하의-레깅스*/
		   ,new CltSalesDto(21, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아디다스 레깅스", "아주 좋은 상품 입니다", 680, 500, 70000, 15000, "01", 30, "system", "system", "01", "설명 없음.")
		   /*하의-긴바지*/
		   /*하의-짧은바지*/
		   ,new CltSalesDto(22, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "나이키 반바지", "아주 좋은 상품 입니다", 307, 110, 55000, 5000, "01", 30, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(23, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "다이클레즈 반바지", "아주 좋은 상품 입니다", 120, 40, 58000, 8000, "01", 22, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(24, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "크리틱 반바지", "아주 좋은 상품 입니다", 310, 210, 38000, 8000, "01", 9, "system", "system", "01", "설명 없음.")
		   /*원피스-원피스*/
		   ,new CltSalesDto(25, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "엠엘비 원피스", "아주 좋은 상품 입니다", 410, 110, 80000, 5000, "01", 28, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(26, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "코닥 원피스", "아주 좋은 상품 입니다", 150, 41, 120000, 20000, "01", 25, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(27, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "르니앤맥코이 원피스", "아주 좋은 상품 입니다", 550, 360, 180000, 18000, "01", 11, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(28, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "그란데라인 원피스", "아주 좋은 상품 입니다", 380, 210, 150000, 10000, "01", 1, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(29, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "이슈넘버 원피스", "아주 좋은 상품 입니다", 610, 510, 170000, 10000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(30, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 플라워 원피스", "아주 좋은 상품 입니다", 433, 203, 146000, 52000, "01", 16, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(31, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 블랙 원피스", "아주 좋은 상품 입니다", 398, 180, 170000, 20000, "01", 15, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(32, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 네이비 반팔 원피스", "아주 좋은 상품 입니다", 408, 210, 110000, 11000, "01", 33, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(33, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 원피스", "아주 좋은 상품 입니다", 577, 209, 135000, 15000, "01", 25, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(34, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 블루 원피스", "아주 좋은 상품 입니다", 210, 103, 125000, 5000, "01", 17, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(35, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "잭니클라우스 원피스", "아주 좋은 상품 입니다", 310, 120, 130000, 20000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(36, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "폴로 랄프 로렌 원피스", "아주 좋은 상품 입니다", 501, 308, 128000, 8000, "01", 50, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(37, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 화이트 원피스", "아주 좋은 상품 입니다", 409, 203, 150000, 20000, "01", 15, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(38, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 원피스", "아주 좋은 상품 입니다", 310, 102, 70000, 5000, "01", 40, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(39, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 네이비 원피스", "아주 좋은 상품 입니다", 207, 107, 99000, 9000, "01", 5, "system", "system", "01", "설명 없음.")
		   /*아우터-블레이저*/
		   ,new CltSalesDto(40, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "로파이 블레이저", "아주 좋은 상품 입니다", 710, 410, 150000, 10000, "01", 19, "system", "system", "01", "설명 없음.")
		   /*아우터-가디건*/
		   ,new CltSalesDto(41, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "니티드 가디건", "아주 좋은 상품 입니다", 310, 60, 75000, 10000, "01", 8, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(42, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "비욘드클로젯 가디건", "아주 좋은 상품 입니다", 110, 10, 55000, 5000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(43, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "와랏이즌 가디건", "아주 좋은 상품 입니다", 490, 180, 65000, 6500, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(44, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "꼼파뇨 가디건", "아주 좋은 상품 입니다", 387, 247, 55000, 5500, "01", 15, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(45, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "노매뉴얼 가디건", "아주 좋은 상품 입니다", 436, 175, 80000, 5000, "01", 5, "system", "system", "01", "설명 없음.")
		   /*아우터-코트*/
		   ,new CltSalesDto(46, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "쿠어 코트", "아주 좋은 상품 입니다", 360, 210, 148000, 8000, "01", 40, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(47, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "메인부스 떡볶이 코트", "아주 좋은 상품 입니다", 380, 220, 98000, 18000, "01", 25, "system", "system", "01", "설명 없음.")
		   /*아우터-자켓*/
		   ,new CltSalesDto(48, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "제멋 딥그레이 자켓", "아주 좋은 상품 입니다", 510, 210, 48000, 4800, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(49, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "제멋 블랙 자켓", "아주 좋은 상품 입니다", 310, 111, 50000, 5000, "01", 18, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(50, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "코드그라피 후드 자켓", "아주 좋은 상품 입니다", 710, 501, 70000, 5000, "01", 2, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(51, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "더스토리 자켓", "아주 좋은 상품 입니다", 680, 408, 87000, 7000, "01", 33, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(52, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "제멋 자켓", "아주 좋은 상품 입니다", 607, 203, 40000, 4000, "01", 12, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(53, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "86로드 자켓", "아주 좋은 상품 입니다", 709, 410, 79000, 4000, "01", 1, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(54, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "86로드 자켓", "아주 좋은 상품 입니다", 710, 410, 76000, 1000, "01", 8, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(55, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 자켓", "아주 좋은 상품 입니다", 864, 540, 49000, 4900, "01", 1, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(56, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 라이트웨이트 자켓", "아주 좋은 상품 입니다", 855, 555, 50000, 5000, "01", 7, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(57, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "로파이 자켓", "아주 좋은 상품 입니다", 940, 610, 85000, 5000, "01", 13, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(58, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "파르티멘토 자켓", "아주 좋은 상품 입니다", 910, 510, 84000, 4000, "01", 15, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(59, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "뎃츠잇 자켓", "아주 좋은 상품 입니다", 560, 408, 68000, 8000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(60, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "코너스 자켓", "아주 좋은 상품 입니다", 410, 110, 88000, 8000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(61, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "말렌 자켓", "아주 좋은 상품 입니다", 510, 210, 60000, 6000, "01", 18, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(62, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "벌스데이수트 자켓", "아주 좋은 상품 입니다", 420, 150, 50000, 5000, "01", 14, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(63, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "오케이 블레이저 자켓", "아주 좋은 상품 입니다", 710, 601, 79000, 4000, "01", 4, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(64, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "투포켓 면자켓", "아주 좋은 상품 입니다", 870, 508, 88000, 4000, "01", 17, "system", "system", "01", "설명 없음.")
		   /*아우터-점퍼*/
		   ,new CltSalesDto(65, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "로스코 점퍼", "아주 좋은 상품 입니다", 620, 305, 68000, 8000, "01", 16, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(66, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "코드그라피 점퍼", "아주 좋은 상품 입니다", 610, 203, 48000, 4800, "01", 35, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(67, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "티알마크 점퍼", "아주 좋은 상품 입니다", 310, 101, 53000, 3000, "01", 12, "system", "system", "01", "설명 없음.")
		   /*아우터-롱패딩*/
		   ,new CltSalesDto(68, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "내셔널지오그래픽 롱패딩", "아주 좋은 상품 입니다", 780, 600, 249000, 9000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(69, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "노스페이스 롱패딩", "아주 좋은 상품 입니다", 910, 810, 250000, 20000, "01", 15, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(70, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 롱패딩", "아주 좋은 상품 입니다", 609, 410, 105000, 5000, "01", 8, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(71, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "널디 롱패딩", "아주 좋은 상품 입니다", 510, 303, 185000, 5000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(72, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "코닥 롱패딩", "아주 좋은 상품 입니다", 430, 201, 230000, 10000, "01", 22, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(73, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 롱패딩", "아주 좋은 상품 입니다", 617, 315, 130000, 13000, "01", 33, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(74, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "토트넘 어패럴 롱패딩", "아주 좋은 상품 입니다", 704, 501, 205000, 5000, "01", 30, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(75, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "지프 롱패딩", "아주 좋은 상품 입니다", 710, 510, 205000, 15000, "01", 18, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(76, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무스너클 롱패딩", "아주 좋은 상품 입니다", 930, 820, 108000, 10800, "01", 16, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(77, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 롱패딩", "아주 좋은 상품 입니다", 609, 410, 105000, 5000, "01", 15, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(78, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "안토니모라토 롱패딩", "아주 좋은 상품 입니다", 440, 223, 135000, 5000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(79, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "라이프 아카이브 롱패딩", "아주 좋은 상품 입니다", 310, 210, 150000, 30000, "01", 1, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(80, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "널디 롱패딩", "아주 좋은 상품 입니다", 510, 303, 185000, 5000, "01", 8, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(81, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무스너클 롱패딩", "아주 좋은 상품 입니다", 505, 402, 207000, 7000, "01", 26, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(82, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "라퍼지스토어 롱패딩", "아주 좋은 상품 입니다", 408, 208, 105000, 20000, "01", 14, "system", "system", "01", "설명 없음.")
		   /*아우터-숏패딩*/
		   ,new CltSalesDto(83, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 블랙 숏패딩", "아주 좋은 상품 입니다", 705, 310, 150000, 5000, "01", 1, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(84, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 라이트 그레이 숏패딩", "아주 좋은 상품 입니다", 701, 309, 148000, 5000, "01", 8, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(85, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에프씨엠엠 숏패딩", "아주 좋은 상품 입니다", 510, 210, 132000, 32000, "01", 19, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(86, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "디미트리블랙 숏패딩", "아주 좋은 상품 입니다", 810, 111, 129000, 5000, "01", 28, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(87, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아웃스탠딩 숏패딩", "아주 좋은 상품 입니다", 610, 110, 150000, 15000, "01", 30, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(88, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "지프 숏패딩", "아주 좋은 상품 입니다", 508, 316, 150000, 5000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(89, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에르노 숏패딩", "아주 좋은 상품 입니다", 607, 310, 148000, 8000, "01", 12, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(90, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "라퍼지스토어 숏패딩", "아주 좋은 상품 입니다", 710, 409, 105000, 5000, "01", 8, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(91, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "내셔널지오그래픽 숏패딩", "아주 좋은 상품 입니다", 801, 501, 149000, 9000, "01", 15, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(92, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "몽클레어 숏패딩", "아주 좋은 상품 입니다", 610, 190, 105000, 5000, "01", 16, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(93, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "유니폼브릿지 숏패딩", "아주 좋은 상품 입니다", 503, 150, 125000, 5000, "01", 8, "system", "system", "01", "설명 없음.")
		   /*아우터-무스탕*/
		   ,new CltSalesDto(94, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "모던스튜디오 무스탕", "아주 좋은 상품 입니다", 810, 310, 250000, 25000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(95, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "프롬웨얼 무스탕", "아주 좋은 상품 입니다", 910, 420, 350000, 50000, "01", 18, "system", "system", "01", "설명 없음.")

		   /*아우터-집업*/
		   ,new CltSalesDto(96, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에스피오나지 후드 집업", "아주 좋은 상품 입니다", 610, 310, 35000, 4000, "01", 50, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(97, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "챔피온 후드 집업", "아주 좋은 상품 입니다", 810, 403, 45000, 3000, "01", 30, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(98, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "와랏이즌 후드 집업", "아주 좋은 상품 입니다", 550, 255, 50000, 5000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(99, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "페플 후드 집업", "아주 좋은 상품 입니다", 480, 380, 38000, 3000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(100, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "그루브라임 후드 집업", "아주 좋은 상품 입니다", 810, 601, 42000, 4200, "01", 18, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(101, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "그레이버 그레이 후드 집업", "아주 좋은 상품 입니다", 710, 510, 38500, 4000, "01", 12, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(102, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "그레이버 블랙 후드 집업", "아주 좋은 상품 입니다", 708, 502, 41500, 5000, "01", 5, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(103, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "오앤에이 후드 집업", "아주 좋은 상품 입니다", 601, 406, 55000, 5000, "01", 44, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(104, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "꼼파뇨 광복절 후드 집업", "아주 좋은 상품 입니다", 780, 540, 44000, 4000, "01", 25, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(105, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 후드 집업", "아주 좋은 상품 입니다", 690, 580, 40000, 2000, "01", 1, "system", "system", "01", "설명 없음.")
		   /*신발-런닝화*/
		   ,new CltSalesDto(106, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "살로몬 런닝화", "아주 좋은 상품 입니다", 706, 510, 105000, 20000, "01", 18, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(107, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아디다스 런닝화", "아주 좋은 상품 입니다", 408, 300, 85000, 5000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(108, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "뉴발란스 런닝화", "아주 좋은 상품 입니다", 500, 208, 105000, 20000, "01", 7, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(109, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "윙스풋 런닝화", "아주 좋은 상품 입니다", 601, 411, 65000, 5000, "01", 2, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(110, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아식스 런닝화", "아주 좋은 상품 입니다", 710, 510, 115000, 5000, "01", 15, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(111, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "23.65 런닝화", "아주 좋은 상품 입니다", 680, 371, 75000, 5000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(112, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아식스 런닝화", "아주 좋은 상품 입니다", 208, 105, 55000, 15000, "01", 18, "system", "system", "01", "설명 없음.")
		   /*신발-스니커즈*/
		   ,new CltSalesDto(113, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "휠라 스니커즈", "아주 좋은 상품 입니다", 810, 620, 105000, 15000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(114, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "컨버스 스니커즈", "아주 좋은 상품 입니다", 799, 570, 95000, 9500, "01", 30, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(115, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "컨버스 스니커즈", "아주 좋은 상품 입니다", 844, 588, 85000, 8500, "01", 40, "system", "system", "01", "설명 없음.")
		   /*스커트-숏*/
		   ,new CltSalesDto(116, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "네스티 팬시 클럽 미니스커트", "아주 좋은 상품 입니다", 688, 388, 45000, 4000, "01", 30, "system", "system", "01", "설명 없음.")
		   /*스커트-롱*/
		   ,new CltSalesDto(117, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 롱 스커트", "아주 좋은 상품 입니다", 677, 199, 50000, 5000, "01", 10, "system", "system", "01", "설명 없음.")
		   /*상의-니트*/
		   ,new CltSalesDto(118, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "니티드 니트", "아주 좋은 상품 입니다", 576, 487, 58000, 5800, "01", 12, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(119, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "블론드나인 니트", "아주 좋은 상품 입니다", 432, 236, 49800, 8000, "01", 12, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(120, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "더웨더이즈어썸 니트", "아주 좋은 상품 입니다", 318, 156, 57000, 5700, "01", 13, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(121, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "데이 니트", "아주 좋은 상품 입니다", 436, 126, 55000, 5000, "01", 1, "system", "system", "01", "설명 없음.")
		   /*상의-긴팔*/
		   ,new CltSalesDto(122, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 베이식 긴팔", "아주 좋은 상품 입니다", 467, 310, 48000, 3000, "01", 1, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(123, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "바스틱 긴팔", "아주 좋은 상품 입니다", 360, 217, 58000, 5000, "01", 30, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(124, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 긴팔", "아주 좋은 상품 입니다", 670, 390, 58000, 5000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(125, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 긴팔", "아주 좋은 상품 입니다", 620, 390, 48000, 4800, "01", 2, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(126, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 화이트 긴팔", "아주 좋은 상품 입니다", 633, 387, 48000, 4800, "01", 3, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(127, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 블랙 긴팔", "아주 좋은 상품 입니다", 644, 399, 48000, 4800, "01", 5, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(128, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "드로우핏 긴팔", "아주 좋은 상품 입니다", 777, 298, 55000, 5000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(129, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "LA 긴팔", "아주 좋은 상품 입니다", 972, 527, 53000, 3000, "01", 14, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(130, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "heybig 긴팔", "아주 좋은 상품 입니다", 347, 129, 53000, 2000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(131, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아미 긴팔", "아주 좋은 상품 입니다", 997, 642, 58000, 3000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(132, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무지 민트 긴팔", "아주 좋은 상품 입니다", 678, 325, 38000, 2000, "01", 1, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(133, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무지 블랙 긴팔", "아주 좋은 상품 입니다", 544, 324, 38000, 2000, "01", 3, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(134, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "솔리드 긴팔", "아주 좋은 상품 입니다", 666, 333, 43000, 3000, "01", 10, "system", "system", "01", "설명 없음.")
		   /*상의-맨투맨*/
		   ,new CltSalesDto(135, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "딥인다이브 맨투맨", "아주 좋은 상품 입니다", 498, 245, 60000, 10000, "01", 5, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(136, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 맨투맨", "아주 좋은 상품 입니다", 768, 442, 45000, 0, "01", 3, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(137, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "팔렛 맨투맨", "아주 좋은 상품 입니다", 539, 362, 58000, 3000, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(138, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "나이키 맨투맨", "아주 좋은 상품 입니다", 668, 384, 62000, 6000, "01", 13, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(139, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "와랏이즌 맨투맨", "아주 좋은 상품 입니다", 628, 368, 63000, 6300, "01", 18, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(140, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "마하그리드 맨투맨", "아주 좋은 상품 입니다", 654, 366, 38000, 3800, "01", 2, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(141, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "어반디타입 맨투맨", "아주 좋은 상품 입니다", 410, 250, 42000, 4200, "01", 7, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(142, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "게인스브로 맨투맨", "아주 좋은 상품 입니다", 710, 310, 56000, 5600, "01", 8, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(143, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 맨투맨", "아주 좋은 상품 입니다", 410, 110, 40000, 2000, "01", 1, "system", "system", "01", "설명 없음.")
		   /*상의-목티*/
		   ,new CltSalesDto(144, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무지 목티", "아주 좋은 상품 입니다", 310, 118, 38000, 3800, "01", 6, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(145, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 목티", "아주 좋은 상품 입니다", 710, 420, 25000, 0, "01", 4, "system", "system", "01", "설명 없음.")
		   /*상의-셔츠*/
		   ,new CltSalesDto(146, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "다이아몬드 레이라 셔츠", "아주 좋은 상품 입니다", 610, 210, 48000, 4800, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(147, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "라퍼지스토어 셔츠", "아주 좋은 상품 입니다", 640, 340, 50000, 5000, "01", 38, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(148, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "토마스모어 셔츠", "아주 좋은 상품 입니다", 689, 346, 44000, 4000, "01", 33, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(149, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "필루미네이트 셔츠", "아주 좋은 상품 입니다", 769, 489, 53000, 3000, "01", 24, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(150, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아노블리어 체크 셔츠", "아주 좋은 상품 입니다", 777, 477, 55000, 5500, "01", 15, "system", "system", "01", "설명 없음.")
		   /*상의-반팔*/
		   ,new CltSalesDto(151, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "오닐 반팔티", "아주 좋은 상품 입니다", 377, 222, 28000, 3000, "01", 30, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(152, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "도그 반팔티", "아주 좋은 상품 입니다", 688, 344, 38000, 3000, "01", 50, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(153, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "프랑켄모노 반팔티", "아주 좋은 상품 입니다", 333, 111, 27000, 4000, "01", 80, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(154, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "오리지널 데이 반팔티", "아주 좋은 상품 입니다", 342, 156, 35000, 3500, "01", 70, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(155, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 반팔티", "아주 좋은 상품 입니다", 489, 275, 20000, 2000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(156, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "리 반팔티", "아주 좋은 상품 입니다", 490, 208, 40000, 2000, "01", 58, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(157, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무지 민소매 반팔티", "아주 좋은 상품 입니다", 488, 208, 20000, 1000, "01", 35, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(158, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "예일 스프라이트 반팔티", "아주 좋은 상품 입니다", 468, 197, 35000, 3500, "01", 34, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(159, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "예일 반팔티", "아주 좋은 상품 입니다", 672, 333, 34900, 3490, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(160, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "오버핏 반팔티", "아주 좋은 상품 입니다", 863, 426, 33000, 3300, "01", 8, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(161, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "오닐 반팔티", "아주 좋은 상품 입니다", 377, 222, 28000, 3000, "01", 30, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(162, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "도그 반팔티", "아주 좋은 상품 입니다", 688, 344, 38000, 3000, "01", 50, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(163, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "프랑켄모노 반팔티", "아주 좋은 상품 입니다", 333, 111, 27000, 4000, "01", 80, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(164, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "오리지널 데이 반팔티", "아주 좋은 상품 입니다", 342, 156, 35000, 3500, "01", 70, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(165, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 반팔티", "아주 좋은 상품 입니다", 489, 275, 20000, 1000, "01", 20, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(166, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "리 반팔티", "아주 좋은 상품 입니다", 490, 208, 40000, 2000, "01", 58, "system", "system", "01", "설명 없음.")
		   /*상의-민소매*/
		   ,new CltSalesDto(167, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무지 민소매 반팔티", "아주 좋은 상품 입니다", 488, 208, 20000, 1000, "01", 35, "system", "system", "01", "설명 없음.")
		   /*상의-스웨터*/
		   ,new CltSalesDto(168, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무지 스웨터", "아주 좋은 상품 입니다", 468, 197, 35000, 3500, "01", 34, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(169, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "DBF 스웨터", "아주 좋은 상품 입니다", 672, 333, 34900, 3490, "01", 10, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(170, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "jeep 스웨터", "아주 좋은 상품 입니다", 863, 426, 33000, 3300, "01", 8, "system", "system", "01", "설명 없음.")
		   /*트레이닝복-하의*/
		   ,new CltSalesDto(171, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아디다스 트레이닝 바지", "아주 좋은 상품 입니다", 699, 348, 38000, 3800, "01", 5, "system", "system", "01", "설명 없음.")
		   ,new CltSalesDto(172, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "멜란지 트레이닝 바지", "아주 좋은 상품 입니다", 641, 317, 35800, 800, "01", 11, "system", "system", "01", "설명 없음.")
		
		   
		   /*하의-레깅스*/
		   ,new CltSalesDto(173, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "나이키 레깅스", "아주 좋은 상품 입니다", 770, 500, 79000, 26500, "01", 20, "system", "system", "01", "설명 없음.") /*leggings_01.jpg*/
		   ,new CltSalesDto(174, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "남성 프로텍션 레깅스", "아주 좋은 상품 입니다", 530, 210, 59000, 5900, "01", 40, "system", "system", "01", "설명 없음.") /*leggings_02.jpg*/
		   ,new CltSalesDto(175, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "올데이 조거 레깅스 머그워트", "아주 좋은 상품 입니다", 610, 430, 59000, 5900, "01", 35, "system", "system", "01", "설명 없음.") /*leggings_03.jpg*/
		   ,new CltSalesDto(176, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "여성 트레이닝 하이라이즈7", "아주 좋은 상품 입니다", 620, 280, 79000, 7000, "01", 40, "system", "system", "01", "설명 없음.") /*leggings_04.jpg*/
		   ,new CltSalesDto(177, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "카파 레깅스", "아주 좋은 상품 입니다", 600, 320, 65000, 5000, "01", 30, "system", "system", "01", "설명 없음.") /*leggings_05.jpg*/
		   ,new CltSalesDto(178, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "언더아머 레깅스", "아주 좋은 상품 입니다", 4400, 1300, 45000, 17000, "01", 9, "system", "system", "01", "설명 없음.") /*leggings_06.jpg*/
		   ,new CltSalesDto(179, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "이노스 골프 레깅스", "아주 좋은 상품 입니다", 300, 120, 168000, 13000, "01", 55, "system", "system", "01", "설명 없음.") /*leggings_07.jpg*/
		   ,new CltSalesDto(180, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "뒤란 스커트 레깅스", "아주 좋은 상품 입니다", 1200, 480, 70000, 21000, "01", 13, "system", "system", "01", "설명 없음.") /*leggings_08.jpg*/
		   ,new CltSalesDto(181, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "그란데라인 레깅스 매트블루", "아주 좋은 상품 입니다", 500, 250, 38000, 4000, "01", 20, "system", "system", "01", "설명 없음.") /*leggings_09.jpg*/
		   /*하의-짧은바지*/
		   ,new CltSalesDto(182, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 유틸리티 쇼츠", "아주 좋은 상품 입니다", 3100, 840, 23900, 6000, "01", 60, "system", "system", "01", "설명 없음.") /*shorts_01.jpg*/
		   ,new CltSalesDto(183, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "유니폼브릿지 반바지", "아주 좋은 상품 입니다", 6000, 990, 69000, 6900, "01", 40, "system", "system", "01", "설명 없음.") /*shorts_02.jpg*/
		   ,new CltSalesDto(184, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아디다스 반바지", "아주 좋은 상품 입니다", 8000, 1450, 45000, 10000, "01", 10, "system", "system", "01", "설명 없음.") /*shorts_03.jpg*/
		   ,new CltSalesDto(185, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "코드그라피 숏팬츠", "아주 좋은 상품 입니다", 4600, 415, 44000, 6000, "01", 38, "system", "system", "01", "설명 없음.") /*shorts_04.jpg*/
		   ,new CltSalesDto(186, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "어반스터프 반바지", "아주 좋은 상품 입니다", 6700, 1376, 54000, 11000, "01", 51, "system", "system", "01", "설명 없음.") /*shorts_05.jpg*/
		   ,new CltSalesDto(187, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "칸6312 반바지 블랙", "아주 좋은 상품 입니다", 280, 110, 74000, 15000, "01", 66, "system", "system", "01", "설명 없음.") /*shorts_06.jpg*/
		   ,new CltSalesDto(188, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에이본 반바지 차콜", "아주 좋은 상품 입니다", 650, 350, 55000, 2250, "01", 33, "system", "system", "01", "설명 없음.") /*shorts_07.jpg*/
		   /*아우터-블레이저*/
		   ,new CltSalesDto(189, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "앤드지 블레이저", "아주 좋은 상품 입니다", 610, 330, 149000, 29000, "01", 18, "system", "system", "01", "설명 없음.") /*blazer_01.jpg*/
		   ,new CltSalesDto(190, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "빠니깔레 블레이저", "아주 좋은 상품 입니다", 830, 310, 130000, 30000, "01", 20, "system", "system", "01", "설명 없음.") /*blazer_02.jpg*/
		   ,new CltSalesDto(191, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 우먼즈 오버사이즈 블레이저", "아주 좋은 상품 입니다", 4100, 329, 71900, 5000, "01", 30, "system", "system", "01", "설명 없음.") /*blazer_03.jpg*/
		   ,new CltSalesDto(192, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에디션 블레이저", "아주 좋은 상품 입니다", 880, 310, 148000, 25000, "01", 19, "system", "system", "01", "설명 없음.") /*blazer_04.jpg*/
		   ,new CltSalesDto(193, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "로파이 블레이저 뉴트로 체크", "아주 좋은 상품 입니다", 2600, 2991, 139000, 10000, "01", 6, "system", "system", "01", "설명 없음.") /*blazer_05.jpg*/
		   ,new CltSalesDto(194, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "본 매그넘 블레이저 라이트 그레이", "아주 좋은 상품 입니다", 710, 260, 179400, 30000, "01", 17, "system", "system", "01", "설명 없음.") /*blazer_06.jpg*/
		   ,new CltSalesDto(195, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "리버클래시 블레이저", "아주 좋은 상품 입니다", 1040, 100, 204000, 50000, "01", 13, "system", "system", "01", "설명 없음.") /*blazer_07.jpg*/
		   ,new CltSalesDto(196, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "토피 오버사이즈 컴포트 블레이저", "아주 좋은 상품 입니다", 1300, 754, 119000, 40000, "01", 3, "system", "system", "01", "설명 없음.") /*blazer_08.jpg*/
		   ,new CltSalesDto(197, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "모디파이드 블레이저", "아주 좋은 상품 입니다", 4300, 2879, 185000, 40000, "01", 20, "system", "system", "01", "설명 없음.") /*blazer_09.jpg*/
		   /*아우터-가디건*/
		   ,new CltSalesDto(198, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "엘무드 가디건", "아주 좋은 상품 입니다", 4600, 2082, 94900, 30000, "01", 8, "system", "system", "01", "설명 없음.") /*cardigan_01.jpg*/
		   ,new CltSalesDto(199, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "베리베인 가디건", "아주 좋은 상품 입니다", 1800, 754, 42000, 3000, "01", 5, "system", "system", "01", "설명 없음.") /*cardigan_02.jpg*/
		   ,new CltSalesDto(200, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "베리베인 그레이 가디건", "아주 좋은 상품 입니다", 2900, 213, 42000, 3000, "01", 10, "system", "system", "01", "설명 없음.") /*cardigan_03.jpg*/
		   ,new CltSalesDto(201, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에스피오나지 가디건", "아주 좋은 상품 입니다", 6000, 656, 132000, 32000, "01", 20, "system", "system", "01", "설명 없음.") /*cardigan_04.jpg*/
		   ,new CltSalesDto(202, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 가디건", "아주 좋은 상품 입니다", 1300, 589, 89000, 45000, "01", 3, "system", "system", "01", "설명 없음.") /*cardigan_05.jpg*/
		   /*아우터-코트*/
		   ,new CltSalesDto(203, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 더블 체스터 코트", "아주 좋은 상품 입니다", 4000, 2155, 159900, 30000, "01", 30, "system", "system", "01", "설명 없음.") /*coat_01.jpg*/
		   ,new CltSalesDto(204, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "로파이 더블 코트", "아주 좋은 상품 입니다", 1260, 960, 245000, 147000, "01", 10, "system", "system", "01", "설명 없음.") /*coat_02.jpg*/
		   ,new CltSalesDto(205, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "쟈니웨스트 코트", "아주 좋은 상품 입니다", 4060, 3010, 98000, 5000, "01", 32, "system", "system", "01", "설명 없음.") /*coat_03.jpg*/
		   ,new CltSalesDto(206, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 맥 코트", "아주 좋은 상품 입니다", 2050, 1520, 89900, 40000, "01", 10, "system", "system", "01", "설명 없음.") /*coat_04.jpg*/
		   ,new CltSalesDto(207, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "라퍼지 스토어 오버 코트", "아주 좋은 상품 입니다", 7099, 5042, 173000, 65000, "01", 22, "system", "system", "01", "설명 없음.") /*coat_05.jpg*/
		   ,new CltSalesDto(208, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 맥 코트", "아주 좋은 상품 입니다", 600, 408, 249000, 149000, "01", 40, "system", "system", "01", "설명 없음.") /*coat_06.jpg*/
		   ,new CltSalesDto(209, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "파르티멘토 롱 코트", "아주 좋은 상품 입니다", 9486, 7926, 155000, 56000, "01", 37, "system", "system", "01", "설명 없음.") /*coat_07.jpg*/
		   ,new CltSalesDto(210, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 울 더플 코트", "아주 좋은 상품 입니다", 4980, 2480, 299000, 90000, "01", 40, "system", "system", "01", "설명 없음.") /*coat_08.jpg*/
		   /*아우터-점퍼*/
		   ,new CltSalesDto(211, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "키뮤어 점퍼", "아주 좋은 상품 입니다", 4400, 781, 99000, 44000, "01", 18, "system", "system", "01", "설명 없음.") /*jumper_01.jpg*/
		   ,new CltSalesDto(212, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "로스코 플라이트 점퍼", "아주 좋은 상품 입니다", 1000, 797, 79000, 16000, "01", 16, "system", "system", "01", "설명 없음.") /*jumper_02.jpg*/
		   ,new CltSalesDto(213, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "디스이즈네버댓 점퍼", "아주 좋은 상품 입니다", 1500, 245, 269000, 13400, "01", 33, "system", "system", "01", "설명 없음.") /*jumper_03.jpg*/
		   ,new CltSalesDto(214, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "알파 인더스트리 점퍼", "아주 좋은 상품 입니다", 7800, 2857, 68000, 8000, "01", 17, "system", "system", "01", "설명 없음.") /*jumper_04.jpg*/
		   ,new CltSalesDto(215, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "엑스사키 항공점퍼", "아주 좋은 상품 입니다", 100, 27, 84000, 49000, "01", 55, "system", "system", "01", "설명 없음.") /*jumper_05.jpg*/
		   ,new CltSalesDto(216, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "인터섹션 디테처블 후드 점퍼", "아주 좋은 상품 입니다", 6799, 4779, 200000, 45000, "01", 1, "system", "system", "01", "설명 없음.") /*jumper_06.jpg*/
		   ,new CltSalesDto(217, 2L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "코너스 스웨트 점퍼", "아주 좋은 상품 입니다", 400, 43, 128000, 22000, "01", 16, "system", "system", "01", "설명 없음.") /*jumper_07.jpg*/
		   /*아우터-무스탕*/
		   ,new CltSalesDto(218, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "어반스터프 무스탕", "아주 좋은 상품 입니다", 3499, 2566, 139000, 14000, "01", 30, "system", "system", "01", "설명 없음.") /*무스탕1.jpg*/
		   ,new CltSalesDto(219, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "세인트페인 무스탕", "아주 좋은 상품 입니다", 3178, 2290, 88000, 8000, "01", 26, "system", "system", "01", "설명 없음.") /*무스탕2.jpg*/
		   ,new CltSalesDto(220, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "도프제이슨 무스탕", "아주 좋은 상품 입니다", 3269, 2104, 250000, 50000, "01", 5, "system", "system", "01", "설명 없음.") /*무스탕3.jpg*/
		   ,new CltSalesDto(221, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "키르시 무스탕", "아주 좋은 상품 입니다", 810, 798, 199000, 50000, "01", 24, "system", "system", "01", "설명 없음.") /*무스탕4.jpg*/
		   ,new CltSalesDto(222, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "알파 인더스트리 무스탕", "아주 좋은 상품 입니다", 1900, 637, 229000, 69000, "01", 37, "system", "system", "01", "설명 없음.") /*무스탕5.jpg*/
		   ,new CltSalesDto(223, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "오브젝트펑크 무스탕", "아주 좋은 상품 입니다", 368, 50, 127000, 20000, "01", 45, "system", "system", "01", "설명 없음.") /*무스탕6.jpg*/
		   ,new CltSalesDto(224, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "매스노운 무스탕", "아주 좋은 상품 입니다", 710, 110, 199000, 69000, "01", 8, "system", "system", "01", "설명 없음.") /*무스탕7.jpg*/
		   ,new CltSalesDto(225, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "뮤게 무스탕", "아주 좋은 상품 입니다", 380, 10, 229000, 60000, "01", 10, "system", "system", "01", "설명 없음.") /*무스탕8.jpg*/
		 /*신발-런닝화*/
		   ,new CltSalesDto(226, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "나이키 레볼루션 6 넥스트 네이터 런닝화", "아주 좋은 상품 입니다", 4500, 380, 89000, 27000, "01", 40, "system", "system", "01", "설명 없음.") /*런닝화1.jpg*/
		   ,new CltSalesDto(227, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "호카오네오네 런닝화", "아주 좋은 상품 입니다", 600, 28, 273900, 90000, "01", 30, "system", "system", "01", "설명 없음.") /*런닝화2.jpg*/
		   ,new CltSalesDto(228, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에이지 나일론 런닝화", "아주 좋은 상품 입니다", 600, 222, 109000, 10000, "01", 10, "system", "system", "01", "설명 없음.") /*런닝화3.jpg*/
		/*신발-스니커즈*/
		   ,new CltSalesDto(229, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "반스 어센틱 스니커즈", "아주 좋은 상품 입니다", 6300, 708, 69000, 19000, "01", 10, "system", "system", "01", "설명 없음.") /*스니커즈1.jpg*/
		   ,new CltSalesDto(230, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "컨버스 스니커즈", "아주 좋은 상품 입니다", 8700, 8300, 99000, 9900, "01", 4, "system", "system", "01", "설명 없음.") /*스니커즈2.jpg*/
		   ,new CltSalesDto(231, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "반스 클래식 슬립온 뮬 스니커즈", "아주 좋은 상품 입니다", 2300, 1100, 69000, 6900, "01", 40, "system", "system", "01", "설명 없음.") /*스니커즈3.jpg*/
		   ,new CltSalesDto(232, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "컨버스 척테일러 올스타 화이트 스니커즈", "아주 좋은 상품 입니다", 4200, 3600, 55000, 5500, "01", 20, "system", "system", "01", "설명 없음.") /*스니커즈4.jpg*/
		   ,new CltSalesDto(233, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "캐치볼 스니커즈", "아주 좋은 상품 입니다", 1400, 665, 89000, 9000, "01", 43, "system", "system", "01", "설명 없음.") /*스니커즈5.jpg*/
		   ,new CltSalesDto(234, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "슈펜 스니커즈", "아주 좋은 상품 입니다", 2600, 2121, 49900, 2000, "01", 32, "system", "system", "01", "설명 없음.") /*스니커즈6.jpg*/
		   ,new CltSalesDto(235, 4L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "엠엘비 스니커즈", "아주 좋은 상품 입니다", 8300, 2614, 65000, 6500, "01", 10, "system", "system", "01", "설명 없음.") /*스니커즈7.jpg*/
		/*스커트-숏*/
		   ,new CltSalesDto(236, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 우먼즈 데님 미니스커트", "아주 좋은 상품 입니다", 9500, 3458, 31900, 3190, "01", 30, "system", "system", "01", "설명 없음.") /*미니스커트1.jpg*/
		   ,new CltSalesDto(237, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아디다스 미니스커트", "아주 좋은 상품 입니다", 200, 26, 69000, 15000, "01", 80, "system", "system", "01", "설명 없음.") /*미니스커트2.jpg*/
		   ,new CltSalesDto(238, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "어뉴골프 미니스커트", "아주 좋은 상품 입니다", 308, 80, 378000, 178000, "01", 77, "system", "system", "01", "설명 없음.") /*미니스커트3.jpg*/
		   ,new CltSalesDto(239, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에이본 미니스커트", "아주 좋은 상품 입니다", 3890, 85, 35000, 3500, "01", 35, "system", "system", "01", "설명 없음.") /*미니스커트4.jpg*/
		   ,new CltSalesDto(240, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "로에일 미니스커트", "아주 좋은 상품 입니다", 338, 10, 72900, 14000, "01", 49, "system", "system", "01", "설명 없음.") /*미니스커트5.jpg*/
		   ,new CltSalesDto(241, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "시티팝즈 미니스커트", "아주 좋은 상품 입니다", 1080, 28, 50000, 10000, "01", 30, "system", "system", "01", "설명 없음.") /*미니스커트6.jpg*/
		   ,new CltSalesDto(242, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 미니스커트", "아주 좋은 상품 입니다", 308, 10, 39900, 3990, "01", 33, "system", "system", "01", "설명 없음.") /*미니스커트7.jpg*/
		   ,new CltSalesDto(243, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "밀리언코르 데님 미니스커트", "아주 좋은 상품 입니다", 3500, 725, 45000, 9000, "01", 30, "system", "system", "01", "설명 없음.") /*미니스커트8.jpg*/
		   ,new CltSalesDto(244, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "비욘드클로젯 미니스커트", "아주 좋은 상품 입니다", 689, 68, 75000, 7500, "01", 10, "system", "system", "01", "설명 없음.") /*미니스커트9.jpg*/
		  /*스커트-롱*/
		   ,new CltSalesDto(245, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "닉앤니콜 롱 스커트", "아주 좋은 상품 입니다", 308, 19, 89000, 10000, "01", 18, "system", "system", "01", "설명 없음.") /*롱스커트1.jpg*/
		   ,new CltSalesDto(246, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "콜릿 롱 스커트", "아주 좋은 상품 입니다", 6804, 4218, 37000, 6000, "01", 3, "system", "system", "01", "설명 없음.") /*롱스커트2.jpg*/
		   ,new CltSalesDto(247, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "링서울 롱 스커트", "아주 좋은 상품 입니다", 387, 8, 82100, 5000, "01", 20, "system", "system", "01", "설명 없음.") /*롱스커트3.jpg*/
		   ,new CltSalesDto(248, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "티비제이 롱 스커트", "아주 좋은 상품 입니다", 4328, 189, 49900, 37000, "01", 88, "system", "system", "01", "설명 없음.") /*롱스커트4.jpg*/
		   ,new CltSalesDto(249, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "비뮤즈맨션 롱 스커트", "아주 좋은 상품 입니다", 3425, 262, 138000, 7000, "01", 43, "system", "system", "01", "설명 없음.") /*롱스커트5.jpg*/
		   ,new CltSalesDto(250, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "아디다스 롱 스커트", "아주 좋은 상품 입니다", 4800, 3110, 79000, 35000, "01", 8, "system", "system", "01", "설명 없음.") /*롱스커트6.jpg*/
		   ,new CltSalesDto(251, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "에잇세컨즈 브라운 플라워 롱 스커트", "아주 좋은 상품 입니다", 577, 6, 39900, 0, "01", 10, "system", "system", "01", "설명 없음.") /*롱스커트7.jpg*/
		   ,new CltSalesDto(252, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "로아즈 롱 스커트", "아주 좋은 상품 입니다", 6800, 3241, 179000, 50000, "01", 50, "system", "system", "01", "설명 없음.") /*롱스커트8.jpg*/
		   ,new CltSalesDto(253, 3L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "컴젠 롱 스커트", "아주 좋은 상품 입니다", 498, 123, 179000, 16000, "01", 30, "system", "system", "01", "설명 없음.") /*롱스커트9.jpg*/
		/*상의-니트*/
		   ,new CltSalesDto(254, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "엘무드 니트", "아주 좋은 상품 입니다", 6100, 3492, 89900, 28900, "01", 12, "system", "system", "01", "설명 없음.") /*니트1.jpg*/
		   ,new CltSalesDto(255, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "블론드나인 크루넥 리브 니트", "아주 좋은 상품 입니다", 8003, 6302, 65600, 35800, "01", 29, "system", "system", "01", "설명 없음.") /*니트2.jpg*/
		   ,new CltSalesDto(256, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 니트", "아주 좋은 상품 입니다", 5546, 2512, 49900, 20000, "01", 6, "system", "system", "01", "설명 없음.") /*니트3.jpg*/
		   ,new CltSalesDto(257, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "테이크이지 니트", "아주 좋은 상품 입니다", 6800, 5104, 54000, 16200, "01", 38, "system", "system", "01", "설명 없음.") /*니트4.jpg*/
		   ,new CltSalesDto(258, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "테이크이지 소프트코튼 브이넥 니트", "아주 좋은 상품 입니다", 2700, 2370, 54000, 11000, "01", 1, "system", "system", "01", "설명 없음.") /*니트5.jpg*/
		 /*상의-맨투맨*/
		   ,new CltSalesDto(259, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "유니폼브릿지 1960 맨투맨", "아주 좋은 상품 입니다", 7668, 6645, 59000, 5900, "01", 35, "system", "system", "01", "설명 없음.") /*맨투맨1.jpg*/
		  /*상의-목티*/
		   ,new CltSalesDto(260, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "락사이코 목티", "아주 좋은 상품 입니다", 2400, 1047, 24000, 2000, "01", 32, "system", "system", "01", "설명 없음.") /*목티1.jpg*/
		   ,new CltSalesDto(261, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "필루미네이트 목티", "아주 좋은 상품 입니다", 1900, 155, 23000, 6000, "01", 28, "system", "system", "01", "설명 없음.") /*목티2.jpg*/
		   ,new CltSalesDto(262, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 목티", "아주 좋은 상품 입니다", 1500, 741, 89000, 45000, "01", 5, "system", "system", "01", "설명 없음.") /*목티3.jpg*/
		   ,new CltSalesDto(263, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "니티드 목티", "아주 좋은 상품 입니다", 159, 98, 42000, 30000, "01", 22, "system", "system", "01", "설명 없음.") /*목티4.jpg*/
		   ,new CltSalesDto(264, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 램스울 리브드 목티", "아주 좋은 상품 입니다", 4899, 440, 67900, 6790, "01", 13, "system", "system", "01", "설명 없음.") /*목티5.jpg*/
		   ,new CltSalesDto(265, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "유씨 버클리 목티", "아주 좋은 상품 입니다", 2700, 889, 63000, 26000, "01", 24, "system", "system", "01", "설명 없음.") /*목티6.jpg*/
		   ,new CltSalesDto(266, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "포스333 목티", "아주 좋은 상품 입니다", 200, 128, 79000, 12000, "01", 40, "system", "system", "01", "설명 없음.") /*목티7.jpg*/
		   ,new CltSalesDto(267, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "메종 키츠네 목티", "아주 좋은 상품 입니다", 1235, 28, 54000, 5400, "01", 6, "system", "system", "01", "설명 없음.") /*목티8.jpg*/
		/*상의-셔츠*/
		   ,new CltSalesDto(268, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "다이아몬드 레이라 플러프 무드 체크 셔츠", "아주 좋은 상품 입니다", 1700, 968, 68000, 31000, "01", 40, "system", "system", "01", "설명 없음.") /*셔츠1.jpg*/
		   ,new CltSalesDto(269, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "쟈니웨스트 체크 셔츠", "아주 좋은 상품 입니다", 1500, 814, 34000, 2000, "01", 35, "system", "system", "01", "설명 없음.") /*셔츠2.jpg*/
		   ,new CltSalesDto(270, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "파르티멘토 셔츠", "아주 좋은 상품 입니다", 2500, 651, 49600, 14900, "01", 5, "system", "system", "01", "설명 없음.") /*셔츠3.jpg*/
		   ,new CltSalesDto(271, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "커버낫 셔츠", "아주 좋은 상품 입니다", 2432, 924, 79000, 16000, "01", 19, "system", "system", "01", "설명 없음.") /*셔츠4.jpg*/
		   ,new CltSalesDto(272, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 릴렉스 핏 실키 셔츠", "아주 좋은 상품 입니다", 1765, 1662, 23900, 2000, "01", 3, "system", "system", "01", "설명 없음.") /*셔츠5.jpg*/
		 /*상의-민소매*/
		   ,new CltSalesDto(273, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "무신사 스탠다드 레이어드 슬리브리스 탑", "아주 좋은 상품 입니다", 8935, 3421, 11900, 2000, "01", 35, "system", "system", "01", "설명 없음.") /*민소매1.jpg*/
		   ,new CltSalesDto(274, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "벤자민 클래식 오트밀 민소매 티셔츠", "아주 좋은 상품 입니다", 1236, 19, 18900, 1000, "01", 63, "system", "system", "01", "설명 없음.") /*민소매2.jpg*/
		   ,new CltSalesDto(275, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "칸6312 민소매 티셔츠", "아주 좋은 상품 입니다", 488, 2, 42000, 11000, "01", 34, "system", "system", "01", "설명 없음.") /*민소매3.jpg*/
		   ,new CltSalesDto(276, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "나이키 민소매 티셔츠", "아주 좋은 상품 입니다", 500, 32, 59000, 23000, "01", 43, "system", "system", "01", "설명 없음.") /*민소매4.jpg*/
		   ,new CltSalesDto(277, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "스티그마 민소매 티셔츠", "아주 좋은 상품 입니다", 1234, 64, 38000, 4000, "01", 65, "system", "system", "01", "설명 없음.") /*민소매5.jpg*/
		   ,new CltSalesDto(278, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "굿데이메이트 민소매 티셔츠", "아주 좋은 상품 입니다", 836, 48, 92000, 9200, "01", 88, "system", "system", "01", "설명 없음.") /*민소매6.jpg*/
		   ,new CltSalesDto(279, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "캘빈클라인 골프 민소매 티셔츠", "아주 좋은 상품 입니다", 1235, 123, 179000, 54000, "01", 20, "system", "system", "01", "설명 없음.") /*민소매7.jpg*/
		   ,new CltSalesDto(280, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "세인트페인 민소매 티셔츠", "아주 좋은 상품 입니다", 4458, 465, 25000, 2500, "01", 5, "system", "system", "01", "설명 없음.") /*민소매8.jpg*/
		   ,new CltSalesDto(281, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "벤자민 클래식 민소매 티셔츠", "아주 좋은 상품 입니다", 1654, 128, 17700, 5000, "01", 38, "system", "system", "01", "설명 없음.") /*민소매9.jpg*/
		   ,new CltSalesDto(282, 1L, "01", "Y",DateUtils.stringToSqlDate("2022-05-01"), DateUtils.stringToSqlDate("2022-12-31"), "리 민소매 티셔츠", "아주 좋은 상품 입니다", 4236, 208, 39000, 15000, "01", 35, "system", "system", "01", "설명 없음.") /*민소매10.jpg*/
		};
		return salesList;
	}
}
