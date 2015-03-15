package businesslogic;

import java.util.ArrayList;

import po.MatchInfoPO;
import po.TeamInfoPO;
import data.MatchData;
import data.TeamData;
import vo.playerCondition;
import vo.playerInfoVO;
import vo.teamInfoVO;

public class ServiceImp implements IService{
	public teamInfoVO getSingleTeamInfo(teamInfoVO t){
		teamInfoVO result=new teamInfoVO();
		
		TeamData td=new TeamData();
		TeamInfoPO tp=td.getSingleTeamOriginal(t.getTeamName());

		result.setFullName(tp.getFullName());
		result.setAbbreviation(tp.getAbbreviation());
		result.setCity(tp.getCity());
		result.setZone(tp.getZone());
		result.setSubarea(tp.getSubarea());
		result.setHomeCourt(tp.getHomeCourt());
		result.setCreateTime(tp.getCreateTime());
		
		
		MatchData md=new MatchData();
		ArrayList<MatchInfoPO> mp=md.getMatchOriginal();
		ArrayList<MatchInfoPO> mpselected=new ArrayList<MatchInfoPO>();
		
		for(int i=0;i<mp.size();i++){
			if(mp.get(i).getTeam1().getTeamName().equals(t.getTeamName())
					||mp.get(i).getTeam2().getTeamName().equals(t.getTeamName())){
				mpselected.add(mp.get(i));
			}
		}//筛选队伍参与的比赛
		
		TeamInfoCalculate tic=new TeamInfoCalculate();
				
		result.setgamesPlayed(mpselected.size());
		result.setFieldGoalsMade(tic.calculateFieldGoalsMade(t.getTeamName(), mpselected));
		result.setFieldGoalsAttempted(tic.calculateFieldGoalsAttempted(t.getTeamName(), mpselected));
		result.setThreePointFieldGoalsMade(tic.calculateThreePointFieldGoalsMade(t.getTeamName(), mpselected));
		result.setThreePointFieldGoalsAttempted(tic.calculateThreePointFieldGoalsAttempted(t.getTeamName(), mpselected));
		result.setFreeThrowsMade(tic.calculateFreeThrowsMade(t.getTeamName(),mpselected));
		result.setFreeThrowsAttempted(tic.calculateFreeThrowsAttempted(t.getTeamName(), mpselected));
		result.setOffensiveRebounds(tic.calculateOffensiveRebounds(t.getTeamName(), mpselected));
		result.setDefensiveRebounds(tic.calculateDefensiveRebounds(t.getTeamName(), mpselected));
		result.setRebounds(result.getOffensiveRebounds()+result.getDefensiveRebounds());
		result.setAssists(tic.calculateAssists(t.getTeamName(),mpselected));
		result.setSteals(tic.calculateSteals(t.getTeamName(), mpselected));
		result.setBlocks(tic.calculateBlocks(t.getTeamName(), mpselected));
		result.setTurnovers(tic.calculateTurnovers(t.getTeamName(), mpselected));
		result.setFouls(tic.calculateFouls(t.getTeamName(),mpselected));
		result.setPoints(tic.calculatePoints(t.getTeamName(), mpselected));
		result.setFieldGoalPercentage(result.getFieldGoalsMade()/result.getFieldGoalsAttempted());
		result.setThreePointFieldGoalPercentage(result.getThreePointFieldGoalsMade()/result.getThreePointFieldGoalsAttempted());
		result.setFreeThrowPercentage(result.getFreeThrowsMade()/result.getFreeThrowsAttempted());
		result.setWinPercentage(tic.calculateWins(t.getTeamName(), mpselected)/result.getgamesPlayed());
		result.setPossessions(result.getFieldGoalsAttempted()+0.4*result.getFreeThrowsAttempted()
				-1.07*result.getOffensiveReboundPercentage()*(result.getFieldGoalsAttempted()-result.getFieldGoalsMade())+1.07*result.getTurnovers());
		
		return result;
	}
	
	
	public ArrayList<teamInfoVO> getTeamInfo(){
		ArrayList<teamInfoVO> result=new ArrayList<teamInfoVO>();
		
		TeamData td=new TeamData();
		ArrayList<TeamInfoPO> tp=td.getTeamOriginal();
		
		for(int i=0;i<tp.size()&&i<30;i++){
			if(tp.get(i).getFullName()!=null){
				result.get(i).setFullName(tp.get(i).getFullName());
				result.get(i).setAbbreviation(tp.get(i).getAbbreviation());
				result.get(i).setCity(tp.get(i).getCity());
				result.get(i).setZone(tp.get(i).getZone());
				result.get(i).setSubarea(tp.get(i).getSubarea());
				result.get(i).setHomeCourt(tp.get(i).getHomeCourt());
				result.get(i).setCreateTime(tp.get(i).getCreateTime());
			}
		}
		
		return result;
	}
	
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc){
		ArrayList<playerInfoVO> s=new ArrayList<playerInfoVO>();
		return s;
	}
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p){
		return new playerInfoVO();
	}
}
