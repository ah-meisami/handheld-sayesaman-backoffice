package org.sunich.dao;

import org.sunich.model.Bank;

import java.util.List;

public interface BankDAO {

    void insertBank(Bank bank);

    void updateBank(Bank bank);

    Bank getBankById(long bankId);

    void deleteBank(long bankId);

    Bank getBank(String bankname);

    List<Bank> getBanks();
}
