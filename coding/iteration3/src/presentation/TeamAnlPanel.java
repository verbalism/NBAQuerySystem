package presentation;

import java.awt.Color;
import java.awt.Cursor;
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
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;

import businesslogic.DataBL;
import businesslogicService.DataBLService;
import ui.PieChart;
import ui.SeriesChart;
import ui.SpiderWebChart;
import vo.PlayerVO;
import vo.TeamVO;

public class TeamAnlPanel extends JPanel implements ActionListener{
	int panelHeight,panelWidth;
	JLabel title;
	//DataBLService dbl = new DataBL();
	JTextField searchField;
	JButton searchBtn;
	JButton scoreBtn, shotBtn, historyBtn;
	JButton offensiveBtn,defensiveBtn;
	JComboBox seasonBox;JLabel chooseSeason;
	JButton playerNameLabel1,playerNameLabel2;
	TeamVO team;
	JPanel anlPanel;
	SeriesChart seriesChart;SpiderWebChart spiderChart;PieChart pieChart;
	public TeamAnlPanel(){
		//TeamVO team = dbl.getSingleTeamInfo("BOS");
		team = new TeamVO(); team.setTeamName("BOS");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		title = new JLabel("  球 队 历 程");
		title.setBounds(0, 10, panelWidth, 40);
		title.setBackground(new Color(87,89,91));
		title.setForeground(Color.white);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setOpaque(true);
		
		JLabel teamImgLabel = new JLabel();
		teamImgLabel.setBounds(20, 0, 120, 120);
		teamImgLabel.setBackground(null);
		ImageIcon img = new ImageIcon("Img//teams//"+team.getTeamName()+".png");
		if(team.getTeamName().equals("NOH"))
			img = new ImageIcon("Img//teams//NOP.png");
		img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
		teamImgLabel.setIcon(img);
		
		
		JLabel teamNameLabel = new JLabel(team.getFullName());
		teamNameLabel.setFont(new Font("Arial Black",0,30));
		teamNameLabel.setBounds(200, 40, 300, 35);
		teamNameLabel.setForeground(new Color(0,103,175));
		JLabel teamCityLabel = new JLabel(team.getCity()+"/"+team.getSubarea());
		teamCityLabel.setFont(new Font("Arial",0,20));
		teamCityLabel.setBounds(200, 75, 300, 50);
		teamCityLabel.setForeground(new Color(122,122,122));
		JLabel infoLabel = new JLabel();
		infoLabel.setFont(new Font("微软雅黑",0,15));
		infoLabel.setBounds(450, 30, 400, 100);
		infoLabel.setForeground(new Color(122,122,122));
		String zone;
		if(team.getZone()=="E")
			zone = "东部联盟";
		else
			zone = "西部联盟";
		infoLabel.setText("<html>"+zone+"<br>主场："+team.getHomeCourt()+"<br>建立时间："+team.getCreateTime()+"</html>");
		
		searchField = new JTextField();
		searchField.setBounds(30,0,400,30);
		searchField.setBackground(new Color(246,246,246));
		searchField.setBorder(null);
		searchField.setText("  查找球队");
		searchField.setForeground(Color.gray);
		searchField.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				searchField.setText(null);
			}
		});
		searchField.addKeyListener(new KeyAdapter(){ 
		      public void keyPressed(KeyEvent e)    
		      {    
		        if(e.getKeyChar()==KeyEvent.VK_ENTER )   //按回车键执行相应操作; 
		        { 
		          //searchBtn1.doClick();
		        } 
		      } 
		    });
		final ImageIcon find = new ImageIcon("Img//searchBtn.png");
		final ImageIcon find_c = new ImageIcon("Img//searchBtn_clicked.png");
		searchBtn = new JButton();
		searchBtn.setIcon(find);
		searchBtn.setBounds(0, 0, 30, 30);
		searchBtn.setBorder(null);
		//searchBtn1.addActionListener(this);
		searchBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				searchBtn.setIcon(find_c);
			}
			public void mouseExited(MouseEvent e){
				searchBtn.setIcon(find);
			}
		});
		JPanel search = new JPanel();
		search.setBounds(0,120,700,30);
		search.setBackground(null);
		search.setLayout(null);
		search.add(searchField);
		search.add(searchBtn);
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setBackground(null);
		basicInfoPanel.setBounds(0, 50, 700, 150);
		basicInfoPanel.setLayout(null);
		basicInfoPanel.add(teamImgLabel);
		basicInfoPanel.add(teamNameLabel);
		basicInfoPanel.add(teamCityLabel);
		basicInfoPanel.add(infoLabel);
		basicInfoPanel.add(search);
		
		anlPanel = new JPanel();
		anlPanel.setBounds(0, 200, 700, 380);
		anlPanel.setBackground(null);
		
		
		seriesChart = new SeriesChart(createSeriesDataset());
		seriesChart.setBounds(0, 60, 700, 300);
		
		spiderChart = new SpiderWebChart(createSpiderDataset());
		spiderChart.setBounds(-7, 60, 700, 300);
		
		pieChart = new PieChart(createPieDataset());
		pieChart.setBounds(0, 60, 700, 300);
		
		
		
		scoreBtn = new JButton("得分");
		shotBtn = new JButton("投篮");
		historyBtn = new JButton("历程");
		scoreBtn.setBounds(57, 10, 60, 30);
		scoreBtn.setBackground(new Color(89,89,89));
		scoreBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		scoreBtn.setFont(new Font("微软雅黑",0,14));
		scoreBtn.setForeground(Color.white);
		scoreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scoreBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				scoreBtn.setBackground(new Color(158,158,158));
				shotBtn.setBackground(new Color(89,89,89));
				historyBtn.setBackground(new Color(89,89,89));
			}
		});
		scoreBtn.addActionListener(this);
		shotBtn.setBounds(114, 10, 60, 30);
		shotBtn.setBackground(new Color(89,89,89));
		shotBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		shotBtn.setFont(new Font("微软雅黑",0,14));
		shotBtn.setForeground(Color.white);
		shotBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		shotBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				shotBtn.setBackground(new Color(158,158,158));
				scoreBtn.setBackground(new Color(89,89,89));
				historyBtn.setBackground(new Color(89,89,89));
			}
		});
		shotBtn.addActionListener(this);
		historyBtn.setBounds(0, 10, 60, 30);
		historyBtn.setBackground(new Color(158,158,158));
		historyBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		historyBtn.setFont(new Font("微软雅黑",0,14));
		historyBtn.setForeground(Color.white);
		historyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		historyBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				historyBtn.setBackground(new Color(158,158,158));
				scoreBtn.setBackground(new Color(89,89,89));
				shotBtn.setBackground(new Color(89,89,89));
			}
		});
		historyBtn.addActionListener(this);
		
		chooseSeason = new JLabel("选择赛季：");
		chooseSeason.setBounds(450, 10, 80, 30);
		chooseSeason.setFont(new Font("微软雅黑",0,15));
		chooseSeason.setForeground(new Color(69,69,69));
		String season[] = {"14-15","13-14","12-13","11-12","10-11","09-10","08-09","07-08","06-07","05-06","04-05"};
		seasonBox = new JComboBox(season);
		seasonBox.setBounds(530, 10, 150, 30);
		seasonBox.setFont(new Font("微软雅黑",0,14));
		//seasonBox.setBorder(new LineBorder(new Color(69,69,69),1,false));
		seasonBox.setForeground(new Color(69,69,69));
		seasonBox.setBackground(Color.WHITE);
		//seasonBox.addActionListener(this);
		
		anlPanel.setLayout(null);
		anlPanel.add(historyBtn);
		anlPanel.add(scoreBtn);
		anlPanel.add(shotBtn);
		anlPanel.add(seriesChart);
		
		
		offensiveBtn = new JButton("进攻");
		offensiveBtn.setBackground(new Color(69,69,69));
		offensiveBtn.setBounds(0, 0, panelWidth/2-350, 40);
		offensiveBtn.setBorder(null);
		offensiveBtn.setFont(new Font("黑体",0,14));
		offensiveBtn.setForeground(Color.WHITE);
		offensiveBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		offensiveBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				offensiveBtn.setBackground(new Color(69,69,69));
				defensiveBtn.setBackground(new Color(87,89,91));
			}
			
		});
		defensiveBtn = new JButton("防守");
		defensiveBtn.setBackground(new Color(87,89,91));
		defensiveBtn.setBounds(panelWidth/2-350, 0, panelWidth/2-350, 40);
		defensiveBtn.setBorder(null);
		defensiveBtn.setFont(new Font("黑体",0,14));
		defensiveBtn.setForeground(Color.WHITE);
		defensiveBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		defensiveBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				defensiveBtn.setBackground(new Color(69,69,69));
				offensiveBtn.setBackground(new Color(87,89,91));
			}
		});
		
		JLabel sl = new JLabel("赛季");
		sl.setBounds(0, 0, 100, 20);
		sl.setFont(new Font("黑体",0,14));
		sl.setForeground(new Color(126,126,126));
		JLabel seasonLabel = new JLabel("14-15赛季");
		seasonLabel.setBounds(0,40,300,30);
		seasonLabel.setFont(new Font("微软雅黑",0,30));
		seasonLabel.setForeground(new Color(68,68,68));
		JPanel seasonPanel = new JPanel();
		seasonPanel.setBackground(null);
		seasonPanel.setBounds(30, 60, panelWidth-700, 120);
		seasonPanel.setLayout(null);
		seasonPanel.add(sl);
		seasonPanel.add(seasonLabel);
		
		JLabel bestPlayerLabel = new JLabel("最佳球员");
		bestPlayerLabel.setBounds(0, 0, 100, 20);
		bestPlayerLabel.setFont(new Font("黑体",0,14));
		bestPlayerLabel.setForeground(new Color(126,126,126));
		JLabel playerImgLabel1 = new JLabel();
		playerImgLabel1.setBounds(0, 40, 100, 80);
		ImageIcon img1 = new ImageIcon("Img//players//portrait//"+"players.get(1).getPlayerName()"+".png");
		//if(!new File("Img//players//portrait//"+players.get(1).getPlayerName()+".png").exists())
			img1 = new ImageIcon("Img//portrait.png");
		img1.setImage(img1.getImage().getScaledInstance(75,60,Image.SCALE_DEFAULT));
		playerImgLabel1.setIcon(img1);
		playerNameLabel1 = new JButton("players");//).get(1).getPlayerName()");
		playerNameLabel1.setBounds(100, 40, 200, 30);
		playerNameLabel1.setFont(new Font("Arial Black",0,20));
		playerNameLabel1.setForeground(new Color(0,103,175));
		playerNameLabel1.setBorder(null);
		playerNameLabel1.setBackground(null);
		playerNameLabel1.setHorizontalAlignment(JButton.LEFT);
		playerNameLabel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playerNameLabel1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				playerNameLabel1.setBackground(null);
				//PlayerVO findPlayer = ps.get(1);
				//new PlayerInfoFrame(findPlayer);
			}
			
		});
		/*JLabel playerTeamLabel2 = new JLabel("players.get(1).getPosition()"+"/"+"players.get(1).getTeamName()");
		playerTeamLabel2.setFont(new Font("Arial",0,15));
		playerTeamLabel2.setBounds(130, 70, 200, 30);
		playerTeamLabel2.setForeground(new Color(68,68,68));*/
		JLabel playerScoreLabel1 = new JLabel("34.6");
		playerScoreLabel1.setFont(new Font("Modern",Font.BOLD,28));
		playerScoreLabel1.setForeground(new Color(68,68,68));
		playerScoreLabel1.setBounds(100, 70, 200, 40);
		JPanel bestPlayer = new JPanel();
		bestPlayer.setBackground(null);
		bestPlayer.setBounds(30, 180, panelWidth-700, 120);
		bestPlayer.setLayout(null);
		bestPlayer.add(bestPlayerLabel);
		bestPlayer.add(playerImgLabel1);
		bestPlayer.add(playerNameLabel1);
		bestPlayer.add(playerScoreLabel1);
		//bestPlayer.add(playerTeamLabel2);
		
		JLabel advancePlayerLabel = new JLabel("最具潜力球员");
		advancePlayerLabel.setBounds(0, 0, 100, 20);
		advancePlayerLabel.setFont(new Font("黑体",0,14));
		advancePlayerLabel.setForeground(new Color(126,126,126));
		JLabel playerImgLabel2 = new JLabel();
		playerImgLabel2.setBounds(0, 40, 100, 80);
		ImageIcon img2 = new ImageIcon("Img//players//portrait//"+"players.get(1).getPlayerName()"+".png");
		//if(!new File("Img//players//portrait//"+players.get(1).getPlayerName()+".png").exists())
			img2 = new ImageIcon("Img//portrait.png");
		img2.setImage(img2.getImage().getScaledInstance(75,60,Image.SCALE_DEFAULT));
		playerImgLabel2.setIcon(img2);
		playerNameLabel2 = new JButton("players");//).get(1).getPlayerName()");
		playerNameLabel2.setBounds(100, 40, 200, 30);
		playerNameLabel2.setFont(new Font("Arial Black",0,20));
		playerNameLabel2.setForeground(new Color(0,103,175));
		playerNameLabel2.setBorder(null);
		playerNameLabel2.setBackground(null);
		playerNameLabel2.setHorizontalAlignment(JButton.LEFT);
		playerNameLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playerNameLabel2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				playerNameLabel2.setBackground(null);
				//PlayerVO findPlayer = ps.get(1);
				//new PlayerInfoFrame(findPlayer);
			}
			
		});
		/*JLabel playerTeamLabel2 = new JLabel("players.get(1).getPosition()"+"/"+"players.get(1).getTeamName()");
		playerTeamLabel2.setFont(new Font("Arial",0,15));
		playerTeamLabel2.setBounds(130, 70, 200, 30);
		playerTeamLabel2.setForeground(new Color(68,68,68));*/
		JLabel playerScoreLabel2 = new JLabel("34.6");
		playerScoreLabel2.setFont(new Font("Modern",Font.BOLD,28));
		playerScoreLabel2.setForeground(new Color(68,68,68));
		playerScoreLabel2.setBounds(100, 70, 200, 40);
		JPanel advancePlayer = new JPanel();
		advancePlayer.setBackground(null);
		advancePlayer.setBounds(30, 320, panelWidth-700, 120);
		advancePlayer.setLayout(null);
		advancePlayer.add(advancePlayerLabel);
		advancePlayer.add(playerImgLabel2);
		advancePlayer.add(playerNameLabel2);
		advancePlayer.add(playerScoreLabel2);
		
		
		
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBounds(700, 60, panelWidth-700, 520);
		playerPanel.setBackground(null);
		playerPanel.setLayout(null);
		playerPanel.add(offensiveBtn);
		playerPanel.add(defensiveBtn);
		playerPanel.add(seasonPanel);
		playerPanel.add(bestPlayer);
		playerPanel.add(advancePlayer);
		
		
		this.setLayout(null);
		this.add(title);
		this.add(basicInfoPanel);
		this.add(anlPanel);
		this.add(playerPanel);
	}
	
	public DefaultCategoryDataset createSeriesDataset() {
		 DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		 // 曲线名称
		 String series1 = "得分";  // series指的就是报表里的那条数据线
                        //因此 对数据线的相关设置就需要联系到serise
                        //比如说setSeriesPaint 设置数据线的颜色

		 // 横轴名称(列名称) 
		 String series2 = "进攻";
		 String series3 = "防守";
		 String[] time = new String[11];
		 String[] timeValue = { "04-05", "05-06", "06-07", "07-08", "08-09", "09-10",
                     "10-11", "11-12", "12-13", "13-14", "14-15"};
		 for (int i = 0; i < 11; i++) {
			 time[i] = timeValue[i];
		 }
		 //随机添加数据值
		 for (int i = 0; i < 11; i++) {
			 linedataset.addValue(i + i * 9.34 ,  //值
					 series1,  //哪条数据线
					 time[i]); // 对应的横轴
			 linedataset.addValue(i + i * 23.2 ,  //值
					 series2,  //哪条数据线
					 time[i]); // 对应的横轴
			 linedataset.addValue(i + i * 14.34 ,  //值
					 series3,  //哪条数据线
					 time[i]); // 对应的横轴
		 }

		 return linedataset;
		
	}
	
	private static DefaultCategoryDataset createSpiderDataset()
	 {
	  String s = "First";
	  String s3 = "%";
	  String s4 = "三分%";
	  String s5 = "罚球%";
	  DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
	  defaultcategorydataset.addValue(30.7, s, s3);
	  defaultcategorydataset.addValue(42.77, s, s4);
	  defaultcategorydataset.addValue(56.2, s, s5);
	  return defaultcategorydataset;
	 }
	
	public static DefaultPieDataset createPieDataset() {  
        DefaultPieDataset pieDataset = new DefaultPieDataset();  
        pieDataset.setValue("二分投篮", 64);  
        pieDataset.setValue("三分投篮", 36);  
        pieDataset.setValue("罚球 ", 14);  
        return pieDataset;  
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==historyBtn){
			anlPanel.removeAll();
			anlPanel.add(historyBtn);
			anlPanel.add(scoreBtn);
			anlPanel.add(shotBtn);
			anlPanel.add(seriesChart);
			anlPanel.repaint();
		}
		if(e.getSource()==scoreBtn){
			anlPanel.removeAll();
			anlPanel.add(historyBtn);
			anlPanel.add(scoreBtn);
			anlPanel.add(shotBtn);
			anlPanel.add(seasonBox);
			anlPanel.add(chooseSeason);
			anlPanel.add(pieChart);
			anlPanel.repaint();
		}
		if(e.getSource()==shotBtn){
			anlPanel.removeAll();
			anlPanel.add(historyBtn);
			anlPanel.add(scoreBtn);
			anlPanel.add(shotBtn);
			anlPanel.add(seasonBox);
			anlPanel.add(chooseSeason);
			anlPanel.add(spiderChart);
			anlPanel.repaint();
		}
		
	}  
	
}
