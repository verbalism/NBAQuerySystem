package data;

import java.sql.*;
import java.util.ArrayList;

import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;
import dataService.MatchDataService;

public class MatchData implements MatchDataService{
	public MatchPO getSingleMatchInfo(String teamName,String date,String season){
		MatchPO result=new MatchPO();
		MatchTeam t1=new MatchTeam();
		MatchTeam t2=new MatchTeam();
		String teamName1="";
		String teamName2="";
		String escore="";
		String[] sescore;
		int matchID=0;
		ArrayList<String> temp=new ArrayList<String>();
		ArrayList<MatchPlayer> players1=new ArrayList<MatchPlayer>();
		ArrayList<MatchPlayer> players2=new ArrayList<MatchPlayer>();
		try {
			 ConnectMySQL c=new ConnectMySQL();
			 Connection conn=c.getConnection();
			 Statement stmt = conn.createStatement();  
	 		 ResultSet rs = stmt.executeQuery("select * from generalmatch"+season+" where (teamName1='"+teamName+"' or teamName2='"+teamName+"') and matchTime in (select matchTime from generalmatch"+season+" where matchTime='"+date+"')");	
	 		 
	 		 while(rs.next()){
	 			 matchID=rs.getInt("id");
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
	 		 rs = stmt.executeQuery("select * from matchplayer"+season+" where generalMatch="+matchID+" and teamName='"+teamName+"'");
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
	 			 mp.setError(rs.getInt("turnover"));
	 			 mp.setFoul(rs.getInt("foul"));
	 			 mp.setScore(rs.getInt("score"));	
	 			 players1.add(mp);
	 		 }
	 		 t1.setPlayers(players1);
	 		 rs = stmt.executeQuery("select * from matchplayer"+season+" where generalMatch="+matchID+" and oppositeTeamName='"+teamName+"'");
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
	 			 mp.setError(rs.getInt("turnover"));
	 			 mp.setFoul(rs.getInt("foul"));
	 			 mp.setScore(rs.getInt("score"));	
	 			 players2.add(mp);
	 		 }
	 		 t2.setPlayers(players2);
	 		 rs.close();
	 		 stmt.close();
	 		 conn.close();
	 		 result.setTeam1(t1);
	 		 result.setTeam2(t2);
	 		 
		 } catch (Exception e) {
				e.printStackTrace();
		 }
		 return result;
	}//根据队名和比赛时间获取比赛信息matchpo
	
	public ArrayList<MatchPO> getAllMatchInfo(String season){
		ArrayList<MatchPO> Result=new ArrayList<MatchPO>();
		ArrayList<Integer> id=new ArrayList<Integer>();
		try {
			 ConnectMySQL c=new ConnectMySQL();
			 Connection conn=c.getConnection();
			 Statement stmt = conn.createStatement();  
			 String sql="select * from generalmatch"+season;
	 		 ResultSet rs = stmt.executeQuery(sql);	
	 		 while(rs.next()){
	 			 id.add(rs.getInt("id"));
	 		 }
	 		for(int i=0;i<id.size();i++){
				MatchPO result=new MatchPO();
	 			MatchTeam t1=new MatchTeam();
	 			MatchTeam t2=new MatchTeam();
	 			String teamName1="";
	 			String teamName2="";
	 			String escore="";
	 			String[] sescore;
	 			int matchID=0;
	 			ArrayList<String> temp=new ArrayList<String>();
	 			ArrayList<MatchPlayer> players1=new ArrayList<MatchPlayer>();
	 			ArrayList<MatchPlayer> players2=new ArrayList<MatchPlayer>();
	 		 	ResultSet rs1 = stmt.executeQuery("select * from generalmatch"+season+" where id='"+id.get(i)+"'");	
	 		 		 
	 		 		while(rs1.next()){
	 		 			 matchID=rs1.getInt("id");
	 		 			 result.setMatchTime(rs1.getString("matchTime"));
	 		 			 teamName1=rs1.getString("teamName1");
	 		 			 teamName2=rs1.getString("teamName2");
	 		 			 result.setTeams(teamName1+"-"+teamName2);
	 		 			 result.setScore(rs1.getString("score"));
	 		 			 result.setScore1(rs1.getString("score1"));
	 		 			 result.setScore2(rs1.getString("score2"));
	 		 			 result.setScore3(rs1.getString("score3"));
	 		 			 result.setScore4(rs1.getString("score4"));
	 		 			 escore=rs1.getString("extrascores");
	 		 			 sescore=escore.split(";");
	 		 			 for(int j=0;j<sescore.length;j++){
	 		 				 temp.add(sescore[j]);
	 		 			 }
	 		 			 result.setExtraScores(temp);
	 		 		 }
	 		 		rs1.close();
	 		 		 t1.setTeamName(teamName1);
	 		 		 t2.setTeamName(teamName2);
	 		 		 rs = stmt.executeQuery("select * from matchplayer"+season+" where generalMatch="+matchID+" and teamName='"+teamName1+"'");
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
	 		 			 mp.setError(rs.getInt("turnover"));
	 		 			 mp.setFoul(rs.getInt("foul"));
	 		 			 mp.setScore(rs.getInt("score"));	
	 		 			 players1.add(mp);
	 		 		 }
	 		 		 t1.setPlayers(players1);
	 		 		 rs = stmt.executeQuery("select * from matchplayer"+season+" where generalMatch="+matchID+" and teamName='"+teamName2+"'");
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
	 		 			 mp.setError(rs.getInt("turnover"));
	 		 			 mp.setFoul(rs.getInt("foul"));
	 		 			 mp.setScore(rs.getInt("score"));	
	 		 			 players2.add(mp);
	 		 		 }
	 		 		 t2.setPlayers(players2);
	 		 		 result.setTeam1(t1);
	 		 		 result.setTeam2(t2);
	 		 	Result.add(result);
			}
	 		rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			
		}
		return Result;
	}//获取所有比赛信息
	
	public ArrayList<MatchPO> getTeamRecentMatchInfo(int number,String teamName){
		MatchData md=new MatchData();
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		ArrayList<String> date=new ArrayList<String>();
		
		String season[]={"14_15_after","14_15","13_14_after","13_14","12_13_after","12_13","11_12_after","11_12","10_11_after","10_11","09_10_after","09_10","08_09_after","08_09","07_08_after","07_08","06_07_after","06_07","05_06_after","05_06",};
		try {
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection();
			for(int i=19;i>=0;i--){
				Statement stmt = conn.createStatement();  
				ResultSet rs = stmt.executeQuery("select * from generalmatch"+season[i]+" where teamName1='"+teamName+"' or teamName2='"+teamName+"'");	
		 		
				while(rs.next()){
		 			 date.add(rs.getString("matchTime")+";"+season[i]);
		 		}
				
		 		rs.close();
		 		stmt.close();
		 		
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int j=date.size()-1;j>date.size()-number-1&j>0;j--){
			String d[]=date.get(j).split(";");
			result.add(md.getSingleMatchInfo(teamName, d[0],d[1]));
		}
		return result;
	}//获取球队最近比赛，number为比赛场数，teamName为队名
	
	public ArrayList<MatchPO> getPlayerRecentMatchInfo(int number,String playerName){
		MatchData md=new MatchData();
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		ArrayList<String> date=new ArrayList<String>();
		ArrayList<String> teamName=new ArrayList<String>();
		
		String season[]={"14_15_after","14_15","13_14_after","13_14","12_13_after","12_13","11_12_after","11_12","10_11_after","10_11","09_10_after","09_10","08_09_after","08_09","07_08_after","07_08","06_07_after","06_07","05_06_after","05_06",};
		try {
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection();
			for(int i=19;i>=0;i--){
				Statement stmt = conn.createStatement();  
				ResultSet rs = stmt.executeQuery("select * from generalmatch"+season[i]+" where ID in(select generalMatch from matchplayer"+season[i]+" where playerName='"+playerName+"')");	
	 		 
				while(rs.next()){
					date.add(rs.getString("MatchTime")+";"+season[i]);
					teamName.add(rs.getString("teamName1"));
				}
	 		
				rs.close();
				stmt.close();
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int j=date.size()-1;j>date.size()-number-1&j>0;j--){
			String d[]=date.get(j).split(";");
			result.add(md.getSingleMatchInfo(teamName.get(j),d[0],d[1]));
		}
		return result;
	}//获取球员最近比赛，number为比赛场数，playername为队员名
	
	public ArrayList<MatchPO> getTodayMatchInfo(String date,String season){
		MatchData md=new MatchData();
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		try {
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection(); 
			Statement stmt = conn.createStatement();  
	 		 
			ResultSet rs = stmt.executeQuery("select * from generalmatch"+season+" where matchTime='"+date+"'");	
			while(rs.next()){
				result.add(md.getSingleMatchInfo(rs.getString("teamName1"),rs.getString("matchTime"),season));
			}

			rs.close();
			stmt.close();
			conn.close();
	 	 } catch (Exception e) {
				e.printStackTrace();
	 	 }
		return result;
	}//获取某日的比赛
	
	public ArrayList<MatchPO> getMatchOfTeam(String teamName,String season){
		ArrayList<MatchPO> Result=new ArrayList<MatchPO>();
		ArrayList<Integer> id=new ArrayList<Integer>();
		try {
			 ConnectMySQL c=new ConnectMySQL();
			 Connection conn=c.getConnection();
			 Statement stmt = conn.createStatement();  
			 String sql="select * from generalmatch"+season+" where (teamName1='"+teamName+"' or teamName2='"+teamName+"')";
	 		 ResultSet rs = stmt.executeQuery(sql);	
	 		 while(rs.next()){
	 			 id.add(rs.getInt("id"));
	 		 }
	 		for(int i=0;i<id.size();i++){
				MatchPO result=new MatchPO();
	 			MatchTeam t1=new MatchTeam();
	 			MatchTeam t2=new MatchTeam();
	 			String teamName1="";
	 			String teamName2="";
	 			String escore="";
	 			String[] sescore;
	 			int matchID=0;
	 			ArrayList<String> temp=new ArrayList<String>();
	 			ArrayList<MatchPlayer> players1=new ArrayList<MatchPlayer>();
	 			ArrayList<MatchPlayer> players2=new ArrayList<MatchPlayer>();
	 		 	ResultSet rs1 = stmt.executeQuery("select * from generalmatch"+season+" where id='"+id.get(i)+"'");	
	 		 		 
	 		 		while(rs1.next()){
	 		 			 matchID=rs1.getInt("id");
	 		 			 result.setMatchTime(rs1.getString("matchTime"));
	 		 			 teamName1=rs1.getString("teamName1");
	 		 			 teamName2=rs1.getString("teamName2");
	 		 			 result.setTeams(teamName1+"-"+teamName2);
	 		 			 result.setScore(rs1.getString("score"));
	 		 			 result.setScore1(rs1.getString("score1"));
	 		 			 result.setScore2(rs1.getString("score2"));
	 		 			 result.setScore3(rs1.getString("score3"));
	 		 			 result.setScore4(rs1.getString("score4"));
	 		 			 escore=rs1.getString("extrascores");
	 		 			 sescore=escore.split(";");
	 		 			 for(int j=0;j<sescore.length;j++){
	 		 				 temp.add(sescore[j]);
	 		 			 }
	 		 			 result.setExtraScores(temp);
	 		 		 }
	 		 		rs1.close();
	 		 		 t1.setTeamName(teamName1);
	 		 		 t2.setTeamName(teamName2);
	 		 		 rs = stmt.executeQuery("select * from matchplayer"+season+" where generalMatch="+matchID+" and teamName='"+teamName1+"'");
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
	 		 			 mp.setError(rs.getInt("turnover"));
	 		 			 mp.setFoul(rs.getInt("foul"));
	 		 			 mp.setScore(rs.getInt("score"));	
	 		 			 players1.add(mp);
	 		 		 }
	 		 		 t1.setPlayers(players1);
	 		 		 rs = stmt.executeQuery("select * from matchplayer"+season+" where generalMatch="+matchID+" and teamName='"+teamName2+"'");
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
	 		 			 mp.setError(rs.getInt("turnover"));
	 		 			 mp.setFoul(rs.getInt("foul"));
	 		 			 mp.setScore(rs.getInt("score"));	
	 		 			 players2.add(mp);
	 		 		 }
	 		 		 t2.setPlayers(players2);
	 		 		 result.setTeam1(t1);
	 		 		 result.setTeam2(t2);
	 		 	Result.add(result);
			}
	 		rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			
		}
		return Result;
	}
	
	/*public static void main(String[] args){
		MatchData md=new MatchData();
		ArrayList<MatchPO> a=md.getAllMatchInfo("14_15");
		System.out.println(a.size());
	}*/
}
