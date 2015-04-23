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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import vo.MatchVO;
import businesslogic.DataBL;
import businesslogicService.DataBLService;

public class MatchListPanel extends JPanel implements ActionListener{
	int panelWidth,panelHeight;
	JTextField searchField;
	JButton searchBtn;
	DateChooser matchDateChooser;
	JScrollPane scrollPane;
	JLabel title;
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
	DataBLService dbl = new DataBL();
	public MatchListPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 10, panelWidth, 50);
		searchPanel.setBackground(new Color(87,89,91));
		title = new JLabel("今 日 比 赛 ");
		title.setBounds(20,0,100,50);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		matchDateChooser = new DateChooser("yyyy-MM-dd");
		matchDateChooser.setBounds(panelWidth-300,10,200,30);
		matchDateChooser.setBackground(new Color(69,69,69));
		matchDateChooser.setBorder(null);
		
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
		
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(matchDateChooser);
		searchPanel.add(searchBtn);
		
		
		String[] columnNames = new String[]{"对阵队伍","比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		ArrayList<MatchVO> matches = dbl.findMatchByDate("today");
		String[][]data=new String[matches.size()][6];
		for(int i=0;i<matches.size();i++){
			data[i][0] = matches.get(i).getTeams();
			data[i][1] = matches.get(i).getScore();
			data[i][2] = matches.get(i).getScore1();
			data[i][3] = matches.get(i).getScore2();
			data[i][4] = matches.get(i).getScore3();
			data[i][5] = matches.get(i).getScore4();
		}
		
		
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 70, panelWidth, panelHeight-100);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		
		this.setLayout(null);
		this.add(searchPanel);
		this.add(scrollPane);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchBtn){
			String date = sdf.format(matchDateChooser.getDate());
			ArrayList<MatchVO> matches = dbl.findMatchByDate(date);
			if(matches.isEmpty())
				new ActionDialog("该日无比赛");
			else{
				refresh(matches);
				title.setText(date+" 比赛");
			}
			
		}
		
	}
	public void refresh(ArrayList<MatchVO> matches){
		this.remove(scrollPane);
		String[] columnNames = new String[]{"对阵队伍","比分","第一节比分","第二节比分","第三节比分","第四节比分"};
		String[][]data=new String[matches.size()][6];
		for(int i=0;i<matches.size();i++){
			data[i][0] = matches.get(i).getTeams();
			data[i][1] = matches.get(i).getScore();
			data[i][2] = matches.get(i).getScore1();
			data[i][3] = matches.get(i).getScore2();
			data[i][4] = matches.get(i).getScore3();
			data[i][5] = matches.get(i).getScore4();
		}
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 70, panelWidth, panelHeight-100);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		this.add(scrollPane);
		this.repaint();
	}
}
