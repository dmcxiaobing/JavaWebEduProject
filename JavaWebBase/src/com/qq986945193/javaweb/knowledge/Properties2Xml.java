package com.qq986945193.javaweb.knowledge;

import org.apache.commons.io.FileUtils;

import com.qq986945193.javaweb.utils.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  Properties 转换 string.xml
 *
 * Created by linchaolong on 2016/12/16.
 */
public class Properties2Xml {

    public static void main(String[] args) throws Exception {

        //<?xml version="1.0" encoding="utf-8"?>
        //<resources>
        //  <string name="inviting_you_to_a_video_call">Inviting you to a video call…</string>
        //</resources>

        File dir = new File("Properties2Xml");
        properties2Xml(new File(dir, "Localizable.prop"), new File(dir, "string.xml"), new File(dir, "string-en.xml"));
    }

    /**
     * Properties 转换 string.xml
     *
     * @param file      properties文件
     * @param xmlCn     中文string.xml
     * @param xmlEn     英文string.xml
     */
    public static void properties2Xml(File file, File xmlCn, File xmlEn) {
        try (FileInputStream in = FileUtils.openInputStream(file)){
            List<String> lines = FileUtils.readLines(file);
            // PrintUtils.list(lines);
            // Properties 并不遵循文件原来的顺序，所以采取读行的方式处理
            List<String> xmlLinesCn = new ArrayList<>(lines.size());
            List<String> xmlLinesEn = new ArrayList<>(lines.size());
            addHeader(xmlLinesCn);
            addHeader(xmlLinesEn);
            for(String line : lines){
                xmlLinesCn.add(itemXmlCn(line));
                xmlLinesEn.add(itemXmlEn(line));
            }
            addFooter(xmlLinesCn);
            addFooter(xmlLinesEn);
            FileUtils.deleteQuietly(xmlCn);
            FileUtils.writeLines(xmlCn, "UTF-8", xmlLinesCn);
            FileUtils.writeLines(xmlEn, "UTF-8", xmlLinesEn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addHeader(List<String> lines){
        lines.add("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        lines.add("<resources>");
    }

    public static void addFooter(List<String> lines){
        lines.add("</resources>");
    }

    /**
     * 中文
     *
     * @param line
     * @return
     */
    private static String itemXmlCn(String line) {
        // <string name="inviting_you_to_a_video_call">Inviting you to a video call…</string>
        String[] keyValue = line.split("=");
        if(keyValue.length == 2){
            String key = keyValue[0].toLowerCase().trim();
            String value = keyValue[1].replaceAll("\"","").replaceAll(";","").trim();
            return "<string name=" + key + ">" + value + "</string>";
        }
        return "";
    }

    /**
     * 英文
     *
     * @param line
     * @return
     */
    private static String itemXmlEn(String line) {
        // <string name="inviting_you_to_a_video_call">Inviting you to a video call…</string>
        String[] keyValue = line.split("=");
        if(keyValue.length == 2){
            String key = keyValue[0].toLowerCase().trim();
            String value = key.replaceAll("_"," ").replaceAll("\"","");
            return "<string name=" + key + ">" + StringUtils.upperFirstLetter(value) + "</string>";
        }
        return "";
    }

}
