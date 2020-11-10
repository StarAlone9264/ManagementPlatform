package com.deer.managementPlatform.service.impl;

import com.deer.managementPlatform.dao.*;
import com.deer.managementPlatform.entity.*;
import com.deer.managementPlatform.service.ExportCService;
import com.deer.managementPlatform.util.UUIDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("ExportCService")
public class ExportCServiceImpl implements ExportCService {
    @Resource
    private ExportCMapper exportCMapper;
    @Resource
    private ContractCMapper contractCMapper;
    @Resource
    private ExportProductCMapper exportProductCMapper;
    @Resource
    private ExtEproductCMapper extEproductCMapper;
    @Resource
    private ContractProductCMapper contractProductCMapper;
    @Resource
    private  ExtCproductCMapper  extCproductCMapper;
    @Override
    public List<ExportC> findAll() {
        return exportCMapper.findAll();
    }
    /*
     * 步骤：
     * 1、根据合同id获得合同对象，获取合同号
     * 2、将合同下的货物信息搬家到报运下的货物表中
     * 3、将合同下的附件信息搬家到报运下的附件表中
     */
    @Override
    public int add(String[] contractIds) {
        //拼接合同号，报运号
        String contractNos = "";
        for (String contractId : contractIds) {
            ContractC contract = contractCMapper.view(contractId);
            if (contract==null){
                System.err.println("合同null----");
            }
            //以空格作为分隔符
            contractNos += contract.getContractNo() + " ";
        }
        //工具类，删除最后一个字符
//        contractNos = UtilFuns.delLastChar(contractNos);
        if(contractNos!=null&&contractNos!="") {
            contractNos=contractNos.substring(0,contractNos.length()-1); //利用截取功能
        }

        ExportC exportc = new ExportC();
//        export.setId(UUID.randomUUID().toString());
//        exportc.setExportId(exportc.getExportId());
        //工具类，拼串
//        exportc.setContractIds(UtilFuns.joinStr(contractIds, ","));
        for (String ids : contractIds) {
            if(ids !=null){
                ids += contractIds.toString() + ";";
                exportc.setExportId(ids);
            }
        }
        exportc.setExportId(UUIDUtils.getUUID().toString());
        exportc.setCustomerContract(contractNos);
        //0草稿
        exportc.setState(0);
        exportCMapper.add(exportc);
        for (String contractId : contractIds) {
            /*ContractC contract = contractCMapper.view(contractId);
            if (contract==null){
                System.err.println("contract为null----");
            }*/
//           根据合同id查询货物
             List<ContractProductC> conProList = contractProductCMapper.findAll(contractId);
            System.err.println(conProList);
            for (ContractProductC cp : conProList) {
                if (cp==null){
                    System.err.println("cp为null----");
                }
                ExportProductC ep = new ExportProductC();
                ep.setExportProductId(UUIDUtils.getUUID().toString());
                ep.setExportId(exportc.getExportId().toString());                    //绑定外键
                //数据搬家，将合同下的对应的货物信息写入到报运下的货物信息中
                ep.setFactoryId(cp.getFactoryC().getFactoryId());
                ep.setContractId(cp.getContractId());
//                ep.setContractNo(cp.getcon);
//                ep.setProductName(cp.getFactoryC().getFactoryName());
                ep.setProductNo(cp.getProductNo());
                ep.setPackingUnit(cp.getPackingUnit());
                ep.setCnumber(cp.getCnumber());
                ep.setBoxNum(cp.getBoxNum());
                ep.setPrice(cp.getPrice());
//                #{contractProductId}, #{exportId}, #{factoryId}, #{contractId}, #{contractNo}, #{productName}, #{productNo}, #{productImage}, #{productDesc}, #{loadingRate}, #{packingUnit}, #{cnumber}, #{outNumber}, #{finished}, #{grossWeight}, #{netWeight}, #{sizeLenght}, #{sizeWidth}, #{sizeHeight}, #{productRequest}, #{factory}, #{price}, #{amount}, #{cunit}, #{boxNum}, #{exPrice}, #{exUnit}, #{noTax}, #{tax}, #{costPrice}, #{costTax}, #{accessories}, #{orderNo})

                if (ep==null){
                    System.err.println("ep为null----");
                }
                System.err.println(ep.toString());
                exportProductCMapper.insert(ep);
//                根据货物id查询附件
//                List<ExtCproductC> extCproducts = cp.getExtCproductC();
                 List<ExtCproductC> extCproductCList = extCproductCMapper.findAll(cp.getContractProductId());
                //处理附件信息
                for (ExtCproductC extcp : extCproductCList) {
                    ExtEproductC extep = new ExtEproductC();
                    //copyProperties spring
                    BeanUtils.copyProperties(extcp, extep);        //spring工具类，数据的拷贝

                    extep.setExtEproductId(UUIDUtils.getUUID().toString());
                    extep.setExportProductId(ep.getExportProductId());        //绑定外键

                    extep.setFactoryId(extcp.getFactoryC().getFactoryId());
                    extep.setProductName(extcp.getFactoryC().getFactoryName());

                    extEproductCMapper.insert(extep);
                }

            }
        }

        return 0;
    }

    @Override
    public ExportC findById(String id) {
        return exportCMapper.findById(id);
    }

    /*@Override
    public String deleteall(Map map){
        if (contractCMapper.deleteall(map) > 0){
            return "success";
        }
        return "error";
    }*/
    @Override
    public String deleteall(Map map){
        if (contractCMapper.deleteall(map) > 0){
            return "success";
        }
        return "error";
    }
}
