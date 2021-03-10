package org.sunich.bo;

import org.sunich.model.BuyType;

import java.util.List;

public interface BuyTypeBO {

	void insertBuyType(BuyType buyType);
	
	BuyType getBuyTypeById(int buyTypeId);
	
	BuyType getBuyType(String buyTypename);
	
	List<BuyType> getBuyTypes();
}
