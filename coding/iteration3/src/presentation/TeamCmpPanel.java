package presentation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.data.category.DefaultCategoryDataset;

import ui.LeftHorizontalBarChart;
import ui.RightHorizontalBarChart;
import ui.SeriesChart;

public class TeamCmpPanel extends JPanel implements ActionListener{
	int panelHeight,panelWidth;
	ImageIcon img1,img2;
	JLabel teamImgLabel1,teamImgLabel2;
	JLabel teamNameLabel1 = new JLabel(), teamNameLabel2 = new JLabel();
	JLabel cmpTypeLabel;
	JTextField searchField1,searchField2;
	JButton searchBtn1,searchBtn2;
	JButton lineChartBtn, barChartBtn;
	JPanel cmpPanel, dataColumnPanel, selectPanel;
	LeftHorizontalBarChart team1Chart;RightHorizontalBarChart team2Chart;
	SeriesChart seriesChart;
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
		lineChartBtn.addActionListener(this);
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
		barChartBtn.addActionListener(this);
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
		
		cmpPanel = new JPanel();
		cmpPanel.setBounds(0, 260, panelWidth, 350);
		cmpPanel.setBackground(null);
		
		
		team2Chart = new RightHorizontalBarChart(createTeam2BarDataset(),new String[]{ "#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E"} );
		team2Chart.setBounds(panelWidth/2+57, 0, panelWidth/2-65, 310);
		team2Chart.setBackground(null);
		
	
		team1Chart = new LeftHorizontalBarChart(createTeam1BarDataset(),new String[]{ "#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E","#9E9E9E"} );
		team1Chart.setBounds(8, 0, panelWidth/2-65, 310);
		team1Chart.setBackground(null);
		
		dataColumnPanel = new JPanel();
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
		
		selectPanel = new JPanel();
		selectPanel.setBounds(730, 20, 300, 300);
		selectPanel.setBackground(null);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton jrbScore = new JRadioButton("场均得分");
		jrbScore.setBackground(null);
		jrbScore.setSelected(true);
		jrbScore.setBounds(0, 0, 200, 30);
		jrbScore.setFont(new Font("微软雅黑",0,15));
		JRadioButton jrbAssist = new JRadioButton("场均助攻");
		jrbAssist.setBackground(null);
		jrbAssist.setBounds(0, 30, 200, 30);
		jrbAssist.setFont(new Font("微软雅黑",0,15));
		JRadioButton jrbBoard = new JRadioButton("场均篮板");
		jrbBoard.setBackground(null);
		jrbBoard.setBounds(0, 60, 200, 30);
		jrbBoard.setFont(new Font("微软雅黑",0,15));
		JRadioButton jrbSteal = new JRadioButton("场均抢断");
		jrbSteal.setBackground(null);
		jrbSteal.setBounds(0, 90, 200, 30);
		jrbSteal.setFont(new Font("微软雅黑",0,15));
		JRadioButton jrbBlock = new JRadioButton("场均盖帽");
		jrbBlock.setBackground(null);
		jrbBlock.setBounds(0, 120, 200, 30);
		jrbBlock.setFont(new Font("微软雅黑",0,15));
		JRadioButton jrbThree = new JRadioButton("三分%");
		jrbThree.setBackground(null);
		jrbThree.setBounds(0, 150, 200, 30);
		jrbThree.setFont(new Font("微软雅黑",0,15));
		JRadioButton jrbFree = new JRadioButton("罚球%");
		jrbFree.setBackground(null);
		jrbFree.setBounds(0, 180, 200, 30);
		jrbFree.setFont(new Font("微软雅黑",0,15));
		JRadioButton jrbHit = new JRadioButton("%");
		jrbHit.setBackground(null);
		jrbHit.setBounds(0, 210, 200, 30);
		jrbHit.setFont(new Font("微软雅黑",0,15));
		bg.add(jrbScore);
		bg.add(jrbAssist);
		bg.add(jrbBoard);
		bg.add(jrbSteal);
		bg.add(jrbBlock);
		bg.add(jrbThree);
		bg.add(jrbFree);
		bg.add(jrbHit);
		selectPanel.setLayout(null);
		selectPanel.add(jrbScore);
		selectPanel.add(jrbAssist);
		selectPanel.add(jrbBoard);
		selectPanel.add(jrbSteal);
		selectPanel.add(jrbBlock);
		selectPanel.add(jrbThree);
		selectPanel.add(jrbFree);
		selectPanel.add(jrbHit);
		
		
		seriesChart = new SeriesChart(createSeriesDataset());
		seriesChart.setBounds(0, 20, 700, 300);
		
		
		
		cmpPanel.setLayout(null);
		cmpPanel.add(dataColumnPanel);
		cmpPanel.add(team1Chart);
		cmpPanel.add(team2Chart);
		//cmpPanel.add(seriesChart);
		//cmpPanel.add(selectPanel);
		
		this.setLayout(null);
		this.add(teamInfoPanel);
		this.add(choosePanel);
		this.add(title);
		this.add(cmpPanel);
		
	}
	
	public static DefaultCategoryDataset createTeam1BarDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
		dataset.addValue(-94.8, "", "得分");  
		dataset.addValue(-20, "", "助攻");  
		dataset.addValue(-40.8, "", "篮板");  
		dataset.addValue(-25.6, "", "三分");  
		dataset.addValue(-77.5, "", "罚球");  
		dataset.addValue(-42, "", "%");   
		dataset.addValue(-3.75, "", "盖帽");
		dataset.addValue(-13.5, "", "失误");
		 return dataset;
	}
	
	public static DefaultCategoryDataset createTeam2BarDataset(){
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lineChartBtn){
			cmpPanel.removeAll();
			cmpPanel.add(seriesChart);
			cmpPanel.add(selectPanel);
			cmpPanel.repaint();
		}
		if(e.getSource()==barChartBtn){
			cmpPanel.removeAll();
			cmpPanel.add(dataColumnPanel);
			cmpPanel.add(team1Chart);
			cmpPanel.add(team2Chart);
			cmpPanel.repaint();
		}
	}
	
	public DefaultCategoryDataset createSeriesDataset() {
		 DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		 // 曲线名称
		 String series1 = "BOS";  // series指的就是报表里的那条数据线
                       //因此 对数据线的相关设置就需要联系到serise
                       //比如说setSeriesPaint 设置数据线的颜色

		 // 横轴名称(列名称) 
		 String series2 = "NBA";
		 //String series3 = "防守";
		 String[] time = new String[11];
		 String[] timeValue = { "04-05", "05-06", "06-07", "07-08", "08-09", "09-10",
                    "10-11", "11-12", "12-13", "13-14", "14-15"};
		 for (int i = 0; i < 11; i++) {
			 time[i] = timeValue[i];
		 }
		 //随机添加数据值
		 for (int i = 0; i < 11; i++) {
			 linedataset.addValue(i + i * 9.34 + 3/(i+1),  //值
					 series1,  //哪条数据线
					 time[i]); // 对应的横轴
			 linedataset.addValue(i + i * 23.2 -22/(i+1),  //值
					 series2,  //哪条数据线
					 time[i]); // 对应的横轴
			// linedataset.addValue(i + i * 14.34 ,  //值
			//		 series3,  //哪条数据线
			//		 time[i]); // 对应的横轴
		 }

		 return linedataset;
		
	}
}
