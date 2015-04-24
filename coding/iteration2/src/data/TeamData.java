package data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dataService.TeamDataService;
import po.BasicTeamPO;
import po.TeamPO;

public class TeamData implements TeamDataService{
	public TeamPO getSingleTeamInfo(String teamName){
		TeamPO tp=new TeamPO();
		 try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
	   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	 	 	 String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	 		 Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	 		 Statement stmt = conn.createStatement();  
		     
		     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+teamName+"'");
		     while(rs.next()){
		    	 tp.setTeamName(rs.getString("TeamName"));
		    	 tp.setGamesPlayed(rs.getInt("gamesPlayed"));
		    	 tp.setFieldGoalsMade(rs.getDouble("fieldGoalsMade"));
		    	 tp.setFieldGoalsAttempted(rs.getDouble("fieldGoalsAttempted"));
		    	 tp.setThreePointFieldGoalsMade(rs.getDouble("threePointFieldGoalsMade"));
		    	 tp.setThreePointFieldGoalsAttempted(rs.getDouble("threePointFieldGoalsAttempted"));
		    	 tp.setFreeThrowsMade(rs.getDouble("freeThrowsMade"));
		    	 tp.setFreeThrowsAttempted(rs.getDouble("freeThrowsAttempted"));
		    	 tp.setOffensiveRebounds(rs.getDouble("offensiveRebounds"));
		    	 tp.setDefensiveRebounds(rs.getDouble("defensiveRebounds"));
		    	 tp.setRebounds(rs.getDouble("rebounds"));
		    	 tp.setAssists(rs.getDouble("assists"));
		    	 tp.setSteals(rs.getDouble("steals"));
		    	 tp.setBlocks(rs.getDouble("blocks"));
		    	 tp.setTurnovers(rs.getDouble("turnovers"));
		    	 tp.setFouls(rs.getDouble("fouls"));
		    	 tp.setPoints(rs.getDouble("points"));
		    	 tp.setFieldGoalPercentage(rs.getDouble("fieldGoalpercentage"));
		    	 tp.setThreePointFieldGoalPercentage(rs.getDouble("threePointFieldGoalPercentage"));
		    	 tp.setFreeThrowPercentage(rs.getDouble("freeThrowPercentage"));
		    	 tp.setWinPercentage(rs.getDouble("winPercentage"));
		    	 tp.setPossessions(rs.getDouble("possessions"));
		    	 tp.setOffensiveRating(rs.getDouble("offensiveRating"));
		    	 tp.setDefensiveRating(rs.getDouble("defensiveRating"));
		    	 tp.setOffensiveReboundPercentage(rs.getDouble("offensiveReboundPercentage"));
		    	 tp.setDefensiveReboundPercentage(rs.getDouble("defensiveReboundPercentage"));
		    	 tp.setStealPercentage(rs.getDouble("stealPercentage"));
		    	 tp.setAssistPercentage(rs.getDouble("assistPercentage"));
		    	 tp.setFullName(rs.getString("fullName"));
		    	 tp.setCity(rs.getString("city"));
		    	 tp.setZone(rs.getString("zone"));
		    	 tp.setSubarea(rs.getString("subarea"));
		    	 tp.setHomeCourt(rs.getString("homeCourt"));
		    	 tp.setCreateTime(rs.getString("createTime"));
		    	 tp.setGamesPlayedWin(rs.getInt("gamesPlayedWin"));
		    	 tp.setOppFieldGoalsMade(rs.getDouble("oppFieldGoalsMade"));
		    	 tp.setOppFieldGoalsAttempted(rs.getInt("oppFieldGoalsAttempted"));
		    	 tp.setOppFreeThrowsAttempted(rs.getDouble("oppFreeThrowsAttempted"));
		    	 tp.setOppTurnovers(rs.getDouble("oppTurnovers"));
		    	 tp.setOppSteals(rs.getDouble("oppSteals"));
		    	 tp.setOppAssists(rs.getDouble("oppAssists"));
		    	 tp.setOppOffensiveRebounds(rs.getDouble("oppOffensiveRebounds"));
		    	 tp.setOppDefensiveRebounds(rs.getDouble("oppDefensiveRebounds"));
		    	 tp.setOppPoints(rs.getDouble("oppPoints"));
		    	 tp.setOppPossessions(rs.getDouble("oppPossessions"));
		     }
		     rs.close();
		     stmt.close();
		     conn.close();
        
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		 return tp;
	}
	public ArrayList<TeamPO> getAllTeamInfo(){
		ArrayList<TeamPO> result=new ArrayList<TeamPO>();
		TeamData td=new TeamData();
		try {
			File f=new File("");
			String s=f.getCanonicalPath();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
			String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
			Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
			Statement stmt = conn.createStatement();  
			
			ResultSet rs = stmt.executeQuery("select * from teamInfo");
			
			while(rs.next()){
				TeamPO tp=td.getSingleTeamInfo(rs.getString("teamName"));
				result.add(tp);
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
	
	/*public static void main(String[]args){
		TeamData td=new TeamData();
		TeamPO tp=td.getSingleTeamInfo("BOS");
		System.out.println(tp.getFreeThrowsAttempted());
	}*/
}
