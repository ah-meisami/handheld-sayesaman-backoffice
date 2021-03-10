package com.jdbc.model;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 10/9/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class RetSaleHdr {
    private String id;
    private String retSaleNo;
    private String retSaleDate;

    private String drealerRef;
    private String dealerCode;
    private String dealerName;

    private String totalAmount;

    private String userRef;
    private String userName;

    public String getDrealerRef() {
        return drealerRef;
    }

    public void setDrealerRef(String drealerRef) {
        this.drealerRef = drealerRef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRetSaleNo() {
        return retSaleNo;
    }

    public void setRetSaleNo(String retSaleNo) {
        this.retSaleNo = retSaleNo;
    }

    public String getRetSaleDate() {
        return retSaleDate;
    }

    public void setRetSaleDate(String retSaleDate) {
        this.retSaleDate = retSaleDate;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(String userRef) {
        this.userRef = userRef;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
