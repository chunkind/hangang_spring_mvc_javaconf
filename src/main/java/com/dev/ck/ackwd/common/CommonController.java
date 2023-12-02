package com.dev.ck.ackwd.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dev.ck.ackwd.common.service.CommonService;

@Controller
public class CommonController {
	@Autowired private CommonService commonService;
	
	
}
