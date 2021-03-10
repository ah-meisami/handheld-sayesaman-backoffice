package com.jdbc.model;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 10/9/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {
    private String id;
    private String code;
    private String firstName;
    private String lastName;
    private String realName;
    private String phone;
    private String mobile;
    private String address;
    private String custLevelRef;
    private String custLevelName;
    private String pelak;
    private String nationalCode;

    public String getPelak() {
        return pelak;
    }

    public void setPelak(String pelak) {
        this.pelak = pelak;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustLevelRef() {
        return custLevelRef;
    }

    public void setCustLevelRef(String custLevelRef) {
        this.custLevelRef = custLevelRef;
    }

    public String getCustLevelName() {
        return custLevelName;
    }

    public void setCustLevelName(String custLevelName) {
        this.custLevelName = custLevelName;
    }
}
