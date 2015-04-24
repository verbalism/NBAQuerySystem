package data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;
import dataService.MatchDataService;

public class MatchData implements MatchDataService{
	public MatchPO getSingleMatchInfo(String teamName,String date){
		MatchPO result=new MatchPO();
		MatchPlayer mp=new MatchPlayer();
		MatchTeam t1=new MatchTeam();
		MatchTeam t2=new MatchTeam();
		String escore="";
		String[] sescore;
		int matchID=0;
		ArrayList<String> temp=new ArrayList<String>();
		 try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
	   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	 	 	 String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	 		 Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	 		 Statement stmt = conn.createStatement();  
	 		 
	 		 ResultSet rs = stmt.executeQuery("select * from generalMatchInfo where matchTime in (select matchTime from generalMatchInfo where teamName1='"+teamName+"' or teamName2='"+teamName+"')");	
	 		 
	 		 while(rs.next()){
	 			 matchID=rs.getInt("ID");
	 			 result.setMatchTime(date);
	 			 result.setTeams(rs.getString("teamName1")+"-"+rs.getString("teamName2"));
	 			 result.setScore(rs.getString("score"));
	 			 result.setScore1(rs.getString("score1"));
	 			 result.setScore2(rs.getString("score2"));
	 			 result.setScore3(rs.getString("score3"));
	 			 result.setScore4(rs.getString("score4"));
	 			 escore=rs.getString("extrascores");
	 			 sescore=escore.split(";");
	 			 for(int i=0;i<sescore.length;i++){
	 				 temp.add(sescore[i]);
	 			 }
	 			 result.setExtraScores(temp);
	 		 }
	 		 t1.setTeamName("teamName1");
	 		 t2.setTeamName("teamName2");
	 		 rs = stmt.executeQuery("select * from playerMatchInfo where generalMatch="+matchID+" and teamName='"+teamName+"'");
	 		 while(rs.next()){
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
	 			 t1.addPlayer(mp);
	 		 }
	 		 rs = stmt.executeQuery("select * from playerMatchInfo where generalMatch="+matchID+" and oppositeTeamName='"+teamName+"'");
	 		 while(rs.next()){
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
	 			 t2.addPlayer(mp);
	 		 }
	 		 rs.close();
	 		 stmt.close();
	 		 conn.close();
	 		 result.setTeam1(t1);
	 		 result.setTeam2(t2);
	 		 
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		 return result;
	}
	
	
	
	public ArrayList<MatchPO> getAllMatchInfo(){
		MatchData md=new MatchData();
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		String date="";
		String teamName="";
		
		try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
	   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	 	 	 String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	 		 Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	 		 Statement stmt = conn.createStatement();  
	 		 
	 		 ResultSet rs = stmt.executeQuery("select * from generalMatchInfo");	
	 		 
	 		 while(rs.next()){
	 			 date=rs.getString("MatchTime");
	 			 teamName=rs.getString("teamName1");
	 			 result.add(md.getSingleMatchInfo(teamName, date));
	 		 }
	 		
	 		 rs.close();
	 		 stmt.close();
	 		 conn.close();
	 		 
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		
		return result;
	}
	
	public ArrayList<MatchPO> getTeamRecentMatchInfo(int number,String teamName){
		MatchData md=new MatchData();
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		ArrayList<String> date=new ArrayList<String>();

		try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
	   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	 	 	 String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	 		 Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	 		 Statement stmt = conn.createStatement();  
	 		 
	 		 ResultSet rs = stmt.executeQuery("select * from generalMatchInfo where teamName1='"+teamName+"' or teamName2='"+teamName+"'");	
	 		 
	 		 while(rs.next()){
	 			 date.add(rs.getString("MatchTime"));
	 		 }
	 		
	 		 rs.close();
	 		 stmt.close();
	 		 conn.close();
	 		 
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		for(int j=date.size()-1;j>date.size()-number-1&j>0;j--){
			result.add(md.getSingleMatchInfo(teamName, date.get(j)));
		}
		
		return result;
	}
	
	public ArrayList<MatchPO> getPlayerRecentMatchInfo(int number,String playerName){
		MatchData md=new MatchData();
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		ArrayList<String> date=new ArrayList<String>();
		ArrayList<String> teamName=new ArrayList<String>();

		try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
	   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	 	 	 String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	 		 Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	 		 Statement stmt = conn.createStatement();  
	 		 
	 		 ResultSet rs = stmt.executeQuery("select * from generalMatchInfo where ID in(select generalMatch from playerMatchInfo where playerName='"+playerName+"')");	
	 		 
	 		 while(rs.next()){
	 			 date.add(rs.getString("MatchTime"));
	 			 teamName.add(rs.getString("teamName1"));
	 		 }
	 		
	 		 rs.close();
	 		 stmt.close();
	 		 conn.close();
	 		 
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		for(int j=date.size()-1;j>date.size()-number-1&j>0;j--){
			result.add(md.getSingleMatchInfo(teamName.get(j),date.get(j)));
		}
		return result;
	}
	
	/*public static void main(String[]args){
		MatchData md=new MatchData();
		ArrayList <MatchPO> mp=md.getTeamRecentMatchInfo(5, "BOS");
		System.out.println(mp.size());
	}*/
}