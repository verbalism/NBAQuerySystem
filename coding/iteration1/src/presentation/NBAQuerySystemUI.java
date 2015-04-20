package presentation;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableItem;

import businesslogic.ServiceImp;
import vo.teamCondition;
import vo.teamInfoVO;
import vo.teamPartion;
public class NBAQuerySystemUI {

	protected Shell shell;
	/**
	 * Launch the application.
	 * @param args
	 */
	private static Table playerInfoTable;
	private Text checkText_1;
	private static Table teamInfoTable;
	private Text checkTest_2;
	private static Table playerDataTable;
	private static Table teamDataTable;
	private Text playerText_1;
	private Text playerText_2;
	private Text playerText_3;
	private Text playerText_4;
	private Text playerText_5;
	private Text playerText_6;
	private Text playerText_7;
	private Text playerText_8;
	private Text playerText_9;
	private Text playerText_10;
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
	private Combo avgCombo_1;
	
	
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
					TableItem item=new TableItem(playerInfoTable,SWT.NONE);
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
					TableItem item=new TableItem(teamInfoTable,SWT.NONE);
					item.setText(new String[]{temp.get(i).getFullName(),temp.get(i).getTeamName(),temp.get(i).getCity()
							,temp.get(i).getZone(),temp.get(i).getSubarea(),temp.get(i).getHomeCourt(),temp.get(i).getCreateTime()}); 
				}
			}
		});
	}
	public static void writeTable3(final ArrayList<teamInfoVO> temp,final int n){
		Display.getDefault().asyncExec(new Runnable() { 
			public void run() { 
				teamDataTable.removeAll();
				for(int i=0;i<temp.size();i++){
					TableItem item=new TableItem(teamDataTable,SWT.NONE);
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
				playerDataTable.removeAll();
				for(int i=0;i<temp.size();i++){
					TableItem item=new TableItem(playerDataTable,SWT.NONE);
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
								String.valueOf(temp.get(i).getPoints()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getEfficiency()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getGmSc()/temp.get(i).getGamesPlayed()),String.valueOf(temp.get(i).getTrueShootingPercentage())
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
		
		
		shell = new Shell(SWT.NO_TRIM );//无边框
		
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
		
		/*鼠标拖动*/
		Listener listener = new Listener() {
		    int startX, startY;
		    public void handleEvent(Event e) {
		        if (e.type == SWT.MouseDown && e.button == 1) {
		            startX = e.x;
		            startY = e.y;
		        }
		        if (e.type == SWT.MouseMove && (e.stateMask & SWT.BUTTON1) != 0) {
		            Point p = shell.toDisplay(e.x, e.y);
		            p.x -= startX;
		            p.y -= startY;
		            shell.setLocation(p);
		        }
		    }
		};
		shell.addListener(SWT.MouseDown, listener);
		shell.addListener(SWT.MouseMove, listener);
	
		shell.setSize(1440,900);
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent()  
                .getClientArea().height / 2 - shell.getSize().y/2); //shell居中
		shell.setText("NBA信息查询系统");
		shell.setBackgroundImage(SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/image2.jpg"));//shell背景
		shell.setImage(SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/symbol.jpg"));//shell图标
		shell.setBackgroundMode(SWT.INHERIT_FORCE); 
		
		
		
		composite_1 = new Composite(shell, SWT.NONE);//主界面
		composite_1.setBounds(0, 0, 1440, 900);
		composite_1.setBackgroundMode(SWT.INHERIT_NONE); 
		composite_1.addListener(SWT.MouseDown, listener);
		composite_1.addListener(SWT.MouseMove, listener);
		
		composite_2 = new Composite(shell, SWT.NONE);//球员信息
		composite_2.setLocation(0, 0);
		composite_2.setSize(1440, 900);
		composite_2.setVisible(false);
		composite_2.setBackgroundMode(SWT.INHERIT_NONE); 
		composite_2.addListener(SWT.MouseDown, listener);
		composite_2.addListener(SWT.MouseMove, listener);
		
		composite_3 = new Composite(shell, SWT.NONE);//球队信息
		composite_3.setBounds(0, 0, 1440, 900);
		composite_3.setVisible(false);
		composite_3.setBackgroundMode(SWT.INHERIT_NONE); 
		composite_3.addListener(SWT.MouseDown, listener);
		composite_3.addListener(SWT.MouseMove, listener);
		
		composite_4 = new Composite(shell, SWT.NONE);//球员数据
		composite_4.setBounds(0, 0, 1440, 900);
		composite_4.setVisible(false);
		composite_4.setBackgroundMode(SWT.INHERIT_NONE); 
		composite_4.addListener(SWT.MouseDown, listener);
		composite_4.addListener(SWT.MouseMove, listener);
		
		composite_5 = new Composite(shell, SWT.NONE);//球队数据
		composite_5.setBounds(0, 0, 1440, 900);
		composite_5.setVisible(false);
		composite_5.setBackgroundMode(SWT.INHERIT_NONE); 
		composite_5.addListener(SWT.MouseDown, listener);
		composite_5.addListener(SWT.MouseMove, listener);
		
		Button checkButton_2 = new Button(composite_3, SWT.NONE);//按关键字查找球队信息
		checkButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		checkButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				teamInfoVO t1=new teamInfoVO();
				t1.setFullName(checkTest_2.getText());
				if(checkTest_2.getText().length()>0){
					try{
						ServiceImp si=new ServiceImp();
						teamInfoVO t2=si.getSingleTeamInfo(t1);
						teamInfoTable.removeAll();
						TableItem item=new TableItem(teamInfoTable,SWT.NONE);
						item.setText(new String[]{t2.getFullName(),t2.getTeamName(),t2.getCity()
								,t2.getZone(),t2.getSubarea(),t2.getHomeCourt(),t2.getCreateTime()}); 
					}catch(Exception e1){
					}
				}
			}
		});
		checkButton_2.setLocation(1050, 170);
		checkButton_2.setSize(98, 32);
		checkButton_2.setText("\u67E5\u627E");
		
		Button backButton_2 = new Button(composite_3, SWT.NONE);
		backButton_2.setFont(SWTResourceManager.getFont("宋体", 12, SWT.NORMAL));
		backButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_3.setVisible(false);
				composite_1.setVisible(true);	
				}
		});
		backButton_2.setLocation(1250, 50);
		backButton_2.setSize(100, 40);
		backButton_2.setText("\u8FD4\u56DE");
		
		checkTest_2 = new Text(composite_3, SWT.BORDER | SWT.SEARCH);
		checkTest_2.setText("\u8F93\u5165\u5173\u952E\u5B57\u67E5\u627E");
		checkTest_2.setFont(SWTResourceManager.getFont("方正舒体", 13, SWT.BOLD));
		checkTest_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		checkTest_2.setLocation(850, 170);
		checkTest_2.setSize(180, 32);
		
		final Combo zoneCombo = new Combo(composite_3, SWT.NONE);//按赛区筛选球队
		zoneCombo.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		zoneCombo.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.BOLD));
		final Combo subareaCombo_1 = new Combo(composite_3, SWT.NONE);//按分区筛选球队
		subareaCombo_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		subareaCombo_1.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.BOLD));
		
		zoneCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(zoneCombo.getText().equals("东部联盟")){
					subareaCombo_1.removeAll();
					subareaCombo_1.add("请选择分区");
					subareaCombo_1.setData("0", "请选择分区");
					subareaCombo_1.add("东南分区");
					subareaCombo_1.setData("1", "东南分区");
					subareaCombo_1.add("中央分区");
					subareaCombo_1.setData("2", "中央分区");
					subareaCombo_1.add("大西洋分区");
					subareaCombo_1.setData("3", "大西洋分区");
					teamInfoTable.removeAll();
					ServiceImp si=new ServiceImp();
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.East);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable2(t);		
				}else if(zoneCombo.getText().equals("西部联盟")){
					subareaCombo_1.removeAll();
					subareaCombo_1.add("请选择分区");
					subareaCombo_1.setData("0", "请选择分区");
					subareaCombo_1.add("太平洋分区");
					subareaCombo_1.setData("1", "太平洋分区");
					subareaCombo_1.add("西北分区");
					subareaCombo_1.setData("2", "西北分区");
					subareaCombo_1.add("西南分区");
					subareaCombo_1.setData("3", "西南分区");	
					teamInfoTable.removeAll();
					ServiceImp si=new ServiceImp();
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.West);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable2(t);
				}else if(zoneCombo.getText().equals("全部")){
					subareaCombo_1.removeAll();
					subareaCombo_1.add("请选择分区");
					subareaCombo_1.setData("0", "请选择分区");
					subareaCombo_1.add("东南分区");
					subareaCombo_1.setData("1", "东南分区");
					subareaCombo_1.add("中央分区");
					subareaCombo_1.setData("2", "中央分区");
					subareaCombo_1.add("大西洋分区");
					subareaCombo_1.setData("3", "大西洋分区");
					subareaCombo_1.add("太平洋分区");
					subareaCombo_1.setData("4", "太平洋分区");
					subareaCombo_1.add("西北分区");
					subareaCombo_1.setData("5", "西北分区");
					subareaCombo_1.add("西南分区");
					subareaCombo_1.setData("6", "西南分区");	
					teamInfoTable.removeAll();
					ServiceImp si=new ServiceImp();
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.All);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable2(t);	
				}
			}
		});
		zoneCombo.setLocation(450, 170);
		zoneCombo.setSize(150, 32);	
		zoneCombo.setText("\u8D5B\u533A");
		zoneCombo.add("全部");
		zoneCombo.setData("0", "全部");
		zoneCombo.add("东部联盟");
		zoneCombo.setData("1", "东部联盟");
		zoneCombo.add("西部联盟");
		zoneCombo.setData("2", "西部联盟");
		
	
		subareaCombo_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				teamCondition tc=new teamCondition();
				if(subareaCombo_1.getText().equals("东南分区")||subareaCombo_1.getText().equals("中央分区")||subareaCombo_1.getText().equals("大西洋分区")){
					zoneCombo.setText("东部联盟");
					if(subareaCombo_1.getText().equals("东南分区")){
						tc.setTeampartion(teamPartion.Southeast);
					}else if(subareaCombo_1.getText().equals("中央分区")){
						tc.setTeampartion(teamPartion.Central);
					}else if(subareaCombo_1.getText().equals("大西洋分区")){
						tc.setTeampartion(teamPartion.Atlantic);
					}
					teamInfoTable.removeAll();
					ServiceImp si=new ServiceImp();
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable2(t);
				}else if(subareaCombo_1.getText().equals("太平洋分区")||subareaCombo_1.getText().equals("西北分区")||subareaCombo_1.getText().equals("西南分区")){
					zoneCombo.setText("西部联盟");
					if(subareaCombo_1.getText().equals("太平洋分区")){
						tc.setTeampartion(teamPartion.Pacific);
					}else if(subareaCombo_1.getText().equals("西北分区")){
						tc.setTeampartion(teamPartion.Northwest);
					}else if(subareaCombo_1.getText().equals("西南分区")){
						tc.setTeampartion(teamPartion.Northwest);
					}
					teamInfoTable.removeAll();
					ServiceImp si=new ServiceImp();
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable2(t);
				}
			}
		});
		subareaCombo_1.setLocation(650, 170);
		subareaCombo_1.setSize(150, 32);
		subareaCombo_1.setText("\u5206\u533A");
		subareaCombo_1.add("请选择分区");
		subareaCombo_1.setData("0", "请选择分区");
		subareaCombo_1.add("东南分区");
		subareaCombo_1.setData("1", "东南分区");
		subareaCombo_1.add("中央分区");
		subareaCombo_1.setData("2", "中央分区");
		subareaCombo_1.add("大西洋分区");
		subareaCombo_1.setData("3", "大西洋分区");
		subareaCombo_1.add("太平洋分区");
		subareaCombo_1.setData("4", "太平洋分区");
		subareaCombo_1.add("西北分区");
		subareaCombo_1.setData("5", "西北分区");
		subareaCombo_1.add("西南分区");
		subareaCombo_1.setData("6", "西南分区");
		
		teamInfoTable = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);//球队基本信息列表
		teamInfoTable.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		teamInfoTable.setFont(SWTResourceManager.getFont("Microsoft YaHei UI Light", 10, SWT.BOLD));
		teamInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_NONE);
				composite_3.setVisible(false);
				composite_8.setVisible(true);
				TableItem[] itemList =teamInfoTable.getItems();
				int listHaveChouse = teamInfoTable.getSelectionIndex();		
				String firstInfo = itemList[listHaveChouse].getText(0);
				String secondInfo = itemList[listHaveChouse].getText(1);
				teamInfoVO t=new teamInfoVO();
				t.setFullName(firstInfo);
				ServiceImp si=new ServiceImp();
				teamInfoVO t2=si.getSingleTeamInfo(t);
				teamText_1.setText("球队全称："+t2.getFullName());
				teamText_2.setText("缩写："+t2.getTeamName());
				teamText_3.setText("所在地："+t2.getCity());
				teamText_4.setText("赛区："+t2.getZone());
				teamText_5.setText("分区："+t2.getSubarea());
				teamText_6.setText("主场："+t2.getHomeCourt());
				teamText_7.setText("建立时间："+t2.getCreateTime());
				Image image=SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/teams/"+secondInfo+".jpg");
				final Rectangle bounds=image.getBounds();
				composite_9.setBounds(100, 200, bounds.width, bounds.height);					
				composite_9.setBackgroundImage(image);
				
			}
		});
		teamInfoTable.setLocation(430, 270);
		teamInfoTable.setSize(943, 507);
		teamInfoTable.setHeaderVisible(true);
		teamInfoTable.setLinesVisible(true);
		
		TableColumn teamTableColumn_1 = new TableColumn(teamInfoTable, SWT.NONE);
		teamTableColumn_1.setWidth(150);
		teamTableColumn_1.setText("\u7403\u961F\u5168\u79F0");
		
		TableColumn teamTableColumn_2 = new TableColumn(teamInfoTable, SWT.NONE);
		teamTableColumn_2.setWidth(100);
		teamTableColumn_2.setText("\u7F29\u5199");
		
		TableColumn teamTableColumn_3 = new TableColumn(teamInfoTable, SWT.NONE);
		teamTableColumn_3.setWidth(140);
		teamTableColumn_3.setText("\u6240\u5728\u5730");
		
		TableColumn teamTableColumn_4 = new TableColumn(teamInfoTable, SWT.NONE);
		teamTableColumn_4.setWidth(80);
		teamTableColumn_4.setText("\u8D5B\u533A");
		
		TableColumn teamTableColumn_5 = new TableColumn(teamInfoTable, SWT.NONE);
		teamTableColumn_5.setWidth(150);
		teamTableColumn_5.setText("\u5206\u533A");
		
		TableColumn teamTableColumn_6 = new TableColumn(teamInfoTable, SWT.NONE);
		teamTableColumn_6.setWidth(200);
		teamTableColumn_6.setText("\u4E3B\u573A");
		
		TableColumn teamTableColumn_7 = new TableColumn(teamInfoTable, SWT.NONE);
		teamTableColumn_7.setWidth(120);
		teamTableColumn_7.setText("\u5EFA\u7ACB\u65F6\u95F4");
		
		playerInfoTable = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		playerInfoTable.setFont(SWTResourceManager.getFont("微软雅黑 Light", 10, SWT.BOLD));
		playerInfoTable.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		playerInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_NONE);
				composite_2.setVisible(false);
				composite_6.setVisible(true);
				TableItem[] itemList =playerInfoTable.getItems();
				int listHaveChouse = playerInfoTable.getSelectionIndex();		
				final String firstInfo = itemList[listHaveChouse].getText(0);
				playerInfoVO p=new playerInfoVO();
				p.setPlayerName(firstInfo);
				ServiceImp si=new ServiceImp();
				playerInfoVO p2=si.getSinglePlayerInfo(p);
				playerText_1.setText("姓名："+p2.getPlayerName());
				playerText_2.setText("所属球队："+p2.getTeamName());
				playerText_3.setText("球衣号码："+p2.getNumber());
				playerText_4.setText("位置："+p2.getPosition());
				playerText_5.setText("身高："+p2.getHeight());
				playerText_6.setText("体重："+p2.getWeight());				
				playerText_7.setText("生日："+p2.getBirth());
				playerText_8.setText("年龄："+p2.getAge());
				playerText_9.setText("球龄："+p2.getExp());
				playerText_10.setText("毕业学校："+p2.getSchool());
				
				Image image=SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/players/action/"+firstInfo+".png");
				final Rectangle bounds=image.getBounds();
				composite_7.setBounds(100, 100, bounds.width, bounds.height);					
				composite_7.setBackgroundImage(image);

				
			}
		});
		playerInfoTable.setBounds(430, 270, 927, 500);
		playerInfoTable.setHeaderVisible(true);
		playerInfoTable.setLinesVisible(true);

	
		TableColumn tableColumn_1 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_1.setWidth(180);
		tableColumn_1.setText("\u59D3\u540D");
		
		TableColumn tableColumn_2 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_2.setWidth(90);
		tableColumn_2.setText("\u7403\u8863\u53F7\u7801");
		
		TableColumn tableColumn_3 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_3.setWidth(60);
		tableColumn_3.setText("\u4F4D\u7F6E");
		
		TableColumn tableColumn_4 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_4.setWidth(65);
		tableColumn_4.setText("\u8EAB\u9AD8");
		
		TableColumn tableColumn_5 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_5.setWidth(50);
		tableColumn_5.setText("\u4F53\u91CD");
		
		TableColumn tableColumn_6 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_6.setWidth(170);
		tableColumn_6.setText("\u751F\u65E5");
		
		TableColumn tableColumn_7 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_7.setWidth(65);
		tableColumn_7.setText("\u5E74\u9F84");
		
		TableColumn tableColumn_8 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_8.setWidth(65);
		tableColumn_8.setText("\u7403\u9F84");
		
		TableColumn tableColumn_9 = new TableColumn(playerInfoTable, SWT.NONE);
		tableColumn_9.setWidth(170);
		tableColumn_9.setText("\u6BD5\u4E1A\u5B66\u6821");
		/*
		Combo combo_1 = new Combo(composite_2, SWT.NONE);//按所属球队筛选 
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
		final Combo positionCombo_1 = new Combo(composite_2, SWT.NONE);//按位置筛选
		positionCombo_1.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.BOLD));
		positionCombo_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		positionCombo_1.add("全部");
		positionCombo_1.setData("0", "全部");
		positionCombo_1.add("前锋");
		positionCombo_1.setData("1", "前锋");
		positionCombo_1.add("中锋");
		positionCombo_1.setData("2", "中锋");
		positionCombo_1.add("后卫");
		positionCombo_1.setData("3", "后卫");
		positionCombo_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				playerInfoTable.removeAll();
				playerCondition pc=new playerCondition();
				if(positionCombo_1.getText().equals("前锋")){
					pc.setPlayerPosition(playerPosition.Forward);
				}else if(positionCombo_1.getText().equals("中锋")){
					pc.setPlayerPosition(playerPosition.Center);
				}else if(positionCombo_1.getText().equals("后卫")){
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
		positionCombo_1.setBounds(458, 191, 170, 40);
		positionCombo_1.setText("\u6309\u4F4D\u7F6E\u67E5\u627E");
		
		
		Button checkButton_1 = new Button(composite_2, SWT.NONE);//按关键字查找球员
		checkButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//只实现了输入全名查找
				playerInfoVO p=new playerInfoVO();
				p.setPlayerName(checkText_1.getText());
				if(checkText_1.getText().length()>0){
					try{
					ServiceImp si=new ServiceImp();
					playerInfoVO player=si.getSinglePlayerInfo(p);
					playerInfoTable.removeAll();
					TableItem item=new TableItem(playerInfoTable,SWT.NONE);
					item.setText(new String[]{player.getPlayerName(),player.getNumber(),player.getPosition()
						,player.getHeight(),player.getWeight(),player.getBirth(),player.getAge(),
						player.getExp(),player.getSchool()});
					}catch(Exception e1){
						
					}
				}
			}
		});
		checkButton_1.setBounds(952, 189, 98, 32);
		checkButton_1.setText("\u67E5\u627E");
		
		Button backButton_1 = new Button(composite_2, SWT.NONE);//返回主界面
		backButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		backButton_1.setFont(SWTResourceManager.getFont("宋体", 12, SWT.NORMAL));
		backButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		backButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_2.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		backButton_1.setBounds(1250, 50, 100, 40);
		backButton_1.setText("\u8FD4\u56DE");		
		checkText_1 = new Text(composite_2, SWT.BORDER );
		checkText_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(checkText_1.getText().equals("\u8F93\u5165\u5173\u952E\u5B57\u67E5\u627E"))
					checkText_1.setText("123");
			}
		});
		checkText_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		checkText_1.setFont(SWTResourceManager.getFont("方正舒体", 13, SWT.BOLD));
		checkText_1.setToolTipText("");
		checkText_1.setText("\u8F93\u5165\u5173\u952E\u5B57\u67E5\u627E");
		checkText_1.setBounds(764, 189, 170, 32);
		
		Button button_1 = new Button(composite_1, SWT.NONE);//球员信息
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
		
		Button button_2 = new Button(composite_1, SWT.NONE);//球队信息
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_1.setVisible(false);
				composite_3.setVisible(true);
				teamInfoTable.removeAll();
				ServiceImp si=new ServiceImp();
				
				teamCondition tc=new teamCondition();
				tc.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
				writeTable2(t);
			}
		});
		button_2.setBounds(933, 275, 123, 56);
		button_2.setText("\u7403\u961F\u4FE1\u606F");
		
		Button button_3 = new Button(composite_1, SWT.NONE);//球员数据
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
		
		Button button_4 = new Button(composite_1, SWT.NONE);//球队数据
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_5.setVisible(true);
				composite_1.setVisible(false);
				teamDataTable.clearAll();
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
		
		
		Button button_5 = new Button(composite_1, SWT.NONE);//退出
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
		final Combo positionCombo_2 = new Combo(composite_4, SWT.NONE);//位置
		positionCombo_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		positionCombo_2.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.BOLD));
		positionCombo_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	
				if(positionCombo_2.getText().equals("前锋")){
					pc2.setPlayerPosition(playerPosition.Forward);				
				}else if(positionCombo_2.getText().equals("中锋")){
					pc2.setPlayerPosition(playerPosition.Center);				
				}else if(positionCombo_2.getText().equals("后卫")){
					pc2.setPlayerPosition(playerPosition.Guard);				
				}else{
					pc2.setPlayerPosition(playerPosition.All);
				}
				playerDataTable.removeAll();
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player,1);
				}else{
					writeTable4(player,0);
				}
			}
		});
		positionCombo_2.setBounds(450, 170, 150, 32);
		positionCombo_2.setText("\u4F4D\u7F6E");
		positionCombo_2.add("请选择位置");
		positionCombo_2.setData("0", "请选择位置");
		positionCombo_2.add("前锋");
		positionCombo_2.setData("1", "前锋");
		positionCombo_2.add("中锋");
		positionCombo_2.setData("2", "中锋");
		positionCombo_2.add("后卫");
		positionCombo_2.setData("3", "后卫");
		
		final Combo subareaCombo_2 = new Combo(composite_4, SWT.NONE);//选择球员联盟
		subareaCombo_2.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.BOLD));
		subareaCombo_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		subareaCombo_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(subareaCombo_2.getText().equals("东南分区——东部联盟")){
					pc2.setPlayerPartition(playerPartition.Southeast);
				}else if(subareaCombo_2.getText().equals("中央分区——东部联盟")){
					pc2.setPlayerPartition(playerPartition.Central);
				}else if(subareaCombo_2.getText().equals("大西洋分区——东部联盟")){
					pc2.setPlayerPartition(playerPartition.Atlantic);
				}else if(subareaCombo_2.getText().equals("太平洋分区——西部联盟")){
					pc2.setPlayerPartition(playerPartition.Pacific);
				}else if(subareaCombo_2.getText().equals("西北分区——西部联盟")){
					pc2.setPlayerPartition(playerPartition.Northwest);
				}else if(subareaCombo_2.getText().equals("西南分区——西部联盟")){
					pc2.setPlayerPartition(playerPartition.Northwest);
				}else if(subareaCombo_2.getText().equals("东部联盟")){
					pc2.setPlayerPartition(playerPartition.East);
				}else if(subareaCombo_2.getText().equals("西部联盟")){
					pc2.setPlayerPartition(playerPartition.West);
				}else{
					pc2.setPlayerPartition(playerPartition.All);
				}
				playerDataTable.removeAll();
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player,1);
				}else{
					writeTable4(player,0);
				}
			}
		});
		subareaCombo_2.setBounds(650, 170, 150, 32);
		subareaCombo_2.setText("\u7403\u5458\u8054\u76DF");
		subareaCombo_2.add("请选择分区");
		subareaCombo_2.setData("0", "请选择分区");
		subareaCombo_2.add("东部联盟");
		subareaCombo_2.setData("1", "东部联盟");
		subareaCombo_2.add("西部联盟");
		subareaCombo_2.setData("2", "西部联盟");
		subareaCombo_2.add("东南分区——东部联盟");
		subareaCombo_2.setData("3", "东南分区——东部联盟");
		subareaCombo_2.add("中央分区——东部联盟");
		subareaCombo_2.setData("4", "中央分区——东部联盟");
		subareaCombo_2.add("大西洋分区——东部联盟");
		subareaCombo_2.setData("5", "大西洋分区——东部联盟");
		subareaCombo_2.add("太平洋分区——西部联盟");
		subareaCombo_2.setData("6", "太平洋分区——西部联盟");
		subareaCombo_2.add("西北分区——西部联盟");
		subareaCombo_2.setData("7", "西北分区——西部联盟");
		subareaCombo_2.add("西南分区——西部联盟");
		subareaCombo_2.setData("8", "西南分区——西部联盟");
		
		final Combo sortCombo = new Combo(composite_4, SWT.NONE);//选择排序依据
		sortCombo.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.BOLD));
		sortCombo.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		sortCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(sortCombo.getText().equals("得分")){
					pc2.setSortOpinions(sortOpinions.Points);
				}else if(sortCombo.getText().equals("篮板")){
					pc2.setSortOpinions(sortOpinions.Rebounds);
				}else if(sortCombo.getText().equals("助攻")){
					pc2.setSortOpinions(sortOpinions.Assists );
				}else if(sortCombo.getText().equals("得分/篮板/助攻")){
					pc2.setSortOpinions(sortOpinions.PointsReboundsAssists);
				}else if(sortCombo.getText().equals("盖帽")){
					pc2.setSortOpinions(sortOpinions.Blocks);
				}else if(sortCombo.getText().equals("抢断")){
					pc2.setSortOpinions(sortOpinions.Steals);
				}else if(sortCombo.getText().equals("犯规")){
					pc2.setSortOpinions(sortOpinions.Fouls);
				}else if(sortCombo.getText().equals("失误")){
					pc2.setSortOpinions(sortOpinions.Turnovers);
				}else if(sortCombo.getText().equals("分钟")){
					pc2.setSortOpinions(sortOpinions.Minutes);
				}else if(sortCombo.getText().equals("效率")){
					pc2.setSortOpinions(sortOpinions.Efficiency);
				}else if(sortCombo.getText().equals("投篮")){
					pc2.setSortOpinions(sortOpinions.FieldGoalsMade);
				}else if(sortCombo.getText().equals("三分")){
					pc2.setSortOpinions(sortOpinions.ThreePointFieldGoalsMade);
				}else if(sortCombo.getText().equals("罚球")){
					pc2.setSortOpinions(sortOpinions.FreeThrowsMade);
				}else if(sortCombo.getText().equals("两双")){
					pc2.setSortOpinions(sortOpinions.DoubleDouble);
				}else{
					pc2.setSortOpinions(sortOpinions.Null);
				}
				playerDataTable.removeAll();
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player,1);
				}else{
					writeTable4(player,0);
				}
			}
		});
		sortCombo.setEnabled(true);
		sortCombo.setBounds(850, 170, 150, 32);
		sortCombo.setText("\u6392\u5E8F\u4F9D\u636E");
		sortCombo.add("请选择排序依据");
		sortCombo.setData("0", "请选择排序依据");
		sortCombo.add("得分");
		sortCombo.setData("0", "得分");
		sortCombo.add("篮板");
		sortCombo.setData("1", "篮板");
		sortCombo.add("助攻");
		sortCombo.setData("2", "助攻");
		sortCombo.add("得分/篮板/助攻");
		sortCombo.setData("3", "得分/篮板/助攻");
		sortCombo.add("盖帽");
		sortCombo.setData("4", "盖帽");
		sortCombo.add("抢断");
		sortCombo.setData("5", "抢断");
		sortCombo.add("犯规");
		sortCombo.setData("6", "犯规");		
		sortCombo.add("失误");
		sortCombo.setData("7", "失误");
		sortCombo.add("分钟");
		sortCombo.setData("8", "分钟");
		sortCombo.add("效率");
		sortCombo.setData("9", "效率");
		sortCombo.add("投篮");
		sortCombo.setData("10", "投篮");
		sortCombo.add("三分");
		sortCombo.setData("11", "三分");
		sortCombo.add("罚球");
		sortCombo.setData("12", "罚球");
		sortCombo.add("两双");
		sortCombo.setData("13", "两双");
		
		avgCombo_1 = new Combo(composite_4, SWT.NONE);//选择场均数据/总数据
		avgCombo_1.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.BOLD));
		avgCombo_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		avgCombo_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(avgCombo_1.getText().equals("总数据")){
					playerDataTable.removeAll();	
					ServiceImp si=new ServiceImp();
					ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
					writeTable4(player,0);
				}else if(avgCombo_1.getText().equals("场均数据")){
					playerDataTable.removeAll();		
					ServiceImp si=new ServiceImp();
					ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
					writeTable4(player,1);
				}
			}
		});
		avgCombo_1.setBounds(1050, 170, 200, 32);
		avgCombo_1.setText("\u603B\u6570\u636E/\u573A\u5747\u6570\u636E");
		avgCombo_1.add("总数据");
		avgCombo_1.setData("0", "总数据");
		avgCombo_1.add("场均数据");
		avgCombo_1.setData("1", "场均数据");
		
		playerDataTable = new Table(composite_4, SWT.BORDER | SWT.FULL_SELECTION);
		playerDataTable.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		playerDataTable.setFont(SWTResourceManager.getFont("Microsoft YaHei UI Light", 12, SWT.BOLD));
		playerDataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_NONE);
				composite_4.setVisible(false);
				composite_6.setVisible(true);
				TableItem[] itemList =playerDataTable.getItems();
				int listHaveChouse = playerDataTable.getSelectionIndex();		
				String firstInfo = itemList[listHaveChouse].getText(1);
				playerInfoVO p=new playerInfoVO();
				p.setPlayerName(firstInfo);
				ServiceImp si=new ServiceImp();
				playerInfoVO p2=si.getSinglePlayerInfo(p);
				playerText_1.setText("姓名："+p2.getPlayerName());
				playerText_2.setText("所属球队："+p2.getTeamName());
				playerText_3.setText("球衣号码："+p2.getNumber());
				playerText_4.setText("位置："+p2.getPosition());
				playerText_5.setText("身高："+p2.getHeight());
				playerText_6.setText("体重："+p2.getWeight());				
				playerText_7.setText("生日："+p2.getBirth());
				playerText_8.setText("年龄："+p2.getAge());
				playerText_9.setText("球龄："+p2.getExp());
				playerText_10.setText("毕业学校："+p2.getSchool());
				composite_7.setBackgroundImage(SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/players/action"+firstInfo+".png"));
			}
		});
		playerDataTable.setBounds(420, 300, 950, 550);
		playerDataTable.setHeaderVisible(true);
		playerDataTable.setLinesVisible(true);
		
		final int item[] =new int[30] ;
		for(int i=0;i<30;i++){
			item[i]=0;
		}
		
		TableColumn playerDataTableColumn_1 = new TableColumn(playerDataTable, SWT.NONE);//排名
		playerDataTableColumn_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		playerDataTableColumn_1.setWidth(60);
		playerDataTableColumn_1.setText("\u6392\u540D");
		
		TableColumn playerDataTableColumn_2 = new TableColumn(playerDataTable, SWT.NONE);//球员名称
		playerDataTableColumn_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		playerDataTableColumn_2.setWidth(150);
		playerDataTableColumn_2.setText("\u7403\u5458");
		
		TableColumn playerDataTableColumn_3 = new TableColumn(playerDataTable, SWT.NONE);//所属球队
		playerDataTableColumn_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		playerDataTableColumn_3.setWidth(110);
		playerDataTableColumn_3.setText("\u7403\u961F");
		
		TableColumn playerDataTableColumn_4 = new TableColumn(playerDataTable, SWT.NONE);//参赛场数
		playerDataTableColumn_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[3]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				playerDataTable.removeAll();	
				if(item[3]%3==0){			
					writeTable4(player,0);
				}else if(item[3]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"gamesPlayed");
					writeTable4(player2,0);
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"gamesPlayed");
					Collections.reverse(player2);
					writeTable4(player2,0);
				}
			}
		});
		playerDataTableColumn_4.setWidth(100);
		playerDataTableColumn_4.setText("\u53C2\u8D5B\u6B21\u6570");
		
		TableColumn playerDataTableColumn_5 = new TableColumn(playerDataTable, SWT.NONE);//先发场数
		playerDataTableColumn_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[4]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				playerDataTable.removeAll();	
				if(item[4]%3==0){			
					writeTable4(player,0);
				}else if(item[4]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"gamesStarting");
					writeTable4(player2,0);
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"gamesStarting");
					Collections.reverse(player2);
					writeTable4(player2,0);
				}
			}
		});
		playerDataTableColumn_5.setWidth(100);
		playerDataTableColumn_5.setText("\u5148\u53D1\u573A\u6570");
		
		TableColumn playerDataTableColumn_6 = new TableColumn(playerDataTable, SWT.NONE);//篮板数
		playerDataTableColumn_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[5]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				playerDataTable.removeAll();	
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
		playerDataTableColumn_6.setWidth(80);
		playerDataTableColumn_6.setText("\u7BEE\u677F\u6570");
		
		TableColumn playerDataTableColumn_7 = new TableColumn(playerDataTable, SWT.NONE);//助攻数
		playerDataTableColumn_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[6]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				playerDataTable.removeAll();	
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
		playerDataTableColumn_7.setWidth(80);
		playerDataTableColumn_7.setText("\u52A9\u653B\u6570");
		
		TableColumn playerDataTableColumn_8 = new TableColumn(playerDataTable, SWT.NONE);//在场时间
		playerDataTableColumn_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[7]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				
				playerDataTable.removeAll();	
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
		playerDataTableColumn_8.setWidth(100);
		playerDataTableColumn_8.setText("\u5728\u573A\u65F6\u95F4");
		
		TableColumn playerDataTableColumn_9 = new TableColumn(playerDataTable, SWT.NONE);//投篮命中率
		playerDataTableColumn_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[8]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"fieldGoalsPercentage");
				playerDataTable.removeAll();	
				if(item[8]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[8]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
				}
			}
		});
		playerDataTableColumn_9.setWidth(150);
		playerDataTableColumn_9.setText("\u6295\u7BEE\u547D\u4E2D\u7387%");
		
		TableColumn playerDataTableColumn_10 = new TableColumn(playerDataTable, SWT.NONE);
		playerDataTableColumn_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[9]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"threePointFieldGoalsPercentage");
				playerDataTable.removeAll();	
				if(item[9]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[9]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_10.setWidth(150);
		playerDataTableColumn_10.setText("\u4E09\u5206\u547D\u4E2D\u7387%");
		
		TableColumn playerDataTableColumn_11 = new TableColumn(playerDataTable, SWT.NONE);
		playerDataTableColumn_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[10]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"freeThrowsPercentage");
				playerDataTable.removeAll();	
				if(item[10]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[10]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_11.setWidth(150);
		playerDataTableColumn_11.setText("\u7F5A\u7403\u547D\u4E2D\u7387%");
		
		TableColumn playerDataTableColumn_12 = new TableColumn(playerDataTable, SWT.NONE);
		playerDataTableColumn_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[11]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				
				playerDataTable.removeAll();	
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
		playerDataTableColumn_12.setWidth(90);
		playerDataTableColumn_12.setText("\u8FDB\u653B\u6570");
		
		TableColumn playerDataTableColumn_13 = new TableColumn(playerDataTable, SWT.NONE);//防守篮板数
		playerDataTableColumn_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[12]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				
				playerDataTable.removeAll();	
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
		playerDataTableColumn_13.setWidth(90);
		playerDataTableColumn_13.setText("\u9632\u5B88\u6570");
		
		TableColumn playerDataTableColumn_14 = new TableColumn(playerDataTable, SWT.NONE);
		playerDataTableColumn_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[13]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				playerDataTable.removeAll();	
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
		playerDataTableColumn_14.setWidth(90);
		playerDataTableColumn_14.setText("\u62A2\u65AD\u6570");
		
		TableColumn playerDataTableColumn_15 = new TableColumn(playerDataTable, SWT.NONE);
		playerDataTableColumn_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[14]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				
				playerDataTable.removeAll();	
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
		playerDataTableColumn_15.setWidth(90);
		playerDataTableColumn_15.setText("\u76D6\u5E3D\u6570");
		
		TableColumn playerDataTableColumn_16 = new TableColumn(playerDataTable, SWT.NONE);//失误数
		playerDataTableColumn_16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[15]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				
				playerDataTable.removeAll();	
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
		playerDataTableColumn_16.setWidth(90);
		playerDataTableColumn_16.setText("\u5931\u8BEF\u6570");
		
		TableColumn playerDataTableColumn_17 = new TableColumn(playerDataTable, SWT.NONE);//犯规数
		playerDataTableColumn_17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[16]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				
				playerDataTable.removeAll();	
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
		playerDataTableColumn_17.setWidth(90);
		playerDataTableColumn_17.setText("\u72AF\u89C4\u6570");
		
		TableColumn playerDataTableColumn_18 = new TableColumn(playerDataTable, SWT.NONE);//得分
		playerDataTableColumn_18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[17]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				
				playerDataTable.removeAll();	
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
		playerDataTableColumn_18.setWidth(70);
		playerDataTableColumn_18.setText("\u5F97\u5206");
		
		TableColumn playerDataTableColumn_19 = new TableColumn(playerDataTable, SWT.NONE);
		playerDataTableColumn_19.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[18]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
			
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				playerDataTable.removeAll();	
				if(item[18]%3==0){			
					writeTable4(player,0);			
				}else if(item[18]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"efficiency");
					writeTable4(player2,0);		
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"efficiency");
					Collections.reverse(player2);
					writeTable4(player2,0);
				}
			}
		});
		playerDataTableColumn_19.setWidth(70);
		playerDataTableColumn_19.setText("\u6548\u7387");
		
		TableColumn playerDataTableColumn_20 = new TableColumn(playerDataTable, SWT.NONE);//GmSc效率值
		playerDataTableColumn_20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[19]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				
				if(avgCombo_1.getText().equals("场均数据")){
					for(int i=0;i<player.size();i++){
						player.get(i).setEfficiency(player.get(i).getEfficiency()/player.get(i).getGamesPlayed());
						player.get(i).setGmSc(player.get(i).getGmSc()/player.get(i).getGamesPlayed());
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
				playerDataTable.removeAll();	
				if(item[18]%3==0){			
					writeTable4(player,0);			
				}else if(item[18]%3==1){
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"GmSc");
					writeTable4(player2,0);		
				}else{
					ArrayList<playerInfoVO> player2=si.descendingOrder(player,"GmSc");
					Collections.reverse(player2);
					writeTable4(player2,0);
				}
			}
		});
		playerDataTableColumn_20.setWidth(130);
		playerDataTableColumn_20.setText("GmSc\u6548\u7387\u503C");
		
		TableColumn playerDataTableColumn_21 = new TableColumn(playerDataTable, SWT.NONE);//真实命中率
		playerDataTableColumn_21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[20]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"trueShootingPercentage");
				playerDataTable.removeAll();	
				if(item[20]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[20]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_21.setWidth(130);
		playerDataTableColumn_21.setText("\u771F\u5B9E\u547D\u4E2D\u7387%");
		
		TableColumn playerDataTableColumn_22 = new TableColumn(playerDataTable, SWT.NONE);
		playerDataTableColumn_22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[21]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"shootingEfficiency");
				playerDataTable.removeAll();	
				if(item[21]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[21]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_22.setWidth(130);
		playerDataTableColumn_22.setText("\u6295\u7BEE\u6548\u7387%");
		
		TableColumn playerDataTableColumn_23 = new TableColumn(playerDataTable, SWT.NONE);//篮板率
		playerDataTableColumn_23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[22]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"reboundRating");
				playerDataTable.removeAll();	
				if(item[22]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[22]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_23.setWidth(130);
		playerDataTableColumn_23.setText("\u7BEE\u677F\u7387%");
		
		TableColumn playerDataTableColumn_24 = new TableColumn(playerDataTable, SWT.NONE);//进攻篮板率
		playerDataTableColumn_24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[23]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"offensiveReboundRating");
				playerDataTable.removeAll();	
				if(item[23]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[23]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_24.setText("\u8FDB\u653B\u7BEE\u677F\u7387%");
		playerDataTableColumn_24.setWidth(150);
		
		TableColumn playerDataTableColumn_25 = new TableColumn(playerDataTable, SWT.NONE);//防守篮板率
		playerDataTableColumn_25.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[24]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"defensiveReboundRating");
				playerDataTable.removeAll();	
				if(item[24]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[24]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_25.setWidth(150);
		playerDataTableColumn_25.setText("\u9632\u5B88\u7BEE\u677F\u7387%");
		
		TableColumn playerDataTableColumn_26 = new TableColumn(playerDataTable, SWT.NONE);
		playerDataTableColumn_26.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[25]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"assisyRating");
				playerDataTable.removeAll();	
				if(item[25]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[25]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_26.setWidth(130);
		playerDataTableColumn_26.setText("\u52A9\u653B\u7387%");
		
		TableColumn playerDataTableColumn_27 = new TableColumn(playerDataTable, SWT.NONE);//抢断率
		playerDataTableColumn_27.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[26]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"stealRating");
				playerDataTable.removeAll();	
				if(item[26]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[26]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_27.setText("\u62A2\u65AD\u7387%");
		playerDataTableColumn_27.setWidth(130);
		
		TableColumn playerDataTableColumn_28 = new TableColumn(playerDataTable, SWT.NONE);//盖帽率
		playerDataTableColumn_28.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[27]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"blockRating");
				playerDataTable.removeAll();	
				if(item[27]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[27]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_28.setWidth(130);
		playerDataTableColumn_28.setText("\u76D6\u5E3D\u7387%");
		
		TableColumn playerDataTableColumn_29 = new TableColumn(playerDataTable, SWT.NONE);//失误率
		playerDataTableColumn_29.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[28]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"turnoverRating");
				playerDataTable.removeAll();	
				if(item[28]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[28]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_29.setWidth(130);
		playerDataTableColumn_29.setText("\u5931\u8BEF\u7387%");
		
		TableColumn playerDataTableColumn_30 = new TableColumn(playerDataTable, SWT.NONE);//使用率
		playerDataTableColumn_30.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item[29]++;
				ServiceImp si=new ServiceImp();
				ArrayList<playerInfoVO> player=si.getPlayerInfo(pc2);
				ArrayList<playerInfoVO> player2=si.descendingOrder(player,"utilizationRating");
				playerDataTable.removeAll();	
				if(item[29]%3==0){
					
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(si.getPlayerInfo(pc2),1);
					}else{
						writeTable4(si.getPlayerInfo(pc2),0);
					}
				}else if(item[29]%3==1){
					if(avgCombo_1.getText().equals("场均数据")){
					writeTable4(player2,1);
					}else{
					writeTable4(player2,0);
					}
				}else{
					Collections.reverse(player2);
					if(avgCombo_1.getText().equals("场均数据")){
						writeTable4(player2,1);
						}else{
						writeTable4(player2,0);
						}
					
				}
			}
		});
		playerDataTableColumn_30.setWidth(130);
		playerDataTableColumn_30.setText("\u4F7F\u7528\u7387%");
		
	
		Button backButton_3 = new Button(composite_4, SWT.NONE);
		backButton_3.setFont(SWTResourceManager.getFont("宋体", 12, SWT.NORMAL));
		backButton_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		backButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_4.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		backButton_3.setBounds(1250, 40, 100, 40);
		backButton_3.setText("\u8FD4\u56DE");
		
		Button backButton_4 = new Button(composite_5, SWT.NONE);
		backButton_4.setFont(SWTResourceManager.getFont("宋体", 12, SWT.NORMAL));
		backButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite_5.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		backButton_4.setBounds(1250, 50, 100, 40);
		backButton_4.setText("\u8FD4\u56DE");
		
		final Combo combo_8 = new Combo(composite_5, SWT.NONE);//选择场均数据/总数据 球队
		combo_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo_8.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.BOLD));
		combo_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_8.getText().equals("场均数据")){
					teamDataTable.removeAll();
					ServiceImp si=new ServiceImp();	
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.All);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable3(t,1);
				}else if(combo_8.getText().equals("总数据")){
					teamDataTable.removeAll();
					ServiceImp si=new ServiceImp();	
					teamCondition tc=new teamCondition();
					tc.setTeampartion(teamPartion.All);
					ArrayList<teamInfoVO> t=si.getTeamInfo(tc);
					writeTable3(t,0);
					
					
				}
				
				
			}
		});
		combo_8.setBounds(500, 170, 150, 32);
		combo_8.setText("\u603B\u6570\u636E");
		combo_8.add("总数据");
		combo_8.setData("0", "总数据");
		combo_8.add("场均数据");
		combo_8.setData("1", "场均数据");
		
		teamDataTable = new Table(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		teamDataTable.setFont(SWTResourceManager.getFont("Microsoft YaHei UI Light", 12, SWT.BOLD));
		teamDataTable.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		teamDataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_NONE);
				composite_5.setVisible(false);
				composite_8.setVisible(true);
				TableItem[] itemList =teamDataTable.getItems();
				int listHaveChouse = teamDataTable.getSelectionIndex();		
				String firstInfo = itemList[listHaveChouse].getText(1);
				
				teamInfoVO t=new teamInfoVO();
				t.setFullName(firstInfo);
				ServiceImp si=new ServiceImp();
				teamInfoVO t2=si.getSingleTeamInfo(t);
				teamText_1.setText("球队全称："+t2.getFullName());
				teamText_2.setText("缩写："+t2.getTeamName());
				teamText_3.setText("所在地："+t2.getCity());
				teamText_4.setText("赛区："+t2.getZone());
				teamText_5.setText("分区："+t2.getSubarea());
				teamText_6.setText("主场："+t2.getHomeCourt());
				teamText_7.setText("建立时间："+t2.getCreateTime());
				
				Image image=SWTResourceManager.getImage(NBAQuerySystemUI.class, "/presentation/image/teams/"+t2.getTeamName()+".jpg");
				final Rectangle bounds=image.getBounds();
				composite_9.setBounds(100, 200, bounds.width, bounds.height);					
				composite_9.setBackgroundImage(image);
			
				
			}
		});
		teamDataTable.setLocation(420, 250);
		teamDataTable.setSize(950, 550);
		teamDataTable.setHeaderVisible(true);
		teamDataTable.setLinesVisible(true);
		final int item2[] =new int[30] ;
		for(int i=0;i<30;i++){
			item2[i]=0;
		}
		
		TableColumn teamDataTableColumn_1 = new TableColumn(teamDataTable, SWT.NONE);//排名
		teamDataTableColumn_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		teamDataTableColumn_1.setWidth(65);
		teamDataTableColumn_1.setText("\u6392\u540D");
		
		TableColumn teamDataTableColumn_2 = new TableColumn(teamDataTable, SWT.NONE);//球队名称
		teamDataTableColumn_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		teamDataTableColumn_2.setWidth(130);
		teamDataTableColumn_2.setText("\u7403\u961F\u540D\u79F0");
		
		TableColumn teamDataTableColumn_3 = new TableColumn(teamDataTable, SWT.NONE);//比赛场次
		teamDataTableColumn_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				item2[2]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFieldGoalsMade(team.get(i).getFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFieldGoalsAttempted(team.get(i).getFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsMade(team.get(i).getThreePointFieldGoalsMade()/team.get(i).getGamesPlayed());
						team.get(i).setThreePointFieldGoalsAttempted(team.get(i).getThreePointFieldGoalsAttempted()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsMade(team.get(i).getFreeThrowsMade()/team.get(i).getGamesPlayed());
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_3.setWidth(100);
		teamDataTableColumn_3.setText("\u6BD4\u8D5B\u573A\u6570");
		
		TableColumn teamDataTableColumn_4 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[3]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_4.setWidth(130);
		teamDataTableColumn_4.setText("\u6295\u7BEE\u547D\u4E2D\u6570");
		
		TableColumn teamDataTableColumn_5 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[4]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){	
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_5.setWidth(130);
		teamDataTableColumn_5.setText("\u6295\u7BEE\u51FA\u624B\u6570");
		
		TableColumn teamDataTableColumn_6 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[5]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_6.setWidth(130);
		teamDataTableColumn_6.setText("\u4E09\u5206\u547D\u4E2D\u6570");
		
		TableColumn teamDataTableColumn_7 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[6]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_7.setWidth(130);
		teamDataTableColumn_7.setText("\u4E09\u5206\u51FA\u624B\u6570");
		
		TableColumn teamDataTableColumn_8 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[7]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_8.setWidth(130);
		teamDataTableColumn_8.setText("\u7F5A\u7403\u547D\u4E2D\u6570");
		
		TableColumn teamDataTableColumn_9 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[8]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){	
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_9.setWidth(130);
		teamDataTableColumn_9.setText("\u7F5A\u7403\u51FA\u624B\u6570");
		
		TableColumn teamDataTableColumn_10 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[9]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_10.setWidth(130);
		teamDataTableColumn_10.setText("\u8FDB\u653B\u7BEE\u677F\u6570");
		
		TableColumn teamDataTableColumn_11 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[10]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){			
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_11.setWidth(130);
		teamDataTableColumn_11.setText("\u9632\u5B88\u7BEE\u677F\u6570");
		
		TableColumn teamDataTableColumn_12 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[11]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_12.setWidth(100);
		teamDataTableColumn_12.setText("\u7BEE\u677F\u6570");
		
		TableColumn teamDataTableColumn_13 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[12]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){	
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_13.setWidth(100);
		teamDataTableColumn_13.setText("\u52A9\u653B\u6570");
		
		TableColumn teamDataTableColumn_14 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[13]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_14.setWidth(100);
		teamDataTableColumn_14.setText("\u62A2\u65AD\u6570");
		
		TableColumn teamDataTableColumn_15 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[14]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){	
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_15.setWidth(100);
		teamDataTableColumn_15.setText("\u76D6\u5E3D\u6570");
		
		TableColumn teamDataTableColumn_16 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[15]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_16.setWidth(100);
		teamDataTableColumn_16.setText("\u5931\u8BEF\u6570");
		
		TableColumn teamDataTableColumn_17 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[16]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_17.setWidth(100);
		teamDataTableColumn_17.setText("\u72AF\u89C4\u6570");
		
		TableColumn teamDataTableColumn_18 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[17]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){	
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				teamDataTable.removeAll();	
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
		teamDataTableColumn_18.setWidth(110);
		teamDataTableColumn_18.setText("\u6BD4\u8D5B\u5F97\u5206");
		
		TableColumn teamDataTableColumn_19 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_19.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[18]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_19.setWidth(130);
		teamDataTableColumn_19.setText("\u6295\u7BEE\u547D\u4E2D\u7387");
		
		TableColumn teamDataTableColumn_20 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[19]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				teamDataTable.removeAll();	
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
		teamDataTableColumn_20.setWidth(130);
		teamDataTableColumn_20.setText("\u4E09\u5206\u547D\u4E2D\u7387");
		
		TableColumn teamDataTableColumn_21 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[20]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				teamDataTable.removeAll();	
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
		teamDataTableColumn_21.setWidth(100);
		teamDataTableColumn_21.setText("\u7F5A\u7403\u547D\u4E2D\u7387");
		
		TableColumn teamDataTableColumn_22 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[21]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				teamDataTable.removeAll();	
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
		teamDataTableColumn_22.setWidth(70);
		teamDataTableColumn_22.setText("\u80DC\u7387");
		
		TableColumn teamDataTableColumn_23 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[22]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){	
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				teamDataTable.removeAll();	
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
		teamDataTableColumn_23.setWidth(110);
		teamDataTableColumn_23.setText("\u8FDB\u653B\u56DE\u5408");
		
		TableColumn teamDataTableColumn_24 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[23]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_24.setWidth(110);
		teamDataTableColumn_24.setText("\u8FDB\u653B\u6548\u7387");
		
		TableColumn teamDataTableColumn_25 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_25.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[24]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_25.setWidth(110);
		teamDataTableColumn_25.setText("\u9632\u5B88\u6548\u7387");
		
		TableColumn teamDataTableColumn_26 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_26.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[25]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){	
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_26.setWidth(150);
		teamDataTableColumn_26.setText("\u8FDB\u653B\u7BEE\u677F\u6548\u7387");
		
		TableColumn teamDataTableColumn_27 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_27.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[26]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_27.setWidth(150);
		teamDataTableColumn_27.setText("\u9632\u5B88\u7BEE\u677F\u6548\u7387");
		
		TableColumn teamDataTableColumn_28 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_28.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[27]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){	
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_28.setWidth(100);
		teamDataTableColumn_28.setText("\u62A2\u65AD\u6548\u7387");
		
		TableColumn teamDataTableColumn_29 = new TableColumn(teamDataTable, SWT.NONE);
		teamDataTableColumn_29.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				item2[28]++;
				ServiceImp si=new ServiceImp();
				teamCondition t=new teamCondition();
				t.setTeampartion(teamPartion.All);
				ArrayList<teamInfoVO> team=si.getTeamInfo(t);
				if(combo_8.getText().equals("场均数据")){
					for(int i=0;i<team.size();i++){		
						team.get(i).setFreeThrowsAttempted(team.get(i).getFreeThrowsAttempted()/team.get(i).getGamesPlayed());
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
				
				teamDataTable.removeAll();	
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
		teamDataTableColumn_29.setWidth(100);
		teamDataTableColumn_29.setText("\u52A9\u653B\u7387");
		
		composite_6 = new Composite(shell, SWT.NONE);
		composite_6.setTouchEnabled(true);
		composite_6.setSize(1440, 900);
		composite_6.setVisible(false);
		composite_6.setBackgroundMode(SWT.INHERIT_DEFAULT);
			
		
		Button backButton_5 = new Button(composite_6, SWT.NONE);
		backButton_5.setText("\u8FD4\u56DE");
		backButton_5.setBounds(1262, 21, 98, 30);
		backButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setBackgroundMode(SWT.INHERIT_FORCE);
				composite_6.setVisible(false);
				composite_1.setVisible(true);
			}
		});
		
		
		playerText_1 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_1.setBounds(740, 140, 350, 50);
		playerText_1.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_2 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_2.setBounds(740, 200, 350, 50);
		playerText_2.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_3 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_3.setBounds(740, 260, 350, 50);
		playerText_3.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_4 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_4.setBounds(740, 320, 350, 50);
		playerText_4.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_5 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_5.setBounds(740, 380, 350,50);
		playerText_5.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_6 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_6.setBounds(740, 440, 350, 50);
		playerText_6.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_7 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_7.setBounds(740, 500, 350, 50);
		playerText_7.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_8 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_8.setBounds(740, 560,350, 50);
		playerText_8.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_9 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_9.setBounds(740, 620, 350, 50);
		playerText_9.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		playerText_10 = new Text(composite_6, SWT.BORDER | SWT.READ_ONLY);
		playerText_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		playerText_10.setBounds(740, 680, 350, 50);	
		playerText_10.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		composite_8 = new Composite(shell, SWT.NONE);
		composite_8.setSize(1440, 900);
		composite_8.setVisible(false);
		composite_8.setBackgroundMode(SWT.INHERIT_NONE);
			
		
		Button backButton_6 = new Button(composite_8, SWT.NONE);
		backButton_6.setText("\u8FD4\u56DE");
		backButton_6.setBounds(1262, 21, 98, 30);
		backButton_6.addSelectionListener(new SelectionAdapter() {
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
		teamText_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		teamText_1.setBounds(740, 140, 350, 50);
		teamText_1.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		teamText_2 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		teamText_2.setBounds(740, 220, 350, 50);
		teamText_2.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		teamText_3 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		teamText_3.setBounds(740, 300, 350, 50);
		teamText_3.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		teamText_4 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		teamText_4.setBounds(740, 380, 350, 50);
		teamText_4.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		teamText_5 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		teamText_5.setBounds(740, 460, 350, 50);
		teamText_5.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		teamText_6 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		teamText_6.setBounds(740, 540, 350, 50);
		teamText_6.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		teamText_7 = new Text(composite_8, SWT.BORDER | SWT.READ_ONLY);
		teamText_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		teamText_7.setBounds(740, 620, 350, 50);
		teamText_7.setFont(SWTResourceManager.getFont("方正舒体", 16, SWT.BOLD));
		
		composite_7 = new Composite(composite_6, SWT.NONE);
		}
}

