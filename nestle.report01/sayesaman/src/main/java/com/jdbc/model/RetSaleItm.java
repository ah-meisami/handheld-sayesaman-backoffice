package com.jdbc.model;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 10/9/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class RetSaleItm {
    private String id;

    private String retCauseRef;
    private String retCauseName;

    private String goodsRef;
    private String goodsCode;
    private String goodsName;
    private String unitName;

    private String totalQty;
    private String amountNut;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(String totalQty) {
        this.totalQty = totalQty;
    }

    public String getAmountNut() {
        return amountNut;
    }

    public void setAmountNut(String amountNut) {
        this.amountNut = amountNut;
    }
}
