package com.jdbc.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 11/10/13
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cheque implements Serializable {
    private static final long serialVersionUID = 530407612837913746L;

    private String id;
    private String no;
    private String date;
    private String amount;
    private String bankRef;
    private String bankName;
    private String bankBranch;
    private String bankAccNo;
    private String custRef;
    private String custCode;
    private String custFirstName;
    private String custLastName;
    private String custRealName;
    private String saleOfficeRef;
    private String saleOfficeName;
    private String insUserRef;
    private String insUserName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankRef() {
        return bankRef;
    }

    public void setBankRef(String bankRef) {
        this.bankRef = bankRef;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getCustRef() {
        return custRef;
    }

    public void setCustRef(String custRef) {
        this.custRef = custRef;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustRealName() {
        return custRealName;
    }

    public void setCustRealName(String custRealName) {
        this.custRealName = custRealName;
    }

    public String getSaleOfficeRef() {
        return saleOfficeRef;
    }

    public void setSaleOfficeRef(String saleOfficeRef) {
        this.saleOfficeRef = saleOfficeRef;
    }

    public String getSaleOfficeName() {
        return saleOfficeName;
    }

    public void setSaleOfficeName(String saleOfficeName) {
        this.saleOfficeName = saleOfficeName;
    }

    public String getInsUserRef() {
        return insUserRef;
    }

    public void setInsUserRef(String insUserRef) {
        this.insUserRef = insUserRef;
    }

    public String getInsUserName() {
        return insUserName;
    }

    public void setInsUserName(String insUserName) {
        this.insUserName = insUserName;
    }
}
