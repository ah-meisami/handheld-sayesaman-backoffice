package com.jdbc.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/17/13
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Personnel implements Serializable {
    private static final long serialVersionUID = 530407612837913746L;

    String ID;
    String PersonnelName;
    String PersonnelPhone;
    byte[] PersonnelImage;
    String PersonnelCode;
    String PersonnelIMEI;
    String PersonnelRef;
    String PersonnelPosition;
    String IsSupervisor;
    String CartRef;
    String V_SaleZoneRef;
    String V_SaleZoneName;
    String V_SaleAreaRef;
    String V_SaleAreaName;
    String V_DealerRef;
    String V_DealerName;
    String V_DCRef;
    String V_DCName;
    String V_SaleOfficeRef;
    String V_SaleOfficeName;
    String V_StockDCRef;
    String V_StockDCName;
    String V_DCSaleOfficeRef;
    String V_CustLevelRef;
    String V_CustLevelName;
    String Type;

    public String getID() {
        return ID;
    }

    public byte[] getPersonnelImage() {
        return PersonnelImage;
    }

    public void setPersonnelImage(byte[] personnelImage) {
        PersonnelImage = personnelImage;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPersonnelName() {
        return PersonnelName;
    }

    public void setPersonnelName(String personnelName) {
        PersonnelName = personnelName;
    }

    public String getPersonnelPhone() {
        return PersonnelPhone;
    }

    public void setPersonnelPhone(String personnelPhone) {
        PersonnelPhone = personnelPhone;
    }

    public String getPersonnelCode() {
        return PersonnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        PersonnelCode = personnelCode;
    }

    public String getPersonnelIMEI() {
        return PersonnelIMEI;
    }

    public void setPersonnelIMEI(String personnelIMEI) {
        PersonnelIMEI = personnelIMEI;
    }

    public String getPersonnelRef() {
        return PersonnelRef;
    }

    public void setPersonnelRef(String personnelRef) {
        PersonnelRef = personnelRef;
    }

    public String getPersonnelPosition() {
        return PersonnelPosition;
    }

    public void setPersonnelPosition(String personnelPosition) {
        PersonnelPosition = personnelPosition;
    }

    public String getIsSupervisor() {
        return IsSupervisor;
    }

    public void setIsSupervisor(String isSupervisor) {
        IsSupervisor = isSupervisor;
    }

    public String getCartRef() {
        return CartRef;
    }

    public void setCartRef(String cartRef) {
        CartRef = cartRef;
    }

    public String getV_SaleZoneRef() {
        return V_SaleZoneRef;
    }

    public void setV_SaleZoneRef(String v_SaleZoneRef) {
        V_SaleZoneRef = v_SaleZoneRef;
    }

    public String getV_SaleZoneName() {
        return V_SaleZoneName;
    }

    public void setV_SaleZoneName(String v_SaleZoneName) {
        V_SaleZoneName = v_SaleZoneName;
    }

    public String getV_SaleAreaRef() {
        return V_SaleAreaRef;
    }

    public void setV_SaleAreaRef(String v_SaleAreaRef) {
        V_SaleAreaRef = v_SaleAreaRef;
    }

    public String getV_SaleAreaName() {
        return V_SaleAreaName;
    }

    public void setV_SaleAreaName(String v_SaleAreaName) {
        V_SaleAreaName = v_SaleAreaName;
    }

    public String getV_DealerRef() {
        return V_DealerRef;
    }

    public void setV_DealerRef(String v_DealerRef) {
        V_DealerRef = v_DealerRef;
    }

    public String getV_DealerName() {
        return V_DealerName;
    }

    public void setV_DealerName(String v_DealerName) {
        V_DealerName = v_DealerName;
    }

    public String getV_DCRef() {
        return V_DCRef;
    }

    public void setV_DCRef(String v_DCRef) {
        V_DCRef = v_DCRef;
    }

    public String getV_DCName() {
        return V_DCName;
    }

    public void setV_DCName(String v_DCName) {
        V_DCName = v_DCName;
    }

    public String getV_SaleOfficeRef() {
        return V_SaleOfficeRef;
    }

    public void setV_SaleOfficeRef(String v_SaleOfficeRef) {
        V_SaleOfficeRef = v_SaleOfficeRef;
    }

    public String getV_SaleOfficeName() {
        return V_SaleOfficeName;
    }

    public void setV_SaleOfficeName(String v_SaleOfficeName) {
        V_SaleOfficeName = v_SaleOfficeName;
    }

    public String getV_StockDCRef() {
        return V_StockDCRef;
    }

    public void setV_StockDCRef(String v_StockDCRef) {
        V_StockDCRef = v_StockDCRef;
    }

    public String getV_StockDCName() {
        return V_StockDCName;
    }

    public void setV_StockDCName(String v_StockDCName) {
        V_StockDCName = v_StockDCName;
    }

    public String getV_DCSaleOfficeRef() {
        return V_DCSaleOfficeRef;
    }

    public void setV_DCSaleOfficeRef(String v_DCSaleOfficeRef) {
        V_DCSaleOfficeRef = v_DCSaleOfficeRef;
    }

    public String getV_CustLevelRef() {
        return V_CustLevelRef;
    }

    public void setV_CustLevelRef(String v_CustLevelRef) {
        V_CustLevelRef = v_CustLevelRef;
    }

    public String getV_CustLevelName() {
        return V_CustLevelName;
    }

    public void setV_CustLevelName(String v_CustLevelName) {
        V_CustLevelName = v_CustLevelName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
