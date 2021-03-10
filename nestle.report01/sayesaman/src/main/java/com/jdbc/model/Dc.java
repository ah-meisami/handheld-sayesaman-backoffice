package com.jdbc.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/17/13
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dc implements Serializable {
    private static final long serialVersionUID = 530407612837913746L;

    String id;
    String name;

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
}
