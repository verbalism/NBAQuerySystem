package businesslogic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.MatchPO;
import po.MatchPlayer;
import po.TodayPlayerPO;
import data.MatchData;
import data.PlayerData;
import dataService.MatchDataService;
import dataService.PlayerDataService;
import vo.MatchVO;
import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
import vo.ScoreWay;
import vo.TeamType;
import vo.TeamVO;
import vo.TodayPlayerVO;
import businesslogicService.AnalysisBLService;
import businesslogicService.DataBLService;


public class AnalysisBL implements AnalysisBLService {
	public ArrayList<PlayerVO> sortPlayer(ArrayList<PlayerVO> pl,String keyword) {
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
					if(pl.get(i).getMinutes()<pl.get(j).getMinutes())
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
		return result;
	}
	public ArrayList<TeamVO> sortTeam(ArrayList<TeamVO> teamlist,String keyword) {
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
		return result;
	}
	public ArrayList<PlayerVO> getTopFiftyPlayer(PlayerPosition position,
			PlayerPartition partition, String keyword,String season) {
		ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
		DataBLService d=new DataBL();
		result=d.getAllPlayerInfo(season);
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
					String t=result.get(i).getTeamName();
					if(!(t.equals("BKN")||t.equals("BOS")||t.equals("NYK")||t.equals("PHI")||t.equals("TOR")))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Central)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String t=result.get(i).getTeamName();
					if(!(t.equals("CHI")||t.equals("CLE")||t.equals("DET")||t.equals("IND")||t.equals("MIL")))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.East)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String t=result.get(i).getTeamName();
					if(!(t.equals("CHI")||t.equals("CLE")||t.equals("DET")||t.equals("IND")||t.equals("MIL")||
							t.equals("BKN")||t.equals("BOS")||t.equals("NYK")||t.equals("PHI")||t.equals("TOR")||
							t.equals("ALT")||t.equals("CHA")||t.equals("MIA")||t.equals("ORL")||t.equals("WAS")))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Northwest)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String t=result.get(i).getTeamName();
					if(!(t.equals("DEN")||t.equals("MIN")||t.equals("OKC")||t.equals("POR")||t.equals("UTA")))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Pacific)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String t=result.get(i).getTeamName();
					if(!(t.equals("GSW")||t.equals("LAC")||t.equals("LAL")||t.equals("PHX")||t.equals("SAC")))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Southeast)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String t=result.get(i).getTeamName();
					if(!(t.equals("ATL")||t.equals("CHA")||t.equals("MIA")||t.equals("ORL")||t.equals("WAS")))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.Southwest)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String t=result.get(i).getTeamName();
					if(!(t.equals("DAL")||t.equals("HOU")||t.equals("MEM")||t.equals("NOP")||t.equals("SAS")))
						result.remove(i);
				}
			}
		}else if(partition.equals(PlayerPartition.West)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("")){
					result.remove(i);
				}else{
					String t=result.get(i).getTeamName();
					if(!(t.equals("DAL")||t.equals("HOU")||t.equals("MEM")||t.equals("NOP")||t.equals("SAS")
							||t.equals("GSW")||t.equals("LAC")||t.equals("LAL")||t.equals("PHX")||t.equals("SAC")
							||t.equals("DEN")||t.equals("MIN")||t.equals("OKC")||t.equals("POR")||t.equals("UTA")))
						result.remove(i);
				}
			}
		}			
		if(!keyword.equals("Null")){	
			result=sortPlayer(result,keyword);
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
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");//设置日期格式
		String str=df.format(new Date());	
		ArrayList<TodayPlayerPO> tp=pd.getTodayPlayerInfo("06-11","14_15_after");
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

	public ArrayList<PlayerVO> getSeasonHotSpotPlayer(String keyword,String season) {
		DataBLService d=new DataBL();
		ArrayList<PlayerVO> p=d.getAllPlayerInfo(season);
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
		p=sortPlayer(p, keyword);
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

	public ArrayList<TeamVO> getSeasonHotSpotTeam(String keyword,String season) {
		DataBLService d=new DataBL();
		ArrayList<TeamVO> t=d.getAllTeamInfo(season);
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
		t=sortTeam(t, keyword);
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

	public ArrayList<PlayerVO> getProgressivePlayer(String keyword,String season) {
		DataBLService d=new DataBL();
		ArrayList<PlayerVO> p=d.getAllPlayerInfo(season);
		ArrayList<PlayerVO> result=sortPlayer(p, keyword);
		if(result.size()>5){
			for(int i=result.size()-1;i>=5;i--){
				result.remove(i);
			}
		}
		return result;
	}
	
	public ArrayList<MatchVO> getTodayMatch() {		
		DataBLService d=new DataBL();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");//设置日期格式
		String str=df.format(new Date());	
		ArrayList<MatchVO> result=new ArrayList<MatchVO>();			
		result=d.findMatchByDate(str,"14_15_after");
		return result;
	}

	
	public double getScoreAnalysis(String teamName, String season,
			ScoreWay scoreWay) {
		double result=0.0;
		DataBLService d=new DataBL();
		TeamVO t=d.getSingleTeamInfo(teamName, season);
		if(t.getPoints()==0){
			return result;
		}
		if(scoreWay.equals(ScoreWay.fieldGoals)){			
			result=1.0;
		}else if(scoreWay.equals(ScoreWay.threePointFieldGoals)){
			result=t.getThreePointFieldGoalsMade()*3/t.getPoints();
		}else if(scoreWay.equals(ScoreWay.freeThrows)){
			result=t.getFreeThrowsMade()/t.getPoints();
		}
		return result;
	}

	@Override
	public String getHighestScoringPlayer(String teamName, String season,
			ScoreWay scoreWay) {
		// TODO Auto-generated method stub
		DataBLService d=new DataBL();
		ArrayList<PlayerVO> p=d.getAllPlayerInfo(season);
		ArrayList<PlayerVO> p2=new ArrayList<PlayerVO>();
		ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
		for(int i=0;i<p.size();i++){
			if(p.get(i).getTeamName().equals(teamName)){
				p2.add(p.get(i));
			}
		}
		if(scoreWay.equals(ScoreWay.fieldGoals)){				
			while(p2.size()>0){
				int i=0;
				for(int j=i+1;j<p2.size();j++){
					if(p2.get(i).getFieldGoalsMade()<p2.get(j).getFieldGoalsMade())
							i=j;
				}
				result.add(p2.get(i));
				p2.remove(i);
			}			
		}else if(scoreWay.equals(ScoreWay.threePointFieldGoals)){
			while(p2.size()>0){
				int i=0;
				for(int j=i+1;j<p2.size();j++){
					if(p2.get(i).getThreePointFieldGoalsMade()<p2.get(j).getThreePointFieldGoalsMade())
							i=j;
				}
				result.add(p2.get(i));
				p2.remove(i);
			}	
		}else if(scoreWay.equals(ScoreWay.freeThrows)){
			while(p2.size()>0){
				int i=0;
				for(int j=i+1;j<p2.size();j++){
					if(p2.get(i).getFreeThrowsMade()<p2.get(j).getFreeThrowsMade())
							i=j;
				}
				result.add(p2.get(i));
				p2.remove(i);
			}	
		}
		return result.get(0).getPlayerName();
	}

	@Override
	public TeamType getTeamType(String teamName, String season) {	
		DataBLService d=new DataBL();
		ArrayList<TeamVO> t=d.getAllTeamInfo(season);
		double[] temp = new double [t.size()];
		for(int i=0;i<t.size();i++){
			temp[i]=t.get(0).getOffensiveRating()-t.get(0).getDefensiveRating();			
		}
		for(int i=0;i<t.size();i++){
			if(t.get(i).getTeamName().equals(teamName)){
				int n=0;
				for(int j=0;j<t.size();j++){
					if(temp[i]>temp[j]){
						n++;
					}
				}
				if(n<(t.size()*2/5)){
					return TeamType.Defensive;
				}else if(n>(t.size()*3/5)){
					return TeamType.Offensive;
				}else{
					return TeamType.Balanced;
				}
			}		
		}		
		return null;
	}
	@Override
	public String getBestOffensivePlayer(String teamName, String season) {
		// TODO Auto-generated method stub
		DataBLService d=new DataBL();
		MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=md.getMatchOfTeam(teamName, season);
		ArrayList<PlayerVO> p=d.getAllPlayerInfo(season);
		
		ArrayList<PlayerVO> p2=new ArrayList<PlayerVO>();
		for(int i=0;i<p.size();i++){
			if(p.get(i).getTeamName().equals(teamName)){
				p2.add(p.get(i));
			}
		}
		double[] n=new double[p2.size()];		
		double CORR = 0.0;  
		for(int j=0;j<p2.size();j++){
			List<String> xList = new ArrayList<String>(); 
			List<String> yList = new ArrayList<String>();  
			
			for(int a=0;a<m.size();a++){
				ArrayList<MatchPlayer> mm = new ArrayList<MatchPlayer>();
				if(m.get(a).getTeam1().getTeamName().equals(teamName)){
					mm=m.get(a).getTeam1().getPlayers();	   
				}else if(m.get(a).getTeam2().getTeamName().equals(teamName)){
					mm=m.get(a).getTeam2().getPlayers();
				}else
					continue;
				double temp=0;			
				for(int k=0;k<mm.size();k++){
					if(mm.get(k).getPlayerName().equals(p2.get(j).getPlayerName())){					
						xList.add(String.valueOf(mm.get(k).getOffensiveRebound()));	
					}		
					temp+=mm.get(k).getOffensiveRebound();
				}  
				yList.add(String.valueOf(temp));					
			}		         
			NumberatorCalculate nc = new NumberatorCalculate(xList,yList);  
			double numerator = nc.calculateNumberator();  
			DenominatorCalculate dc = new DenominatorCalculate();  
			double denominator = dc.calculateDenominator(xList, yList);  
			CORR = numerator/denominator;  
			if(denominator==0){
				CORR=0;}
			n[j]=CORR;
			System.out.println(p2.get(j).getPlayerName()+"\t\t\t"+n[j]+"\t\t\t"+numerator+"\t\t"+denominator);
		}
		
		for(int i=0;i<n.length;i++){
			int k=0;
			for(int j=0;j<n.length;j++){
				if(n[i]<n[j])
					k=1;
			}
			if(k==0){
				return p2.get(i).getPlayerName();
			}
		}
		return null;
	}

	@Override
	public String getTheMostPotentialOffensivePlayer(String teamName,String season) {
		DataBLService d=new DataBL();
		MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=md.getMatchOfTeam(teamName, season);
		ArrayList<PlayerVO> p=d.getAllPlayerInfo(season);
		ArrayList<PlayerVO> p2=new ArrayList<PlayerVO>();
		for(int i=0;i<p.size();i++){
			if(p.get(i).getTeamName().equals(teamName)){
				p2.add(p.get(i));
			}
		}
		double[] n=new double[p2.size()];		
		for(int j=0;j<p2.size();j++){
			List<Double> xList = new ArrayList<Double>();
			List<Double> yList = new ArrayList<Double>();
			int l=1;  
			
			for(int a=0;a<m.size();a++){
				ArrayList<MatchPlayer> mm = new ArrayList<MatchPlayer>();
				ArrayList<MatchPlayer> mm2 = new ArrayList<MatchPlayer>();
				if(m.get(a).getTeam1().getTeamName().equals(teamName)){
					mm=m.get(a).getTeam1().getPlayers();
				    mm2=m.get(a).getTeam2().getPlayers();
				}else if(m.get(a).getTeam2().getTeamName().equals(teamName)){
					mm=m.get(a).getTeam2().getPlayers();
					mm2=m.get(a).getTeam1().getPlayers();
				}else
					continue;
				double temp=0;
				double temp2=0;
				double temp3=0;
				for(int k=0;k<mm.size();k++){
					temp+=mm.get(k).getOffensiveRebound();
					String[] str=mm.get(k).getMatchTime().split(":");
					double minutes=Double.parseDouble(str[0])+Double.parseDouble("0."+str[1])*5/3;
					temp3+=minutes;
				}  
				for(int k=0;k<mm2.size();k++){
					temp2+=mm2.get(k).getOffensiveRebound();
				}  
				for(int k=0;k<mm.size();k++){
					if(mm.get(k).getPlayerName().equals(p2.get(j).getPlayerName())){
						String[] str=mm.get(k).getMatchTime().split(":");
						double minutes=Double.parseDouble(str[0])+Double.parseDouble("0."+str[1])*5/3;
						if(minutes==0)
							xList.add(0.0);
						else
							xList.add(mm.get(k).getOffensiveRebound()*temp3/5/minutes/(temp+temp2));
						yList.add((double) l);
						l++;
					}					
				}  				
			}		
					 
			LinearRegression h=new LinearRegression(xList,yList);
			n[j]=h.getB();	
			System.out.println(p2.get(j).getPlayerName()+"\t\t"+n[j]+"\t\t"+"\t\t"+l);
			
		}		
		for(int i=0;i<n.length;i++){
			int k=0;
			for(int j=0;j<n.length;j++){
				if(n[i]<n[j])
					k=1;
			}
			if(k==0){
				return p2.get(i).getPlayerName();
			}
		}
		return null;
	}

	@Override
	public String getBestDefensivePlayer(String teamName, String season) {
		DataBLService d=new DataBL();
		MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=md.getMatchOfTeam(teamName, season);
		
		ArrayList<PlayerVO> p=d.getAllPlayerInfo(season);
		ArrayList<PlayerVO> p2=new ArrayList<PlayerVO>();
		for(int i=0;i<p.size();i++){
			if(p.get(i).getTeamName().equals(teamName)){
				p2.add(p.get(i));
			}
		}
		double[] n=new double[p2.size()];		
		double CORR = 0.0;  
		for(int j=0;j<p2.size();j++){
			List<String> xList = new ArrayList<String>();;  
			List<String> yList = new ArrayList<String>();  
			
			for(int a=0;a<m.size();a++){
				ArrayList<MatchPlayer> mm = new ArrayList<MatchPlayer>();
				if(m.get(a).getTeam1().getTeamName().equals(teamName))
					mm=m.get(a).getTeam1().getPlayers();
				else if(m.get(a).getTeam2().getTeamName().equals(teamName))
					mm=m.get(a).getTeam2().getPlayers();
				else
					continue;
				double temp=0;
				for(int k=0;k<mm.size();k++){
					if(mm.get(k).getPlayerName().equals(p2.get(j).getPlayerName())){
						xList.add(String.valueOf(mm.get(k).getDefensiveRebound()));	
					}
					temp+=mm.get(k).getDefensiveRebound();
				}  
				yList.add(String.valueOf(temp));					
			}		         
			NumberatorCalculate nc = new NumberatorCalculate(xList,yList);  
			double numerator = nc.calculateNumberator();  
			DenominatorCalculate dc = new DenominatorCalculate();  
			double denominator = dc.calculateDenominator(xList, yList);  
			
			CORR = numerator/denominator; 
			if(denominator==0)
				CORR=0;
			n[j]=CORR;
		}
		
		for(int i=0;i<n.length;i++){
			int k=0;
			for(int j=0;j<n.length;j++){
				if(n[i]<n[j])
					k=1;
			}
			if(k==0){
				return p2.get(i).getPlayerName();
			}
		}
		return null;
	}

	@Override
	public String getTheMostPotentialDefensivePlayer(String teamName,String season) {
		DataBLService d=new DataBL();
		MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=md.getMatchOfTeam(teamName, season);
		ArrayList<PlayerVO> p=d.getAllPlayerInfo(season);
		ArrayList<PlayerVO> p2=new ArrayList<PlayerVO>();
		for(int i=0;i<p.size();i++){
			if(p.get(i).getTeamName().equals(teamName)){
				p2.add(p.get(i));
			}
		}
		double[] n=new double[p2.size()];		
		for(int j=0;j<p2.size();j++){
			List<Double> xList = new ArrayList<Double>();
			List<Double> yList = new ArrayList<Double>();  
			int l=1;
			for(int a=0;a<m.size();a++){
				ArrayList<MatchPlayer> mm = new ArrayList<MatchPlayer>();
				ArrayList<MatchPlayer> mm2 = new ArrayList<MatchPlayer>();
				if(m.get(a).getTeam1().getTeamName().equals(teamName)){
					mm=m.get(a).getTeam1().getPlayers();
				    mm2=m.get(a).getTeam2().getPlayers();
				}else if(m.get(a).getTeam2().getTeamName().equals(teamName)){
					mm=m.get(a).getTeam2().getPlayers();
					mm2=m.get(a).getTeam1().getPlayers();
				}else
					continue;
				double temp=0;
				double temp2=0;
				double temp3=0;
				for(int k=0;k<mm.size();k++){
					temp+=mm.get(k).getDefensiveRebound();
					String[] str=mm.get(k).getMatchTime().split(":");
					double minutes=Double.parseDouble(str[0])+Double.parseDouble("0."+str[1])*5/3;
					temp3+=minutes;
				}  
				for(int k=0;k<mm2.size();k++){
					temp2+=mm2.get(k).getDefensiveRebound();
				}  
				for(int k=0;k<mm.size();k++){
					if(mm.get(k).getPlayerName().equals(p2.get(j).getPlayerName())){
						String[] str=mm.get(k).getMatchTime().split(":");
						double minutes=Double.parseDouble(str[0])+Double.parseDouble("0."+str[1])*5/3;
						if(minutes==0)
							xList.add(0.0);
						else
							xList.add(mm.get(k).getDefensiveRebound()*temp3/5/minutes/(temp+temp2));
						yList.add((double) l);
						l++;
					}					
				}  					
			}		         
			LinearRegression h=new LinearRegression(xList,yList);
			n[j]=h.getB();		
		}		
		for(int i=0;i<n.length;i++){
			int k=0;
			for(int j=0;j<n.length;j++){
				if(n[i]<n[j])
					k=1;
			}
			if(k==0){
				return p2.get(i).getPlayerName();
			}
		}
		return null;
	}
	

}
