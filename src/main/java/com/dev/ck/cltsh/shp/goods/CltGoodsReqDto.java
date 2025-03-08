package com.dev.ck.cltsh.shp.goods;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.dev.ck.cltsh.shp.opts.CltOptsDto;
import com.dev.ck.cltsh.shp.user.CltUserDto;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 상품 등록 및 수정 요청 DTO 
 * */

@Data
@NoArgsConstructor
public class CltGoodsReqDto {
	
	@Valid
	private CltGoodsDto goodsDto;

	@Valid
	private List<CltOptsDto> optList;
	
	private MultipartFile file1;
	
	public CltGoodsDto setGoodsInfo(CltUserDto user) {
		CltGoodsDto goodsInfo = new CltGoodsDto();
		
		goodsInfo.setGoodsCd(goodsDto.getGoodsCd());
		goodsInfo.setUpdtId(user.getUpdtId());
		
		System.out.println(goodsInfo);
		
		return goodsInfo;
	}
}
