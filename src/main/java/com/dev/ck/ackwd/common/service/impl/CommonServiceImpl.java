package com.dev.ck.ackwd.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.ackwd.common.service.CommonMapper;
import com.dev.ck.ackwd.common.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired private CommonMapper commonMapper;

}
