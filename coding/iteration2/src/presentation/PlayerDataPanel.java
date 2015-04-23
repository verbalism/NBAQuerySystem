package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
import businesslogic.AnalysisBL;
import businesslogic.DataBL;
import businesslogicService.AnalysisBLService;
import businesslogicService.DataBLService;

public class PlayerDataPanel extends JPanel implements ActionListener{
	int panelWidth,panelHeight;
	JButton allBtn;
	JButton averageBtn;
	JButton top50Btn;
	JComboBox positionBox,unionBox,areaBox,sortBox;
	JPanel top50Panel;
	DecimalFormat df=new DecimalFormat(".##");
	NumberFormat nf = NumberFormat.getPercentInstance();
	DataBLService dbl = new DataBL();
	AnalysisBLService abl = new AnalysisBL();
	JScrollPane scrollPane = new JScrollPane();
	public PlayerDataPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 10, panelWidth, 100);
		searchPanel.setBackground(new Color(87,89,91));
		JLabel title = new JLabel("球 员 数 据");
		title.setBounds(20,0,100,50);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		allBtn = new JButton("赛季");
		averageBtn = new JButton("场均");
		allBtn.setBounds(20, 65, 60, 30);
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
		averageBtn.setBounds(77, 65, 60, 30);
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
		
		top50Panel = new JPanel();
		top50Panel.setBounds(370, 20, panelWidth-370, 80);
		top50Panel.setBorder(null);
		top50Panel.setBackground(null);
		
		String position[] = {"全部位置","前锋","中锋","后卫"};
		positionBox = new JComboBox(position);
		positionBox.setBounds(0, 10, 150, 30);
		positionBox.setFont(new Font("微软雅黑",0,14));
		positionBox.setBorder(new LineBorder(new Color(69,69,69),2,false));
		positionBox.setForeground(Color.WHITE);
		positionBox.setBackground(new Color(69,69,69));
		
		String union[] = {"全部联盟","东部","西部"};
		unionBox = new JComboBox(union);
		unionBox.setBounds(340, 10, 150, 30);
		unionBox.setFont(new Font("微软雅黑",0,14));
		unionBox.setBorder(new LineBorder(new Color(69,69,69),2,false));
		unionBox.setForeground(Color.WHITE);
		unionBox.setBackground(new Color(69,69,69));
		unionBox.addActionListener(this);
		
		String area[] = {"全部分区"};
		areaBox = new JComboBox(area);
		areaBox.setBounds(510, 10, 150, 30);
		areaBox.setFont(new Font("微软雅黑",0,14));
		areaBox.setBorder(new LineBorder(new Color(69,69,69),2,false));
		areaBox.setForeground(Color.WHITE);
		areaBox.setBackground(new Color(69,69,69));
		
		String sort[] = {"得分","篮板","助攻","得分/篮板/助攻","盖帽","抢断","犯规","失误","分钟","效率","投篮","三分","罚球","两双"};
		sortBox = new JComboBox(sort);
		sortBox.setBounds(170, 10, 150, 30);
		sortBox.setFont(new Font("微软雅黑",0,14));
		sortBox.setBorder(new LineBorder(new Color(69,69,69),2,false));
		sortBox.setForeground(Color.WHITE);
		sortBox.setBackground(new Color(69,69,69));
		
		top50Btn = new JButton("Find Top50");
		top50Btn.setBounds(460, 50, 200, 25);
		top50Btn.setFont(new Font("微软雅黑",0,14));
		top50Btn.setBorder(new LineBorder(new Color(69,69,69),2,false));
		top50Btn.setForeground(Color.WHITE);
		top50Btn.setBackground(null);
		top50Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		top50Btn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				top50Btn.setBackground(new Color(158,158,158));
			}
			public void mouseExited(MouseEvent arg0){
				top50Btn.setBackground(null);
			}
		});
		top50Btn.addActionListener(this);
		
		unionBox.addItemListener(new ItemListener() {
		      public void itemStateChanged(final ItemEvent e) {
		        int index = unionBox.getSelectedIndex();
		        if (index == 0){
		        	areaBox.removeAllItems();
		        	areaBox.addItem("全部分区");
		        }
		        if (index == 1) {
		        	areaBox.removeAllItems();
		        	areaBox.addItem("全部分区");
		        	areaBox.addItem("东南分区");
		        	areaBox.addItem("中央分区");
		        	areaBox.addItem("大西洋分区");
		        }
		        if(index == 2){
		        	areaBox.removeAllItems();
		        	areaBox.addItem("全部分区");
		        	areaBox.addItem("西北分区");
		        	areaBox.addItem("西南分区");
		        	areaBox.addItem("̫太平洋分区");
		        }
		      }
		    });
		
		top50Panel.setLayout(null);
		top50Panel.add(positionBox);
		top50Panel.add(unionBox);
		top50Panel.add(areaBox);
		top50Panel.add(sortBox);
		top50Panel.add(top50Btn);
		
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(allBtn);
		searchPanel.add(averageBtn);
		searchPanel.add(top50Panel);
		
		
        
		nf.setMaximumFractionDigits(2);
		all();
		this.setLayout(null);
		this.add(searchPanel);
		this.add(scrollPane);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==allBtn){
			all();
		}
		if(e.getSource()==averageBtn){
			avg();
		}
		if(e.getSource()==top50Btn){
			String keyword="points";
			PlayerPosition position = PlayerPosition.All;
			PlayerPartition partition = PlayerPartition.All;
			switch(unionBox.getSelectedIndex()){
			case 0:
				partition = PlayerPartition.All;
				break;
			case 1:
				partition = PlayerPartition.East;
				switch(areaBox.getSelectedIndex()){
				case 0:
					partition = PlayerPartition.East;
					break;
				case 1:
					partition = PlayerPartition.Southeast;
					break;
				case 2:
					partition = PlayerPartition.Central;
					break;
				case 3:
					partition = PlayerPartition.Atlantic;
				default:
					break;
				}
				break;
			case 2:
				partition = PlayerPartition.West;
				switch(areaBox.getSelectedIndex()){
				case 0:
					partition = PlayerPartition.West;
					break;
				case 1:
					partition = PlayerPartition.Northwest;
					break;
				case 2:
					partition = PlayerPartition.Southwest;
					break;
				case 3:
					partition = PlayerPartition.Pacific;
				default:
					break;
				}
			}
			switch(positionBox.getSelectedIndex()){
			case 0:
				position = PlayerPosition.All;
				break;
			case 1:
				position = PlayerPosition.Forward;
				break;
			case 2:
				position = PlayerPosition.Center;
				break;
			case 3:
				position = PlayerPosition.Guard;
				break;
			default:
				break;	
			}
			switch(sortBox.getSelectedIndex()){
			case 0:
				keyword = "points";
				break;
			case 1:
				keyword = "rebounds";
				break;
			case 2:
				keyword = "assists";
				break;
			case 3:
				keyword = "p/r/a";
				break;
			case 4:
				keyword = "blocks";
				break;
			case 5:
				keyword = "steals";
				break;
			case 6:
				keyword = "fouls";
				break;
			case 7:
				keyword = "turnovers";
				break;
			case 8:
				keyword = "minutes";
				break;
			case 9:
				keyword = "efficiency";
				break;
			case 10:
				keyword = "fieldGoalsPercentage";
				break;
			case 11:
				keyword = "threePointFieldGoalsPercentage";
				break;
			case 12:
				keyword = "freeThrowsPercentage";
				break;
			case 13:
				keyword = "2";
				break;
			default:
				break;
			}
			ArrayList<PlayerVO> players = abl.getTopFiftyPlayer(position, partition, keyword);
			setTop50(players);
		}
		
	}
	
	public void all(){
		this.remove(scrollPane);
		
		ArrayList<PlayerVO> players = dbl.getAllPlayerInfo();
		String[] columnNames = new String[]{"","球员名称","所属球队","参赛场数","先发场数","在场时间","投篮命中率","三分命中率","罚球命中率","篮板数","助攻数","进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率","GMSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率"};
		Object[][]data=new Object[players.size()][30];
		for(int i=0;i<players.size();i++){
			data[i][0] = (i+1);
			data[i][1] = players.get(i).getPlayerName();
			data[i][2] = players.get(i).getTeamName();
			data[i][3] = (players.get(i).getGamesPlayed());
			data[i][4] = (players.get(i).getGamesStarting());
			data[i][5] = players.get(i).getMinutes();
			data[i][6] = nf.format(players.get(i).getFieldGoalsPercentage());
			data[i][7] = nf.format(players.get(i).getThreePointFieldGoalsPercentage());
			data[i][8] = nf.format(players.get(i).getFreeThrowsPercentage());
			data[i][9] = ((int)players.get(i).getRebounds());
			data[i][10] = ((int)players.get(i).getAssists());
			data[i][11] = ((int)players.get(i).getOffensiveRebounds());
			data[i][12] = ((int)players.get(i).getDefensiveRebounds());
			data[i][13] = ((int)players.get(i).getSteals());
			data[i][14] = ((int)players.get(i).getBlocks());
			data[i][15] = ((int)players.get(i).getTurnovers());
			data[i][16] = ((int)players.get(i).getFouls());
			data[i][17] = ((int)players.get(i).getPoints());
			data[i][18] = (players.get(i).getEfficiency());
			data[i][19] = Double.valueOf(df.format(players.get(i).getGmSc()));
			data[i][20] = nf.format(players.get(i).getTrueShootingPercentage());
			data[i][21] = nf.format(players.get(i).getShootingEfficiency());
			data[i][22] = nf.format(players.get(i).getReboundRating());
			data[i][23] = nf.format(players.get(i).getOffensiveReboundRating());
			data[i][24] = nf.format(players.get(i).getDefensiveReboundRating());
			data[i][25] = nf.format(players.get(i).getAssisyRating());
			data[i][26] = nf.format(players.get(i).getStealRating());
			data[i][27] = nf.format(players.get(i).getBlockRating());
			data[i][28] = nf.format(players.get(i).getTurnoverRating());
			data[i][29] = nf.format(players.get(i).getUtilizationRating());
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
        TableColumn nameColumn = table.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(170);
        nameColumn.setMaxWidth(170);
        nameColumn.setMinWidth(170);
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 120, panelWidth, panelHeight-150);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		
		this.add(scrollPane);
	}
	
	public void avg(){
		this.remove(scrollPane);
		
		ArrayList<PlayerVO> players = dbl.getAllPlayerInfo();
		String[] columnNames = new String[]{"","球员名称","所属球队","篮板数","助攻数","进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率","GMSc效率值"};
		Object[][]data=new Object[players.size()][14];
		
		for(int i=0;i<players.size();i++){
			if(players.get(i).getGamesPlayed()==0){
				data[i][0]=i+1;
				for(int j=1;j<14;j++)
					data[i][j]=0;
			}
			else{
				data[i][0] = (i+1);
				data[i][1] = players.get(i).getPlayerName();
				data[i][2] = players.get(i).getTeamName();
				data[i][3] = Double.valueOf(df.format(players.get(i).getRebounds()/players.get(i).getGamesPlayed()));
				data[i][4] = Double.valueOf(df.format(players.get(i).getAssists()/players.get(i).getGamesPlayed()));
				data[i][5] = Double.valueOf(df.format(players.get(i).getOffensiveRebounds()/players.get(i).getGamesPlayed()));
				data[i][6] = Double.valueOf(df.format(players.get(i).getDefensiveRebounds()/players.get(i).getGamesPlayed()));
				data[i][7] = Double.valueOf(df.format(players.get(i).getSteals()/players.get(i).getGamesPlayed()));
				data[i][8] = Double.valueOf(df.format(players.get(i).getBlocks()/players.get(i).getGamesPlayed()));
				data[i][9] = Double.valueOf(df.format(players.get(i).getTurnovers()/players.get(i).getGamesPlayed()));
				data[i][10] = Double.valueOf(df.format(players.get(i).getFouls()/players.get(i).getGamesPlayed()));
				data[i][11] = Double.valueOf(df.format(players.get(i).getPoints()/players.get(i).getGamesPlayed()));
				data[i][12] = Double.valueOf(df.format(players.get(i).getEfficiency()/players.get(i).getGamesPlayed()));
				data[i][13] = Double.valueOf(df.format(players.get(i).getGmSc()/players.get(i).getGamesPlayed()));
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
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("微软雅黑",0,13));
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(30);
        firsetColumn.setMaxWidth(30);
        firsetColumn.setMinWidth(30);
        TableColumn nameColumn = table.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(170);
        nameColumn.setMaxWidth(170);
        nameColumn.setMinWidth(170);
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 120, panelWidth, panelHeight-150);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		
		this.add(scrollPane);
	}
	
	public void setTop50(ArrayList<PlayerVO> players){
		this.remove(scrollPane);
		
		String[] columnNames = new String[]{"","球员名称","所属球队","参赛场数","先发场数","投篮命中率","三分命中率","罚球命中率","篮板数","助攻数","进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分"};
		Object[][]data=new Object[players.size()][19];
		for(int i=0;i<players.size();i++){
			data[i][0] = (i+1);
			data[i][1] = players.get(i).getPlayerName();
			data[i][2] = players.get(i).getTeamName();
			data[i][3] = (players.get(i).getGamesPlayed());
			data[i][4] = (players.get(i).getGamesStarting());
			data[i][5] = players.get(i).getMinutes();
			data[i][6] = nf.format(players.get(i).getFieldGoalsPercentage());
			data[i][7] = nf.format(players.get(i).getThreePointFieldGoalsPercentage());
			data[i][8] = nf.format(players.get(i).getFreeThrowsPercentage());
			data[i][9] = ((int)players.get(i).getRebounds());
			data[i][10] = ((int)players.get(i).getAssists());
			data[i][11] = ((int)players.get(i).getOffensiveRebounds());
			data[i][12] = ((int)players.get(i).getDefensiveRebounds());
			data[i][13] = ((int)players.get(i).getSteals());
			data[i][14] = ((int)players.get(i).getBlocks());
			data[i][15] = ((int)players.get(i).getTurnovers());
			data[i][16] = ((int)players.get(i).getFouls());
			data[i][17] = ((int)players.get(i).getPoints());
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
        TableColumn nameColumn = table.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(170);
        nameColumn.setMaxWidth(170);
        nameColumn.setMinWidth(170);
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 120, panelWidth, panelHeight-150);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		
		this.add(scrollPane);
	}
	
	
}
