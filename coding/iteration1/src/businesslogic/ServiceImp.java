package businesslogic;

import java.util.ArrayList;

import po.MatchInfoPO;
import po.MatchPlayer;
import po.MatchTeam;
import po.PlayerInfoPO;
import po.TeamInfoPO;
import data.MatchData;
import data.PlayerData;
import data.TeamData;
import vo.playerCondition;
import vo.playerInfoVO;
import vo.playerPartition;
import vo.playerPosition;
import vo.sortOpinions;
import vo.teamInfoVO;

public class ServiceImp implements IService{
	public teamInfoVO getSingleTeamInfo(teamInfoVO t){
		teamInfoVO result=new teamInfoVO();
		
		TeamData td=new TeamData();
		TeamInfoPO tp=td.getSingleTeamOriginal(t.getTeamName());
		
		result.setTeamName(t.getTeamName());
		result.setFullName(tp.getFullName());
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
		result.setOffensiveReboundPercentage(result.getOffensiveRebounds()/(result.getOffensiveRebounds()+tic.calculateOppositeDefensiveRebounds(t.getTeamName(), mpselected)));
		result.setDefensiveReboundPercentage(result.getDefensiveRebounds()/(result.getDefensiveRebounds()+tic.calculateOppositeOffensiveRebounds(t.getTeamName(), mpselected)));
		result.setPossessions(result.getFieldGoalsAttempted()+0.4*result.getFreeThrowsAttempted()
				-1.07*result.getOffensiveReboundPercentage()*(result.getFieldGoalsAttempted()-result.getFieldGoalsMade())+1.07*result.getTurnovers());
		result.setOffensiveRating(result.getPoints()/result.getPossessions()*100);
		double oppositeOffensiveReboundPer=tic.calculateOppositeOffensiveRebounds(t.getTeamName(), mpselected)/(tic.calculateOppositeOffensiveRebounds(t.getTeamName(), mpselected)+result.getDefensiveRebounds());
		double oppositePossessions=tic.calculateOppositeFieldGoalsAttempted(t.getTeamName(), mpselected)+0.4*tic.calculateOppositeFreeThrowsAttempted(t.getTeamName(), mpselected)
				-1.07*oppositeOffensiveReboundPer*(tic.calculateOppositeFieldGoalsAttempted(t.getTeamName(), mpselected)-tic.calculateOppositeFieldGoalsMade(t.getTeamName(), mpselected))+1.07*tic.calculateOppositeTurnovers(t.getTeamName(), mpselected);
		//计算对手进攻回合数
		result.setDefensiveRating(tic.calculateOppositePoints(t.getTeamName(), mpselected)/oppositePossessions*100);
		result.setStealPercentage(result.getSteals()/oppositePossessions*100);
		result.setAssistPercentage(result.getAssists()/result.getPossessions()*100);
		
		return result;
	}
	
	
	public ArrayList<teamInfoVO> getTeamInfo(){
		ServiceImp si=new ServiceImp();
		ArrayList<teamInfoVO> result=new ArrayList<teamInfoVO>();
		
		TeamData td=new TeamData();
		ArrayList<TeamInfoPO> tp=td.getTeamOriginal();
		
		for(int i=0;i<tp.size()&&i<30;i++){
			if(tp.get(i).getFullName()!=null){
				teamInfoVO temp=new teamInfoVO();
				temp.setTeamName(tp.get(i).getAbbreviation());
				result.add(si.getSingleTeamInfo(temp));				
			}
		}
		
		return result;
	}
	
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc){
		ArrayList<playerInfoVO> result=new ArrayList<playerInfoVO>();
		
		PlayerData pd=new PlayerData();
		ArrayList<PlayerInfoPO> pip=pd.getPlayerOriginal();

		for(int i=0;i<pip.size();i++){
			playerInfoVO temp=new playerInfoVO();
			temp.setPlayerName(pip.get(i).getName());
			ServiceImp si=new ServiceImp();
			playerInfoVO piv=si.getSinglePlayerInfo(temp);
			result.add(piv);
		}
		
		if(pc.getPlayerPosition().equals(playerPosition.All)){
		}else if(pc.getPlayerPosition().equals(playerPosition.Center)){
			for(int i=result.size()-1;i>=0;i--){
				if(!result.get(i).getPosition().equals("C") && !result.get(i).getPosition().equals("C-F")){	
					result.remove(i);
				}
			}
		}else if(pc.getPlayerPosition().equals(playerPosition.Guard)){
			for(int i=result.size()-1;i>=0;i--){
				if(!result.get(i).getPosition().equals("G") && !result.get(i).getPosition().equals("G-F")){	
					result.remove(i);
				}
			}
		}else if(pc.getPlayerPosition().equals(playerPosition.Forward)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getPosition().equals("C") || result.get(i).getPosition().equals("G")){	
					result.remove(i);
				}
			}
		}
		
		TeamData TD=new TeamData();
		if(pc.getPlayerPartition().equals(playerPartition.All)){
		}else if(pc.getPlayerPartition().equals(playerPartition.Atlantic)){
			for(int i=result.size()-1;i>=0;i--){
				String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
				if(!area.equals("Atlantic"))
					result.remove(i);
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.Central)){
			for(int i=result.size()-1;i>=0;i--){
				String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
				if(!area.equals("Central"))
					result.remove(i);
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.East)){
			for(int i=result.size()-1;i>=0;i--){
				String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getZone();
				if(!area.equals("East"))
					result.remove(i);
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.Northwest)){
			for(int i=result.size()-1;i>=0;i--){
				String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
				if(!area.equals("Northwest"))
					result.remove(i);
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.Pacific)){
			for(int i=result.size()-1;i>=0;i--){
				String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
				if(!area.equals("Pacific"))
					result.remove(i);
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.Southeast)){
			for(int i=result.size()-1;i>=0;i--){
				String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
				if(!area.equals("Southeast"))
					result.remove(i);
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.West)){
			for(int i=result.size()-1;i>=0;i--){
				String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getZone();
				if(!area.equals("West"))
					result.remove(i);
			}
		}
		
		playerInfoCalculate pic=new playerInfoCalculate();
		if(pc.getSortOpinions().equals(sortOpinions.Null)){
		}else if(pc.getSortOpinions().equals(sortOpinions.Points)){
			result=pic.sort50(result, "Points");
		}else if(pc.getSortOpinions().equals(sortOpinions.Rebounds)){
			result=pic.sort50(result, "Rebounds");
		}else if(pc.getSortOpinions().equals(sortOpinions.Assists)){
			result=pic.sort50(result, "Assists");
		}else if(pc.getSortOpinions().equals(sortOpinions.PointsReboundsAssists)){
			result=pic.sort50(result, "PointsReboundsAssists");
		}else if(pc.getSortOpinions().equals(sortOpinions.Blocks)){
			result=pic.sort50(result, "Blocks");
		}else if(pc.getSortOpinions().equals(sortOpinions.Steals)){
			result=pic.sort50(result, "Steals");
		}else if(pc.getSortOpinions().equals(sortOpinions.Fouls)){
			result=pic.sort50(result, "Fouls");
		}else if(pc.getSortOpinions().equals(sortOpinions.Turnovers)){
			result=pic.sort50(result, "Turnovers");
		}else if(pc.getSortOpinions().equals(sortOpinions.Minutes)){
			result=pic.sort50(result, "Minutes");
		}else if(pc.getSortOpinions().equals(sortOpinions.Efficiency)){
			result=pic.sort50(result, "Efficiency");
		}else if(pc.getSortOpinions().equals(sortOpinions.FieldGoalsMade)){
			result=pic.sort50(result, "FieldGoalsMade");
		}else if(pc.getSortOpinions().equals(sortOpinions.ThreePointFieldGoalsMade)){
			result=pic.sort50(result, "ThreePointFieldGoalsMade");
		}else if(pc.getSortOpinions().equals(sortOpinions.FreeThrowsMade)){
			result=pic.sort50(result, "FreeThrowsMade");
		}else if(pc.getSortOpinions().equals(sortOpinions.DoubleDouble)){
			result=pic.sort50(result, "DoubleDouble");
		}
		
		
		return result;
	}
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p){
		playerInfoVO result=new playerInfoVO();
		
		PlayerData pd=new PlayerData();
		PlayerInfoPO pp=pd.getSinglePlayerOriginal(p.getPlayerName());
		
		result.setNumber(pp.getNumber());
		result.setPosition(pp.getPosition());
		result.setHeight(pp.getHeight());
		result.setWeight(pp.getWeight());
		result.setBirth(pp.getBirth());
		result.setAge(pp.getAge());
		result.setExp(pp.getExp());
		result.setSchool(pp.getSchool());
		//添加球员基本信息
		
		MatchData md=new MatchData();
		ArrayList<MatchInfoPO> mp=md.getMatchOriginal();
		ArrayList<MatchInfoPO> mpSelected=new ArrayList<MatchInfoPO>();//该球员参加的比赛
		ArrayList<MatchPlayer> MP=new ArrayList<MatchPlayer>();//该球员参加的比赛的个人数据
		ArrayList<MatchTeam> MT=new ArrayList<MatchTeam>();//该球员参加的比赛的队伍
		ArrayList<MatchTeam> MT2=new ArrayList<MatchTeam>();//该球员参加的比赛的对手队伍
		
		for(int i=0;i<mp.size();i++){
			ArrayList<MatchPlayer> tp=mp.get(i).getTeam1().getPlayers();
			for(int j=0;j<tp.size();j++){
				if(tp.get(j).getPlayerName().equals(p.getPlayerName())){
					mpSelected.add(mp.get(i));
					MP.add(tp.get(j));
					MT.add(mp.get(i).getTeam1());
					MT2.add(mp.get(i).getTeam2());
				}
			}
			ArrayList<MatchPlayer> tp2=mp.get(i).getTeam2().getPlayers();
			for(int j=0;j<tp2.size();j++){
				if(tp2.get(j).getPlayerName().equals(p.getPlayerName())){
					mpSelected.add(mp.get(i));
					MP.add(tp2.get(j));
					MT.add(mp.get(i).getTeam2());
					MT2.add(mp.get(i).getTeam1());
				}
			}
			
		}
		//筛选球员参与的比赛
		
		playerInfoCalculate pic=new playerInfoCalculate();
		
		result.setTeamName(pic.CalculateTeam(p.getPlayerName(),mpSelected.get(mpSelected.size())));
		result.setGamesPlayed(mpSelected.size());
		result.setGamesStarting(pic.CalculateGamesStarting(p.getPlayerName(), mpSelected));
		result.setRebounds(pic.CalculateRebounds(MP));
		result.setAssists(pic.CalculateAssists(MP));
		result.setMinutes(pic.CalculateMinutes(MP));
		result.setFieldGoalsMade(pic.CalculateFieldGoalsMade(MP));
		result.setThreePointFieldGoalsMade(pic.CalculateThreePointFieldGoalsMade(MP));
		result.setFreeThrowsMade(pic.CalculateFreeThrowsMade(MP));
		result.setOffensiveRebounds(pic.CalculateOffensiveRebounds(MP));
		result.setDefensiveRebounds(pic.CalculateDefensiveRebounds(MP));
		result.setSteals(pic.CalculateSteals(MP));
		result.setBlocks(pic.CalculateBlocks(MP));
		result.setTurnovers(pic.CalculateTurnovers(MP));
		result.setFouls(pic.CalculateFouls(MP));
		result.setPoints(pic.CalculatePoints(MP));
		result.setEfficiency(pic.CalculateEfficiency(MP));
		result.setGmSc(pic.CalculateGmSc(MP));
		result.setTrueShootingPercentage(pic.CalculateTrueShootingPercentage(MP));
		result.setShootingEfficiency(pic.CalculateShootingEfficiency(MP));
		result.setReboundRating(pic.CalculateReboundRating(MT,MT2,MP));
		result.setOffensiveReboundRating(pic.CalculateOffensiveReboundRating(MT,MT2,MP));
		result.setDefensiveReboundRating(pic.CalculateDefensiveReboundRating(MT,MT2,MP));
		result.setAssisyRating(pic.CalculateAssisyRating(MT,MP));
		result.setStealRating(pic.CalculateStealRating(MT,MT2,MP));
		result.setBlockRating(pic.CalculateBlockRating(MT,MT2,MP));
		result.setTurnoverRating(pic.CalculateTurnoverRating(MP));
		result.setUtilizationRating(pic.CalculateUtilizationRating(MT,MP));
		result.setDoubleDouble(pic.CalculateDoubleDouble(MP));
		
		return result;
	}
}
