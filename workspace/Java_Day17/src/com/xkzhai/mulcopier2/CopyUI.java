package com.xkzhai.mulcopier2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * 主窗口
 * @author Administrator
 *
 */
public class CopyUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 6189847546972653742L;
	// srcFile
	private JLabel lblSrcFile;
	private JTextField tfSrcFile;

	// destDir
	private JLabel lblDestDir;
	private JTextField tfDestDir;
	private JButton btnStart;
	private JLabel lblCount;
	private JTextField tfCount;
	
	private JProgressBar[] bars;
	
	public CopyUI(){
		init();
	}
	private void init() {
		this.setTitle("主窗口");
		this.setBounds(100, 100, 800, 600);
		this.setLayout(null);
		
		// srcFile标签
		lblSrcFile = new JLabel("源文件");
		lblSrcFile.setBounds(10, 10, 80, 30);
		this.add(lblSrcFile);
		
		tfSrcFile = new JTextField();
		tfSrcFile.setText("D:/copyTest.zip");
		tfSrcFile.setBounds(110, 10, 600, 30);
		
		this.add(tfSrcFile);
		
		// destDir标签
		lblDestDir = new JLabel("目标目录");
		lblDestDir.setBounds(10, 60, 100, 30);
		this.add(lblDestDir);
		
		tfDestDir = new JTextField();
		tfDestDir.setBounds(110, 60, 600, 30);
		tfDestDir.setText("D:/copyUI.zip");
		this.add(tfDestDir);
		
		// 线程数
		lblCount = new JLabel("线程数");
		lblCount.setBounds(10, 110, 80, 30);
		this.add(lblCount);
		
		tfCount = new JTextField();
		tfCount.setText(""+5);
		tfCount.setBounds(110, 110, 600, 30);
		this.add(tfCount);
		
		// 开始按钮
		btnStart = new JButton("开始");
		btnStart.setBounds(10, 160, 100, 30);
		this.add(btnStart);
		btnStart.addActionListener(this);
		
		this.setVisible(true);
		
		// 设置窗口适配器
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}
	
	// 添加按钮监听
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		// 开始按钮
		if(source == btnStart){
			String srcFile = tfSrcFile.getText();
			String destDir = tfDestDir.getText();
			int count = Integer.parseInt(tfCount.getText());
			
			// 创建复制器对象
			Copier copier = new Copier(this,srcFile,destDir,count);
			
			// 动态添加进度条
			addBar(copier.infos);
			
			// 开始复制
			copier.startCopy();
			
		}
	}
	/**
	 * 动态添加进度条
	 * @param infos
	 */
	private void addBar(List<CopyInfo> infos) {
		bars = new JProgressBar[infos.size()];
		for(CopyInfo info: infos){
			bars[info.getIndex()] = new JProgressBar();			
			bars[info.getIndex()].setBounds(10,200 + info.getIndex() * 50,650,50);
			bars[info.getIndex()].setMaximum(info.getEnd() - info.getStart() + 1);
			this.add(bars[info.getIndex()]);
		}
		// 重绘
		this.repaint();
	}
	
	private int completeCount = 0;
	// 更新进度条
	public void updateBar(int index, int length) {
		bars[index].setValue(bars[index].getValue() + length);
		if(bars[index].getValue() >= bars[index].getMaximum()){
			completeCount ++;
			processFinish();
			
		}
	}
	private void processFinish() {
		if(completeCount>=bars.length){
			// 删除进度条
			for(JProgressBar bar: bars){
				this.remove(bar);
			}
			this.repaint();
		}
	}
}
