package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;
import businesslogic.DataBL;
import businesslogicService.DataBLService;

public class TeamListPanel extends JPanel implements ActionListener{
	int panelWidth,panelHeight;
	JTextField searchField;
	JButton searchBtn;
	DataBLService dbl = new DataBL();
	ArrayList<TeamVO> teams;
	public TeamListPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 10, panelWidth, 50);
		searchPanel.setBackground(new Color(87,89,91));
		JLabel title = new JLabel("球   队");
		title.setBounds(20,0,100,50);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		searchBtn = new JButton("查  找");
		searchBtn.setBounds(panelWidth-90, 10, 80, 30);
		searchBtn.setBackground(null);
		searchBtn.setBorder(new LineBorder(new Color(69,69,69)));
		searchBtn.setFont(new Font("微软雅黑",0,14));
		searchBtn.setForeground(Color.white);
		searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				searchBtn.setBackground(new Color(158,158,158));
			}
			public void mouseExited(MouseEvent arg0) {
				searchBtn.setBackground(null);
				}
		});
		searchBtn.addActionListener(this);
		searchField = new JTextField();
		searchField.setBounds(panelWidth-300,10,200,30);
		searchField.setBackground(new Color(69,69,69));
		searchField.setBorder(null);
		searchField.setText("  输入球队名查找");
		searchField.setForeground(Color.WHITE);
		searchField.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				searchField.setText(null);
			}
		});
		searchField.addKeyListener(new KeyAdapter(){ 
		      public void keyPressed(KeyEvent e)    
		      {    
		        if(e.getKeyChar()==KeyEvent.VK_ENTER )   //按回车键执行相应操作; 
		        { 
		          searchBtn.doClick();
		        } 
		      } 
		    });
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(searchField);
		searchPanel.add(searchBtn);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 70, panelWidth, 40);
		titlePanel.setBackground(new Color(30,81,140));
		JLabel east = new JLabel("东部联盟");
		east.setBounds(20,0,100,40);
		east.setForeground(Color.white);
		east.setFont(new Font("微软雅黑",0,15));
		JLabel west = new JLabel("西部联盟");
		west.setBounds(panelWidth/2+20,0,100,40);
		west.setForeground(Color.white);
		west.setFont(new Font("微软雅黑",0,15));
		
		titlePanel.setLayout(null);
		titlePanel.add(east);
		titlePanel.add(west);
		
		JPanel areaPanel = new JPanel();
		areaPanel.setBounds(0, 110, panelWidth, 30);
		areaPanel.setBackground(new Color(218,218,218));
		JLabel southEast = new JLabel("东南分区");
		southEast.setBounds(20,0,100,30);
		southEast.setForeground(new Color(68,68,68));
		southEast.setFont(new Font("微软雅黑",0,13));
		JLabel center = new JLabel("中央分区");
		center.setBounds(panelWidth/6+20,0,100,30);
		center.setForeground(new Color(68,68,68));
		center.setFont(new Font("微软雅黑",0,13));
		JLabel Altantic = new JLabel("大西洋分区");
		Altantic.setBounds(panelWidth/3+20,0,100,30);
		Altantic.setForeground(new Color(68,68,68));
		Altantic.setFont(new Font("微软雅黑",0,13));
		JLabel pacific = new JLabel("太平洋分区");
		pacific.setBounds(panelWidth/2+20,0,100,30);
		pacific.setForeground(new Color(68,68,68));
		pacific.setFont(new Font("微软雅黑",0,13));
		JLabel northWest = new JLabel("西北分区");
		northWest.setBounds(panelWidth*2/3+20,0,100,30);
		northWest.setForeground(new Color(68,68,68));
		northWest.setFont(new Font("微软雅黑",0,13));
		JLabel southWest = new JLabel("西南分区");
		southWest.setBounds(panelWidth*5/6+20,0,100,30);
		southWest.setForeground(new Color(68,68,68));
		southWest.setFont(new Font("微软雅黑",0,13));
		areaPanel.setLayout(null);
		areaPanel.add(southWest);
		areaPanel.add(northWest);
		areaPanel.add(pacific);
		areaPanel.add(Altantic);
		areaPanel.add(center);
		areaPanel.add(southEast);
		
		
		
		String[] columnNames = new String[]{"东南分区","a","中央分区","b","大西洋分区","c","太平洋分区","d","西北分区","e","西南分区","f"};
		Object[][]data=new Object[5][12];
		
		teams = dbl.getAllTeamInfo();
		int se=0,ce=0,al=0,p=0,nw=0,sw=0;
		for(int i=0;i<teams.size();i++){
			int line = 0;int row = 0;
			switch(teams.get(i).getSubarea()){
			case "Southeast":
				row = 0;
				line = se;
				se++;
				break;
			case "Atlantic":
				row = 4;
				line = al;
				al++;
				break;
			case "Central":
				row = 2;
				line = ce;
				ce++;
				break;
			case "Northwest":
				row = 8;
				line = nw;
				nw++;
				break;
			case "Southwest":
				row = 10;
				line = sw;
				sw++;
				break;
			case "Pacific":
				row = 6;
				line = p;
				p++;
				break;
			default:
				break;
			}
			ImageIcon img = new ImageIcon("Img//teams//"+teams.get(i).getTeamName()+".png");
			if(teams.get(i).getTeamName().equals("NOH"))
				img = new ImageIcon("Img//teams//NOP.png");
			img.setImage(img.getImage().getScaledInstance((panelHeight-200)/5-30,(panelHeight-200)/5-30,Image.SCALE_DEFAULT));
			
			data[line][row] = img; 
			data[line][row+1] = teams.get(i).getTeamName()+"-"+teams.get(i).getFullName();
		}
		
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		final InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
        table.setBackground(null);
        table.setShowGrid(false);
		table.setOpaque(false);
        table.setRowHeight((panelHeight-200)/5);
        table.setBounds(0, 140, panelWidth, panelHeight-200-3);
        for(int i=0;i<12;i++){
        	TableColumn Column = table.getColumnModel().getColumn(i);
        	if(i%2==0){
        		table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
        		Column.setPreferredWidth((panelHeight-200)/5-30);
        		Column.setMaxWidth((panelHeight-200)/5-30);
        		Column.setMinWidth((panelHeight-200)/5-30);
        	}
        	else{
        		Column.setPreferredWidth((panelWidth-(panelHeight-200)*6/5+180)/6);
        		Column.setMaxWidth((panelWidth-(panelHeight-200)*6/5+180)/6);
        		Column.setMinWidth((panelWidth-(panelHeight-200)*6/5+180)/6);
        		
        	}
        }
        table.setSelectionBackground(null);
		table.addMouseListener(new MouseAdapter() {
       	public void mouseClicked(MouseEvent e) {
       		 if (e.getButton() == MouseEvent.BUTTON1) {// 单击鼠标左键
       		     if (e.getClickCount() == 1) {
       		    	 String name = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
       		    	 TeamVO team = dbl.getSingleTeamInfo(name.split("-")[0]);
       		    	 new TeamInfoFrame(team);
       		     }
       		    	 
       		 }
       	}});
		
		
		this.setLayout(null);
		this.add(searchPanel);
		this.add(titlePanel);
		this.add(areaPanel);
		this.add(table);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchBtn){
			String name = searchField.getText();
		    TeamVO team = new TeamVO();
		    for(int i=0;i<teams.size();i++){
		    	if(teams.get(i).getTeamName().equals(name)||teams.get(i).getFullName().equals(name)){
		    		team = teams.get(i);
		    		break;
		    	}
		    }
		    if(team.getTeamName()!= null)
		    	new TeamInfoFrame(team);
		    else
		    	new ActionDialog("球队名有误请重新输入");
		}
		
	}
}
