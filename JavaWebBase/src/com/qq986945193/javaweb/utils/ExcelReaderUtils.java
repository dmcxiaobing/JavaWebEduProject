package com.qq986945193.javaweb.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReaderUtils {
	public static void main(String[] args) throws BiffException, IOException {
		File file = new File("src/excel03.xls");
		File of = new File("src/excel03.properties");
		FileInputStream in = new FileInputStream(file);
		FileOutputStream os = new FileOutputStream(of, true);
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os, 512));
		Workbook workbook = Workbook.getWorkbook(in);
		Sheet sheet = workbook.getSheet(0);
		for (int i = 0; i < 6; i++) {// 72表示72行,下标从0-71
			for (int j = 1; j >= 0; j--) {// 2表示3列，0,1,2
				if (j != 2) {// 这里主要看我的excel，这里和下面的if把！=后面的数字换掉就能生成中文的国际化配置文件
					Cell c = sheet.getCell(j, i);// 注意这里左边j表示列，右边i表示行，发现报数组越界错误八成是弄反了
					String strc00 = c.getContents();
					System.out.println("ct:"+strc00);
					dos.write(strc00.getBytes("utf-8"));// utf-8这样不会乱码，中文的还是用gb2312吧，utf-8最后展示在myeclipse里还是乱码了
					System.out.println("写入成功1");
				if (j != 0) {// 这里主要看我的excel
						dos.write('=');
						System.out.println("写入成功2");
					}
				}

			}
			dos.write("\r\n".getBytes());
			dos.flush();
			System.out.println("写入成功3");
		}
		
		Properties props = new Properties();

		InputStream ins = new BufferedInputStream(new FileInputStream("src/excel03.properties"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(ins));
		props.load(bf);
		Set<Object> list = props.keySet();
		File f = new File("src/excel031.properties");
		FileOutputStream fos = new FileOutputStream(f);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos,
		"UTF-8"));
		for (Object o : list) {
		System.out.println(props.getProperty(o.toString()));
		writer.write(props.getProperty((String) o) + "=" + o.toString()
		+ "\r\n");
		}
		writer.flush();
		writer.close();
		System.out.print("over");


	}
}
