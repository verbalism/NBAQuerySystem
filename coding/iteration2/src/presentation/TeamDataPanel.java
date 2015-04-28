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
	JButton analysisBtn;
	String state = "all";
	JScrollPane scrollPane = new JScrollPane();
	DataBLService dbl = new DataBL();
	DecimalFormat df=new DecimalFormat(".##");
	NumberFormat nf = NumberFormat.getPercentInstance();
	Thread thread;
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
		analysisBtn = new JButton("分析");
		allBtn.setBounds(panelWidth-184, 10, 60, 30);
		allBtn.setBackground(new Color(158,158,158));
		allBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		allBtn.setFont(new Font("微软雅黑",0,14));
		allBtn.setForeground(Color.white);
		allBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allBtn.setBackground(new Color(158,158,158));
				averageBtn.setBackground(null);
				analysisBtn.setBackground(null);
			}
		});
		allBtn.addActionListener(this);
		averageBtn.setBounds(panelWidth-127, 10, 60, 30);
		averageBtn.setBackground(null);
		averageBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		averageBtn.setFont(new Font("微软雅黑",0,14));
		averageBtn.setForeground(Color.white);
		averageBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		averageBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				averageBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
				analysisBtn.setBackground(null);
			}
		});
		averageBtn.addActionListener(this);
		analysisBtn.setBounds(panelWidth-70, 10, 60, 30);
		analysisBtn.setBackground(null);
		analysisBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		analysisBtn.setFont(new Font("微软雅黑",0,14));
		analysisBtn.setForeground(Color.white);
		analysisBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		analysisBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				analysisBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
				averageBtn.setBackground(null);
			}
		});
		analysisBtn.addActionListener(this);
		
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(allBtn);
		searchPanel.add(averageBtn);
		searchPanel.add(analysisBtn);
		
		
        nf.setMaximumFractionDigits(2);
		all();
		this.setLayout(null);
		this.add(searchPanel);
		
		thread = new Thread(new Runnable(){
            @Override
            public void run() {
            	 while(true){
            		   try {   
            			   switch(state){
            			   case "all":
            				   all();
            				   break;
            			   case "avg":
            				   avg();
            				   break;
            			   case "anl":
            				   analysis();
            				   break;
            			   default:
            				   break;
            			   }
            			   Thread.sleep(10000);
            		   } catch (InterruptedException e) {
            		    e.printStackTrace();
            		   }
            	 }
            }
        });
		thread.start();
	}
	
	
	public void avg(){
		this.remove(scrollPane);
		ArrayList<TeamVO> teams = dbl.getAllTeamInfo();
		String[] columnNames = new String[]{"","球队名","投篮命中","投篮出手","三分命中","三分出手","罚球命中","罚球出手","进攻篮板","防守篮板","篮板","助攻","抢断","盖帽","失误","犯规","得分","进攻回合"};
		Object[][]data=new Object[teams.size()][18];
		for(int i=0;i<teams.size();i++){
			data[i][0] = (i+1);
			if(teams.get(i).getGamesPlayed()==0){
				data[i][1] = teams.get(i).getFullName();
				for(int j=2;j<17;j++)
					data[i][j]=0;
			}
			else{
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
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("微软雅黑",0,13));
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(30);
        firsetColumn.setMaxWidth(30);
        firsetColumn.setMinWidth(30);
        TableColumn nameColumn = table.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(80);
        nameColumn.setMaxWidth(80);
        nameColumn.setMinWidth(80);
       /** for(int i=10;i<17;i++){
        	TableColumn Column = table.getColumnModel().getColumn(i);
        	Column.setPreferredWidth(60);
        	Column.setMaxWidth(60);
        	Column.setMinWidth(60);
        }*/
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(-1, 69, panelWidth+18, panelHeight-100);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		this.add(scrollPane);
		this.repaint();
	}
	
	public void all(){
		this.remove(scrollPane);
		ArrayList<TeamVO> teams = dbl.getAllTeamInfo();
		String[] columnNames = new String[]{"","球队名","场数","投篮命中","投篮出手","三分命中","三分出手","罚球命中","罚球出手","进攻篮板","防守篮板","篮板","助攻","抢断","盖帽","失误","犯规","得分","进攻回合"};
		Object[][]data=new Object[teams.size()][19];
		for(int i=0;i<teams.size();i++){
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
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("微软雅黑",0,13));
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(30);
        firsetColumn.setMaxWidth(30);
        firsetColumn.setMinWidth(30);
        TableColumn nameColumn = table.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(80);
        nameColumn.setMaxWidth(80);
        nameColumn.setMinWidth(80);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(-1, 69, panelWidth+18, panelHeight-100);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		this.add(scrollPane);
		this.repaint();
	}
	
	public void analysis(){
		this.remove(scrollPane);
		ArrayList<TeamVO> teams = dbl.getAllTeamInfo();
		String[] columnNames = new String[]{"","球队名称","投篮命中率","三分命中率","罚球命中率","进攻篮板效率","防守篮板效率","助攻效率","抢断效率","胜率","进攻效率","防守效率"};
		Object[][]data=new Object[teams.size()][13];
		for(int i=0;i<teams.size();i++){
			data[i][0] = (i+1);
			data[i][1] = teams.get(i).getFullName();
			data[i][2] = nf.format(teams.get(i).getFieldGoalPercentage());
			data[i][3] = nf.format(teams.get(i).getThreePointFieldGoalPercentage());
			data[i][4] = nf.format(teams.get(i).getFieldGoalPercentage());
			data[i][5] = nf.format(teams.get(i).getOffensiveReboundPercentage());
			data[i][6] = nf.format(teams.get(i).getDefensiveReboundPercentage());
			data[i][7] = Double.valueOf(df.format(teams.get(i).getAssistPercentage()));
			data[i][8] = Double.valueOf(df.format(teams.get(i).getStealPercentage()));
			data[i][9] = nf.format(teams.get(i).getWinPercentage());
			data[i][10] = Double.valueOf(df.format(teams.get(i).getPossessions()));
			data[i][11] = Double.valueOf(df.format(teams.get(i).getOffensiveRating()));
			data[i][12] = Double.valueOf(df.format(teams.get(i).getDefensiveRating()));
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
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("微软雅黑",0,13));
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(30);
        firsetColumn.setMaxWidth(30);
        firsetColumn.setMinWidth(30);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(-1, 69, panelWidth+20, panelHeight-100);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		this.add(scrollPane);
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==allBtn){
			state = "all";
			all();
		}
		if(e.getSource()==averageBtn){
			state = "avg";
			avg();
		}
		if(e.getSource()==analysisBtn){
			state = "anl";
			analysis();
		}
	}
}
