package com.jdbc.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 10/22/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class StockGoods implements Serializable {
    private static final long serialVersionUID = 530407612837913746L;

    private String id;
    private String goodsRef;
    private String goodsCode;
    private String goodsName;
    private String onHandQty;
    private boolean isBatch;

    public String getId() {
        return id;
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

    public String getOnHandQty() {
        return onHandQty;
    }

    public void setOnHandQty(String onHandQty) {
        this.onHandQty = onHandQty;
    }

    public boolean isBatch() {
        return isBatch;
    }

    public void setBatch(boolean batch) {
        isBatch = batch;
    }
}
