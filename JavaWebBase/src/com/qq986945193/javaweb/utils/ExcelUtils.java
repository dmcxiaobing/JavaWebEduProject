package com.qq986945193.javaweb.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Excel 工具类
 */
public class ExcelUtils {

    public static final int CELL_VALUE_ERROR = -1;
    public static final int BUFF_SIZE = 1024 * 1024 * 50; // 50KB
    public static final String SUFFIX_XLS = ".xls";
    public static final String SUFFIX_XLSX = ".xlsx";

    /**
     * 是否是excel文件
     *
     * @param name
     * @return
     */
    public static boolean isExcel(String name) {
        if (null != name) {
            String fileType = name
                    .substring(name.lastIndexOf("."), name.length())
                    .trim().toLowerCase();
            return SUFFIX_XLS.equals(fileType) || SUFFIX_XLSX.equals(fileType);
        }
        return false;
    }

    /**
     * 根据文件名获取excel对象
     *
     * @param excel
     * @return
     */
    public static Workbook workbook(String excel) {
        return workbook(new File(excel));
    }

    /**
     * 根据文件名获取excel对象
     *
     * @param excel
     * @return
     */
    public static Workbook workbook(File excel) {
        Workbook workbook = null;
        if (null != excel) {
            String fileType = getFileSuffix(excel.getName());
            try {
                FileInputStream fileStream = new FileInputStream(excel);
                if (".xls".equals(fileType)) {
                    workbook = new HSSFWorkbook(fileStream);
                } else if (".xlsx".equals(fileType)) {
                    workbook = new XSSFWorkbook(fileStream);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(excel + "，文件找不到。");
            } catch (IOException e) {
                throw new RuntimeException(excel + "，文件读取失败。");
            }
        }
        return workbook;
    }

    /**
     * 获取 cell 的值
     *
     * @param cell
     * @return  返回 double 值，获取失败返回{@link #CELL_VALUE_ERROR}
     */
    public static double doubleValue(Cell cell){
        try {
            return cell.getNumericCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CELL_VALUE_ERROR;
    }

    /**
     * 获取 cell 的值
     *
     * @param cell
     * @return  返回 int 值，获取失败返回{@link #CELL_VALUE_ERROR}
     */
    public static int intValue(Cell cell){
        return (int) doubleValue(cell);
    }

    /**
     * 获取 cell 的值
     *
     * @param cell
     * @return  返回字符串
     */
    public static String stringValue(Cell cell){
        return cell.toString();
    }

    /**
     * 获取 cell 的值，支持包含文件内容
     *
     * @param cell
     * @param includeFileFlag   导入文件内容标记，
     *                          比如 "#f:" 为标记，cell 值为 "#f:test.txt"，则会把 test.txt 中的内容作为 cell 的值
     *
     * @param parentDir 文件父目录
     *
     * @return 返回字符串
     */
    public static String stringValue(Cell cell, String includeFileFlag, File parentDir) {
        String value = cell.toString();
        // 插入文件内容
        if (value.startsWith(includeFileFlag)) {
            String path = value.substring(value.indexOf(':') + 1);
            File file = new File(parentDir, path);
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
                 ByteArrayOutputStream out = new ByteArrayOutputStream()){
                byte buff[] = new byte[BUFF_SIZE];
                for (int len; (len = in.read(buff)) != -1; ) {
                    out.write(buff, 0, len);
                }
                // System.out.println(out.toString());
                return out.toString();
            } catch (FileNotFoundException e1) {
                throw new RuntimeException("单元格（" + cell.getRowIndex() + "，" + cell.getColumnIndex() + "），\"" + path + "\"文件不存在。");
            } catch (IOException e1) {
                throw new RuntimeException("单元格（" + cell.getRowIndex() + "，" + cell.getColumnIndex() + "），\"" + path + "\"文件读取失败。");
            }
        }
        return value;
    }

    /**
     * 获取文件后缀
     *
     * @param filename
     * @return
     */
    private static String getFileSuffix(String filename){
        return filename.substring(filename.lastIndexOf("."), filename.length())
                .trim().toLowerCase();
    }
}
