package com.qq986945193.javaweb.knowledge;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *Jframe的简单使用
 */
public class JframeIntroduce {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 200);
		frame.setLocation(200, 200);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("确定");

		frame.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("hello");
			}
		});

		frame.setVisible(true);
	}
}
