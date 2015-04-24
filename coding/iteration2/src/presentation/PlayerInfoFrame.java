package presentation;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businesslogic.DataBL;
import businesslogicService.DataBLService;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;

public class PlayerInfoFrame extends JFrame{
	public static void main(String args[]){
		DataBLService db = new DataBL();
		PlayerVO vo = db.getSinglePlayerInfo("Anthony Nicholson");
		PlayerInfoFrame pf = new PlayerInfoFrame(vo);
	}
	
	public PlayerInfoFrame(PlayerVO player){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int frameHeight = screenSize.height*2/3;
		int frameWidth = screenSize.width*2/3;
		
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.white);
		backgroundPanel.setBounds(0, 0, frameWidth, frameHeight);
		
		JLabel playerImgLabel = new JLabel();
		playerImgLabel.setBounds(frameWidth-300, 5, 314, 500);
		playerImgLabel.setBackground(null);
		ImageIcon img = new ImageIcon("Img//players//action//"+player.getPlayerName()+".png");
		img.setImage(img.getImage().getScaledInstance(314,500,Image.SCALE_DEFAULT));
		playerImgLabel.setIcon(img);
		
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setBackground(null);
		basicInfoPanel.setBounds(0, 0, frameWidth, 150);
		JLabel playerNumLabel = new JLabel("32");
		playerNumLabel.setFont(new Font("Arial Narrow",Font.BOLD,50));
		playerNumLabel.setBounds(50, 0, 50, 150);
		playerNumLabel.setForeground(new Color(0,103,175));
		JLabel playerNameLabel = new JLabel(player.getPlayerName());
		playerNameLabel.setFont(new Font("Arial Black",0,30));
		playerNameLabel.setBounds(120, 40, 200, 35);
		playerNameLabel.setForeground(new Color(0,103,175));
		JLabel playerTeamLabel = new JLabel(player.getPosition()+"/"+player.getTeamName());
		playerTeamLabel.setFont(new Font("Arial",0,20));
		playerTeamLabel.setBounds(120, 75, 200, 50);
		playerTeamLabel.setForeground(new Color(122,122,122));
		JLabel infoLabel = new JLabel();
		infoLabel.setFont(new Font("微软雅黑",0,15));
		infoLabel.setBounds(370, 40, 400, 100);
		infoLabel.setForeground(new Color(122,122,122));
		infoLabel.setText("<html>"+player.getHeight()+"/"+player.getWeight()+"<br>生日："+player.getBirth()+"<br>年龄："+player.getAge()+"<br>球龄："+player.getExp()+"<br>毕业院校："+player.getSchool()+"</html>");
		basicInfoPanel.setLayout(null);
		basicInfoPanel.add(playerNumLabel);
		basicInfoPanel.add(playerNameLabel);
		basicInfoPanel.add(playerTeamLabel);
		basicInfoPanel.add(infoLabel);
		
		DecimalFormat df=new DecimalFormat(".##");
		NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
		String[] column = new String[]{"1","2","3","4","5","6","7","8"};
		String[][]data=new String[][]{{"场均得分","场均篮板","场均助攻","场均抢断","场均盖帽","三分%","投篮%","罚球%"},{df.format(player.getPoints()/player.getGamesPlayed()),df.format(player.getRebounds()/player.getGamesPlayed()),df.format(player.getAssists()/player.getGamesPlayed()),df.format(player.getSteals()/player.getGamesPlayed()),df.format(player.getBlocks()/player.getGamesPlayed()),nf.format(player.getThreePointFieldGoalsPercentage()),nf.format(player.getFieldGoalsPercentage()),nf.format(player.getFreeThrowsPercentage())}};
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
        dataTable.setBounds(10, 0, frameWidth-350, 60);
        dataTable.setCellSelectionEnabled(false);
		DefaultTableCellRenderer hr = new DefaultTableCellRenderer();
		hr.setHorizontalAlignment(SwingConstants.CENTER);
		hr.setOpaque(false);
		dataTable.setDefaultRenderer(dataTable.getColumnClass(0), hr);
		dataTable.setShowGrid(false);
		dataTable.setOpaque(false);
		JPanel bcPanel = new JPanel();
		bcPanel.setBackground(new Color(246,246,246));
		bcPanel.setBounds(0, 25, frameWidth-340, 35);
        JPanel dataPanel = new JPanel();
		dataPanel.setBounds(20, 200, frameWidth-300, 60);
		dataPanel.setBackground(null);
		dataPanel.setLayout(null);
		dataPanel.add(dataTable);
		dataPanel.add(bcPanel);
		
		JPanel matchPanel = new JPanel();
		matchPanel.setBounds(20, 280, frameWidth-300, 230);
		matchPanel.setBackground(null);
		String[] columnNames = new String[]{"比赛日期","对阵队伍","比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		String[][]matchData=new String[5][7];
		final DataBLService dbl = new DataBL();
		ArrayList<MatchVO> matches = dbl.findMatchByPlayer(player.getPlayerName());
		for(int i=0;i<5;i++){
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
		scrollPane.setBounds(0, 35, frameWidth-340, 180);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		JLabel matchTitle = new JLabel("    最近5场比赛");
		matchTitle.setOpaque(true);
		matchTitle.setBackground(new Color(0,103,175));
		matchTitle.setForeground(Color.WHITE);
		matchTitle.setFont(new Font("华文细黑",Font.BOLD,18));
		matchTitle.setBounds(0, 0, frameWidth-340, 35);
		
		matchPanel.setLayout(null);
		matchPanel.add(scrollPane);
		matchPanel.add(matchTitle);
		
		backgroundPanel.setLayout(null);
		backgroundPanel.add(playerImgLabel);
		backgroundPanel.add(basicInfoPanel);
		backgroundPanel.add(dataPanel);
		backgroundPanel.add(matchPanel);
		this.setLayout(null);
		this.add(backgroundPanel);
		
		this.setTitle(player.getPlayerName());
		Image icon = kit.getImage("Img//players//portrait//"+player.getPlayerName()+".png");
		this.setIconImage(icon);
		this.setBounds(frameWidth/4, frameHeight/4, frameWidth+10, frameHeight+40);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
