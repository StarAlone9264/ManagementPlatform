package com.deer.managementPlatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (ExportProductC)实体类
 *
 * @author makejava
 * @since 2020-10-10 14:30:09
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ExportProductC implements Serializable {
    private static final long serialVersionUID = -21228052040200695L;

    private String exportProductId;

    private String contractProductId;

    private String exportId;

    private String factoryId;

    private String contractId;

    private String contractNo;

    private String productName;

    private String productNo;

    private String productImage;

    private String productDesc;

    private String loadingRate;

    private String packingUnit;

    private int cnumber;

    private int outNumber;

    private int finished;

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

    private int boxNum;

    private Float exPrice;

    private String exUnit;

    private Float noTax;

    private Float tax;

    private Float costPrice;

    private Float costTax;

    private int accessories;

    private int orderNo;
}