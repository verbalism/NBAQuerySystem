package data;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectMySQL {
	public Connection getConnection() throws Exception{
		String driverClass=null;
		String jdbcurl=null;
		String user=null;
		String password=null;
		
		InputStream in=getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties=new Properties();
		properties.load(in);
		driverClass=properties.getProperty("driver");
		jdbcurl=properties.getProperty("jdbcurl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
		
		Driver driver=(Driver) Class.forName(driverClass).newInstance();
		Properties info=new Properties();
		info.put("user",user);
		info.put("password", password);
		Connection conn=driver.connect(jdbcurl,info);
		return conn; 
	}
	
	public void create(){
		String season[]={"14_15_after","14_15","13_14_after","13_14","12_13_after","12_13","11_12_after","11_12","10_11_after","10_11","09_10_after","09_10","08_09_after","08_09","07_08_after","07_08","06_07_after","06_07","05_06_after","05_06",};
		try {
			ConnectMySQL c=new ConnectMySQL();
			Connection conn = c.getConnection();
			for(int i=19;i>=0;i--){
				String sql1 = "CREATE TABLE generalmatch"+season[i]+"(id int unsigned not null auto_increment primary key,"
					+ "matchTime char(20) not null,score char(10) not null,score1 char(10) not null,score2 char(10) not null,score3 char(10) not null,score4 char(10) not null,extrascores char(50) not null,teamName1 char(20) not null,teamName2 char(20) not null)";
				String sql2 = "CREATE TABLE matchplayer"+season[i]+"(id int unsigned not null auto_increment primary key,"
					+ "generalMatch int not null,teamName char(20) not null,oppositeTeamName char(20) not null,playerName char(20) not null,position char(20) not null,matchTime char(20) not null,fieldGoal double not null,fieldGoalAttempts double not null,"
					+ "threepointShot double not null,threepointAttempts double not null,freeThrowGoal double not null,freeThrowAttempts double not null,offensiveRebound double not null,defensiveRebound double not null,rebound double not null,"
					+ "assist double not null,st double not null,blockShot double not null,turnover double not null,foul double not null,score double not null)";
				String sql3 = "CREATE TABLE player"+season[i]+"(id int unsigned not null auto_increment primary key,"
					+ "playerName char(50) not null,playerNumber char(10) not null,position char(50) not null,height char(10) not null,weight char(10) not null,"
					+ "birth char(20) not null,age char(10) not null,exp char(20) not null,school char(50) not null,teamName char(20) not null,gamesPlayed int not null,gamesStarting int not null,rebounds double not null,offensiveRebounds double not null,"
					+ "defensiveRebounds double not null,assists double not null,minutes double not null,fieldGoalsAttempts double not null,fieldGoalsMade double not null,fieldGoalsPercentage double not null,threePointFieldGoalsAttempts double not null,"
					+ "threePointFieldGoalsMade double not null,threePointFieldGoalsPercentage double not null,freeThrowsAttempts double not null,freeThrowsMade double not null,freeThrowsPercentage double not null,steals double not null,blocks double not null,"
					+ "turnovers double not null,fouls double not null,points double not null,efficiency double not null,GmSc double not null,trueShootingPercentage double not null,shootingEfficiency double not null,reboundRating double not null,"
					+ "offensiveReboundRating double not null,defensiveReboundRating double not null,assisyRating double not null,stealRating double not null,blockRating double not null,turnoverRating double not null,utilizationRating double not null,"
					+ "doubleDouble double not null,increaseOfPoints double not null,increaseOfRebounds double not null,increaseOfAssists double not null)";
				String sql4 = "CREATE TABLE team"+season[i]+"(id int unsigned not null auto_increment primary key,"
					+ "teamName char(20) not null,gamesPlayed int not null,fieldGoalsMade double not null,fieldGoalsAttempted double not null,threePointFieldGoalsMade double not null,threePointFieldGoalsAttempted double not null,freeThrowsMade double not null,"
					+ "freeThrowsAttempted double not null,offensiveRebounds double not null,defensiveRebounds double not null,rebounds double not null,assists double not null,steals double not null,blocks double not null,turnovers double not null,"
					+ "fouls double not null,points double not null,fieldGoalPercentage double not null,threePointFieldGoalPercentage double not null,freeThrowPercentage double not null,winPercentage double not null,possessions double not null,"
					+ "offensiveRating double not null,defensiveRating double not null,offensiveReboundPercentage double not null,defensiveReboundPercentage double not null,stealPercentage double not null,"
					+ "AssistPercentage double not null,fullName char(20) not null,city char(50) not null,zone char(20) not null,subarea char(20) not null,homeCourt char(50) not null,createTime char(20) not null,gamesPlayedWin double not null)";
				
				
				PreparedStatement pstmt;
				pstmt = (PreparedStatement) conn.prepareStatement(sql1);
				pstmt.executeUpdate();
				pstmt = (PreparedStatement) conn.prepareStatement(sql2);
				pstmt.executeUpdate();
				pstmt = (PreparedStatement) conn.prepareStatement(sql3);
				pstmt.executeUpdate();
				pstmt = (PreparedStatement) conn.prepareStatement(sql4);
				pstmt.executeUpdate();
				pstmt.close();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drop(){
		String season[]={"14_15_after","14_15","13_14_after","13_14","12_13_after","12_13","11_12_after","11_12","10_11_after","10_11","09_10_after","09_10","08_09_after","08_09","07_08_after","07_08","06_07_after","06_07","05_06_after","05_06",};
		try {
			ConnectMySQL c=new ConnectMySQL();
			Connection conn = c.getConnection();
			for(int i=19;i>=0;i--){
				String sql1="DROP TABLE generalmatch"+season[i];
				String sql2="DROP TABLE matchplayer"+season[i];
				String sql3="DROP TABLE player"+season[i];
				String sql4="DROP TABLE team"+season[i];
				PreparedStatement pstmt;
				pstmt = (PreparedStatement) conn.prepareStatement(sql1);
				pstmt.executeUpdate();
				pstmt = (PreparedStatement) conn.prepareStatement(sql2);
				pstmt.executeUpdate();
				pstmt = (PreparedStatement) conn.prepareStatement(sql3);
				pstmt.executeUpdate();
				pstmt = (PreparedStatement) conn.prepareStatement(sql4);
				pstmt.executeUpdate();
				pstmt.close();
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args){
		ConnectMySQL c=new ConnectMySQL();
		c.drop();
		c.create();
	}*/
}
