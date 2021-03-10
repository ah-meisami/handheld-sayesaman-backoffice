package com.jdbc.bo.impl;

import com.jdbc.bo.JdbcBo;
import com.jdbc.dao.JdbcDao;
import com.jdbc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/17/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class JdbcBoImpl implements JdbcBo {

    @Autowired
    private JdbcDao jdbcDao;

    @Override
    @Transactional(value = "transactionManager1")
    public List<Personnel> getPersonnel(String personnelRef, String supervisorRef, String dCRef, String personnelTypeRef) {
        return jdbcDao.getPersonnel(personnelRef, supervisorRef, dCRef, personnelTypeRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<AccYear> getAccYear() {
        return jdbcDao.getAccYear();
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<Dc> getDc(boolean withRedbull) {
        return jdbcDao.getDc(withRedbull);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<SalePath> getSalePath(String DcRef, String SaleZoneRef, String SaleAreaRef, String SalePathRef) {
        return jdbcDao.getSalePath(DcRef, SaleZoneRef, SaleAreaRef, SalePathRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<Customer> getCustomer(String DcRef, String SalePathRef) {
        return jdbcDao.getCustomer(DcRef, SalePathRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<SaleHdr> getSaleHdr(String AccYear, String CustRef) {
        return jdbcDao.getSaleHdr(AccYear, CustRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<SaleItm> getSaleItm(String HdrRef) {
        return jdbcDao.getSaleItm(HdrRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<SalePay> getSalePay(String HdrRef) {
        return jdbcDao.getSalePay(HdrRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<RetSaleHdr> getRetSaleHdr(String AccYear, String CustRef) {
        return jdbcDao.getRetSaleHdr(AccYear, CustRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<RetSaleItm> getRetSaleItm(String HdrRef) {
        return jdbcDao.getRetSaleItm(HdrRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public boolean setCustomer(String CustRef, String Pelak, String NationalCode) {
        return jdbcDao.setCustomer(CustRef, Pelak, NationalCode);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<VocherHdr> getVocherHdr(String dc, String accYear, String rows, String page, String sidx, String sord) {
        return jdbcDao.getVocherHdr(dc, accYear, rows, page, sidx, sord);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<StockDc> getStockDC(String AccYear, String DcRef) {
        return jdbcDao.getStockDC(AccYear, DcRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<GoodsGroup> getStockGoodsGroup(String AccYear, String StockDCRef) {
        return jdbcDao.getStockGoodsGroup(AccYear, StockDCRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<StockGoods> getStockGoods(String AccYear, String StockDCRef) {
        return jdbcDao.getStockGoods(AccYear, StockDCRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<StockGoods> getStockGoodsByGoodsGroup(String AccYear, String StockDCRef, String GoodsGroupRef) {
        return jdbcDao.getStockGoodsByGoodsGroup(AccYear, StockDCRef, GoodsGroupRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<StockGoodsDetail> getStockGoodsDetail(String HdrRef) {
        return jdbcDao.getStockGoodsDetail(HdrRef);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public boolean remove(String id) {
        return jdbcDao.remove(id);
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<Cheque> getAll(String accYear, String dcRef, String insertDate) {
        return jdbcDao.getAll(accYear, dcRef, insertDate);
    }
}