package com.deer.managementPlatform.entity;

import java.util.Date;

/**
 * @author wangt
 */
public class FactoryC {

    private String factoryId;
    private String fullName;
    private String factoryName;
    private String contactor;
    private String phone;
    private String mobile;
    private String fax;
    private String cNote;
    private int cType;
    private String state;
    private String inspector;
    private int orderNo;
    private String createBy;
    private String createDept;
    private Date createTime;

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getcNote() {
        return cNote;
    }

    public void setcNote(String cNote) {
        this.cNote = cNote;
    }

    public int getcType() {
        return cType;
    }

    public void setcType(int cType) {
        this.cType = cType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FactoryC{" +
                "factoryId='" + factoryId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", contactor='" + contactor + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", fax='" + fax + '\'' +
                ", cNote='" + cNote + '\'' +
                ", cType=" + cType +
                ", state='" + state + '\'' +
                ", inspector='" + inspector + '\'' +
                ", orderNo=" + orderNo +
                ", createBy='" + createBy + '\'' +
                ", createDept='" + createDept + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
