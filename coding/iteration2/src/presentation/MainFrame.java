package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import businesslogic.AnalysisBL;
import businesslogicService.AnalysisBLService;

public class MainFrame extends JFrame implements ActionListener{
	int frameHeight,frameWidth,panelWidth,panelHeight;
	JButton teamInfoBtn,playerInfoBtn,matchInfoBtn,teamDataBtn,playerDataBtn,hotBtn;
	JPanel containPanel;
	TeamListPanel teamListPanel = new TeamListPanel(); boolean teamlist = true; boolean tl = false;
	PlayerListPanel playerListPanel; boolean playerlist = false; boolean pl = true;
	TeamDataPanel teamDataPanel; boolean teamdata = false; boolean td = true;
	PlayerDataPanel playerDataPanel; boolean playerdata = false; boolean pd = true;
	MatchListPanel matchListPanel; boolean matchlist = false; boolean ml = true;
	HotPanel hotPanel; boolean hot = false; boolean h = true;
	static ProgressBar pb; static Boolean load = true;
	public static void main(String args[]){
		AnalysisBLService abs = new AnalysisBL();
		 final Thread line =	new Thread() {
			    public void run() {
			    	synchronized (this){
			        while (load){
			        	pb = new ProgressBar((Frame) null, null, "加载中", null,null);
			    		pb.show();
			            try {
			                this.sleep(100);
			            } catch (InterruptedException e) {
			            	e.printStackTrace();
			            }
			        }
			    	}
			    }
			 
			};
		Thread f = new Thread(){
			public void run(){
				synchronized (this){
					MainFrame mf=new MainFrame();
					while (load) {
			            try {
			                sleep(1000);
			            } catch (InterruptedException e) {
			            	e.printStackTrace();
			            }
			            load = false;
			        }
					pb.close();
					show(mf);
				}
			}
		};
		line.start();
		f.start();
		abs.updateData();
	}
	
	
	public MainFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image icon = kit.getImage("Img//icon.png");
		this.setIconImage(icon);
		Dimension screenSize = kit.getScreenSize();
		frameHeight = screenSize.height-40;
		frameWidth = screenSize.width-285;
		panelWidth = frameWidth-35;
		panelHeight = frameHeight-110;
		
		teamInfoBtn = new JButton();
		teamInfoBtn.setText("球 队");
		teamInfoBtn.setBackground(null);
		teamInfoBtn.setBorder(null);
		teamInfoBtn.setFont(new Font("华文细黑",Font.BOLD,16));
		teamInfoBtn.setForeground(Color.white);
		teamInfoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamInfoBtn.setBounds(0, 0, (panelWidth-200)/6, 40);
		teamInfoBtn.addActionListener(this);
		teamInfoBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				teamInfoBtn.setBackground(new Color(133,177,226));
			}
			public void mouseExited(MouseEvent arg0) {
				teamInfoBtn.setBackground(null);
				}
		});
		teamInfoBtn.addActionListener(this);
		playerInfoBtn = new JButton();
		playerInfoBtn.setText("球 员");
		playerInfoBtn.setBackground(null);
		playerInfoBtn.setBorder(null);
		playerInfoBtn.setFont(new Font("华文细黑",Font.BOLD,16));
		playerInfoBtn.setForeground(Color.white);
		playerInfoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playerInfoBtn.setBounds((panelWidth-200)/6, 0, (panelWidth-200)/6, 40);
		playerInfoBtn.addActionListener(this);
		playerInfoBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				playerInfoBtn.setBackground(new Color(133,177,226));
			}
			public void mouseExited(MouseEvent arg0) {
				playerInfoBtn.setBackground(null);
				}
		});
		playerInfoBtn.addActionListener(this);
		matchInfoBtn = new JButton();
		matchInfoBtn.setText("比  赛");
		matchInfoBtn.setBackground(null);
		matchInfoBtn.setBorder(null);
		matchInfoBtn.setFont(new Font("华文细黑",Font.BOLD,16));
		matchInfoBtn.setForeground(Color.white);
		matchInfoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		matchInfoBtn.setBounds((panelWidth-200)/3, 0, (panelWidth-200)/6, 40);
		matchInfoBtn.addActionListener(this);
		matchInfoBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				matchInfoBtn.setBackground(new Color(133,177,226));
			}
			public void mouseExited(MouseEvent arg0) {
				matchInfoBtn.setBackground(null);
				}
		});
		matchInfoBtn.addActionListener(this);
		teamDataBtn = new JButton();
		teamDataBtn.setText("球队分析");
		teamDataBtn.setBackground(null);
		teamDataBtn.setBorder(null);
		teamDataBtn.setFont(new Font("华文细黑",Font.BOLD,16));
		teamDataBtn.setForeground(Color.white);
		teamDataBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		teamDataBtn.setBounds((panelWidth-200)/2, 0, (panelWidth-200)/6, 40);
		teamDataBtn.addActionListener(this);
		teamDataBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				teamDataBtn.setBackground(new Color(133,177,226));
			}
			public void mouseExited(MouseEvent arg0) {
				teamDataBtn.setBackground(null);
				}
		});
		teamDataBtn.addActionListener(this);
		playerDataBtn = new JButton();
		playerDataBtn.setText("球员分析");
		playerDataBtn.setBackground(null);
		playerDataBtn.setBorder(null);
		playerDataBtn.setFont(new Font("华文细黑",Font.BOLD,16));
		playerDataBtn.setForeground(Color.white);
		playerDataBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playerDataBtn.setBounds((panelWidth-200)*2/3,0, (panelWidth-200)/6, 40);
		playerDataBtn.addActionListener(this);
		playerDataBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				playerDataBtn.setBackground(new Color(133,177,226));
			}
			public void mouseExited(MouseEvent arg0) {
				playerDataBtn.setBackground(null);
				}
		});
		playerDataBtn.addActionListener(this);
		hotBtn = new JButton();
		hotBtn.setText("热 点");
		hotBtn.setBackground(null);
		hotBtn.setBorder(null);
		hotBtn.setFont(new Font("华文细黑",Font.BOLD,16));
		hotBtn.setForeground(Color.white);
		hotBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hotBtn.setBounds((panelWidth-200)*5/6, 0, (panelWidth-200)/6, 40);
		hotBtn.addActionListener(this);
		hotBtn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				hotBtn.setBackground(new Color(133,177,226));
			}
			public void mouseExited(MouseEvent arg0) {
				hotBtn.setBackground(null);
				}
		});
		hotBtn.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(200, 50, panelWidth-200, 40);
		buttonPanel.setBackground(new Color(26,71,123));
		buttonPanel.setLayout(null);
		buttonPanel.add(teamInfoBtn);
		buttonPanel.add(playerInfoBtn);
		buttonPanel.add(matchInfoBtn);
		buttonPanel.add(teamDataBtn);
		buttonPanel.add(playerDataBtn);
		buttonPanel.add(hotBtn);
		
		
		JPanel guidePanel = new JPanel();
		guidePanel.setBounds(10, 10, panelWidth, 90);
		guidePanel.setBackground(new Color(0,103,175));
		guidePanel.setLayout(null);
		guidePanel.add(buttonPanel);
		
		containPanel = new JPanel();
		containPanel.setBounds(0, 0, frameWidth-15, frameHeight);
		containPanel.setBackground(Color.WHITE);
		containPanel.setLayout(null);
		containPanel.add(guidePanel);
		containPanel.add(teamListPanel);
		
		this.setLayout(null);
		this.add(containPanel);
		this.setBounds(150, 0,frameWidth, frameHeight);
		this.setTitle("NBA查询系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void show(MainFrame mf){
		mf.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==teamInfoBtn){
			if(teamlist){
				containPanel.remove(teamListPanel);
				teamlist = false;
			}
			if(teamdata){
				containPanel.remove(teamDataPanel);
				teamdata = false;
			}
			if(playerlist){
				containPanel.remove(playerListPanel);
				playerlist = false;
			}
			if(playerdata){
				containPanel.remove(playerDataPanel);
				playerdata = false;
			}
			if(matchlist){
				containPanel.remove(matchListPanel);
				matchlist = false;
			}
			if(hot){
				containPanel.remove(hotPanel);
				hot = false;
			}
			if(tl){
				teamListPanel = new TeamListPanel();
				tl = false;
			}
			containPanel.add(teamListPanel);
			teamlist = true;
			containPanel.repaint();
		}
		if(e.getSource()==playerInfoBtn){
			if(teamlist){
				containPanel.remove(teamListPanel);
				teamlist = false;
			}
			if(teamdata){
				containPanel.remove(teamDataPanel);
				teamdata = false;
			}
			if(playerlist){
				containPanel.remove(playerListPanel);
				playerlist = false;
			}
			if(playerdata){
				containPanel.remove(playerDataPanel);
				playerdata = false;
			}
			if(matchlist){
				containPanel.remove(matchListPanel);
				matchlist = false;
			}
			if(hot){
				containPanel.remove(hotPanel);
				hot = false;
			}
			if(pl){
				playerListPanel = new PlayerListPanel();
				pl = false;
			}
			containPanel.add(playerListPanel);
			playerlist = true;
			containPanel.repaint();
		}
		if(e.getSource()==matchInfoBtn){
			if(teamlist){
				containPanel.remove(teamListPanel);
				teamlist = false;
			}
			if(teamdata){
				containPanel.remove(teamDataPanel);
				teamdata = false;
			}
			if(playerlist){
				containPanel.remove(playerListPanel);
				playerlist = false;
			}
			if(playerdata){
				containPanel.remove(playerDataPanel);
				playerdata = false;
			}
			if(matchlist){
				containPanel.remove(matchListPanel);
				matchlist = false;
			}
			if(hot){
				containPanel.remove(hotPanel);
				hot = false;
			}
			if(ml){
				matchListPanel = new MatchListPanel();
				ml = false;
			}
			containPanel.add(matchListPanel);
			matchlist = true;
			containPanel.repaint();
		}
		if(e.getSource()==teamDataBtn){
			if(teamlist){
				containPanel.remove(teamListPanel);
				teamlist = false;
			}
			if(teamdata){
				containPanel.remove(teamDataPanel);
				teamdata = false;
			}
			if(playerlist){
				containPanel.remove(playerListPanel);
				playerlist = false;
			}
			if(playerdata){
				containPanel.remove(playerDataPanel);
				playerdata = false;
			}
			if(matchlist){
				containPanel.remove(matchListPanel);
				matchlist = false;
			}
			if(hot){
				containPanel.remove(hotPanel);
				hot = false;
			}
			if(td){
				teamDataPanel = new TeamDataPanel();
				td = false;
			}
			containPanel.add(teamDataPanel);
			teamdata = true;
			containPanel.repaint();
		}
		if(e.getSource()==playerDataBtn){
			if(teamlist){
				containPanel.remove(teamListPanel);
				teamlist = false;
			}
			if(teamdata){
				containPanel.remove(teamDataPanel);
				teamdata = false;
			}
			if(playerlist){
				containPanel.remove(playerListPanel);
				playerlist = false;
			}
			if(playerdata){
				containPanel.remove(playerDataPanel);
				playerdata = false;
			}
			if(matchlist){
				containPanel.remove(matchListPanel);
				matchlist = false;
			}
			if(hot){
				containPanel.remove(hotPanel);
				hot = false;
			}
			if(pd){
				playerDataPanel = new PlayerDataPanel();
				pd = false;
			}
			containPanel.add(playerDataPanel);
			playerdata = true;
			containPanel.repaint();
		}
		if(e.getSource()==hotBtn){
			if(teamlist){
				containPanel.remove(teamListPanel);
				teamlist = false;
			}
			if(teamdata){
				containPanel.remove(teamDataPanel);
				teamdata = false;
			}
			if(playerlist){
				containPanel.remove(playerListPanel);
				playerlist = false;
			}
			if(playerdata){
				containPanel.remove(playerDataPanel);
				playerdata = false;
			}
			if(matchlist){
				containPanel.remove(matchListPanel);
				matchlist = false;
			}
			if(hot){
				containPanel.remove(hotPanel);
				hot = false;
			}
			if(h){
				hotPanel = new HotPanel();
				h = false;
			}
			containPanel.add(hotPanel);
			hot = true;
			containPanel.repaint();
		}
	}
	
}
