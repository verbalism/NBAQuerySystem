package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.DataBL;
import businesslogicService.DataBLService;
import vo.PlayerVO;
import vo.TeamVO;

public class HotTeamPanel extends JPanel{
	JButton teamNameLabel1,teamNameLabel2,teamNameLabel3,teamNameLabel4,teamNameLabel5;
	ArrayList<TeamVO> team;
	public HotTeamPanel(ArrayList<TeamVO> teams,String keyword){
		team = teams;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int panelHeight = screenSize.height-160;
		int panelWidth = screenSize.width-320;
		
		
		JLabel teamImgLabel1 = new JLabel();
		teamImgLabel1.setBounds(0, 50, 230, 230);
		teamImgLabel1.setBackground(null);
		ImageIcon img = new ImageIcon("Img//teams//"+teams.get(0).getTeamName()+".png");
		if(teams.get(0).getTeamName().equals("NOH"))
			img = new ImageIcon("Img//teams//NOP.png");
		img.setImage(img.getImage().getScaledInstance(230,230,Image.SCALE_DEFAULT));
		teamImgLabel1.setIcon(img);
		JLabel teamNumLabel1 = new JLabel("1");
		teamNumLabel1.setFont(new Font("Modern",Font.BOLD,90));
		teamNumLabel1.setBounds(230, 0, 50, 200);
		teamNumLabel1.setForeground(new Color(68,68,68));
		teamNameLabel1 = new JButton(teams.get(0).getFullName());
		teamNameLabel1.setFont(new Font("Arial Black",0,25));
		teamNameLabel1.setBounds(300, 60, 200, 35);
		teamNameLabel1.setForeground(new Color(0,103,175));
		teamNameLabel1.setBorder(null);
		teamNameLabel1.setBackground(null);
		teamNameLabel1.setHorizontalAlignment(JButton.LEFT);
		teamNameLabel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamNameLabel1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamNameLabel1.setBackground(null);
				TeamVO findPlayer = (team.get(0));
				new TeamInfoFrame(findPlayer);
			}
			
		});
		JLabel teamTeamLabel1 = new JLabel(teams.get(0).getCity()+"/"+teams.get(0).getSubarea());
		teamTeamLabel1.setFont(new Font("Arial",0,20));
		teamTeamLabel1.setBounds(300, 95, 300, 50);
		teamTeamLabel1.setForeground(new Color(68,68,68));
		JLabel teamScoreLabel1 = new JLabel("");
		teamScoreLabel1.setFont(new Font("Modern",Font.BOLD,35));
		teamScoreLabel1.setForeground(new Color(68,68,68));
		teamScoreLabel1.setBounds(300, 160, 200, 30);
		
		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(0, 0, panelWidth/2, 480);
		firstPanel.setBackground(null);
		firstPanel.setLayout(null);
		firstPanel.add(teamImgLabel1);
		firstPanel.add(teamNumLabel1);
		firstPanel.add(teamNameLabel1);
		firstPanel.add(teamTeamLabel1);
		firstPanel.add(teamScoreLabel1);
		
		JLabel teamNumLabel2 = new JLabel("2",JLabel.CENTER);
		teamNumLabel2.setBounds(0, 0, 100, 120);
		teamNumLabel2.setOpaque(true);
		teamNumLabel2.setBackground(new Color(246,246,246));
		teamNumLabel2.setFont(new Font("Modern",Font.BOLD,25));
		teamNumLabel2.setForeground(new Color(144,144,144));
		JLabel teamImgLabel2 = new JLabel();
		teamImgLabel2.setBounds(110, 30, 80, 80);
		ImageIcon img2 = new ImageIcon("Img//teams//"+teams.get(1).getTeamName()+".png");
		if(teams.get(1).getTeamName().equals("NOH"))
			img2 = new ImageIcon("Img//teams//NOP.png");
		img2.setImage(img2.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
		teamImgLabel2.setIcon(img2);
		teamNameLabel2 = new JButton(teams.get(1).getFullName());
		teamNameLabel2.setBounds(210, 30, 200, 30);
		teamNameLabel2.setFont(new Font("Arial Black",0,18));
		teamNameLabel2.setForeground(new Color(0,103,175));
		teamNameLabel2.setBorder(null);
		teamNameLabel2.setBackground(null);
		teamNameLabel2.setHorizontalAlignment(JButton.LEFT);
		teamNameLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamNameLabel2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamNameLabel1.setBackground(null);
				TeamVO findPlayer = (team.get(1));
				new TeamInfoFrame(findPlayer);
			}
			
		});
		JLabel teamTeamLabel2 = new JLabel(teams.get(1).getCity()+"/"+teams.get(1).getSubarea());
		teamTeamLabel2.setFont(new Font("Arial",0,15));
		teamTeamLabel2.setBounds(210, 70, 200, 30);
		teamTeamLabel2.setForeground(new Color(68,68,68));
		JLabel teamScoreLabel2 = new JLabel("",JLabel.CENTER);
		teamScoreLabel2.setFont(new Font("Modern",Font.BOLD,25));
		teamScoreLabel2.setForeground(new Color(68,68,68));
		teamScoreLabel2.setBounds(430, 0, 100, 120);
		JPanel secteam = new JPanel();
		secteam.setBackground(null);
		secteam.setBounds(0, 0, panelWidth/2, 120);
		secteam.setLayout(null);
		secteam.add(teamNumLabel2);
		secteam.add(teamImgLabel2);
		secteam.add(teamNameLabel2);
		secteam.add(teamScoreLabel2);
		secteam.add(teamTeamLabel2);
		
		JLabel teamNumLabel3 = new JLabel("3",JLabel.CENTER);
		teamNumLabel3.setBounds(0, 0, 100, 120);
		teamNumLabel3.setOpaque(true);
		teamNumLabel3.setBackground(new Color(246,246,246));
		teamNumLabel3.setFont(new Font("Modern",Font.BOLD,25));
		teamNumLabel3.setForeground(new Color(144,144,144));
		JLabel teamImgLabel3 = new JLabel();
		teamImgLabel3.setBounds(110, 30, 80, 80);
		ImageIcon img3 = new ImageIcon("Img//teams//"+teams.get(2).getTeamName()+".png");
		if(teams.get(2).getTeamName().equals("NOH"))
			img3 = new ImageIcon("Img//teams//NOP.png");
		img3.setImage(img3.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
		teamImgLabel3.setIcon(img3);
		teamNameLabel3 = new JButton(teams.get(2).getFullName());
		teamNameLabel3.setBounds(210, 30, 200, 30);
		teamNameLabel3.setFont(new Font("Arial Black",0,18));
		teamNameLabel3.setForeground(new Color(0,103,175));
		teamNameLabel3.setBorder(null);
		teamNameLabel3.setBackground(null);
		teamNameLabel3.setHorizontalAlignment(JButton.LEFT);
		teamNameLabel3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamNameLabel3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamNameLabel1.setBackground(null);
				TeamVO findPlayer = (team.get(2));
				new TeamInfoFrame(findPlayer);
			}
			
		});
		JLabel teamTeamLabel3 = new JLabel(teams.get(2).getCity()+"/"+teams.get(2).getSubarea());
		teamTeamLabel3.setFont(new Font("Arial",0,15));
		teamTeamLabel3.setBounds(210, 70, 200, 30);
		teamTeamLabel3.setForeground(new Color(68,68,68));
		JLabel teamScoreLabel3 = new JLabel("",JLabel.CENTER);
		teamScoreLabel3.setFont(new Font("Modern",Font.BOLD,25));
		teamScoreLabel3.setForeground(new Color(68,68,68));
		teamScoreLabel3.setBounds(430, 0, 100, 120);
		JPanel thdteam = new JPanel();
		thdteam.setBackground(null);
		thdteam.setBounds(0, 120, panelWidth/2, 120);
		thdteam.setLayout(null);
		thdteam.add(teamNumLabel3);
		thdteam.add(teamImgLabel3);
		thdteam.add(teamNameLabel3);
		thdteam.add(teamScoreLabel3);
		thdteam.add(teamTeamLabel3);
		
		JLabel teamNumLabel4 = new JLabel("4",JLabel.CENTER);
		teamNumLabel4.setBounds(0, 0, 100, 120);
		teamNumLabel4.setOpaque(true);
		teamNumLabel4.setBackground(new Color(246,246,246));
		teamNumLabel4.setFont(new Font("Modern",Font.BOLD,25));
		teamNumLabel4.setForeground(new Color(144,144,144));
		JLabel teamImgLabel4 = new JLabel();
		teamImgLabel4.setBounds(110, 30, 80, 80);
		ImageIcon img4 = new ImageIcon("Img//teams//"+teams.get(3).getTeamName()+".png");
		if(teams.get(3).getTeamName().equals("NOH"))
			img4 = new ImageIcon("Img//teams//NOP.png");
		img4.setImage(img4.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
		teamImgLabel4.setIcon(img4);
		teamNameLabel4 = new JButton(teams.get(3).getFullName());
		teamNameLabel4.setBounds(210, 30, 200, 30);
		teamNameLabel4.setFont(new Font("Arial Black",0,18));
		teamNameLabel4.setForeground(new Color(0,103,175));
		teamNameLabel4.setBorder(null);
		teamNameLabel4.setBackground(null);
		teamNameLabel4.setHorizontalAlignment(JButton.LEFT);
		teamNameLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamNameLabel4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamNameLabel1.setBackground(null);
				TeamVO findPlayer = (team.get(3));
				new TeamInfoFrame(findPlayer);
			}
			
		});
		JLabel teamTeamLabel4 = new JLabel(teams.get(3).getCity()+"/"+teams.get(3).getSubarea());
		teamTeamLabel4.setFont(new Font("Arial",0,15));
		teamTeamLabel4.setBounds(210, 70, 200, 30);
		teamTeamLabel4.setForeground(new Color(68,68,68));
		JLabel teamScoreLabel4 = new JLabel("",JLabel.CENTER);
		teamScoreLabel4.setFont(new Font("Modern",Font.BOLD,25));
		teamScoreLabel4.setForeground(new Color(68,68,68));
		teamScoreLabel4.setBounds(430, 0, 100, 120);
		JPanel forteam = new JPanel();
		forteam.setBackground(null);
		forteam.setBounds(0, 240, panelWidth/2, 120);
		forteam.setLayout(null);
		forteam.add(teamNumLabel4);
		forteam.add(teamImgLabel4);
		forteam.add(teamNameLabel4);
		forteam.add(teamScoreLabel4);
		forteam.add(teamTeamLabel4);
		
		JLabel teamNumLabel5 = new JLabel("5",JLabel.CENTER);
		teamNumLabel5.setBounds(0, 0, 100, 110);
		teamNumLabel5.setOpaque(true);
		teamNumLabel5.setBackground(new Color(246,246,246));
		teamNumLabel5.setFont(new Font("Modern",Font.BOLD,25));
		teamNumLabel5.setForeground(new Color(144,144,144));
		JLabel teamImgLabel5 = new JLabel();
		teamImgLabel5.setBounds(110, 30, 80, 80);
		ImageIcon img5 = new ImageIcon("Img//teams//"+teams.get(4).getTeamName()+".png");
		if(teams.get(4).getTeamName().equals("NOH"))
			img5 = new ImageIcon("Img//teams//NOP.png");
		img5.setImage(img5.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
		teamImgLabel5.setIcon(img5);
		teamNameLabel5 = new JButton(teams.get(4).getFullName());
		teamNameLabel5.setBounds(210, 30, 200, 30);
		teamNameLabel5.setFont(new Font("Arial Black",0,18));
		teamNameLabel5.setForeground(new Color(0,103,175));
		teamNameLabel5.setBorder(null);
		teamNameLabel5.setBackground(null);
		teamNameLabel5.setHorizontalAlignment(JButton.LEFT);
		teamNameLabel5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamNameLabel5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamNameLabel1.setBackground(null);
				TeamVO findPlayer = (team.get(4));
				new TeamInfoFrame(findPlayer);
			}
			
		});
		JLabel teamTeamLabel5 = new JLabel(teams.get(4).getCity()+"/"+teams.get(4).getSubarea());
		teamTeamLabel5.setFont(new Font("Arial",0,15));
		teamTeamLabel5.setBounds(210, 70, 200, 30);
		teamTeamLabel5.setForeground(new Color(68,68,68));
		JLabel teamScoreLabel5 = new JLabel("",JLabel.CENTER);
		teamScoreLabel5.setFont(new Font("Modern",Font.BOLD,25));
		teamScoreLabel5.setForeground(new Color(68,68,68));
		teamScoreLabel5.setBounds(430, 0, 100, 120);
		JPanel fifteam = new JPanel();
		fifteam.setBackground(null);
		fifteam.setBounds(0, 360, panelWidth/2, 120);
		fifteam.setLayout(null);
		fifteam.add(teamNumLabel5);
		fifteam.add(teamImgLabel5);
		fifteam.add(teamNameLabel5);
		fifteam.add(teamScoreLabel5);
		fifteam.add(teamTeamLabel5);
		
		DecimalFormat df=new DecimalFormat(".##");
		NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
		switch (keyword){
		case "allScore":
			teamScoreLabel1.setText(df.format(teams.get(0).getPoints()/teams.get(0).getGamesPlayed()));
			teamScoreLabel2.setText(df.format(teams.get(1).getPoints()/teams.get(1).getGamesPlayed()));
			teamScoreLabel3.setText(df.format(teams.get(2).getPoints()/teams.get(2).getGamesPlayed()));
			teamScoreLabel4.setText(df.format(teams.get(3).getPoints()/teams.get(3).getGamesPlayed()));
			teamScoreLabel5.setText(df.format(teams.get(4).getPoints()/teams.get(4).getGamesPlayed()));
			break;
		case "allBackBord":
			teamScoreLabel1.setText(df.format(teams.get(0).getRebounds()/teams.get(0).getGamesPlayed()));
			teamScoreLabel2.setText(df.format(teams.get(1).getRebounds()/teams.get(1).getGamesPlayed()));
			teamScoreLabel3.setText(df.format(teams.get(2).getRebounds()/teams.get(2).getGamesPlayed()));
			teamScoreLabel4.setText(df.format(teams.get(3).getRebounds()/teams.get(3).getGamesPlayed()));
			teamScoreLabel5.setText(df.format(teams.get(4).getRebounds()/teams.get(4).getGamesPlayed()));
			break;
		case "allAssist":
			teamScoreLabel1.setText(df.format(teams.get(0).getAssists()/teams.get(0).getGamesPlayed()));
			teamScoreLabel2.setText(df.format(teams.get(1).getAssists()/teams.get(1).getGamesPlayed()));
			teamScoreLabel3.setText(df.format(teams.get(2).getAssists()/teams.get(2).getGamesPlayed()));
			teamScoreLabel4.setText(df.format(teams.get(3).getAssists()/teams.get(3).getGamesPlayed()));
			teamScoreLabel5.setText(df.format(teams.get(4).getAssists()/teams.get(4).getGamesPlayed()));
			break;
		case "allBlockShot":
			teamScoreLabel1.setText(df.format(teams.get(0).getBlocks()/teams.get(0).getGamesPlayed()));
			teamScoreLabel2.setText(df.format(teams.get(1).getBlocks()/teams.get(1).getGamesPlayed()));
			teamScoreLabel3.setText(df.format(teams.get(2).getBlocks()/teams.get(2).getGamesPlayed()));
			teamScoreLabel4.setText(df.format(teams.get(3).getBlocks()/teams.get(3).getGamesPlayed()));
			teamScoreLabel5.setText(df.format(teams.get(4).getBlocks()/teams.get(4).getGamesPlayed()));
			break;
		case "allST":
			teamScoreLabel1.setText(df.format(teams.get(0).getSteals()/teams.get(0).getGamesPlayed()));
			teamScoreLabel2.setText(df.format(teams.get(1).getSteals()/teams.get(1).getGamesPlayed()));
			teamScoreLabel3.setText(df.format(teams.get(2).getSteals()/teams.get(2).getGamesPlayed()));
			teamScoreLabel4.setText(df.format(teams.get(3).getSteals()/teams.get(3).getGamesPlayed()));
			teamScoreLabel5.setText(df.format(teams.get(4).getSteals()/teams.get(4).getGamesPlayed()));
			break;
		case "all3":
			teamScoreLabel1.setText(nf.format(teams.get(0).getThreePointFieldGoalPercentage()));
			teamScoreLabel2.setText(nf.format(teams.get(1).getThreePointFieldGoalPercentage()));
			teamScoreLabel3.setText(nf.format(teams.get(2).getThreePointFieldGoalPercentage()));
			teamScoreLabel4.setText(nf.format(teams.get(3).getThreePointFieldGoalPercentage()));
			teamScoreLabel5.setText(nf.format(teams.get(4).getThreePointFieldGoalPercentage()));
			break;
		case "allShot":
			teamScoreLabel1.setText(nf.format(teams.get(0).getFieldGoalPercentage()));
			teamScoreLabel2.setText(nf.format(teams.get(1).getFieldGoalPercentage()));
			teamScoreLabel3.setText(nf.format(teams.get(2).getFieldGoalPercentage()));
			teamScoreLabel4.setText(nf.format(teams.get(3).getFieldGoalPercentage()));
			teamScoreLabel5.setText(nf.format(teams.get(4).getFieldGoalPercentage()));
			break;
		case "allPenalty":
			teamScoreLabel1.setText(nf.format(teams.get(0).getFreeThrowPercentage()));
			teamScoreLabel2.setText(nf.format(teams.get(1).getFreeThrowPercentage()));
			teamScoreLabel3.setText(nf.format(teams.get(2).getFreeThrowPercentage()));
			teamScoreLabel4.setText(nf.format(teams.get(3).getFreeThrowPercentage()));
			teamScoreLabel5.setText(nf.format(teams.get(4).getFreeThrowPercentage()));
			break;
		default:
			break;
		}
		
		JPanel otherPanel = new JPanel();
		otherPanel.setBounds(panelWidth/2, 0, panelWidth/2, 480);
		otherPanel.setBackground(null);
		otherPanel.setLayout(null);
		otherPanel.add(secteam);
		otherPanel.add(thdteam);
		otherPanel.add(forteam);
		otherPanel.add(fifteam);
		
		this.setBounds(0, 100, panelWidth, 480);
		this.setBackground(null);
		this.setLayout(null);
		this.add(firstPanel);
		this.add(otherPanel);
		
	}
}
