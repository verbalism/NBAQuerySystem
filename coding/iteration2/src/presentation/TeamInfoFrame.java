package presentation;

import java.awt.Color;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TeamInfoFrame extends JFrame{
	public static void main(String args[]){
		TeamInfoFrame tf = new TeamInfoFrame();
	}
	public TeamInfoFrame(){
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
		ImageIcon img = new ImageIcon("Img//teams//ATL.png");
		img.setImage(img.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
		teamImgLabel.setIcon(img);
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setBackground(null);
		basicInfoPanel.setBounds(0, 0, frameWidth, 180);
		JLabel teamNameLabel = new JLabel("Hawks");
		teamNameLabel.setFont(new Font("Arial Black",0,30));
		teamNameLabel.setBounds(200, 40, 200, 35);
		teamNameLabel.setForeground(new Color(0,103,175));
		JLabel teamCityLabel = new JLabel("Atlanta/Southeast");
		teamCityLabel.setFont(new Font("Arial",0,20));
		teamCityLabel.setBounds(200, 75, 200, 50);
		teamCityLabel.setForeground(new Color(122,122,122));
		JLabel infoLabel = new JLabel();
		infoLabel.setFont(new Font("微软雅黑",0,15));
		infoLabel.setBounds(450, 30, 400, 100);
		infoLabel.setForeground(new Color(122,122,122));
		infoLabel.setText("<html>东部联盟<br>主场：<br>建立时间：</html>");
		basicInfoPanel.setLayout(null);
		basicInfoPanel.add(teamImgLabel);
		basicInfoPanel.add(teamNameLabel);
		basicInfoPanel.add(teamCityLabel);
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
		matchPanel.setBounds(20, 260, frameWidth-40, 200);
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
		scrollPane.setBounds(0, 35, frameWidth-40, 130);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		JLabel matchTitle = new JLabel("    最近5场比赛");
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
		
		this.setTitle("ATL");
		this.setBounds(frameWidth/3, frameHeight/4, frameWidth+10, frameHeight+40);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
