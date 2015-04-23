package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import vo.TeamVO;
import businesslogic.DataBL;
import businesslogicService.DataBLService;

public class TeamDataPanel extends JPanel implements ActionListener{
	int panelWidth,panelHeight;
	JButton allBtn;
	JButton averageBtn;
	JScrollPane scrollPane = new JScrollPane();
	DataBLService dbl = new DataBL();
	DecimalFormat df=new DecimalFormat(".##");
	NumberFormat nf = NumberFormat.getPercentInstance();
	public TeamDataPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 10, panelWidth, 50);
		searchPanel.setBackground(new Color(87,89,91));
		JLabel title = new JLabel("球 队 数 据");
		title.setBounds(20,0,100,50);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		allBtn = new JButton("赛季");
		averageBtn = new JButton("场均");
		allBtn.setBounds(panelWidth-127, 10, 60, 30);
		allBtn.setBackground(new Color(158,158,158));
		allBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		allBtn.setFont(new Font("微软雅黑",0,14));
		allBtn.setForeground(Color.white);
		allBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allBtn.setBackground(new Color(158,158,158));
				averageBtn.setBackground(null);
			}
		});
		allBtn.addActionListener(this);
		averageBtn.setBounds(panelWidth-70, 10, 60, 30);
		averageBtn.setBackground(null);
		averageBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		averageBtn.setFont(new Font("微软雅黑",0,14));
		averageBtn.setForeground(Color.white);
		averageBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		averageBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				averageBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
			}
		});
		averageBtn.addActionListener(this);
		
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(allBtn);
		searchPanel.add(averageBtn);
		
		
        nf.setMaximumFractionDigits(2);
		all();
		this.setLayout(null);
		this.add(searchPanel);
		
	}
	
	
	public void avg(){
		this.remove(scrollPane);
		ArrayList<TeamVO> teams = dbl.getAllTeamInfo();
		String[] columnNames = new String[]{"","球队名称","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","进攻回合"};
		Object[][]data=new Object[teams.size()][18];
		for(int i=0;i<teams.size();i++){
			data[i][0] = (i+1);
			data[i][1] = teams.get(i).getFullName();
			data[i][2] = Double.valueOf(df.format(teams.get(i).getFieldGoalsMade()/teams.get(i).getGamesPlayed()));
			data[i][3] = Double.valueOf(df.format(teams.get(i).getFieldGoalsAttempted()/teams.get(i).getGamesPlayed()));
			data[i][4] = Double.valueOf(df.format(teams.get(i).getThreePointFieldGoalsMade()/teams.get(i).getGamesPlayed()));
			data[i][5] = Double.valueOf(df.format(teams.get(i).getThreePointFieldGoalsAttempted()/teams.get(i).getGamesPlayed()));
			data[i][6] = Double.valueOf(df.format(teams.get(i).getFreeThrowsMade()/teams.get(i).getGamesPlayed()));
			data[i][7] = Double.valueOf(df.format(teams.get(i).getFreeThrowsAttempted()/teams.get(i).getGamesPlayed()));
			data[i][8] = Double.valueOf(df.format(teams.get(i).getOffensiveRebounds()/teams.get(i).getGamesPlayed()));
			data[i][9] = Double.valueOf(df.format(teams.get(i).getDefensiveRebounds()/teams.get(i).getGamesPlayed()));
			data[i][10] = Double.valueOf(df.format(teams.get(i).getRebounds()/teams.get(i).getGamesPlayed()));
			data[i][11] = Double.valueOf(df.format(teams.get(i).getAssists()/teams.get(i).getGamesPlayed()));
			data[i][12] = Double.valueOf(df.format(teams.get(i).getSteals()/teams.get(i).getGamesPlayed()));
			data[i][13] = Double.valueOf(df.format(teams.get(i).getBlocks()/teams.get(i).getGamesPlayed()));
			data[i][14] = Double.valueOf(df.format(teams.get(i).getTurnovers()/teams.get(i).getGamesPlayed()));
			data[i][15] = Double.valueOf(df.format(teams.get(i).getFouls()/teams.get(i).getGamesPlayed()));
			data[i][16] = Double.valueOf(df.format(teams.get(i).getPoints()/teams.get(i).getGamesPlayed()));
			data[i][17] = Double.valueOf(df.format(teams.get(i).getPossessions()/teams.get(i).getGamesPlayed()));
		}
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames){
		      public Class<?> getColumnClass(int column) {
			        return getValueAt(0, column).getClass();
			      }
			};
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                            return false;}}; 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("微软雅黑",0,13));
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(30);
        firsetColumn.setMaxWidth(30);
        firsetColumn.setMinWidth(30);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 70, panelWidth, panelHeight-100);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		this.add(scrollPane);
		this.repaint();
	}
	
	public void all(){
		this.remove(scrollPane);
		ArrayList<TeamVO> teams = dbl.getAllTeamInfo();
		String[] columnNames = new String[]{"","球队名称","比赛场数","投篮命中数","投篮出手数","投篮命中率","三分命中数","三分出手数","三分命中率","罚球命中数","罚球出手数","罚球命中率","进攻篮板数","进攻篮板效率","防守篮板数","防守篮板效率","篮板数","助攻数","助攻效率","抢断数","抢断效率","盖帽数","失误数","犯规数","比赛得分","胜率","进攻回合","进攻效率","防守效率"};
		Object[][]data=new Object[teams.size()][29];
		for(int i=0;i<teams.size();i++){
			data[i][0] = (i+1);
			data[i][1] = teams.get(i).getFullName();
			data[i][2] = (teams.get(i).getGamesPlayed());
			data[i][3] = ((int)teams.get(i).getFieldGoalsMade());
			data[i][4] = ((int)teams.get(i).getFieldGoalsAttempted());
			data[i][5] = nf.format(teams.get(i).getFieldGoalPercentage());
			data[i][6] = ((int)teams.get(i).getThreePointFieldGoalsMade());
			data[i][7] = ((int)teams.get(i).getThreePointFieldGoalsAttempted());
			data[i][8] = nf.format(teams.get(i).getThreePointFieldGoalPercentage());
			data[i][9] = ((int)teams.get(i).getFreeThrowsMade());
			data[i][10] = ((int)teams.get(i).getFreeThrowsAttempted());
			data[i][11] = nf.format(teams.get(i).getFieldGoalPercentage());
			data[i][12] = ((int)teams.get(i).getOffensiveRebounds());
			data[i][13] = nf.format(teams.get(i).getOffensiveReboundPercentage());
			data[i][14] = ((int)teams.get(i).getDefensiveRebounds());
			data[i][15] = nf.format(teams.get(i).getDefensiveReboundPercentage());
			data[i][16] = ((int)teams.get(i).getRebounds());
			data[i][17] = ((int)teams.get(i).getAssists());
			data[i][18] = Double.valueOf(df.format(teams.get(i).getAssistPercentage()));
			data[i][19] = ((int)teams.get(i).getSteals());
			data[i][20] = Double.valueOf(df.format(teams.get(i).getStealPercentage()));
			data[i][21] = ((int)teams.get(i).getBlocks());
			data[i][22] = ((int)teams.get(i).getTurnovers());
			data[i][23] = ((int)teams.get(i).getFouls());
			data[i][24] = ((int)teams.get(i).getPoints());
			data[i][25] = nf.format(teams.get(i).getWinPercentage());
			data[i][26] = Double.valueOf(df.format(teams.get(i).getPossessions()));
			data[i][27] = Double.valueOf(df.format(teams.get(i).getOffensiveRating()));
			data[i][28] = Double.valueOf(df.format(teams.get(i).getDefensiveRating()));
		}
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames){
		      public Class<?> getColumnClass(int column) {
			        return getValueAt(0, column).getClass();
			      }
			};
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                            return false;}}; 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("微软雅黑",0,13));
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(30);
        firsetColumn.setMaxWidth(30);
        firsetColumn.setMinWidth(30);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 70, panelWidth, panelHeight-100);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		this.add(scrollPane);
		this.repaint();
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==allBtn){
			all();
		}
		if(e.getSource()==averageBtn){
			avg();
		}
		
	}
}
