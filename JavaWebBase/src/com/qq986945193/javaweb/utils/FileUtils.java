package com.qq986945193.javaweb.utils;
/**
 * @Author ：程序员小冰
 * @GitHub: https://github.com/QQ986945193
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * 文件的工具类
 */
public class FileUtils {

	/***
	 * 获取指定目录下的所有的文件（不包括文件夹），采用了递归
	 * 
	 */
	public static ArrayList<File> getListFiles(Object obj) {
		File directory = null;
		if (obj instanceof File) {
			directory = (File) obj;
		} else {
			directory = new File(obj.toString());
		}
		ArrayList<File> files = new ArrayList<File>();
		if (directory.isFile()) {
			files.add(directory);
			return files;
		} else if (directory.isDirectory()) {
			File[] fileArr = directory.listFiles();
			for (int i = 0; i < fileArr.length; i++) {
				File fileOne = fileArr[i];
				files.addAll(getListFiles(fileOne));
			}
		}
		return files;
	}

	@Test
	public void test_getListFiles() {
		ArrayList<File> files = FileUtils
				.getListFiles("D:\\KaiFaGongJu\\apache-tomcat-8.5.12\\webapps\\javaweb\\WEB-INF\\files");
		System.out.println(files);//这里就是打印集合
		/**
		 * 单个打印出文件名字
		 * D:\KaiFaGongJu\apache-tomcat-8.5.12\webapps\javaweb\WEB-INF\files\
		 * 04C0CCFC861C4C9CB83352D5E0D42961_db1.sql
		 * D:\KaiFaGongJu\apache-tomcat-8.5.12\webapps\javaweb\WEB-INF\files\
		 * 08602C533F954978868A0050D595A30D_db1
		 * D:\KaiFaGongJu\apache-tomcat-8.5.12\webapps\javaweb\WEB-INF\files\
		 * 3FF12D362BD448BBA7B0B1AAABC0843A_db1
		 * D:\KaiFaGongJu\apache-tomcat-8.5.12\webapps\javaweb\WEB-INF\files\
		 * 408B3146A79C4291ADA4D8594F5D3334_mydb1.sql
		 * D:\KaiFaGongJu\apache-tomcat-8.5.12\webapps\javaweb\WEB-INF\files\
		 * 65BD8E777DDC4554871638CAB8B72770_db1.sql
		 * D:\KaiFaGongJu\apache-tomcat-8.5.12\webapps\javaweb\WEB-INF\files\
		 * A126C19EB7D64224B11FFC941DD52096_db1
		 */
		for (int i = 0; i < files.size(); i++) {
			System.out.println(files.get(i));
		}
		//当然也可以直接获取到文件的名称：files.get(i).getName();
	}
}
