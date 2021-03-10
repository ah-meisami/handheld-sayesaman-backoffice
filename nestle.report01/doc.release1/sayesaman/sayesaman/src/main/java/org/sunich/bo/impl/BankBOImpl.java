package org.sunich.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunich.bo.BankBO;
import org.sunich.dao.BankDAO;
import org.sunich.model.Bank;

import java.util.List;

@Service
public class BankBOImpl implements BankBO {

	@Autowired
	private BankDAO bankDAO;
	
	@Override
	@Transactional(value = "transactionManager1")
	public void insertBank(Bank bank) {
		bankDAO.insertBank(bank);
	}

    @Override
    @Transactional(value = "transactionManager1")
    public void updateBank(Bank bank) {
        bankDAO.updateBank(bank);
    }

    @Override
    @Transactional(value = "transactionManager1")
	public Bank getBankById(long bankId) {
		return bankDAO.getBankById(bankId);
	}

    @Override
    @Transactional(value = "transactionManager1")
    public void deleteBank(long bankId) {
        bankDAO.deleteBank(bankId);
    }

    @Override
    @Transactional(value = "transactionManager1")
	public Bank getBank(String bankname) {
		return bankDAO.getBank(bankname);
	}

	@Override
    @Transactional(value = "transactionManager1")
	public List<Bank> getBanks() {
		return bankDAO.getBanks();
	}

}
