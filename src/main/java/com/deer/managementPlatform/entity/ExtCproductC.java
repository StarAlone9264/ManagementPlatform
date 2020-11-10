package com.deer.managementPlatform.entity;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (ExtCproductC)实体类
 *
 * @author makejava
 * @since 2020-09-22 22:43:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ExtCproductC implements Serializable {
    private static final long serialVersionUID = 248085637657836690L;

    private String extCproductId;

    private String factoryId;

    private String contractProductId;

    private Integer ctype;

    private String productName;

    private String productNo;

    private String productImage;

    private String productDesc;

    private String loadingRate;

    private String packingUnit;

    private Integer cnumber;

    private Integer outNumber;

    private String finished;

    private Float grossWeight;

    private Float netWeight;

    private Float sizeLenght;

    private Float sizeWidth;

    private Float sizeHeight;

    private String productRequest;

    private String factory;

    private Float price;

    private Float amount;

    private String cunit;

    private Integer boxNum;

    private Float exPrice;

    private String exUnit;

    private Float noTax;

    private Float tax;

    private Float costPrice;

    private Float costTax;

    private String accessories;

    private Integer orderNo;

    private FactoryC factoryC;

    private ContractProductC contractProductC;

}