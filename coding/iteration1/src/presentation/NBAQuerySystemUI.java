package presentation;


import java.util.ArrayList;





import java.util.Collections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import vo.playerCondition;
import vo.playerInfoVO;
import vo.playerPartition;
import vo.playerPosition;
import vo.sortOpinions;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableItem;

import businesslogic.ServiceImp;
import vo.playerCondition;
import vo.playerInfoVO;
import vo.teamCondition;
import vo.teamInfoVO;
import vo.playerPartition;
import vo.playerPosition;
import vo.sortOpinions;
import vo.teamPartion;


public class NBAQuerySystemUI {

	protected Shell shell;
	/**
	 * Launch the application.
	 * @param args
	 */
	private boolean isDraw = false;   
	private int xx;   
	private int yy;
	private static Table table;
	private Text text;
	private static Table table_2;
	private Text text_1;
	private static Table table_1;
	private static Table table_3;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Composite composite_1 ;
	private Composite composite_2 ;
	private Composite composite_3 ;
	private Composite composite_4 ;
	private Composite composite_5 ;
	private Composite composite_6 ;
	private Composite composite_7 ;
	private Composite composite_8 ;
	private Composite composite_9;
	private Text teamText_1;
	private Text teamText_2;
	private Text teamText_3;
	private Text teamText_4;
	private Text teamText_5;	
	private Text teamText_6;
	private Text teamText_7;
	private Combo combo_7;
	
	
	public static void main(String[] args) {
		try {
			NBAQuerySystemUI window = new NBAQuerySystemUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public static void writeTable(final ArrayList<playerInfoVO> temp){
		Display.getDefault().asyncExec(new Runnable() { 
			public void run() { 
				for(int i=0;i<temp.size();i++){
					TableItem item=new TableItem(table,SWT.NONE);
					item.setText(new String[]{temp.get(i).getPlayerName(),temp.get(i).getNumber(),temp.get(i).getPosition()
							,temp.get(i).getHeight(),temp.get(i).getWeight(),temp.get(i).getBirth(),temp.get(i).getAge(),
							temp.get(i).getExp(),temp.get(i).getSchool()});
					
				}
		
			} 
		
		});
	}

	public static void writeTable2(final ArrayList<teamInfoVO> temp){
		Display.getDefault().asyncExec(new Runnable() { 
			public void run() { 
	
				for(int i=0;i<temp.size();i++){				
					TableItem item=new TableItem(table_2,SWT.NONE);
					item.setText(new String[]{temp.get(i).getFullName(),temp.get(i).getTeamName(),temp.get(i).getCity()
							,temp.get(i).getZone(),temp.get(i).getSubarea(),temp.get(i).getHomeCourt(),temp.get(i).getCreateTime()}); 
					System.out.println(item);
				}
		
			} 
		
		});
	}
	public static void writeTable3(final ArrayList<teamInfoVO> temp,final int n){
		Display.getDefault().asyncExec(new Runnable() { 
			public void run() { 
				table_3.removeAll();
				for(int i=0;i<temp.size();i++){
					TableItem item=new TableItem(table_3,SWT.NONE);
					if(n==0){
						item.setText(new String[]{String.valueOf(i+1),temp.get(i).getFullName(),String.valueOf(temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getFieldGoalsMade()),
							String.valueOf(temp.get(i).getFieldGoalsAttempted()),String.valueOf(temp.get(i).getThreePointFieldGoalsMade()),
							String.valueOf(temp.get(i).getThreePointFieldGoalsAttempted()),String.valueOf(temp.get(i).getFreeThrowsMade()),
							String.valueOf(temp.get(i).getFreeThrowsAttempted()),String.valueOf(temp.get(i).getOffensiveRebounds()),
							String.valueOf(temp.get(i).getDefensiveRebounds()),String.valueOf(temp.get(i).getRebounds()),String.valueOf(temp.get(i).getAssists()),
							String.valueOf(temp.get(i).getSteals()),String.valueOf(temp.get(i).getBlocks()),String.valueOf(temp.get(i).getTurnovers()),String.valueOf(temp.get(i).getFouls()),
							String.valueOf(temp.get(i).getPoints()),String.valueOf(temp.get(i).getFieldGoalPercentage()),String.valueOf(temp.get(i).getThreePointFieldGoalPercentage()),
							String.valueOf(temp.get(i).getFreeThrowPercentage()),String.valueOf(temp.get(i).getWinPercentage()),String.valueOf(temp.get(i).getPossessions()),
							String.valueOf(temp.get(i).getOffensiveRating()),String.valueOf(temp.get(i).getDefensiveRating()),String.valueOf(temp.get(i).getOffensiveReboundPercentage()),
							String.valueOf(temp.get(i).getDefensiveReboundPercentage()),String.valueOf(temp.get(i).getStealPercentage()),String.valueOf(temp.get(i).getAssistPercentage())});
					}else if(n==1){
						item.setText(new String[]{String.valueOf(i+1),temp.get(i).getFullName(),String.valueOf(temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getFieldGoalsMade()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getFieldGoalsAttempted()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getThreePointFieldGoalsMade()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getThreePointFieldGoalsAttempted()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getFreeThrowsMade()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getFreeThrowsAttempted()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getOffensiveRebounds()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getDefensiveRebounds()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getRebounds()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getAssists()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getSteals()/temp.get(i).getGamesPlayed()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getBlocks()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getTurnovers()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getFouls()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getPoints()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getFieldGoalPercentage()),String.valueOf(temp.get(i).getThreePointFieldGoalPercentage()),
								String.valueOf(temp.get(i).getFreeThrowPercentage()),String.valueOf(temp.get(i).getWinPercentage()),String.valueOf(temp.get(i).getPossessions()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getOffensiveRating()),String.valueOf(temp.get(i).getDefensiveRating()),String.valueOf(temp.get(i).getOffensiveReboundPercentage()),
								String.valueOf(temp.get(i).getDefensiveReboundPercentage()),String.valueOf(temp.get(i).getStealPercentage()),String.valueOf(temp.get(i).getAssistPercentage())});
						
					}
				}
			} 
		
		});
	}
	public static void writeTable4(final ArrayList<playerInfoVO> temp,final int n){
		Display.getDefault().asyncExec(new Runnable() { 
			public void run() { 
				for(int i=0;i<temp.size();i++){
					table_1.removeAll();
					TableItem item=new TableItem(table_1,SWT.NONE);
					if(n==0){
						item.setText(new String[]{String.valueOf(i+1),temp.get(i).getPlayerName(),temp.get(i).getTeamName(),String.valueOf(temp.get(i).getGamesPlayed())
								,String.valueOf(temp.get(i).getGamesStarting()),String.valueOf(temp.get(i).getRebounds()),String.valueOf(temp.get(i).getAssists()),
								String.valueOf(temp.get(i).getMinutes()),String.valueOf(temp.get(i).getFieldGoalsPercentage()),String.valueOf(temp.get(i).getThreePointFieldGoalsPercentage())
								,String.valueOf(temp.get(i).getFreeThrowsPercentage()),String.valueOf(temp.get(i).getOffensiveRebounds()),String.valueOf(temp.get(i).getDefensiveRebounds()),
								String.valueOf(temp.get(i).getSteals()),String.valueOf(temp.get(i).getBlocks()),String.valueOf(temp.get(i).getTurnovers()),String.valueOf(temp.get(i).getFouls()),
								String.valueOf(temp.get(i).getPoints()),String.valueOf(temp.get(i).getEfficiency()),String.valueOf(temp.get(i).getGmSc()),String.valueOf(temp.get(i).getTrueShootingPercentage())
								,String.valueOf(temp.get(i).getShootingEfficiency()),String.valueOf(temp.get(i).getReboundRating()),String.valueOf(temp.get(i).getOffensiveReboundRating())
								,String.valueOf(temp.get(i).getDefensiveReboundRating()),String.valueOf(temp.get(i).getAssisyRating()),String.valueOf(temp.get(i).getStealRating()),String.valueOf(temp.get(i).getBlockRating())
								,String.valueOf(temp.get(i).getTurnoverRating()),String.valueOf(temp.get(i).getUtilizationRating())});
					}else if(n==1){
						item.setText(new String[]{String.valueOf(i+1),temp.get(i).getPlayerName(),temp.get(i).getTeamName(),String.valueOf(temp.get(i).getGamesPlayed())
								,String.valueOf(temp.get(i).getGamesStarting()),String.valueOf(temp.get(i).getRebounds()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getAssists()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getMinutes()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getFieldGoalsPercentage()),String.valueOf(temp.get(i).getThreePointFieldGoalsPercentage())
								,String.valueOf(temp.get(i).getFreeThrowsPercentage()),String.valueOf(temp.get(i).getOffensiveRebounds()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getDefensiveRebounds()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getSteals()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getBlocks()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getTurnovers()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getFouls()/temp.get(i).getGamesPlayed()),
								String.valueOf(temp.get(i).getPoints()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getEfficiency()),String.valueOf(temp.get(i).getGmSc()),String.valueOf(temp.get(i).getTrueShootingPercentage())
								,String.valueOf(temp.get(i).getShootingEfficiency()),String.valueOf(temp.get(i).getReboundRating()),String.valueOf(temp.get(i).getOffensiveReboundRating())
								,String.valueOf(temp.get(i).getDefensiveReboundRating()),String.valueOf(temp.get(i).getAssisyRating()),String.valueOf(temp.get(i).getStealRating()),String.valueOf(temp.get(i).getBlockRating())
								,String.valueOf(temp.get(i).getTurnoverRating()),String.valueOf(temp.get(i).getUtilizationRating())});
					}
				}
			} 
		
		});
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		
		shell = new Shell(SWT.NO_TRIM );//�ޱ߿�
		
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				shell.dispose();
			}
			@Override
			public void shellDeiconified(ShellEvent e) {
			}
			@Override
			public void shellIconified(ShellEvent e) {
			}
		});
		
		/*����϶�*/
		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				isDraw = true;   
				xx = e.x;   
				yy = e.y;
			}
			@Override
			public void mouseUp(MouseEvent e) {
				isDraw = false;
			}
		});
		shell.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if (isDraw) {  shell.setLocation(shell.getLocation().x + arg0.x - xx,shell.getLocation().y + arg0.y - yy);    }
			}
		});
		
		shell.setSize(1440,900);
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent()  
                .getClientArea().height / 2 - shell.getSize().y/2); //shell����
		shell.setText("NBA��Ϣ��ѯϵͳ");
		shell.setBackgroundImage(SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/image1.jpg"));//shell����
		shell.setImage(SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/symbol.jpg"));//shellͼ��
		shell.setBackgroundMode(SWT.INHERIT_FORCE); 
		
		
		
		composite_1 = new Composite(shell, SWT.NONE);//������
		composite_1.setBounds(0, 0, 1440, 900);
		composite_1.setBackgroundMode(SWT.INHERIT_NONE); 
		//ImageButton b1=new ImageButton(composite,null,null,null);
		
		composite_2 = new Composite(shell, SWT.NONE);//��Ա��Ϣ
		composite_2.setLocation(0, 0);
		composite_2.setSize(1440, 900);
		composite_2.setVisible(false);
		composite_2.setBackgroundMode(SWT.INHERIT_NONE); 
		
		composite_3 = new Composite(shell, SWT.NONE);//�����Ϣ
		composite_3.setBounds(0, 0, 1440, 900);
		composite_3.setVisible(false);
		composite_3.setBackgroundMode(SWT.INHERIT_NONE); 
		
		composite_4 = new Composite(shell, SWT.NONE);//��Ա����
		composite_4.setBounds(0, 0, 1440, 900);
		composite_4.setVisible(false);
		composite_4.setBackgroundMode(SWT.INHERIT_NONE); 
		
		composite_5 = new Composite(shell, SWT.NONE);//�������
		composite_5.setBounds(0, 0, 1440, 900);
		composite_5.setVisible(false);
		composite_5.setBackgroundMode(SWT.INHERIT_NONE); 
		
		Button button = new Button(composite_3, SWT.NONE);//���ؼ��ֲ��������Ϣ
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				teamInfoVO t1=new teamInfoVO();
				t1.setFullName(text_1.getText());
				ServiceImp si=new ServiceImp();
				teamInfoVO t2=si.getSingleTeamInfo(t1);
				TableItem item=new TableItem(table_2,SWT.NONE);
				item.setText(new String[]{t2.getFullName(),t2.getTeamName(),t2.getCity()
						,t2.getZone(),t2.getSubarea(),t2.getHomeCourt(),t2.getCreateTime()}); 
				
			}
		});
		button.setLocation(1050, 170);
		button.setSize(98, 30);
		button.setText("\u67E5\u627E");
		
		Button backButton_2 = new Button(composite_3, SWT.NONE);//�����Ϣ���淵�ذ�ť
		backButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_3.setVisible(false);
				composite_1.setVisible(true);	
				
				}
		});
		backButton_2.setLocation(1320, 20);
		backButton_2.setSize(98, 30);
		backButton_2.setText("\u8FD4\u56DE");
		
		text_1 = new Text(composite_3, SWT.BORDER | SWT.SEARCH);
		text_1.setLocation(850, 170);
		text_1.setSize(132, 26);
		text_1.setToolTipText("");
		text_1.setText("\u8F93\u5165\u5173\u952E\u5B57\u67E5\u627E");
		
		final Combo combo_3 = new Combo(composite_3, SWT.NONE);//������ɸѡ���
		final Combo combo_4 = new Combo(composite_3, SWT.NONE);//������ɸѡ���
		
		combo_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_3.getText().equals("��������")){
					combo_4.removeAll();
					combo_4.add("��ѡ�����");
					combo_4.setData("0", "��ѡ�����");
					combo_4.add("���Ϸ���");
					combo_4.setData("1", "���Ϸ���");
					combo_4.add("�������");
					combo_4.setData("2", "�������");
					combo_4.add("���������");
					combo_4.setData("3", "���������");
					
					table_2.removeAll();
					ServiceImp si=new ServiceImp();
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.East);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					System.out.println(t.size());
					writeTable2(t);
					
					
				}else if(combo_3.getText().equals("��������")){
					combo_4.removeAll();
					combo_4.add("��ѡ�����");
					combo_4.setData("0", "��ѡ�����");
					combo_4.add("̫ƽ�����");
					combo_4.setData("1", "̫ƽ�����");
					combo_4.add("��������");
					combo_4.setData("2", "��������");
					combo_4.add("���Ϸ���");
					combo_4.setData("3", "���Ϸ���");
					
					table_2.removeAll();
					ServiceImp si=new ServiceImp();
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.West);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable2(t);
				}
				
			}
		});
		combo_3.setLocation(250, 170);
		combo_3.setSize(109, 28);
		
		combo_3.setText("\u8D5B\u533A");
		combo_3.add("ȫ��");
		combo_3.setData("0", "ȫ��");
		combo_3.add("��������");
		combo_3.setData("1", "��������");
		combo_3.add("��������");
		combo_3.setData("2", "��������");
		
	
		combo_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//ˢ���б�
				teamCondition tc=new teamCondition();
				if(combo_4.getText().equals("���Ϸ���")||combo_4.getText().equals("�������")||combo_4.getText().equals("���������")){
					combo_3.setText("��������");
					if(combo_4.getText().equals("���Ϸ���")){
						tc.setTeampartion(teamPartion.Southeast);
					}else if(combo_4.getText().equals("�������")){
						tc.setTeampartion(teamPartion.Central);
					}else if(combo_4.getText().equals("���������")){
						tc.setTeampartion(teamPartion.Atlantic);
					}
					table_2.removeAll();
					ServiceImp si=new ServiceImp();
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable2(t);
				}else if(combo_4.getText().equals("̫ƽ�����")||combo_4.getText().equals("��������")||combo_4.getText().equals("���Ϸ���")){
					combo_3.setText("��������");
					if(combo_4.getText().equals("̫ƽ�����")){
						tc.setTeampartion(teamPartion.Pacific);
					}else if(combo_4.getText().equals("��������")){
						tc.setTeampartion(teamPartion.Northwest);
					}else if(combo_4.getText().equals("���Ϸ���")){
						tc.setTeampartion(teamPartion.Northwest);
					}
					table_2.removeAll();
					ServiceImp si=new ServiceImp();
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable2(t);
				}
			}
		});
		combo_4.setLocation(450, 170);
		combo_4.setSize(92, 28);
		combo_4.setText("\u5206\u533A");
		combo_4.add("��ѡ�����");
		combo_4.setData("0", "��ѡ�����");
		combo_4.add("���Ϸ���");
		combo_4.setData("1", "���Ϸ���");
		combo_4.add("�������");
		combo_4.setData("2", "�������");
		combo_4.add("���������");
		combo_4.setData("3", "���������");
		combo_4.add("̫ƽ�����");
		combo_4.setData("4", "̫ƽ�����");
		combo_4.add("��������");
		combo_4.setData("5", "��������");
		combo_4.add("���Ϸ���");
		combo_4.setData("6", "���Ϸ���");
		
		table_2 = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);//��ӻ�����Ϣ�б�
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_NONE);
				composite_3.setVisible(false);
				composite_8.setVisible(true);
				TableItem[] itemList =table_2.getItems();
				int listHaveChouse = table_2.getSelectionIndex();		
				String firstInfo = itemList[listHaveChouse].getText(0);
				String secondInfo = itemList[listHaveChouse].getText(1);
				System.out.println(firstInfo);
				System.out.println(secondInfo);
				teamInfoVO t=new teamInfoVO();
				t.setFullName(firstInfo);
				ServiceImp si=new ServiceImp();
				teamInfoVO t2=si.getSingleTeamInfo(t);
				teamText_1.setText("���ȫ�ƣ�"+t2.getFullName());
				teamText_2.setText("��д��"+t2.getTeamName());
				teamText_3.setText("���ڵأ�"+t2.getCity());
				teamText_4.setText("������"+t2.getZone());
				teamText_5.setText("������"+t2.getSubarea());
				teamText_6.setText("������"+t2.getHomeCourt());
				teamText_7.setText("����ʱ�䣺"+t2.getCreateTime());
				Image image=SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/teams/"+secondInfo+".jpg");
				final Rectangle bounds=image.getBounds();
				composite_9.setBounds(100, 200, bounds.width, bounds.height);					
				composite_9.setBackgroundImage(image);
				
			}
		});
		table_2.setLocation(240, 270);
		table_2.setSize(943, 507);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		TableColumn teamTableColumn_1 = new TableColumn(table_2, SWT.NONE);
		teamTableColumn_1.setWidth(142);
		teamTableColumn_1.setText("\u7403\u961F\u5168\u79F0");
		
		TableColumn teamTableColumn_2 = new TableColumn(table_2, SWT.NONE);
		teamTableColumn_2.setWidth(140);
		teamTableColumn_2.setText("\u7F29\u5199");
		
		TableColumn teamTableColumn_3 = new TableColumn(table_2, SWT.NONE);
		teamTableColumn_3.setWidth(138);
		teamTableColumn_3.setText("\u6240\u5728\u5730");
		
		TableColumn teamTableColumn_4 = new TableColumn(table_2, SWT.NONE);
		teamTableColumn_4.setWidth(128);
		teamTableColumn_4.setText("\u8D5B\u533A");
		
		TableColumn teamTableColumn_5 = new TableColumn(table_2, SWT.NONE);
		teamTableColumn_5.setWidth(146);
		teamTableColumn_5.setText("\u5206\u533A");
		
		TableColumn teamTableColumn_6 = new TableColumn(table_2, SWT.NONE);
		teamTableColumn_6.setWidth(127);
		teamTableColumn_6.setText("\u4E3B\u573A");
		
		TableColumn teamTableColumn_7 = new TableColumn(table_2, SWT.NONE);
		teamTableColumn_7.setWidth(118);
		teamTableColumn_7.setText("\u5EFA\u7ACB\u65F6\u95F4");
		
		table = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_NONE);
				composite_2.setVisible(false);
				composite_6.setVisible(true);
				TableItem[] itemList =table.getItems();
				int listHaveChouse = table.getSelectionIndex();		
				final String firstInfo = itemList[listHaveChouse].getText(0);
				playerInfoVO p=new playerInfoVO();
				p.setPlayerName(firstInfo);
				ServiceImp si=new ServiceImp();
				playerInfoVO p2=si.getSinglePlayerInfo(p);
				text_2.setText("������"+p2.getPlayerName());
				text_3.setText("������ӣ�"+p2.getTeamName());
				text_4.setText("���º��룺"+p2.getNumber());
				text_5.setText("λ�ã�"+p2.getPosition());
				text_6.setText("��ߣ�"+p2.getHeight());
				text_7.setText("���أ�"+p2.getWeight());				
				text_8.setText("���գ�"+p2.getBirth());
				text_9.setText("���䣺"+p2.getAge());
				text_10.setText("���䣺"+p2.getExp());
				text_11.setText("��ҵѧУ��"+p2.getSchool());
				
				Image image=SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/players/action/"+firstInfo+".png");
				final Rectangle bounds=image.getBounds();
				composite_7.setBounds(100, 100, bounds.width, bounds.height);					
				composite_7.setBackgroundImage(image);

				
			}
		});
		table.setBounds(232, 270, 906, 500);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

	
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u59D3\u540D");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u7403\u8863\u53F7\u7801");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u4F4D\u7F6E");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("\u8EAB\u9AD8");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("\u4F53\u91CD");
		
		TableColumn tableColumn_6 = new TableColumn(table, SWT.NONE);
		tableColumn_6.setWidth(100);
		tableColumn_6.setText("\u751F\u65E5");
		
		TableColumn tableColumn_7 = new TableColumn(table, SWT.NONE);
		tableColumn_7.setWidth(100);
		tableColumn_7.setText("\u5E74\u9F84");
		
		TableColumn tableColumn_8 = new TableColumn(table, SWT.NONE);
		tableColumn_8.setWidth(100);
		tableColumn_8.setText("\u7403\u9F84");
		
		TableColumn tableColumn_9 = new TableColumn(table, SWT.NONE);
		tableColumn_9.setWidth(100);
		tableColumn_9.setText("\u6BD5\u4E1A\u5B66\u6821");
		
		/*Combo combo_1 = new Combo(composite_2, SWT.NONE);//���������ɸѡ
	
		combo_1.setBounds(248, 191, 140, 28);
		combo_1.setText("\u6309\u6240\u5C5E\u7403\u961F\u67E5\u627E");
		
		combo_1.add("Hawks");
		combo_1.setData("0", "Hawks");
		combo_1.add("Nets");
		combo_1.setData("1", "Nets");
		combo_1.add("Celtics");
		combo_1.setData("2", "Celtics");
		combo_1.add("Hornets");
		combo_1.setData("3", "Hornets");
		combo_1.add("Bulls");
		combo_1.setData("4", "Bulls");
		combo_1.add("Cavaliers");
		combo_1.setData("5", "Cavaliers");
		combo_1.add("Mavericks");
		combo_1.setData("6", "Mavericks");	
		combo_1.add("Nuggets");
		combo_1.setData("7", "Nuggets");
		combo_1.add("Pistons");
		combo_1.setData("8", "Pistons");
		combo_1.add("Warriors");
		combo_1.setData("9", "Warriors");
		combo_1.add("Rockets");
		combo_1.setData("10", "Rockets");
		combo_1.add("Pacers");
		combo_1.setData("11", "Pacers");		
		combo_1.add("Clippers");
		combo_1.setData("12", "Clippers");
		combo_1.add("Lakers");
		combo_1.setData("13", "Lakers");	
		combo_1.add("Grizzlies");
		combo_1.setData("14", "Grizzlies");
		combo_1.add("Heat");
		combo_1.setData("15", "Heat");
		combo_1.add("Bucks");
		combo_1.setData("16", "Bucks");
		combo_1.add("Timberwolves");
		combo_1.setData("17", "Timberwolves");
		combo_1.add("Pelicans");
		combo_1.setData("18", "Pelicans");
		combo_1.add("Knicks");
		combo_1.setData("19", "Knicks");
		combo_1.add("Thunder");
		combo_1.setData("20", "Thunder");
		combo_1.add("Magic");
		combo_1.setData("21", "Magic");
		combo_1.add("76ers");
		combo_1.setData("22", "76ers");
		combo_1.add("Suns");
		combo_1.setData("23", "Suns");
		combo_1.add("Trail Blazers");
		combo_1.setData("24", "Trail Blazers");	
		combo_1.add("Kings");
		combo_1.setData("25", "Kings");
		combo_1.add("Spurs");
		combo_1.setData("26", "Spurs");
		combo_1.add("Raptors");
		combo_1.setData("27", "Raptors");
		combo_1.add("Jazz");
		combo_1.setData("28", "Jazz");	
		combo_1.add("Wizards");
		combo_1.setData("29", "Wizards");
				*/
		final Combo combo_2 = new Combo(composite_2, SWT.NONE);//��λ��ɸѡ
		combo_2.add("ȫ��");
		combo_2.setData("0", "ȫ��");
		combo_2.add("ǰ��");
		combo_2.setData("1", "ǰ��");
		combo_2.add("�з�");
		combo_2.setData("2", "�з�");
		combo_2.add("����");
		combo_2.setData("3", "����");
		combo_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				table.removeAll();
				playerCondition pc=new playerCondition();
				if(combo_2.getText().equals("ǰ��")){
					pc.setPlayerPosition(playerPosition.Forward);
				}else if(combo_2.getText().equals("�з�")){
					pc.setPlayerPosition(playerPosition.Center);
				}else if(combo_2.getText().equals("����")){
					pc.setPlayerPosition(playerPosition.Guard);
				}else
					pc.setPlayerPosition(playerPosition.All);
				pc.setPlayerPartition(playerPartition.All);			
				pc.setSortOpinions(sortOpinions.Null);			
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> p=si.getPlayerInfo(pc);
				writeTable(p);
			}
		});
		combo_2.setBounds(458, 191, 140, 28);
		combo_2.setText("\u6309\u4F4D\u7F6E\u67E5\u627E");
		
		
		Button checkbutton_1 = new Button(composite_2, SWT.NONE);//���ؼ��ֲ�����Ա
		checkbutton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//ֻʵ��������ȫ������
				playerInfoVO p=new playerInfoVO();
				p.setPlayerName(text.getText());
				ServiceImp si=new ServiceImp();
				playerInfoVO player=si.getSinglePlayerInfo(p);
				table.removeAll();
				TableItem item=new TableItem(table,SWT.NONE);
				item.setText(new String[]{player.getPlayerName(),player.getNumber(),player.getPosition()
						,player.getHeight(),player.getWeight(),player.getBirth(),player.getAge(),
						player.getExp(),player.getSchool()});
			}
		});
		checkbutton_1.setBounds(952, 189, 98, 30);
		checkbutton_1.setText("\u67E5\u627E");
		
		Button backButton_1 = new Button(composite_2, SWT.NONE);//����������
		backButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_2.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		backButton_1.setBounds(1262, 21, 98, 30);
		backButton_1.setText("\u8FD4\u56DE");
		
		text = new Text(composite_2, SWT.BORDER | SWT.SEARCH);
		text.setToolTipText("");
		text.setText("\u8F93\u5165\u5173\u952E\u5B57\u67E5\u627E");
		text.setBounds(764, 189, 132, 26);
		
		Button button_1 = new Button(composite_1, SWT.NONE);//��Ա��Ϣ
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_1.setVisible(false);
				composite_2.setVisible(true);
				playerCondition pc=new playerCondition();
				pc.setPlayerPartition(playerPartition.All);
				pc.setPlayerPosition(playerPosition.All);
				pc.setSortOpinions(sortOpinions.Null);			
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc);
				writeTable(player);
			}
		});
		button_1.setText("\u7403\u5458\u4FE1\u606F");
		button_1.setBounds(933, 175, 123, 56);
		button_1.setImage(null);
		
		
		
		Button button_2 = new Button(composite_1, SWT.NONE);//�����Ϣ
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_1.setVisible(false);
				composite_3.setVisible(true);
				table_2.removeAll();
				ServiceImp si=new ServiceImp();
				
				teamCondition tc=new teamCondition();
				tc.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
				writeTable2(t);
			}
		});
		button_2.setBounds(933, 275, 123, 56);
		button_2.setText("\u7403\u961F\u4FE1\u606F");
		
		Button button_3 = new Button(composite_1, SWT.NONE);//��Ա����
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_4.setVisible(true);
				composite_1.setVisible(false);
				playerCondition pc=new playerCondition();
				pc.setPlayerPartition(playerPartition.All);
				pc.setPlayerPosition(playerPosition.All);
				pc.setSortOpinions(sortOpinions.Null);			

				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc);
				writeTable4(player,0);
			}
			
		});
		button_3.setBounds(933, 379, 123, 56);
		button_3.setText("\u7403\u5458\u6570\u636E");
		
		Button button_4 = new Button(composite_1, SWT.NONE);//�������
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_5.setVisible(true);
				composite_1.setVisible(false);
				table_3.clearAll();
				ServiceImp si=new ServiceImp();	
				teamCondition tc=new teamCondition();
				tc.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
				writeTable3(t,0);
				
			
			}
		});
		button_4.setSelection(true);
		button_4.setBounds(933, 481, 123, 56);
		button_4.setText("\u7403\u961F\u6570\u636E");
		
		
		Button button_5 = new Button(composite_1, SWT.NONE);//�˳�
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close ();
			}
		});
		button_5.setBounds(933, 599, 123, 56);
		button_5.setText("\u9000\u51FA");
		final playerCondition pc2=new playerCondition();
		pc2.setPlayerPosition(playerPosition.All);
		pc2.setPlayerPartition(playerPartition.All);
		pc2.setSortOpinions(sortOpinions.Null);
		final Combo combo = new Combo(composite_4, SWT.NONE);//λ��
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	
				if(combo.getText().equals("ǰ��")){
					pc2.setPlayerPosition(playerPosition.Forward);				
				}else if(combo.getText().equals("�з�")){
					pc2.setPlayerPosition(playerPosition.Center);				
				}else if(combo.getText().equals("����")){
					pc2.setPlayerPosition(playerPosition.Guard);				
				}else{
					pc2.setPlayerPosition(playerPosition.All);
				}
				table_1.removeAll();
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					writeTable4(player,1);
				}else{
					writeTable4(player,0);
				}
			}
		});
		combo.setBounds(120, 170, 92, 28);
		combo.setText("\u4F4D\u7F6E");
		combo.add("��ѡ��λ��");
		combo.setData("0", "��ѡ��λ��");
		combo.add("ǰ��");
		combo.setData("1", "ǰ��");
		combo.add("�з�");
		combo.setData("2", "�з�");
		combo.add("����");
		combo.setData("3", "����");
		
		final Combo combo_5 = new Combo(composite_4, SWT.NONE);//ѡ����Ա����
		combo_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_5.getText().equals("���Ϸ���������������")){
					pc2.setPlayerPartition(playerPartition.Southeast);
				}else if(combo_5.getText().equals("�������������������")){
					pc2.setPlayerPartition(playerPartition.Central);
				}else if(combo_5.getText().equals("���������������������")){
					pc2.setPlayerPartition(playerPartition.Atlantic);
				}else if(combo_5.getText().equals("̫ƽ�����������������")){
					pc2.setPlayerPartition(playerPartition.Pacific);
				}else if(combo_5.getText().equals("��������������������")){
					pc2.setPlayerPartition(playerPartition.Northwest);
				}else if(combo_5.getText().equals("���Ϸ���������������")){
					pc2.setPlayerPartition(playerPartition.Northwest);
				}else if(combo_5.getText().equals("��������")){
					pc2.setPlayerPartition(playerPartition.East);
				}else if(combo_5.getText().equals("��������")){
					pc2.setPlayerPartition(playerPartition.West);
				}else{
					pc2.setPlayerPartition(playerPartition.All);
				}
				table_1.removeAll();
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					writeTable4(player,1);
				}else{
					writeTable4(player,0);
				}
			}
		});
		combo_5.setBounds(320, 170, 92, 28);
		combo_5.setText("\u7403\u5458\u8054\u76DF");
		combo_5.add("��ѡ�����");
		combo_5.setData("0", "��ѡ�����");
		combo_5.add("��������");
		combo_5.setData("1", "��������");
		combo_5.add("��������");
		combo_5.setData("2", "��������");
		combo_5.add("���Ϸ���������������");
		combo_5.setData("3", "���Ϸ���������������");
		combo_5.add("�������������������");
		combo_5.setData("4", "�������������������");
		combo_5.add("���������������������");
		combo_5.setData("5", "���������������������");
		combo_5.add("̫ƽ�����������������");
		combo_5.setData("6", "̫ƽ�����������������");
		combo_5.add("��������������������");
		combo_5.setData("7", "��������������������");
		combo_5.add("���Ϸ���������������");
		combo_5.setData("8", "���Ϸ���������������");
		
		final Combo combo_6 = new Combo(composite_4, SWT.NONE);//ѡ����������
		combo_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_6.getText().equals("�÷�")){
					pc2.setSortOpinions(sortOpinions.Points);
				}else if(combo_6.getText().equals("����")){
					pc2.setSortOpinions(sortOpinions.Rebounds);
				}else if(combo_6.getText().equals("����")){
					pc2.setSortOpinions(sortOpinions.Assists );
				}else if(combo_6.getText().equals("�÷�/����/����")){
					pc2.setSortOpinions(sortOpinions.PointsReboundsAssists);
				}else if(combo_6.getText().equals("��ñ")){
					pc2.setSortOpinions(sortOpinions.Blocks);
				}else if(combo_6.getText().equals("����")){
					pc2.setSortOpinions(sortOpinions.Steals);
				}else if(combo_6.getText().equals("����")){
					pc2.setSortOpinions(sortOpinions.Fouls);
				}else if(combo_6.getText().equals("ʧ��")){
					pc2.setSortOpinions(sortOpinions.Turnovers);
				}else if(combo_6.getText().equals("����")){
					pc2.setSortOpinions(sortOpinions.Minutes);
				}else if(combo_6.getText().equals("Ч��")){
					pc2.setSortOpinions(sortOpinions.Efficiency);
				}else if(combo_6.getText().equals("Ͷ��")){
					pc2.setSortOpinions(sortOpinions.FieldGoalsMade);
				}else if(combo_6.getText().equals("����")){
					pc2.setSortOpinions(sortOpinions.ThreePointFieldGoalsMade);
				}else if(combo_6.getText().equals("����")){
					pc2.setSortOpinions(sortOpinions.FreeThrowsMade);
				}else if(combo_6.getText().equals("��˫")){
					pc2.setSortOpinions(sortOpinions.DoubleDouble);
				}else{
					pc2.setSortOpinions(sortOpinions.Null);
				}
				table_1.removeAll();
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					writeTable4(player,1);
				}else{
					writeTable4(player,0);
				}
				
			}
		});
		combo_6.setEnabled(true);
		combo_6.setBounds(520, 170, 92, 28);
		combo_6.setText("\u6392\u5E8F\u4F9D\u636E");
		combo_6.add("��ѡ����������");
		combo_6.setData("0", "��ѡ����������");
		combo_6.add("�÷�");
		combo_6.setData("0", "�÷�");
		combo_6.add("����");
		combo_6.setData("1", "����");
		combo_6.add("����");
		combo_6.setData("2", "����");
		combo_6.add("�÷�/����/����");
		combo_6.setData("3", "�÷�/����/����");
		combo_6.add("��ñ");
		combo_6.setData("4", "��ñ");
		combo_6.add("����");
		combo_6.setData("5", "����");
		combo_6.add("����");
		combo_6.setData("6", "����");		
		combo_6.add("ʧ��");
		combo_6.setData("7", "ʧ��");
		combo_6.add("����");
		combo_6.setData("8", "����");
		combo_6.add("Ч��");
		combo_6.setData("9", "Ч��");
		combo_6.add("Ͷ��");
		combo_6.setData("10", "Ͷ��");
		combo_6.add("����");
		combo_6.setData("11", "����");
		combo_6.add("����");
		combo_6.setData("12", "����");
		combo_6.add("��˫");
		combo_6.setData("13", "��˫");
		
		combo_7 = new Combo(composite_4, SWT.NONE);//ѡ�񳡾�����/������
		combo_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(combo_7.getText().equals("������")){
					table_1.removeAll();	
					ServiceImp si=new ServiceImp();
					ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
					writeTable4(player,0);
				}else if(combo_7.getText().equals("��������")){
					table_1.removeAll();		
					ServiceImp si=new ServiceImp();
					ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
					writeTable4(player,1);
				}
			}
		});
		combo_7.setBounds(720, 170, 92, 28);
		combo_7.setText("\u603B\u6570\u636E/\u573A\u5747\u6570\u636E");
		combo_7.add("������");
		combo_7.setData("0", "������");
		combo_7.add("��������");
		combo_7.setData("1", "��������");
		
		table_1 = new Table(composite_4, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_NONE);
				composite_4.setVisible(false);
				composite_6.setVisible(true);
				TableItem[] itemList =table_1.getItems();
				int listHaveChouse = table_1.getSelectionIndex();		
				String firstInfo = itemList[listHaveChouse].getText(1);
				playerInfoVO p=new playerInfoVO();
				p.setPlayerName(firstInfo);
				ServiceImp si=new ServiceImp();
				playerInfoVO p2=si.getSinglePlayerInfo(p);
				text_2.setText("������"+p2.getPlayerName());
				text_3.setText("������ӣ�"+p2.getTeamName());
				text_4.setText("���º��룺"+p2.getNumber());
				text_5.setText("λ�ã�"+p2.getPosition());
				text_6.setText("��ߣ�"+p2.getHeight());
				text_7.setText("���أ�"+p2.getWeight());				
				text_8.setText("���գ�"+p2.getBirth());
				text_9.setText("���䣺"+p2.getAge());
				text_10.setText("���䣺"+p2.getExp());
				text_11.setText("��ҵѧУ��"+p2.getSchool());
				composite_7.setBackgroundImage(SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/players/action"+firstInfo+".png"));
				
			}
		});
		table_1.setBounds(100, 300, 1240, 550);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		final int item[] =new int[30] ;
		for(int i=0;i<30;i++){
			item[i]=0;
		}
		
		TableColumn tableColumn = new TableColumn(table_1, SWT.NONE);//����
		tableColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		tableColumn.setWidth(43);
		tableColumn.setText("\u6392\u540D");
		
		TableColumn tableColumn_10 = new TableColumn(table_1, SWT.NONE);//��Ա����
		tableColumn_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		tableColumn_10.setWidth(80);
		tableColumn_10.setText("\u7403\u5458");
		
		TableColumn tableColumn_11 = new TableColumn(table_1, SWT.NONE);//�������
		tableColumn_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		tableColumn_11.setWidth(70);
		tableColumn_11.setText("\u7403\u961F");
		
		TableColumn tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);//��������
		tblclmnNewColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		tblclmnNewColumn.setWidth(66);
		tblclmnNewColumn.setText("\u53C2\u8D5B\u6B21\u6570");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table_1, SWT.NONE);//�ȷ�����
		tblclmnNewColumn_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		tblclmnNewColumn_1.setWidth(73);
		tblclmnNewColumn_1.setText("\u5148\u53D1\u573A\u6570");
		
		TableColumn tableColumn_12 = new TableColumn(table_1, SWT.NONE);//������
		tableColumn_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[5]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
			
				table_1.removeAll();	
				if(item[5]%3==0){			
					writeTable4(player,0);
					
				}else if(item[5]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"rebounds");
					writeTable4(player2,0);
	
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"rebounds");
					Collections.reverse(player2);
					writeTable4(player2,0);
					
					
				}
			}
			
		});
		tableColumn_12.setWidth(67);
		tableColumn_12.setText("\u7BEE\u677F\u6570");
		
		TableColumn tableColumn_13 = new TableColumn(table_1, SWT.NONE);//������
		tableColumn_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[6]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[6]%3==0){
					
					writeTable4(player,0);
					
				}else if(item[6]%3==1){
					
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"assists");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"assists");
					Collections.reverse(player2);
					writeTable4(player2,0);
					
					
				}
			}
		});
		tableColumn_13.setWidth(61);
		tableColumn_13.setText("\u52A9\u653B\u6570");
		
		TableColumn tableColumn_14 = new TableColumn(table_1, SWT.NONE);//�ڳ�ʱ��
		tableColumn_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[7]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[7]%3==0){
					writeTable4(player,0);
					
				}else if(item[7]%3==1){
					
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"minutes");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"minutes");
					Collections.reverse(player2);
					writeTable4(player2,0);
					
					
				}
				
			}
		});
		tableColumn_14.setWidth(76);
		tableColumn_14.setText("\u5728\u573A\u65F6\u95F4");
		
		TableColumn tableColumn_15 = new TableColumn(table_1, SWT.NONE);//Ͷ��������
		tableColumn_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[8]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"fieldGoalsPercentage");
				table_1.removeAll();	
				if(item[8]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[8]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_15.setWidth(88);
		tableColumn_15.setText("\u6295\u7BEE\u547D\u4E2D\u7387");
		
		TableColumn tableColumn_16 = new TableColumn(table_1, SWT.NONE);
		tableColumn_16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[9]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"threePointFieldGoalsPercentage");
				table_1.removeAll();	
				if(item[9]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[9]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_16.setWidth(96);
		tableColumn_16.setText("\u4E09\u5206\u547D\u4E2D\u7387");
		
		TableColumn tableColumn_17 = new TableColumn(table_1, SWT.NONE);
		tableColumn_17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[10]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"freeThrowsPercentage");
				table_1.removeAll();	
				if(item[10]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[10]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_17.setWidth(92);
		tableColumn_17.setText("\u7F5A\u7403\u547D\u4E2D\u7387");
		
		TableColumn tableColumn_18 = new TableColumn(table_1, SWT.NONE);
		tableColumn_18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[11]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[11]%3==0){
					
					
					writeTable4(player,0);
					
				}else if(item[11]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"offensiveRebounds");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"offensiveRebounds");
					Collections.reverse(player2);
					writeTable4(player2,0);
					
					
				}
			}
		});
		tableColumn_18.setWidth(66);
		tableColumn_18.setText("\u8FDB\u653B\u6570");
		
		TableColumn tableColumn_19 = new TableColumn(table_1, SWT.NONE);//����������
		tableColumn_19.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[12]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[12]%3==0){
					
					writeTable4(player,0);
					
				}else if(item[12]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"defensiveRebounds");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"defensiveRebounds");
					Collections.reverse(player2);
					writeTable4(player2,0);
					
					
				}
			}
		});
		tableColumn_19.setWidth(61);
		tableColumn_19.setText("\u9632\u5B88\u6570");
		
		TableColumn tableColumn_20 = new TableColumn(table_1, SWT.NONE);
		tableColumn_20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[13]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[13]%3==0){
					
					writeTable4(player,0);
					
				}else if(item[13]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"steals");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"steals");
					Collections.reverse(player2);
					writeTable4(player2,0);
					
				}
			}
		});
		tableColumn_20.setWidth(64);
		tableColumn_20.setText("\u62A2\u65AD\u6570");
		
		TableColumn tableColumn_21 = new TableColumn(table_1, SWT.NONE);
		tableColumn_21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[14]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[14]%3==0){
					
					writeTable4(player,0);
					
				}else if(item[14]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"blocks");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"blocks");
					Collections.reverse(player2);
					writeTable4(player2,0);
					
					
				}
			}
		});
		tableColumn_21.setWidth(62);
		tableColumn_21.setText("\u76D6\u5E3D\u6570");
		
		TableColumn tableColumn_22 = new TableColumn(table_1, SWT.NONE);//ʧ����
		tableColumn_22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[15]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[15]%3==0){
					
					writeTable4(player,0);
					
				}else if(item[15]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"turnovers");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"turnovers");
					Collections.reverse(player2);
					writeTable4(player2,0);
				
					
				}
			}
		});
		tableColumn_22.setWidth(63);
		tableColumn_22.setText("\u5931\u8BEF\u6570");
		
		TableColumn tableColumn_23 = new TableColumn(table_1, SWT.NONE);//������
		tableColumn_23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[16]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[16]%3==0){
					
					writeTable4(player,0);
					
				}else if(item[16]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"fouls");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"fouls");
					Collections.reverse(player2);
					writeTable4(player2,0);
						
					
				}
			}
		});
		tableColumn_23.setWidth(57);
		tableColumn_23.setText("\u72AF\u89C4\u6570");
		
		TableColumn tableColumn_24 = new TableColumn(table_1, SWT.NONE);//�÷�
		tableColumn_24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[17]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(combo_7.getText().equals("��������")){
					for(int i=0;i<player.size();i++){
						player.get(i).setRebounds(player.get(i).getRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setAssists(player.get(i).getAssists()/player.get(i).getGamesPlayed());
						player.get(i).setMinutes(player.get(i).getMinutes()/player.get(i).getGamesPlayed());
						player.get(i).setOffensiveRebounds(player.get(i).getOffensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setDefensiveRebounds(player.get(i).getDefensiveRebounds()/player.get(i).getGamesPlayed());
						player.get(i).setSteals(player.get(i).getSteals()/player.get(i).getGamesPlayed());
						player.get(i).setBlocks(player.get(i).getBlocks()/player.get(i).getGamesPlayed());
						player.get(i).setTurnovers(player.get(i).getTurnovers()/player.get(i).getGamesPlayed());
						player.get(i).setFouls(player.get(i).getFouls()/player.get(i).getGamesPlayed());
						player.get(i).setPoints(player.get(i).getPoints()/player.get(i).getGamesPlayed());
					}
				}
				
				table_1.removeAll();	
				if(item[17]%3==0){
					
					writeTable4(player,0);
					
				}else if(item[17]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"points");
					writeTable4(player2,0);
					
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"points");
					Collections.reverse(player2);
					writeTable4(player2,0);
						
					
				}
			}
		});
		tableColumn_24.setWidth(44);
		tableColumn_24.setText("\u5F97\u5206");
		
		TableColumn tableColumn_25 = new TableColumn(table_1, SWT.NONE);
		tableColumn_25.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[18]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"efficiency");
				table_1.removeAll();	
				if(item[18]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[18]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_25.setWidth(52);
		tableColumn_25.setText("\u6548\u7387");
		
		TableColumn tableColumn_26 = new TableColumn(table_1, SWT.NONE);//GmScЧ��ֵ
		tableColumn_26.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[19]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"GmSc");
				table_1.removeAll();	
				if(item[19]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[19]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_26.setWidth(70);
		tableColumn_26.setText("GmSc\u6548\u7387\u503C");
		
		TableColumn tableColumn_27 = new TableColumn(table_1, SWT.NONE);//��ʵ������
		tableColumn_27.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[20]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"trueShootingPercentage");
				table_1.removeAll();	
				if(item[20]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[20]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_27.setWidth(70);
		tableColumn_27.setText("\u771F\u5B9E\u547D\u4E2D\u7387");
		
		TableColumn tableColumn_28 = new TableColumn(table_1, SWT.NONE);
		tableColumn_28.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[21]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"shootingEfficiency");
				table_1.removeAll();	
				if(item[21]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[21]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_28.setWidth(70);
		tableColumn_28.setText("\u6295\u7BEE\u6548\u7387");
		
		TableColumn tableColumn_29 = new TableColumn(table_1, SWT.NONE);//������
		tableColumn_29.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[22]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"reboundRating");
				table_1.removeAll();	
				if(item[22]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[22]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_29.setWidth(70);
		tableColumn_29.setText("\u7BEE\u677F\u7387");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table_1, SWT.NONE);//����������
		tblclmnNewColumn_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[23]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"offensiveReboundRating");
				table_1.removeAll();	
				if(item[23]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[23]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tblclmnNewColumn_2.setText("\u8FDB\u653B\u7BEE\u677F\u7387");
		tblclmnNewColumn_2.setWidth(70);
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table_1, SWT.NONE);//����������
		tblclmnNewColumn_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[24]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"defensiveReboundRating");
				table_1.removeAll();	
				if(item[24]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[24]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tblclmnNewColumn_3.setWidth(70);
		tblclmnNewColumn_3.setText("\u9632\u5B88\u7BEE\u677F\u7387");
		
		TableColumn tableColumn_30 = new TableColumn(table_1, SWT.NONE);
		tableColumn_30.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[25]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"assisyRating");
				table_1.removeAll();	
				if(item[25]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[25]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_30.setWidth(70);
		tableColumn_30.setText("\u52A9\u653B\u7387");
		
		TableColumn tableColumn_31 = new TableColumn(table_1, SWT.NONE);//������
		tableColumn_31.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[26]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"stealRating");
				table_1.removeAll();	
				if(item[26]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[26]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tableColumn_31.setText("\u62A2\u65AD\u7387");
		tableColumn_31.setWidth(70);
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table_1, SWT.NONE);//��ñ��
		tblclmnNewColumn_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[27]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"blockRating");
				table_1.removeAll();	
				if(item[27]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[27]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tblclmnNewColumn_4.setWidth(70);
		tblclmnNewColumn_4.setText("\u76D6\u5E3D\u7387");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table_1, SWT.NONE);//ʧ����
		tblclmnNewColumn_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[28]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"turnoverRating");
				table_1.removeAll();	
				if(item[28]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[28]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tblclmnNewColumn_5.setWidth(70);
		tblclmnNewColumn_5.setText("\u5931\u8BEF\u7387");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table_1, SWT.NONE);//ʹ����
		tblclmnNewColumn_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[29]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"utilizationRating");
				table_1.removeAll();	
				if(item[29]%3==0){
					
					if(combo_7.getText().equals("��������")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[29]%3==1){
					if(combo_7.getText().equals("��������")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(combo_7.getText().equals("��������")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		tblclmnNewColumn_6.setWidth(70);
		tblclmnNewColumn_6.setText("\u4F7F\u7528\u7387");
		
	
		Button backButton_3 = new Button(composite_4, SWT.NONE);
		backButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_4.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		backButton_3.setBounds(1262, 21, 98, 30);
		backButton_3.setText("\u8FD4\u56DE");
		
		Button backButton_4 = new Button(composite_5, SWT.NONE);
		backButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_5.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		backButton_4.setBounds(1262, 21, 98, 30);
		backButton_4.setText("\u8FD4\u56DE");
		
		final Combo combo_8 = new Combo(composite_5, SWT.NONE);//ѡ�񳡾�����/������ ���
		combo_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_8.getText().equals("��������")){
					table_3.removeAll();
					ServiceImp si=new ServiceImp();	
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.All);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable3(t,1);
				}else if(combo_8.getText().equals("������")){
					table_3.removeAll();
					ServiceImp si=new ServiceImp();	
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.All);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable3(t,0);
					
					
				}
				
				
			}
		});
		combo_8.setBounds(200, 170, 92, 28);
		combo_8.setText("\u603B\u6570\u636E");
		combo_8.add("������");
		combo_8.setData("0", "������");
		combo_8.add("��������");
		combo_8.setData("1", "��������");
		
		table_3 = new Table(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_NONE);
				composite_5.setVisible(false);
				composite_8.setVisible(true);
				TableItem[] itemList =table_3.getItems();
				int listHaveChouse = table_3.getSelectionIndex();		
				String firstInfo = itemList[listHaveChouse].getText(1);
				
				teamInfoVO t=new teamInfoVO();
				t.setFullName(firstInfo);
				ServiceImp si=new ServiceImp();
				teamInfoVO t2=si.getSingleTeamInfo(t);
				teamText_1.setText("���ȫ�ƣ�"+t2.getFullName());
				teamText_2.setText("��д��"+t2.getTeamName());
				teamText_3.setText("���ڵأ�"+t2.getCity());
				teamText_4.setText("������"+t2.getZone());
				teamText_5.setText("������"+t2.getSubarea());
				teamText_6.setText("������"+t2.getHomeCourt());
				teamText_7.setText("����ʱ�䣺"+t2.getCreateTime());
				
				Image image=SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/teams/"+t2.getTeamName()+".jpg");
				final Rectangle bounds=image.getBounds();
				composite_9.setBounds(100, 200, bounds.width, bounds.height);					
				composite_9.setBackgroundImage(image);
			
				
			}
		});
		table_3.setLocation(100, 300);
		table_3.setSize(1240, 550);
		table_3.setHeaderVisible(true);
		table_3.setLinesVisible(true);
		final int item2[] =new int[30] ;
		for(int i=0;i<30;i++){
			item2[i]=0;
		}
		
		TableColumn tableColumn_32 = new TableColumn(table_3, SWT.NONE);//����
		tableColumn_32.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		tableColumn_32.setWidth(43);
		tableColumn_32.setText("\u6392\u540D");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table_3, SWT.NONE);//�������
		tblclmnNewColumn_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		tblclmnNewColumn_7.setWidth(100);
		tblclmnNewColumn_7.setText("\u7403\u961F\u540D\u79F0");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table_3, SWT.NONE);//��������
		tblclmnNewColumn_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				item2[2]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[2]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[2]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "gamesPlayed");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "gamesPlayed");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			
			}
		});
		tblclmnNewColumn_8.setWidth(100);
		tblclmnNewColumn_8.setText("\u6BD4\u8D5B\u573A\u6570");
		
		TableColumn tblclmnNewColumn_9 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[3]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[3]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[3]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "fieldGoalsMade");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "fieldGoalsMade");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_9.setWidth(100);
		tblclmnNewColumn_9.setText("\u6295\u7BEE\u547D\u4E2D\u6570");
		
		TableColumn tblclmnNewColumn_10 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[4]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[4]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[4]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "fieldGoalsAttempted");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "fieldGoalsAttempted");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_10.setWidth(100);
		tblclmnNewColumn_10.setText("\u6295\u7BEE\u51FA\u624B\u6B21\u6570");
		
		TableColumn tblclmnNewColumn_11 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[5]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[5]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[5]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "threePointFieldGoalsMade");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "threePointFieldGoalsMade");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_11.setWidth(100);
		tblclmnNewColumn_11.setText("\u4E09\u5206\u547D\u4E2D\u6570");
		
		TableColumn tblclmnNewColumn_12 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[6]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[6]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[6]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "threePointFieldGoalsAttempted");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "threePointFieldGoalsAttempted");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_12.setWidth(100);
		tblclmnNewColumn_12.setText("\u4E09\u5206\u51FA\u624B\u6570");
		
		TableColumn tblclmnNewColumn_13 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[7]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[7]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[7]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "freeThrowsMade");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "freeThrowsMade");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_13.setWidth(100);
		tblclmnNewColumn_13.setText("\u7F5A\u7403\u547D\u4E2D\u6570");
		
		TableColumn tblclmnNewColumn_14 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[8]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[8]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[8]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "freeThrowsAttempted");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "freeThrowsAttempted");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_14.setWidth(100);
		tblclmnNewColumn_14.setText("\u7F5A\u7403\u51FA\u624B\u6570");
		
		TableColumn tblclmnNewColumn_15 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[9]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[9]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[9]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "offensiveRebounds");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "offensiveRebounds");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_15.setWidth(100);
		tblclmnNewColumn_15.setText("\u8FDB\u653B\u7BEE\u677F\u6570");
		
		TableColumn tblclmnNewColumn_16 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[10]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[10]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[10]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "defensiveRebounds");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "defensiveRebounds");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_16.setWidth(100);
		tblclmnNewColumn_16.setText("\u9632\u5B88\u7BEE\u677F\u6570");
		
		TableColumn tblclmnNewColumn_17 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[11]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[11]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[11]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "rebounds");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "rebounds");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_17.setWidth(100);
		tblclmnNewColumn_17.setText("\u7BEE\u677F\u6570");
		
		TableColumn tblclmnNewColumn_18 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[12]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[12]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[12]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "assists");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "assists");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_18.setWidth(100);
		tblclmnNewColumn_18.setText("\u52A9\u653B\u6570");
		
		TableColumn tblclmnNewColumn_19 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_19.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[13]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[13]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[13]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "steals");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "steals");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_19.setWidth(100);
		tblclmnNewColumn_19.setText("\u62A2\u65AD\u6570");
		
		TableColumn tblclmnNewColumn_20 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[14]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[14]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[14]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "blocks");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "blocks");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_20.setWidth(100);
		tblclmnNewColumn_20.setText("\u76D6\u5E3D\u6570");
		
		TableColumn tblclmnNewColumn_21 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[15]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[15]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[15]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "turnovers");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "turnovers");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_21.setWidth(100);
		tblclmnNewColumn_21.setText("\u5931\u8BEF\u6570");
		
		TableColumn tblclmnNewColumn_22 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[16]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[16]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[16]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "fouls");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "fouls");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_22.setWidth(100);
		tblclmnNewColumn_22.setText("\u72AF\u89C4\u6570");
		
		TableColumn tblclmnNewColumn_23 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[17]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[17]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[17]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "points");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "points");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_23.setWidth(100);
		tblclmnNewColumn_23.setText("\u6BD4\u8D5B\u5F97\u5206");
		
		TableColumn tblclmnNewColumn_24 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[18]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[18]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[18]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "fieldGoalPercentage");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "fieldGoalPercentage");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_24.setWidth(100);
		tblclmnNewColumn_24.setText("\u6295\u7BEE\u547D\u4E2D\u7387");
		
		TableColumn tblclmnNewColumn_25 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_25.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[19]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[19]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[19]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "threePointFieldGoalPercentage");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "threePointFieldGoalPercentage");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_25.setWidth(100);
		tblclmnNewColumn_25.setText("\u4E09\u5206\u547D\u4E2D\u7387");
		
		TableColumn tblclmnNewColumn_26 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_26.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[20]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[20]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[20]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "freeThrowPercentage");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "freeThrowPercentage");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_26.setWidth(100);
		tblclmnNewColumn_26.setText("\u7F5A\u7403\u547D\u4E2D\u7387");
		
		TableColumn tblclmnNewColumn_27 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_27.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[21]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[21]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[21]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "winPercentage");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "winPercentage");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_27.setWidth(100);
		tblclmnNewColumn_27.setText("\u80DC\u7387");
		
		TableColumn tblclmnNewColumn_28 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_28.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[22]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[22]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[22]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "possessions");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "possessions");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_28.setWidth(100);
		tblclmnNewColumn_28.setText("\u8FDB\u653B\u56DE\u5408");
		
		TableColumn tblclmnNewColumn_29 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_29.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[23]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[23]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[23]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "offensiveRating");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "offensiveRating");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_29.setWidth(100);
		tblclmnNewColumn_29.setText("\u8FDB\u653B\u6548\u7387");
		
		TableColumn tblclmnNewColumn_30 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_30.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[24]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[24]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[24]%3==1){				
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "defensiveRating");
					writeTable3(team2,0);			
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "defensiveRating");
					Collections.reverse(team2);
					writeTable3(team2,0);
		
				}
			}
		});
		tblclmnNewColumn_30.setWidth(100);
		tblclmnNewColumn_30.setText("\u9632\u5B88\u6548\u7387");
		
		TableColumn tableColumn_34 = new TableColumn(table_3, SWT.NONE);
		tableColumn_34.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[25]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[25]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[25]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "offensiveReboundPercentage");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "offensiveReboundPercentage");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tableColumn_34.setWidth(100);
		tableColumn_34.setText("\u8FDB\u653B\u7BEE\u677F\u6548\u7387");
		
		TableColumn tableColumn_33 = new TableColumn(table_3, SWT.NONE);
		tableColumn_33.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[26]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[26]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[26]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "defensiveReboundPercentage");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "defensiveReboundPercentage");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tableColumn_33.setWidth(100);
		tableColumn_33.setText("\u9632\u5B88\u7BEE\u677F\u6548\u7387");
		
		TableColumn tblclmnNewColumn_32 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_32.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[27]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[27]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[27]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "stealPercentage");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "stealPercentage");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_32.setWidth(100);
		tblclmnNewColumn_32.setText("\u62A2\u65AD\u6548\u7387");
		
		TableColumn tblclmnNewColumn_33 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_33.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[28]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("��������")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setOffensiveRebounds(team.get(i).getOffensiveRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setDefensiveRebounds(team.get(i).getDefensiveRebounds()/team.get(i).getGamesPlayed());				
						team.get(i).setRebounds(team.get(i).getRebounds()/team.get(i).getGamesPlayed());
						team.get(i).setAssists(team.get(i).getAssists()/team.get(i).getGamesPlayed());
						team.get(i).setSteals(team.get(i).getSteals()/team.get(i).getGamesPlayed());
						team.get(i).setBlocks(team.get(i).getBlocks()/team.get(i).getGamesPlayed());
						team.get(i).setTurnovers(team.get(i).getTurnovers()/team.get(i).getGamesPlayed());
						team.get(i).setFouls(team.get(i).getFouls()/team.get(i).getGamesPlayed());
						team.get(i).setPoints(team.get(i).getPoints()/team.get(i).getGamesPlayed());
						team.get(i).setPossessions(team.get(i).getPossessions()/team.get(i).getGamesPlayed());
					}
				}
				
				table_3.removeAll();	
				if(item2[28]%3==0){
					
					writeTable3(team,0);
					
				}else if(item2[28]%3==1){
					
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "assistPercentage");
					writeTable3(team2,0);
					
				}else{
					ArrayList<teamInfoVO> team2=si.sortTeam(team, "assistPercentage");
					Collections.reverse(team2);
					writeTable3(team2,0);
					
					
				}
			}
		});
		tblclmnNewColumn_33.setWidth(100);
		tblclmnNewColumn_33.setText("\u52A9\u653B\u7387");
		
		composite_6 = new Composite(shell, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(204, 204, 204));
		composite_6.setTouchEnabled(true);
		composite_6.setSize(1440, 900);
		composite_6.setVisible(false);
		composite_6.setBackgroundMode(SWT.INHERIT_DEFAULT);
			
		
		Button button_7 = new Button(composite_6, SWT.NONE);
		button_7.setText("\u8FD4\u56DE");
		button_7.setBounds(1262, 21, 98, 30);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_FORCE);
				composite_6.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		
		
		text_2 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_2.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_2.setBounds(740, 140, 350, 50);
		text_2.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_3 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_3.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_3.setBounds(740, 200, 350, 50);
		text_3.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_4 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_4.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_4.setBounds(740, 260, 350, 50);
		text_4.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_5 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_5.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_5.setBounds(740, 320, 350, 50);
		text_5.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_6 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_6.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_6.setBounds(740, 380, 350,50);
		text_6.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_7 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_7.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_7.setBounds(740, 440, 350, 50);
		text_7.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_8 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_8.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_8.setBounds(740, 500, 350, 50);
		text_8.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_9 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_9.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_9.setBounds(740, 560,350, 50);
		text_9.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_10 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_10.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_10.setBounds(740, 620, 350, 50);
		text_10.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		text_11 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		text_11.setForeground(SWTResourceManager.getColor(255, 102, 51));
		text_11.setBounds(740, 680, 350, 50);	
		text_11.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		composite_8 = new Composite(shell, SWT.NONE);
		composite_8.setSize(1440, 900);
		composite_8.setVisible(false);
		composite_8.setBackgroundMode(SWT.INHERIT_NONE);
			
		
		Button button_8 = new Button(composite_8, SWT.NONE);
		button_8.setText("\u8FD4\u56DE");
		button_8.setBounds(1262, 21, 98, 30);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_FORCE);
				composite_8.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		composite_9 = new Composite(composite_8, SWT.NONE);
		composite_9.setBounds(100, 100, 440, 700);
		
		teamText_1 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_1.setForeground(SWTResourceManager.getColor(255, 102, 51));
		teamText_1.setBounds(740, 140, 350, 50);
		teamText_1.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		teamText_2 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_2.setForeground(SWTResourceManager.getColor(255, 102, 51));
		teamText_2.setBounds(740, 220, 350, 50);
		teamText_2.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		teamText_3 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_3.setForeground(SWTResourceManager.getColor(255, 102, 51));
		teamText_3.setBounds(740, 300, 350, 50);
		teamText_3.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		teamText_4 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_4.setForeground(SWTResourceManager.getColor(255, 102, 51));
		teamText_4.setBounds(740, 380, 350, 50);
		teamText_4.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		teamText_5 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_5.setForeground(SWTResourceManager.getColor(255, 102, 51));
		teamText_5.setBounds(740, 460, 350, 50);
		teamText_5.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		teamText_6 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_6.setForeground(SWTResourceManager.getColor(255, 102, 51));
		teamText_6.setBounds(740, 540, 350, 50);
		teamText_6.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		teamText_7 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_7.setForeground(SWTResourceManager.getColor(255, 102, 51));
		teamText_7.setBounds(740, 620, 350, 50);
		teamText_7.setFont(SWTResourceManager.getFont("��������", 16, SWT.BOLD));
		
		composite_7 = new Composite(composite_6, SWT.NONE);
		
		
		
		
		}
}

