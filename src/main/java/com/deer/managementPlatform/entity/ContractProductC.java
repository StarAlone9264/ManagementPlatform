package com.deer.managementPlatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (ContractProductC)实体类
 *
 * @author makejava
 * @since 2020-09-23 15:42:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContractProductC implements Serializable {
    private static final long serialVersionUID = 734889186786073958L;
    
    private String contractProductId;
    
    private String contractId;
    
    private String factoryId;
    
    private String productName;
    
    private String productNo;
    
    private String productImage;
    
    private String productDesc;
    
    private String loadingRate;
    
    private String packingUnit;
    
    private int cnumber;
    
    private int outNumber;
    
    private String finished;
    
    private float grossWeight;
    
    private float netWeight;
    
    private float sizeLenght;
    
    private float sizeWidth;
    
    private float sizeHeight;
    
    private String productRequest;
    
    private String factory;
    
    private float price;
    
    private float amount;
    
    private String cunit;
    
    private int boxNum;
    
    private float exPrice;
    
    private String exUnit;
    
    private float noTax;
    
    private float tax;
    
    private float costPrice;
    
    private float costTax;
    
    private String accessories;
    
    private int orderNo;
    private  FactoryC  factoryC;
    private ContractC contract;		//将复杂的关联关系变成单表操作
    private List<ExtCproductC> extCproductC;		//和附件一对多

}