package com.deer.managementPlatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ContractC {
    private String contractId;
    private List<ContractProductC> contractProducts;		//货物的集合
    private String offeror;
    private String contractNo;
    private Date signingDate;
    private String inputBy;
    private String checkBy;
    private String inspector;
    private float totalAmount;
    private String request;
    private String customName;
    private Date shipTime;
    private int importNum;
    private Date deliveryPeriod;
    private String remark;
    private String printStyle;
    private int oldState;
    private int state;
    private int outState;
    private String createBy;
    private String createDept;
    private Date createTime;
    private String cpnum;
    private String extnum;
    private String total_amount;
    private ContractProductC contractProductC;

}
