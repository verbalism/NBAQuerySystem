package data;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import po.BasicTeamPO;
import po.TeamPO;
import po.MatchPO;

public class TeamDataCalculate{
	public boolean judgeEmptyFile(String address){
		boolean result=false;
		int size=0;
		FileInputStream fin;
		try {
			fin = new FileInputStream(address);
			size=fin.available();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(size==0){
			result=true;
		}
		return result;
	}//判断文件是否为空，为空返回true
	
	public void writeTeamInfo(ArrayList<TeamPO> teaminfo){
		//System.out.println("执行了writeTeamInfo");
		File f = new File("E://SE3//NBAQuerySystem//coding//iteration2//Data//teamInfoPO.txt");
		FileWriter fw ;
		BufferedWriter bw;
		try {
			fw=  new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw=new FileWriter(f);
			bw=new BufferedWriter(fw);
			for(int i=0;i<teaminfo.size();i++){
				bw.write(teaminfo.get(i).getTeamName()+";"+teaminfo.get(i).getGamesPlayed()+";"+teaminfo.get(i).getFieldGoalsMade()+";"+teaminfo.get(i).getFieldGoalsAttempted()+";"+teaminfo.get(i).getThreePointFieldGoalsMade()
						+";"+teaminfo.get(i).getThreePointFieldGoalsAttempted()+";"+teaminfo.get(i).getFreeThrowsMade()+";"+teaminfo.get(i).getFreeThrowsAttempted()+";"+teaminfo.get(i).getOffensiveRebounds()+";"+teaminfo.get(i).getDefensiveRebounds()
						+";"+teaminfo.get(i).getRebounds()+";"+teaminfo.get(i).getAssists()+";"+teaminfo.get(i).getSteals()+";"+teaminfo.get(i).getBlocks()+";"+teaminfo.get(i).getTurnovers()+";"+teaminfo.get(i).getFouls()+";"+teaminfo.get(i).getPoints()
						+";"+teaminfo.get(i).getFieldGoalPercentage()+";"+teaminfo.get(i).getThreePointFieldGoalPercentage()+";"+teaminfo.get(i).getFreeThrowPercentage()+";"+teaminfo.get(i).getWinPercentage()+";"+teaminfo.get(i).getPossessions()
						+";"+teaminfo.get(i).getOffensiveRating()+";"+teaminfo.get(i).getDefensiveRating()+";"+teaminfo.get(i).getOffensiveReboundPercentage()+";"+teaminfo.get(i).getDefensiveReboundPercentage()+";"+teaminfo.get(i).getStealPercentage()
						+";"+teaminfo.get(i).getAssistPercentage()+";"+teaminfo.get(i).getFullName()+";"+teaminfo.get(i).getCity()+";"+teaminfo.get(i).getZone()+";"+teaminfo.get(i).getSubarea()+";"+teaminfo.get(i).getHomeCourt()+";"+teaminfo.get(i).getCreateTime());
				bw.write("\r\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<TeamPO> readTeamInfo(){
		File f = new File("E://SE3//NBAQuerySystem//coding//iteration2//Data//teamInfoPO.txt");
		ArrayList<TeamPO> result=new ArrayList<TeamPO>();
		try{
			BufferedReader br=new BufferedReader(new FileReader(f));
			String s="";
			while((s=br.readLine())!=null){
				String[]temp=s.split(";");
				TeamPO tiv=new TeamPO();
				tiv.setTeamName(temp[0]);
				tiv.setGamesPlayed(Integer.parseInt(temp[1]));
				tiv.setFieldGoalsMade(Double.parseDouble(temp[2]));
				tiv.setFieldGoalsAttempted(Double.parseDouble(temp[3]));
				tiv.setThreePointFieldGoalsMade(Double.parseDouble(temp[4]));
				tiv.setThreePointFieldGoalsAttempted(Double.parseDouble(temp[5]));
				tiv.setFreeThrowsMade(Double.parseDouble(temp[6]));
				tiv.setFreeThrowsAttempted(Double.parseDouble(temp[7]));
				tiv.setOffensiveRebounds(Double.parseDouble(temp[8]));
				tiv.setDefensiveRebounds(Double.parseDouble(temp[9]));
				tiv.setRebounds(Double.parseDouble(temp[10]));
				tiv.setAssists(Double.parseDouble(temp[11]));
				tiv.setSteals(Double.parseDouble(temp[12]));
				tiv.setBlocks(Double.parseDouble(temp[13]));
				tiv.setTurnovers(Double.parseDouble(temp[14]));
				tiv.setFouls(Double.parseDouble(temp[15]));
				tiv.setPoints(Double.parseDouble(temp[16]));
				tiv.setFieldGoalPercentage(Double.parseDouble(temp[17]));
				tiv.setThreePointFieldGoalPercentage(Double.parseDouble(temp[18]));
				tiv.setFreeThrowPercentage(Double.parseDouble(temp[19]));
				tiv.setWinPercentage(Double.parseDouble(temp[20]));
				tiv.setPossessions(Double.parseDouble(temp[21]));
				tiv.setOffensiveRating(Double.parseDouble(temp[22]));
				tiv.setDefensiveRating(Double.parseDouble(temp[23]));
				tiv.setOffensiveReboundPercentage(Double.parseDouble(temp[24]));
				tiv.setDefensiveReboundPercentage(Double.parseDouble(temp[25]));
				tiv.setStealPercentage(Double.parseDouble(temp[26]));
				tiv.setAssistPercentage(Double.parseDouble(temp[27]));
				tiv.setFullName(temp[28]);
				tiv.setCity(temp[29]);
				tiv.setZone(temp[30]);
				tiv.setSubarea(temp[31]);
				tiv.setHomeCourt(temp[32]);
				tiv.setCreateTime(temp[33]);
				result.add(tiv);
			}
			br.close();    
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int calculateFieldGoalsMade(String name,ArrayList<MatchPO> mpselected){
		int fieldGoalsMadeCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					fieldGoalsMadeCounter=fieldGoalsMadeCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getFieldGoal();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					fieldGoalsMadeCounter=fieldGoalsMadeCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getFieldGoal();
				}
			}
		}
		return fieldGoalsMadeCounter;
	}
	
	public int calculateOppositeFieldGoalsMade(String name,ArrayList<MatchPO> mpselected){
		int oppositeFieldGoalsMadeCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					oppositeFieldGoalsMadeCounter=oppositeFieldGoalsMadeCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getFieldGoal();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					oppositeFieldGoalsMadeCounter=oppositeFieldGoalsMadeCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getFieldGoal();
				}
			}
		}
		return oppositeFieldGoalsMadeCounter;
	}//对手投篮命中数
	
	public int calculateFieldGoalsAttempted(String name,ArrayList<MatchPO> mpselected){
		int fieldGoalsAttemptedCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					fieldGoalsAttemptedCounter=fieldGoalsAttemptedCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getFieldGoalAttempts();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					fieldGoalsAttemptedCounter=fieldGoalsAttemptedCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getFieldGoalAttempts();
				}
			}
		}
		return fieldGoalsAttemptedCounter;
	}
	
	public int calculateOppositeFieldGoalsAttempted(String name,ArrayList<MatchPO> mpselected){
		int oppositeFieldGoalsAttemptedCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					oppositeFieldGoalsAttemptedCounter=oppositeFieldGoalsAttemptedCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getFieldGoalAttempts();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					oppositeFieldGoalsAttemptedCounter=oppositeFieldGoalsAttemptedCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getFieldGoalAttempts();
				}
			}
		}
		return oppositeFieldGoalsAttemptedCounter;
	}//对手的投篮数
	
	public int calculateThreePointFieldGoalsMade(String name,ArrayList<MatchPO> mpselected){
		int threePointFieldGoalsMadeCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					threePointFieldGoalsMadeCounter=threePointFieldGoalsMadeCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getThreePointShot();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					threePointFieldGoalsMadeCounter=threePointFieldGoalsMadeCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getThreePointShot();
				}
			}
		}
		return threePointFieldGoalsMadeCounter;
	}
	
	public int calculateThreePointFieldGoalsAttempted(String name,ArrayList<MatchPO> mpselected){
		int threePointFieldGoalsAttemptedCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					threePointFieldGoalsAttemptedCounter=threePointFieldGoalsAttemptedCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getThreePointAttempts();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					threePointFieldGoalsAttemptedCounter=threePointFieldGoalsAttemptedCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getThreePointAttempts();
				}
			}
		}
		return threePointFieldGoalsAttemptedCounter;
	}
	
	public int calculateFreeThrowsMade(String name,ArrayList<MatchPO>mpselected){
		int freeThrowsMadeCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					freeThrowsMadeCounter=freeThrowsMadeCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getFreeThrowGoal();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					freeThrowsMadeCounter=freeThrowsMadeCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getFreeThrowGoal();
				}
			}
		}
		return freeThrowsMadeCounter;
	}
	
	public int calculateFreeThrowsAttempted(String name,ArrayList<MatchPO> mpselected){
		int freeThrowsAttemptedCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					freeThrowsAttemptedCounter=freeThrowsAttemptedCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getFreeThrowAttempts();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					freeThrowsAttemptedCounter=freeThrowsAttemptedCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getFreeThrowAttempts();
				}
			}
		}
		return freeThrowsAttemptedCounter;
	}
	
	public int calculateOppositeFreeThrowsAttempted(String name,ArrayList<MatchPO> mpselected){
		int oppositeFreeThrowsAttemptedCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					oppositeFreeThrowsAttemptedCounter=oppositeFreeThrowsAttemptedCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getFreeThrowAttempts();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					oppositeFreeThrowsAttemptedCounter=oppositeFreeThrowsAttemptedCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getFreeThrowAttempts();
				}
			}
		}
		return oppositeFreeThrowsAttemptedCounter;
	}//对手罚球数
	
	public int calculateOffensiveRebounds(String name,ArrayList<MatchPO> mpselected){
		int offensiveReboundsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					offensiveReboundsCounter=offensiveReboundsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getOffensiveRebound();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					offensiveReboundsCounter=offensiveReboundsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getOffensiveRebound();
				}
			}
		}
		return offensiveReboundsCounter;
	}
	
	public int calculateOppositeOffensiveRebounds(String name,ArrayList<MatchPO> mpselected){
		int oppositeOffensiveReboundsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					oppositeOffensiveReboundsCounter=oppositeOffensiveReboundsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getOffensiveRebound();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					oppositeOffensiveReboundsCounter=oppositeOffensiveReboundsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getOffensiveRebound();
				}
			}
		}
		return oppositeOffensiveReboundsCounter;
	}//对手前场板数量
	
	public int calculateDefensiveRebounds(String name,ArrayList<MatchPO> mpselected){
		int defensiveReboundsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					defensiveReboundsCounter=defensiveReboundsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getDefensiveRebound();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					defensiveReboundsCounter=defensiveReboundsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getDefensiveRebound();
				}
			}
		}
		return defensiveReboundsCounter;
	}
	
	public int calculateOppositeDefensiveRebounds(String name,ArrayList<MatchPO> mpselected){
		int oppositeDefensiveReboundsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					oppositeDefensiveReboundsCounter=oppositeDefensiveReboundsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getDefensiveRebound();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					oppositeDefensiveReboundsCounter=oppositeDefensiveReboundsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getDefensiveRebound();
				}
			}
		}
		return oppositeDefensiveReboundsCounter;
	}//对手后场板数量
	
	public int calculateAssists(String name,ArrayList<MatchPO> mpselected){
		int assistsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					assistsCounter=assistsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getAssist();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					assistsCounter=assistsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getAssist();
				}
			}
		}
		return assistsCounter;
	}
	
	public int calculateSteals(String name,ArrayList<MatchPO> mpselected){
		int stealsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					stealsCounter=stealsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getST();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					stealsCounter=stealsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getST();
				}
			}
		}
		return stealsCounter;
	}
	
	public int calculateBlocks(String name,ArrayList<MatchPO> mpselected){
		int blocksCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					blocksCounter=blocksCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getBlockShot();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					blocksCounter=blocksCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getBlockShot();
				}
			}
		}
		return blocksCounter;
	}
	
	public int calculateTurnovers(String name,ArrayList<MatchPO> mpselected){
		int turnoversCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					turnoversCounter=turnoversCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getError();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					turnoversCounter=turnoversCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getError();
				}
			}
		}
		return turnoversCounter;
	}
	
	public int calculateOppositeTurnovers(String name,ArrayList<MatchPO> mpselected){
		int oppositeTurnoversCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					oppositeTurnoversCounter=oppositeTurnoversCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getError();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					oppositeTurnoversCounter=oppositeTurnoversCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getError();
				}
			}
		}
		return oppositeTurnoversCounter;
	}//对手失误数
	
	public int calculateFouls(String name,ArrayList<MatchPO> mpselected){
		int foulsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					foulsCounter=foulsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getFoul();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					foulsCounter=foulsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getFoul();
				}
			}
		}
		return foulsCounter;
	}
	
	public int calculatePoints(String name,ArrayList<MatchPO> mpselected){
		int pointsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					pointsCounter=pointsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getScore();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					pointsCounter=pointsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getScore();
				}
			}
		}
		return pointsCounter;
	}
	
	public int calculateOppositePoints(String name,ArrayList<MatchPO> mpselected){
		int oppositePointsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				for(int j=0;j<mpselected.get(i).getTeam2().getPlayers().size();j++){
					oppositePointsCounter=oppositePointsCounter+mpselected.get(i).getTeam2().getPlayers().get(j).getScore();
				}
			}
			else{
				for(int j=0;j<mpselected.get(i).getTeam1().getPlayers().size();j++){
					oppositePointsCounter=oppositePointsCounter+mpselected.get(i).getTeam1().getPlayers().get(j).getScore();
				}
			}
		}
		return oppositePointsCounter;
	}//对手得分
	
	public int calculateWins(String name,ArrayList<MatchPO> mpselected){
		int winsCounter=0;
		for(int i=0;i<mpselected.size();i++){
			if(mpselected.get(i).getTeam1().getTeamName().equals(name)){
				String []s=mpselected.get(i).getScore().split("-");
				if(Integer.parseInt(s[0])>Integer.parseInt(s[1])){
					winsCounter=winsCounter+1;
				}
			}
			else{
				String []s=mpselected.get(i).getScore().split("-");
				if(Integer.parseInt(s[0])<Integer.parseInt(s[1])){
					winsCounter=winsCounter+1;
				}
			}
		}
		return winsCounter;
	}
}
