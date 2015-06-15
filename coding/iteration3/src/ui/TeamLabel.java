package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.TeamAnlPanel;
import presentation.TeamCmpPanel;
import presentation.TeamListPanel;

public class TeamLabel extends JLabel{
	JLabel teamImgLabel = new JLabel();
	JLabel teamNameLabel = new JLabel();
	JLabel infoLabel, cmpLabel, historyLabel;
	int panelHeight;
	int panelWidth;
	public TeamLabel(String teamName, final JPanel fPanel, final TeamListPanel list){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setOpaque(true);
		teamImgLabel.setBounds(0, 10, (panelHeight-200)/5-20,(panelHeight-200)/5-20);
		teamImgLabel.setBackground(null);
		ImageIcon img = new ImageIcon("Img//teams//"+teamName+".png");
		if(teamName.equals("NOH"))
			img = new ImageIcon("Img//teams//NOP.png");
		img.setImage(img.getImage().getScaledInstance((panelHeight-200)/5-20,(panelHeight-200)/5-20,Image.SCALE_DEFAULT));
		teamImgLabel.setIcon(img);
		
		
		teamNameLabel.setText(teamName);
		teamNameLabel.setFont(new Font("Arial",0,16));
		teamNameLabel.setBounds((panelHeight-200)/5, 10, (panelWidth-(panelHeight-200)*6/5)/6, (panelHeight-200-3)/5-60);
		teamNameLabel.setForeground(new Color(53,109,160));
		
		infoLabel = new JLabel("信息");
		infoLabel.setFont(new Font("微软雅黑",0,14));
		infoLabel.setForeground(new Color(53,109,160));
		infoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		infoLabel.setBounds((panelHeight-200)/5, (panelHeight-200-3)/5-45, 30, 15);
		infoLabel.addMouseListener((new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				
			}
			public void mouseEntered(MouseEvent arg0){
				infoLabel.setText("<html><u>信息</u></html>");
			}
			public void mouseExited(MouseEvent arg0){
				infoLabel.setText("信息");
			}
		}));
		
		cmpLabel = new JLabel("对比");
		cmpLabel.setFont(new Font("微软雅黑",0,14));
		cmpLabel.setForeground(new Color(53,109,160));
		cmpLabel.setBounds((panelHeight-200)/5+40, (panelHeight-200-3)/5-45, 30, 15);
		cmpLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmpLabel.addMouseListener((new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				TeamCmpPanel cmp = new TeamCmpPanel(teamNameLabel.getText());
				fPanel.remove(list);
				fPanel.add(cmp);
				fPanel.repaint();
			}
			public void mouseEntered(MouseEvent arg0){
				cmpLabel.setText("<html><u>对比</u></html>");
			}
			public void mouseExited(MouseEvent arg0){
				cmpLabel.setText("对比");
			}
		}));
		
		historyLabel = new JLabel("分析");
		historyLabel.setFont(new Font("微软雅黑",0,14));
		historyLabel.setForeground(new Color(53,109,160));
		historyLabel.setBounds((panelHeight-200)/5, (panelHeight-200-3)/5-25, 30, 15);
		historyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		historyLabel.addMouseListener((new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				TeamAnlPanel anl = new TeamAnlPanel(teamNameLabel.getText());
				fPanel.remove(list);
				fPanel.add(anl);
				fPanel.repaint();
			}
			public void mouseEntered(MouseEvent arg0){
				historyLabel.setText("<html><u>分析</u></html>");
			}
			public void mouseExited(MouseEvent arg0){
				historyLabel.setText("分析");
			}
		}));
		
		this.setLayout(null);
		this.add(teamImgLabel);
		this.add(teamNameLabel);
		this.add(infoLabel);
		this.add(cmpLabel);
		this.add(historyLabel);
	}
	

}
