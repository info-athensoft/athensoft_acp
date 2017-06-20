package com.athensoft.crm.customer.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athensoft.crm.customer.entity.BillToContact;
import com.athensoft.crm.customer.service.BillToContactService;

@Controller
public class BillToContactController {
	
	private static final Logger logger = Logger.getLogger(BillToContactController.class);
	
	private BillToContactService billToContactService;
	
	@Autowired
	public void setBillToContactService(BillToContactService billToContactService) {
		this.billToContactService = billToContactService;
	}
	
	@RequestMapping(value="/crm/billtoContactListData",produces="application/json")
	@ResponseBody
	public Map<String,Object> getDataBilltoContactList(){
		logger.info("entering /crm/billtoContactListData");
		
		ModelAndView mav = new ModelAndView();
		
		//data
		List<BillToContact> listBillToContact = billToContactService.getAllBillToContact();
		logger.info("Length of news entries: "+ listBillToContact.size());
		
		String[][] data = getData(listBillToContact);
		
		Map<String, Object> model = mav.getModel();
		
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus","OK");
		model.put("customActionMessage","Data loaded");
		
		logger.info("leaving /crm/billtoContactListData");
		return model;
	}
	
	private String[][] getData(List<BillToContact> listEntries){
		int entryLength = listEntries.size();
		final int COLUMN_NUM = 14;
		String[][] data = new String[entryLength][COLUMN_NUM];
		
		String field0 = "";	//check box
		String field1 = "";	//customer_id
		String field2 = "";	//contact id, global_id
		String field3 = "";	//contact_no
		String field4 = "";	//entity_name
		String field5 = "";	//tel_num
		String field6 = "";	//cell_num
		String field7 = "";	//fax_num
		String field8 = "";	//email_num
		String field9 = ""; //street_no+street_type+street_name+unit_type+unit_no
		String field10 = ""; //city
		String field11 = ""; //province
		String field12 = ""; //postal_code
		String field13 = ""; //action

		
		for(int i=0; i<entryLength ; i++){
			
			BillToContact x = listEntries.get(i);
			
			field0 = "<input type='checkbox' name='id[]' value="+x.getContactId()+">";
			field1 = x.getCustomerId()+"";
			field2 = x.getContactId()+"";
			field3 = x.getContactNo();
			field4 = x.getBilltoName();
			field5 = x.getTelNum();
			field6 = x.getCellNum();
			field7 = x.getFaxNum();
			field8 = x.getEmail();
			
			StringBuffer sbf = new StringBuffer();
			
			String streetNum = x.getBilltoAddr().getStreetNum();
			String streetType = x.getBilltoAddr().getStreetType();
			String streetName = x.getBilltoAddr().getStreetName();
			String unitType = x.getBilltoAddr().getUnitType();
			String unitNo = x.getBilltoAddr().getRoomNum();
			
			sbf.append(streetNum);
			sbf.append(" ");
			sbf.append(streetType);
			sbf.append(" ");
			sbf.append(streetName);
			sbf.append(" ");
			sbf.append(streetName);
			sbf.append(" ");
			sbf.append(unitType);
			sbf.append(" ");
			sbf.append(unitNo);
			
			field9 = sbf.toString();
			field10 = x.getBilltoAddr().getCityCode();
			field11 = x.getBilltoAddr().getProvinceCode();
			field12 = x.getBilltoAddr().getPostalCode();
			
			field13 = "<a href='#' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> "+"ACTION"+"</a>";
			
			
			data[i][0] = field0;
			data[i][1] = field1;
			data[i][2] = field2;
			data[i][3] = field3;
			data[i][4] = field4;
			data[i][5] = field5;
			data[i][6] = field6;
			data[i][7] = field7;
			data[i][8] = field8;
			data[i][9] = field9;
			data[i][10] = field10;
			data[i][11] = field11;
			data[i][12] = field12;
			data[i][13] = field13;
		}
		
		return data;
	}
}
