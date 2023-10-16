package com.xkzhai.deepcopy;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * ������
 * @author Administrator
 *
 */
public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 5867166639769467858L;
	private JButton btnOK;
	private JButton btnCancel;
	private JTextArea txtArea;
	public MainFrame(){
		initFrame();
		this.setVisible(true);
		
		
	}
	
	/**
	 * ��ʼ��
	 */
	private void initFrame() {
		//����
		this.setTitle("������");
		
		// �߽�
		this.setBounds(100, 100, 800, 600);

		// ���Բ���
		this.setLayout(null);
		
		Font font = new Font("����",Font.BOLD,20);
		txtArea = new JTextArea();
		txtArea.setBounds(0, 0, 800, 500);
		txtArea.setFont(font);
		//txtArea.setBackground(Color.BLACK);
		//txtArea.setBackground(new Color(0xff,0,0,0x10));
		this.add(txtArea);
		
		btnOK = new JButton("ȷ��");
		btnOK.setBounds(600, 510, 100, 50);
		btnOK.setFont(font);
		btnOK.addActionListener(this);
		this.add(btnOK);
		
		btnCancel = new JButton("ȡ��");
		btnCancel.setBounds(710, 510, 100, 50);
		btnCancel.setFont(font);
		btnCancel.addActionListener(this);
		this.add(btnCancel);
		
		// ��Ӵ����¼��������ʹ��������
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("OKKK");
				System.exit(-1);
			}
		});
		
	}

	/**
	 * �����������
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// �õ��¼�Դ
		Object es = e.getSource();
		//System.out.println(es);
		
		// �����ļ�
		if(es == btnOK){
			
			try {
				// �򿪱���Ի��򣬶�λ�����ļ���λ��
				FileDialog d = new FileDialog(this,"����",FileDialog.SAVE);
				d.setVisible(true);
				System.out.println(d.getDirectory()+":"+d.getFile());
				
				File f = new File(d.getDirectory(),d.getFile());
				
				String str = txtArea.getText();
				FileWriter fw = new FileWriter(f);
//				FileWriter fw = new FileWriter("a.txt");
				fw.write(str);
				fw.close();
				txtArea.setText("");
			} catch (Exception e1) {
				
			}
			//System.out.println("OK");
		}
		else if(es == btnCancel){
			this.dispose();
		}
		
	}
	
	


}
