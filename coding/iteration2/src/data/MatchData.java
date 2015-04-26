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
		String teamName1="";
		String teamName2="";
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
	 		 
	 		 ResultSet rs = stmt.executeQuery("select * from generalMatchInfo where matchTime='"+date+"' and EXISTs (select * from generalMatchInfo where teamName1='"+teamName+"' or teamName2='"+teamName+"')");	
	 		 
	 		 while(rs.next()){
	 			 matchID=rs.getInt("ID");
	 			 result.setMatchTime(date);
	 			 teamName1=rs.getString("teamName1");
	 			 teamName2=rs.getString("teamName2");
	 			 result.setTeams(teamName1+"-"+teamName2);
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
	 		 t1.setTeamName(teamName1);
	 		 t2.setTeamName(teamName2);
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
		MatchPO matchpo=new MatchPO();
		ArrayList<Integer> matchID=new ArrayList<Integer>();
		String escore="";
		String[] sescore;
		MatchPlayer mp=new MatchPlayer();
		ArrayList<String> temp=new ArrayList<String>();
		MatchTeam t1=new MatchTeam();
		MatchTeam t2=new MatchTeam();
		String date="";
		String teamName1="";
		String teamName2="";
		
		try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
	   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	 	 	 String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	 		 Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	 		 Statement stmt = conn.createStatement();  
	 		 
	 		 ResultSet rs = stmt.executeQuery("select * from generalMatchInfo");	
	 		 while(rs.next()){
	 			 result.add(md.getSingleMatchInfo(rs.getString("teamName1"), rs.getString("matchTime")));
	 		 }
	 		 /*while(rs.next()){
	 			 matchID.add(rs.getInt("ID"));	 			 
	 		 }
	 		 for(int j=0;j<matchID.size();j++){
	 			 System.out.println(matchID.get(j));
	 			 rs = stmt.executeQuery("select * from generalMatchInfo where ID="+matchID.get(j));
	 			 while(rs.next()){
	 				 matchpo.setMatchTime(date);
	 				 teamName1=rs.getString("teamName1");
	 				 teamName2=rs.getString("teamName2");
	 				 matchpo.setTeams(teamName1+"-"+teamName2);
	 				 matchpo.setScore(rs.getString("score"));
	 				 matchpo.setScore1(rs.getString("score1"));
	 				 matchpo.setScore2(rs.getString("score2"));
	 				 matchpo.setScore3(rs.getString("score3"));
	 				 matchpo.setScore4(rs.getString("score4"));
	 				 escore=rs.getString("extrascores");
	 				 sescore=escore.split(";");
	 				 for(int i=0;i<sescore.length;i++){
	 					 temp.add(sescore[i]);
	 				 }
	 				 matchpo.setExtraScores(temp);
	 			 }
	 			 t1.setTeamName(teamName1);
	 			 t2.setTeamName(teamName2);
	 			 rs = stmt.executeQuery("select * from playerMatchInfo where generalMatch="+matchID+" and teamName='"+teamName1+"'");
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
	 			 rs= stmt.executeQuery("select * from playerMatchInfo where generalMatch="+matchID+" and oppositeTeamName='"+teamName1+"'");
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
	 			 matchpo.setTeam1(t1);
	 			 matchpo.setTeam2(t2);
	 			 result.add(matchpo);
	 		 }*/
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
	
	public String getDate(){
		String result="";
		try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
	   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	 	 	 String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	 		 Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	 		 Statement stmt = conn.createStatement();  
	 		 
	 		 ResultSet rs = stmt.executeQuery("select * from generalMatchInfo");	
	 		 
	 		 while(rs.next()){
	 			 result=rs.getString("matchTime");
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
	
	public ArrayList<MatchPO> getTodayMatchInfo(String date){
		MatchData md=new MatchData();
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		MatchPO matchpo=new MatchPO();
		MatchPlayer mp=new MatchPlayer();
		MatchTeam t1=new MatchTeam();
		MatchTeam t2=new MatchTeam();
		String teamName1="";
		String teamName2="";
		ArrayList<String> temp=new ArrayList<String>();
		String escore="";
		String[] sescore;
		int matchID=0;
		try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
	   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	 	 	 String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	 		 Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	 		 Statement stmt = conn.createStatement();  
	 		 
	 		 ResultSet rs = stmt.executeQuery("select * from generalMatchInfo where matchTime='"+date+"'");	
	 		 while(rs.next()){
	 			 result.add(md.getSingleMatchInfo(rs.getString("teamName1"),rs.getString("matchTime")));
	 		 }
	 		 /*while(rs.next()){
	 			 matchID=rs.getInt("ID");
	 			 matchpo.setMatchTime(date);
	 			 teamName1=rs.getString("teamName1");
	 			 teamName2=rs.getString("teamName2");
	 			 matchpo.setTeams(teamName1+"-"+teamName2);
	 			 matchpo.setScore(rs.getString("score"));
	 			 matchpo.setScore1(rs.getString("score1"));
	 			 matchpo.setScore2(rs.getString("score2"));
	 			 matchpo.setScore3(rs.getString("score3"));
	 			 matchpo.setScore4(rs.getString("score4"));
	 			 escore=rs.getString("extrascores");
	 			 sescore=escore.split(";");
	 			 for(int i=0;i<sescore.length;i++){
	 				 temp.add(sescore[i]);
	 			 }
	 			 matchpo.setExtraScores(temp);

	 			 t1.setTeamName(teamName1);
	 			 t2.setTeamName(teamName2);
	 			 rs1 = stmt.executeQuery("select * from playerMatchInfo where generalMatch="+matchID+" and teamName='"+teamName1+"'");
	 			 while(rs1.next()){
	 				 mp.setPlayerName(rs1.getString("playerName"));
	 				 mp.setPosition(rs1.getString("position"));
	 				 mp.setMatchTime(rs1.getString("matchTime"));
	 				 mp.setFieldGoal(rs1.getInt("fieldGoal"));
	 				 mp.setFieldGoalAttempts(rs1.getInt("fieldGoalAttempts"));
	 				 mp.setThreePointShot(rs1.getInt("threepointShot"));
	 				 mp.setThreePointAttempts(rs1.getInt("threepointAttempts"));
	 				 mp.setFreeThrowGoal(rs1.getInt("freeThrowGoal"));
	 				 mp.setFreeThrowAttempts(rs1.getInt("freeThrowAttempts"));
	 				 mp.setOffensiveRebound(rs1.getInt("offensiveRebound"));
	 				 mp.setDefensiveRebound(rs1.getInt("defensiveRebound"));
	 				 mp.setRebound(rs1.getInt("rebound"));
	 				 mp.setAssist(rs1.getInt("assist"));
	 				 mp.setST(rs.getInt("st"));	
	 				 mp.setBlockShot(rs1.getInt("blockShot"));
	 				 mp.setError(rs1.getInt("error"));
	 				 mp.setFoul(rs1.getInt("foul"));
	 			 	 mp.setScore(rs1.getInt("score"));	
	 			 	 t1.addPlayer(mp);
	 			 }
	 			 rs1 = stmt.executeQuery("select * from playerMatchInfo where generalMatch="+matchID+" and oppositeTeamName='"+teamName1+"'");
	 			 while(rs1.next()){
	 				 mp.setPlayerName(rs1.getString("playerName"));
	 				 mp.setPosition(rs1.getString("position"));
	 				 mp.setMatchTime(rs1.getString("matchTime"));
	 				 mp.setFieldGoal(rs1.getInt("fieldGoal"));
	 				 mp.setFieldGoalAttempts(rs1.getInt("fieldGoalAttempts"));
	 				 mp.setThreePointShot(rs1.getInt("threepointShot"));
	 				 mp.setThreePointAttempts(rs1.getInt("threepointAttempts"));
	 				 mp.setFreeThrowGoal(rs1.getInt("freeThrowGoal"));
	 				 mp.setFreeThrowAttempts(rs1.getInt("freeThrowAttempts"));
	 				 mp.setOffensiveRebound(rs1.getInt("offensiveRebound"));
	 				 mp.setDefensiveRebound(rs1.getInt("defensiveRebound"));
	 				 mp.setRebound(rs1.getInt("rebound"));
	 				 mp.setAssist(rs1.getInt("assist"));
	 				 mp.setST(rs1.getInt("st"));	
	 				 mp.setBlockShot(rs1.getInt("blockShot"));
	 				 mp.setError(rs1.getInt("error"));
	 				 mp.setFoul(rs1.getInt("foul"));
	 				 mp.setScore(rs1.getInt("score"));	
	 				 t2.addPlayer(mp);
	 			 }
	 			 matchpo.setTeam1(t1);
	 			 matchpo.setTeam2(t2);
	 			 result.add(matchpo);
	 		 } */

			rs.close();
			stmt.close();
			conn.close();
	 	 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	 	 }
		return result;
	}
	
	public void updateMatchInfo(){
		MatchDataCalculate mdc=new MatchDataCalculate();
		try {
			mdc.deleteAllMatch();
			mdc.BasicMatchOriginal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[]args){
		MatchData md=new MatchData();
		ArrayList <MatchPO> mp=md.getTodayMatchInfo("12-11");
		MatchPO mpo=md.getSingleMatchInfo("BOS", "12-11");
		System.out.println(mp.size());
		System.out.println(mpo.getScore());
	}
}
