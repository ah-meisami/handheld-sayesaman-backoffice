package com.jdbc.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 10/22/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class StockGoodsDetail implements Serializable {
    private static final long serialVersionUID = 530407612837913746L;

    String id;
    String batchRef;
    String batchNo;
    String batchExpDate;
    String onHandQty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatchRef() {
        return batchRef;
    }

    public void setBatchRef(String batchRef) {
        this.batchRef = batchRef;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getBatchExpDate() {
        return batchExpDate;
    }

    public void setBatchExpDate(String batchExpDate) {
        this.batchExpDate = batchExpDate;
    }

    public String getOnHandQty() {
        return onHandQty;
    }

    public void setOnHandQty(String onHandQty) {
        this.onHandQty = onHandQty;
    }
}
