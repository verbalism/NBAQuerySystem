package data;

import java.sql.*;
import java.util.ArrayList;

import po.MatchPO;
import po.MatchPlayer;
import po.PlayerPO;
import po.TeamPO;

public class SaveInfo {
//------------------------存储球员信息----------------------//
	public void savePlayerInfo(String postfix,PlayerPO pp) throws Exception{
		ConnectMySQL c=new ConnectMySQL();
		Connection conn=c.getConnection();
		String sql1="select * from allplayer where playerID='"+pp.getPlayerID()+"'";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql1);
		if(!rs.next()){
			String sql2 = "insert into allplayer (playerID,playerName,playerNumber,position,height,weight,birth,age,exp,school) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt.setString(1,pp.getPlayerID());
			pstmt.setString(2,pp.getPlayerName());
			pstmt.setString(3,pp.getNumber());
			pstmt.setString(4,pp.getPosition());
			pstmt.setString(5,pp.getHeight());
			pstmt.setString(6,pp.getWeight());
			pstmt.setString(7,pp.getBirth());
			pstmt.setString(8,pp.getAge());
			pstmt.setString(9,pp.getExp());
			pstmt.setString(10,pp.getSchool());
			pstmt.executeUpdate();
		    pstmt.close();
		}
		String sql3 = "insert into player"+postfix+" (playerID,teamName,gamesPlayed,gamesStarting,rebounds,offensiveRebounds,defensiveRebounds,assists,minutes,fieldGoalsAttempts,fieldGoalsMade,fieldGoalsPercentage,threePointFieldGoalsAttempts,threePointFieldGoalsMade,threePointFieldGoalsPercentage,freeThrowsAttempts,freeThrowsMade,freeThrowsPercentage,steals,blocks,turnovers,fouls,points,efficiency,GmSc,trueShootingPercentage,shootingEfficiency,reboundRating,offensiveReboundRating,defensiveReboundRating,assisyRating,stealRating,blockRating,turnoverRating,utilizationRating,doubleDouble,increaseOfPoints,increaseOfRebounds,increaseOfAssists) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    
	    pstmt = (PreparedStatement) conn.prepareStatement(sql3);
	    pstmt.setString(1, pp.getPlayerID());
	    pstmt.setString(2,pp.getTeamName());
	    pstmt.setInt(3,pp.getGamesPlayed());
	    pstmt.setInt(4,pp.getGamesStarting());
	    pstmt.setDouble(5,pp.getRebounds());
	    pstmt.setDouble(6,pp.getOffensiveRebounds());
	    pstmt.setDouble(7,pp.getDefensiveRebounds());
	    pstmt.setDouble(8,pp.getAssists());
	    pstmt.setDouble(9,pp.getMinutes());
	    pstmt.setDouble(10,pp.getFieldGoalsAttempts());
	    pstmt.setDouble(11,pp.getFieldGoalsMade());
	    pstmt.setDouble(12,pp.getFieldGoalsPercentage());
	    pstmt.setDouble(13,pp.getThreePointFieldGoalsAttempts());
	    pstmt.setDouble(14,pp.getThreePointFieldGoalsMade());
	    pstmt.setDouble(15,pp.getThreePointFieldGoalsPercentage());
	    pstmt.setDouble(16,pp.getFreeThrowsAttempts());
	    pstmt.setDouble(17,pp.getFreeThrowsMade());
	    pstmt.setDouble(18,pp.getFreeThrowsPercentage());
	    pstmt.setDouble(19,pp.getSteals());
	    pstmt.setDouble(20,pp.getBlocks());
	    pstmt.setDouble(21,pp.getTurnovers());
	    pstmt.setDouble(22,pp.getFouls());
	    pstmt.setDouble(23,pp.getPoints());
	    pstmt.setDouble(24,pp.getEfficiency());
	    pstmt.setDouble(25,pp.getGmSc());
	    pstmt.setDouble(26,pp.getTrueShootingPercentage());
	    pstmt.setDouble(27,pp.getShootingEfficiency());
	    pstmt.setDouble(28,pp.getReboundRating());
	    pstmt.setDouble(29,pp.getOffensiveReboundRating());
	    pstmt.setDouble(30,pp.getDefensiveReboundRating());
	    pstmt.setDouble(31,pp.getAssisyRating());
	    pstmt.setDouble(32,pp.getStealRating());
	    pstmt.setDouble(33,pp.getBlockRating());
	    pstmt.setDouble(34,pp.getTurnoverRating());
	    pstmt.setDouble(35,pp.getUtilizationRating());
	    pstmt.setDouble(36,pp.getDoubleDouble());
	    pstmt.setDouble(37,pp.getIncreaseOfPoints());
	    pstmt.setDouble(38,pp.getIncreaseOfRebounds());
	    pstmt.setDouble(39,pp.getIncreaseOfAssists());
	    
	    pstmt.executeUpdate();
	    
	    pstmt.close();
	    conn.close();
	}
	
//------------------------存储球队信息----------------------//
	public void saveTeamID(TeamPO pp) throws Exception{
		ConnectMySQL c=new ConnectMySQL();
		Connection conn=c.getConnection();
		String sql="insert into allteam (teamID,teamName,fullName,city,zone,subarea,homeCourt,createTime) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1,pp.getTeamID());
		pstmt.setString(2,pp.getTeamName());
		pstmt.setString(3,pp.getFullName());
		pstmt.setString(4,pp.getCity());
		pstmt.setString(5,pp.getZone());
		pstmt.setString(6,pp.getSubarea());
		pstmt.setString(7,pp.getHomeCourt());
		pstmt.setString(8,pp.getCreateTime());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	public void saveTeamInfo(String postfix,TeamPO pp) throws Exception{
		ConnectMySQL c=new ConnectMySQL();
		Connection conn=c.getConnection();
		String sql = "insert into team"+postfix+" (teamID,teamName,gamesPlayed,fieldGoalsMade,fieldGoalsAttempted,threePointFieldGoalsMade,threePointFieldGoalsAttempted,freeThrowsMade,freeThrowsAttempted,offensiveRebounds,defensiveRebounds,rebounds,assists,steals,blocks,turnovers,fouls,points,fieldGoalPercentage,threePointFieldGoalPercentage,freeThrowPercentage,winPercentage,possessions,offensiveRating,defensiveRating,offensiveReboundPercentage,defensiveReboundPercentage,stealPercentage,assistPercentage,fullName,city,zone,subarea,homeCourt,createTime,gamesPlayedWin) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
	    
	    pstmt = (PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1, pp.getTeamID());
	    pstmt.setString(2,pp.getTeamName());
	    pstmt.setInt(3,pp.getGamesPlayed());
	    pstmt.setDouble(4,pp.getFieldGoalsMade());
	    pstmt.setDouble(5,pp.getFieldGoalsAttempted());
	    pstmt.setDouble(6,pp.getThreePointFieldGoalsMade());
	    pstmt.setDouble(7,pp.getThreePointFieldGoalsAttempted());
	    pstmt.setDouble(8,pp.getFreeThrowsMade());
	    pstmt.setDouble(9,pp.getFreeThrowsAttempted());
	    pstmt.setDouble(10,pp.getOffensiveRebounds());
	    pstmt.setDouble(11,pp.getDefensiveRebounds());
	    pstmt.setDouble(12,pp.getRebounds());
	    pstmt.setDouble(13,pp.getAssists());
	    pstmt.setDouble(14,pp.getSteals());
	    pstmt.setDouble(15,pp.getBlocks());
	    pstmt.setDouble(16,pp.getTurnovers());
	    pstmt.setDouble(17,pp.getFouls());
	    pstmt.setDouble(18,pp.getPoints());
	    pstmt.setDouble(19,pp.getFieldGoalPercentage());
	    pstmt.setDouble(20,pp.getThreePointFieldGoalPercentage());
	    pstmt.setDouble(21,pp.getFreeThrowPercentage());
	    pstmt.setDouble(22,pp.getWinPercentage());
	    pstmt.setDouble(23,pp.getPossessions());
	    pstmt.setDouble(24,pp.getOffensiveRating());
	    pstmt.setDouble(25,pp.getDefensiveRating());
	    pstmt.setDouble(26,pp.getOffensiveReboundPercentage());
	    pstmt.setDouble(27,pp.getDefensiveReboundPercentage());
	    pstmt.setDouble(28,pp.getStealPercentage());
	    pstmt.setDouble(29,pp.getAssistPercentage());
	    pstmt.setString(30,pp.getFullName());
	    pstmt.setString(31,pp.getCity());
	    pstmt.setString(32,pp.getZone());
	    pstmt.setString(33,pp.getSubarea());
	    pstmt.setString(34,pp.getHomeCourt());
	    pstmt.setString(35,pp.getCreateTime());
	    pstmt.setDouble(36,pp.getGamesPlayedWin());
	    
	    pstmt.executeUpdate();
	    
	    pstmt.close();
	    conn.close();
	}
	
//------------------------存储比赛信息----------------------//
	public void saveMatchInfo(String postfix,int id,MatchPO pp) throws Exception{
		ConnectMySQL c=new ConnectMySQL();
		Connection conn=c.getConnection();
		String sql = "insert into generalMatch"+postfix+" (matchTime,score,score1,score2,score3,score4,extrascores,teamName1,teamName2) values(?,?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    pstmt = (PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1,pp.getMatchTime());
	    pstmt.setString(2,pp.getScore());
	    pstmt.setString(3,pp.getScore1());
	    pstmt.setString(4,pp.getScore2());
	    pstmt.setString(5,pp.getScore3());
	    pstmt.setString(6,pp.getScore4());
	    ArrayList<String> es=pp.getExtraScores();
	    String extraScores="";
	    for(int i=0;i<es.size();i++){
	    	if(extraScores.equals(""))
	    		extraScores=es.get(i);
	    	else
	    		extraScores=extraScores+";"+es.get(i);
	    }
	    pstmt.setString(7,extraScores);
	    pstmt.setString(8,pp.getTeam1().getTeamName());
	    pstmt.setString(9,pp.getTeam2().getTeamName());
	    
	    pstmt.executeUpdate();
	    
	    pstmt.close();
	    
	    //--------------------------------------------------------//
	    
	    ArrayList<MatchPlayer> mp1=pp.getTeam1().getPlayers();
	    ArrayList<MatchPlayer> mp2=pp.getTeam2().getPlayers();
	    String sql1 = "insert into matchplayer"+postfix+" (generalMatch,teamName,oppositeTeamName,playerName,position,matchTime,fieldGoal,fieldGoalAttempts,threepointShot,threepointAttempts,freeThrowGoal,freeThrowAttempts,offensiveRebound,defensiveRebound,rebound,assist,st,blockShot,turnover,foul,score) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    for(int i=0;i<mp1.size();i++){
	    	PreparedStatement pstmt1;
	    	pstmt1 = (PreparedStatement) conn.prepareStatement(sql1);
	    	pstmt1.setInt(1,id);
	    	pstmt1.setString(2,pp.getTeam1().getTeamName());
	    	pstmt1.setString(3,pp.getTeam2().getTeamName());
	    	pstmt1.setString(4,mp1.get(i).getPlayerName());
	    	pstmt1.setString(5,mp1.get(i).getPosition());
	    	pstmt1.setString(6,mp1.get(i).getMatchTime());
	    	pstmt1.setDouble(7,mp1.get(i).getFieldGoal());
	    	pstmt1.setDouble(8,mp1.get(i).getFieldGoalAttempts());
	    	pstmt1.setDouble(9,mp1.get(i).getThreePointShot());
	    	pstmt1.setDouble(10,mp1.get(i).getThreePointAttempts());
	    	pstmt1.setDouble(11,mp1.get(i).getFreeThrowGoal());
	    	pstmt1.setDouble(12,mp1.get(i).getFreeThrowAttempts());
	    	pstmt1.setDouble(13,mp1.get(i).getOffensiveRebound());
	    	pstmt1.setDouble(14,mp1.get(i).getDefensiveRebound());
	    	pstmt1.setDouble(15,mp1.get(i).getRebound());
	    	pstmt1.setDouble(16,mp1.get(i).getAssist());
	    	pstmt1.setDouble(17,mp1.get(i).getST());
	    	pstmt1.setDouble(18,mp1.get(i).getBlockShot());
	    	pstmt1.setDouble(19,mp1.get(i).getError());
	    	pstmt1.setDouble(20,mp1.get(i).getFoul());
	    	pstmt1.setDouble(21,mp1.get(i).getScore());
	    	
	    	pstmt1.executeUpdate();
		    
		    pstmt1.close();
	    }
	    
	    for(int i=0;i<mp2.size();i++){
	    	PreparedStatement pstmt1;
	    	pstmt1 = (PreparedStatement) conn.prepareStatement(sql1);
	    	pstmt1.setInt(1,id);
	    	pstmt1.setString(2,pp.getTeam2().getTeamName());
	    	pstmt1.setString(3,pp.getTeam1().getTeamName());
	    	pstmt1.setString(4,mp2.get(i).getPlayerName());
	    	pstmt1.setString(5,mp2.get(i).getPosition());
	    	pstmt1.setString(6,mp2.get(i).getMatchTime());
	    	pstmt1.setDouble(7,mp2.get(i).getFieldGoal());
	    	pstmt1.setDouble(8,mp2.get(i).getFieldGoalAttempts());
	    	pstmt1.setDouble(9,mp2.get(i).getThreePointShot());
	    	pstmt1.setDouble(10,mp2.get(i).getThreePointAttempts());
	    	pstmt1.setDouble(11,mp2.get(i).getFreeThrowGoal());
	    	pstmt1.setDouble(12,mp2.get(i).getFreeThrowAttempts());
	    	pstmt1.setDouble(13,mp2.get(i).getOffensiveRebound());
	    	pstmt1.setDouble(14,mp2.get(i).getDefensiveRebound());
	    	pstmt1.setDouble(15,mp2.get(i).getRebound());
	    	pstmt1.setDouble(16,mp2.get(i).getAssist());
	    	pstmt1.setDouble(17,mp2.get(i).getST());
	    	pstmt1.setDouble(18,mp2.get(i).getBlockShot());
	    	pstmt1.setDouble(19,mp2.get(i).getError());
	    	pstmt1.setDouble(20,mp2.get(i).getFoul());
	    	pstmt1.setDouble(21,mp2.get(i).getScore());
	    	
	    	pstmt1.executeUpdate();
		    
		    pstmt1.close();
	    }
	    
	    conn.close();
	}
	
	
	
	/*public static void main(String[] args) throws Exception{
		
	}*/
}
