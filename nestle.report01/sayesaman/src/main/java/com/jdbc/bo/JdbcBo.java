package com.jdbc.bo;

import com.jdbc.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/17/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public interface JdbcBo {
    public List<Personnel> getPersonnel(String personnelRef, String supervisorRef, String dCRef, String personnelTypeRef);

    public List<AccYear> getAccYear();

    public List<Dc> getDc(boolean withRedbull);

    public List<SalePath> getSalePath(String DcRef, String SaleZoneRef, String SaleAreaRef, String SalePathRef);

    public List<Customer> getCustomer(String DcRef, String SalePathRef);

    public List<SaleHdr> getSaleHdr(String AccYear, String CustRef);

    public List<SaleItm> getSaleItm(String HdrRef);

    public List<SalePay> getSalePay(String HdrRef);

    public List<RetSaleHdr> getRetSaleHdr(String AccYear, String CustRef);

    public List<RetSaleItm> getRetSaleItm(String HdrRef);

    public boolean setCustomer(String CustRef, String Pelak, String NationalCode);

    public List<VocherHdr> getVocherHdr(String dc, String accYear, String rows, String page, String sidx, String sord);

    public List<StockDc> getStockDC(String AccYear, String DcRef);

    public List<GoodsGroup> getStockGoodsGroup(String AccYear, String StockDCRef);

    public List<StockGoods> getStockGoods(String AccYear, String StockDCRef);

    public List<StockGoods> getStockGoodsByGoodsGroup(String AccYear, String StockDCRef, String GoodsGroupRef);

    public List<StockGoodsDetail> getStockGoodsDetail(String HdrRef);

    //=======================================================
    public List<Cheque> getAll(String accYear, String dcRef, String insertDate);

    public boolean remove(String id);
    //=======================================================
}
