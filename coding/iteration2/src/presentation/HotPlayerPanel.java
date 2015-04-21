package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HotPlayerPanel extends JPanel{
	public HotPlayerPanel(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int panelHeight = screenSize.height-160;
		int panelWidth = screenSize.width-320;
		
		
		JLabel playerImgLabel1 = new JLabel();
		playerImgLabel1.setBounds(0, 40, 250, 400);
		playerImgLabel1.setBackground(null);
		ImageIcon img = new ImageIcon("Img//players//action//Jameer Nelson.png");
		img.setImage(img.getImage().getScaledInstance(250,400,Image.SCALE_DEFAULT));
		playerImgLabel1.setIcon(img);
		JLabel playerNumLabel1 = new JLabel("1");
		playerNumLabel1.setFont(new Font("Modern",Font.BOLD,90));
		playerNumLabel1.setBounds(230, 0, 50, 200);
		playerNumLabel1.setForeground(new Color(68,68,68));
		JLabel playerNameLabel1 = new JLabel("Aaron Gray");
		playerNameLabel1.setFont(new Font("Arial Black",0,25));
		playerNameLabel1.setBounds(300, 60, 200, 35);
		playerNameLabel1.setForeground(new Color(0,103,175));
		JLabel playerTeamLabel1 = new JLabel("G/Rocket");
		playerTeamLabel1.setFont(new Font("Arial",0,20));
		playerTeamLabel1.setBounds(300, 95, 200, 50);
		playerTeamLabel1.setForeground(new Color(68,68,68));
		JLabel playerScoreLabel1 = new JLabel("35");
		playerScoreLabel1.setFont(new Font("Modern",Font.BOLD,35));
		playerScoreLabel1.setForeground(new Color(68,68,68));
		playerScoreLabel1.setBounds(300, 160, 200, 30);
		
		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(0, 0, panelWidth/2, 480);
		firstPanel.setBackground(null);
		firstPanel.setLayout(null);
		firstPanel.add(playerImgLabel1);
		firstPanel.add(playerNumLabel1);
		firstPanel.add(playerNameLabel1);
		firstPanel.add(playerTeamLabel1);
		firstPanel.add(playerScoreLabel1);
		
		JLabel playerNumLabel2 = new JLabel("2",JLabel.CENTER);
		playerNumLabel2.setBounds(0, 0, 100, 120);
		playerNumLabel2.setOpaque(true);
		playerNumLabel2.setBackground(new Color(246,246,246));
		playerNumLabel2.setFont(new Font("Modern",Font.BOLD,25));
		playerNumLabel2.setForeground(new Color(144,144,144));
		JLabel playerImgLabel2 = new JLabel();
		playerImgLabel2.setBounds(110, 30, 100, 80);
		ImageIcon img2 = new ImageIcon("Img//players//portrait//Aaron Brooks.png");
		img2.setImage(img2.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
		playerImgLabel2.setIcon(img2);
		JLabel playerNameLabel2 = new JLabel("Aaron Brooks");
		playerNameLabel2.setBounds(230, 30, 200, 30);
		playerNameLabel2.setFont(new Font("Arial Black",0,18));
		playerNameLabel2.setForeground(new Color(0,103,175));
		JLabel playerTeamLabel2 = new JLabel("G/Rocket");
		playerTeamLabel2.setFont(new Font("Arial",0,15));
		playerTeamLabel2.setBounds(230, 70, 200, 30);
		playerTeamLabel2.setForeground(new Color(68,68,68));
		JLabel playerScoreLabel2 = new JLabel("33",JLabel.CENTER);
		playerScoreLabel2.setFont(new Font("Modern",Font.BOLD,25));
		playerScoreLabel2.setForeground(new Color(68,68,68));
		playerScoreLabel2.setBounds(430, 0, 100, 120);
		JPanel secPlayer = new JPanel();
		secPlayer.setBackground(null);
		secPlayer.setBounds(0, 0, panelWidth/2, 120);
		secPlayer.setLayout(null);
		secPlayer.add(playerNumLabel2);
		secPlayer.add(playerImgLabel2);
		secPlayer.add(playerNameLabel2);
		secPlayer.add(playerScoreLabel2);
		secPlayer.add(playerTeamLabel2);
		
		JLabel playerNumLabel3 = new JLabel("3",JLabel.CENTER);
		playerNumLabel3.setBounds(0, 0, 100, 120);
		playerNumLabel3.setOpaque(true);
		playerNumLabel3.setBackground(new Color(246,246,246));
		playerNumLabel3.setFont(new Font("Modern",Font.BOLD,25));
		playerNumLabel3.setForeground(new Color(144,144,144));
		JLabel playerImgLabel3 = new JLabel();
		playerImgLabel3.setBounds(110, 30, 100, 80);
		ImageIcon img3 = new ImageIcon("Img//players//portrait//Al Harrington.png");
		img3.setImage(img3.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
		playerImgLabel3.setIcon(img3);
		JLabel playerNameLabel3 = new JLabel("Al Harrington");
		playerNameLabel3.setBounds(230, 30, 200, 30);
		playerNameLabel3.setFont(new Font("Arial Black",0,18));
		playerNameLabel3.setForeground(new Color(0,103,175));
		JLabel playerTeamLabel3 = new JLabel("G/Rocket");
		playerTeamLabel3.setFont(new Font("Arial",0,15));
		playerTeamLabel3.setBounds(230, 70, 200, 30);
		playerTeamLabel3.setForeground(new Color(68,68,68));
		JLabel playerScoreLabel3 = new JLabel("33",JLabel.CENTER);
		playerScoreLabel3.setFont(new Font("Modern",Font.BOLD,25));
		playerScoreLabel3.setForeground(new Color(68,68,68));
		playerScoreLabel3.setBounds(430, 0, 100, 120);
		JPanel thdPlayer = new JPanel();
		thdPlayer.setBackground(null);
		thdPlayer.setBounds(0, 120, panelWidth/2, 120);
		thdPlayer.setLayout(null);
		thdPlayer.add(playerNumLabel3);
		thdPlayer.add(playerImgLabel3);
		thdPlayer.add(playerNameLabel3);
		thdPlayer.add(playerScoreLabel3);
		thdPlayer.add(playerTeamLabel3);
		
		JLabel playerNumLabel4 = new JLabel("4",JLabel.CENTER);
		playerNumLabel4.setBounds(0, 0, 100, 120);
		playerNumLabel4.setOpaque(true);
		playerNumLabel4.setBackground(new Color(246,246,246));
		playerNumLabel4.setFont(new Font("Modern",Font.BOLD,25));
		playerNumLabel4.setForeground(new Color(144,144,144));
		JLabel playerImgLabel4 = new JLabel();
		playerImgLabel4.setBounds(110, 30, 100, 80);
		ImageIcon img4 = new ImageIcon("Img//players//portrait//Glen Davis.png");
		img4.setImage(img4.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
		playerImgLabel4.setIcon(img4);
		JLabel playerNameLabel4 = new JLabel("Glen Davis");
		playerNameLabel4.setBounds(230, 30, 200, 30);
		playerNameLabel4.setFont(new Font("Arial Black",0,18));
		playerNameLabel4.setForeground(new Color(0,103,175));
		JLabel playerTeamLabel4 = new JLabel("G/Rocket");
		playerTeamLabel4.setFont(new Font("Arial",0,15));
		playerTeamLabel4.setBounds(230, 70, 200, 30);
		playerTeamLabel4.setForeground(new Color(68,68,68));
		JLabel playerScoreLabel4 = new JLabel("33",JLabel.CENTER);
		playerScoreLabel4.setFont(new Font("Modern",Font.BOLD,25));
		playerScoreLabel4.setForeground(new Color(68,68,68));
		playerScoreLabel4.setBounds(430, 0, 100, 120);
		JPanel forPlayer = new JPanel();
		forPlayer.setBackground(null);
		forPlayer.setBounds(0, 240, panelWidth/2, 120);
		forPlayer.setLayout(null);
		forPlayer.add(playerNumLabel4);
		forPlayer.add(playerImgLabel4);
		forPlayer.add(playerNameLabel4);
		forPlayer.add(playerScoreLabel4);
		forPlayer.add(playerTeamLabel4);
		
		JLabel playerNumLabel5 = new JLabel("5",JLabel.CENTER);
		playerNumLabel5.setBounds(0, 0, 100, 110);
		playerNumLabel5.setOpaque(true);
		playerNumLabel5.setBackground(new Color(246,246,246));
		playerNumLabel5.setFont(new Font("Modern",Font.BOLD,25));
		playerNumLabel5.setForeground(new Color(144,144,144));
		JLabel playerImgLabel5 = new JLabel();
		playerImgLabel5.setBounds(110, 30, 100, 80);
		ImageIcon img5 = new ImageIcon("Img//players//portrait//Luol Deng.png");
		img5.setImage(img5.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
		playerImgLabel5.setIcon(img5);
		JLabel playerNameLabel5 = new JLabel("Luol Deng");
		playerNameLabel5.setBounds(230, 30, 200, 30);
		playerNameLabel5.setFont(new Font("Arial Black",0,18));
		playerNameLabel5.setForeground(new Color(0,103,175));
		JLabel playerTeamLabel5 = new JLabel("G/Rocket");
		playerTeamLabel5.setFont(new Font("Arial",0,15));
		playerTeamLabel5.setBounds(230, 70, 200, 30);
		playerTeamLabel5.setForeground(new Color(68,68,68));
		JLabel playerScoreLabel5 = new JLabel("33",JLabel.CENTER);
		playerScoreLabel5.setFont(new Font("Modern",Font.BOLD,25));
		playerScoreLabel5.setForeground(new Color(68,68,68));
		playerScoreLabel5.setBounds(430, 0, 100, 120);
		JPanel fifPlayer = new JPanel();
		fifPlayer.setBackground(null);
		fifPlayer.setBounds(0, 360, panelWidth/2, 120);
		fifPlayer.setLayout(null);
		fifPlayer.add(playerNumLabel5);
		fifPlayer.add(playerImgLabel5);
		fifPlayer.add(playerNameLabel5);
		fifPlayer.add(playerScoreLabel5);
		fifPlayer.add(playerTeamLabel5);
		
		
		
		
		
		
		JPanel otherPanel = new JPanel();
		otherPanel.setBounds(panelWidth/2, 0, panelWidth/2, 480);
		otherPanel.setBackground(null);
		otherPanel.setLayout(null);
		otherPanel.add(secPlayer);
		otherPanel.add(thdPlayer);
		otherPanel.add(forPlayer);
		otherPanel.add(fifPlayer);
		
		this.setBounds(0, 100, panelWidth, 480);
		this.setBackground(null);
		this.setLayout(null);
		this.add(firstPanel);
		this.add(otherPanel);
		
	}

}
