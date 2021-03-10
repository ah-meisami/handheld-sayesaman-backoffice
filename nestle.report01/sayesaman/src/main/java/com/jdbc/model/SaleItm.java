package com.jdbc.model;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 10/9/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaleItm {
    private String id;
    private String goodsRef;
    private String goodsCode;
    private String goodsName;
    private String amountNut;
    private String unitQty;
    private String totalQty;

    public String getId() {
        return id;
    }

    public String getAmountNut() {
        return amountNut;
    }

    public void setAmountNut(String amountNut) {
        this.amountNut = amountNut;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(String unitQty) {
        this.unitQty = unitQty;
    }

    public String getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(String totalQty) {
        this.totalQty = totalQty;
    }
}
