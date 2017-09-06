package com.qq986945193.javaweb.knowledge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadWrite {
	// 行数
	public static final int lastrownum = 50;
	// 列数
	public static final int lastCellNum = 3;

	// 需要写入properties文件中的key所在的列数 从0开始为第一列
	public static final int KEY_NUM = 0;
	// 需要写入properties文件中的value值所在的列数 从0开始为第一列
	public static final int VALUE_NUM = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readExcel("F:/Demo/in.xls");
	}

	/**
	 * 读excel
	 * 
	 * @param filePath
	 *            excel路径
	 */
	public static void readExcel(String filePath) {
		Workbook book = null;
		try {
			book = getExcelWorkbook(filePath);
			Sheet sheet = getSheetByNum(book, 1);
			System.out.println("sheet名称是：" + sheet.getSheetName());
			// 获取文档总行数
			// int lastRowNum = sheet.getLastRowNum();

			Row row = null;
			// i控制行数，从第一行开始遍历，直到最后一行
			for (int i = 0; i <= lastrownum; i++) {
				// row为行数
				row = sheet.getRow(i);
				if (row != null) {
					System.out.println("正在读第" + (i + 1) + "行：");
					// 获取文档总列数
					// int lastCellNum = row.getLastCellNum();
					Cell cell = null;
					StringBuilder sb = null;
					
					
					Cell key = row.getCell(KEY_NUM);
					Cell value = row.getCell(VALUE_NUM);
					// j控制列数，从第一列遍历到最后一列
					/*for (int j = 0; j < lastCellNum; j++) {
						// 获取单元格中数据
						// cell = row.getCell(j);
						

						if (cell != null) {
							// sb = new
							// StringBuilder("第"+(j+1)+"列的单元格内容是："+cell);
							// String type_cn = null;
							// String type_style =
							// cell.getCellStyle().getDataFormatString().toUpperCase();

							System.out.println(sb.toString());
						}
						
					}*/
					System.out.println("key的值是:"+key.toString()+"      "+"value的值是:"+value.toString());
					//将需要写入的两列数9据以key = value的格式写入到properties文件中
					createProperties(key.toString(),value.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取excel的Workbook
	 * 
	 * @throws IOException
	 */
	public static Workbook getExcelWorkbook(String filePath) throws IOException {
		Workbook book = null;
		File file = null;
		FileInputStream fis = null;

		try {
			file = new File(filePath);
			if (!file.exists()) {
				throw new RuntimeException("文件不存在");
			} else {
				fis = new FileInputStream(file);
				book = WorkbookFactory.create(fis);
				// initStyleMap(book);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		return book;
	}

	/**
	 * 根据索引 返回Sheet
	 * 
	 * @param number
	 */
	public static Sheet getSheetByNum(Workbook book, int number) {
		Sheet sheet = null;
		try {
			sheet = book.getSheetAt(number - 1);
			// if(sheet == null){
			// sheet = book.createSheet("Sheet"+number);
			// }
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return sheet;
	}

	/**
	 * 创建properties文件
	 * 
	 * @param key
	 * @param value
	 */
	public static void createProperties(String key, String value) {
		FileOutputStream fos = null;
        OutputStreamWriter bufferedWriter = null;
        PrintWriter propWriter = null;
        
        try {
        	 // 1、创建新生成的文件写入流propWriter
			fos = new FileOutputStream("F:/Demo/out.properties");
			 bufferedWriter = new OutputStreamWriter(fos, "gbk");
		        propWriter = new PrintWriter(bufferedWriter);
		        
		} catch (Exception e) {
			return;
		}
        String properties = key+"="+value;
        System.out.println("写入的数据为:"+properties);
        propWriter.write(properties);
        propWriter.write("\n");
        
        propWriter.flush();
        propWriter.close();
       
 
	}

}
