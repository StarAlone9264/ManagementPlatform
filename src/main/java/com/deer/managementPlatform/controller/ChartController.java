package com.deer.managementPlatform.controller;

import com.deer.managementPlatform.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author wangt
 */
@Controller
@RequestMapping("/chart")
public class ChartController {

  /*  @Resource
    private SqlDao sqlDao;
    @RequestMapping("/factorySale")
    public String factorySale(HttpServletRequest request) throws FileNotFoundException {

        //真实路径
        String path = request.getSession().getServletContext().getRealPath("/");

        //1、组织数据源
        String sql = "SELECT f.factory_name,cp.countnum FROM (SELECT factory_id,factory_name FROM factory_c) f RIGHT JOIN (SELECT factory_id,COUNT(*) AS countnum FROM contract_product_c GROUP BY factory_id ) cp ON f.factory_id=cp.factory_id";
        //List<String>
        List<String> dataList=sqlDao.executeSQL(sql);
        System.out.println(dataList.size());
        //2、拼接成xml
        //拼接数据为一个xml字符串
        StringBuffer sBuf = new StringBuffer();
        sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sBuf.append("<pie>");
        for (int i = 0; i < dataList.size();) {
            // 在for循环内部控制当前记录标识
            sBuf.append("  <slice title=\"").append(dataList.get(i++)).append("\">").append(dataList.get(i++)).append("</slice>");
        }
        sBuf.append("</pie>");

        //3、创建一个文件txt格式，xml 工具类
        //输出文件，如果目录下没有文件，直接创建；如果目录下文件存在，覆盖。
        FileUtil fu = new FileUtil();
        fu.createTxt(path + "/stat/chart/factorysale", "data.xml", sBuf.toString(), "utf-8");


        return "stat/chart/sa";
    }*/
}
