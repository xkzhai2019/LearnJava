package com.xkzhai.deepcopy;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 主窗口
 * @author Administrator
 *
 */
public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 5867166639769467858L;
	private JButton btnOK;
	private JButton btnCancel;
	private JTextArea txtArea;
	private JMenuItem miOpen;
	private JMenuItem miExit;
	public MainFrame(){
		initFrame();
		this.setVisible(true);
	}
	
	/**
	 * 初始化
	 */
	private void initFrame() {
		//标题
		this.setTitle("主窗口");
		
		// 边界
		this.setBounds(100, 100, 850, 600);

		// 绝对布局
		this.setLayout(null);
		
		Font font = new Font("宋体",Font.BOLD,20);
		
		// 将文本域添加到滚动面板中
		txtArea = new JTextArea();
		//txtArea.setBounds(0, 0, 800, 500);
		txtArea.setFont(font);
		//txtArea.setBackground(Color.BLACK);
		//txtArea.setBackground(new Color(0xff,0,0,0x10));
		//this.add(txtArea);
		
		// 滚动面板
		JScrollPane scrollPane = new JScrollPane(txtArea);
		scrollPane.setBounds(0, 0, 800, 500);
		//scrollPane.setLayout(null);
		this.add(scrollPane);
		
		
		btnOK = new JButton("保存");
		btnOK.setBounds(600, 510, 100, 50);
		btnOK.setFont(font);
		btnOK.addActionListener(this);
		this.add(btnOK);
		
		btnCancel = new JButton("取消");
		btnCancel.setBounds(710, 510, 100, 50);
		btnCancel.setFont(font);
		btnCancel.addActionListener(this);
		this.add(btnCancel);
		
		// 添加窗口事件处理程序，使用适配器
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("OKKK");
				System.exit(-1);
			}
		});
		
		// 添加菜单栏
		JMenuBar menubar = new JMenuBar();
		
		// 添加菜单
		JMenu menu = new JMenu("文件");
		miOpen = new JMenuItem("打开"); 
		miOpen.addActionListener(this);
		menu.add(miOpen);
		
		// 分隔符
		menu.addSeparator();
		
		miExit = new JMenuItem("退出");
		menu.add(miExit);
		miExit.addActionListener(this);
		
		
		menubar.add(menu);
		this.setJMenuBar(menubar);
		
		
		
	}

	/**
	 * 动作处理程序
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 得到事件源
		Object es = e.getSource();
		//System.out.println(es);
		
		// 保存文件
		if(es == btnOK){
			
			try {
				// 打开保存对话框，定位保存文件的位置
				FileDialog d = new FileDialog(this,"保存",FileDialog.SAVE);
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
		// 是否是菜单项
		else if(es == miOpen){
			txtArea.setText("");
			FileDialog d = new FileDialog(this,"打开",FileDialog.LOAD);
			d.setVisible(true);
			//File f = new File(d.getDirectory(),d.getFile());
			String dir = d.getDirectory();
			String f = d.getFile();
			if(dir != null & f!= null){
				try {
					txtArea.setText("");
					FileReader reader = new FileReader(new File(dir,f));
					char[] buffer = new char[1024];
					int len = -1;
					while( (len = reader.read(buffer)) != -1){
						txtArea.setText(txtArea.getText()+new String(buffer,0,len));
					}
					reader.close();
				} catch (Exception e1) {
				}
			}
		}
		else if(es == miExit){
			System.exit(-1);
		}
		
	}
	
	


}
