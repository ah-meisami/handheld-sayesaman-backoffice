package com.jdbc.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 10/26/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class GoodsGroup implements Serializable {
    private static final long serialVersionUID = 530407612837913746L;
    String id;
    String name;
    String qty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
