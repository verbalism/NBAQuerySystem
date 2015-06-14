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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import businesslogic.DataBL;
import businesslogicService.DataBLService;
import ui.InfoListTable;
import vo.MatchVO;
import vo.TeamVO;

public class TeamInfoFrame extends JFrame implements ActionListener{
	JButton beforeSearch,avgBtn,allBtn,backBtn;
	JPanel dataPanel;
	JPanel matchPanel;
	JPanel backgroundPanel;
	JPanel beforePanel;
	JScrollPane scrollPane = new JScrollPane();
	boolean avg=true;
	public TeamInfoFrame(TeamVO team){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int frameHeight = screenSize.height*2/3;
		int frameWidth = screenSize.width*3/5;
		
		
		
		JLabel teamImgLabel = new JLabel();
		teamImgLabel.setBounds(20, 0, 150, 150);
		teamImgLabel.setBackground(null);
		ImageIcon img = new ImageIcon("Img//teams//"+team.getTeamName()+".png");
		if(team.getTeamName().equals("NOH"))
			img = new ImageIcon("Img//teams//NOP.png");
		img.setImage(img.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
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
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setBackground(null);
		basicInfoPanel.setBounds(0, 0, frameWidth, 150);
		basicInfoPanel.setLayout(null);
		basicInfoPanel.add(teamImgLabel);
		basicInfoPanel.add(teamNameLabel);
		basicInfoPanel.add(teamCityLabel);
		basicInfoPanel.add(infoLabel);
		
		DecimalFormat df=new DecimalFormat(".##");
		NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
		String[] column = new String[]{"1","2","3","4","5","6","7","8"};
		String[][]data=new String[][]{{"场均得分","场均篮板","场均助攻","场均抢断","场均盖帽","三分%","投篮%","罚球%"},{df.format(team.getPoints()/team.getGamesPlayed()),df.format(team.getRebounds()/team.getGamesPlayed()),df.format(team.getAssists()/team.getGamesPlayed()),df.format(team.getSteals()/team.getGamesPlayed()),df.format(team.getBlocks()/team.getGamesPlayed()),nf.format(team.getThreePointFieldGoalPercentage()),nf.format(team.getFieldGoalPercentage()),nf.format(team.getFreeThrowPercentage())}};
		DefaultTableModel model = new DefaultTableModel(data,column);
		JTable dataTable=new JTable(model){
            public boolean isCellEditable(int row, int column)
            {
                return false;}
            }; 
        dataTable.setRowHeight(0, 25);
        dataTable.setRowHeight(1, 35);
        dataTable.setBackground(null);
        dataTable.setFont(new Font("微软雅黑",0,14));
        dataTable.setForeground(new Color(122,122,122));
        dataTable.setBounds(10, 0, frameWidth-50, 60);
        dataTable.setCellSelectionEnabled(false);
		DefaultTableCellRenderer hr = new DefaultTableCellRenderer();
		hr.setHorizontalAlignment(SwingConstants.CENTER);
		hr.setOpaque(false);
		dataTable.setDefaultRenderer(dataTable.getColumnClass(0), hr);
		dataTable.setShowGrid(false);
		dataTable.setOpaque(false);
		JPanel bcPanel = new JPanel();
		bcPanel.setBackground(new Color(246,246,246));
		bcPanel.setBounds(0, 25, frameWidth-40, 35);
        dataPanel = new JPanel();
		dataPanel.setBounds(20, 180, frameWidth-40, 60);
		dataPanel.setBackground(null);
		dataPanel.setLayout(null);
		dataPanel.add(dataTable);
		dataPanel.add(bcPanel);
		
		
		String[] columnNames = new String[]{"比赛日期","对阵队伍","比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		
		/*final DataBLService dbl = new DataBL();
		ArrayList<MatchVO> matches = dbl.findMatchByTeam(team.getTeamName());
		String[][]matchData=new String[matches.size()][7];
		for(int i=0;i<matches.size();i++){
			matchData[i][0] = matches.get(i).getMatchTime();
			matchData[i][1] = matches.get(i).getTeams();
			matchData[i][2] = matches.get(i).getScore();
			matchData[i][3] = matches.get(i).getScore1();
			matchData[i][4] = matches.get(i).getScore2();
			matchData[i][5] = matches.get(i).getScore3();
			matchData[i][6] = matches.get(i).getScore4();
		}*/
		String[][]matchData=new String[][]{{"","",""},{},{}};
		DefaultTableModel matchModel = new DefaultTableModel(matchData,columnNames);
		final InfoListTable table=new InfoListTable(matchModel){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
                 table.addMouseListener(new MouseAdapter() {     	
                 	public void mouseClicked(MouseEvent e) {
                          if (e.getButton() == MouseEvent.BUTTON1) {// 单击鼠标左键
                         	 if (e.getClickCount() == 2) {
                         		 	String matchDate = (String) table.getValueAt(table.getSelectedRow(), 0);
                          		    String team = ((String) table.getValueAt(table.getSelectedRow(), 1)).split("-")[0];
                          			//MatchVO match = dbl.getSingleMatchInfo(matchDate, team);
                          		    //new MatchInfoFrame(match);
                          	 }	    	 
                       }}});
		JScrollPane matchscrollPane = new JScrollPane(table);
		matchscrollPane.setBounds(0, 35, frameWidth-40, 180);
		matchscrollPane.setOpaque(false);
		matchscrollPane.getViewport().setOpaque(false);
		matchscrollPane.setBorder(null);
		JLabel matchTitle = new JLabel("    最近"+"场比赛");
		matchTitle.setOpaque(true);
		matchTitle.setBackground(new Color(0,103,175));
		matchTitle.setForeground(Color.WHITE);
		matchTitle.setFont(new Font("华文细黑",Font.BOLD,18));
		matchTitle.setBounds(0, 0, frameWidth-40, 35);
		
		matchPanel = new JPanel();
		matchPanel.setBounds(20, 260, frameWidth-40, 220);
		matchPanel.setBackground(null);
		matchPanel.setLayout(null);
		matchPanel.add(matchscrollPane);
		matchPanel.add(matchTitle);
		
		beforeSearch = new JButton("过往查询");
		beforeSearch.setBounds(frameWidth-100, 480, 100, 20);
		beforeSearch.setFont(new Font("微软雅黑",0,14));
		beforeSearch.setForeground(new Color(53,109,160));
		beforeSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		beforeSearch.setBackground(null);
		beforeSearch.setBorder(null);
		beforeSearch.addActionListener(this);
		
		
		
		final ImageIcon back = new ImageIcon("Img//back.JPG");
		final ImageIcon back_c = new ImageIcon("Img//back_clicked.jpg");
		backBtn = new JButton();
		backBtn.setIcon(back);
		backBtn.setBounds(frameWidth-70, 330, 30, 30);
		backBtn.setBorder(null);
		backBtn.addActionListener(this);
		backBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0){
				backBtn.setIcon(back_c);
			}
			public void mouseExited(MouseEvent e){
				backBtn.setIcon(back);
			}
		});
		
		
		JPanel beforeTitle = new JPanel();
		beforeTitle.setBackground(new Color(30,81,140));
		beforeTitle.setBounds(0, 0, frameWidth-40, 40);
		JLabel title = new JLabel("球 队 数 据");
		title.setBounds(20,0,100,40);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		
		avgBtn = new JButton("平均");
		avgBtn.setBounds(frameWidth-180, 5, 60, 30);
		avgBtn.setBackground(new Color(42,108,182));
		avgBtn.setBorder(new LineBorder(new Color(26,71,123),2,false));
		avgBtn.setForeground(Color.white);
		avgBtn.setFont(new Font("华文细黑",0,14));
		avgBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		avgBtn.addActionListener(this);
		avgBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				avgBtn.setBackground(new Color(42,108,182));
				allBtn.setBackground(new Color(26,71,123));
				avg = true;
			}
			public void mouseEntered(MouseEvent arg0){
				if(!avg){
					avgBtn.setBackground(new Color(30,81,140));
				}
			}
			public void mouseExited(MouseEvent e){
				if(!avg){
					avgBtn.setBackground(new Color(26,71,123));
				}
			}
		});
		
		
		allBtn = new JButton("总计");
		allBtn.setBounds(frameWidth-122, 5, 60, 30);
		allBtn.setBackground(new Color(26,71,123));
		allBtn.setBorder(new LineBorder(new Color(26,71,123),2,false));
		allBtn.setForeground(Color.white);
		allBtn.setFont(new Font("华文细黑",0,14));
		allBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allBtn.addActionListener(this);
		allBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allBtn.setBackground(new Color(42,108,182));
				avgBtn.setBackground(new Color(26,71,123));
				avg = false;
			}
			public void mouseEntered(MouseEvent arg0){
				if(avg){
					allBtn.setBackground(new Color(30,81,140));
				}
			}
			public void mouseExited(MouseEvent e){
				if(avg){
					allBtn.setBackground(new Color(26,71,123));
				}
			}
		});
		
		
		beforeTitle.setLayout(null);
		beforeTitle.add(title);
		beforeTitle.add(avgBtn);
		beforeTitle.add(allBtn);
		
		scrollPane.setBounds(-1, 40, frameWidth-22, 290);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		
		beforePanel = new JPanel();
		beforePanel.setBounds(20, 150, frameWidth-40, 360);
		beforePanel.setBackground(null);
		beforePanel.setLayout(null);
		beforePanel.add(beforeTitle);
		beforePanel.add(backBtn);
		beforePanel.add(scrollPane);
		avg();
		
		
		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.white);
		backgroundPanel.setBounds(0, 0, frameWidth, frameHeight);
		backgroundPanel.setLayout(null);
		backgroundPanel.add(basicInfoPanel);
		backgroundPanel.add(dataPanel);
		backgroundPanel.add(matchPanel);
		backgroundPanel.add(beforeSearch);
		
		
		this.setLayout(null);
		this.add(backgroundPanel);
		
		this.setTitle(team.getFullName());
		Image icon = kit.getImage("Img//teams//"+team.getTeamName()+".png");
		this.setIconImage(icon);
		this.setBounds(frameWidth/3, frameHeight/4, frameWidth+10, frameHeight+40);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==beforeSearch){
			backgroundPanel.remove(dataPanel);
			backgroundPanel.remove(matchPanel);
			backgroundPanel.remove(beforeSearch);
			backgroundPanel.add(beforePanel);
			backgroundPanel.repaint();
			this.repaint();
		}
		
		if(e.getSource()==backBtn){
			backgroundPanel.remove(beforePanel);
			backgroundPanel.add(dataPanel);
			backgroundPanel.add(matchPanel);
			backgroundPanel.add(beforeSearch);
			backgroundPanel.repaint();
			this.repaint();
		}
		if(e.getSource()==avgBtn){
			avg();
			backgroundPanel.repaint();
			this.repaint();
		}
		if(e.getSource()==allBtn){
			all();
			backgroundPanel.repaint();
			this.repaint();
		}
		
	}
	
	public void avg(){
		String[] columnNames = new String[]{"年度","场数","投篮命中","三分命中","罚球命中","进攻","防守","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		Object[][]data=new Object[10][14];
		/*for(int i=0;i<teams.size();i++){
			data[i][0] = (i+1);
			data[i][1] = teams.get(i).getFullName();
			data[i][2] = (teams.get(i).getGamesPlayed());
			data[i][3] = ((int)teams.get(i).getFieldGoalsMade());
			data[i][4] = ((int)teams.get(i).getFieldGoalsAttempted());
			data[i][5] = ((int)teams.get(i).getThreePointFieldGoalsMade());
			data[i][6] = ((int)teams.get(i).getThreePointFieldGoalsAttempted());
			data[i][7] = ((int)teams.get(i).getFreeThrowsMade());
			data[i][8] = ((int)teams.get(i).getFreeThrowsAttempted());
			data[i][9] = ((int)teams.get(i).getOffensiveRebounds());
			data[i][10] = ((int)teams.get(i).getDefensiveRebounds());
			data[i][11] = ((int)teams.get(i).getRebounds());
			data[i][12] = ((int)teams.get(i).getAssists());
			data[i][13] = ((int)teams.get(i).getSteals());
			data[i][14] = ((int)teams.get(i).getBlocks());
			data[i][15] = ((int)teams.get(i).getTurnovers());
			data[i][16] = ((int)teams.get(i).getFouls());
			data[i][17] = ((int)teams.get(i).getPoints());
			data[i][18] = (int)teams.get(i).getPossessions();
		}*/
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames){
		      public Class<?> getColumnClass(int column) {
			        return getValueAt(0, column).getClass();
			      }
			};
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                            return false;}}; 
        table.setFont(new Font("微软雅黑",0,13));
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(70);
        firsetColumn.setMaxWidth(70);
        firsetColumn.setMinWidth(70);
        for(int i=2;i<5;i++){
        TableColumn nameColumn = table.getColumnModel().getColumn(i);
        nameColumn.setPreferredWidth(80);
        nameColumn.setMaxWidth(80);
        nameColumn.setMinWidth(80);
        }
        scrollPane.setViewportView(table);
        scrollPane.repaint();
		beforePanel.repaint();
		
	}
	
	public void all(){
		String[] columnNames = new String[]{"年度","场数","命中","出手","三分命中","三分出手","罚球命中","罚球出手","进攻","防守","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		Object[][]data=new Object[10][17];
		/*for(int i=0;i<teams.size();i++){
			data[i][0] = (i+1);
			data[i][1] = teams.get(i).getFullName();
			data[i][2] = (teams.get(i).getGamesPlayed());
			data[i][3] = ((int)teams.get(i).getFieldGoalsMade());
			data[i][4] = ((int)teams.get(i).getFieldGoalsAttempted());
			data[i][5] = ((int)teams.get(i).getThreePointFieldGoalsMade());
			data[i][6] = ((int)teams.get(i).getThreePointFieldGoalsAttempted());
			data[i][7] = ((int)teams.get(i).getFreeThrowsMade());
			data[i][8] = ((int)teams.get(i).getFreeThrowsAttempted());
			data[i][9] = ((int)teams.get(i).getOffensiveRebounds());
			data[i][10] = ((int)teams.get(i).getDefensiveRebounds());
			data[i][11] = ((int)teams.get(i).getRebounds());
			data[i][12] = ((int)teams.get(i).getAssists());
			data[i][13] = ((int)teams.get(i).getSteals());
			data[i][14] = ((int)teams.get(i).getBlocks());
			data[i][15] = ((int)teams.get(i).getTurnovers());
			data[i][16] = ((int)teams.get(i).getFouls());
			data[i][17] = ((int)teams.get(i).getPoints());
			data[i][18] = (int)teams.get(i).getPossessions();
		}*/
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames){
		      public Class<?> getColumnClass(int column) {
			        return getValueAt(0, column).getClass();
			      }
			};
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                            return false;}}; 
        table.setFont(new Font("微软雅黑",0,13));
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(70);
        firsetColumn.setMaxWidth(70);
        firsetColumn.setMinWidth(70);
        for(int i=4;i<8;i++){
        	TableColumn nameColumn = table.getColumnModel().getColumn(i);
        	nameColumn.setPreferredWidth(70);
        	nameColumn.setMaxWidth(70);
        	nameColumn.setMinWidth(70);
        }
        scrollPane.setViewportView(table);
        scrollPane.repaint();
		beforePanel.repaint();
		
	}
}
