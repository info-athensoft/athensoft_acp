package com.athensoft.crm.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerAcpController {
	/**
	 * go to the view of CRM dashboard
	 * @return the target view name
	 */
	@RequestMapping(value="/crm/dashboard")
	public String gotoDashboard(){
		String viewName = "crm/crm_dashborad";
		return viewName;
	}
	
	/**
	 * go to the view of customer contact listing
	 * @return the target view name 
	 */
	@RequestMapping(value="/crm/customerContactList")
	public String gotoNewsList(){
		String viewName = "crm/customer_contact_list";
		return viewName;
	}
	
	@RequestMapping(value="/crm/billtoContactList")
	public String gotoBilltoContactList(){
		String viewName = "crm/billto_contact_list";
		return viewName;
	}
	
	@RequestMapping(value="/crm/shiptoContactList")
	public String gotoShiptoContactList(){
		String viewName = "crm/shipto_contact_list";
		return viewName;
	}
}
