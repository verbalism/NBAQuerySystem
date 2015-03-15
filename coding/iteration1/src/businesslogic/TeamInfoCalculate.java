package businesslogic;

import java.util.ArrayList;

import po.MatchInfoPO;

public class TeamInfoCalculate {
	public int calculateFieldGoalsMade(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateFieldGoalsAttempted(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateThreePointFieldGoalsMade(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateThreePointFieldGoalsAttempted(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateFreeThrowsMade(String name,ArrayList<MatchInfoPO>mpselected){
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
	
	public int calculateFreeThrowsAttempted(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateOffensiveRebounds(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateDefensiveRebounds(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateAssists(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateSteals(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateBlocks(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateTurnovers(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateFouls(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculatePoints(String name,ArrayList<MatchInfoPO> mpselected){
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
	
	public int calculateWins(String name,ArrayList<MatchInfoPO> mpselected){
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
