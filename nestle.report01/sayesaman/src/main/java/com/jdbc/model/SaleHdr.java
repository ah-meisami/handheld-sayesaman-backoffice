package com.jdbc.model;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 10/9/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaleHdr {
    private String id;
    private String saleDate;
    private String saleVoucherNo;
    private String saleNo;
    private String totalAmount;

    private String dealerName;
    private String distributerName;
    private String driverName;

    private String retCauseRef;
    private String retCauseName;

    public String getRetCauseRef() {
        return retCauseRef;
    }

    public void setRetCauseRef(String retCauseRef) {
        this.retCauseRef = retCauseRef;
    }

    public String getRetCauseName() {
        return retCauseName;
    }

    public void setRetCauseName(String retCauseName) {
        this.retCauseName = retCauseName;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDistributerName() {
        return distributerName;
    }

    public void setDistributerName(String distributerName) {
        this.distributerName = distributerName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getSaleVoucherNo() {
        return saleVoucherNo;
    }

    public void setSaleVoucherNo(String saleVoucherNo) {
        this.saleVoucherNo = saleVoucherNo;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
