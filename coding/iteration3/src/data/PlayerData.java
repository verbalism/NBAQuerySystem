package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dataService.PlayerDataService;
import po.PlayerPO;
import po.TodayPlayerPO;

public class PlayerData implements PlayerDataService{
	public PlayerPO getSinglePlayerInfo(String playerName,String season){
		String name=playerName.replace("'", "''");
		PlayerPO result=new PlayerPO();
		try{
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection();
			Statement stmt=conn.createStatement();
			String sql1="select * from allplayer where playerName='"+name+"'";
			ResultSet rs0=stmt.executeQuery(sql1);
			while(rs0.next()){
				result.setPlayerName(rs0.getString("playerName"));
				result.setNumber(rs0.getString("playerNumber"));
				result.setPosition(rs0.getString("position"));
				result.setHeight(rs0.getString("height"));
				result.setWeight(rs0.getString("weight"));
				result.setBirth(rs0.getString("birth"));
				result.setAge(rs0.getString("age"));
				result.setExp(rs0.getString("exp"));
				result.setSchool(rs0.getString("school"));
			}
			rs0.close();
			String sql2 ="select * from player"+season+" where playerID in (select playerID from allplayer where playerName='"+name+"')";
			ResultSet rs=stmt.executeQuery(sql2);
			while(rs.next()){
				result.setTeamName(rs.getString("teamName"));
				result.setGamesPlayed(rs.getInt("gamesPlayed"));
				result.setGamesStarting(rs.getInt("gamesStarting"));
				result.setRebounds(rs.getDouble("rebounds"));
				result.setOffensiveRebounds(rs.getDouble("offensiveRebounds"));
				result.setDefensiveRebounds(rs.getDouble("defensiveRebounds"));
				result.setAssists(rs.getDouble("assists"));
				result.setMinutes(rs.getDouble("minutes"));
				result.setFieldGoalsAttempts(rs.getDouble("fieldGoalsAttempts"));
				result.setFieldGoalsMade(rs.getDouble("fieldGoalsMade"));
				result.setFieldGoalsPercentage(rs.getDouble("fieldGoalsPercentage"));
				result.setThreePointFieldGoalsAttempts(rs.getDouble("threePointFieldGoalsAttempts"));
				result.setThreePointFieldGoalsMade(rs.getDouble("threePointFieldGoalsMade"));
				result.setThreePointFieldGoalsPercentage(rs.getDouble("threePointFieldGoalsPercentage"));
				result.setFreeThrowsAttempts(rs.getDouble("freeThrowsAttempts"));
				result.setFreeThrowsMade(rs.getDouble("freeThrowsMade"));
				result.setFreeThrowsPercentage(rs.getDouble("freeThrowsPercentage"));
				result.setSteals(rs.getDouble("steals"));
				result.setBlocks(rs.getDouble("blocks"));
				result.setTurnovers(rs.getDouble("turnovers"));
				result.setFouls(rs.getDouble("fouls"));
				result.setPoints(rs.getDouble("points"));
				result.setEfficiency(rs.getDouble("efficiency"));
				result.setGmSc(rs.getDouble("GmSc"));
				result.setTrueShootingPercentage(rs.getDouble("trueShootingPercentage"));
				result.setShootingEfficiency(rs.getDouble("shootingEfficiency"));
				result.setReboundRating(rs.getDouble("reboundRating"));
				result.setOffensiveReboundRating(rs.getDouble("offensiveReboundRating"));
				result.setDefensiveReboundRating(rs.getDouble("defensiveReboundRating"));
				result.setAssisyRating(rs.getDouble("assisyRating"));
				result.setStealRating(rs.getDouble("stealRating"));
				result.setBlockRating(rs.getDouble("blockRating"));
				result.setTurnoverRating(rs.getDouble("turnoverRating"));
				result.setUtilizationRating(rs.getDouble("utilizationRating"));
				result.setDoubleDouble(rs.getDouble("doubleDouble"));
				result.setIncreaseOfPoints(rs.getDouble("increaseOfPoints"));
				result.setIncreaseOfRebounds(rs.getDouble("increaseOfRebounds"));
				result.setIncreaseOfAssists(rs.getDouble("increaseOfAssists"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
		}
		
		return result;
	}//查询单个球员信息
	
	public ArrayList<PlayerPO> getAllPlayerInfo(String season){
		ArrayList<PlayerPO> Result=new ArrayList<PlayerPO>();
		try{
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection();
			Statement stmt=conn.createStatement();
			String sql ="select * from allplayer,player"+season+" where allplayer.playerID=player"+season+".playerID";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				PlayerPO result=new PlayerPO();
				result.setPlayerID(rs.getString("playerID"));
				result.setPlayerName(rs.getString("playerName"));
				result.setNumber(rs.getString("playerNumber"));
				result.setPosition(rs.getString("position"));
				result.setHeight(rs.getString("height"));
				result.setWeight(rs.getString("weight"));
				result.setBirth(rs.getString("birth"));
				result.setAge(rs.getString("age"));
				result.setExp(rs.getString("exp"));
				result.setSchool(rs.getString("school"));
				result.setTeamName(rs.getString("teamName"));
				result.setGamesPlayed(rs.getInt("gamesPlayed"));
				result.setGamesStarting(rs.getInt("gamesStarting"));
				result.setRebounds(rs.getDouble("rebounds"));
				result.setOffensiveRebounds(rs.getDouble("offensiveRebounds"));
				result.setDefensiveRebounds(rs.getDouble("defensiveRebounds"));
				result.setAssists(rs.getDouble("assists"));
				result.setMinutes(rs.getDouble("minutes"));
				result.setFieldGoalsAttempts(rs.getDouble("fieldGoalsAttempts"));
				result.setFieldGoalsMade(rs.getDouble("fieldGoalsMade"));
				result.setFieldGoalsPercentage(rs.getDouble("fieldGoalsPercentage"));
				result.setThreePointFieldGoalsAttempts(rs.getDouble("threePointFieldGoalsAttempts"));
				result.setThreePointFieldGoalsMade(rs.getDouble("threePointFieldGoalsMade"));
				result.setThreePointFieldGoalsPercentage(rs.getDouble("threePointFieldGoalsPercentage"));
				result.setFreeThrowsAttempts(rs.getDouble("freeThrowsAttempts"));
				result.setFreeThrowsMade(rs.getDouble("freeThrowsMade"));
				result.setFreeThrowsPercentage(rs.getDouble("freeThrowsPercentage"));
				result.setSteals(rs.getDouble("steals"));
				result.setBlocks(rs.getDouble("blocks"));
				result.setTurnovers(rs.getDouble("turnovers"));
				result.setFouls(rs.getDouble("fouls"));
				result.setPoints(rs.getDouble("points"));
				result.setEfficiency(rs.getDouble("efficiency"));
				result.setGmSc(rs.getDouble("GmSc"));
				result.setTrueShootingPercentage(rs.getDouble("trueShootingPercentage"));
				result.setShootingEfficiency(rs.getDouble("shootingEfficiency"));
				result.setReboundRating(rs.getDouble("reboundRating"));
				result.setOffensiveReboundRating(rs.getDouble("offensiveReboundRating"));
				result.setDefensiveReboundRating(rs.getDouble("defensiveReboundRating"));
				result.setAssisyRating(rs.getDouble("assisyRating"));
				result.setStealRating(rs.getDouble("stealRating"));
				result.setBlockRating(rs.getDouble("blockRating"));
				result.setTurnoverRating(rs.getDouble("turnoverRating"));
				result.setUtilizationRating(rs.getDouble("utilizationRating"));
				result.setDoubleDouble(rs.getDouble("doubleDouble"));
				result.setIncreaseOfPoints(rs.getDouble("increaseOfPoints"));
				result.setIncreaseOfRebounds(rs.getDouble("increaseOfRebounds"));
				result.setIncreaseOfAssists(rs.getDouble("increaseOfAssists"));
				Result.add(result);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
		}
		return Result;
	}//查询全部球员信息
	
	public ArrayList<TodayPlayerPO> getTodayPlayerInfo(String date,String season){
		ArrayList<TodayPlayerPO> Result=new ArrayList<TodayPlayerPO>();
		try{
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection();
			Statement stmt=conn.createStatement();
			String sql ="select * from matchplayer"+season+" where generalMatch in (select id from generalmatch"+season+" where matchTime='"+date+"')";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				TodayPlayerPO result=new TodayPlayerPO();
				result.setTeamName(rs.getString("teamName"));
				result.setOppositeTeamName(rs.getString("oppositeTeamName"));
				result.setPlayerName(rs.getString("playerName"));
				result.setPosition(rs.getString("position"));
				result.setMatchTime(rs.getString("matchTime"));
				result.setFieldGoal(rs.getDouble("fieldGoal"));
				result.setFieldGoalAttempts(rs.getDouble("fieldGoalAttempts"));
				result.setThreepointShot(rs.getDouble("threepointShot"));
				result.setThreepointAttempts(rs.getDouble("threepointAttempts"));
				result.setFreeThrowGoal(rs.getDouble("freeThrowGoal"));
				result.setFreeThrowAttempts(rs.getDouble("freeThrowAttempts"));
				result.setOffensiveRebound(rs.getDouble("offensiveRebound"));
				result.setDefensiveRebound(rs.getDouble("defensiveRebound"));
				result.setRebound(rs.getDouble("rebound"));
				result.setAssist(rs.getDouble("assist"));
				result.setSt(rs.getDouble("st"));
				result.setBlockShot(rs.getDouble("blockShot"));
				result.setError(rs.getDouble("turnover"));
				result.setFoul(rs.getDouble("foul"));
				result.setScore(rs.getDouble("score"));
				Result.add(result);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
		}
		return Result;
	}//查询当天球员信息
	
	/*public static void main(String[]args){
		PlayerData pd=new PlayerData();
		ArrayList<PlayerPO> a=pd.getAllPlayerInfo("05_06_after");
		System.out.println(a.get(2).getBirth());
	}*/
	
}
