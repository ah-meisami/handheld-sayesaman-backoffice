package org.sunich.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunich.bo.BuyTypeBO;
import org.sunich.dao.BuyTypeDAO;
import org.sunich.model.BuyType;

import java.util.List;

@Service
public class BuyTypeBOImpl implements BuyTypeBO {

	@Autowired
	private BuyTypeDAO buyTypeDAO;
	
	@Override
    @Transactional(value = "transactionManager1")
	public void insertBuyType(BuyType buyType) {
		buyTypeDAO.insertBuyType(buyType);
	}

	@Override
    @Transactional(value = "transactionManager1")
	public BuyType getBuyTypeById(int buyTypeId) {
		return buyTypeDAO.getBuyTypeById(buyTypeId);
	}
	
	@Override
    @Transactional(value = "transactionManager1")
	public BuyType getBuyType(String buyTypename) {
		return buyTypeDAO.getBuyType(buyTypename);
	}

	@Override
    @Transactional(value = "transactionManager1")
	public List<BuyType> getBuyTypes() {
		return buyTypeDAO.getBuyTypes();
	}

}
