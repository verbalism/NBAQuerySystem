package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import vo.PlayerVO;
import vo.TeamVO;
import vo.TodayPlayerVO;
import businesslogic.AnalysisBL;
import businesslogicService.AnalysisBLService;

public class HotPanel extends JPanel implements ActionListener{
	int panelWidth,panelHeight;
	JTextField searchField;
	JButton searchBtn,todayBtn,allBtn,advanceBtn,teamBtn;
	JButton tdScoreBtn, tdBackBordBtn,tdAssistBtn,tdBlockShotBtn,tdSTBtn;
	JButton allScoreBtn, allBackBordBtn,allAssistBtn,allBlockShotBtn,allSTBtn,all3Btn,allShotBtn,allPenaltyBtn;
	JButton adScoreBtn, adBackBordBtn,adAssistBtn;
	boolean sortTeam = false;
	JLabel title;
	JPanel todayPlayerSortPanel,advanceSortPanel,allSortPanel;
	TodayHotPlayerPanel tdplayerResultPanel;
	HotPlayerPanel playerResultPanel;
	HotTeamPanel teamResultPanel;
	AnalysisBLService abl = new AnalysisBL();
	public HotPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
	
		
		todayPlayerSortPanel = new JPanel();
		todayPlayerSortPanel.setBounds(0, 60, panelWidth, 40);
		todayPlayerSortPanel.setBackground(new Color(222,222,222));
		tdScoreBtn = new JButton("得  分");
		tdScoreBtn.setFont(new Font("微软雅黑",0,14));
		tdScoreBtn.setBackground(new Color(200,200,200));
		tdScoreBtn.setBounds(0, 0, panelWidth/5, 40);
		tdScoreBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		tdScoreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tdScoreBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				tdScoreBtn.setBackground(new Color(200,200,200));
				tdBackBordBtn.setBackground(null);
				tdAssistBtn.setBackground(null);
				tdBlockShotBtn.setBackground(null);
				tdSTBtn.setBackground(null);
			}
		});
		tdScoreBtn.addActionListener(this);
		tdBackBordBtn = new JButton("蓝  板");
		tdBackBordBtn.setFont(new Font("微软雅黑",0,14));
		tdBackBordBtn.setBackground(null);
		tdBackBordBtn.setBounds(panelWidth/5, 0, panelWidth/5, 40);
		tdBackBordBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		tdBackBordBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tdBackBordBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				tdBackBordBtn.setBackground(new Color(200,200,200));
				tdScoreBtn.setBackground(null);
				tdAssistBtn.setBackground(null);
				tdBlockShotBtn.setBackground(null);
				tdSTBtn.setBackground(null);
			}
		});
		tdBackBordBtn.addActionListener(this);
		tdAssistBtn = new JButton("助  攻");
		tdAssistBtn.setFont(new Font("微软雅黑",0,14));
		tdAssistBtn.setBackground(null);
		tdAssistBtn.setBounds(panelWidth/5*2, 0, panelWidth/5, 40);
		tdAssistBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		tdAssistBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tdAssistBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				tdAssistBtn.setBackground(new Color(200,200,200));
				tdBackBordBtn.setBackground(null);
				tdScoreBtn.setBackground(null);
				tdBlockShotBtn.setBackground(null);
				tdSTBtn.setBackground(null);
			}
		});
		tdAssistBtn.addActionListener(this);
		tdBlockShotBtn = new JButton("盖  帽");
		tdBlockShotBtn.setFont(new Font("微软雅黑",0,14));
		tdBlockShotBtn.setBackground(null);
		tdBlockShotBtn.setBounds(panelWidth/5*3, 0, panelWidth/5, 40);
		tdBlockShotBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		tdBlockShotBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tdBlockShotBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				tdBlockShotBtn.setBackground(new Color(200,200,200));
				tdBackBordBtn.setBackground(null);
				tdAssistBtn.setBackground(null);
				tdScoreBtn.setBackground(null);
				tdSTBtn.setBackground(null);
			}
		});
		tdBlockShotBtn.addActionListener(this);
		tdSTBtn = new JButton("抢  断");
		tdSTBtn.setFont(new Font("微软雅黑",0,14));
		tdSTBtn.setBackground(null);
		tdSTBtn.setBounds(panelWidth/5*4,0, panelWidth/5, 40);
		tdSTBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		tdSTBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tdSTBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				tdSTBtn.setBackground(new Color(200,200,200));
				tdBackBordBtn.setBackground(null);
				tdAssistBtn.setBackground(null);
				tdBlockShotBtn.setBackground(null);
				tdScoreBtn.setBackground(null);
			}
		});
		tdSTBtn.addActionListener(this);
		todayPlayerSortPanel.setLayout(null);
		todayPlayerSortPanel.add(tdScoreBtn);
		todayPlayerSortPanel.add(tdBackBordBtn);
		todayPlayerSortPanel.add(tdAssistBtn);
		todayPlayerSortPanel.add(tdBlockShotBtn);
		todayPlayerSortPanel.add(tdSTBtn);
		
		
		advanceSortPanel = new JPanel();
		advanceSortPanel.setBounds(0, 60, panelWidth, 40);
		advanceSortPanel.setBackground(new Color(222,222,222));
		adScoreBtn = new JButton("场均得分");
		adScoreBtn.setFont(new Font("微软雅黑",0,14));
		adScoreBtn.setBackground(new Color(200,200,200));
		adScoreBtn.setBounds(0, 0, panelWidth/3, 40);
		adScoreBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		adScoreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adScoreBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				adScoreBtn.setBackground(new Color(200,200,200));
				adBackBordBtn.setBackground(null);
				adAssistBtn.setBackground(null);
			}
		});
		adScoreBtn.addActionListener(this);
		adBackBordBtn = new JButton("场均蓝板");
		adBackBordBtn.setFont(new Font("微软雅黑",0,14));
		adBackBordBtn.setBackground(null);
		adBackBordBtn.setBounds(panelWidth/3, 0, panelWidth/3, 40);
		adBackBordBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		adBackBordBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adBackBordBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				adBackBordBtn.setBackground(new Color(200,200,200));
				adScoreBtn.setBackground(null);
				adAssistBtn.setBackground(null);
			}
		});
		adBackBordBtn.addActionListener(this);
		adAssistBtn = new JButton("场均助攻");
		adAssistBtn.setFont(new Font("微软雅黑",0,14));
		adAssistBtn.setBackground(null);
		adAssistBtn.setBounds(panelWidth/3*2, 0, panelWidth/3, 40);
		adAssistBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		adAssistBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adAssistBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				adAssistBtn.setBackground(new Color(200,200,200));
				adBackBordBtn.setBackground(null);
				adScoreBtn.setBackground(null);
			}
		});
		adAssistBtn.addActionListener(this);
		advanceSortPanel.setLayout(null);
		advanceSortPanel.add(adScoreBtn);
		advanceSortPanel.add(adBackBordBtn);
		advanceSortPanel.add(adAssistBtn);
		
		
		
		
		allSortPanel = new JPanel();
		allSortPanel.setBounds(0, 60, panelWidth, 40);
		allSortPanel.setBackground(new Color(222,222,222));
		allScoreBtn = new JButton("场均得分");
		allScoreBtn.setFont(new Font("微软雅黑",0,14));
		allScoreBtn.setBackground(new Color(200,200,200));
		allScoreBtn.setBounds(0, 0, panelWidth/8, 40);
		allScoreBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		allScoreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allScoreBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allScoreBtn.setBackground(new Color(200,200,200));
				allBackBordBtn.setBackground(null);
				allAssistBtn.setBackground(null);
				allBlockShotBtn.setBackground(null);
				allSTBtn.setBackground(null);
				all3Btn.setBackground(null);
				allShotBtn.setBackground(null);
				allPenaltyBtn.setBackground(null);
			}
		});
		allScoreBtn.addActionListener(this);
		allBackBordBtn = new JButton("场均蓝板");
		allBackBordBtn.setFont(new Font("微软雅黑",0,14));
		allBackBordBtn.setBackground(null);
		allBackBordBtn.setBounds(panelWidth/8, 0, panelWidth/8, 40);
		allBackBordBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		allBackBordBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allBackBordBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allBackBordBtn.setBackground(new Color(200,200,200));
				allScoreBtn.setBackground(null);
				allAssistBtn.setBackground(null);
				allBlockShotBtn.setBackground(null);
				allSTBtn.setBackground(null);
				all3Btn.setBackground(null);
				allShotBtn.setBackground(null);
				allPenaltyBtn.setBackground(null);
			}
		});
		allBackBordBtn.addActionListener(this);
		allAssistBtn = new JButton("场均助攻");
		allAssistBtn.setFont(new Font("微软雅黑",0,14));
		allAssistBtn.setBackground(null);
		allAssistBtn.setBounds(panelWidth/8*2, 0, panelWidth/8, 40);
		allAssistBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		allAssistBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allAssistBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allAssistBtn.setBackground(new Color(200,200,200));
				allBackBordBtn.setBackground(null);
				allScoreBtn.setBackground(null);
				allBlockShotBtn.setBackground(null);
				allSTBtn.setBackground(null);
				all3Btn.setBackground(null);
				allShotBtn.setBackground(null);
				allPenaltyBtn.setBackground(null);
			}
		});
		allAssistBtn.addActionListener(this);
		allBlockShotBtn = new JButton("场均盖帽");
		allBlockShotBtn.setFont(new Font("微软雅黑",0,14));
		allBlockShotBtn.setBackground(null);
		allBlockShotBtn.setBounds(panelWidth/8*3, 0, panelWidth/8, 40);
		allBlockShotBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		allBlockShotBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allBlockShotBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allBlockShotBtn.setBackground(new Color(200,200,200));
				allBackBordBtn.setBackground(null);
				allAssistBtn.setBackground(null);
				allScoreBtn.setBackground(null);
				allSTBtn.setBackground(null);
				all3Btn.setBackground(null);
				allShotBtn.setBackground(null);
				allPenaltyBtn.setBackground(null);
			}
		});
		allBlockShotBtn.addActionListener(this);
		allSTBtn = new JButton("场均抢断");
		allSTBtn.setFont(new Font("微软雅黑",0,14));
		allSTBtn.setBackground(null);
		allSTBtn.setBounds(panelWidth/8*4,0, panelWidth/8, 40);
		allSTBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		allSTBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allSTBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allSTBtn.setBackground(new Color(200,200,200));
				allBackBordBtn.setBackground(null);
				allAssistBtn.setBackground(null);
				allBlockShotBtn.setBackground(null);
				allScoreBtn.setBackground(null);
				all3Btn.setBackground(null);
				allShotBtn.setBackground(null);
				allPenaltyBtn.setBackground(null);
			}
		});
		allSTBtn.addActionListener(this);
		all3Btn = new JButton("三分命中率");
		all3Btn.setFont(new Font("微软雅黑",0,14));
		all3Btn.setBackground(null);
		all3Btn.setBounds(panelWidth/8*5,0, panelWidth/8, 40);
		all3Btn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		all3Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		all3Btn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				all3Btn.setBackground(new Color(200,200,200));
				allBackBordBtn.setBackground(null);
				allAssistBtn.setBackground(null);
				allBlockShotBtn.setBackground(null);
				allScoreBtn.setBackground(null);
				allSTBtn.setBackground(null);
				allShotBtn.setBackground(null);
				allPenaltyBtn.setBackground(null);
			}
		});
		all3Btn.addActionListener(this);
		allShotBtn = new JButton("投篮命中率");
		allShotBtn.setFont(new Font("微软雅黑",0,14));
		allShotBtn.setBackground(null);
		allShotBtn.setBounds(panelWidth/8*6,0, panelWidth/8, 40);
		allShotBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		allShotBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allShotBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allShotBtn.setBackground(new Color(200,200,200));
				allBackBordBtn.setBackground(null);
				allAssistBtn.setBackground(null);
				allBlockShotBtn.setBackground(null);
				allScoreBtn.setBackground(null);
				all3Btn.setBackground(null);
				allSTBtn.setBackground(null);
				allPenaltyBtn.setBackground(null);
			}
		});
		allShotBtn.addActionListener(this);
		allPenaltyBtn = new JButton("罚球命中率");
		allPenaltyBtn.setFont(new Font("微软雅黑",0,14));
		allPenaltyBtn.setBackground(null);
		allPenaltyBtn.setBounds(panelWidth/8*7,0, panelWidth/8, 40);
		allPenaltyBtn.setBorder(new LineBorder(new Color(246,246,246),1,false));
		allPenaltyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allPenaltyBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allPenaltyBtn.setBackground(new Color(200,200,200));
				allBackBordBtn.setBackground(null);
				allAssistBtn.setBackground(null);
				allBlockShotBtn.setBackground(null);
				allScoreBtn.setBackground(null);
				all3Btn.setBackground(null);
				allShotBtn.setBackground(null);
				allSTBtn.setBackground(null);
			}
		});
		allPenaltyBtn.addActionListener(this);
		allSortPanel.setLayout(null);
		allSortPanel.add(allScoreBtn);
		allSortPanel.add(allBackBordBtn);
		allSortPanel.add(allAssistBtn);
		allSortPanel.add(allBlockShotBtn);
		allSortPanel.add(allSTBtn);
		allSortPanel.add(all3Btn);
		allSortPanel.add(allShotBtn);
		allSortPanel.add(allPenaltyBtn);
		
		
		
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 10, panelWidth, 50);
		searchPanel.setBackground(new Color(87,89,91));
		title = new JLabel("今 日 热 点 球 员");
		title.setBounds(20,0,200,50);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		
		allBtn = new JButton("赛季");
		todayBtn = new JButton("今日");
		advanceBtn = new JButton("进步");
		todayBtn.setBounds(panelWidth-241, 10, 60, 30);
		todayBtn.setBackground(new Color(158,158,158));
		todayBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		todayBtn.setFont(new Font("微软雅黑",0,14));
		todayBtn.setForeground(Color.white);
		todayBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		todayBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				todayBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
				advanceBtn.setBackground(null);
				teamBtn.setBackground(null);
				title.setText("今 日 热 点 球 员");
				sortTeam = false;
			}
		});
		todayBtn.addActionListener(this);
		allBtn.setBounds(panelWidth-184, 10, 60, 30);
		allBtn.setBackground(null);
		allBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		allBtn.setFont(new Font("微软雅黑",0,14));
		allBtn.setForeground(Color.white);
		allBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allBtn.setBackground(new Color(158,158,158));
				todayBtn.setBackground(null);
				advanceBtn.setBackground(null);
				teamBtn.setBackground(null);
				title.setText("赛 季 热 点 球 员");
				sortTeam = false;
			}
		});
		allBtn.addActionListener(this);
		advanceBtn.setBounds(panelWidth-127, 10, 60, 30);
		advanceBtn.setBackground(null);
		advanceBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		advanceBtn.setFont(new Font("微软雅黑",0,14));
		advanceBtn.setForeground(Color.white);
		advanceBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		advanceBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				advanceBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
				todayBtn.setBackground(null);
				teamBtn.setBackground(null);
				title.setText("进 步 最 快 球 员");
				sortTeam = false;
			}
		});
		advanceBtn.addActionListener(this);
		teamBtn = new JButton("球队");
		teamBtn.setBounds(panelWidth-70, 10, 60, 30);
		teamBtn.setBackground(null);
		teamBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		teamBtn.setFont(new Font("微软雅黑",0,14));
		teamBtn.setForeground(Color.white);
		teamBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
				todayBtn.setBackground(null);
				advanceBtn.setBackground(null);
				title.setText("热 点 球 队");
				sortTeam = true;
			}
		});
		teamBtn.addActionListener(this);
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(allBtn);
		searchPanel.add(todayBtn);
		searchPanel.add(advanceBtn);
		searchPanel.add(teamBtn);
		
		
		ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("points","14_15");
		teamResultPanel = new HotTeamPanel(teams,"allScore");
		ArrayList<PlayerVO> players2 = abl.getSeasonHotSpotPlayer("points","14_15");
		playerResultPanel = new HotPlayerPanel(players2,"allScore");
		ArrayList<TodayPlayerVO> players = abl.getTodayHotSpotPlayer("score");
		tdplayerResultPanel = new TodayHotPlayerPanel(players,"tdScore");
		
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.add(searchPanel);
		this.add(todayPlayerSortPanel);
		this.add(tdplayerResultPanel);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==allBtn||e.getSource()==teamBtn){
			allScoreBtn.setBackground(new Color(200,200,200));
			allBackBordBtn.setBackground(null);
			allAssistBtn.setBackground(null);
			allBlockShotBtn.setBackground(null);
			allSTBtn.setBackground(null);
			all3Btn.setBackground(null);
			allShotBtn.setBackground(null);
			allPenaltyBtn.setBackground(null);
			this.remove(todayPlayerSortPanel);
			this.remove(advanceSortPanel);
			this.add(allSortPanel);
			this.remove(playerResultPanel);
			this.remove(teamResultPanel);
			this.remove(tdplayerResultPanel);
			if(e.getSource()==allBtn){
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("points","14_15");
				playerResultPanel = new HotPlayerPanel(players,"allScore");
				this.add(playerResultPanel);
			}
			else{
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("points","14_15");
				teamResultPanel = new HotTeamPanel(teams,"allScore");
				this.add(teamResultPanel);
			}
			this.repaint();
		}
		if(e.getSource()==todayBtn){
			tdScoreBtn.setBackground(new Color(200,200,200));
			tdBackBordBtn.setBackground(null);
			tdAssistBtn.setBackground(null);
			tdBlockShotBtn.setBackground(null);
			tdSTBtn.setBackground(null);
			this.remove(allSortPanel);
			this.remove(advanceSortPanel);
			this.add(todayPlayerSortPanel);
			this.remove(tdplayerResultPanel);
			this.remove(playerResultPanel);
			this.remove(teamResultPanel);
			ArrayList<TodayPlayerVO> players = abl.getTodayHotSpotPlayer("score");
			tdplayerResultPanel = new TodayHotPlayerPanel(players,"tdScore");
			this.add(tdplayerResultPanel);
			this.repaint();
		}
		if(e.getSource()==advanceBtn){
			adScoreBtn.setBackground(new Color(200,200,200));
			adBackBordBtn.setBackground(null);
			adAssistBtn.setBackground(null);
			this.remove(allSortPanel);
			this.remove(todayPlayerSortPanel);
			this.add(advanceSortPanel);
			this.remove(tdplayerResultPanel);
			this.remove(playerResultPanel);
			this.remove(teamResultPanel);
			ArrayList<PlayerVO> players = abl.getProgressivePlayer("increaseOfPoints","14_15");
			playerResultPanel = new HotPlayerPanel(players,"adScore");
			this.add(playerResultPanel);
			this.repaint();
		}
		
		if(e.getSource()==tdScoreBtn){
			this.remove(tdplayerResultPanel);
			ArrayList<TodayPlayerVO> players = abl.getTodayHotSpotPlayer("score");
			tdplayerResultPanel = new TodayHotPlayerPanel(players,"tdScore");
			this.add(tdplayerResultPanel);
			this.repaint();
		}
		if(e.getSource()==tdBackBordBtn){
			this.remove(tdplayerResultPanel);
			ArrayList<TodayPlayerVO> players = abl.getTodayHotSpotPlayer("rebound");
			tdplayerResultPanel = new TodayHotPlayerPanel(players,"tdBackBord");
			this.add(tdplayerResultPanel);
			this.repaint();
		}
		if(e.getSource()==tdAssistBtn){
			this.remove(tdplayerResultPanel);
			ArrayList<TodayPlayerVO> players = abl.getTodayHotSpotPlayer("assist");
			tdplayerResultPanel = new TodayHotPlayerPanel(players,"tdAssist");
			this.add(tdplayerResultPanel);
			this.repaint();
		}
		if(e.getSource()==tdBlockShotBtn){
			this.remove(tdplayerResultPanel);
			ArrayList<TodayPlayerVO> players = abl.getTodayHotSpotPlayer("blockShot");
			tdplayerResultPanel = new TodayHotPlayerPanel(players,"tdBlockShot");
			this.add(tdplayerResultPanel);
			this.repaint();
		}
		if(e.getSource()==tdSTBtn){
			this.remove(tdplayerResultPanel);
			ArrayList<TodayPlayerVO> players = abl.getTodayHotSpotPlayer("st");
			tdplayerResultPanel = new TodayHotPlayerPanel(players,"tdST");
			this.add(tdplayerResultPanel);
			this.repaint();
		}
		
		if(e.getSource()==allScoreBtn){
			if(sortTeam){
				this.remove(teamResultPanel);
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("points","14_15");
				teamResultPanel = new HotTeamPanel(teams,"allScore");
				this.add(teamResultPanel);
			}
			else{
				this.remove(playerResultPanel);
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("points","14_15");
				playerResultPanel = new HotPlayerPanel(players,"allScore");
				this.add(playerResultPanel);
			}
			this.repaint();
		} 
		
		if(e.getSource()==allBackBordBtn){
			if(sortTeam){
				this.remove(teamResultPanel);
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("rebounds","14_15");
				teamResultPanel = new HotTeamPanel(teams,"allBackBord");
				this.add(teamResultPanel);
			}
			else{
				this.remove(playerResultPanel);
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("rebounds","14_15");
				playerResultPanel = new HotPlayerPanel(players,"allBackBord");
				this.add(playerResultPanel);
			}
			this.repaint();
		}
		if(e.getSource()==allAssistBtn){
			if(sortTeam){
				this.remove(teamResultPanel);
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("assists","14_15");
				teamResultPanel = new HotTeamPanel(teams,"allAssist");
				this.add(teamResultPanel);
			}
			else{
				this.remove(playerResultPanel);
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("assists","14_15");
				playerResultPanel = new HotPlayerPanel(players,"allAssist");
				this.add(playerResultPanel);
			}
			this.repaint();
		}
		if(e.getSource()==allBlockShotBtn){
			if(sortTeam){
				this.remove(teamResultPanel);
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("blocks","14_15");
				teamResultPanel = new HotTeamPanel(teams,"allBlockShot");
				this.add(teamResultPanel);
			}
			else{
				this.remove(playerResultPanel);
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("blocks","14_15");
				playerResultPanel = new HotPlayerPanel(players,"allBlockShot");
				this.add(playerResultPanel);
			}
			this.repaint();
		}
		if(e.getSource()==allSTBtn){
			if(sortTeam){
				this.remove(teamResultPanel);
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("steals","14_15");
				teamResultPanel = new HotTeamPanel(teams,"allST");
				this.add(teamResultPanel);
			}
			else{
				this.remove(playerResultPanel);
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("steals","14_15");
				playerResultPanel = new HotPlayerPanel(players,"allST");
				this.add(playerResultPanel);
			}
			this.repaint();
		}
		if(e.getSource()==all3Btn){
			if(sortTeam){
				this.remove(teamResultPanel);
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("threePointFieldGoalPercentage","14_15");
				teamResultPanel = new HotTeamPanel(teams,"all3");
				this.add(teamResultPanel);
			}
			else{
				this.remove(playerResultPanel);
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("threePointFieldGoalsPercentage","14_15");
				playerResultPanel = new HotPlayerPanel(players,"all3");
				this.add(playerResultPanel);
			}
			this.repaint();
		}
		if(e.getSource()==allShotBtn){
			if(sortTeam){
				this.remove(teamResultPanel);
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("fieldGoalPercentage","14_15");
				teamResultPanel = new HotTeamPanel(teams,"allShot");
				this.add(teamResultPanel);
			}
			else{
				this.remove(playerResultPanel);
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("fieldGoalsPercentage","14_15");
				playerResultPanel = new HotPlayerPanel(players,"allShot");
				this.add(playerResultPanel);
			}
			this.repaint();
		}
		if(e.getSource()==allPenaltyBtn){
			if(sortTeam){
				this.remove(teamResultPanel);
				ArrayList<TeamVO> teams = abl.getSeasonHotSpotTeam("freeThrowPercentage","14_15");
				teamResultPanel = new HotTeamPanel(teams,"allPenalty");
				this.add(teamResultPanel);
			}
			else{
				this.remove(playerResultPanel);
				ArrayList<PlayerVO> players = abl.getSeasonHotSpotPlayer("freeThrowsPercentage","14_15");
				playerResultPanel = new HotPlayerPanel(players,"allPenalty");
				this.add(playerResultPanel);
			}
			this.repaint();
		}
		
		if(e.getSource()==adScoreBtn){
			this.remove(playerResultPanel);
			ArrayList<PlayerVO> players = abl.getProgressivePlayer("increaseOfPoints","14_15");
			playerResultPanel = new HotPlayerPanel(players,"adScore");
			this.add(playerResultPanel);
			this.repaint();
		}
		if(e.getSource()==adBackBordBtn){
			this.remove(playerResultPanel);
			ArrayList<PlayerVO> players = abl.getProgressivePlayer("increaseOfRebounds","14_15");
			playerResultPanel = new HotPlayerPanel(players,"adBackBord");
			this.add(playerResultPanel);
			this.repaint();
		}
		if(e.getSource()==adAssistBtn){
			this.remove(playerResultPanel);
			ArrayList<PlayerVO> players = abl.getProgressivePlayer("increaseOfAssists","14_15");
			playerResultPanel = new HotPlayerPanel(players,"adAssist");
			this.add(playerResultPanel);
			this.repaint();
		}
	}
}