package com.adogo.ad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdPostController {
	
	@RequestMapping("/ad/adPostCreate")
	public String gotoAdPost(){
		String viewName = "adogo/ad_post";
		return viewName;
	}
}
