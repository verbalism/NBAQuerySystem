package data;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import po.MatchPO;

public class MatchDataCalculate {
	
	
	public void deleteAllMatch()throws Exception{
		File f=new File("");
	 	String s=f.getCanonicalPath();
	 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
		Statement stmt=conn.createStatement();
		
		stmt.executeUpdate("delete * from generalMatchInfo");
		stmt.executeUpdate("delete * from playerMatchInfo");
		
		stmt.close();
		conn.close();
		
	}
	
	
	public void BasicMatchOriginal() throws Exception{  
	 	//在数据库中读入比赛基本信息
	 
	 	File f=new File("");
	 	String s=f.getCanonicalPath();
	 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
        
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
        PreparedStatement pstmt = null;
        ArrayList<MatchPO> mp=new BasicMatchData().getMatchOriginal();
        for(int i=0;i<mp.size();i++){     	 
        	 String sql = "insert into generalMatchInfo (matchTime,score,score1,score2,score3,score4,extrascores,teamName1,teamName2) values(?,?,?,?,?,?,?,?,?)";
        	 pstmt = (PreparedStatement) conn.prepareStatement(sql);
             pstmt.setString(1, mp.get(i).getMatchTime());
             pstmt.setString(2, mp.get(i).getScore());
             pstmt.setString(3, mp.get(i).getScore1());
             pstmt.setString(4, mp.get(i).getScore2());
             pstmt.setString(5, mp.get(i).getScore3());
             pstmt.setString(6, mp.get(i).getScore4());
             int exs=mp.get(i).getExtraScores().size();
             String extraScores="";
             if(exs>0){
            	 extraScores=mp.get(i).getExtraScores().get(0);
            	 for(int j=1;j<exs;j++){
            		 extraScores=extraScores+";"+mp.get(i).getExtraScores().get(j);
            	 }	
             }
             pstmt.setString(7, extraScores);
             pstmt.setString(8, mp.get(i).getTeam1().getTeamName());
             pstmt.setString(9, mp.get(i).getTeam2().getTeamName());
             pstmt.executeUpdate();
             
             int generalMatchID=new MatchDataCalculate().getBasicMatchID(mp.get(i).getMatchTime(),mp.get(i).getTeam1().getTeamName());
             new MatchDataCalculate().playerMatchOriginal(generalMatchID, mp.get(i));
        } 
        pstmt.close();
        conn.close();
        System.out.println("比赛基本信息已读入");
	}
	
	
	public int Cal_Known(int MatchID,String teamName ,String type)throws Exception{
		//根据比赛ID和球队名称和所需数据类型呢获得新增的数据
		
		int result=0;
		
		File f=new File("");
	 	String s=f.getCanonicalPath();
	 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from playerMatchInfo where generalmatch="+MatchID+" and teamName='"+teamName+"'");
		while(rs.next()){
			if(type.equals("fieldGoalsMade")){
				result=result+rs.getInt("fieldGoal");
			}
			else if(type.equals("fieldGoalsAttempted")){
				result=result+rs.getInt("fieldGoalAttempts");
			}
			else if(type.equals("threePointFieldGoalsMade")){
				result=result+rs.getInt("threepointShot");
			}
			else if(type.equals("threePointFieldGoalsAttempted")){
				result=result+rs.getInt("threepointAttempts");
			}
			else if(type.equals("freeThrowsMade")){
				result=result+rs.getInt("freeThrowGoal");
			}
			else if(type.equals("freeThrowsAttempted")){
				result=result+rs.getInt("freeThrowAttempts");
			}
			else if(type.equals("offensiveRebounds")){
				result=result+rs.getInt("offensiveRebound");
			}
			else if(type.equals("defensiveRebounds")){
				result=result+rs.getInt("defensiveRebound");
			}
			else if(type.equals("rebounds")){
				result=result+rs.getInt("rebound");
			}
			else if(type.equals("assists")){
				result=result+rs.getInt("assist");
			}
			else if(type.equals("steals")){
				result=result+rs.getInt("st");
			}
			else if(type.equals("blocks")){
				result=result+rs.getInt("blockShot");
			}
			else if(type.equals("turnovers")){
				result=result+rs.getInt("error");
			}
			else if(type.equals("fouls")){
				result=result+rs.getInt("foul");
			}
			else if(type.equals("points")){
				result=result+rs.getInt("score");
			}
		}
		rs.close();
		stmt.close();
		conn.close();
		return result;
	}
	
	
	public int getBasicMatchID(String matchtime,String team1)throws Exception{
		//根据比赛时间和队名获得该场比赛的generalID
		
		int result=0;
		File f=new File("");
	 	String s=f.getCanonicalPath();
	 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select ID from generalMatchInfo");
		while(rs.next()){
			result=rs.getInt("ID");
		}
		stmt.close();
		conn.close();
        return  result+1;
        
		
	}
	
	public void playerMatchOriginal(int matchID,MatchPO mp)throws Exception{
		
		//数据库中写入球员比赛信息
		File f=new File("");
	 	String s=f.getCanonicalPath();
	 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
        PreparedStatement pstmt=null;
        for(int i=0;i<mp.getTeam1().getPlayers().size();i++){
        	String sql = "insert into playerMatchInfo (generalMatch,teamName,oppositeTeamName,playerName,position,matchTime,fieldGoal,fieldGoalAttempts,threepointShot,threepointAttempts,freeThrowGoal,freeThrowAttempts,offensiveRebound,defensiveRebound,rebound,assist,st,blockShot,error,foul,score) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        	pstmt = (PreparedStatement) conn.prepareStatement(sql);
        	pstmt.setInt(1, matchID);
            pstmt.setString(2, mp.getTeam1().getTeamName());
            pstmt.setString(3, mp.getTeam2().getTeamName());
            pstmt.setString(4, mp.getTeam1().getPlayers().get(i).getPlayerName());
            pstmt.setString(5, mp.getTeam1().getPlayers().get(i).getPosition());
            pstmt.setString(6, mp.getTeam1().getPlayers().get(i).getMatchTime());
            pstmt.setDouble(7, mp.getTeam1().getPlayers().get(i).getFieldGoal());
            pstmt.setDouble(8, mp.getTeam1().getPlayers().get(i).getFieldGoalAttempts());
            pstmt.setDouble(9, mp.getTeam1().getPlayers().get(i).getThreePointShot());
            pstmt.setDouble(10, mp.getTeam1().getPlayers().get(i).getThreePointAttempts());
            pstmt.setDouble(11, mp.getTeam1().getPlayers().get(i).getFreeThrowGoal());
            pstmt.setDouble(12, mp.getTeam1().getPlayers().get(i).getFreeThrowAttempts());
            pstmt.setDouble(13, mp.getTeam1().getPlayers().get(i).getOffensiveRebound());
            pstmt.setDouble(14, mp.getTeam1().getPlayers().get(i).getDefensiveRebound());
            pstmt.setDouble(15, mp.getTeam1().getPlayers().get(i).getRebound());
            pstmt.setDouble(16, mp.getTeam1().getPlayers().get(i).getAssist());
            pstmt.setDouble(17, mp.getTeam1().getPlayers().get(i).getST());
            pstmt.setDouble(18, mp.getTeam1().getPlayers().get(i).getBlockShot());
            pstmt.setDouble(19, mp.getTeam1().getPlayers().get(i).getError());
            pstmt.setDouble(20, mp.getTeam1().getPlayers().get(i).getFoul());
            pstmt.setDouble(21, mp.getTeam1().getPlayers().get(i).getScore());
            pstmt.executeUpdate();
        }
        
        for(int i=0;i<mp.getTeam2().getPlayers().size();i++){
        	String sql = "insert into playerMatchInfo (generalMatch,teamName,oppositeTeamName,playerName,position,matchTime,fieldGoal,fieldGoalAttempts,threepointShot,threepointAttempts,freeThrowGoal,freeThrowAttempts,offensiveRebound,defensiveRebound,rebound,assist,st,blockShot,error,foul,score) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        	pstmt = (PreparedStatement) conn.prepareStatement(sql);
        	pstmt.setInt(1, matchID);
            pstmt.setString(2, mp.getTeam2().getTeamName());
            pstmt.setString(3, mp.getTeam1().getTeamName());
            pstmt.setString(4, mp.getTeam2().getPlayers().get(i).getPlayerName());
            pstmt.setString(5, mp.getTeam2().getPlayers().get(i).getPosition());
            pstmt.setString(6, mp.getTeam2().getPlayers().get(i).getMatchTime());
            pstmt.setDouble(7, mp.getTeam2().getPlayers().get(i).getFieldGoal());
            pstmt.setDouble(8, mp.getTeam2().getPlayers().get(i).getFieldGoalAttempts());
            pstmt.setDouble(9, mp.getTeam2().getPlayers().get(i).getThreePointShot());
            pstmt.setDouble(10, mp.getTeam2().getPlayers().get(i).getThreePointAttempts());
            pstmt.setDouble(11, mp.getTeam2().getPlayers().get(i).getFreeThrowGoal());
            pstmt.setDouble(12, mp.getTeam2().getPlayers().get(i).getFreeThrowAttempts());
            pstmt.setDouble(13, mp.getTeam2().getPlayers().get(i).getOffensiveRebound());
            pstmt.setDouble(14, mp.getTeam2().getPlayers().get(i).getDefensiveRebound());
            pstmt.setDouble(15, mp.getTeam2().getPlayers().get(i).getRebound());
            pstmt.setDouble(16, mp.getTeam2().getPlayers().get(i).getAssist());
            pstmt.setDouble(17, mp.getTeam2().getPlayers().get(i).getST());
            pstmt.setDouble(18, mp.getTeam2().getPlayers().get(i).getBlockShot());
            pstmt.setDouble(19, mp.getTeam2().getPlayers().get(i).getError());
            pstmt.setDouble(20, mp.getTeam2().getPlayers().get(i).getFoul());
            pstmt.setDouble(21, mp.getTeam2().getPlayers().get(i).getScore());
            pstmt.executeUpdate();
           
        }
        pstmt.close();
        conn.close();
	}
	
	

}
