package data;
import java.util.Date; 

import java.text.SimpleDateFormat;
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
        
        String sql = "select * from playerMatchInfo where generalMatch=" + ID;
        PreparedStatement pstmt;
        pstmt = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
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
        pstmt.close();

        PlayerDataCalculate pdc=new PlayerDataCalculate();
        
        for(int i=0;i<mp1.size();i++){
        	if(pdc.isExist(mp1.get(i).getPlayerName())){
        	}else{
	    		String sql1 = "insert into playerInfo (playerName,position) values(?,?)";
	    		PreparedStatement pstmt1;
	    		pstmt1 = (PreparedStatement) conn.prepareStatement(sql1);
	    		pstmt1.setString(1, mp1.get(i).getPlayerName());
	    		pstmt1.setString(2, mp1.get(i).getPosition());
	    		pstmt1.executeUpdate();
	    		pstmt1.close();
        	}
        	
        	double gp=pdc.searchPlayerInfoD("gamesPlayed", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("gamesPlayed", gp+1, mp1.get(i).getPlayerName(),conn);
        	if(mp1.get(i).getPosition()!=null && !mp1.get(i).getPosition().equals("")){
        		double	gs=pdc.searchPlayerInfoD("gamesStarting", mp1.get(i).getPlayerName(),conn);
        		pdc.updatePlayerInfoD("gamesStarting", gs+1, mp1.get(i).getPlayerName(),conn);
        	}
        	
        	pdc.updatePlayerInfoS("teamName", temp1, mp1.get(i).getPlayerName(),conn);
        	
        	String t=pdc.searchPlayerInfoS("minutes", mp1.get(i).getPlayerName(),conn);
        	String time=pdc.calTime(mp1.get(i).getMatchTime(), t);
        	pdc.updatePlayerInfoS("minutes", time, mp1.get(i).getPlayerName(),conn);
        	
        	double fgm=pdc.searchPlayerInfoD("fieldGoalsMade", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("fieldGoalsMade", fgm+mp1.get(i).getFieldGoal(), mp1.get(i).getPlayerName(),conn);
        	double fga=pdc.searchPlayerInfoD("fieldGoalsAttempts", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("fieldGoalsAttempts", fga+mp1.get(i).getFieldGoalAttempts(), mp1.get(i).getPlayerName(),conn);
        	double tpfgm=pdc.searchPlayerInfoD("threePointFieldGoalsMade", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("threePointFieldGoalsMade", tpfgm+mp1.get(i).getThreePointShot(), mp1.get(i).getPlayerName(),conn);
        	double tpfga=pdc.searchPlayerInfoD("threePointFieldGoalsAttempts", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("threePointFieldGoalsAttempts", tpfga+mp1.get(i).getThreePointAttempts(), mp1.get(i).getPlayerName(),conn);
        	double ftm=pdc.searchPlayerInfoD("freeThrowsMade", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("freeThrowsMade", ftm+mp1.get(i).getFreeThrowGoal(), mp1.get(i).getPlayerName(),conn);
        	double fta=pdc.searchPlayerInfoD("freeThrowsAttempts", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("freeThrowsAttempts", fta+mp1.get(i).getFreeThrowAttempts(), mp1.get(i).getPlayerName(),conn);
        	double or=pdc.searchPlayerInfoD("offensiveRebounds", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("offensiveRebounds", or+mp1.get(i).getOffensiveRebound(), mp1.get(i).getPlayerName(),conn);
        	double dr=pdc.searchPlayerInfoD("defensiveRebounds", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("defensiveRebounds", dr+mp1.get(i).getDefensiveRebound(), mp1.get(i).getPlayerName(),conn);
        	double r=pdc.searchPlayerInfoD("rebounds", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("rebounds", r+mp1.get(i).getRebound(), mp1.get(i).getPlayerName(),conn);
        	double a=pdc.searchPlayerInfoD("assists", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("assists", a+mp1.get(i).getAssist(), mp1.get(i).getPlayerName(),conn);
        	double s=pdc.searchPlayerInfoD("steals", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("steals", s+mp1.get(i).getST(), mp1.get(i).getPlayerName(),conn);
        	double b=pdc.searchPlayerInfoD("blocks", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("blocks", b+mp1.get(i).getBlockShot(), mp1.get(i).getPlayerName(),conn);
        	double tu=pdc.searchPlayerInfoD("turnovers", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("turnovers", tu+mp1.get(i).getError(), mp1.get(i).getPlayerName(),conn);
        	double f=pdc.searchPlayerInfoD("fouls", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("fouls", f+mp1.get(i).getFoul(), mp1.get(i).getPlayerName(),conn);
        	double p=pdc.searchPlayerInfoD("points", mp1.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("points", p+mp1.get(i).getScore(), mp1.get(i).getPlayerName(),conn);
        	
        	String atot=pdc.searchPlayerInfoS("allTimeOfTeam", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		atot=pdc.calTime(atot, mp1.get(j).getMatchTime());
        	}
        	pdc.updatePlayerInfoS("allTimeOfTeam", atot, mp1.get(i).getPlayerName(),conn);
        	
        	double arot=pdc.searchPlayerInfoD("allReboundsOfTeam", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		arot=arot+mp1.get(j).getRebound();
        	}
        	pdc.updatePlayerInfoD("allReboundsOfTeam", arot, mp1.get(i).getPlayerName(),conn);
        
        	double aorot=pdc.searchPlayerInfoD("allOffensiveReboundsOfTeam", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		aorot=aorot+mp1.get(j).getOffensiveRebound();
        	}
        	pdc.updatePlayerInfoD("allOffensiveReboundsOfTeam", aorot, mp1.get(i).getPlayerName(),conn);
        	
        	double adrot=pdc.searchPlayerInfoD("allDefensiveReboundsOfTeam", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		adrot=adrot+mp1.get(j).getDefensiveRebound();
        	}
        	pdc.updatePlayerInfoD("allDefensiveReboundsOfTeam", adrot, mp1.get(i).getPlayerName(),conn);
        	
        	double aroo=pdc.searchPlayerInfoD("allReboundsOfOpposite", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		aroo=aroo+mp2.get(j).getRebound();
        	}
        	pdc.updatePlayerInfoD("allReboundsOfOpposite", aroo, mp1.get(i).getPlayerName(),conn);
        	
        	double aoroo=pdc.searchPlayerInfoD("allOffensiveReboundsOfOpposite", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		aoroo=aoroo+mp2.get(j).getOffensiveRebound();
        	}
        	pdc.updatePlayerInfoD("allOffensiveReboundsOfOpposite", aoroo, mp1.get(i).getPlayerName(),conn);
        	
        	double adroo=pdc.searchPlayerInfoD("allDefensiveReboundsOfOpposite", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		adroo=adroo+mp2.get(j).getDefensiveRebound();
        	}
        	pdc.updatePlayerInfoD("allDefensiveReboundsOfOpposite", adroo, mp1.get(i).getPlayerName(),conn);
        	
        	double afgm=pdc.searchPlayerInfoD("allFieldGoalsMade", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		afgm=afgm+mp1.get(j).getFieldGoal();
        	}
        	pdc.updatePlayerInfoD("allFieldGoalsMade", afgm, mp1.get(i).getPlayerName(),conn);
        	
        	double tpfgaoo=pdc.searchPlayerInfoD("twoPointFieldGoalsAttemptsOfOpposite", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		tpfgaoo=tpfgaoo+mp2.get(j).getFieldGoalAttempts()-mp2.get(j).getThreePointAttempts();
        	}
        	pdc.updatePlayerInfoD("twoPointFieldGoalsAttemptsOfOpposite", tpfgaoo, mp1.get(i).getPlayerName(),conn);
        	
        	double tpfg=pdc.searchPlayerInfoD("twoPointFieldGoalsAttempts", mp1.get(i).getPlayerName(),conn);
        	tpfg=tpfg+mp1.get(i).getFieldGoalAttempts()-mp1.get(i).getThreePointAttempts();
        	pdc.updatePlayerInfoD("twoPointFieldGoalsAttempts", tpfg, mp1.get(i).getPlayerName(),conn);
        	
        	double afgaot=pdc.searchPlayerInfoD("allFieldGoalsAttemptsOfTeam", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		afgaot=afgaot+mp1.get(j).getFieldGoalAttempts();
        	}
        	pdc.updatePlayerInfoD("allFieldGoalsAttemptsOfTeam", afgaot, mp1.get(i).getPlayerName(),conn);
        	
        	double afgao=pdc.searchPlayerInfoD("allFreeGoalsAttemptsOfTeam", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		afgao=afgao+mp1.get(j).getFreeThrowAttempts();
        	}
        	pdc.updatePlayerInfoD("allFreeGoalsAttemptsOfTeam", afgao, mp1.get(i).getPlayerName(),conn);
        	
        	double ato=pdc.searchPlayerInfoD("allturnoversOfTeam", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		ato=ato+mp1.get(j).getError();
        	}
        	pdc.updatePlayerInfoD("allturnoversOfTeam", ato, mp1.get(i).getPlayerName(),conn);
        	
        	double afgaoo=pdc.searchPlayerInfoD("allFieldGoalsAttemptsOfOpposite", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		afgaoo=afgaoo+mp2.get(j).getFieldGoalAttempts();
        	}
        	pdc.updatePlayerInfoD("allFieldGoalsAttemptsOfOpposite", afgaoo, mp1.get(i).getPlayerName(),conn);
        	
        	double afga=pdc.searchPlayerInfoD("allFreeGoalsAttemptsOfOpposite", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		afga=afga+mp2.get(j).getFreeThrowAttempts();
        	}
        	pdc.updatePlayerInfoD("allFreeGoalsAttemptsOfOpposite", afga, mp1.get(i).getPlayerName(),conn);
        	
        	double amgoo=pdc.searchPlayerInfoD("allMissedGoalsOfOpposite", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		amgoo=amgoo+mp2.get(j).getFieldGoalAttempts()-mp2.get(j).getFieldGoal();
        	}
        	pdc.updatePlayerInfoD("allMissedGoalsOfOpposite", amgoo, mp1.get(i).getPlayerName(),conn);
        	
        	double atoo=pdc.searchPlayerInfoD("allturnoversOfOpposite", mp1.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		atoo=atoo+mp2.get(j).getError();
        	}
        	pdc.updatePlayerInfoD("allturnoversOfOpposite", atoo, mp1.get(i).getPlayerName(),conn);
        	
        	double dd=pdc.searchPlayerInfoD("doubleDouble", mp1.get(i).getPlayerName(),conn);
        	if((mp1.get(i).getScore()>=10&&mp1.get(i).getAssist()>=10) || (mp1.get(i).getScore()>=10&&mp1.get(i).getRebound()>=10) 
					|| (mp1.get(i).getScore()>=10&&mp1.get(i).getST()>=10) || (mp1.get(i).getScore()>=10&&mp1.get(i).getBlockShot()>=10) 
					|| (mp1.get(i).getAssist()>=10&&mp1.get(i).getBlockShot()>=10) || (mp1.get(i).getAssist()>=10&&mp1.get(i).getRebound()>=10) 
					|| (mp1.get(i).getAssist()>=10&&mp1.get(i).getST()>=10) || (mp1.get(i).getST()>=10&&mp1.get(i).getBlockShot()>=10) 
					|| (mp1.get(i).getST()>=10&&mp1.get(i).getRebound()>=10) || (mp1.get(i).getRebound()>=10&&mp1.get(i).getBlockShot()>=10)){
        		dd=dd+1;
        	}
        	pdc.updatePlayerInfoD("doubleDouble", dd, mp1.get(i).getPlayerName(),conn);
        }

        for(int i=0;i<mp2.size();i++){
        	if(pdc.isExist(mp2.get(i).getPlayerName())){
        	}else{
	    		String sql1 = "insert into playerInfo (playerName,position) values(?,?)";
	    		PreparedStatement pstmt1;
	    		pstmt1 = (PreparedStatement) conn.prepareStatement(sql1);
	    		pstmt1.setString(1, mp2.get(i).getPlayerName());
	    		pstmt1.setString(2, mp2.get(i).getPosition());
	    		pstmt1.executeUpdate();
	    		pstmt1.close();
        	}
    		
        	double gp=pdc.searchPlayerInfoD("gamesPlayed", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("gamesPlayed", gp+1, mp2.get(i).getPlayerName(),conn);
        	if(mp2.get(i).getPosition()!=null && !mp2.get(i).getPosition().equals("")){
        		double	gs=pdc.searchPlayerInfoD("gamesStarting", mp2.get(i).getPlayerName(),conn);
        		pdc.updatePlayerInfoD("gamesStarting", gs+1, mp2.get(i).getPlayerName(),conn);
        	}
        	
        	pdc.updatePlayerInfoS("teamName", temp2, mp2.get(i).getPlayerName(),conn);
        	
        	String t=pdc.searchPlayerInfoS("minutes", mp2.get(i).getPlayerName(),conn);
        	String time=pdc.calTime(mp2.get(i).getMatchTime(), t);
        	pdc.updatePlayerInfoS("minutes", time, mp2.get(i).getPlayerName(),conn);
        	
        	double fgm=pdc.searchPlayerInfoD("fieldGoalsMade", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("fieldGoalsMade", fgm+mp2.get(i).getFieldGoal(), mp2.get(i).getPlayerName(),conn);
        	double fga=pdc.searchPlayerInfoD("fieldGoalsAttempts", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("fieldGoalsAttempts", fga+mp2.get(i).getFieldGoalAttempts(), mp2.get(i).getPlayerName(),conn);
        	double tpfgm=pdc.searchPlayerInfoD("threePointFieldGoalsMade", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("threePointFieldGoalsMade", tpfgm+mp2.get(i).getThreePointShot(), mp2.get(i).getPlayerName(),conn);
        	double tpfga=pdc.searchPlayerInfoD("threePointFieldGoalsAttempts", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("threePointFieldGoalsAttempts", tpfga+mp2.get(i).getThreePointAttempts(), mp2.get(i).getPlayerName(),conn);
        	double ftm=pdc.searchPlayerInfoD("freeThrowsMade", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("freeThrowsMade", ftm+mp2.get(i).getFreeThrowGoal(), mp2.get(i).getPlayerName(),conn);
        	double fta=pdc.searchPlayerInfoD("freeThrowsAttempts", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("freeThrowsAttempts", fta+mp2.get(i).getFreeThrowAttempts(), mp2.get(i).getPlayerName(),conn);
        	double or=pdc.searchPlayerInfoD("offensiveRebounds", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("offensiveRebounds", or+mp2.get(i).getOffensiveRebound(), mp2.get(i).getPlayerName(),conn);
        	double dr=pdc.searchPlayerInfoD("defensiveRebounds", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("defensiveRebounds", dr+mp2.get(i).getDefensiveRebound(), mp2.get(i).getPlayerName(),conn);
        	double r=pdc.searchPlayerInfoD("rebounds", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("rebounds", r+mp2.get(i).getRebound(), mp2.get(i).getPlayerName(),conn);
        	double a=pdc.searchPlayerInfoD("assists", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("assists", a+mp2.get(i).getAssist(), mp2.get(i).getPlayerName(),conn);
        	double s=pdc.searchPlayerInfoD("steals", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("steals", s+mp2.get(i).getST(), mp2.get(i).getPlayerName(),conn);
        	double b=pdc.searchPlayerInfoD("blocks", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("blocks", b+mp2.get(i).getBlockShot(), mp2.get(i).getPlayerName(),conn);
        	double tu=pdc.searchPlayerInfoD("turnovers", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("turnovers", tu+mp2.get(i).getError(), mp2.get(i).getPlayerName(),conn);
        	double f=pdc.searchPlayerInfoD("fouls", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("fouls", f+mp2.get(i).getFoul(), mp2.get(i).getPlayerName(),conn);
        	double p=pdc.searchPlayerInfoD("points", mp2.get(i).getPlayerName(),conn);
        	pdc.updatePlayerInfoD("points", p+mp2.get(i).getScore(), mp2.get(i).getPlayerName(),conn);
        	
        	String atot=pdc.searchPlayerInfoS("allTimeOfTeam", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		atot=pdc.calTime(atot, mp2.get(j).getMatchTime());
        	}
        	pdc.updatePlayerInfoS("allTimeOfTeam", atot, mp2.get(i).getPlayerName(),conn);	
        	double arot=pdc.searchPlayerInfoD("allReboundsOfTeam", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		arot=arot+mp2.get(j).getRebound();
        	}
        	pdc.updatePlayerInfoD("allReboundsOfTeam", arot, mp2.get(i).getPlayerName(),conn);
        
        	double aorot=pdc.searchPlayerInfoD("allOffensiveReboundsOfTeam", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		aorot=aorot+mp2.get(j).getOffensiveRebound();
        	}
        	pdc.updatePlayerInfoD("allOffensiveReboundsOfTeam", aorot, mp2.get(i).getPlayerName(),conn);
        	
        	double adrot=pdc.searchPlayerInfoD("allDefensiveReboundsOfTeam", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		adrot=adrot+mp2.get(j).getDefensiveRebound();
        	}
        	pdc.updatePlayerInfoD("allDefensiveReboundsOfTeam", adrot, mp2.get(i).getPlayerName(),conn);
        	
        	double aroo=pdc.searchPlayerInfoD("allReboundsOfOpposite", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		aroo=aroo+mp1.get(j).getRebound();
        	}
        	pdc.updatePlayerInfoD("allReboundsOfOpposite", aroo, mp2.get(i).getPlayerName(),conn);
        	
        	double aoroo=pdc.searchPlayerInfoD("allOffensiveReboundsOfOpposite", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		aoroo=aoroo+mp1.get(j).getOffensiveRebound();
        	}
        	pdc.updatePlayerInfoD("allOffensiveReboundsOfOpposite", aoroo, mp2.get(i).getPlayerName(),conn);
        	
        	double adroo=pdc.searchPlayerInfoD("allDefensiveReboundsOfOpposite", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		adroo=adroo+mp1.get(j).getDefensiveRebound();
        	}
        	pdc.updatePlayerInfoD("allDefensiveReboundsOfOpposite", adroo, mp2.get(i).getPlayerName(),conn);
        	
        	double afgm=pdc.searchPlayerInfoD("allFieldGoalsMade", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		afgm=afgm+mp2.get(j).getFieldGoal();
        	}
        	pdc.updatePlayerInfoD("allFieldGoalsMade", afgm, mp2.get(i).getPlayerName(),conn);
        	
        	double tpfgaoo=pdc.searchPlayerInfoD("twoPointFieldGoalsAttemptsOfOpposite", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		tpfgaoo=tpfgaoo+mp1.get(j).getFieldGoalAttempts()-mp1.get(j).getThreePointAttempts();
        	}
        	pdc.updatePlayerInfoD("twoPointFieldGoalsAttemptsOfOpposite", tpfgaoo, mp2.get(i).getPlayerName(),conn);
        	
        	double tpfg=pdc.searchPlayerInfoD("twoPointFieldGoalsAttempts", mp2.get(i).getPlayerName(),conn);
        	tpfg=tpfg+mp2.get(i).getFieldGoalAttempts()-mp2.get(i).getThreePointAttempts();
        	pdc.updatePlayerInfoD("twoPointFieldGoalsAttempts", tpfg, mp2.get(i).getPlayerName(),conn);
        	
        	double afgaot=pdc.searchPlayerInfoD("allFieldGoalsAttemptsOfTeam", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		afgaot=afgaot+mp2.get(j).getFieldGoalAttempts();
        	}
        	pdc.updatePlayerInfoD("allFieldGoalsAttemptsOfTeam", afgaot, mp2.get(i).getPlayerName(),conn);
        	
        	double afgao=pdc.searchPlayerInfoD("allFreeGoalsAttemptsOfTeam", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		afgao=afgao+mp2.get(j).getFreeThrowAttempts();
        	}
        	pdc.updatePlayerInfoD("allFreeGoalsAttemptsOfTeam", afgao, mp2.get(i).getPlayerName(),conn);
        	
        	double ato=pdc.searchPlayerInfoD("allturnoversOfTeam", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp2.size();j++){
        		ato=ato+mp2.get(j).getError();
        	}
        	pdc.updatePlayerInfoD("allturnoversOfTeam", ato, mp2.get(i).getPlayerName(),conn);
        	
        	double afgaoo=pdc.searchPlayerInfoD("allFieldGoalsAttemptsOfOpposite", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		afgaoo=afgaoo+mp1.get(j).getFieldGoalAttempts();
        	}
        	pdc.updatePlayerInfoD("allFieldGoalsAttemptsOfOpposite", afgaoo, mp2.get(i).getPlayerName(),conn);
        	
        	double afga=pdc.searchPlayerInfoD("allFreeGoalsAttemptsOfOpposite", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		afga=afga+mp1.get(j).getFreeThrowAttempts();
        	}
        	pdc.updatePlayerInfoD("allFreeGoalsAttemptsOfOpposite", afga, mp2.get(i).getPlayerName(),conn);
        	
        	double amgoo=pdc.searchPlayerInfoD("allMissedGoalsOfOpposite", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		amgoo=amgoo+mp1.get(j).getFieldGoalAttempts()-mp1.get(j).getFieldGoal();
        	}
        	pdc.updatePlayerInfoD("allMissedGoalsOfOpposite", amgoo, mp2.get(i).getPlayerName(),conn);
        	
        	double atoo=pdc.searchPlayerInfoD("allturnoversOfOpposite", mp2.get(i).getPlayerName(),conn);
        	for(int j=0;j<mp1.size();j++){
        		atoo=atoo+mp1.get(j).getError();
        	}
        	pdc.updatePlayerInfoD("allturnoversOfOpposite", atoo, mp2.get(i).getPlayerName(),conn);
        	
        	double dd=pdc.searchPlayerInfoD("doubleDouble", mp2.get(i).getPlayerName(),conn);
        	if((mp2.get(i).getScore()>=10&&mp2.get(i).getAssist()>=10) || (mp2.get(i).getScore()>=10&&mp2.get(i).getRebound()>=10) 
					|| (mp2.get(i).getScore()>=10&&mp2.get(i).getST()>=10) || (mp2.get(i).getScore()>=10&&mp2.get(i).getBlockShot()>=10) 
					|| (mp2.get(i).getAssist()>=10&&mp2.get(i).getBlockShot()>=10) || (mp2.get(i).getAssist()>=10&&mp2.get(i).getRebound()>=10) 
					|| (mp2.get(i).getAssist()>=10&&mp2.get(i).getST()>=10) || (mp2.get(i).getST()>=10&&mp2.get(i).getBlockShot()>=10) 
					|| (mp2.get(i).getST()>=10&&mp2.get(i).getRebound()>=10) || (mp2.get(i).getRebound()>=10&&mp2.get(i).getBlockShot()>=10)){
        		dd=dd+1;
        	}
        	pdc.updatePlayerInfoD("doubleDouble", dd, mp2.get(i).getPlayerName(),conn);
        }
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
        	System.out.println(i);
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
	

	
	public void calComplexData() throws Exception{
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
        pstmt.close();
        
        for(int i=0;i<pp.size();i++){
        	double fgp=0;
        	if(pp.get(i).getFieldGoalsAttempts()!=0)
        		fgp=pp.get(i).getFieldGoalsMade()/pp.get(i).getFieldGoalsAttempts();
        	pdc.updatePlayerInfoD("fieldGoalsPercentage", fgp, pp.get(i).getPlayerName(),conn);
        	//计算投篮命中率
        	
        	double tpfgp=0;
        	if(pp.get(i).getThreePointFieldGoalsAttempts()!=0)
        		tpfgp=pp.get(i).getThreePointFieldGoalsMade()/pp.get(i).getThreePointFieldGoalsAttempts();
        	pdc.updatePlayerInfoD("threePointFieldGoalsPercentage", tpfgp, pp.get(i).getPlayerName(),conn);
        	//计算三分命中率
        	
        	double ftgp=0;
        	if(pp.get(i).getFreeThrowsAttempts()!=0)
        		ftgp=pp.get(i).getFreeThrowsMade()/pp.get(i).getFreeThrowsAttempts();
        	pdc.updatePlayerInfoD("freeThrowsPercentage", ftgp, pp.get(i).getPlayerName(),conn);
        	//计算罚球命中率
        	
        	double e=pp.get(i).getPoints()+pp.get(i).getBlocks()+pp.get(i).getAssists()+pp.get(i).getSteals()
        			+pp.get(i).getRebounds()-pp.get(i).getFieldGoalsAttempts()+pp.get(i).getFieldGoalsMade()
        			-pp.get(i).getFreeThrowsAttempts()+pp.get(i).getFreeThrowsMade()-pp.get(i).getTurnovers();
        	pdc.updatePlayerInfoD("efficiency", e, pp.get(i).getPlayerName(),conn);
        	//计算效率
        	
        	double GmSc=pp.get(i).getPoints()+0.4*pp.get(i).getFieldGoalsMade()-0.7*pp.get(i).getFieldGoalsAttempts()
        			-0.4*(pp.get(i).getFreeThrowsAttempts()-pp.get(i).getFreeThrowsMade())+0.7*pp.get(i).getOffensiveRebounds()
        			+0.3*pp.get(i).getDefensiveRebounds()+pp.get(i).getSteals()+0.7*pp.get(i).getAssists()
        			+0.7*pp.get(i).getBlocks()-0.4*pp.get(i).getFouls()-pp.get(i).getTurnovers();
        	pdc.updatePlayerInfoD("GmSc", GmSc, pp.get(i).getPlayerName(),conn);
        	//计算GmSc
        	
        	double tsp=0;
        	if(2*(pp.get(i).getFieldGoalsAttempts()+0.44*pp.get(i).getFreeThrowsAttempts())!=0)
        		tsp=pp.get(i).getPoints()/(2*(pp.get(i).getFieldGoalsAttempts()+0.44*pp.get(i).getFreeThrowsAttempts()));
        	pdc.updatePlayerInfoD("trueShootingPercentage", tsp, pp.get(i).getPlayerName(),conn);
        	//计算真实命中率
        	
        	double se=0;
        	if(pp.get(i).getFieldGoalsAttempts()!=0)
        		se=(pp.get(i).getFieldGoalsMade()+0.5*pp.get(i).getThreePointFieldGoalsMade())/pp.get(i).getFieldGoalsAttempts();
        	pdc.updatePlayerInfoD("shootingEfficiency", se, pp.get(i).getPlayerName(),conn);
        	//计算投篮效率
        	
        	double time=pdc.getTime(pp.get(i).getMinutes());
        	double allTime=pdc.getTime(pp.get(i).getAllTimeOfTeam())/5;
        	
        	double rr=0;
        	if(time!=0 && pp.get(i).getAllReboundsOfTeam()+pp.get(i).getAllReboundsOfOpposite()!=0)
        		rr=pp.get(i).getRebounds()*(allTime)/time
        			/(pp.get(i).getAllReboundsOfTeam()+pp.get(i).getAllReboundsOfOpposite());
        	pdc.updatePlayerInfoD("reboundRating", rr, pp.get(i).getPlayerName(),conn);
        	//计算篮板率
        	
        	double orr=0;
        	if(time!=0 && pp.get(i).getAllOffensiveReboundsOfTeam()+pp.get(i).getAllOffensiveReboundsOfOpposite()!=0)
        		orr=pp.get(i).getOffensiveRebounds()*(allTime)/time
        			/(pp.get(i).getAllOffensiveReboundsOfTeam()+pp.get(i).getAllOffensiveReboundsOfOpposite());
        	pdc.updatePlayerInfoD("offensiveReboundRating", orr, pp.get(i).getPlayerName(),conn);
        	//计算进攻篮板率
        	
        	double drr=0;
        	if(time!=0 && pp.get(i).getAlldefensiveReboundsOfTeam()+pp.get(i).getAlldefensiveReboundsOfOpposite()!=0)
        		drr=pp.get(i).getDefensiveRebounds()*(allTime)/time
        			/(pp.get(i).getAlldefensiveReboundsOfTeam()+pp.get(i).getAlldefensiveReboundsOfOpposite());
        	pdc.updatePlayerInfoD("defensiveReboundRating", drr, pp.get(i).getPlayerName(),conn);
        	//计算防守篮板率
        	
        	double ar=0;
        	if(allTime!=0)
        		if(time/allTime*pp.get(i).getAllFieldGoalsMade()-pp.get(i).getFieldGoalsMade()!=0)
        			ar=pp.get(i).getAssists()/(time/allTime*pp.get(i).getAllFieldGoalsMade()-pp.get(i).getFieldGoalsMade());
        	pdc.updatePlayerInfoD("assisyRating", ar, pp.get(i).getPlayerName(),conn);
        	//计算助攻率
        	
        	
        	double adoo=0;
        	if(pp.get(i).getAllOffensiveReboundsOfOpposite()+pp.get(i).getAlldefensiveReboundsOfTeam()!=0)
        		adoo=pp.get(i).getAllFieldGoalsAttemptsOfOpposite()+0.4*pp.get(i).getAllFreeGoalsAttemptsOfOpposite()-1.07*
        			(pp.get(i).getAllOffensiveReboundsOfOpposite()/(pp.get(i).getAllOffensiveReboundsOfOpposite()+pp.get(i).getAlldefensiveReboundsOfTeam())*pp.get(i).getAllMissedGoalsOfOpposite())
        			+1.07*pp.get(i).getAllturnoversOfOpposite();
        	pdc.updatePlayerInfoD("allDefenseOfOpposite", adoo, pp.get(i).getPlayerName(),conn);
        	pp.get(i).setAllDefenseOfOpposite(adoo);
        	//计算对手进攻次数
        	
        	double sr=0;
        	if(time!=0 && pp.get(i).getAllDefenseOfOpposite()!=0)
        		sr=pp.get(i).getSteals()*allTime/time/pp.get(i).getAllDefenseOfOpposite();
        	pdc.updatePlayerInfoD("stealRating", sr, pp.get(i).getPlayerName(),conn);
        	//计算抢断率
        	
        	double br=0;
        	if(time!=0 && pp.get(i).getTwoPointFieldGoalsAttemptsOfOpposite()!=0)
        		br=pp.get(i).getBlocks()*allTime/time/pp.get(i).getTwoPointFieldGoalsAttemptsOfOpposite();
        	pdc.updatePlayerInfoD("blockRating", br, pp.get(i).getPlayerName(),conn);
        	//计算盖帽率

        	double tr=0;
        	if(pp.get(i).getTurnovers()!=0)
        		tr=pp.get(i).getTurnovers()/(pp.get(i).getTwoPointFieldGoalsAttempts()+0.44*pp.get(i).getFreeThrowsAttempts()+pp.get(i).getTurnovers());
        	pdc.updatePlayerInfoD("turnoverRating", tr, pp.get(i).getPlayerName(),conn);
        	//计算失误率
        	
        	double ur=0;
        	if(time!=0 && pp.get(i).getAllFieldGoalsAttemptsOfTeam()+0.44*pp.get(i).getAllFreeGoalsAttemptsOfTeam()+pp.get(i).getAllturnoversOfTeam()!=0)
        		ur=(pp.get(i).getFieldGoalsAttempts()+0.44*pp.get(i).getFreeThrowsAttempts()+pp.get(i).getTurnovers())*
        			allTime/time/(pp.get(i).getAllFieldGoalsAttemptsOfTeam()+0.44*pp.get(i).getAllFreeGoalsAttemptsOfTeam()+pp.get(i).getAllturnoversOfTeam());
        	pdc.updatePlayerInfoD("utilizationRating", ur, pp.get(i).getPlayerName(),conn);
        	//计算使用率
        	
        }
		
		conn.close();
	}//计算复杂数据
	
	public void calIncreaseOf5() throws Exception{
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
        
        ArrayList<PlayerPO> pn=new ArrayList<PlayerPO>();
        while(rs.next()){
        	PlayerPO p=new PlayerPO();
        	p.setPlayerName(rs.getString("playerName"));
        	pn.add(p);
        }
        rs.close();
        pstmt.close();
        
        for(int i=0;i<pn.size();i++){
	        String name=pn.get(i).getPlayerName().replace("'", "''");
	        String sql1 = "select * from playerMatchInfo where playerName='" +name+"'";
	        PreparedStatement pstmt1;
	        pstmt1 = (PreparedStatement)conn.prepareStatement(sql1);
	        ResultSet rs1 = pstmt1.executeQuery();
	        
	        ArrayList<Double> point=new ArrayList<Double>();
	        ArrayList<Double> rebound=new ArrayList<Double>();
	        ArrayList<Double> assist=new ArrayList<Double>();
	        while(rs1.next()){
	        	point.add(rs1.getDouble("score"));
	        	rebound.add(rs1.getDouble("rebound"));
	        	assist.add(rs1.getDouble("assist"));
	        }
	        pstmt.close();
	        if(point.size()<=5)
	        	pdc.updatePlayerInfoD("increaseOfPoints", 0, pn.get(i).getPlayerName(),conn);
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
	        		pdc.updatePlayerInfoD("increaseOfPoints", 0, pn.get(i).getPlayerName(),conn);
	        	else
	        		pdc.updatePlayerInfoD("increaseOfPoints", (B-A)/A, pn.get(i).getPlayerName(),conn);;
	        }
	        
	        if(rebound.size()<=5)
	        	pdc.updatePlayerInfoD("increaseOfRebounds", 0, pn.get(i).getPlayerName(),conn);
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
	        	A=A/(point.size()-5);
	        	if(A==0)
	        		pdc.updatePlayerInfoD("increaseOfRebounds", 0, pn.get(i).getPlayerName(),conn);
	        	else
	        		pdc.updatePlayerInfoD("increaseOfRebounds", (B-A)/A, pn.get(i).getPlayerName(),conn);;
	        }
	        
	        if(assist.size()<=5)
	        	pdc.updatePlayerInfoD("increaseOfAssists", 0, pn.get(i).getPlayerName(),conn);
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
	        	A=A/(point.size()-5);
	        	if(A==0)
	        		pdc.updatePlayerInfoD("increaseOfAssists", 0, pn.get(i).getPlayerName(),conn);
	        	else
	        		pdc.updatePlayerInfoD("increaseOfAssists", (B-A)/A, pn.get(i).getPlayerName(),conn);;
	        }
	        
        }
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
	
	public void updatePlayerInfoS(String p,String s,String name,Connection conn) throws Exception {
        
        name=name.replace("'", "''");
        String sql = "update playerInfo set "+p+"='"+s+"' where playerName='" +name+ "'";
        PreparedStatement pstmt;
        pstmt = (PreparedStatement) conn.prepareStatement(sql);
    	pstmt.executeUpdate();
    	pstmt.close();
	}//在playerInfo中更新字符串
	
	public void updatePlayerInfoD(String p,double s,String name,Connection conn) throws Exception {        
        name=name.replace("'", "''");
        String sql = "update playerInfo set "+p+"='"+s+"' where playerName='" +name+ "'";
        PreparedStatement pstmt;
        pstmt = (PreparedStatement) conn.prepareStatement(sql);
    	pstmt.executeUpdate();
    	pstmt.close();
	}//在playerInfo中更新数字
	
	public String searchPlayerInfoS(String p,String name,Connection conn) throws Exception {
        name=name.replace("'", "''");
        String sql = "select * from playerInfo where playerName='" + name + "'";
        PreparedStatement pstmt;
        pstmt = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        String result="";
        while(rs.next()){
        	result=rs.getString(p);
        }
        rs.close();
        pstmt.close();
        return result;
	}//在playerInfo中查找字符串
	
	public double searchPlayerInfoD(String p,String name,Connection conn) throws Exception {
        name=name.replace("'", "''");
        String sql = "select * from playerInfo where playerName='" + name + "'";
        PreparedStatement pstmt;
        pstmt = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        double result=0;
        while(rs.next()){
        	result=rs.getDouble(p);
        }
        rs.close();
        pstmt.close();
        return result;
	}//在playerInfo中查找数字
	
	public static void main(String[] args){
		PlayerDataCalculate pdc=new PlayerDataCalculate();
		try {
			Date date = new Date();
			String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			System.out.println(str);
			pdc.saveBasicInfo();
			
			Date date1 = new Date();
			String str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
			System.out.println(str1);
			
			pdc.calSimpleData();
			
			Date date2 = new Date();
			String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
			System.out.println(str2);
			
			pdc.calComplexData();

			Date date3 = new Date();
			String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date3);
			System.out.println(str3);
			
			pdc.calIncreaseOf5();
			Date date4 = new Date();
			String str4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date4);
			System.out.println(str4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//select *from playerMatchInfo where generalMatchID in (select ID from)

