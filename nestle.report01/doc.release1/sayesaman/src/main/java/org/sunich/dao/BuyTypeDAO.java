package org.sunich.dao;

import org.sunich.model.BuyType;

import java.util.List;

public interface BuyTypeDAO {

	void insertBuyType(BuyType buyType);
	
	BuyType getBuyTypeById(int buyTypeId);
	
	BuyType getBuyType(String buyTypename);
	
    List<BuyType> getBuyTypes();
}
