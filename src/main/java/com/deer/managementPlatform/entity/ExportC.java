package com.deer.managementPlatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (ExportC)实体类
 *
 * @author makejava
 * @since 2020-10-08 19:26:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ExportC implements Serializable {
    private static final long serialVersionUID = -28396929440396864L;

    private String exportId;

    private Date inputDate;

    private String contractIds;

    private String customerContract;

    private String lcno;

    private String consignee;

    private String marks;

    private String shipmentPort;

    private String destinationPort;

    private String transportMode;

    private String priceCondition;

    private String remark;

    private int boxNum;

    private int cnumber;

    private String packingUnit;

    private Float grossWeight;

    private Float netWeight;

    private Float sizeLenght;

    private Float sizeWidth;

    private Float sizeHeight;

    private Float csize;

    private Float amount;

    private Float noTax;

    private Float tax;

    private Float costPrice;

    private Float costTax;

    private int state;

    private String inspector;

    private String createBy;

    private String createDept;

    private Date createTime;
    private String epnum;

    private String extnum;

    public void setExportId() {
    }
}