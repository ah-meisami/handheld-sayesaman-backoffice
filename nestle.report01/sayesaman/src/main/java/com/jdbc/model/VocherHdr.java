package com.jdbc.model;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 7/24/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class VocherHdr {
    String vocherNo;
    String vocherDate;

    String stockDCName1;
    String StockDCName2;

    String goodsRef;
    String goodsCode;
    String goodsName;
    double unitQty;
    String cartonType;
    int qty;

    String batchNo;
    int totalQty;

    public String getStockDCName1() {
        return stockDCName1;
    }

    public void setStockDCName1(String stockDCName1) {
        this.stockDCName1 = stockDCName1;
    }

    public String getStockDCName2() {
        return StockDCName2;
    }

    public void setStockDCName2(String stockDCName2) {
        StockDCName2 = stockDCName2;
    }

    public String getVocherNo() {
        return vocherNo;
    }

    public void setVocherNo(String vocherNo) {
        this.vocherNo = vocherNo;
    }

    public String getVocherDate() {
        return vocherDate;
    }

    public void setVocherDate(String vocherDate) {
        this.vocherDate = vocherDate;
    }


    public String getGoodsRef() {
        return goodsRef;
    }

    public void setGoodsRef(String goodsRef) {
        this.goodsRef = goodsRef;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCartonType() {
        return cartonType;
    }

    public void setCartonType(String cartonType) {
        this.cartonType = cartonType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public double getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(double unitQty) {
        this.unitQty = unitQty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }
}
