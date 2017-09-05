package com.qq986945193.javaweb.knowledge;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.qq986945193.javaweb.utils.ExcelUtils;

import java.io.*;

/**
 * Excel转换为xml
 */
public class Excel2Xml {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        File excelFile = new File("src/excel03.xls");

        Workbook workbook = ExcelUtils.workbook(excelFile);

        Sheet sheet = workbook.getSheetAt(0);

        int totalRow = sheet.getLastRowNum();

        
        File xml = new File(excelFile.getParentFile(), "excel0300.xml");
        File xmlCn = new File(excelFile.getParentFile(), "excel0300.xml");
        deleteExists(xml);
        deleteExists(xmlCn);

        //<?xml version="1.0" encoding="utf-8"?>
        //<resources>
        //  <string name="inviting_you_to_a_video_call">Inviting you to a video call…</string>
        //</resources>

        try (BufferedWriter out = new BufferedWriter(new FileWriter(xml));
             BufferedWriter outCn = new BufferedWriter(new FileWriter(xmlCn))){

            appendHeader(out);
            appendHeader(outCn);

            // 迭代每一行
            Row row;
            for (int i = 1; i <= totalRow; i++) {
                // 获取每一行
                row = sheet.getRow(i);
                if(row == null){
                    continue;
                }
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);

                appendItem(out, cell1, cell2);
                appendItemCn(outCn, cell1, cell2);
            }

            appendFooter(out);
            appendFooter(outCn);
        } catch (IOException e) {
            throw new RuntimeException("文件导出失败。");
        }
        System.out.println("导出完成");
    }

    public static void deleteExists(File file){
        if (file.exists()) {
            file.delete();
        }
    }

    public static void appendHeader(BufferedWriter out) throws IOException {
        out.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        out.newLine();
        out.append("<resources>");
        out.newLine();
    }

    public static void appendFooter(BufferedWriter out) throws IOException {
        out.append("</resources>");
    }

    public static void appendItem(BufferedWriter out, Cell cell1, Cell cell2) throws IOException {
        // <string name="inviting_you_to_a_video_call">Inviting you to a video call…</string>
        if (cell2 == null) {
            return;
        }
        String value = cell2.getStringCellValue();
        String name = value.replaceAll("( )+", "_").toLowerCase();
        if(StringUtils.isEmpty(name) && StringUtils.isEmpty(value)){
            return;
        }
        out.append(String.format("<string name=\"%s\">%s</string>", name, value));
        out.newLine();
    }

    public static void appendItemCn(BufferedWriter out, Cell cell1, Cell cell2) throws IOException {
        if (cell1 == null || cell2 == null) {
            return;
        }
        String name = cell2.getStringCellValue().replaceAll("( )+", "_").toLowerCase();
        String value = cell1.getStringCellValue();
        if(StringUtils.isEmpty(name) && StringUtils.isEmpty(value)){
            return;
        }
        out.append(String.format("<string name=\"%s\">%s</string>", name, value));
        out.newLine();
    }

}
