package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import businesslogic.DataBL;
import businesslogicService.DataBLService;
import vo.MatchPlayer;
import vo.MatchVO;

public class MatchInfoFrame extends JFrame{
	/**public static void main(String args[]){
		MatchInfoFrame mf = new MatchInfoFrame();
	}*/
	
	public MatchInfoFrame(MatchVO match){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int frameHeight = screenSize.height-50;
		int frameWidth = screenSize.width*2/3;
		
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.white);
		backgroundPanel.setBounds(0, 0, frameWidth, frameHeight);
		
		JLabel team1ImgLabel = new JLabel();
		team1ImgLabel.setBounds(frameWidth/2-200, 0, 120, 120);
		team1ImgLabel.setBackground(null);
		ImageIcon img1 = new ImageIcon("Img//teams//"+match.getTeam1().getTeamName()+".png");
		img1.setImage(img1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
		team1ImgLabel.setIcon(img1);
		JLabel team1NameLabel = new JLabel(match.getTeam1().getTeamName(),JLabel.CENTER);
		team1NameLabel.setFont(new Font("Arial Black",0,25));
		team1NameLabel.setBounds(frameWidth/2-200, 120, 120, 30);
		team1NameLabel.setForeground(new Color(64,64,64));
		JLabel vsLabel = new JLabel("VS",JLabel.CENTER);
		vsLabel.setFont(new Font("Arial Narrow",Font.BOLD,45));
		vsLabel.setBounds(frameWidth/2-80, 0, 160, 150);
		vsLabel.setForeground(new Color(0,103,175));
		JLabel team2ImgLabel = new JLabel();
		team2ImgLabel.setBounds(frameWidth/2+80, 0, 120, 120);
		team2ImgLabel.setBackground(null);
		ImageIcon img2 = new ImageIcon("Img//teams//"+match.getTeam2().getTeamName()+".png");
		img2.setImage(img2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
		team2ImgLabel.setIcon(img2);
		JLabel team2NameLabel = new JLabel(match.getTeam2().getTeamName(),JLabel.CENTER);
		team2NameLabel.setFont(new Font("Arial Black",0,25));
		team2NameLabel.setBounds(frameWidth/2+80, 120, 120, 30);
		team2NameLabel.setForeground(new Color(64,64,64));
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setBackground(null);
		basicInfoPanel.setBounds(0, 0, frameWidth, 150);
		basicInfoPanel.setLayout(null);
		basicInfoPanel.add(team1ImgLabel);
		basicInfoPanel.add(team1NameLabel);
		basicInfoPanel.add(vsLabel);
		basicInfoPanel.add(team2NameLabel);
		basicInfoPanel.add(team2ImgLabel);
		
		String[] column = new String[]{"1","2","3","4","5","6"};
		String[][]data=new String[][]{{"比分","第一节","第二节","第三节","第四节","加时"},{match.getScore(),match.getScore1(),match.getScore2(),match.getScore3(),match.getScore4(),""}};
		if(!match.getExtreaScores().isEmpty()){
		for(int i=0;i<match.getExtreaScores().size();i++){
			data[1][5] = data[1][5]+match.getExtreaScores().get(i)+"  ";
		}
		}
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
        dataTable.setBounds(10, 0, frameWidth-70, 60);
        dataTable.setCellSelectionEnabled(false);
    	DefaultTableCellRenderer hr = new DefaultTableCellRenderer();
    	hr.setHorizontalAlignment(SwingConstants.CENTER);
    	hr.setOpaque(false);
    	dataTable.setDefaultRenderer(dataTable.getColumnClass(0), hr);
    	dataTable.setShowGrid(false);
    	dataTable.setOpaque(false);
    	for(int k=0;k<5;k++){
    		TableColumn Column = dataTable.getColumnModel().getColumn(k);
        	Column.setPreferredWidth(100);
        	Column.setMaxWidth(100);
        	Column.setMinWidth(100);
    	}
    	JPanel bcPanel = new JPanel();
    	bcPanel.setBackground(new Color(246,246,246));
    	bcPanel.setBounds(0, 25, frameWidth-60, 35);
        JPanel dataPanel = new JPanel();
    	dataPanel.setBounds(20, 170, frameWidth-60, 60);
    	dataPanel.setBackground(null);
    	dataPanel.setLayout(null);
    	dataPanel.add(dataTable);
    	dataPanel.add(bcPanel);
    	
    	JPanel team1Panel = new JPanel();
    	team1Panel.setBounds(20, 250, frameWidth, 200);
    	team1Panel.setBackground(null);
		String[] columnNames = new String[]{"球员","位置","在场时间","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","总篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","个人得分"};
		ArrayList<MatchPlayer> players1 = match.getTeam1().getPlayers();
		Object[][]matchData=new Object[players1.size()][18];
		for(int i=0;i<players1.size();i++){
			matchData[i][0] = players1.get(i).getPlayerName();
			matchData[i][1] = players1.get(i).getPosition();
			matchData[i][2] = players1.get(i).getMatchTime();
			matchData[i][3] = players1.get(i).getFieldGoal();
			matchData[i][4] = players1.get(i).getFieldGoalAttempts();
			matchData[i][5] = players1.get(i).getThreePointShot();
			matchData[i][6] = players1.get(i).getThreePointAttempts();
			matchData[i][7] = players1.get(i).getFreeThrowGoal();
			matchData[i][8] = players1.get(i).getFreeThrowAttempts();
			matchData[i][9] = players1.get(i).getOffensiveRebound();
			matchData[i][10] = players1.get(i).getDefensiveRebound();
			matchData[i][11] = players1.get(i).getRebound();
			matchData[i][12] = players1.get(i).getAssist();
			matchData[i][13] = players1.get(i).getST();
			matchData[i][14] = players1.get(i).getBlockShot();
			matchData[i][15] = players1.get(i).getError();
			matchData[i][16] = players1.get(i).getFoul();
			matchData[i][17] = players1.get(i).getScore();
		}
		DefaultTableModel matchModel = new DefaultTableModel(matchData,columnNames);
		InfoListTable table1=new InfoListTable(matchModel){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
        table1.setRowHeight(20);
        table1.setFont(new Font("微软雅黑",0,13));
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn nameColumn = table1.getColumnModel().getColumn(0);
        nameColumn.setPreferredWidth(170);
        nameColumn.setMaxWidth(170);
        nameColumn.setMinWidth(170);
		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBounds(0, 35, frameWidth-60, 160);
		scrollPane1.setOpaque(false);
		scrollPane1.getViewport().setOpaque(false);
		scrollPane1.setBorder(null);
		JLabel team1Title = new JLabel("    BOS");
		team1Title.setOpaque(true);
		team1Title.setBackground(new Color(0,103,175));
		team1Title.setForeground(Color.WHITE);
		team1Title.setFont(new Font("华文细黑",Font.BOLD,18));
		team1Title.setBounds(0, 0, frameWidth-60, 35);
		team1Panel.setLayout(null);
		team1Panel.add(scrollPane1);
		team1Panel.add(team1Title);
		
		JPanel team2Panel = new JPanel();
    	team2Panel.setBounds(20, 470, frameWidth, 200);
    	team2Panel.setBackground(null);
		String[] columnNames2 = new String[]{"球员","位置","在场时间","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","总篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","个人得分"};
		ArrayList<MatchPlayer> players2 = match.getTeam2().getPlayers();
		Object[][]matchData2=new Object[players1.size()][18];
		for(int i=0;i<players2.size();i++){
			matchData2[i][0] = players2.get(i).getPlayerName();
			matchData2[i][1] = players2.get(i).getPosition();
			matchData2[i][2] = players2.get(i).getMatchTime();
			matchData2[i][3] = players2.get(i).getFieldGoal();
			matchData2[i][4] = players2.get(i).getFieldGoalAttempts();
			matchData2[i][5] = players2.get(i).getThreePointShot();
			matchData2[i][6] = players2.get(i).getThreePointAttempts();
			matchData2[i][7] = players2.get(i).getFreeThrowGoal();
			matchData2[i][8] = players2.get(i).getFreeThrowAttempts();
			matchData2[i][9] = players2.get(i).getOffensiveRebound();
			matchData2[i][10] = players2.get(i).getDefensiveRebound();
			matchData2[i][11] = players2.get(i).getRebound();
			matchData2[i][12] = players2.get(i).getAssist();
			matchData2[i][13] = players2.get(i).getST();
			matchData2[i][14] = players2.get(i).getBlockShot();
			matchData2[i][15] = players2.get(i).getError();
			matchData2[i][16] = players2.get(i).getFoul();
			matchData2[i][17] = players2.get(i).getScore();
		}
		DefaultTableModel matchModel2 = new DefaultTableModel(matchData2,columnNames2);
		InfoListTable table2=new InfoListTable(matchModel2){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
        table2.setRowHeight(20);
        table2.setFont(new Font("微软雅黑",0,13));
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn nameColumn2 = table2.getColumnModel().getColumn(0);
        nameColumn2.setPreferredWidth(170);
        nameColumn2.setMaxWidth(170);
        nameColumn2.setMinWidth(170);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(0, 35, frameWidth-60, 160);
		scrollPane2.setOpaque(false);
		scrollPane2.getViewport().setOpaque(false);
		scrollPane2.setBorder(null);
		JLabel team2Title = new JLabel("    NYK");
		team2Title.setOpaque(true);
		team2Title.setBackground(new Color(0,103,175));
		team2Title.setForeground(Color.WHITE);
		team2Title.setFont(new Font("华文细黑",Font.BOLD,18));
		team2Title.setBounds(0, 0, frameWidth-60, 35);
		team2Panel.setLayout(null);
		team2Panel.add(scrollPane2);
		team2Panel.add(team2Title);
	
    	backgroundPanel.setLayout(null);
    	backgroundPanel.add(basicInfoPanel);
    	backgroundPanel.add(dataPanel);
    	backgroundPanel.add(team1Panel);
    	backgroundPanel.add(team2Panel);
    		
		this.setLayout(null);
		this.add(backgroundPanel);
		this.setTitle(match.getMatchTime());
		//Image icon = kit.getImage("Img//teams//"+team.getTeamName()+".png");
		//this.setIconImage(icon);
		this.setBounds(frameWidth/4, 0, frameWidth, frameHeight);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
