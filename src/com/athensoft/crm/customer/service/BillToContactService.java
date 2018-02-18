package com.athensoft.crm.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.athensoft.crm.customer.dao.BillToContactDao;
import com.athensoft.crm.customer.entity.BillToContact;

@Service
public class BillToContactService {
	@Autowired
	@Qualifier("billToContactDaoJDBCImpl")
	private BillToContactDao billToContactDao;

	public void setBillToContactDao(BillToContactDao billToContactDao) {
		this.billToContactDao = billToContactDao;
	}
	
	public List<BillToContact> getAllBillToContact(){
		return billToContactDao.findAll();
	}
}
