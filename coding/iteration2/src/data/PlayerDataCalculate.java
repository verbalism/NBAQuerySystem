package data;
import java.util.Date;
import java.util.ArrayList;
import java.io.File;
import java.sql.*;

import po.BasicPlayerPO;
import po.MatchPlayer;
import po.PlayerPO;

public class PlayerDataCalculate {
	public void saveBasicInfo() throws Exception {
		File directory = new File("");
		String courseFile = directory.getCanonicalPath() ;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
  
		BasicPlayerData BPD=new BasicPlayerData();
		ArrayList<BasicPlayerPO> BPP=BPD.getPlayerOriginal();
		for(int i=0;i<BPP.size();i++){
			String sql = "insert into playerInfo (playerName,playerNumber,position,height,weight,birth,age,exp,school) values(?,?,?,?,?,?,?,?,?)";
	        PreparedStatement pstmt;
		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
		    pstmt.setString(1, BPP.get(i).getName());
		    pstmt.setString(2, BPP.get(i).getNumber());
		    pstmt.setString(3, BPP.get(i).getPosition());
		    pstmt.setString(4, BPP.get(i).getHeight());
		    pstmt.setString(5, BPP.get(i).getWeight());
		    pstmt.setString(6, BPP.get(i).getBirth());
		    pstmt.setString(7, BPP.get(i).getAge());
		    pstmt.setString(8, BPP.get(i).getExp());
		    pstmt.setString(9, BPP.get(i).getSchool());
		    pstmt.executeUpdate();
		    pstmt.close();
		}
		conn.close();
	}//输入基本信息
	
	public boolean isExist(String name) throws Exception {
		
		File directory = new File("");
		String courseFile = directory.getCanonicalPath() ;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
        
        name=name.replace("'","''");
        String sql = "select * from playerInfo where playerName='" + name + "'";
        PreparedStatement pstmt;
        pstmt = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean result=false;
        if(rs.next())
        	result=true;
        rs.close();
        pstmt.close();
        conn.close();
		return result;
	}//判断playerInfo中是否存在该球员
	
	public void updatePlayerInfoBySingleMatch(int ID) throws Exception {
		File directory = new File("");
		String courseFile = directory.getCanonicalPath() ;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
        
        Statement stmt=conn.createStatement();
        
        String sql = "select * from playerMatchInfo where generalMatch=" + ID;
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList<MatchPlayer> mp1=new ArrayList<MatchPlayer>();
        ArrayList<MatchPlayer> mp2=new ArrayList<MatchPlayer>();
        String temp1="";
        String temp2="";
        while(rs.next()){
            MatchPlayer mp=new MatchPlayer();
        	mp.setPlayerName(rs.getString("playerName"));
        	mp.setPosition(rs.getString("position"));
        	mp.setMatchTime(rs.getString("matchTime"));
        	mp.setFieldGoal(rs.getInt("fieldGoal"));
        	mp.setFieldGoalAttempts(rs.getInt("fieldGoalAttempts"));
        	mp.setThreePointShot(rs.getInt("threepointShot"));
        	mp.setThreePointAttempts(rs.getInt("threepointAttempts"));
        	mp.setFreeThrowGoal(rs.getInt("freeThrowGoal"));
        	mp.setFreeThrowAttempts(rs.getInt("freeThrowAttempts"));
        	mp.setOffensiveRebound(rs.getInt("offensiveRebound"));
        	mp.setDefensiveRebound(rs.getInt("defensiveRebound"));
        	mp.setRebound(rs.getInt("rebound"));
        	mp.setAssist(rs.getInt("assist"));
        	mp.setST(rs.getInt("st"));
        	mp.setBlockShot(rs.getInt("blockShot"));
        	mp.setError(rs.getInt("error"));
        	mp.setFoul(rs.getInt("foul"));
        	mp.setScore(rs.getInt("score"));
        	if(temp1.equals("")){
        		temp1=rs.getString("teamName");
        		temp2=rs.getString("oppositeTeamName");
        		mp1.add(mp);
        	}else if(rs.getString("teamName").equals(temp1)){
        		mp1.add(mp);
        	}else
        		mp2.add(mp);
        }
        rs.close();

        PlayerDataCalculate pdc=new PlayerDataCalculate();
        
        
        String name;
        double gp=0;
        double gs=0;
        String t;
        double fgm=0;
        double fga=0;
        double tpfgm=0;
        double tpfga=0;
    	double ftm=0;
    	double fta=0;
    	double or=0;
    	double dr=0;
    	double r=0;
    	double a=0;
    	double s=0;
    	double b=0;
    	double tu=0;
    	double f=0;
    	double p=0;
    	String atot;
    	double arot=0;
    	double aorot=0;
    	double adrot=0;
    	double aroo=0;
    	double aoroo=0;
    	double adroo=0;
    	double afgm=0;
    	double tpfgaoo=0;
    	double tpfg=0;
    	double afgaot=0;
    	double afgao=0;
    	double ato=0;
    	double afgaoo=0;
    	double afga=0;
    	double amgoo=0;
    	double atoo=0;
    	double dd=0;
    	String time;
        for(int i=0;i<mp1.size();i++){
        	name=mp1.get(i).getPlayerName();
        	name=name.replace("'","''");
        	
        	if(pdc.isExist(mp1.get(i).getPlayerName())){
        	}else{
	    		String sql1 = "insert into playerInfo (playerName,position) values(?,?)";
	    		PreparedStatement pstmt;
	    		pstmt = (PreparedStatement) conn.prepareStatement(sql1);
	    		pstmt.setString(1, mp1.get(i).getPlayerName());
	    		pstmt.setString(2, mp1.get(i).getPosition());
	    		pstmt.executeUpdate();
	    		pstmt.close();
        	}

        	ResultSet rs0=stmt.executeQuery("select * from playerInfo where playerName='"+name+"'");
        	rs0.next();   	
        	gp=rs0.getDouble("gamesPlayed");
        	gs=rs0.getDouble("gamesStarting");
        	t=rs0.getString("minutes");
        	fgm=rs0.getDouble("fieldGoalsMade");
        	fga=rs0.getDouble("fieldGoalsAttempts");
        	tpfgm=rs0.getDouble("threePointFieldGoalsMade");
        	tpfga=rs0.getDouble("threePointFieldGoalsAttempts");
        	ftm=rs0.getDouble("freeThrowsMade");
        	fta=rs0.getDouble("freeThrowsAttempts");
        	or=rs0.getDouble("offensiveRebounds");
        	dr=rs0.getDouble("defensiveRebounds");
        	r=rs0.getDouble("rebounds");
        	a=rs0.getDouble("assists");
        	s=rs0.getDouble("steals");
        	b=rs0.getDouble("blocks");
        	tu=rs0.getDouble("turnovers");
        	f=rs0.getDouble("fouls");
        	p=rs0.getDouble("points");
        	atot=rs0.getString("allTimeOfTeam");
        	arot=rs0.getDouble("allReboundsOfTeam");
        	aorot=rs0.getDouble("allOffensiveReboundsOfTeam");
        	adrot=rs0.getDouble("allDefensiveReboundsOfTeam");
        	aroo=rs0.getDouble("allReboundsOfOpposite");
        	aoroo=rs0.getDouble("allOffensiveReboundsOfOpposite");
        	adroo=rs0.getDouble("allDefensiveReboundsOfOpposite");
        	afgm=rs0.getDouble("allFieldGoalsMade");
        	tpfgaoo=rs0.getDouble("twoPointFieldGoalsAttemptsOfOpposite");
        	tpfg=rs0.getDouble("twoPointFieldGoalsAttempts");
        	afgaot=rs0.getDouble("allFieldGoalsAttemptsOfTeam");
        	afgao=rs0.getDouble("allFreeGoalsAttemptsOfTeam");
        	ato=rs0.getDouble("allturnoversOfTeam");
        	afgaoo=rs0.getDouble("allFieldGoalsAttemptsOfOpposite");
        	afga=rs0.getDouble("allFreeGoalsAttemptsOfOpposite");
        	amgoo=rs0.getDouble("allMissedGoalsOfOpposite");
        	atoo=rs0.getDouble("allturnoversOfOpposite");
        	dd=rs0.getDouble("doubleDouble");      	
        	rs0.close();
        	
        	gp=gp+1;
        	stmt.executeUpdate("update playerInfo set gamesPlayed='"+gp+"' where playerName='" +name+ "'");
        	
        	if(mp1.get(i).getPosition()!=null && !mp1.get(i).getPosition().equals("")){
        		gs=gs+1;
        		stmt.executeUpdate("update playerInfo set gamesStarting='"+gs+"' where playerName='" +name+ "'");
        	}
        	
        	stmt.executeUpdate("update playerInfo set teamName='"+temp1+"' where playerName='" +name+ "'");
        	
        	time=pdc.calTime(mp1.get(i).getMatchTime(), t);
        	stmt.executeUpdate("update playerInfo set minutes='"+time+"' where playerName='" +name+ "'");
        	
        	fgm=fgm+mp1.get(i).getFieldGoal();
        	stmt.executeUpdate("update playerInfo set fieldGoalsMade='"+fgm+"' where playerName='" +name+ "'");
        	
        	fga=fga+mp1.get(i).getFieldGoalAttempts();
        	stmt.executeUpdate("update playerInfo set fieldGoalsAttempts='"+fga+"' where playerName='" +name+ "'");
        	
        	tpfgm=tpfgm+mp1.get(i).getThreePointShot();
        	stmt.executeUpdate("update playerInfo set threePointFieldGoalsMade='"+tpfgm+"' where playerName='" +name+ "'");
        	
        	tpfga=tpfga+mp1.get(i).getThreePointAttempts();
        	stmt.executeUpdate("update playerInfo set threePointFieldGoalsAttempts='"+tpfga+"' where playerName='" +name+ "'");
        	
        	ftm=ftm+mp1.get(i).getFreeThrowGoal();
        	stmt.executeUpdate("update playerInfo set freeThrowsMade='"+ftm+"' where playerName='" +name+ "'");
        	
        	fta=fta+mp1.get(i).getFreeThrowAttempts();
        	stmt.executeUpdate("update playerInfo set freeThrowsAttempts='"+fga+"' where playerName='" +name+ "'");
        	
        	or=or+mp1.get(i).getOffensiveRebound();
        	stmt.executeUpdate("update playerInfo set offensiveRebounds='"+or+"' where playerName='" +name+ "'");
        	
        	dr=dr+mp1.get(i).getDefensiveRebound();
        	stmt.executeUpdate("update playerInfo set defensiveRebounds='"+dr+"' where playerName='" +name+ "'");
        	
        	r=r+mp1.get(i).getRebound();
        	stmt.executeUpdate("update playerInfo set rebounds='"+r+"' where playerName='" +name+ "'");
        	
        	a=a+mp1.get(i).getAssist();
        	stmt.executeUpdate("update playerInfo set assists='"+fga+"' where playerName='" +name+ "'");
        	
        	s=s+mp1.get(i).getST();
        	stmt.executeUpdate("update playerInfo set steals='"+s+"' where playerName='" +name+ "'");
        	
        	b=b+mp1.get(i).getBlockShot();
        	stmt.executeUpdate("update playerInfo set blocks='"+b+"' where playerName='" +name+ "'");
        	
        	tu=tu+mp1.get(i).getError();
        	stmt.executeUpdate("update playerInfo set turnovers='"+tu+"' where playerName='" +name+ "'");
        	
        	f=f+mp1.get(i).getFoul();
        	stmt.executeUpdate("update playerInfo set fouls='"+f+"' where playerName='" +name+ "'");
        	
        	p=p+mp1.get(i).getScore();
        	stmt.executeUpdate("update playerInfo set points='"+p+"' where playerName='" +name+ "'");
        	
        	tpfg=tpfg+mp1.get(i).getFieldGoalAttempts()-mp1.get(i).getThreePointAttempts();
        	stmt.executeUpdate("update playerInfo set twoPointFieldGoalsAttempts='"+tpfg+"' where playerName='" +name+ "'");
        	
        	for(int j=0;j<mp1.size();j++){
        		atot=pdc.calTime(atot, mp1.get(j).getMatchTime());
        		arot=arot+mp1.get(j).getRebound();
        		aorot=aorot+mp1.get(j).getOffensiveRebound();
        		adrot=adrot+mp1.get(j).getDefensiveRebound();
        		afgm=afgm+mp1.get(j).getFieldGoal();
        		afgaot=afgaot+mp1.get(j).getFieldGoalAttempts();
        		afgao=afgao+mp1.get(j).getFreeThrowAttempts();
        		ato=ato+mp1.get(j).getError();
        		
        	}
        	for(int j=0;j<mp2.size();j++){
        		aroo=aroo+mp2.get(j).getRebound();
        		aoroo=aoroo+mp2.get(j).getOffensiveRebound();
        		adroo=adroo+mp2.get(j).getDefensiveRebound();
        		tpfgaoo=tpfgaoo+mp2.get(j).getFieldGoalAttempts()-mp2.get(j).getThreePointAttempts();
        		afgaoo=afgaoo+mp2.get(j).getFieldGoalAttempts();
        		afga=afga+mp2.get(j).getFreeThrowAttempts();
        		amgoo=amgoo+mp2.get(j).getFieldGoalAttempts()-mp2.get(j).getFieldGoal();
        		atoo=atoo+mp2.get(j).getError();
            	
        	}
        	stmt.executeUpdate("update playerInfo set allTimeOfTeam='"+atot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allReboundsOfTeam='"+arot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allOffensiveReboundsOfTeam='"+aorot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allDefensiveReboundsOfTeam='"+adrot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allReboundsOfOpposite='"+aroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allOffensiveReboundsOfOpposite='"+aoroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allDefensiveReboundsOfOpposite='"+adroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsMade='"+afgm+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set twoPointFieldGoalsAttemptsOfOpposite='"+tpfgaoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsAttemptsOfTeam='"+afgaot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFreeGoalsAttemptsOfTeam='"+afgao+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allturnoversOfTeam='"+ato+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsAttemptsOfOpposite='"+afgaoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFreeGoalsAttemptsOfOpposite='"+afga+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allMissedGoalsOfOpposite='"+amgoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allturnoversOfOpposite='"+atoo+"' where playerName='" +name+ "'");
        	
        	if((mp1.get(i).getScore()>=10&&mp1.get(i).getAssist()>=10) || (mp1.get(i).getScore()>=10&&mp1.get(i).getRebound()>=10) 
					|| (mp1.get(i).getScore()>=10&&mp1.get(i).getST()>=10) || (mp1.get(i).getScore()>=10&&mp1.get(i).getBlockShot()>=10) 
					|| (mp1.get(i).getAssist()>=10&&mp1.get(i).getBlockShot()>=10) || (mp1.get(i).getAssist()>=10&&mp1.get(i).getRebound()>=10) 
					|| (mp1.get(i).getAssist()>=10&&mp1.get(i).getST()>=10) || (mp1.get(i).getST()>=10&&mp1.get(i).getBlockShot()>=10) 
					|| (mp1.get(i).getST()>=10&&mp1.get(i).getRebound()>=10) || (mp1.get(i).getRebound()>=10&&mp1.get(i).getBlockShot()>=10)){
        		dd=dd+1;
        	}
        	stmt.executeUpdate("update playerInfo set doubleDouble='"+dd+"' where playerName='" +name+ "'");
        	
        }

        for(int i=0;i<mp2.size();i++){
        	name=mp2.get(i).getPlayerName();
        	name=name.replace("'","''");
        	
        	if(pdc.isExist(mp2.get(i).getPlayerName())){
        	}else{
	    		String sql1 = "insert into playerInfo (playerName,position) values(?,?)";
	    		PreparedStatement pstmt;
	    		pstmt = (PreparedStatement) conn.prepareStatement(sql1);
	    		pstmt.setString(1, mp2.get(i).getPlayerName());
	    		pstmt.setString(2, mp2.get(i).getPosition());
	    		pstmt.executeUpdate();
	    		pstmt.close();
        	}

        	ResultSet rs0=stmt.executeQuery("select * from playerInfo where playerName='"+name+"'");
        	rs0.next();   	
        	gp=rs0.getDouble("gamesPlayed");
        	gs=rs0.getDouble("gamesStarting");
        	t=rs0.getString("minutes");
        	fgm=rs0.getDouble("fieldGoalsMade");
        	fga=rs0.getDouble("fieldGoalsAttempts");
        	tpfgm=rs0.getDouble("threePointFieldGoalsMade");
        	tpfga=rs0.getDouble("threePointFieldGoalsAttempts");
        	ftm=rs0.getDouble("freeThrowsMade");
        	fta=rs0.getDouble("freeThrowsAttempts");
        	or=rs0.getDouble("offensiveRebounds");
        	dr=rs0.getDouble("defensiveRebounds");
        	r=rs0.getDouble("rebounds");
        	a=rs0.getDouble("assists");
        	s=rs0.getDouble("steals");
        	b=rs0.getDouble("blocks");
        	tu=rs0.getDouble("turnovers");
        	f=rs0.getDouble("fouls");
        	p=rs0.getDouble("points");
        	atot=rs0.getString("allTimeOfTeam");
        	arot=rs0.getDouble("allReboundsOfTeam");
        	aorot=rs0.getDouble("allOffensiveReboundsOfTeam");
        	adrot=rs0.getDouble("allDefensiveReboundsOfTeam");
        	aroo=rs0.getDouble("allReboundsOfOpposite");
        	aoroo=rs0.getDouble("allOffensiveReboundsOfOpposite");
        	adroo=rs0.getDouble("allDefensiveReboundsOfOpposite");
        	afgm=rs0.getDouble("allFieldGoalsMade");
        	tpfgaoo=rs0.getDouble("twoPointFieldGoalsAttemptsOfOpposite");
        	tpfg=rs0.getDouble("twoPointFieldGoalsAttempts");
        	afgaot=rs0.getDouble("allFieldGoalsAttemptsOfTeam");
        	afgao=rs0.getDouble("allFreeGoalsAttemptsOfTeam");
        	ato=rs0.getDouble("allturnoversOfTeam");
        	afgaoo=rs0.getDouble("allFieldGoalsAttemptsOfOpposite");
        	afga=rs0.getDouble("allFreeGoalsAttemptsOfOpposite");
        	amgoo=rs0.getDouble("allMissedGoalsOfOpposite");
        	atoo=rs0.getDouble("allturnoversOfOpposite");
        	dd=rs0.getDouble("doubleDouble");      	
        	rs0.close();
        	
        	gp=gp+1;
        	stmt.executeUpdate("update playerInfo set gamesPlayed='"+gp+"' where playerName='" +name+ "'");
        	
        	if(mp2.get(i).getPosition()!=null && !mp2.get(i).getPosition().equals("")){
        		gs=gs+1;
        		stmt.executeUpdate("update playerInfo set gamesStarting='"+gs+"' where playerName='" +name+ "'");
        	}
        	
        	stmt.executeUpdate("update playerInfo set teamName='"+temp2+"' where playerName='" +name+ "'");
        	
        	time=pdc.calTime(mp2.get(i).getMatchTime(), t);
        	stmt.executeUpdate("update playerInfo set minutes='"+time+"' where playerName='" +name+ "'");
        	
        	fgm=fgm+mp2.get(i).getFieldGoal();
        	stmt.executeUpdate("update playerInfo set fieldGoalsMade='"+fgm+"' where playerName='" +name+ "'");
        	
        	fga=fga+mp2.get(i).getFieldGoalAttempts();
        	stmt.executeUpdate("update playerInfo set fieldGoalsAttempts='"+fga+"' where playerName='" +name+ "'");
        	
        	tpfgm=tpfgm+mp2.get(i).getThreePointShot();
        	stmt.executeUpdate("update playerInfo set threePointFieldGoalsMade='"+tpfgm+"' where playerName='" +name+ "'");
        	
        	tpfga=tpfga+mp2.get(i).getThreePointAttempts();
        	stmt.executeUpdate("update playerInfo set threePointFieldGoalsAttempts='"+tpfga+"' where playerName='" +name+ "'");
        	
        	ftm=ftm+mp2.get(i).getFreeThrowGoal();
        	stmt.executeUpdate("update playerInfo set freeThrowsMade='"+ftm+"' where playerName='" +name+ "'");
        	
        	fta=fta+mp2.get(i).getFreeThrowAttempts();
        	stmt.executeUpdate("update playerInfo set freeThrowsAttempts='"+fga+"' where playerName='" +name+ "'");
        	
        	or=or+mp2.get(i).getOffensiveRebound();
        	stmt.executeUpdate("update playerInfo set offensiveRebounds='"+or+"' where playerName='" +name+ "'");
        	
        	dr=dr+mp2.get(i).getDefensiveRebound();
        	stmt.executeUpdate("update playerInfo set defensiveRebounds='"+dr+"' where playerName='" +name+ "'");
        	
        	r=r+mp2.get(i).getRebound();
        	stmt.executeUpdate("update playerInfo set rebounds='"+r+"' where playerName='" +name+ "'");
        	
        	a=a+mp2.get(i).getAssist();
        	stmt.executeUpdate("update playerInfo set assists='"+fga+"' where playerName='" +name+ "'");
        	
        	s=s+mp2.get(i).getST();
        	stmt.executeUpdate("update playerInfo set steals='"+s+"' where playerName='" +name+ "'");
        	
        	b=b+mp2.get(i).getBlockShot();
        	stmt.executeUpdate("update playerInfo set blocks='"+b+"' where playerName='" +name+ "'");
        	
        	tu=tu+mp2.get(i).getError();
        	stmt.executeUpdate("update playerInfo set turnovers='"+tu+"' where playerName='" +name+ "'");
        	
        	f=f+mp2.get(i).getFoul();
        	stmt.executeUpdate("update playerInfo set fouls='"+f+"' where playerName='" +name+ "'");
        	
        	p=p+mp2.get(i).getScore();
        	stmt.executeUpdate("update playerInfo set points='"+p+"' where playerName='" +name+ "'");
        	
        	tpfg=tpfg+mp2.get(i).getFieldGoalAttempts()-mp2.get(i).getThreePointAttempts();
        	stmt.executeUpdate("update playerInfo set twoPointFieldGoalsAttempts='"+tpfg+"' where playerName='" +name+ "'");
        	
        	for(int j=0;j<mp2.size();j++){
        		atot=pdc.calTime(atot, mp2.get(j).getMatchTime());
        		arot=arot+mp2.get(j).getRebound();
        		aorot=aorot+mp2.get(j).getOffensiveRebound();
        		adrot=adrot+mp2.get(j).getDefensiveRebound();
        		afgm=afgm+mp2.get(j).getFieldGoal();
        		afgaot=afgaot+mp2.get(j).getFieldGoalAttempts();
        		afgao=afgao+mp2.get(j).getFreeThrowAttempts();
        		ato=ato+mp2.get(j).getError();
        		
        	}
        	for(int j=0;j<mp1.size();j++){
        		aroo=aroo+mp1.get(j).getRebound();
        		aoroo=aoroo+mp1.get(j).getOffensiveRebound();
        		adroo=adroo+mp1.get(j).getDefensiveRebound();
        		tpfgaoo=tpfgaoo+mp1.get(j).getFieldGoalAttempts()-mp1.get(j).getThreePointAttempts();
        		afgaoo=afgaoo+mp1.get(j).getFieldGoalAttempts();
        		afga=afga+mp1.get(j).getFreeThrowAttempts();
        		amgoo=amgoo+mp1.get(j).getFieldGoalAttempts()-mp1.get(j).getFieldGoal();
        		atoo=atoo+mp1.get(j).getError();
            	
        	}
        	stmt.executeUpdate("update playerInfo set allTimeOfTeam='"+atot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allReboundsOfTeam='"+arot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allOffensiveReboundsOfTeam='"+aorot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allDefensiveReboundsOfTeam='"+adrot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allReboundsOfOpposite='"+aroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allOffensiveReboundsOfOpposite='"+aoroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allDefensiveReboundsOfOpposite='"+adroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsMade='"+afgm+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set twoPointFieldGoalsAttemptsOfOpposite='"+tpfgaoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsAttemptsOfTeam='"+afgaot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFreeGoalsAttemptsOfTeam='"+afgao+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allturnoversOfTeam='"+ato+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsAttemptsOfOpposite='"+afgaoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFreeGoalsAttemptsOfOpposite='"+afga+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allMissedGoalsOfOpposite='"+amgoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allturnoversOfOpposite='"+atoo+"' where playerName='" +name+ "'");
        	
        	if((mp2.get(i).getScore()>=10&&mp2.get(i).getAssist()>=10) || (mp2.get(i).getScore()>=10&&mp2.get(i).getRebound()>=10) 
					|| (mp2.get(i).getScore()>=10&&mp2.get(i).getST()>=10) || (mp2.get(i).getScore()>=10&&mp2.get(i).getBlockShot()>=10) 
					|| (mp2.get(i).getAssist()>=10&&mp2.get(i).getBlockShot()>=10) || (mp2.get(i).getAssist()>=10&&mp2.get(i).getRebound()>=10) 
					|| (mp2.get(i).getAssist()>=10&&mp2.get(i).getST()>=10) || (mp2.get(i).getST()>=10&&mp2.get(i).getBlockShot()>=10) 
					|| (mp2.get(i).getST()>=10&&mp2.get(i).getRebound()>=10) || (mp2.get(i).getRebound()>=10&&mp2.get(i).getBlockShot()>=10)){
        		dd=dd+1;
        	}
        	stmt.executeUpdate("update playerInfo set doubleDouble='"+dd+"' where playerName='" +name+ "'");
        	
        }
        stmt.close();
        conn.close();
	}//根据单场比赛ID添加信息
	
	
	
	public void calSimpleData() throws Exception{
		PlayerDataCalculate pdc=new PlayerDataCalculate();
		
		File directory = new File("");
		String courseFile = directory.getCanonicalPath() ;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password");
        
        String sql = "select * from playerInfo";
        PreparedStatement pstmt;
        pstmt = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        ArrayList<String> playerName=new ArrayList<String>();
        while(rs.next()){
        	playerName.add(rs.getString("playerName"));
        }
        rs.close();
		pstmt.close();
       
    	Statement stmt=conn.createStatement();
        for(int i=0;i<playerName.size();i++){
        	String tn="";
    		double gp=0;
    		String position;
    		double gs=0;
            double r=0;
            double rebound=0;
            double or=0;
            double dr=0;
            double a=0;
            double assist=0;
            String m="0:0";
            double fga=0;
            double fgm=0;
            double tfga=0;
            double tfgm=0;
            double frga=0;
            double frgm=0;
            double s=0;
            double steal=0;
            double b=0;
            double block=0;
            double t=0;
            double f=0;
            double p=0;
            double point=0;
            double tpfga=0;
            double dd=0;
            
            String atot="0:0";
            double arot=0;
            double aorot=0;
            double adrot=0;
            double afgm=0;
            double afgaot=0;
            double afrgaot=0;
            double atuot=0;
            
            double fieldAoo=0;
            double threeAoo=0;
            double fieldMoo=0;
            double aroo=0;
            double aoroo=0;
            double adroo=0;
            double tpfgaoo=0;
            double afgaoo=0;
            double afrgaoo=0;
            double amgoo=0;
            double atoo=0;
            

        	String name=playerName.get(i).replace("'","''");
        	
        	String sql1 = "select * from playerMatchInfo where playerName='" +name+"'";
            ResultSet rs1 = stmt.executeQuery(sql1);
        	
            
            while(rs1.next()){
            	tn=rs1.getString("teamName");
                gp=gp+1;
                position=rs1.getString("position");
                if(position!=null && !position.equals(""))
            		gs=gs+1;
                rebound=rs1.getDouble("rebound");
                r=r+rebound;
                or=or+rs1.getDouble("offensiveRebound");
                dr=dr+rs1.getDouble("defensiveRebound");
                assist=rs1.getDouble("assist");
                a=a+assist;
                m=pdc.calTime(m,rs1.getString("matchTime"));
                fga=fga+rs1.getDouble("fieldGoalAttempts");
                fgm=fgm+rs1.getDouble("fieldGoal");
                tfga=tfga+rs1.getDouble("threePointAttempts");
                tfgm=tfgm+rs1.getDouble("threePointShot");
                frga=frga+rs1.getDouble("freeThrowAttempts");
                frgm=frgm+rs1.getDouble("freeThrowGoal");
                steal=rs1.getDouble("st");
                s=s+steal;
                block=rs1.getDouble("blockShot");
                b=b+block;
                t=t+rs1.getDouble("error");
                f=f+rs1.getDouble("foul");
                point=rs1.getDouble("score");
                p=p+point;
                if((point>=10 && assist>=10) || (point>=10 && rebound>=10)
                		 || (point>=10 && block>=10) || (point>=10 && steal>=10)
                		 || (block>=10 && assist>=10) || (rebound>=10 && steal>=10)
                		 || (steal>=10 && assist>=10) || (block>=10 && steal>=10)
                		 || (rebound>=10 && assist>=10) || (block>=10 && rebound>=10))
                	dd=dd+1;
                	
            }
            tpfga=fga-tfga;
            rs1.close();
            
    
	            String sql2 = "select * from playerMatchInfo where generalMatch in (select generalMatch from playerMatchInfo where playerName='"+name+"') and teamName in (select teamName from playerMatchInfo where playerName='"+name+"')";
	            ResultSet rs2 = stmt.executeQuery(sql2);
	            
	            while(rs2.next()){
	            	atot=pdc.calTime(atot, rs2.getString("matchTime"));
	            	arot=arot+rs2.getDouble("rebound");
	            	aorot=aorot+rs2.getDouble("offensiveRebound");
	            	adrot=adrot+rs2.getDouble("defensiveRebound");
	            	afgm=afgm+rs2.getDouble("fieldGoal");
	            	afgaot=afgaot+rs2.getDouble("fieldGoalAttempts");
	            	afrgaot=afrgaot+rs2.getDouble("freeThrowAttempts");
	            	atuot=atuot+rs2.getDouble("error");
	            }
	            rs2.close();

	            String sql3 = "select * from playerMatchInfo where generalMatch in (select generalMatch from playerMatchInfo where playerName='"+name+"') and oppositeTeamName in (select teamName from playerMatchInfo where playerName='"+name+"')";
	            ResultSet rs3 = stmt.executeQuery(sql3);
	            while(rs3.next()){
	            		fieldAoo=rs3.getDouble("fieldGoalAttempts");
	            		threeAoo=rs3.getDouble("threepointAttempts");
	            		fieldMoo=rs3.getDouble("fieldGoal");
	            		aroo=aroo+rs3.getDouble("rebound");
	            		aoroo=aoroo+rs3.getDouble("offensiveRebound");
	            		adroo=adroo+rs3.getDouble("defensiveRebound");
	            		tpfgaoo=tpfgaoo+fieldAoo-threeAoo;
	            		afgaoo=afgaoo+fieldAoo;
	            		afrgaoo=afrgaoo+rs3.getDouble("freeThrowAttempts");
	            		amgoo=amgoo+fieldAoo-fieldMoo;
	            		atoo=atoo+rs3.getDouble("error");
	            	
	            }
	            rs3.close();

	        stmt.executeUpdate("update playerInfo set teamName='"+tn+"' where playerName='" +name+ "'");    
        	stmt.executeUpdate("update playerInfo set gamesPlayed='"+gp+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set gamesStarting='"+gs+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set rebounds='"+r+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set offensiveRebounds='"+or+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set defensiveRebounds='"+dr+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set assists='"+a+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set minutes='"+m+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set fieldGoalsAttempts='"+fga+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set fieldGoalsMade='"+fgm+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set threePointFieldGoalsAttempts='"+tfga+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set threePointFieldGoalsMade='"+tfgm+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set freeThrowsAttempts='"+frga+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set freeThrowsMade='"+frgm+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set steals='"+s+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set blocks='"+b+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set turnovers='"+t+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set fouls='"+f+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set points='"+p+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set doubleDouble='"+dd+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allTimeOfTeam='"+atot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allReboundsOfTeam='"+arot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allOffensiveReboundsOfTeam='"+aorot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set alldefensiveReboundsOfTeam='"+adrot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allReboundsOfOpposite='"+aroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allOffensiveReboundsOfOpposite='"+aoroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set alldefensiveReboundsOfOpposite='"+adroo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsMade='"+afgm+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set twoPointFieldGoalsAttemptsOfOpposite='"+tpfgaoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set twoPointFieldGoalsAttempts='"+tpfga+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsAttemptsOfTeam='"+afgaot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFreeGoalsAttemptsOfTeam='"+afrgaot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allturnoversOfTeam='"+atuot+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFieldGoalsAttemptsOfOpposite='"+afgaoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allFreeGoalsAttemptsOfOpposite='"+afrgaoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allMissedGoalsOfOpposite='"+amgoo+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set allturnoversOfOpposite='"+atoo+"' where playerName='" +name+ "'");
        	
        	
        }
        stmt.close();
        conn.close();
		
	}//添加基本信息
	
	public void calComplexData(int matchID) throws Exception{

		PlayerDataCalculate pdc=new PlayerDataCalculate();
		
		File directory = new File("");
		String courseFile = directory.getCanonicalPath();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
        
        Statement stmt=conn.createStatement();
        
        String sql = "select * from playerInfo where playerName in (select playerName from playerMatchInfo where generalMatch="+matchID+")";
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList<PlayerPO> pp=new ArrayList<PlayerPO>();
        while(rs.next()){
        	PlayerPO p=new PlayerPO();
        	p.setPlayerName(rs.getString("playerName"));
        	p.setRebounds(rs.getDouble("rebounds"));
        	p.setOffensiveRebounds(rs.getDouble("offensiveRebounds"));
        	p.setDefensiveRebounds(rs.getDouble("defensiveRebounds"));
        	p.setAssists(rs.getDouble("assists"));
        	p.setMinutes(rs.getString("minutes"));
        	p.setFieldGoalsAttempts(rs.getDouble("fieldGoalsAttempts"));
        	p.setFieldGoalsMade(rs.getDouble("fieldGoalsMade"));
        	p.setThreePointFieldGoalsAttempts(rs.getDouble("threePointFieldGoalsAttempts"));
        	p.setThreePointFieldGoalsMade(rs.getDouble("threePointFieldGoalsMade"));
        	p.setFreeThrowsAttempts(rs.getDouble("freeThrowsAttempts"));
        	p.setFreeThrowsMade(rs.getDouble("freeThrowsMade"));
        	p.setSteals(rs.getDouble("steals"));
        	p.setBlocks(rs.getDouble("blocks"));
        	p.setTurnovers(rs.getDouble("turnovers"));
        	p.setFouls(rs.getDouble("fouls"));
        	p.setPoints(rs.getDouble("points"));
        	p.setAllTimeOfTeam(rs.getString("allTimeOfTeam"));
        	p.setAllReboundsOfTeam(rs.getDouble("allReboundsOfTeam"));
        	p.setAlldefensiveReboundsOfTeam(rs.getDouble("alldefensiveReboundsOfTeam"));
        	p.setAllOffensiveReboundsOfTeam(rs.getDouble("allOffensiveReboundsOfTeam"));
        	p.setAllReboundsOfOpposite(rs.getDouble("allReboundsOfOpposite"));
        	p.setAlldefensiveReboundsOfOpposite(rs.getDouble("alldefensiveReboundsOfOpposite"));
        	p.setAllOffensiveReboundsOfOpposite(rs.getDouble("allOffensiveReboundsOfOpposite"));
        	p.setAllFieldGoalsMade(rs.getDouble("allFieldGoalsMade"));
        	p.setTwoPointFieldGoalsAttempts(rs.getDouble("twoPointFieldGoalsAttempts"));
        	p.setTwoPointFieldGoalsAttemptsOfOpposite(rs.getDouble("twoPointFieldGoalsAttemptsOfOpposite"));
        	p.setAllFieldGoalsAttemptsOfTeam(rs.getDouble("allFieldGoalsAttemptsOfTeam"));
        	p.setAllFreeGoalsAttemptsOfTeam(rs.getDouble("allFreeGoalsAttemptsOfTeam"));
        	p.setAllturnoversOfTeam(rs.getDouble("allturnoversOfTeam"));
        	p.setAllFieldGoalsAttemptsOfOpposite(rs.getDouble("allFieldGoalsAttemptsOfOpposite"));
        	p.setAllFreeGoalsAttemptsOfOpposite(rs.getDouble("allFreeGoalsAttemptsOfOpposite"));
        	p.setAllMissedGoalsOfOpposite(rs.getDouble("allMissedGoalsOfOpposite"));
        	p.setAllturnoversOfOpposite(rs.getDouble("allTurnoversOfOpposite"));
        	pp.add(p);
        }
        rs.close();
        
        double fgp=0;
        double tpfgp=0;
        double ftgp=0;
        double e=0;
        double GmSc=0;
    	double tsp=0;
    	double se=0;
    	double time=0;
    	double allTime=0;
    	double rr=0;
    	double orr=0;
    	double drr=0;
    	double ar=0;
    	double adoo=0;
    	double sr=0;
    	double br=0;
    	double tr=0;
    	double ur=0;
    	String name;
        for(int i=0;i<pp.size();i++){
        	name=pp.get(i).getPlayerName();
        	name=name.replace("'","''");
        	
        	if(pp.get(i).getFieldGoalsAttempts()!=0)
        		fgp=pp.get(i).getFieldGoalsMade()/pp.get(i).getFieldGoalsAttempts();
        	//计算投篮命中率
        	
        	
        	if(pp.get(i).getThreePointFieldGoalsAttempts()!=0)
        		tpfgp=pp.get(i).getThreePointFieldGoalsMade()/pp.get(i).getThreePointFieldGoalsAttempts();
        	//计算三分命中率
        	
        	
        	if(pp.get(i).getFreeThrowsAttempts()!=0)
        		ftgp=pp.get(i).getFreeThrowsMade()/pp.get(i).getFreeThrowsAttempts();
        	//计算罚球命中率
        	
        	e=pp.get(i).getPoints()+pp.get(i).getBlocks()+pp.get(i).getAssists()+pp.get(i).getSteals()
        			+pp.get(i).getRebounds()-pp.get(i).getFieldGoalsAttempts()+pp.get(i).getFieldGoalsMade()
        			-pp.get(i).getFreeThrowsAttempts()+pp.get(i).getFreeThrowsMade()-pp.get(i).getTurnovers();
        	//计算效率
        	
        	GmSc=pp.get(i).getPoints()+0.4*pp.get(i).getFieldGoalsMade()-0.7*pp.get(i).getFieldGoalsAttempts()
        			-0.4*(pp.get(i).getFreeThrowsAttempts()-pp.get(i).getFreeThrowsMade())+0.7*pp.get(i).getOffensiveRebounds()
        			+0.3*pp.get(i).getDefensiveRebounds()+pp.get(i).getSteals()+0.7*pp.get(i).getAssists()
        			+0.7*pp.get(i).getBlocks()-0.4*pp.get(i).getFouls()-pp.get(i).getTurnovers();
        	//计算GmSc
        	

        	if(2*(pp.get(i).getFieldGoalsAttempts()+0.44*pp.get(i).getFreeThrowsAttempts())!=0)
        		tsp=pp.get(i).getPoints()/(2*(pp.get(i).getFieldGoalsAttempts()+0.44*pp.get(i).getFreeThrowsAttempts()));
        	//计算真实命中率
        	
        	
        	if(pp.get(i).getFieldGoalsAttempts()!=0)
        		se=(pp.get(i).getFieldGoalsMade()+0.5*pp.get(i).getThreePointFieldGoalsMade())/pp.get(i).getFieldGoalsAttempts();
        	//计算投篮效率
        	
        	time=pdc.getTime(pp.get(i).getMinutes());
        	allTime=pdc.getTime(pp.get(i).getAllTimeOfTeam())/5;
        	
        	
        	if(time!=0 && pp.get(i).getAllReboundsOfTeam()+pp.get(i).getAllReboundsOfOpposite()!=0)
        		rr=pp.get(i).getRebounds()*(allTime)/time
        			/(pp.get(i).getAllReboundsOfTeam()+pp.get(i).getAllReboundsOfOpposite());
        	//计算篮板率
        	
        	
        	if(time!=0 && pp.get(i).getAllOffensiveReboundsOfTeam()+pp.get(i).getAllOffensiveReboundsOfOpposite()!=0)
        		orr=pp.get(i).getOffensiveRebounds()*(allTime)/time
        			/(pp.get(i).getAllOffensiveReboundsOfTeam()+pp.get(i).getAllOffensiveReboundsOfOpposite());
        	//计算进攻篮板率
        	
        	
        	if(time!=0 && pp.get(i).getAlldefensiveReboundsOfTeam()+pp.get(i).getAlldefensiveReboundsOfOpposite()!=0)
        		drr=pp.get(i).getDefensiveRebounds()*(allTime)/time
        			/(pp.get(i).getAlldefensiveReboundsOfTeam()+pp.get(i).getAlldefensiveReboundsOfOpposite());
        	//计算防守篮板率
        	
        	
        	if(allTime!=0)
        		if(time/allTime*pp.get(i).getAllFieldGoalsMade()-pp.get(i).getFieldGoalsMade()!=0)
        			ar=pp.get(i).getAssists()/(time/allTime*pp.get(i).getAllFieldGoalsMade()-pp.get(i).getFieldGoalsMade());
        	//计算助攻率
        	
        	  	
        	if(pp.get(i).getAllOffensiveReboundsOfOpposite()+pp.get(i).getAlldefensiveReboundsOfTeam()!=0)
        		adoo=pp.get(i).getAllFieldGoalsAttemptsOfOpposite()+0.4*pp.get(i).getAllFreeGoalsAttemptsOfOpposite()-1.07*
        			(pp.get(i).getAllOffensiveReboundsOfOpposite()/(pp.get(i).getAllOffensiveReboundsOfOpposite()+pp.get(i).getAlldefensiveReboundsOfTeam())*pp.get(i).getAllMissedGoalsOfOpposite())
        			+1.07*pp.get(i).getAllturnoversOfOpposite();
        	pp.get(i).setAllDefenseOfOpposite(adoo);
        	//计算对手进攻次数
        	
        	
        	if(time!=0 && pp.get(i).getAllDefenseOfOpposite()!=0)
        		sr=pp.get(i).getSteals()*allTime/time/pp.get(i).getAllDefenseOfOpposite();
        	//计算抢断率
        	
        	
        	if(time!=0 && pp.get(i).getTwoPointFieldGoalsAttemptsOfOpposite()!=0)
        		br=pp.get(i).getBlocks()*allTime/time/pp.get(i).getTwoPointFieldGoalsAttemptsOfOpposite();
        	//计算盖帽率

        	
        	if(pp.get(i).getTurnovers()!=0)
        		tr=pp.get(i).getTurnovers()/(pp.get(i).getTwoPointFieldGoalsAttempts()+0.44*pp.get(i).getFreeThrowsAttempts()+pp.get(i).getTurnovers());
        	//计算失误率
        	
        	
        	if(time!=0 && pp.get(i).getAllFieldGoalsAttemptsOfTeam()+0.44*pp.get(i).getAllFreeGoalsAttemptsOfTeam()+pp.get(i).getAllturnoversOfTeam()!=0)
        		ur=(pp.get(i).getFieldGoalsAttempts()+0.44*pp.get(i).getFreeThrowsAttempts()+pp.get(i).getTurnovers())*
        			allTime/time/(pp.get(i).getAllFieldGoalsAttemptsOfTeam()+0.44*pp.get(i).getAllFreeGoalsAttemptsOfTeam()+pp.get(i).getAllturnoversOfTeam());
        	//计算使用率
        	
        	stmt.executeUpdate("update playerInfo set fieldGoalsPercentage='"+fgp+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set threePointFieldGoalsPercentage='"+tpfgp+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set freeThrowsPercentage='"+ftgp+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set efficiency='"+e+"' where playerName='" +name+ "'");
        	stmt.executeUpdate("update playerInfo set GmSc='"+GmSc+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set trueShootingPercentage='"+tsp+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set shootingEfficiency='"+se+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set reboundRating='"+rr+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set offensiveReboundRating='"+orr+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set defensiveReboundRating='"+drr+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set assisyRating='"+ar+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set allDefenseOfOpposite='"+adoo+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set stealRating='"+sr+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set blockRating='"+br+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set turnoverRating='"+tr+"' where playerName='" +name+ "'");
            stmt.executeUpdate("update playerInfo set utilizationRating='"+ur+"' where playerName='" +name+ "'");
        }
		stmt.close();
		conn.close();
	}//计算复杂数据
	
	
	public void calIncreaseOf5(int matchID) throws Exception{
		
		File directory = new File("");
		String courseFile = directory.getCanonicalPath() ;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
        
        Statement stmt=conn.createStatement();
        
        String sql = "select * from playerInfo where playerName in (select playerName from playerMatchInfo where generalMatch="+matchID+")";
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList<PlayerPO> pn=new ArrayList<PlayerPO>();
        while(rs.next()){
        	PlayerPO p=new PlayerPO();
        	p.setPlayerName(rs.getString("playerName"));
        	pn.add(p);
        }
        rs.close();
        
        double temp=0;
        for(int i=0;i<pn.size();i++){
	        String name=pn.get(i).getPlayerName().replace("'", "''");
	        String sql1 = "select * from playerMatchInfo where playerName='" +name+"'";
	        ResultSet rs1 = stmt.executeQuery(sql1);
	        
	        ArrayList<Double> point=new ArrayList<Double>();
	        ArrayList<Double> rebound=new ArrayList<Double>();
	        ArrayList<Double> assist=new ArrayList<Double>();
	        
	        while(rs1.next()){
	        	point.add(rs1.getDouble("score"));
	        	rebound.add(rs1.getDouble("rebound"));
	        	assist.add(rs1.getDouble("assist"));
	        }
	        rs1.close();
	        
	        if(point.size()<=5)
	        	stmt.executeUpdate("update playerInfo set increaseOfPoints='0' where playerName='" +name+ "'");
	        else{
	        	double B=0;
	        	for(int j=point.size()-1;j>=point.size()-5;j--){
	        		B=point.get(j)+B;
	        	}
	        	B=B/5;
	        	double A=0;
	        	for(int j=point.size()-6;j>=0;j--){
	        		A=point.get(j)+A;
	        	}
	        	A=A/(point.size()-5);
	        	if(A==0)
	        		temp=0;
	        	else
	        		temp=(B-A)/A;
	        	stmt.executeUpdate("update playerInfo set increaseOfPoints='"+temp+"' where playerName='" +name+ "'");
	        	
	        }
	        
	        if(rebound.size()<=5)
	        	stmt.executeUpdate("update playerInfo set increaseOfRebounds='0' where playerName='" +name+ "'");
	        else{
	        	double B=0;
	        	for(int j=rebound.size()-1;j>=rebound.size()-5;j--){
	        		B=rebound.get(j)+B;
	        	}
	        	B=B/5;
	        	double A=0;
	        	for(int j=rebound.size()-6;j>=0;j--){
	        		A=rebound.get(j)+A;
	        	}
	        	A=A/(rebound.size()-5);
	        	if(A==0)
	        		temp=0;
	        	else
		        	temp=(B-A)/A;
		        stmt.executeUpdate("update playerInfo set increaseOfRebounds='"+temp+"' where playerName='" +name+ "'");
	        }
	        
	        if(assist.size()<=5)
	        	 stmt.executeUpdate("update playerInfo set increaseOfAssists='0' where playerName='" +name+ "'");
	        else{
	        	double B=0;
	        	for(int j=assist.size()-1;j>=assist.size()-5;j--){
	        		B=assist.get(j)+B;
	        	}
	        	B=B/5;
	        	double A=0;
	        	for(int j=assist.size()-6;j>=0;j--){
	        		A=assist.get(j)+A;
	        	}
	        	A=A/(assist.size()-5);
	        	if(A==0)
	        		temp=0;
	        	else
	        		temp=(B-A)/A;
	        	stmt.executeUpdate("update playerInfo set increaseOfAssists='"+temp+"' where playerName='" +name+ "'");
	        }
	        
        }
        stmt.close();
        conn.close();
	}//计算近五场的提升率
	
	
	
	
	public double getTime(String time){
		if(time==null)
			time="0:0";
		String []t=time.split(":");
		double min=Double.valueOf(t[0]);
		double sec=Double.valueOf(t[0]);
		double result=min+sec/60;
		return result;
	}//计算时间值
	
	
	
	
	public String calTime(String a,String b){
		if(a==null || a.equals(""))
			a="0:0";
		if(b==null || b.equals(""))
			b="0:0";
		String[] xa=a.split(":");
		String[] xb=b.split(":");
		int second1=Integer.parseInt(xa[1]);
		int second2=Integer.parseInt(xb[1]);
		int minute1=Integer.parseInt(xa[0]);
		int minute2=Integer.parseInt(xb[0]);
		
		int minute=(second1+second2)/60+minute1+minute2;
		int second=(second1+second2)%60;
		
		String result=String.valueOf(minute)+":"+String.valueOf(second);
		
		return result;
	}//计算两时间之和
	
	
	
		
	public void update(ArrayList<Integer> matchID){
		PlayerDataCalculate pdc=new PlayerDataCalculate();
		try {
			for(int i=0;i<matchID.size();i++){
				pdc.updatePlayerInfoBySingleMatch(matchID.get(i));
				pdc.calComplexData(matchID.get(i));
				pdc.calIncreaseOf5(matchID.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateBasic(){
		PlayerDataCalculate pdc=new PlayerDataCalculate();
		try {
			pdc.saveBasicInfo();
			
			File directory = new File("");
			String courseFile = directory.getCanonicalPath() ;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
	        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
	        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
	        
	        Statement stmt=conn.createStatement();
	        
	        String sql = "select * from generalMatchInfo";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        ArrayList<Integer> matchID=new ArrayList<Integer>();
	        while(rs.next()){
	        	matchID.add(rs.getInt("ID"));
	        }
	        pdc.update(matchID);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String []args){
		PlayerDataCalculate pdc=new PlayerDataCalculate();
		try {
			Date d = new Date();  
	        System.out.println(d);  
	        
			pdc.saveBasicInfo();
			
			Date d1 = new Date();  
	        System.out.println(d1);
	        
	        for(int i=0;i<10;i++)
	        	pdc.updatePlayerInfoBySingleMatch(i);
	        
	        Date d2 = new Date();  
	        System.out.println(d2);
	        
	        for(int i=0;i<10;i++)
	        	pdc.calComplexData(i);
	        
	        Date d3 = new Date();  
	        System.out.println(d3);
	        
	        for(int i=0;i<10;i++)
	        	pdc.calIncreaseOf5(i);
			
			Date d4 = new Date();  
	        System.out.println(d4);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


