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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PlayerListPanel extends JPanel{
	int panelWidth,panelHeight;
	JTextField searchField;
	JButton searchBtn;
	public PlayerListPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 10, panelWidth, 50);
		searchPanel.setBackground(new Color(87,89,91));
		JLabel title = new JLabel("球   员");
		title.setBounds(20,0,100,50);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		searchField = new JTextField();
		searchField.setBounds(panelWidth-300,10,200,30);
		searchField.setBackground(new Color(69,69,69));
		searchField.setBorder(null);
		searchField.setText("  输入球员名查找");
		searchField.setForeground(Color.WHITE);
		searchField.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				searchField.setText(null);
			}
		});
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
		
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(searchField);
		searchPanel.add(searchBtn);
		
		
		String[] columnNames = new String[]{"球员名","位置","球衣号","球龄","身高","体重","生日","年龄","毕业学校"};
		String[][]data=new String[][]{{"abc","3","4","","","","","",""},{"kkk","2","3","4","","","","",""}};
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
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
