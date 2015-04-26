package data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import po.PlayerPO;
import po.TodayPlayerPO;
import dataService.PlayerDataService;

public class PlayerData implements PlayerDataService{
	public PlayerPO getSinglePlayerInfo(String playerName){
		PlayerPO result=new PlayerPO();
		try{
			File directory = new File("");
			String courseFile = directory.getCanonicalPath() ;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
			Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
        
			String name=playerName.replace("'", "''");
			String sql = "select * from playerInfo where playerName='" + name + "'";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
        
			while(rs.next()){
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
				result.setMinutes(rs.getString("minutes"));
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
				result.setAllTimeOfTeam(rs.getString("allTimeOfTeam"));
				result.setAllReboundsOfTeam(rs.getDouble("allReboundsOfTeam"));
				result.setAllOffensiveReboundsOfTeam(rs.getDouble("allOffensiveReboundsOfTeam"));
				result.setAlldefensiveReboundsOfTeam(rs.getDouble("alldefensiveReboundsOfTeam"));
				result.setAllReboundsOfOpposite(rs.getDouble("allReboundsOfOpposite"));
				result.setAllOffensiveReboundsOfOpposite(rs.getDouble("allOffensiveReboundsOfOpposite"));
				result.setAlldefensiveReboundsOfOpposite(rs.getDouble("alldefensiveReboundsOfOpposite"));
				result.setAllFieldGoalsMade(rs.getDouble("allFieldGoalsMade"));
				result.setAllDefenseOfOpposite(rs.getDouble("allDefenseOfOpposite"));
				result.setTwoPointFieldGoalsAttemptsOfOpposite(rs.getDouble("twoPointFieldGoalsAttemptsOfOpposite"));
				result.setTwoPointFieldGoalsAttempts(rs.getDouble("twoPointFieldGoalsAttempts"));
				result.setAllFieldGoalsAttemptsOfTeam(rs.getDouble("allFieldGoalsAttemptsOfTeam"));
				result.setAllFreeGoalsAttemptsOfTeam(rs.getDouble("allFreeGoalsAttemptsOfTeam"));
				result.setAllturnoversOfTeam(rs.getDouble("allturnoversOfTeam"));
				result.setAllFieldGoalsAttemptsOfOpposite(rs.getDouble("allFieldGoalsAttemptsOfOpposite"));
				result.setAllFreeGoalsAttemptsOfOpposite(rs.getDouble("allFreeGoalsAttemptsOfOpposite"));
				result.setAllMissedGoalsOfOpposite(rs.getDouble("allMissedGoalsOfOpposite"));
				result.setAllturnoversOfOpposite(rs.getDouble("allturnoversOfOpposite"));
				result.setIncreaseOfPoints(rs.getDouble("increaseOfPoints"));
				result.setIncreaseOfRebounds(rs.getDouble("increaseOfRebounds"));
				result.setIncreaseOfAssists(rs.getDouble("increaseOfAssists"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
        return result;
	}
	
	public ArrayList<PlayerPO> getAllPlayerInfo(){
		ArrayList<PlayerPO> pp=new ArrayList<PlayerPO>();
		try{
			File directory = new File("");
			String courseFile = directory.getCanonicalPath() ;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
			Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
			
			String sql = "select * from playerInfo";
	        PreparedStatement pstmt;
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        
	        while(rs.next()){
	        	PlayerPO result=new PlayerPO();
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
				result.setMinutes(rs.getString("minutes"));
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
				result.setAllTimeOfTeam(rs.getString("allTimeOfTeam"));
				result.setAllReboundsOfTeam(rs.getDouble("allReboundsOfTeam"));
				result.setAllOffensiveReboundsOfTeam(rs.getDouble("allOffensiveReboundsOfTeam"));
				result.setAlldefensiveReboundsOfTeam(rs.getDouble("alldefensiveReboundsOfTeam"));
				result.setAllReboundsOfOpposite(rs.getDouble("allReboundsOfOpposite"));
				result.setAllOffensiveReboundsOfOpposite(rs.getDouble("allOffensiveReboundsOfOpposite"));
				result.setAlldefensiveReboundsOfOpposite(rs.getDouble("alldefensiveReboundsOfOpposite"));
				result.setAllFieldGoalsMade(rs.getDouble("allFieldGoalsMade"));
				result.setAllDefenseOfOpposite(rs.getDouble("allDefenseOfOpposite"));
				result.setTwoPointFieldGoalsAttemptsOfOpposite(rs.getDouble("twoPointFieldGoalsAttemptsOfOpposite"));
				result.setTwoPointFieldGoalsAttempts(rs.getDouble("twoPointFieldGoalsAttempts"));
				result.setAllFieldGoalsAttemptsOfTeam(rs.getDouble("allFieldGoalsAttemptsOfTeam"));
				result.setAllFreeGoalsAttemptsOfTeam(rs.getDouble("allFreeGoalsAttemptsOfTeam"));
				result.setAllturnoversOfTeam(rs.getDouble("allturnoversOfTeam"));
				result.setAllFieldGoalsAttemptsOfOpposite(rs.getDouble("allFieldGoalsAttemptsOfOpposite"));
				result.setAllFreeGoalsAttemptsOfOpposite(rs.getDouble("allFreeGoalsAttemptsOfOpposite"));
				result.setAllMissedGoalsOfOpposite(rs.getDouble("allMissedGoalsOfOpposite"));
				result.setAllturnoversOfOpposite(rs.getDouble("allturnoversOfOpposite"));
				result.setIncreaseOfPoints(rs.getDouble("increaseOfPoints"));
				result.setIncreaseOfRebounds(rs.getDouble("increaseOfRebounds"));
				result.setIncreaseOfAssists(rs.getDouble("increaseOfAssists"));
				pp.add(result);
	        }
	        rs.close();
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pp;
	}
	
	public ArrayList<TodayPlayerPO> getTodayPlayerInfo(String date){
		ArrayList<TodayPlayerPO> result=new ArrayList<TodayPlayerPO>();
		try{
			File directory = new File("");
			String courseFile = directory.getCanonicalPath() ;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+courseFile+"//NBAIteration2";  
			Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
			
			Statement stmt=conn.createStatement();
	        
	        String sql ="select * from playerMatchInfo where generalMatch in (select ID from generalMatchInfo where matchTime='"+date+"')";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while(rs.next()){
	        	TodayPlayerPO tpp=new TodayPlayerPO();
	        	tpp.setTeamName(rs.getString("teamName"));
	        	tpp.setOppositeTeamName(rs.getString("oppositeTeamName"));
	        	tpp.setPlayerName(rs.getString("playerName"));
	        	tpp.setPosition(rs.getString("position"));
	        	tpp.setMatchTime(rs.getString("matchTime"));
	        	tpp.setFieldGoal(rs.getDouble("fieldGoal"));
	        	tpp.setFieldGoalAttempts(rs.getDouble("fieldGoalAttempts"));
	        	tpp.setThreepointShot(rs.getDouble("threepointShot"));
	        	tpp.setThreepointAttempts(rs.getDouble("threepointAttempts"));
	        	tpp.setFreeThrowGoal(rs.getDouble("freeThrowGoal"));
	        	tpp.setFreeThrowAttempts(rs.getDouble("freeThrowAttempts"));
	        	tpp.setOffensiveRebound(rs.getDouble("offensiveRebound"));
	        	tpp.setDefensiveRebound(rs.getDouble("defensiveRebound"));
	        	tpp.setRebound(rs.getDouble("rebound"));
	        	tpp.setAssist(rs.getDouble("assist"));
	        	tpp.setSt(rs.getDouble("st"));
	        	tpp.setBlockShot(rs.getDouble("blockShot"));
	        	tpp.setError(rs.getDouble("error"));
	        	tpp.setFoul(rs.getDouble("foul"));
	        	tpp.setScore(rs.getDouble("score"));
	        	result.add(tpp);
	        }
	        rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void updatePlayerInfo(ArrayList<Integer> matchID){
		PlayerDataCalculate pdc=new PlayerDataCalculate();
		pdc.update(matchID);
	}
	
	public void updateBasicPlayerInfo(){
		PlayerDataCalculate pdc=new PlayerDataCalculate();
		pdc.updateBasic();
	}
	
	public static void main(String []args){
		/*PlayerData pd=new PlayerData();
		
		PlayerPO pp=pd.getSinglePlayerInfo("LeBron James");
		System.out.println(pp.getAge());
		
		ArrayList<TodayPlayerPO> tpp=pd.getTodayPlayerInfo("01-01");
		for(int i=0;i<tpp.size();i++){
			System.out.println(tpp.get(i).getPlayerName());
		}*/
	}
}
