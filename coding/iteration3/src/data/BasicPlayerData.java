package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

import po.MatchPlayer;
import po.PlayerPO;

public class BasicPlayerData {
	public ArrayList<PlayerPO> getPlayerInfo(String filename){
		File readfile = new File("C:\\Users\\yq13y_000\\Desktop\\player\\"+filename);
		ArrayList<PlayerPO> result= new ArrayList<PlayerPO>();
		try {
			ArrayList<String> wtf = new ArrayList<String>();
			InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
			BufferedReader br = new BufferedReader( read);
			for(String s = br.readLine();s != null; s = br.readLine()){
				wtf.add(s);
			}
			br.close();
			for(int i=0;i<wtf.size();i++){
				PlayerPO temp=new PlayerPO();
				String[] c=wtf.get(i).split(";");
				temp.setPlayerName(c[0]);
				temp.setNumber(c[1]);
				temp.setPosition(c[2]);
				temp.setHeight(c[3]);
				temp.setWeight(c[4]);
				temp.setBirth(c[5]);
				temp.setAge(c[6]);
				temp.setExp(c[7]);
				temp.setSchool(c[8]);
				temp.setTeamName(c[9]);
				temp.setGamesPlayed(Integer.parseInt(c[10]));
				temp.setGamesStarting(Integer.parseInt(c[11]));
				temp.setRebounds(Double.parseDouble(c[12]));
				temp.setOffensiveRebounds(Double.parseDouble(c[13]));
				temp.setDefensiveRebounds(Double.parseDouble(c[14]));
				temp.setAssists(Double.parseDouble(c[15]));
				temp.setMinutes(Double.parseDouble(c[16]));
				temp.setFieldGoalsAttempts(Double.parseDouble(c[17]));
				temp.setFieldGoalsMade(Double.parseDouble(c[18]));
				temp.setFieldGoalsPercentage(Double.parseDouble(c[19]));
				temp.setThreePointFieldGoalsAttempts(Double.parseDouble(c[20]));
				temp.setThreePointFieldGoalsMade(Double.parseDouble(c[21]));
				temp.setThreePointFieldGoalsPercentage(Double.parseDouble(c[22]));
				temp.setFreeThrowsAttempts(Double.parseDouble(c[23]));
				temp.setFreeThrowsMade(Double.parseDouble(c[24]));
				temp.setFreeThrowsPercentage(Double.parseDouble(c[25]));
				temp.setSteals(Double.parseDouble(c[26]));
				temp.setBlocks(Double.parseDouble(c[27]));
				temp.setTurnovers(Double.parseDouble(c[28]));
				temp.setFouls(Double.parseDouble(c[29]));
				temp.setPoints(Double.parseDouble(c[30]));
				temp.setEfficiency(Double.parseDouble(c[31]));
				temp.setGmSc(Double.parseDouble(c[32]));
				temp.setTrueShootingPercentage(Double.parseDouble(c[33]));
				temp.setShootingEfficiency(Double.parseDouble(c[34]));
				temp.setReboundRating(Double.parseDouble(c[35]));
				temp.setOffensiveReboundRating(Double.parseDouble(c[36]));
				temp.setDefensiveReboundRating(Double.parseDouble(c[37]));
				temp.setAssisyRating(Double.parseDouble(c[38]));
				temp.setStealRating(Double.parseDouble(c[39]));
				temp.setBlockRating(Double.parseDouble(c[40]));
				temp.setTurnoverRating(Double.parseDouble(c[41]));
				temp.setUtilizationRating(Double.parseDouble(c[42]));
				temp.setDoubleDouble(Double.parseDouble(c[43]));
				result.add(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*public static void main(String[]args){
		BasicPlayerData bpd=new BasicPlayerData();
		SaveInfo si=new SaveInfo();
		String[] filename={"05-06\\playoff","05-06\\regular","06-07\\playoff","06-07\\regular","07-08\\playoff","07-08\\regular","08-09\\playoff","08-09\\regular","09-10\\playoff","09-10\\regular","10-11\\playoff","10-11\\regular","11-12\\playoff","11-12\\regular","12-13\\playoff","12-13\\regular","13-14\\playoff","13-14\\regular","14-15\\playoff","14-15\\regular"};
		String[] season={"05_06_after","05_06","06_07_after","06_07","07_08_after","07_08","08_09_after","08_09","09_10_after","09_10","10_11_after","10_11","11_12_after","11_12","12_13_after","12_13","13_14_after","13_14","14_15_after","14_15"};
		for(int i=0;i<filename.length;i++){
			ArrayList<PlayerPO> a=bpd.getPlayerInfo(filename[i]);
			for(int k=0;k<a.size();k++){
				try {
					si.savePlayerInfo(season[i],a.get(k));
				} catch (Exception e) {
				}
			}
		}
		bpd.getIncrease("14_15");
	}*/
	public double CalculateIncreaseOfPoints(ArrayList<MatchPlayer> MP){
		int num=MP.size();
		double A=0,B=0,result=0;
		if(num>=6){
			for(int i=num-1;i>=num-5;i--){
				B=MP.get(i).getScore()+B;
			}
			B=B/5;
			for(int i=num-6;i>=0;i--){
				A=MP.get(i).getScore()+A;
			}
			A=A/(num-5);
			if(A!=0)
				result=(B-A)/A;
		}
		return result;
	}
	
	public double CalculateIncreaseOfAssists(ArrayList<MatchPlayer> MP){
		int num=MP.size();
		double A=0,B=0,result=0;
		if(num>=6){
			for(int i=num-1;i>=num-5;i--){
				B=MP.get(i).getAssist()+B;
			}
			B=B/5;
			for(int i=num-6;i>=0;i--){
				A=MP.get(i).getAssist()+A;
			}
			A=A/(num-5);
			if(A!=0)
				result=(B-A)/A;
		}
		return result;
	}
	
	public double CalculateIncreaseOfRebounds(ArrayList<MatchPlayer> MP){
		int num=MP.size();
		double A=0,B=0,result=0;
		if(num>=6){
			for(int i=num-1;i>=num-5;i--){
				B=MP.get(i).getRebound()+B;
			}
			B=B/5;
			for(int i=num-6;i>=0;i--){
				A=MP.get(i).getRebound()+A;
			}
			A=A/(num-5);
			if(A!=0)
				result=(B-A)/A;
		}
		return result;
	}
	
	public void getIncrease(String season){
		BasicPlayerData bpd=new BasicPlayerData();
		try {
			ArrayList<PlayerPO> pp1=new PlayerData().getAllPlayerInfo(season);
			ArrayList<PlayerPO> pp2=new PlayerData().getAllPlayerInfo(season+"_after");
			ConnectMySQL c=new ConnectMySQL();
			Connection conn=c.getConnection();
			
			for(int i=0;i<pp1.size();i++){
				Statement stmt=conn.createStatement();
				ArrayList<MatchPlayer> MP=new ArrayList<MatchPlayer> ();
				String name=pp1.get(i).getPlayerName().replace("'", "''");
				String sql1 ="select * from matchplayer"+season+" where playerName='" + name + "'";

				ResultSet rs1=stmt.executeQuery(sql1);
				while(rs1.next()){
					MatchPlayer mp=new MatchPlayer();
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
		 			 mp.setError(rs1.getInt("turnover"));
		 			 mp.setFoul(rs1.getInt("foul"));
		 			 mp.setScore(rs1.getInt("score"));
		 			MP.add(mp);
				}
				rs1.close();
				String sql2 ="select * from matchplayer"+season+"_after where playerName='" + name + "'";
				ResultSet rs2=stmt.executeQuery(sql2);
				while(rs2.next()){
					MatchPlayer mp=new MatchPlayer();
		 			 mp.setPlayerName(rs2.getString("playerName"));
		 			 mp.setPosition(rs2.getString("position"));
		 			 mp.setMatchTime(rs2.getString("matchTime"));
		 			 mp.setFieldGoal(rs2.getInt("fieldGoal"));
		 			 mp.setFieldGoalAttempts(rs2.getInt("fieldGoalAttempts"));
		 			 mp.setThreePointShot(rs2.getInt("threepointShot"));
		 			 mp.setThreePointAttempts(rs2.getInt("threepointAttempts"));
		 			 mp.setFreeThrowGoal(rs2.getInt("freeThrowGoal"));
		 			 mp.setFreeThrowAttempts(rs2.getInt("freeThrowAttempts"));
		 			 mp.setOffensiveRebound(rs2.getInt("offensiveRebound"));
		 			 mp.setDefensiveRebound(rs2.getInt("defensiveRebound"));
		 			 mp.setRebound(rs2.getInt("rebound"));
		 			 mp.setAssist(rs2.getInt("assist"));
		 			 mp.setST(rs2.getInt("st"));	
		 			 mp.setBlockShot(rs2.getInt("blockShot"));
		 			 mp.setError(rs2.getInt("turnover"));
		 			 mp.setFoul(rs2.getInt("foul"));
		 			 mp.setScore(rs2.getInt("score"));
		 			MP.add(mp);
				}
				rs2.close();
				stmt.close();
				double iop=bpd.CalculateIncreaseOfPoints(MP);
				double ioa=bpd.CalculateIncreaseOfAssists(MP);
				double ior=bpd.CalculateIncreaseOfRebounds(MP);
				
				PreparedStatement pstmt;
				String sql3 = "update player"+season+" set increaseOfPoints='" + iop + "' where playerName='" + name + "'";
				String sql4 = "update player"+season+" set increaseOfAssists='" + ioa + "' where playerName='" + name + "'";
				String sql5 = "update player"+season+" set increaseOfRebounds='" + ior + "' where playerName='" + name + "'";
				pstmt = (PreparedStatement) conn.prepareStatement(sql3);
			    pstmt.executeUpdate();
			    pstmt = (PreparedStatement) conn.prepareStatement(sql4);
			    pstmt.executeUpdate();
			    pstmt = (PreparedStatement) conn.prepareStatement(sql5);
			    pstmt.executeUpdate();
			    pstmt.close();
			}
			
			for(int i=0;i<pp2.size();i++){
				Statement stmt=conn.createStatement();
				ArrayList<MatchPlayer> MP=new ArrayList<MatchPlayer> ();
				String name=pp2.get(i).getPlayerName().replace("'", "''");
				String sql1 ="select * from matchplayer"+season+" where playerName='" + name + "'";
				ResultSet rs1=stmt.executeQuery(sql1);
				while(rs1.next()){
					MatchPlayer mp=new MatchPlayer();
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
		 			 mp.setError(rs1.getInt("turnover"));
		 			 mp.setFoul(rs1.getInt("foul"));
		 			 mp.setScore(rs1.getInt("score"));
		 			MP.add(mp);
				}
				rs1.close();
				String sql2 ="select * from matchplayer"+season+"_after where playerName='" + name + "'";
				ResultSet rs2=stmt.executeQuery(sql2);
				while(rs2.next()){
					MatchPlayer mp=new MatchPlayer();
		 			 mp.setPlayerName(rs2.getString("playerName"));
		 			 mp.setPosition(rs2.getString("position"));
		 			 mp.setMatchTime(rs2.getString("matchTime"));
		 			 mp.setFieldGoal(rs2.getInt("fieldGoal"));
		 			 mp.setFieldGoalAttempts(rs2.getInt("fieldGoalAttempts"));
		 			 mp.setThreePointShot(rs2.getInt("threepointShot"));
		 			 mp.setThreePointAttempts(rs2.getInt("threepointAttempts"));
		 			 mp.setFreeThrowGoal(rs2.getInt("freeThrowGoal"));
		 			 mp.setFreeThrowAttempts(rs2.getInt("freeThrowAttempts"));
		 			 mp.setOffensiveRebound(rs2.getInt("offensiveRebound"));
		 			 mp.setDefensiveRebound(rs2.getInt("defensiveRebound"));
		 			 mp.setRebound(rs2.getInt("rebound"));
		 			 mp.setAssist(rs2.getInt("assist"));
		 			 mp.setST(rs2.getInt("st"));	
		 			 mp.setBlockShot(rs2.getInt("blockShot"));
		 			 mp.setError(rs2.getInt("turnover"));
		 			 mp.setFoul(rs2.getInt("foul"));
		 			 mp.setScore(rs2.getInt("score"));
		 			MP.add(mp);
				}
				rs2.close();
				stmt.close();
				double iop=bpd.CalculateIncreaseOfPoints(MP);
				double ioa=bpd.CalculateIncreaseOfAssists(MP);
				double ior=bpd.CalculateIncreaseOfRebounds(MP);
				
				PreparedStatement pstmt;
				String sql3 = "update player"+season+"_after set increaseOfPoints='" + iop + "' where playerName='" + name + "'";
				String sql4 = "update player"+season+"_after set increaseOfAssists='" + ioa + "' where playerName='" + name + "'";
				String sql5 = "update player"+season+"_after set increaseOfRebounds='" + ior + "' where playerName='" + name + "'";
				pstmt = (PreparedStatement) conn.prepareStatement(sql3);
			    pstmt.executeUpdate();
			    pstmt = (PreparedStatement) conn.prepareStatement(sql4);
			    pstmt.executeUpdate();
			    pstmt = (PreparedStatement) conn.prepareStatement(sql5);
			    pstmt.executeUpdate();
			    pstmt.close();
			}
			
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
