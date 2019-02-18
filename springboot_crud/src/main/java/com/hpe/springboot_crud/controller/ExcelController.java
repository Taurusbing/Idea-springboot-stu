package com.hpe.springboot_crud.controller;

import com.hpe.springboot_crud.model.SysUser;
import com.hpe.springboot_crud.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author xubing
 * @date 2019/2/13
 * 创建一个excel文件工作薄（HSSFWorkbook workbook = new HSSFWorkbook()）
 * 创建一张表：HSSFSheet sheet = workbook.createSheet(“统计表”)
 * 创建一行：HSSFRow row = sheet.createRow(0)
 * 填充一列数据：row.createCell(0).setCellValue("数据")
 * 设置一个单元格样式：cell.setCellStyle(style)
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    private UserService userService;

    //创建表头
    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);

        //设置列宽，setColumnWidth的第一个参数是列数,第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(2,17*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        //设置字体加粗
        font.setBold(true);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);

        //为第0行的0，1，2列填充数据，并设置样式
        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("用户名");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("密码");
        cell.setCellStyle(style);
    }

    //生成sys_user表excel
    @GetMapping("/getUser")
    public String getUser(HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("用户信息列表");

        //调用表头创建方法
        createTitle(workbook,sheet);

        List<SysUser> list = userService.queryAll();

        //新增数据行，并设置单元格数据
        int rowNum = 1;
        for(SysUser user : list){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getPassword());
            rowNum++;
        }

        //文件名
        String fileName = "导出excel例子.xls";

        //生成excel文件
        buildExcelFile(fileName,workbook);

        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);

        return "download excel";
    }

    protected void buildExcelFile(String fileName,HSSFWorkbook workbook) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);

        workbook.write(fos);

        fos.close();
    }

    protected void buildExcelDocument(String fileName,HSSFWorkbook workbook,HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }
}

