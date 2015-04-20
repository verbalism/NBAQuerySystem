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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PlayerDataPanel extends JPanel implements ActionListener{
	int panelWidth,panelHeight;
	JButton allBtn;
	JButton averageBtn;
	JButton top50Btn;
	JComboBox positionBox,unionBox,areaBox,sortBox;
	JPanel top50Panel;
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
		
		
		String[] columnNames = new String[]{"球员名称","所属球队","参赛场数","先发场数","在场时间","投篮命中率","三分命中率","罚球命中率","篮板数","助攻数","进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率","GMSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率"};
		String[][]data=new String[][]{{"abc","3","4","","","","","","","","","",""},{"kkk","2","3","4","","","","",""}};
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                            return false;}}; 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
        JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 120, panelWidth, panelHeight-150);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		
		this.setLayout(null);
		this.add(searchPanel);
		this.add(scrollPane);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
