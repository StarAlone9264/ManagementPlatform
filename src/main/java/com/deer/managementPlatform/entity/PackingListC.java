package com.deer.managementPlatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (PackingListC)实体类
 *
 * @author makejava
 * @since 2020-10-11 19:42:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class PackingListC implements Serializable {
    private static final long serialVersionUID = -76958067597808127L;

    private String packingListId;

    private String exportId;

    private String seller;//卖方

    private String buyer;//买方

    private String invoiceNo;//发票号

    private Date invoiceDate;//发票日期

    private String marks;//

    private String descriptions;//描述
    private String exportIds;//存储报运的id串
    private String exportNos;//存储报运号
    private int state;//状态
    private String createBy;

    private String createDept;

    private Date createTime;
}