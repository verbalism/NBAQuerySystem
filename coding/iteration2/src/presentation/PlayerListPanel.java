package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import vo.PlayerVO;
import businesslogic.DataBL;
import businesslogicService.DataBLService;

public class PlayerListPanel extends JPanel implements ActionListener{
	int panelWidth,panelHeight;
	JTextField searchField;
	JButton searchBtn;
	DataBLService db = new DataBL();
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
		searchBtn.addActionListener(this);
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(searchField);
		searchPanel.add(searchBtn);
		
		
		
		ArrayList<PlayerVO> allPlayer = db.getAllPlayerInfo();
		String[] columnNames = new String[]{"","球员名","位置","球衣号","球龄","身高","体重","生日","年龄","毕业学校"};
		Object[][]data=new Object[allPlayer.size()][10];
		for(int i=0;i<allPlayer.size();i++){
			ImageIcon img = new ImageIcon("Img//players//portrait//"+allPlayer.get(i).getPlayerName()+".png");
			img.setImage(img.getImage().getScaledInstance(74,60,Image.SCALE_DEFAULT));
			data[i][0] = img;
			data[i][1] = allPlayer.get(i).getPlayerName();
			data[i][2] = allPlayer.get(i).getPosition();
			data[i][3] = allPlayer.get(i).getNumber();
			data[i][4] = allPlayer.get(i).getExp();
			data[i][5] = allPlayer.get(i).getHeight();
			data[i][6] = allPlayer.get(i).getWeight();
			data[i][7] = allPlayer.get(i).getBirth();
			data[i][8] = allPlayer.get(i).getAge();
			data[i][9] = allPlayer.get(i).getSchool();
		}
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		final InfoListTable table=new InfoListTable(model){
            public boolean isCellEditable(int row, int column)
                 {
                     return false;}
                 }; 
        table.setRowHeight(60);
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer2());
		table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		 if (e.getButton() == MouseEvent.BUTTON1) {// 单击鼠标左键
        		     if (e.getClickCount() == 1) {
        		    	 String name = (String) table.getValueAt(table.getSelectedRow(), 1);
        		    	 PlayerVO player = db.getSinglePlayerInfo(name);
        		    	 new PlayerInfoFrame(player);
        		     }
        		    	 
        		 }
        }});
        
        TableColumn firsetColumn = table.getColumnModel().getColumn(0);
        firsetColumn.setPreferredWidth(74);
        firsetColumn.setMaxWidth(74);
        firsetColumn.setMinWidth(74);
        TableColumn nameColumn = table.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(170);
        nameColumn.setMaxWidth(170);
        nameColumn.setMinWidth(170);
        for(int k=2;k<7;k++){
        	TableColumn Column = table.getColumnModel().getColumn(k);
        	Column.setPreferredWidth(70);
        	Column.setMaxWidth(70);
        	Column.setMinWidth(70);
        }
        TableColumn ageColumn = table.getColumnModel().getColumn(8);
        ageColumn.setPreferredWidth(70);
        ageColumn.setMaxWidth(70);
        ageColumn.setMinWidth(70);
        TableColumn birthColumn = table.getColumnModel().getColumn(7);
        birthColumn.setPreferredWidth(120);
        birthColumn.setMaxWidth(120);
        birthColumn.setMinWidth(120);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(-1, 70, panelWidth+18, panelHeight-100);
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
			PlayerVO findPlayer = db.getSinglePlayerInfo(searchField.getText());
			if(findPlayer.getAge() == null){
				new ActionDialog("未查找到相关球员，请重新输入");
			}
			else{
				new PlayerInfoFrame(findPlayer);
			}
		}
		
	}
}
