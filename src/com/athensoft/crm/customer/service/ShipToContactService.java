package com.athensoft.crm.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.athensoft.crm.customer.dao.ShipToContactDao;
import com.athensoft.crm.customer.entity.ShipToContact;

@Service
public class ShipToContactService {
	@Autowired
	@Qualifier("shipToContactDaoJDBCImpl")
	private ShipToContactDao shipToContactDao;

	public void setShipToContactDao(ShipToContactDao shipToContactDao) {
		this.shipToContactDao = shipToContactDao;
	}
	
	public List<ShipToContact> getAllShipToContact(){
		return shipToContactDao.findAll();
	}
}
