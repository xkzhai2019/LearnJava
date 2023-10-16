package com.xkzhai.deepcopy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyWindow {

	public static void main(String[] args) {
		// 创建窗口
		JFrame frame = new JFrame("我的第一个窗口");
		// 设置大小
		frame.setSize(800, 600);
		// 设置位置
		frame.setLocation(100, 100);
		
		// 设置布局
		frame.setLayout(null);
		// 创建按钮
		JButton button = new JButton("确定");
		// 设置边界= 大小 + 位置（相对于所在容器）
		button.setBounds(400, 200, 100, 50);
		// 将按钮添加给容器
		frame.add(button);
		frame.show();
		
		// 给按钮添加监听器
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
//		JTextArea xx = null;
//		xx.getText();
		//frame.dispose();

	}

}
