package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class TeamDataPanel extends JPanel{
	int panelWidth,panelHeight;
	JButton allBtn;
	JButton averageBtn;
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
		JLabel title = new JLabel("球 队 分 析");
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
		
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(allBtn);
		searchPanel.add(averageBtn);
		
		
		String[] columnNames = new String[]{"球队名称","比赛场数","投篮命中数","投篮出手数","投篮命中率","三分命中数","三分出手数","三分命中率","罚球命中数","罚球出手数","罚球命中率","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"};
		String[][]data=new String[][]{{"abc","3","4","","","","","","","","","",""},{"kkk","2","3","4","","","","",""}};
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                            return false;}}; 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
        JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 70, panelWidth, panelHeight-100);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		
		this.setLayout(null);
		this.add(searchPanel);
		this.add(scrollPane);
	}
}
