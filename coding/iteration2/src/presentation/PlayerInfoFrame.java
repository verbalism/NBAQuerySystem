package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

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

public class PlayerInfoFrame extends JFrame{
	public static void main(String args[]){
		PlayerInfoFrame pf = new PlayerInfoFrame();
	}
	
	public PlayerInfoFrame(){
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
		ImageIcon img = new ImageIcon("Img//players//action//Al Jefferson.png");
		img.setImage(img.getImage().getScaledInstance(314,500,Image.SCALE_DEFAULT));
		playerImgLabel.setIcon(img);
		
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setBackground(null);
		basicInfoPanel.setBounds(0, 0, frameWidth, 150);
		//basicInfoPanel.setBackground(Color.GRAY);
		JLabel playerNumLabel = new JLabel("32");
		playerNumLabel.setFont(new Font("Arial Narrow",Font.BOLD,50));
		playerNumLabel.setBounds(50, 0, 50, 150);
		playerNumLabel.setForeground(new Color(0,103,175));
		JLabel playerNameLabel = new JLabel("Aaron Gray");
		playerNameLabel.setFont(new Font("Arial Black",0,30));
		playerNameLabel.setBounds(120, 40, 200, 35);
		playerNameLabel.setForeground(new Color(0,103,175));
		JLabel playerTeamLabel = new JLabel("G/Rocket");
		playerTeamLabel.setFont(new Font("Arial",0,20));
		playerTeamLabel.setBounds(120, 75, 200, 50);
		playerTeamLabel.setForeground(new Color(122,122,122));
		JLabel infoLabel = new JLabel();
		infoLabel.setFont(new Font("微软雅黑",0,15));
		infoLabel.setBounds(370, 40, 400, 100);
		infoLabel.setForeground(new Color(122,122,122));
		infoLabel.setText("<html>身高/体重<br>生日：<br>年龄：<br>球龄：<br>毕业院校：</html>");
		basicInfoPanel.setLayout(null);
		basicInfoPanel.add(playerNumLabel);
		basicInfoPanel.add(playerNameLabel);
		basicInfoPanel.add(playerTeamLabel);
		basicInfoPanel.add(infoLabel);
		
		String[] column = new String[]{"1","2","3","4","5","6","7","8"};
		String[][]data=new String[][]{{"场均得分","场均篮板","场均助攻","场均抢断","场均盖帽","三分%","投篮%","罚球%"},{"1","2","3","4","5","6","7","8"}};
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
		matchPanel.setBounds(20, 280, frameWidth-300, 200);
		matchPanel.setBackground(null);
		String[] columnNames = new String[]{"对阵队伍","比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		String[][]matchData=new String[][]{{"abc","3","4","","",""},{"kkk","2","3","4","",""},{},{},{}};
		DefaultTableModel matchModel = new DefaultTableModel(matchData,columnNames);
		InfoListTable table=new InfoListTable(matchModel){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, frameWidth-340, 130);
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
		
		this.setTitle("Al");
		this.setBounds(frameWidth/4, frameHeight/4, frameWidth+10, frameHeight+40);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
