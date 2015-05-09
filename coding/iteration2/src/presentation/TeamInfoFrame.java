package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

import businesslogic.DataBL;
import businesslogicService.DataBLService;
import vo.MatchVO;
import vo.TeamVO;

public class TeamInfoFrame extends JFrame{
	/*public static void main(String args[]){
		DataBLService db = new DataBL();
		TeamVO vo = db.getSingleTeamInfo("BOS");
		TeamInfoFrame tf = new TeamInfoFrame(vo);
	}*/
	public TeamInfoFrame(TeamVO team){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int frameHeight = screenSize.height*2/3;
		int frameWidth = screenSize.width*3/5;
		
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.white);
		backgroundPanel.setBounds(0, 0, frameWidth, frameHeight);
		
		JLabel teamImgLabel = new JLabel();
		teamImgLabel.setBounds(20, 0, 150, 150);
		teamImgLabel.setBackground(null);
		ImageIcon img = new ImageIcon("Img//teams//"+team.getTeamName()+".png");
		if(team.getTeamName().equals("NOH"))
			img = new ImageIcon("Img//teams//NOP.png");
		img.setImage(img.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
		teamImgLabel.setIcon(img);
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setBackground(null);
		basicInfoPanel.setBounds(0, 0, frameWidth, 180);
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
        JPanel dataPanel = new JPanel();
		dataPanel.setBounds(20, 180, frameWidth-40, 60);
		dataPanel.setBackground(null);
		dataPanel.setLayout(null);
		dataPanel.add(dataTable);
		dataPanel.add(bcPanel);
		
		
		JPanel matchPanel = new JPanel();
		matchPanel.setBounds(20, 260, frameWidth-40, 220);
		matchPanel.setBackground(null);
		String[] columnNames = new String[]{"比赛日期","对阵队伍","比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		
		final DataBLService dbl = new DataBL();
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
		}
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
                          			MatchVO match = dbl.getSingleMatchInfo(matchDate, team);
                          		    new MatchInfoFrame(match);
                          	 }	    	 
                       }}});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, frameWidth-40, 180);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		JLabel matchTitle = new JLabel("    最近"+matches.size()+"场比赛");
		matchTitle.setOpaque(true);
		matchTitle.setBackground(new Color(0,103,175));
		matchTitle.setForeground(Color.WHITE);
		matchTitle.setFont(new Font("华文细黑",Font.BOLD,18));
		matchTitle.setBounds(0, 0, frameWidth-40, 35);
		
		matchPanel.setLayout(null);
		matchPanel.add(scrollPane);
		matchPanel.add(matchTitle);
		
		backgroundPanel.setLayout(null);
		backgroundPanel.add(basicInfoPanel);
		backgroundPanel.add(dataPanel);
		backgroundPanel.add(matchPanel);
		this.setLayout(null);
		this.add(backgroundPanel);
		
		this.setTitle(team.getFullName());
		Image icon = kit.getImage("Img//teams//"+team.getTeamName()+".png");
		this.setIconImage(icon);
		this.setBounds(frameWidth/3, frameHeight/4, frameWidth+10, frameHeight+40);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
