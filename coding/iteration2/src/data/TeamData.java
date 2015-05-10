package data;
 

import java.util.ArrayList;




import dataService.TeamDataService;
import po.BasicTeamPO;
import po.MatchPO;
import po.TeamPO;


public class TeamData implements TeamDataService{
	public TeamPO getSingleTeamInfo(String teamName){
		TeamDataCalculate tic=new TeamDataCalculate();
		TeamPO result=new TeamPO();

		if(tic.judgeEmptyFile("Data//teamInfoPO.txt")){
		
			BasicTeamData btd=new BasicTeamData();
			BasicTeamPO tp=btd.getSingleTeamOriginal(teamName);
			
			result.setTeamName(tp.getAbbreviation());
			result.setFullName(tp.getFullName());
			result.setCity(tp.getCity());
			result.setZone(tp.getZone());
			result.setSubarea(tp.getSubarea());
			result.setHomeCourt(tp.getHomeCourt());
			result.setCreateTime(tp.getCreateTime());
		
		
			MatchData md=new MatchData();
			ArrayList<MatchPO> mp=md.getAllMatchInfo();
			ArrayList<MatchPO> mpselected=new ArrayList<MatchPO>();
		
			for(int i=0;i<mp.size();i++){
				if(mp.get(i).getTeam1().getTeamName().equals(result.getTeamName())
						||mp.get(i).getTeam2().getTeamName().equals(result.getTeamName())){
					mpselected.add(mp.get(i));
				}
			}//筛选队伍参与的比赛
			
			result.setGamesPlayed(mpselected.size());
			result.setFieldGoalsMade(tic.calculateFieldGoalsMade(result.getTeamName(), mpselected));
			result.setFieldGoalsAttempted(tic.calculateFieldGoalsAttempted(result.getTeamName(), mpselected));
			result.setThreePointFieldGoalsMade(tic.calculateThreePointFieldGoalsMade(result.getTeamName(), mpselected));
			result.setThreePointFieldGoalsAttempted(tic.calculateThreePointFieldGoalsAttempted(result.getTeamName(), mpselected));
			result.setFreeThrowsMade(tic.calculateFreeThrowsMade(result.getTeamName(),mpselected));
			result.setFreeThrowsAttempted(tic.calculateFreeThrowsAttempted(result.getTeamName(), mpselected));
			result.setOffensiveRebounds(tic.calculateOffensiveRebounds(result.getTeamName(), mpselected));
			result.setDefensiveRebounds(tic.calculateDefensiveRebounds(result.getTeamName(), mpselected));
			result.setRebounds(result.getOffensiveRebounds()+result.getDefensiveRebounds());
			result.setAssists(tic.calculateAssists(result.getTeamName(),mpselected));
			result.setSteals(tic.calculateSteals(result.getTeamName(), mpselected));
			result.setBlocks(tic.calculateBlocks(result.getTeamName(), mpselected));
			result.setTurnovers(tic.calculateTurnovers(result.getTeamName(), mpselected));
			result.setFouls(tic.calculateFouls(result.getTeamName(),mpselected));
			result.setPoints(tic.calculatePoints(result.getTeamName(), mpselected));
			result.setFieldGoalPercentage(result.getFieldGoalsMade()/result.getFieldGoalsAttempted());
			result.setThreePointFieldGoalPercentage(result.getThreePointFieldGoalsMade()/result.getThreePointFieldGoalsAttempted());
			result.setFreeThrowPercentage(result.getFreeThrowsMade()/result.getFreeThrowsAttempted());
			result.setWinPercentage((double)tic.calculateWins(result.getTeamName(), mpselected)/(double)result.getGamesPlayed());
			result.setOffensiveReboundPercentage(result.getOffensiveRebounds()/(result.getOffensiveRebounds()+tic.calculateOppositeDefensiveRebounds(result.getTeamName(), mpselected)));
			result.setDefensiveReboundPercentage(result.getDefensiveRebounds()/(result.getDefensiveRebounds()+tic.calculateOppositeOffensiveRebounds(result.getTeamName(), mpselected)));
			result.setPossessions(result.getFieldGoalsAttempted()+0.4*result.getFreeThrowsAttempted()
					-1.07*result.getOffensiveReboundPercentage()*(result.getFieldGoalsAttempted()-result.getFieldGoalsMade())+1.07*result.getTurnovers());
			result.setOffensiveRating(result.getPoints()/result.getPossessions()*100);
			double oppositeOffensiveReboundPer=tic.calculateOppositeOffensiveRebounds(result.getTeamName(), mpselected)/(tic.calculateOppositeOffensiveRebounds(result.getTeamName(), mpselected)+result.getDefensiveRebounds());
			double oppositePossessions=tic.calculateOppositeFieldGoalsAttempted(result.getTeamName(), mpselected)+0.4*tic.calculateOppositeFreeThrowsAttempted(result.getTeamName(), mpselected)
				-1.07*oppositeOffensiveReboundPer*(tic.calculateOppositeFieldGoalsAttempted(result.getTeamName(), mpselected)-tic.calculateOppositeFieldGoalsMade(result.getTeamName(), mpselected))+1.07*tic.calculateOppositeTurnovers(result.getTeamName(), mpselected);
			//计算对手进攻回合数
			result.setDefensiveRating(tic.calculateOppositePoints(result.getTeamName(), mpselected)/oppositePossessions*100);
			result.setStealPercentage(result.getSteals()/oppositePossessions*100);
			result.setAssistPercentage(result.getAssists()/result.getPossessions()*100);
		
			return result;
		}
		else{
			ArrayList<TeamPO> all=tic.readTeamInfo();
			for(int i=0;i<all.size();i++){
				if(teamName.equals(all.get(i).getFullName())){
					result=all.get(i);
				}
			}
			return result;
		}
	}
	
	
	public ArrayList<TeamPO> getAllTeamInfo(){
		TeamDataCalculate tic=new TeamDataCalculate();
		ArrayList<TeamPO> result=new ArrayList<TeamPO>();
		ArrayList<TeamPO> original=new ArrayList<TeamPO>();
		BasicTeamData btd=new BasicTeamData();
		TeamData td=new TeamData();

		
		if(tic.judgeEmptyFile("Data//teamInfoPO.txt")){
			ArrayList<BasicTeamPO> tp=btd.getTeamOriginal();
			for(int i=0;i<tp.size()&&i<30;i++){
				if(tp.get(i).getFullName()!=null){
				
					original.add(td.getSingleTeamInfo(tp.get(i).getAbbreviation()));
					
				}
			}
			tic.writeTeamInfo(original);
			System.out.println("未执行readTeam");
		}
		else{
			original=tic.readTeamInfo();
			System.out.println("执行了readTeam");
		}
		
		
		
		return result;
	}
	
	
	/*public static void main(String[]args){
		TeamData td=new TeamData();
		td.getAllTeamInfo();
	}*/
}
