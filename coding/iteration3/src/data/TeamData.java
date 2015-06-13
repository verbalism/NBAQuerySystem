package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dataService.TeamDataService;
import po.TeamPO;
import po.TodayPlayerPO;

public class TeamData implements TeamDataService{
	public TeamPO getSingleTeamInfo(String teamName,String season){
		TeamPO result=new TeamPO();
		try{
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection();
			Statement stmt=conn.createStatement();
			String sql ="select * from team"+season+" where teamName='"+teamName+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				result.setTeamName(rs.getString("teamName"));
				result.setGamesPlayed(rs.getInt("gamesPlayed"));
				result.setFieldGoalsMade(rs.getDouble("fieldGoalsMade"));
				result.setFieldGoalsAttempted(rs.getDouble("fieldGoalsAttempted"));
				result.setThreePointFieldGoalsMade(rs.getDouble("threePointFieldGoalsMade"));
				result.setThreePointFieldGoalsAttempted(rs.getDouble("threePointFieldGoalsAttempted"));
				result.setFreeThrowsMade(rs.getDouble("freeThrowsMade"));
				result.setFreeThrowsAttempted(rs.getDouble("freeThrowsAttempted"));
				result.setOffensiveRebounds(rs.getDouble("offensiveRebounds"));
				result.setDefensiveRebounds(rs.getDouble("defensiveRebounds"));
				result.setRebounds(rs.getDouble("rebounds"));
				result.setAssists(rs.getDouble("assists"));
				result.setSteals(rs.getDouble("steals"));
				result.setBlocks(rs.getDouble("blocks"));
				result.setTurnovers(rs.getDouble("turnovers"));
				result.setFouls(rs.getDouble("fouls"));
				result.setPoints(rs.getDouble("points"));
				result.setFieldGoalPercentage(rs.getDouble("fieldGoalPercentage"));
				result.setThreePointFieldGoalPercentage(rs.getDouble("threePointFieldGoalPercentage"));
				result.setFreeThrowPercentage(rs.getDouble("freeThrowPercentage"));
				result.setWinPercentage(rs.getDouble("winPercentage"));
				result.setPossessions(rs.getDouble("possessions"));
				result.setOffensiveRating(rs.getDouble("offensiveRating"));
				result.setDefensiveRating(rs.getDouble("defensiveRating"));
				result.setOffensiveReboundPercentage(rs.getDouble("offensiveReboundPercentage"));
				result.setDefensiveReboundPercentage(rs.getDouble("defensiveReboundPercentage"));
				result.setStealPercentage(rs.getDouble("stealPercentage"));
				result.setAssistPercentage(rs.getDouble("assistPercentage"));
				result.setFullName(rs.getString("fullName"));
				result.setCity(rs.getString("city"));
				result.setZone(rs.getString("zone"));
				result.setSubarea(rs.getString("subarea"));
				result.setHomeCourt(rs.getString("homeCourt"));
				result.setCreateTime(rs.getString("createTime"));
				result.setGamesPlayedWin(rs.getDouble("gamesPlayedWin"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
		}
		return result;
	}//获得单个球队信息根据球队名
	
	public ArrayList<TeamPO> getAllTeamInfo(String season){
		ArrayList<TeamPO> Result=new ArrayList<TeamPO>();
		try{
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection();
			Statement stmt=conn.createStatement();
			String sql ="select * from team"+season;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				TeamPO result=new TeamPO();
				result.setTeamName(rs.getString("teamName"));
				result.setGamesPlayed(rs.getInt("gamesPlayed"));
				result.setFieldGoalsMade(rs.getDouble("fieldGoalsMade"));
				result.setFieldGoalsAttempted(rs.getDouble("fieldGoalsAttempted"));
				result.setThreePointFieldGoalsMade(rs.getDouble("threePointFieldGoalsMade"));
				result.setThreePointFieldGoalsAttempted(rs.getDouble("threePointFieldGoalsAttempted"));
				result.setFreeThrowsMade(rs.getDouble("freeThrowsMade"));
				result.setFreeThrowsAttempted(rs.getDouble("freeThrowsAttempted"));
				result.setOffensiveRebounds(rs.getDouble("offensiveRebounds"));
				result.setDefensiveRebounds(rs.getDouble("defensiveRebounds"));
				result.setRebounds(rs.getDouble("rebounds"));
				result.setAssists(rs.getDouble("assists"));
				result.setSteals(rs.getDouble("steals"));
				result.setBlocks(rs.getDouble("blocks"));
				result.setTurnovers(rs.getDouble("turnovers"));
				result.setFouls(rs.getDouble("fouls"));
				result.setPoints(rs.getDouble("points"));
				result.setFieldGoalPercentage(rs.getDouble("fieldGoalPercentage"));
				result.setThreePointFieldGoalPercentage(rs.getDouble("threePointFieldGoalPercentage"));
				result.setFreeThrowPercentage(rs.getDouble("freeThrowPercentage"));
				result.setWinPercentage(rs.getDouble("winPercentage"));
				result.setPossessions(rs.getDouble("possessions"));
				result.setOffensiveRating(rs.getDouble("offensiveRating"));
				result.setDefensiveRating(rs.getDouble("defensiveRating"));
				result.setOffensiveReboundPercentage(rs.getDouble("offensiveReboundPercentage"));
				result.setDefensiveReboundPercentage(rs.getDouble("defensiveReboundPercentage"));
				result.setStealPercentage(rs.getDouble("stealPercentage"));
				result.setAssistPercentage(rs.getDouble("assistPercentage"));
				result.setFullName(rs.getString("fullName"));
				result.setCity(rs.getString("city"));
				result.setZone(rs.getString("zone"));
				result.setSubarea(rs.getString("subarea"));
				result.setHomeCourt(rs.getString("homeCourt"));
				result.setCreateTime(rs.getString("createTime"));
				result.setGamesPlayedWin(rs.getDouble("gamesPlayedWin"));
				Result.add(result);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
		}
		return Result;
	}//获取所有球队信息。返回arraylist
	
	/*public static void main(String[]args){
		TeamData pd=new TeamData();
		ArrayList<TeamPO> a=pd.getAllTeamInfo("08_09");
		System.out.println(a.get(3).getDefensiveRebounds());
	}*/
}
