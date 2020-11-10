package com.deer.managementPlatform.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deer.managementPlatform.entity.OutProductVO;
import com.deer.managementPlatform.service.OutProductService;
import com.deer.managementPlatform.util.DownloadUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/outProduct")
public class OutProductController extends BaseController {

    @Resource
    private OutProductService outProductService;
    //非模板开发
    @RequestMapping("/print")
    public void print(String inputDate,String xlsName,HttpServletResponse response) throws IOException {
        System.err.println(inputDate+"...."+xlsName);
        /*
         * POI实现excel打印
         * 1、大标题，合并单元格
         * 2、标题，修饰
         * 3、内容，修饰
         *
         */

        Workbook wb = new HSSFWorkbook();		//创建一个工作簿
        Sheet sheet = wb.createSheet();			//创建一个工作表
        Row nRow = null;
        Cell nCell = null;
        int rowNo = 0;							//行号
        int colNo = 1;							//列号：从第2列开始

        //创建样式和字体对象
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        sheet.setColumnWidth(0, 1 * 278); // 设置列宽 278，BUG，精度不够，总是差一点
        sheet.setColumnWidth(1, 26 * 278);
        sheet.setColumnWidth(2, 12 * 278);
        sheet.setColumnWidth(3, 29 * 278);
        sheet.setColumnWidth(4, 10 * 278);
        sheet.setColumnWidth(5, 12 * 278);
        sheet.setColumnWidth(6, 8 * 278);
        sheet.setColumnWidth(7, 10 * 278);
        sheet.setColumnWidth(8, 10 * 278);
        sheet.setColumnWidth(9, 8 * 278);

        //处理大标题	sheet.addMergedRegion(new CellRangeAddress(开始行，结束行，开始列，结束列));
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 8));

        //合并单元格的内容是写在合并前第一个单元格
        nRow = sheet.createRow(rowNo++);
        nRow.setHeightInPoints(36);

        nCell = nRow.createCell(1);
        nCell.setCellStyle(bigTitleStyle(wb));

        nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表");		//yyyy-MM

        //处理标题。标题数组
        String[] title = new String[]{"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};
        nRow = sheet.createRow(rowNo++);
        nRow.setHeightInPoints(26);

        for(int i=0;i<title.length;i++){
            nCell = nRow.createCell(i+1);
            nCell.setCellValue(title[i]);
            nCell.setCellStyle(this.titleStyle(wb));
        }

        //处理内容
        List<OutProductVO> dataList = outProductService.find(inputDate);
        for(int j=0;j<dataList.size();j++){
            colNo = 1;				//初始化
            OutProductVO op = dataList.get(j);

            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCustomName());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getContractNo());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getProductNo());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCnumber());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getFactoryName());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getDeliveryPeriod());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getShipTime());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getTradeTerms());
            nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
        }

//		OutputStream os = new FileOutputStream("d:\\outproduct.xls");
//		wb.write(os);
//
//		os.flush();
//		os.close();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        wb.write(os);

        //直接弹出下载框，用户可以打开，可以保存
        DownloadUtil downloadUtil = new DownloadUtil();
        downloadUtil.download(os, response, xlsName+".xls");

        os.flush();
        os.close();

    }

    //模板开发
    @RequestMapping("/printHSSF")
    public void printHSSF(String inputDate, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // linux下jdk1.8 方法获取时，不会拼接自己写的目录
        String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
        InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xls"));

        Workbook wb = new HSSFWorkbook(is); // 打开一个模板文件，工作簿
        Sheet sheet = wb.getSheetAt(0); // 获取到第一个工作表

        Row nRow = null;
        Cell nCell = null;
        int rowNo = 0; // 行号
        int colNo = 1; // 列号

        // 获取模板上的单元格样式
        nRow = sheet.getRow(2);

        // 客户的样式
        nCell = nRow.getCell(1);
        CellStyle customStyle = nCell.getCellStyle();

        // 订单号的样式
        nCell = nRow.getCell(2);
        CellStyle contractNoStyle = nCell.getCellStyle();

        // 货号的样式
        nCell = nRow.getCell(3);
        CellStyle productNoStyle = nCell.getCellStyle();

        // 数量的样式
        nCell = nRow.getCell(4);
        CellStyle numStyle = nCell.getCellStyle();

        // 生产厂家的样式
        nCell = nRow.getCell(5);
        CellStyle factoryStyle = nCell.getCellStyle();

        // 工厂交期的样式
        nCell = nRow.getCell(6);
        CellStyle dateStyle = nCell.getCellStyle();

        // 船期的样式和工厂交期的样式一样
        // nCell = nRow.getCell(7);
        // CellStyle shipStyle = nCell.getCellStyle();

        // 贸易条款的样式
        nCell = nRow.getCell(8);
        CellStyle tradeStyle = nCell.getCellStyle();

        // 处理大标题
        nRow = sheet.getRow(rowNo++); // 获取一个行对象
        nCell = nRow.getCell(colNo); // 获取一个单元格对象
        nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表"); // yyyy-MM

        rowNo++; // 跳过静态表格头

        // 处理内容
        List<OutProductVO> dataList = outProductService.find(inputDate);
        for (int j = 0; j < dataList.size(); j++) {
            colNo = 1; // 初始化
            OutProductVO op = dataList.get(j);

            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCustomName());
            nCell.setCellStyle(customStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getContractNo());
            nCell.setCellStyle(contractNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getProductNo());
            nCell.setCellStyle(productNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCnumber());
            nCell.setCellStyle(numStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getFactoryName());
            nCell.setCellStyle(factoryStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getDeliveryPeriod());
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getShipTime());
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getTradeTerms());
            nCell.setCellStyle(tradeStyle);
        }
        // OutputStream os = new FileOutputStream("d:\\outproduct.xls");
        // wb.write(os);
        //
        // os.flush();
        // os.close();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        wb.write(os);

        DownloadUtil downloadUtil = new DownloadUtil(); // 直接弹出下载框，用户可以打开，可以保存
        downloadUtil.download(os, response, "出货表.xls");

        os.flush();
        os.close();
    }

    // 模板开发XSSF
    @RequestMapping("/printXSSF")
    public void printXSSF(String inputDate, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // linux下jdk1.8 方法获取时，不会拼接自己写的目录
        String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
        InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xlsx"));

        Workbook wb = new XSSFWorkbook(is); // 打开一个模板文件，工作簿 2007以上版本
        Sheet sheet = wb.getSheetAt(0); // 获取到第一个工作表

        Row nRow = null;
        Cell nCell = null;
        int rowNo = 0; // 行号
        int colNo = 1; // 列号

        // 获取模板上的单元格样式
        nRow = sheet.getRow(2);

        // 客户的样式
        nCell = nRow.getCell(1);
        CellStyle customStyle = nCell.getCellStyle();

        // 订单号的样式
        nCell = nRow.getCell(2);
        CellStyle contractNoStyle = nCell.getCellStyle();

        // 货号的样式
        nCell = nRow.getCell(3);
        CellStyle productNoStyle = nCell.getCellStyle();

        // 数量的样式
        nCell = nRow.getCell(4);
        CellStyle numStyle = nCell.getCellStyle();

        // 生产厂家的样式
        nCell = nRow.getCell(5);
        CellStyle factoryStyle = nCell.getCellStyle();

        // 日期的样式
        nCell = nRow.getCell(6);
        CellStyle dateStyle = nCell.getCellStyle();

        // 贸易条款的样式
        nCell = nRow.getCell(8);
        CellStyle tradeStyle = nCell.getCellStyle();

        // 处理大标题
        nRow = sheet.getRow(rowNo++); // 获取一个行对象
        nCell = nRow.getCell(colNo); // 获取一个单元格对象
        nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表"); // yyyy-MM

        rowNo++; // 跳过静态表格头

        // 处理内容
        List<OutProductVO> dataList = outProductService.find(inputDate);
        for (int j = 0; j < dataList.size(); j++) {
            colNo = 1; // 初始化
            OutProductVO op = dataList.get(j);

            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCustomName());
            nCell.setCellStyle(customStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getContractNo());
            nCell.setCellStyle(contractNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getProductNo());
            nCell.setCellStyle(productNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getCnumber());
            nCell.setCellStyle(numStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getFactoryName());
            nCell.setCellStyle(factoryStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getDeliveryPeriod());
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getShipTime());
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(op.getTradeTerms());
            nCell.setCellStyle(tradeStyle);
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        wb.write(os);

        DownloadUtil downloadUtil = new DownloadUtil(); // 直接弹出下载框，用户可以打开，可以保存
        downloadUtil.download(os, response, "出货表.xlsx");

        os.flush();
        os.close();
    }




    //大标题样式
    private CellStyle bigTitleStyle(Workbook wb) {
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        curFont.setFontName("宋体");
        curFont.setFontHeightInPoints((short) 16);
        curFont.setBoldweight(Font.BOLDWEIGHT_BOLD); // 字体加粗

        curStyle.setFont(curFont); // 绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_CENTER); // 横向居中
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

        return curStyle;
    }



    // 小标题样式
    private CellStyle titleStyle(Workbook wb) {
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();

        curFont.setFontName("黑体");
        curFont.setFontHeightInPoints((short) 12);

        curStyle.setFont(curFont); // 绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_CENTER); // 横向居中
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

        curStyle.setBorderTop(CellStyle.BORDER_THIN); // 设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);

        return curStyle;
    }

    // 文字样式
    private CellStyle textStyle(Workbook wb, CellStyle curStyle, Font curFont) {

        curFont.setFontName("Times New Roman");
        curFont.setFontHeightInPoints((short) 10);

        curStyle.setFont(curFont); // 绑定字体

        curStyle.setAlignment(CellStyle.ALIGN_LEFT); // 横向居左
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

        curStyle.setBorderTop(CellStyle.BORDER_THIN); // 设置四周边线，细线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);
        curStyle.setBorderLeft(CellStyle.BORDER_THIN);
        curStyle.setBorderRight(CellStyle.BORDER_THIN);

        return curStyle;
    }
}
