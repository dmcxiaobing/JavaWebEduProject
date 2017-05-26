package com.qq986945193.javaweb.knowledge;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

import com.qq986945193.javaweb.domain.AttachBean;
import com.qq986945193.javaweb.utils.Mail;
import com.qq986945193.javaweb.utils.MailUtils;

/**
 * JAVA邮件的使用简单介绍
 */
public class JavaMailIntroduce {
	/**
	 * 普通发送邮件
	 * 
	 * @throws MessagingException
	 * @throws AddressException
	 */
	@Test
	public void sendMessage() throws AddressException, MessagingException {
		/**
		 * 1,得到session
		 */
		Properties properties = new Properties();
		properties.setProperty("mail.host", "smtp.163.com");
		properties.setProperty("mail.smtp.auth", "true");

		Authenticator authenticator = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("username", "password");
			}

		};
		Session session = Session.getInstance(properties);
		/**
		 * 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("我是发件人的邮箱地址@gmail.com"));// 设置发件人
		msg.setRecipients(RecipientType.TO, "我是收件人的邮箱地址@gmail.com");// 设置收件人
		msg.setRecipients(RecipientType.CC, "我是抄送人的邮箱地址@gmail.com");// 设置抄送
		msg.setRecipients(RecipientType.BCC, "我是暗送人的邮箱地址@sina.com");// 设置暗送
		/**
		 * 设置主题和内容
		 */
		msg.setSubject("这是来自javamail的测试邮件 主题");
		msg.setContent("这就是一封垃圾邮件,这是内容！", "text/html;charset=utf-8");

		/*
		 * 3. 发送
		 */
		Transport.send(msg);
	}
	
	/**
	 * 发送带有附件的邮件！！！
	 */
	@Test
	public void fun2() throws Exception {
		/*
		 * 1. 得到session
		 */
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("username", "password");
			}
		};
		
		Session session = Session.getInstance(props, auth);
		
		/*
		 * 2. 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("fasongren@163.com"));//设置发件人
		msg.setRecipients(RecipientType.TO, "shousongren@126.com");//设置收件人
		
		msg.setSubject("这是来自javamail的测试邮件有附件");
		
		
		////////////////////////////////////////////////////////
		/*
		 * 当发送包含附件的邮件时，邮件体就为多部件形式！
		 * 1. 创建一个多部件的部件内容！MimeMultipart
		 *   MimeMultipart就是一个集合，用来装载多个主体部件！
		 * 2. 我们需要创建两个主体部件，一个是文本内容的，另一个是附件的。
		 *   主体部件叫MimeBodyPart
		 * 3. 把MimeMultipart设置给MimeMessage的内容！
		 */
		MimeMultipart list = new MimeMultipart();//创建多部分内容
		
		// 创建MimeBodyPart
		MimeBodyPart part1 = new MimeBodyPart();
		// 设置主体部件的内容
		part1.setContent("这是一封包含附件的垃圾邮件", "text/html;charset=utf-8");
		// 把主体部件添加到集合中
		list.addBodyPart(part1);
		
		
		// 创建MimeBodyPart
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("F:/f/图片.jpg"));//设置附件的内容
		part2.setFileName(MimeUtility.encodeText("图片美女.jpg"));//设置显示的文件名称，其中encodeText用来处理中文乱码问题
		list.addBodyPart(part2);
		
		msg.setContent(list);//把它设置给邮件作为邮件的内容。
		
		
		////////////////////////////////////////////////////////
		
		/*
		 * 3. 发
		 */
		Transport.send(msg);		
	}
	/**
	 * 利用我们封装的工具进行发送邮件
	 * @throws Exception
	 */
	@Test
	public void fun3() throws Exception {
		/*
		 * 1. 得到session
		 */
		Session session = MailUtils.createSession("smtp.163.com", 
				"username", "password");
		/*
		 * 2. 创建邮件对象
		 */
		Mail mail = new Mail("986945193@qq.com",
				"dmcxiaobing@gmail.com,dmcxiaobing@foxmail.com",
				"不是垃圾邮件能是什么呢？", "这里是正文");
		
		/*				
		 * 创建两个附件对象
		 */
		AttachBean ab1 = new AttachBean(new File("F:/f/美女.jpg"), "小美女.jpg");
		AttachBean ab2 = new AttachBean(new File("F:/f/帅哥.jpg"), "小帅哥.jpg");
		
		// 添加到mail中
		mail.addAttach(ab1);
		mail.addAttach(ab2);
		
		/*
		 * 3. 发送
		 */
		MailUtils.send(session, mail);
	}
}
