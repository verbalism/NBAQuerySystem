package presentation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.data.category.DefaultCategoryDataset;

public class TeamCmpPanel extends JPanel{
	int panelHeight,panelWidth;
	ImageIcon img1,img2;
	JLabel teamImgLabel1,teamImgLabel2;
	JLabel teamNameLabel1 = new JLabel(), teamNameLabel2 = new JLabel();
	JLabel cmpTypeLabel;
	JTextField searchField1,searchField2;
	JButton searchBtn1,searchBtn2;
	JButton lineChartBtn, barChartBtn;
	public TeamCmpPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		JLabel title = new JLabel("  球 队 对 比");
		title.setBounds(0, 10, panelWidth, 40);
		title.setBackground(new Color(87,89,91));
		title.setForeground(Color.white);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setOpaque(true);
		
		
		JPanel teamInfoPanel = new JPanel();
		teamInfoPanel.setBounds(0, 50, panelWidth, 180);
		teamInfoPanel.setBackground(null);

		
		JLabel cmpLabel = new JLabel("球队对比");
		cmpLabel.setBackground(Color.WHITE);
		cmpLabel.setOpaque(true);
		cmpLabel.setBounds(panelWidth/2-65, 0, 130, 120);
		cmpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cmpLabel.setFont(new Font("微软雅黑",Font.BOLD,24));
		cmpLabel.setForeground(new Color(0,103,175));
		
		
		searchField1 = new JTextField();
		searchField1.setBounds(30,0,panelWidth/2-95,30);
		searchField1.setBackground(new Color(246,246,246));
		searchField1.setBorder(null);
		searchField1.setText("  查找球队");
		searchField1.setForeground(Color.gray);
		searchField1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				searchField1.setText(null);
			}
		});
		searchField1.addKeyListener(new KeyAdapter(){ 
		      public void keyPressed(KeyEvent e)    
		      {    
		        if(e.getKeyChar()==KeyEvent.VK_ENTER )   //按回车键执行相应操作; 
		        { 
		          //searchBtn1.doClick();
		        } 
		      } 
		    });
		searchField2 = new JTextField();
		searchField2.setBounds(panelWidth/2+65,0,panelWidth/2-95,30);
		searchField2.setBackground(new Color(246,246,246));
		searchField2.setBorder(null);
		searchField2.setText("  查找球队");
		searchField2.setForeground(Color.gray);
		searchField2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				searchField2.setText(null);
			}
		});
		searchField2.addKeyListener(new KeyAdapter(){ 
		      public void keyPressed(KeyEvent e)    
		      {    
		        if(e.getKeyChar()==KeyEvent.VK_ENTER )   //按回车键执行相应操作; 
		        { 
		          //searchBtn2.doClick();
		        } 
		      } 
		    });
		final ImageIcon find = new ImageIcon("Img//searchBtn.png");
		final ImageIcon find_c = new ImageIcon("Img//searchBtn_clicked.png");
		
		searchBtn1 = new JButton();
		searchBtn1.setIcon(find);
		searchBtn1.setBounds(0, 0, 30, 30);
		searchBtn1.setBorder(null);
		//searchBtn1.addActionListener(this);
		searchBtn1.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				searchBtn1.setIcon(find_c);
			}
			public void mouseExited(MouseEvent e){
				searchBtn1.setIcon(find);
			}
		});
		searchBtn2 = new JButton();
		searchBtn2.setIcon(find);
		searchBtn2.setBounds(panelWidth-30, 0, 30, 30);
		searchBtn2.setBorder(null);
		//searchBtn2.addActionListener(this);
		searchBtn2.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				searchBtn2.setIcon(find_c);
			}
			public void mouseExited(MouseEvent e){
				searchBtn2.setIcon(find);
			}
		});
		
		JPanel search = new JPanel();
		search.setBounds(0,90,panelWidth,30);
		search.setBackground(null);
		search.setLayout(null);
		search.add(searchField1);
		search.add(searchField2);
		search.add(searchBtn1);
		search.add(searchBtn2);
		
		
		teamImgLabel1=new JLabel();
		teamImgLabel1.setBounds(panelWidth/2-215, 5, 90, 90);
		teamImgLabel2 = new JLabel();
		teamImgLabel2.setBounds(panelWidth/2+65, 5, 90, 90);
		img1 = new ImageIcon("Img//teams//"+"BOS.png");
		img1.setImage(img1.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT));
		teamImgLabel1.setIcon(img1);
		img2 = new ImageIcon("Img//icon.jpg");
		img2.setImage(img2.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT));
		teamImgLabel2.setIcon(img2);
		
		JPanel teamImgPanel = new JPanel();
		teamImgPanel.setOpaque(false);
		teamImgPanel.setBounds(0, 0, panelWidth, 120);
		teamImgPanel.setBackground(null);
		teamImgPanel.setLayout(null);
		teamImgPanel.add(teamImgLabel1);
		teamImgPanel.add(teamImgLabel2);
		teamImgPanel.add(cmpLabel);
		
		teamNameLabel1.setBounds(0, 130, panelWidth/2-65, 50);
		teamNameLabel1.setBackground(new Color(30,81,140));
		teamNameLabel1.setOpaque(true);
		teamNameLabel1.setText("ATL  ");
		teamNameLabel1.setForeground(Color.WHITE);
		teamNameLabel1.setFont(new Font("Arial",Font.BOLD,20));
		teamNameLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		teamNameLabel2.setBounds(panelWidth/2+65, 130, panelWidth/2-65, 50);
		teamNameLabel2.setBackground(new Color(30,81,140));
		teamNameLabel2.setOpaque(true);
		teamNameLabel2.setText("  NBA");
		teamNameLabel2.setForeground(Color.WHITE);
		teamNameLabel2.setFont(new Font("Arial",Font.BOLD,20));
		
		
		
		JLabel vsLabel = new JLabel("VS");
		vsLabel.setBounds(panelWidth/2-65, 130, 130, 50);
		vsLabel.setBackground(new Color(42,108,182));
		vsLabel.setOpaque(true);
		vsLabel.setForeground(Color.WHITE);
		vsLabel.setFont(new Font("Arial",Font.BOLD,20));
		vsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		teamInfoPanel.setLayout(null);
		
		
		teamInfoPanel.add(teamImgPanel,0);
		teamInfoPanel.add(teamNameLabel1);
		teamInfoPanel.add(teamNameLabel2);
		teamInfoPanel.add(vsLabel);
		teamInfoPanel.add(search);
		
		JPanel choosePanel = new JPanel();
		choosePanel.setBounds(0, 230, panelWidth, 30);
		choosePanel.setBackground(new Color(218,218,218));
		cmpTypeLabel = new JLabel("赛季数据");
		cmpTypeLabel.setFont(new Font("微软雅黑",Font.BOLD,14));
		cmpTypeLabel.setBounds(panelWidth/2-50, 0, 100, 30);
		cmpTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		final ImageIcon line = new ImageIcon("Img//linechart.png");
		final ImageIcon line_c = new ImageIcon("Img//linechart_clicked.png");
		lineChartBtn = new JButton();
		lineChartBtn.setIcon(line);
		lineChartBtn.setBounds(panelWidth-30, 0, 30, 30);
		lineChartBtn.setBorder(null);
		//lineChartBtn.addActionListener(this);
		lineChartBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				lineChartBtn.setIcon(line_c);
			}
			public void mouseExited(MouseEvent e){
				lineChartBtn.setIcon(line);
			}
			public void mouseClicked(MouseEvent e){
				barChartBtn.setVisible(true);
				lineChartBtn.setVisible(false);
			}
		});
		final ImageIcon bar = new ImageIcon("Img//barchart.png");
		final ImageIcon bar_c = new ImageIcon("Img//barchart_clicked.png");
		barChartBtn = new JButton();
		barChartBtn.setIcon(bar);
		barChartBtn.setBounds(panelWidth-30, 0, 30, 30);
		barChartBtn.setBorder(null);
		barChartBtn.setVisible(false);
		//barChartBtn.addActionListener(this);
		barChartBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				barChartBtn.setIcon(bar_c);
			}
			public void mouseExited(MouseEvent e){
				barChartBtn.setIcon(bar);
			}
			public void mouseClicked(MouseEvent e){
				barChartBtn.setVisible(false);
				lineChartBtn.setVisible(true);
			}
		});
		choosePanel.setLayout(null);
		choosePanel.add(cmpTypeLabel);
		choosePanel.add(lineChartBtn);
		choosePanel.add(barChartBtn);
		
		JPanel cmpPanel = new JPanel();
		cmpPanel.setBounds(0, 260, panelWidth, 350);
		cmpPanel.setBackground(null);
		
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();   
		dataset1.addValue(94.8, "", "得分");  
		dataset1.addValue(20, "", "助攻");  
		dataset1.addValue(40.8, "", "篮板");  
		dataset1.addValue(25.6, "", "三分");  
		dataset1.addValue(77.5, "", "罚球");  
		dataset1.addValue(42, "", "%");   
		dataset1.addValue(3.75, "", "盖帽");
		dataset1.addValue(13.5, "", "失误");
		RightHorizontalBarChart team2Chart = new RightHorizontalBarChart(dataset1,new String[]{ "#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E"} );
		team2Chart.setBounds(panelWidth/2+57, 0, panelWidth/2-65, 310);
		team2Chart.setBackground(null);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
		dataset.addValue(-94.8, "", "得分");  
		dataset.addValue(-20, "", "助攻");  
		dataset.addValue(-40.8, "", "篮板");  
		dataset.addValue(-25.6, "", "三分");  
		dataset.addValue(-77.5, "", "罚球");  
		dataset.addValue(-42, "", "%");   
		dataset.addValue(-3.75, "", "盖帽");
		dataset.addValue(-13.5, "", "失误");
		LeftHorizontalBarChart team1Chart = new LeftHorizontalBarChart(dataset,new String[]{ "#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E"} );
		team1Chart.setBounds(8, 0, panelWidth/2-65, 310);
		team1Chart.setBackground(null);
		
		JPanel dataColumnPanel = new JPanel();
		dataColumnPanel.setBounds(panelWidth/2-65, 0, 131, 310);
		dataColumnPanel.setBackground(null);
		JLabel score = new JLabel("场均得分");
		score.setFont(new Font("微软雅黑",0,15));
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setBounds(0, 15, 130, 35);
		JLabel assist = new JLabel("场均助攻");
		assist.setFont(new Font("微软雅黑",0,15));
		assist.setHorizontalAlignment(SwingConstants.CENTER);
		assist.setBounds(0, 15+35, 130, 35);
		JLabel board = new JLabel("场均篮板");
		board.setFont(new Font("微软雅黑",0,15));
		board.setHorizontalAlignment(SwingConstants.CENTER);
		board.setBounds(0, 15+35*2, 130, 35);
		JLabel steal = new JLabel("场均抢断");
		steal.setFont(new Font("微软雅黑",0,15));
		steal.setHorizontalAlignment(SwingConstants.CENTER);
		steal.setBounds(0, 15+35*3, 130, 35);
		JLabel block = new JLabel("场均盖帽");
		block.setFont(new Font("微软雅黑",0,15));
		block.setHorizontalAlignment(SwingConstants.CENTER);
		block.setBounds(0, 15+35*4, 130, 35);
		JLabel three = new JLabel("三分%");
		three.setFont(new Font("微软雅黑",0,15));
		three.setHorizontalAlignment(SwingConstants.CENTER);
		three.setBounds(0, 15+35*5, 130, 35);
		JLabel free = new JLabel("罚球%");
		free.setFont(new Font("微软雅黑",0,15));
		free.setHorizontalAlignment(SwingConstants.CENTER);
		free.setBounds(0, 15+35*6, 130, 35);
		JLabel hit = new JLabel("%");
		hit.setFont(new Font("微软雅黑",0,15));
		hit.setHorizontalAlignment(SwingConstants.CENTER);
		hit.setBounds(0, 15+35*7, 130, 35);
		
		
		dataColumnPanel.setLayout(null);
		dataColumnPanel.add(score);
		dataColumnPanel.add(assist);
		dataColumnPanel.add(board);
		dataColumnPanel.add(steal);
		dataColumnPanel.add(block);
		dataColumnPanel.add(three);
		dataColumnPanel.add(free);
		dataColumnPanel.add(hit);
		
		cmpPanel.setLayout(null);
		cmpPanel.add(dataColumnPanel);
		cmpPanel.add(team1Chart);
		cmpPanel.add(team2Chart);
		
		
		this.setLayout(null);
		this.add(teamInfoPanel);
		this.add(choosePanel);
		this.add(title);
		this.add(cmpPanel);
		
	}
	
	public static DefaultCategoryDataset createDataset() {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
		 dataset.addValue(94.8, "", "得分");  
		 dataset.addValue(20, "", "助攻");  
		 dataset.addValue(40.8, "", "篮板");  
		 dataset.addValue(25.6, "", "三分");  
		 dataset.addValue(77.5, "", "罚球");  
		 dataset.addValue(42, "", "%");   
		 dataset.addValue(3.75, "", "盖帽");
		 dataset.addValue(13.5, "", "失误");
		 return dataset;
	}
}
