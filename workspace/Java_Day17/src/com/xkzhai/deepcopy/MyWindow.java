package com.xkzhai.deepcopy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyWindow {

	public static void main(String[] args) {
		// ��������
		JFrame frame = new JFrame("�ҵĵ�һ������");
		// ���ô�С
		frame.setSize(800, 600);
		// ����λ��
		frame.setLocation(100, 100);
		
		// ���ò���
		frame.setLayout(null);
		// ������ť
		JButton button = new JButton("ȷ��");
		// ���ñ߽�= ��С + λ�ã����������������
		button.setBounds(400, 200, 100, 50);
		// ����ť���Ӹ�����
		frame.add(button);
		frame.show();
		
		// ����ť���Ӽ�����
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