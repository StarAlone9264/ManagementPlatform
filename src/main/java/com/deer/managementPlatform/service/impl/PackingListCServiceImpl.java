package com.deer.managementPlatform.service.impl;

import com.deer.managementPlatform.dao.ExportCMapper;
import com.deer.managementPlatform.dao.PackingListCMapper;
import com.deer.managementPlatform.entity.ExportC;
import com.deer.managementPlatform.entity.PackingListC;
import com.deer.managementPlatform.service.PackingListCService;
import com.deer.managementPlatform.util.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PackingListCService")
public  class PackingListCServiceImpl implements PackingListCService {
    @Resource
    private PackingListCMapper packingListCDao;
    @Resource
    private ExportCMapper exportDao;

    @Override
    public List<PackingListC> find() {
        return packingListCDao.find();
    }

    //拆串，拼串
//    private PackingListC spellString(PackingListC packingList){
   /* private PackingListC spellString(String[] exportIdss) {
        String exportIds = "";
        String exportNos = "";
        for (String exportId : exportIdss) {
            ExportC exportC = exportDao.findById(exportId);
            if (exportC == null) {
                System.err.println("合同null----");
            }
            ;
//            exportIds += exportC.getExportId() + " ";
//            exportNos += exportC.getCustomerContract() + " ";
            System.err.println(exportC);
            String[] _s = exportC.getExportId().split(",");        //id|no
            for (int i = 0; i < _s.length; i++) {
                String[] _tmp = _s[i].split("\\|");                        //正则表达式，转义
                exportIds += _tmp[0] + "|";
                exportNos += _tmp[1] + "|";
            }
            if (exportIds != null && exportIds != "") {
                exportIds = exportIds.substring(0, exportIds.length() - 1); //利用截取功能
            }
            if (exportNos != null && exportNos != "") {
                exportNos = exportNos.substring(0, exportNos.length() - 1); //利用截取功能
            }
            PackingListC packingList = new PackingListC();
            packingList.setExportIds(exportIds);
            packingList.setExportNos(exportNos);

            return packingList;
        }
        return null;
    }*/
    private PackingListC spellString(PackingListC packingList){
        String exportIds = "";
        String exportNos = "";
        System.err.println(packingList);
        String[] _s = packingList.getExportIds().split(",");		//id|no
        for(int i=0;i<_s.length;i++){
            String[] _tmp = _s[i].split("\\|");						//正则表达式，转义
            exportIds +=  _tmp[0] + "|";
            exportNos +=  _tmp[1] + "|";
        }
        if (exportIds != null && exportIds != "") {
            exportIds = exportIds.substring(0, exportIds.length() - 1); //利用截取功能
        }
        if (exportNos != null && exportNos != "") {
            exportNos = exportNos.substring(0, exportNos.length() - 1); //利用截取功能
        }
        packingList.setExportId(exportIds);
        /*packingList.setExportNo(exportNo);*/

        return packingList;
    }
    //拼接HTML片段
        @Override
        public String getDivDataCreate (String[] exportIds){
            StringBuffer sBuf = new StringBuffer();
            for (int i = 0; i < exportIds.length; i++) {
                ExportC export = exportDao.findById(exportIds[i]);
                sBuf.append("<input type=\"checkbox\" name=\"exportIds\" checked value=\"").append(exportIds[i]).append("|").append(export.getCustomerContract()).append("\" class=\"input\"/>");
                sBuf.append(export.getCustomerContract()).append("&nbsp;&nbsp;");
            }

            return sBuf.toString();
        }
    @Override
    public int insert (PackingListC packingListC){
            this.spellString(packingListC);
            System.err.println(this.spellString(packingListC));
            packingListC.setPackingListId(UUIDUtils.getUUID().toString());
            packingListC.setState(0);
            System.err.println(packingListC);
            packingListCDao.insert(packingListC);
            return 0;
        }
//        修改

    @Override
    public PackingListC selcteById(String id) {
        return packingListCDao.selcteById(id);
    }
    @Override
    public void update(PackingListC packingList) {
        this.spellString(packingList);

        packingListCDao.update(packingList);
    }

}