package com.dev.ck.cltsh.shp.payment.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dev.ck.cltsh.shp.payment.CltPaymentDto;

@Mapper
public interface CltPaymentMapper {
	int insertPayment(CltPaymentDto pvo);
	CltPaymentDto selectPaymentOne(CltPaymentDto pvo);
	List<CltPaymentDto> selectPaymentList(CltPaymentDto pvo);
	CltPaymentDto ordNoSearch(String ordNo);
	
	int insertPayDtlInfo(CltPaymentDto pvo);
	CltPaymentDto selectPayDtlInfoOne(CltPaymentDto pvo);
	List<CltPaymentDto> selectPayDtlInfoList(CltPaymentDto pvo);
}