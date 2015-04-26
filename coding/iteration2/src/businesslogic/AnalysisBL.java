package businesslogic;

import java.util.ArrayList;
import java.util.Collections;




import po.TodayPlayerPO;
import data.MatchData;
import data.PlayerData;
import data.TeamData;
import dataService.MatchDataService;
import dataService.PlayerDataService;
import dataService.TeamDataService;
import vo.MatchVO;
import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
import vo.SortType;
import vo.TeamVO;
import vo.TodayPlayerVO;
import businesslogicService.AnalysisBLService;
import businesslogicService.DataBLService;

public class AnalysisBL implements AnalysisBLService {

	
	public ArrayList<PlayerVO> sortPlayer(ArrayList<PlayerVO> pl,
			String keyword, SortType type) {
		ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
		if(keyword.equals("rebounds")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getRebounds()<pl.get(j).getRebounds())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("gamesPlayed")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getGamesPlayed()<pl.get(j).getGamesPlayed())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("gamesStarting")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getGamesStarting()<pl.get(j).getGamesStarting())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("assists")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAssists()<pl.get(j).getAssists())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("minutes")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getMinutes().compareTo(pl.get(j).getMinutes())<0)
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("fieldGoalsPercentage")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getFieldGoalsPercentage()<pl.get(j).getFieldGoalsPercentage())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("threePointFieldGoalsPercentage")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getThreePointFieldGoalsPercentage()<pl.get(j).getThreePointFieldGoalsPercentage())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("freeThrowsPercentage")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getFreeThrowsPercentage()<pl.get(j).getFreeThrowsPercentage())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("offensiveRebounds")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getOffensiveRebounds()<pl.get(j).getOffensiveRebounds())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("defensiveRebounds")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getDefensiveRebounds()<pl.get(j).getDefensiveRebounds())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("steals")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getSteals()<pl.get(j).getSteals())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("blocks")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getBlocks()<pl.get(j).getBlocks())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("turnovers")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getTurnovers()<pl.get(j).getTurnovers())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("fouls")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getFouls()<pl.get(j).getFouls())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("points")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getPoints()<pl.get(j).getPoints())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("efficiency")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getEfficiency()<pl.get(j).getEfficiency())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("GmSc")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getGmSc()<pl.get(j).getGmSc())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("trueShootingPercentage")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getTrueShootingPercentage()<pl.get(j).getTrueShootingPercentage())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("shootingEfficiency")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getShootingEfficiency()<pl.get(j).getShootingEfficiency())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("reboundRating")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getReboundRating()<pl.get(j).getReboundRating())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("offensiveReboundRating")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getOffensiveReboundRating()<pl.get(j).getOffensiveReboundRating())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("defensiveReboundRating")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getDefensiveReboundRating()<pl.get(j).getDefensiveReboundRating())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("assisyRating")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAssisyRating()<pl.get(j).getAssisyRating())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("stealRating")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getStealRating()<pl.get(j).getStealRating())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("blockRating")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getBlockRating()<pl.get(j).getBlockRating())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("turnoverRating")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getTurnoverRating()<pl.get(j).getTurnoverRating())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("utilizationRating")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getUtilizationRating()<pl.get(j).getUtilizationRating())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("pointsReboundsAssists")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getPoints()+pl.get(i).getRebounds()+pl.get(i).getAssists()
							<pl.get(j).getPoints()+pl.get(j).getRebounds()+pl.get(j).getAssists())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("doubleDouble")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getDoubleDouble()<pl.get(j).getDoubleDouble())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allTimeOfTeam")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllTimeOfTeam().compareTo(pl.get(j).getAllTimeOfTeam())<0)
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allReboundsOfTeam")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllReboundsOfTeam()<pl.get(j).getAllReboundsOfTeam())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allOffensiveReboundsOfTeam")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllOffensiveReboundsOfTeam()<pl.get(j).getAllOffensiveReboundsOfTeam())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("alldefensiveReboundsOfTeam")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAlldefensiveReboundsOfTeam()<pl.get(j).getAlldefensiveReboundsOfTeam())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allReboundsOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllReboundsOfOpposite()<pl.get(j).getAllReboundsOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allOffensiveReboundsOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllOffensiveReboundsOfOpposite()<pl.get(j).getAllOffensiveReboundsOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("alldefensiveReboundsOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAlldefensiveReboundsOfOpposite()<pl.get(j).getAlldefensiveReboundsOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allFieldGoalsMade")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllFieldGoalsMade()<pl.get(j).getAllFieldGoalsMade())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allDefenseOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllDefenseOfOpposite()<pl.get(j).getAllDefenseOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("twoPointFieldGoalsAttemptsOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getTwoPointFieldGoalsAttemptsOfOpposite()<pl.get(j).getTwoPointFieldGoalsAttemptsOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("twoPointFieldGoalsAttempts")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getTwoPointFieldGoalsAttempts()<pl.get(j).getTwoPointFieldGoalsAttempts())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allFieldGoalsAttemptsOfTeam")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllFieldGoalsAttemptsOfTeam()<pl.get(j).getAllFieldGoalsAttemptsOfTeam())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allFreeGoalsAttemptsOfTeam")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllFreeGoalsAttemptsOfTeam()<pl.get(j).getAllFreeGoalsAttemptsOfTeam())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("AllturnoversOfTeam")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllturnoversOfTeam()<pl.get(j).getAllturnoversOfTeam())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allFieldGoalsAttemptsOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllFieldGoalsAttemptsOfOpposite()<pl.get(j).getAllFieldGoalsAttemptsOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allFreeGoalsAttemptsOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllFreeGoalsAttemptsOfOpposite()<pl.get(j).getAllFreeGoalsAttemptsOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allMissedGoalsOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllMissedGoalsOfOpposite()<pl.get(j).getAllMissedGoalsOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("allturnoversOfOpposite")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getAllturnoversOfOpposite()<pl.get(j).getAllturnoversOfOpposite())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("increaseOfPoints")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getIncreaseOfPoints()<pl.get(j).getIncreaseOfPoints())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("increaseOfRebounds")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getIncreaseOfRebounds()<pl.get(j).getIncreaseOfRebounds())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("increaseOfAssists")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getIncreaseOfAssists()<pl.get(j).getIncreaseOfAssists())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}else if(keyword.equals("pointsReboundsAssists")){
			while(pl.size()>0){
				int i=0;
				for(int j=i+1;j<pl.size();j++){
					if(pl.get(i).getPoints()+pl.get(i).getRebounds()+pl.get(i).getAssists()
							<pl.get(j).getPoints()+pl.get(j).getRebounds()+pl.get(j).getAssists())
						i=j;
				}
				result.add(pl.get(i));
				pl.remove(i);
			}
		}
		
		if(type.equals(SortType.Descending)){
			return result;
		}else if(type.equals(SortType.Ascending)){
			Collections.reverse(result);
			return result;
		}
		return pl;
	}

	public ArrayList<TeamVO> sortTeam(ArrayList<TeamVO> teamlist,
			String keyword, SortType type) {
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		if(keyword.equals("gamesPlayed")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getGamesPlayed()>teamlist.get(max).getGamesPlayed()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("fieldGoalsMade")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getFieldGoalsMade()>teamlist.get(max).getFieldGoalsMade()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("fieldGoalsAttempted")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getFieldGoalsAttempted()>teamlist.get(max).getFieldGoalsAttempted()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("threePointFieldGoalsMade")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getThreePointFieldGoalsMade()>teamlist.get(max).getThreePointFieldGoalsMade()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("threePointFieldGoalsAttempted")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getThreePointFieldGoalsAttempted()>teamlist.get(max).getThreePointFieldGoalsAttempted()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("freeThrowsMade")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getFreeThrowsMade()>teamlist.get(max).getFreeThrowsMade()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("freeThrowsAttempted")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getFreeThrowsAttempted()>teamlist.get(max).getFreeThrowsAttempted()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("offensiveRebounds")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOffensiveRebounds()>teamlist.get(max).getOffensiveRebounds()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("defensiveRebounds")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getDefensiveRebounds()>teamlist.get(max).getDefensiveRebounds()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("rebounds")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getRebounds()>teamlist.get(max).getRebounds()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("assists")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getAssists()>teamlist.get(max).getAssists()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("steals")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getSteals()>teamlist.get(max).getSteals()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("blocks")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getBlocks()>teamlist.get(max).getBlocks()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("turnovers")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getTurnovers()>teamlist.get(max).getTurnovers()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("fouls")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getFouls()>teamlist.get(max).getFouls()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("points")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getPoints()>teamlist.get(max).getPoints()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("fieldGoalPercentage")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getFieldGoalPercentage()>teamlist.get(max).getFieldGoalPercentage()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("threePointFieldGoalPercentage")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getThreePointFieldGoalPercentage()>teamlist.get(max).getThreePointFieldGoalPercentage()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("freeThrowPercentage")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getFreeThrowPercentage()>teamlist.get(max).getFreeThrowPercentage()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("winPercentage")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getWinPercentage()>teamlist.get(max).getWinPercentage()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("possessions")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getPossessions()>teamlist.get(max).getPossessions()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("offensiveRating")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOffensiveRating()>teamlist.get(max).getOffensiveRating()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("defensiveRating")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getDefensiveRating()>teamlist.get(max).getDefensiveRating()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("offensiveReboundPercentage")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOffensiveReboundPercentage()>teamlist.get(max).getOffensiveReboundPercentage()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("defensiveReboundPercentage")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getDefensiveReboundPercentage()>teamlist.get(max).getDefensiveReboundPercentage()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("stealPercentage")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getStealPercentage()>teamlist.get(max).getStealPercentage()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("assistPercentage")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getAssistPercentage()>teamlist.get(max).getAssistPercentage()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("gamesPlayedWin")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getGamesPlayedWin()>teamlist.get(max).getGamesPlayedWin()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppFieldGoalsMade")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppFieldGoalsMade()>teamlist.get(max).getOppFieldGoalsMade()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppFieldGoalsAttempted")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppFieldGoalsAttempted()>teamlist.get(max).getOppFieldGoalsAttempted()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppFreeThrowsAttempted")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppFreeThrowsAttempted()>teamlist.get(max).getOppFreeThrowsAttempted()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppTurnovers")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppTurnovers()>teamlist.get(max).getOppTurnovers()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppSteals")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppSteals()>teamlist.get(max).getOppSteals()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppAssists")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppAssists()>teamlist.get(max).getOppAssists()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppOffensiveRebounds")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppOffensiveRebounds()>teamlist.get(max).getOppOffensiveRebounds()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppDefensiveRebounds")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppDefensiveRebounds()>teamlist.get(max).getOppDefensiveRebounds()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppPoints")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppPoints()>teamlist.get(max).getOppPoints()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}
		else if(keyword.equals("oppPossessions")){
			while(teamlist.size()>0){
				int max=0;
				for(int i=0;i<teamlist.size();i++){
					if(teamlist.get(i).getOppPossessions()>teamlist.get(max).getOppPossessions()){
						max=i;
					}
				}
				result.add(teamlist.get(max));
				teamlist.remove(max);
			}
		}else if(keyword.equals("pointsReboundsAssists")){
			while(teamlist.size()>0){
				int i=0;
				for(int j=i+1;j<teamlist.size();j++){
					if(teamlist.get(i).getPoints()+teamlist.get(i).getRebounds()+teamlist.get(i).getAssists()
							<teamlist.get(j).getPoints()+teamlist.get(j).getRebounds()+teamlist.get(j).getAssists())
						i=j;
				}
				result.add(teamlist.get(i));
				teamlist.remove(i);
			}
		}
		if(type.equals(SortType.Descending)){
			return result;
		}else if(type.equals(SortType.Ascending)){
			Collections.reverse(result);
			return result;
		}
		return teamlist;
	}

	public ArrayList<PlayerVO> getTopFiftyPlayer(PlayerPosition position,
			PlayerPartition partition, String keyword) {
		ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
		DataBLService d=new DataBL();
		result=d.getAllPlayerInfo();
		if(position.equals(PlayerPosition.All)){
			
		}else if(position.equals(PlayerPosition.Center)){
			for(int i=result.size()-1;i>=0;i--){
				if(!result.get(i).getPosition().equals("C") && !result.get(i).getPosition().equals("C-F") && !result.get(i).getPosition().equals("F-C")){	
					result.remove(i);
				}
			}
		}else if(position.equals(PlayerPosition.Guard)){
			for(int i=result.size()-1;i>=0;i--){
				if(!result.get(i).getPosition().equals("G") && !result.get(i).getPosition().equals("G-F") && !result.get(i).getPosition().equals("F-G")){	
					result.remove(i);
				}
			}
		}else if(position.equals(PlayerPosition.Forward)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getPosition().equals("C") || result.get(i).getPosition().equals("G")){	
					result.remove(i);
				}
			}
		}
		
		
		if(partition.equals(PlayerPartition.All)){
		}else if(partition.equals(PlayerPartition.Atlantic)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String area=d.getSingleTeamInfo(result.get(i).getTeamName()).getSubarea();
					/*System.out.println(result.get(i).getPlayerName());
					System.out.println(result.get(i).getTeamName());
					System.out.println(area);*/
					if(!area.equals("Atlantic"))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Central)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String area=d.getSingleTeamInfo(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Central"))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.East)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String area=d.getSingleTeamInfo(result.get(i).getTeamName()).getZone();
					if(!area.equals("E"))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Northwest)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String area=d.getSingleTeamInfo(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Northwest"))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Pacific)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String area=d.getSingleTeamInfo(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Pacific"))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Southeast)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String area=d.getSingleTeamInfo(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Southeast"))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.West)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String area=d.getSingleTeamInfo(result.get(i).getTeamName()).getZone();
					if(!area.equals("W"))
						result.remove(i);
				}
			}
		}
			
		if(!keyword.equals("Null")){	
			result=sortPlayer(result,keyword, SortType.Descending);
			if(result.size()>50){
				for(int i=result.size()-1;i>=50;i--){
					result.remove(i);
				}
			}
		}
			
		return result;
	}

	public ArrayList<TodayPlayerVO> getTodayHotSpotPlayer(String keyword) {
		
		PlayerDataService pd=new PlayerData();
		MatchDataService md=new MatchData();
		String str=md.getDate();
		ArrayList<TodayPlayerPO> tp=pd.getTodayPlayerInfo(str);
		ArrayList<TodayPlayerVO> result2=new ArrayList<TodayPlayerVO>();
		ArrayList<TodayPlayerVO> result=new ArrayList<TodayPlayerVO>();
		for(int i=0;i<tp.size();i++){
			TodayPlayerVO temp=new TodayPlayerVO();
			temp.setPlayerName(tp.get(i).getPlayerName());
			temp.setPosition(tp.get(i).getPosition());
			temp.setTeamName(tp.get(i).getTeamName());
			temp.setOppositeTeamName(tp.get(i).getOppositeTeamName());
			temp.setMatchTime(tp.get(i).getMatchTime());
			temp.setRebound(tp.get(i).getRebound());
			temp.setAssist(tp.get(i).getAssist());		
			temp.setSt(tp.get(i).getSt());
			temp.setBlockShot(tp.get(i).getBlockShot());
			temp.setError(tp.get(i).getError());
			temp.setFoul(tp.get(i).getFoul());
			temp.setScore(tp.get(i).getScore());
			temp.setFieldGoal(tp.get(i).getFieldGoal());
			temp.setFieldGoalAttempts(tp.get(i).getFieldGoalAttempts());
			temp.setThreepointShot(tp.get(i).getThreepointShot());
			temp.setThreepointAttempts(tp.get(i).getThreepointAttempts());
			temp.setFreeThrowAttempts(tp.get(i).getFreeThrowAttempts());
			temp.setFreeThrowGoal(tp.get(i).getFreeThrowGoal());
			temp.setOffensiveRebound(tp.get(i).getOffensiveRebound());
			temp.setDefensiveRebound(tp.get(i).getDefensiveRebound());
			
			
			result.add(temp);
		}
		
		if(keyword.equals("rebound")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getRebound()<result.get(j).getRebound())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("assist")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getAssist()<result.get(j).getAssist())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("st")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getSt()<result.get(j).getSt())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("blockShot")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getBlockShot()<result.get(j).getBlockShot())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("error")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getError()<result.get(j).getError())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("foul")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getFoul()<result.get(j).getFoul())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("score")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getScore()<result.get(j).getScore())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("fieldGoal")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getFieldGoal()<result.get(j).getFieldGoal())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("fieldGoalAttempts")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getFieldGoalAttempts()<result.get(j).getFieldGoalAttempts())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("threepointShot")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getThreepointShot()<result.get(j).getThreepointShot())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("threepointAttempts")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getThreepointAttempts()<result.get(j).getThreepointAttempts())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("freeThrowGoal")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getFreeThrowGoal()<result.get(j).getFreeThrowGoal())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("freeThrowAttempts")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getFreeThrowAttempts()<result.get(j).getFreeThrowAttempts())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("offensiveRebound")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getOffensiveRebound()<result.get(j).getOffensiveRebound())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}else if(keyword.equals("defensiveRebound")){
			while(result.size()>0){
				int i=0;
				for(int j=i+1;j<result.size();j++){
					if(result.get(i).getDefensiveRebound()<result.get(j).getDefensiveRebound())
						i=j;
				}
				result2.add(result.get(i));
				result.remove(i);
			}
		}
		if(result2.size()>5){
			for(int i=result2.size()-1;i>=5;i--){
				result2.remove(i);
			}
		}
		return result2;
	}

	public ArrayList<PlayerVO> getSeasonHotSpotPlayer(String keyword) {
		DataBLService d=new DataBL();
		ArrayList<PlayerVO> p=d.getAllPlayerInfo();
		for(int i=0;i<p.size();i++){
			p.get(i).setEfficiency(p.get(i).getEfficiency()/p.get(i).getGamesPlayed());
			p.get(i).setGmSc(p.get(i).getGmSc()/p.get(i).getGamesPlayed());
			p.get(i).setRebounds(p.get(i).getRebounds()/p.get(i).getGamesPlayed());
			p.get(i).setAssists(p.get(i).getAssists()/p.get(i).getGamesPlayed());
			p.get(i).setOffensiveRebounds(p.get(i).getOffensiveRebounds()/p.get(i).getGamesPlayed());
			p.get(i).setDefensiveRebounds(p.get(i).getDefensiveRebounds()/p.get(i).getGamesPlayed());
			p.get(i).setSteals(p.get(i).getSteals()/p.get(i).getGamesPlayed());
			p.get(i).setBlocks(p.get(i).getBlocks()/p.get(i).getGamesPlayed());
			p.get(i).setTurnovers(p.get(i).getTurnovers()/p.get(i).getGamesPlayed());
			p.get(i).setFouls(p.get(i).getFouls()/p.get(i).getGamesPlayed());
			p.get(i).setPoints(p.get(i).getPoints()/p.get(i).getGamesPlayed());
		}
		p=sortPlayer(p, keyword,SortType.Descending);
		if(p.size()>5){
			for(int i=p.size()-1;i>=5;i--){
				p.remove(i);
			}
		}
		for(int i=0;i<p.size();i++){
			p.get(i).setEfficiency(p.get(i).getEfficiency()*p.get(i).getGamesPlayed());
			p.get(i).setGmSc(p.get(i).getGmSc()*p.get(i).getGamesPlayed());
			p.get(i).setRebounds(p.get(i).getRebounds()*p.get(i).getGamesPlayed());
			p.get(i).setAssists(p.get(i).getAssists()*p.get(i).getGamesPlayed());
			p.get(i).setOffensiveRebounds(p.get(i).getOffensiveRebounds()*p.get(i).getGamesPlayed());
			p.get(i).setDefensiveRebounds(p.get(i).getDefensiveRebounds()*p.get(i).getGamesPlayed());
			p.get(i).setSteals(p.get(i).getSteals()*p.get(i).getGamesPlayed());
			p.get(i).setBlocks(p.get(i).getBlocks()*p.get(i).getGamesPlayed());
			p.get(i).setTurnovers(p.get(i).getTurnovers()*p.get(i).getGamesPlayed());
			p.get(i).setFouls(p.get(i).getFouls()*p.get(i).getGamesPlayed());
			p.get(i).setPoints(p.get(i).getPoints()*p.get(i).getGamesPlayed());
		}
		return p;
	}

	public ArrayList<TeamVO> getSeasonHotSpotTeam(String keyword) {
		DataBLService d=new DataBL();
		ArrayList<TeamVO> t=d.getAllTeamInfo();
		t=sortTeam(t, keyword,SortType.Descending);
		for(int i=0;i<t.size();i++){		
			t.get(i).setFreeThrowsAttempted(t.get(i).getFreeThrowsAttempted()/t.get(i).getGamesPlayed());
			t.get(i).setFieldGoalsMade(t.get(i).getFieldGoalsMade()/t.get(i).getGamesPlayed());
			t.get(i).setFieldGoalsAttempted(t.get(i).getFieldGoalsAttempted()/t.get(i).getGamesPlayed());
			t.get(i).setThreePointFieldGoalsMade(t.get(i).getThreePointFieldGoalsMade()/t.get(i).getGamesPlayed());
			t.get(i).setThreePointFieldGoalsAttempted(t.get(i).getThreePointFieldGoalsAttempted()/t.get(i).getGamesPlayed());
			t.get(i).setFreeThrowsMade(t.get(i).getFreeThrowsMade()/t.get(i).getGamesPlayed());
			t.get(i).setOffensiveRebounds(t.get(i).getOffensiveRebounds()/t.get(i).getGamesPlayed());
			t.get(i).setDefensiveRebounds(t.get(i).getDefensiveRebounds()/t.get(i).getGamesPlayed());				
			t.get(i).setRebounds(t.get(i).getRebounds()/t.get(i).getGamesPlayed());
			t.get(i).setAssists(t.get(i).getAssists()/t.get(i).getGamesPlayed());
			t.get(i).setSteals(t.get(i).getSteals()/t.get(i).getGamesPlayed());
			t.get(i).setBlocks(t.get(i).getBlocks()/t.get(i).getGamesPlayed());
			t.get(i).setTurnovers(t.get(i).getTurnovers()/t.get(i).getGamesPlayed());
			t.get(i).setFouls(t.get(i).getFouls()/t.get(i).getGamesPlayed());
			t.get(i).setPoints(t.get(i).getPoints()/t.get(i).getGamesPlayed());
			t.get(i).setPossessions(t.get(i).getPossessions()/t.get(i).getGamesPlayed());
		}
		if(t.size()>5){
			for(int i=t.size()-1;i>=5;i--){
				t.remove(i);
			}
		}
		for(int i=0;i<t.size();i++){		
			t.get(i).setFreeThrowsAttempted(t.get(i).getFreeThrowsAttempted()*t.get(i).getGamesPlayed());
			t.get(i).setFieldGoalsMade(t.get(i).getFieldGoalsMade()*t.get(i).getGamesPlayed());
			t.get(i).setFieldGoalsAttempted(t.get(i).getFieldGoalsAttempted()*t.get(i).getGamesPlayed());
			t.get(i).setThreePointFieldGoalsMade(t.get(i).getThreePointFieldGoalsMade()*t.get(i).getGamesPlayed());
			t.get(i).setThreePointFieldGoalsAttempted(t.get(i).getThreePointFieldGoalsAttempted()*t.get(i).getGamesPlayed());
			t.get(i).setFreeThrowsMade(t.get(i).getFreeThrowsMade()*t.get(i).getGamesPlayed());
			t.get(i).setOffensiveRebounds(t.get(i).getOffensiveRebounds()*t.get(i).getGamesPlayed());
			t.get(i).setDefensiveRebounds(t.get(i).getDefensiveRebounds()*t.get(i).getGamesPlayed());				
			t.get(i).setRebounds(t.get(i).getRebounds()*t.get(i).getGamesPlayed());
			t.get(i).setAssists(t.get(i).getAssists()*t.get(i).getGamesPlayed());
			t.get(i).setSteals(t.get(i).getSteals()*t.get(i).getGamesPlayed());
			t.get(i).setBlocks(t.get(i).getBlocks()*t.get(i).getGamesPlayed());
			t.get(i).setTurnovers(t.get(i).getTurnovers()*t.get(i).getGamesPlayed());
			t.get(i).setFouls(t.get(i).getFouls()*t.get(i).getGamesPlayed());
			t.get(i).setPoints(t.get(i).getPoints()*t.get(i).getGamesPlayed());
			t.get(i).setPossessions(t.get(i).getPossessions()*t.get(i).getGamesPlayed());
		}
		return t;
	}

	public ArrayList<PlayerVO> getProgressivePlayer(String keyword) {
		DataBLService d=new DataBL();
		ArrayList<PlayerVO> p=d.getAllPlayerInfo();
		ArrayList<PlayerVO> result=sortPlayer(p, keyword, SortType.Descending);
		if(result.size()>5){
			for(int i=result.size()-1;i>=5;i--){
				result.remove(i);
			}
		}
		return result;
	}
	
	public ArrayList<MatchVO> getTodayMatch() {
		
		DataBLService d=new DataBL();
		MatchDataService md=new MatchData();
		String str=md.getDate();
		ArrayList<MatchVO> result=d.findMatchByDate(str);
		return result;
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		MatchDataService md=new MatchData();
		TeamDataService td=new TeamData();
		PlayerDataService pd=new PlayerData();
		md.updateMatchInfo();
		td.updateAllTeam();
		pd.updatePlayerInfo();
		
	}

}
