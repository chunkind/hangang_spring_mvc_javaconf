package com.dev.ck.cltsh.shp.goods;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltGoodsDto extends PagingVO{
	public CltGoodsDto(long entrNo, String goodsNm, int goodsPrc
		, String catgryCd, String catgryCd2, int inyQty, int dlvPrc
		, String goodsSize, String goodsClr, String imgPath
		, String imgNm, String goodsIntr, String saleStatCd
		, String useYn, String rgstId, java.sql.Date rgstDate
		, String updtId, java.sql.Date updtDate) {
		this.entrNo = entrNo;
		this.goodsNm = goodsNm;
		this.goodsPrc = goodsPrc;
		this.catgryCd = catgryCd;
		this.catgryCd2 = catgryCd2;
		this.inyQty = inyQty;
		this.dlvPrc = dlvPrc;
		this.goodsSize = goodsSize;
		this.goodsClr = goodsClr;
		this.imgPath = imgPath;
		this.imgNm = imgNm;
		this.goodsIntr = goodsIntr;
		this.saleStatCd = saleStatCd;
		this.useYn = useYn;
		this.rgstId = rgstId;
		this.rgstDate = rgstDate;
		this.updtId = updtId;
		this.updtDate = updtDate;
	}
	//new GoodsVO(1L, "흰색가방", 250000, "CT01", "CT0101", 10, 2500, "S", "흰색", "/img/cltsh/part/bag/backpack/", "backpack_01.jpg", "흰색 가방 입니다.", "01", "Y", "system", DateUtils.stringToSqlDate("2012-05-21"), "system", DateUtils.stringToSqlDate("2012-05-21"))

	private long goodsInfoSeq;/*상품 시퀀스*/
	private long goodsCd;/*상품 코드*/
	private long entrNo;/*거래처 번호*/
	private String goodsNm;/*상품이름*/
	private int goodsPrc;/*상품가격*/
	private String catgryCd;/*대분류*/
	private String catgryCd2;/*소분류*/
	private int inyQty;/*재고수량*/
	private int dlvPrc;/*배송비*/
	private String goodsSize;/*상품싸이즈*/
	private String goodsClr;/*상품컬러*/
	private String imgPath;/*이미지경로*/
	private String imgNm;/*이미지이름*/
	private String goodsIntr;/*상품소개*/
	private String saleStatCd;/*판매상태*/
	private String useYn;/*사용여부*/
	private String rgstId;/*등록자*/
	private Date rgstDate;/*등록일*/
	private String updtId;/*수정자*/
	private Date updtDate;/*수정일*/
	
	private String saleBoardSeq;
	private String bulTitNm;
	private String bulStrtDt;
	private String bulEndDt;
	private String bulYn;
	private String ntcSctCd;
	private String bulCont;
	private String qryCnt;
	private String lkeCnt;
	private String goodsSalePrc;
	private String prclWay;
	private String saleCnt;
	private String description;
	private String goodsInfo;
	
	private String searchEntrNo;
	private String searchSaleBoardSeq;
	
	private String searchCatgryCd;
	private String searchCatgryCd2;
	private String searchGoodsCd;
	
	private MultipartFile file1;
}