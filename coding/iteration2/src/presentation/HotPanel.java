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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class HotPanel extends JPanel{
	int panelWidth,panelHeight;
	JTextField searchField;
	JButton searchBtn,todayBtn,allBtn,advanceBtn,teamBtn;
	JLabel title;
	JPanel sortPanel;
	public HotPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		sortPanel = new JPanel();
		sortPanel.setBounds(0, 60, panelWidth, 40);
		sortPanel.setBackground(new Color(222,222,222));
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 10, panelWidth, 50);
		searchPanel.setBackground(new Color(87,89,91));
		title = new JLabel("今 日 热 点 球 员");
		title.setBounds(20,0,200,50);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		
		allBtn = new JButton("赛季");
		todayBtn = new JButton("今日");
		advanceBtn = new JButton("进步");
		todayBtn.setBounds(panelWidth-241, 10, 60, 30);
		todayBtn.setBackground(new Color(158,158,158));
		todayBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		todayBtn.setFont(new Font("微软雅黑",0,14));
		todayBtn.setForeground(Color.white);
		todayBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		todayBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				todayBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
				advanceBtn.setBackground(null);
				teamBtn.setBackground(null);
				title.setText("今 日 热 点 球 员");
			}
			
		});
		allBtn.setBounds(panelWidth-184, 10, 60, 30);
		allBtn.setBackground(null);
		allBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		allBtn.setFont(new Font("微软雅黑",0,14));
		allBtn.setForeground(Color.white);
		allBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				allBtn.setBackground(new Color(158,158,158));
				todayBtn.setBackground(null);
				advanceBtn.setBackground(null);
				teamBtn.setBackground(null);
				title.setText("赛 季 热 点 球 员");
			}
			
		});
		advanceBtn.setBounds(panelWidth-127, 10, 60, 30);
		advanceBtn.setBackground(null);
		advanceBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		advanceBtn.setFont(new Font("微软雅黑",0,14));
		advanceBtn.setForeground(Color.white);
		advanceBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		advanceBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				advanceBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
				todayBtn.setBackground(null);
				teamBtn.setBackground(null);
				title.setText("进 步 最 快 球 员");
			}
		});
		teamBtn = new JButton("球队");
		teamBtn.setBounds(panelWidth-70, 10, 60, 30);
		teamBtn.setBackground(null);
		teamBtn.setBorder(new LineBorder(new Color(69,69,69),3,false));
		teamBtn.setFont(new Font("微软雅黑",0,14));
		teamBtn.setForeground(Color.white);
		teamBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamBtn.setBackground(new Color(158,158,158));
				allBtn.setBackground(null);
				todayBtn.setBackground(null);
				advanceBtn.setBackground(null);
				title.setText("热 点 球 队");
			}
		});
		
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(allBtn);
		searchPanel.add(todayBtn);
		searchPanel.add(advanceBtn);
		searchPanel.add(teamBtn);
		
		sortPanel = new JPanel();
		sortPanel.setBounds(0, 60, panelWidth, 40);
		sortPanel.setBackground(new Color(222,222,222));
		
		this.setLayout(null);
		this.add(searchPanel);
		this.add(sortPanel);
	}
}