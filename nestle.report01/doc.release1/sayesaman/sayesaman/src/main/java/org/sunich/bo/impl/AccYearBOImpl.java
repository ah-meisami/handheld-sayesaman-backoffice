package org.sunich.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunich.bo.AccYearBO;
import org.sunich.bo.BankBO;
import org.sunich.dao.AccYearDAO;
import org.sunich.dao.BankDAO;
import org.sunich.model.AccYear;
import org.sunich.model.Bank;

import java.util.List;

@Service
public class AccYearBOImpl implements AccYearBO {

	@Autowired
	private AccYearDAO accYearDAO;
	

    @Override
    @Transactional(value = "transactionManager1")
    public List<AccYear> getAll() {
        return accYearDAO.getAll();
    }
}
