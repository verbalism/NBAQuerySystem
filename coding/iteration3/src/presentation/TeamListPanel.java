package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;
import businesslogic.DataBL;
import businesslogicService.DataBLService;

public class TeamListPanel extends JPanel implements ActionListener{
	int panelWidth,panelHeight;
	JTextField searchField;
	JButton searchBtn;
	DataBLService dbl = new DataBL();
	ArrayList<TeamVO> teams;
	public TeamListPanel(JPanel fpanel){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panelHeight = screenSize.height-160;
		panelWidth = screenSize.width-320;
		
		this.setBounds(10, 100, panelWidth, panelHeight);
		this.setBackground(Color.white);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 10, panelWidth, 50);
		searchPanel.setBackground(new Color(87,89,91));
		JLabel title = new JLabel("球   队");
		title.setBounds(20,0,100,50);
		title.setBackground(null);
		title.setFont(new Font("微软雅黑",Font.BOLD,16));
		title.setForeground(Color.WHITE);
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
		searchField = new JTextField();
		searchField.setBounds(panelWidth-300,10,200,30);
		searchField.setBackground(new Color(69,69,69));
		searchField.setBorder(null);
		searchField.setText("  输入球队名查找");
		searchField.setForeground(Color.WHITE);
		searchField.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				searchField.setText(null);
			}
		});
		searchField.addKeyListener(new KeyAdapter(){ 
		      public void keyPressed(KeyEvent e)    
		      {    
		        if(e.getKeyChar()==KeyEvent.VK_ENTER )   //按回车键执行相应操作; 
		        { 
		          searchBtn.doClick();
		        } 
		      } 
		    });
		searchPanel.setLayout(null);
		searchPanel.add(title);
		searchPanel.add(searchField);
		searchPanel.add(searchBtn);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 70, panelWidth, 40);
		titlePanel.setBackground(new Color(30,81,140));
		JLabel east = new JLabel("东部联盟");
		east.setBounds(20,0,100,40);
		east.setForeground(Color.white);
		east.setFont(new Font("微软雅黑",0,15));
		JLabel west = new JLabel("西部联盟");
		west.setBounds(panelWidth/2+20,0,100,40);
		west.setForeground(Color.white);
		west.setFont(new Font("微软雅黑",0,15));
		
		titlePanel.setLayout(null);
		titlePanel.add(east);
		titlePanel.add(west);
		
		JPanel areaPanel = new JPanel();
		areaPanel.setBounds(0, 110, panelWidth, 30);
		areaPanel.setBackground(new Color(218,218,218));
		JLabel southEast = new JLabel("东南分区");
		southEast.setBounds(20,0,100,30);
		southEast.setForeground(new Color(68,68,68));
		southEast.setFont(new Font("微软雅黑",0,13));
		JLabel center = new JLabel("中央分区");
		center.setBounds(panelWidth/6+20,0,100,30);
		center.setForeground(new Color(68,68,68));
		center.setFont(new Font("微软雅黑",0,13));
		JLabel Altantic = new JLabel("大西洋分区");
		Altantic.setBounds(panelWidth/3+20,0,100,30);
		Altantic.setForeground(new Color(68,68,68));
		Altantic.setFont(new Font("微软雅黑",0,13));
		JLabel pacific = new JLabel("太平洋分区");
		pacific.setBounds(panelWidth/2+20,0,100,30);
		pacific.setForeground(new Color(68,68,68));
		pacific.setFont(new Font("微软雅黑",0,13));
		JLabel northWest = new JLabel("西北分区");
		northWest.setBounds(panelWidth*2/3+20,0,100,30);
		northWest.setForeground(new Color(68,68,68));
		northWest.setFont(new Font("微软雅黑",0,13));
		JLabel southWest = new JLabel("西南分区");
		southWest.setBounds(panelWidth*5/6+20,0,100,30);
		southWest.setForeground(new Color(68,68,68));
		southWest.setFont(new Font("微软雅黑",0,13));
		areaPanel.setLayout(null);
		areaPanel.add(southWest);
		areaPanel.add(northWest);
		areaPanel.add(pacific);
		areaPanel.add(Altantic);
		areaPanel.add(center);
		areaPanel.add(southEast);
		
		
		JPanel table = new JPanel();
        table.setBackground(null);
		table.setOpaque(false);
        table.setBounds(0, 140, panelWidth, panelHeight-200-3);
        
        TeamLabel atl = new TeamLabel("ATL", fpanel, this);
        atl.setBounds(0, 0, panelWidth/6-2, (panelHeight-200-3)/5-2);
        atl.setBackground(null);
        TeamLabel cha = new TeamLabel("CHA", fpanel, this);
        cha.setBounds(0, (panelHeight-200-3)/5, panelWidth/6-2, (panelHeight-200-3)/5-2);
        cha.setBackground(new Color(246, 246, 246));
        TeamLabel mia = new TeamLabel("MIA", fpanel, this);
        mia.setBounds(0, (panelHeight-200-3)/5*2, panelWidth/6-2, (panelHeight-200-3)/5-2);
        mia.setBackground(null);
        TeamLabel orl = new TeamLabel("ORL", fpanel, this);
        orl.setBounds(0, (panelHeight-200-3)/5*3, panelWidth/6-2, (panelHeight-200-3)/5-2);
        orl.setBackground(new Color(246, 246, 246));
        TeamLabel was = new TeamLabel("WAS", fpanel, this);
        was.setBounds(0, (panelHeight-200-3)/5*4, panelWidth/6-2, (panelHeight-200-3)/5-2);
        was.setBackground(null);
        
        TeamLabel chi = new TeamLabel("CHI", fpanel, this);
        chi.setBounds(panelWidth/6, 0, panelWidth/6-2, (panelHeight-200-3)/5-2);
        chi.setBackground(null);
        TeamLabel cle = new TeamLabel("CLE", fpanel, this);
        cle.setBounds(panelWidth/6, (panelHeight-200-3)/5, panelWidth/6-2, (panelHeight-200-3)/5-2);
        cle.setBackground(new Color(246, 246, 246));
        TeamLabel det = new TeamLabel("DET", fpanel, this);
        det.setBounds(panelWidth/6, (panelHeight-200-3)/5*2, panelWidth/6-2, (panelHeight-200-3)/5-2);
        det.setBackground(null);
        TeamLabel ind = new TeamLabel("IND", fpanel, this);
        ind.setBounds(panelWidth/6, (panelHeight-200-3)/5*3, panelWidth/6-2, (panelHeight-200-3)/5-2);
        ind.setBackground(new Color(246, 246, 246));
        TeamLabel mil = new TeamLabel("MIL", fpanel, this);
        mil.setBounds(panelWidth/6, (panelHeight-200-3)/5*4, panelWidth/6-2, (panelHeight-200-3)/5-2);
        mil.setBackground(null);
        
        TeamLabel bos = new TeamLabel("BOS", fpanel, this);
        bos.setBounds(panelWidth/3, 0, panelWidth/6-2, (panelHeight-200-3)/5-2);
        bos.setBackground(null);
        TeamLabel bkn = new TeamLabel("BKN", fpanel, this);
        bkn.setBounds(panelWidth/3, (panelHeight-200-3)/5, panelWidth/6-2, (panelHeight-200-3)/5-2);
        bkn.setBackground(new Color(246, 246, 246));
        TeamLabel nyk = new TeamLabel("NYK", fpanel, this);
        nyk.setBounds(panelWidth/3, (panelHeight-200-3)/5*2, panelWidth/6-2, (panelHeight-200-3)/5-2);
        nyk.setBackground(null);
        TeamLabel phi = new TeamLabel("PHI", fpanel, this);
        phi.setBounds(panelWidth/3, (panelHeight-200-3)/5*3, panelWidth/6-2, (panelHeight-200-3)/5-2);
        phi.setBackground(new Color(246, 246, 246));
        TeamLabel tor = new TeamLabel("TOR", fpanel, this);
        tor.setBounds(panelWidth/3, (panelHeight-200-3)/5*4, panelWidth/6-2, (panelHeight-200-3)/5-2);
        tor.setBackground(null);
        
        TeamLabel gsw = new TeamLabel("GSW", fpanel, this);
        gsw.setBounds(panelWidth/2, 0, panelWidth/6-2, (panelHeight-200-3)/5-2);
        gsw.setBackground(null);
        TeamLabel lac = new TeamLabel("LAC", fpanel, this);
        lac.setBounds(panelWidth/2, (panelHeight-200-3)/5, panelWidth/6-2, (panelHeight-200-3)/5-2);
        lac.setBackground(new Color(246, 246, 246));
        TeamLabel lal = new TeamLabel("LAL", fpanel, this);
        lal.setBounds(panelWidth/2, (panelHeight-200-3)/5*2, panelWidth/6-2, (panelHeight-200-3)/5-2);
        lal.setBackground(null);
        TeamLabel phx = new TeamLabel("PHX", fpanel, this);
        phx.setBounds(panelWidth/2, (panelHeight-200-3)/5*3, panelWidth/6-2, (panelHeight-200-3)/5-2);
        phx.setBackground(new Color(246, 246, 246));
        TeamLabel sac = new TeamLabel("SAC", fpanel, this);
        sac.setBounds(panelWidth/2, (panelHeight-200-3)/5*4, panelWidth/6-2, (panelHeight-200-3)/5-2);
        sac.setBackground(null);
        
        TeamLabel den = new TeamLabel("DEN", fpanel, this);
        den.setBounds(panelWidth/3*2, 0, panelWidth/6-2, (panelHeight-200-3)/5-2);
        den.setBackground(null);
        TeamLabel min = new TeamLabel("MIN", fpanel, this);
        min.setBounds(panelWidth/3*2, (panelHeight-200-3)/5, panelWidth/6-2, (panelHeight-200-3)/5-2);
        min.setBackground(new Color(246, 246, 246));
        TeamLabel okc = new TeamLabel("OKC", fpanel, this);
        okc.setBounds(panelWidth/3*2, (panelHeight-200-3)/5*2, panelWidth/6-2, (panelHeight-200-3)/5-2);
        okc.setBackground(null);
        TeamLabel por = new TeamLabel("POR", fpanel, this);
        por.setBounds(panelWidth/3*2, (panelHeight-200-3)/5*3, panelWidth/6-2, (panelHeight-200-3)/5-2);
        por.setBackground(new Color(246, 246, 246));
        TeamLabel uta = new TeamLabel("UTA", fpanel, this);
        uta.setBounds(panelWidth/3*2, (panelHeight-200-3)/5*4, panelWidth/6-2, (panelHeight-200-3)/5-2);
        uta.setBackground(null);
        
        TeamLabel dal = new TeamLabel("DAL", fpanel, this);
        dal.setBounds(panelWidth*5/6, 0, panelWidth/6-2, (panelHeight-200-3)/5-2);
        dal.setBackground(null);
        TeamLabel hou = new TeamLabel("HOU", fpanel, this);
        hou.setBounds(panelWidth*5/6, (panelHeight-200-3)/5, panelWidth/6-2, (panelHeight-200-3)/5-2);
        hou.setBackground(new Color(246, 246, 246));
        TeamLabel mem = new TeamLabel("MEM", fpanel, this);
        mem.setBounds(panelWidth*5/6, (panelHeight-200-3)/5*2, panelWidth/6-2, (panelHeight-200-3)/5-2);
        mem.setBackground(null);
        TeamLabel nop = new TeamLabel("NOP", fpanel, this);
        nop.setBounds(panelWidth*5/6, (panelHeight-200-3)/5*3, panelWidth/6-2, (panelHeight-200-3)/5-2);
        nop.setBackground(new Color(246, 246, 246));
        TeamLabel sas = new TeamLabel("SAS", fpanel, this);
        sas.setBounds(panelWidth*5/6, (panelHeight-200-3)/5*4, panelWidth/6-2, (panelHeight-200-3)/5-2);
        sas.setBackground(null);
        
        table.setLayout(null);
        table.add(atl);
        table.add(cha);
        table.add(mia);
        table.add(orl);
        table.add(was);
        table.add(chi);
        table.add(cle);
        table.add(det);
        table.add(ind);
        table.add(mil);
        table.add(bos);
        table.add(bkn);
        table.add(nyk);
        table.add(phi);
        table.add(tor);
        
        table.add(gsw);
        table.add(lac);
        table.add(lal);
        table.add(phx);
        table.add(sac);
        table.add(den);
        table.add(min);
        table.add(okc);
        table.add(por);
        table.add(uta);
        table.add(dal);
        table.add(hou);
        table.add(mem);
        table.add(nop);
        table.add(sas);
		
		
		this.setLayout(null);
		this.add(searchPanel);
		this.add(titlePanel);
		this.add(areaPanel);
		this.add(table);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchBtn){
			String name = searchField.getText();
		    TeamVO team = new TeamVO();
		    for(int i=0;i<teams.size();i++){
		    	if(teams.get(i).getTeamName().equals(name)||teams.get(i).getFullName().equals(name)){
		    		team = teams.get(i);
		    		break;
		    	}
		    }
		    if(team.getTeamName()!= null)
		    	new TeamInfoFrame(team);
		    else
		    	new ActionDialog("球队名有误请重新输入");
		}
		
	}
}
