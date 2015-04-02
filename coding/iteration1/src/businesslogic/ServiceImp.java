package businesslogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import vo.teamCondition;
import vo.teamInfoVO;
import vo.teamPartion;

public class ServiceImp implements IService{
	public teamInfoVO getSingleTeamInfo(teamInfoVO t){
		TeamInfoCalculate tic=new TeamInfoCalculate();
		teamInfoVO result=new teamInfoVO();
		if(tic.judgeEmptyFile("Data//teamInfoVO.txt")){
		
			TeamData td=new TeamData();
			TeamInfoPO tp=td.getSingleTeamOriginal(t.getFullName());
			
			result.setTeamName(tp.getAbbreviation());
			result.setFullName(t.getFullName());
			result.setCity(tp.getCity());
			result.setZone(tp.getZone());
			result.setSubarea(tp.getSubarea());
			result.setHomeCourt(tp.getHomeCourt());
			result.setCreateTime(tp.getCreateTime());
		
		
			MatchData md=new MatchData();
			ArrayList<MatchInfoPO> mp=md.getMatchOriginal();
			ArrayList<MatchInfoPO> mpselected=new ArrayList<MatchInfoPO>();
		
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
			ArrayList<teamInfoVO> all=tic.readTeamInfo();
			for(int i=0;i<all.size();i++){
				if(t.getFullName().equals(all.get(i).getFullName())){
					result=all.get(i);
				}
			}
			return result;
		}
	}
	
	
	public ArrayList<teamInfoVO> getTeamInfo(teamCondition tc){
		TeamInfoCalculate tic=new TeamInfoCalculate();
		ArrayList<teamInfoVO> result=new ArrayList<teamInfoVO>();
		ArrayList<teamInfoVO> original=new ArrayList<teamInfoVO>();
		ServiceImp si=new ServiceImp();
		
		if(tic.judgeEmptyFile("Data//teamInfoVO.txt")){
			TeamData td=new TeamData();
			ArrayList<TeamInfoPO> tp=td.getTeamOriginal();
			for(int i=0;i<tp.size()&&i<30;i++){
				if(tp.get(i).getFullName()!=null){
					teamInfoVO temp=new teamInfoVO();
					temp.setFullName(tp.get(i).getFullName());
					temp.setSubarea(tp.get(i).getSubarea());	
					original.add(si.getSingleTeamInfo(temp));
				}
			}
			tic.writeTeamInfo(original);
			System.out.println("未执行readTeam");
		}
		else{
			original=tic.readTeamInfo();
			System.out.println("执行了readTeam");
		}
		
		
		if(tc.getTeampartion().equals(teamPartion.All)){	
			for(int i=0;i<original.size();i++){
				result.add(original.get(i));
			}
		}
		else if(tc.getTeampartion().equals(teamPartion.East)){
			for(int i=0;i<original.size();i++){
				if(original.get(i).getSubarea().equals("Southeast")||original.get(i).getSubarea().equals("Central")||original.get(i).getSubarea().equals("Atlantic")){
					result.add(original.get(i));
				}
			}
		}
		else if(tc.getTeampartion().equals(teamPartion.West)){
			for(int i=0;i<original.size();i++){
				if(original.get(i).getSubarea().equals("Southwest")||original.get(i).getSubarea().equals("Northwest")||original.get(i).getSubarea().equals("Pacific")){
					result.add(original.get(i));
				}
			}
		}
		else if(tc.getTeampartion().equals(teamPartion.Southeast)){
			for(int i=0;i<original.size();i++){
				if(original.get(i).getSubarea().equals("Southeast")){
					result.add(original.get(i));
				}
			}
		}
		else if(tc.getTeampartion().equals(teamPartion.Central)){
			for(int i=0;i<original.size();i++){
				if(original.get(i).getSubarea().equals("Central")){
					result.add(original.get(i));
				}
			}
		}
		else if(tc.getTeampartion().equals(teamPartion.Atlantic)){
			for(int i=0;i<original.size();i++){
				if(original.get(i).getSubarea().equals("Atlantic")){
					result.add(original.get(i));
				}
			}
		}
		else if(tc.getTeampartion().equals(teamPartion.Southwest)){
			for(int i=0;i<original.size();i++){
				if(original.get(i).getSubarea().equals("Southwest")){
					result.add(original.get(i));
				}
			}
		}
		else if(tc.getTeampartion().equals(teamPartion.Northwest)){
			for(int i=0;i<original.size();i++){
				if(original.get(i).getSubarea().equals("Northwest")){
					result.add(original.get(i));
				}
			}
		}
		else if(tc.getTeampartion().equals(teamPartion.Pacific)){
			for(int i=0;i<original.size();i++){
				if(original.get(i).getSubarea().equals("Pacific")){
					result.add(original.get(i));
				}
			}
		}
		return result;
	}
	
	
	public ArrayList<teamInfoVO> sortTeam(ArrayList<teamInfoVO> original ,String s ){
		ArrayList <teamInfoVO> result =new ArrayList<teamInfoVO>();
		if(s.equals("gamesPlayed")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getGamesPlayed()>original.get(max).getGamesPlayed()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("fieldGoalsMade")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getFieldGoalsMade()>original.get(max).getFieldGoalsMade()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("fieldGoalsAttempted")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getFieldGoalsAttempted()>original.get(max).getFieldGoalsAttempted()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("threePointFieldGoalsMade")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getThreePointFieldGoalsMade()>original.get(max).getThreePointFieldGoalsMade()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("threePointFieldGoalsAttempted")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getThreePointFieldGoalsAttempted()>original.get(max).getThreePointFieldGoalsAttempted()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("freeThrowsMade")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getFreeThrowsMade()>original.get(max).getFreeThrowsMade()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("freeThrowsAttempted")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getFreeThrowsAttempted()>original.get(max).getFreeThrowsAttempted()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("offensiveRebounds")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getOffensiveRebounds()>original.get(max).getOffensiveRebounds()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("defensiveRebounds")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getDefensiveRebounds()>original.get(max).getDefensiveRebounds()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("rebounds")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getRebounds()>original.get(max).getRebounds()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("assists")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getAssists()>original.get(max).getAssists()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("steals")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getSteals()>original.get(max).getSteals()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("blocks")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getBlocks()>original.get(max).getBlocks()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("turnovers")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getTurnovers()>original.get(max).getTurnovers()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("fouls")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getFouls()>original.get(max).getFouls()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("points")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getPoints()>original.get(max).getPoints()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("fieldGoalPercentage")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getFieldGoalPercentage()>original.get(max).getFieldGoalPercentage()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("threePointFieldGoalPercentage")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getThreePointFieldGoalPercentage()>original.get(max).getThreePointFieldGoalPercentage()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("freeThrowPercentage")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getFreeThrowPercentage()>original.get(max).getFreeThrowPercentage()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("winPercentage")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getWinPercentage()>original.get(max).getWinPercentage()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("possessions")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getPossessions()>original.get(max).getPossessions()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("offensiveRating")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getOffensiveRating()>original.get(max).getOffensiveRating()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("defensiveRating")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getDefensiveRating()>original.get(max).getDefensiveRating()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("offensiveReboundPercentage")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getOffensiveReboundPercentage()>original.get(max).getOffensiveReboundPercentage()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("defensiveReboundPercentage")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getDefensiveReboundPercentage()>original.get(max).getDefensiveReboundPercentage()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("stealPercentage")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getStealPercentage()>original.get(max).getStealPercentage()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		else if(s.equals("assistPercentage")){
			while(original.size()>0){
				int max=0;
				for(int i=0;i<original.size();i++){
					if(original.get(i).getAssistPercentage()>original.get(max).getAssistPercentage()){
						max=i;
					}
				}
				result.add(original.get(max));
				original.remove(max);
			}
		}
		return result;
	}
	
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc){
		ArrayList<playerInfoVO> result=new ArrayList<playerInfoVO>();
		
		File file = new File("Data//playerInfoVO.txt");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while((s = br.readLine())!=null){
				String[] temp=s.split(";");
				playerInfoVO piv=new playerInfoVO();
				piv.setPlayerName(temp[0]);
				piv.setTeamName(temp[1]);
				piv.setGamesPlayed(Integer.parseInt(temp[2]));
				piv.setGamesStarting(Integer.parseInt(temp[3]));
				piv.setRebounds(Double.valueOf(temp[4]));
				piv.setAssists(Double.valueOf(temp[5]));
				piv.setMinutes(Double.valueOf(temp[6]));
				piv.setFieldGoalsPercentage(Double.valueOf(temp[7]));
				piv.setThreePointFieldGoalsPercentage(Double.valueOf(temp[8]));
				piv.setFreeThrowsPercentage(Double.valueOf(temp[9]));
				piv.setOffensiveRebounds(Double.valueOf(temp[10]));
				piv.setDefensiveRebounds(Double.valueOf(temp[11]));
				piv.setSteals(Double.valueOf(temp[12]));
				piv.setBlocks(Double.valueOf(temp[13]));
				piv.setTurnovers(Double.valueOf(temp[14]));
				piv.setFouls(Double.valueOf(temp[15]));
				piv.setPoints(Double.valueOf(temp[16]));
				piv.setEfficiency(Double.valueOf(temp[17]));
				piv.setGmSc(Double.valueOf(temp[18]));
				piv.setTrueShootingPercentage(Double.valueOf(temp[19]));
				piv.setShootingEfficiency(Double.valueOf(temp[20]));
				piv.setReboundRating(Double.valueOf(temp[21]));
				piv.setOffensiveReboundRating(Double.valueOf(temp[22]));
				piv.setDefensiveReboundRating(Double.valueOf(temp[23]));
				piv.setAssisyRating(Double.valueOf(temp[24]));
				piv.setStealRating(Double.valueOf(temp[25]));
				piv.setBlockRating(Double.valueOf(temp[26]));
				piv.setTurnoverRating(Double.valueOf(temp[27]));
				piv.setUtilizationRating(Double.valueOf(temp[28]));
				piv.setNumber(temp[29]);
				piv.setPosition(temp[30]);
				piv.setHeight(temp[31]);
				piv.setWeight(temp[32]);
				piv.setBirth(temp[33]);
				piv.setAge(temp[34]);
				piv.setExp(temp[35]);
				piv.setSchool(temp[36]);
				piv.setDoubleDouble(Double.valueOf(temp[37]));
				result.add(piv);

			}
			br.close();    
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(pc.getPlayerPosition().equals(playerPosition.All)){
		}else if(pc.getPlayerPosition().equals(playerPosition.Center)){
			for(int i=result.size()-1;i>=0;i--){
				if(!result.get(i).getPosition().equals("C") && !result.get(i).getPosition().equals("C-F") && !result.get(i).getPosition().equals("F-C")){	
					result.remove(i);
				}
			}
		}else if(pc.getPlayerPosition().equals(playerPosition.Guard)){
			for(int i=result.size()-1;i>=0;i--){
				if(!result.get(i).getPosition().equals("G") && !result.get(i).getPosition().equals("G-F") && !result.get(i).getPosition().equals("F-G")){	
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
				if(result.get(i).getTeamName().equals("Unknow")){
					result.remove(i);
				}else{
					String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Atlantic"))
						result.remove(i);
				}
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.Central)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("Unknow")){
					result.remove(i);
				}else{
					String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Central"))
						result.remove(i);
				}
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.East)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("Unknow")){
					result.remove(i);
				}else{
					String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getZone();
					if(!area.equals("E"))
						result.remove(i);
				}
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.Northwest)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("Unknow")){
					result.remove(i);
				}else{
					String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Northwest"))
						result.remove(i);
				}
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.Pacific)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("Unknow")){
					result.remove(i);
				}else{
					String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Pacific"))
						result.remove(i);
				}
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.Southeast)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("Unknow")){
					result.remove(i);
				}else{
					String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getSubarea();
					if(!area.equals("Southeast"))
						result.remove(i);
				}
			}
		}else if(pc.getPlayerPartition().equals(playerPartition.West)){
			for(int i=result.size()-1;i>=0;i--){
				if(result.get(i).getTeamName().equals("Unknow")){
					result.remove(i);
				}else{
					String area=TD.getSingleTeamOriginal(result.get(i).getTeamName()).getZone();
					if(!area.equals("W"))
						result.remove(i);
				}
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
		
		result.setPlayerName(p.getPlayerName());
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
		
		if(mpSelected.size()==0){
			result.setTeamName("Unknow");
		}else{
			result.setTeamName(pic.CalculateTeam(p.getPlayerName(),mpSelected.get(mpSelected.size()-1)));
			result.setGamesPlayed(mpSelected.size());
			result.setGamesStarting(pic.CalculateGamesStarting(p.getPlayerName(), mpSelected));
			result.setRebounds(pic.CalculateRebounds(MP));
			result.setAssists(pic.CalculateAssists(MP));
			result.setMinutes(pic.CalculateMinutes(MP));
			result.setFieldGoalsPercentage(100*pic.CalculateFieldGoalsPercentage(MP));
			result.setThreePointFieldGoalsPercentage(100*pic.CalculateThreePointFieldGoalsPercentage(MP));
			result.setFreeThrowsPercentage(100*pic.CalculateFreeThrowsPercentage(MP));
			result.setOffensiveRebounds(pic.CalculateOffensiveRebounds(MP));
			result.setDefensiveRebounds(pic.CalculateDefensiveRebounds(MP));
			result.setSteals(pic.CalculateSteals(MP));
			result.setBlocks(pic.CalculateBlocks(MP));
			result.setTurnovers(pic.CalculateTurnovers(MP));
			result.setFouls(pic.CalculateFouls(MP));
			result.setPoints(pic.CalculatePoints(MP));
			result.setEfficiency(pic.CalculateEfficiency(MP));
			result.setGmSc(pic.CalculateGmSc(MP));
			result.setTrueShootingPercentage(100*pic.CalculateTrueShootingPercentage(MP));
			result.setShootingEfficiency(100*pic.CalculateShootingEfficiency(MP));
			result.setReboundRating(100*pic.CalculateReboundRating(MT,MT2,MP));
			result.setOffensiveReboundRating(100*pic.CalculateOffensiveReboundRating(MT,MT2,MP));
			result.setDefensiveReboundRating(100*pic.CalculateDefensiveReboundRating(MT,MT2,MP));
			result.setAssisyRating(100*pic.CalculateAssisyRating(MT,MP));
			result.setStealRating(100*pic.CalculateStealRating(MT,MT2,MP));
			result.setBlockRating(100*pic.CalculateBlockRating(MT,MT2,MP));
			result.setTurnoverRating(100*pic.CalculateTurnoverRating(MP));
			result.setUtilizationRating(100*pic.CalculateUtilizationRating(MT,MP));
			result.setDoubleDouble(pic.CalculateDoubleDouble(MP));
		}
		
		return result;
	}
	
	public ArrayList<playerInfoVO> descendingOrder(ArrayList<playerInfoVO> piv,String s){
		ArrayList<playerInfoVO> result=new ArrayList<playerInfoVO>();
		if(s.equals("rebounds")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getRebounds()<piv.get(j).getRebounds())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("gamesPlayed")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getGamesPlayed()<piv.get(j).getGamesPlayed())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("gamesStarting")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getGamesStarting()<piv.get(j).getGamesStarting())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("assists")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getAssists()<piv.get(j).getAssists())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("minutes")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getMinutes()<piv.get(j).getMinutes())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("fieldGoalsPercentage")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getFieldGoalsPercentage()<piv.get(j).getFieldGoalsPercentage())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("threePointFieldGoalsPercentage")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getThreePointFieldGoalsPercentage()<piv.get(j).getThreePointFieldGoalsPercentage())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("freeThrowsPercentage")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getFreeThrowsPercentage()<piv.get(j).getFreeThrowsPercentage())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("offensiveRebounds")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getOffensiveRebounds()<piv.get(j).getOffensiveRebounds())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("defensiveRebounds")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getDefensiveRebounds()<piv.get(j).getDefensiveRebounds())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("steals")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getSteals()<piv.get(j).getSteals())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("blocks")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getBlocks()<piv.get(j).getBlocks())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("turnovers")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getTurnovers()<piv.get(j).getTurnovers())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("fouls")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getFouls()<piv.get(j).getFouls())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("points")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getPoints()<piv.get(j).getPoints())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("efficiency")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getEfficiency()<piv.get(j).getEfficiency())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("GmSc")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getGmSc()<piv.get(j).getGmSc())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("trueShootingPercentage")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getTrueShootingPercentage()<piv.get(j).getTrueShootingPercentage())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("shootingEfficiency")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getShootingEfficiency()<piv.get(j).getShootingEfficiency())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("reboundRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getReboundRating()<piv.get(j).getReboundRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("offensiveReboundRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getOffensiveReboundRating()<piv.get(j).getOffensiveReboundRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("defensiveReboundRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getDefensiveReboundRating()<piv.get(j).getDefensiveReboundRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("assisyRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getAssisyRating()<piv.get(j).getAssisyRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("stealRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getStealRating()<piv.get(j).getStealRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("blockRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getBlockRating()<piv.get(j).getBlockRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("turnoverRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getTurnoverRating()<piv.get(j).getTurnoverRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("utilizationRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getUtilizationRating()<piv.get(j).getUtilizationRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("pointsReboundsAssists")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getPoints()+piv.get(i).getRebounds()+piv.get(i).getAssists()
							<piv.get(j).getPoints()+piv.get(j).getRebounds()+piv.get(j).getAssists())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("doubleDouble")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getDoubleDouble()<piv.get(j).getDoubleDouble())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}
		return result;
	}//降序排序
	
	/*public static void main(String[] args){
		ArrayList<playerInfoVO> a=new ArrayList<playerInfoVO>();
		playerInfoVO b=new playerInfoVO();
		playerInfoVO c=new playerInfoVO();

		ServiceImp si=new ServiceImp();
		playerCondition pc=new playerCondition();
		pc.setPlayerPartition(playerPartition.Southeast);
		pc.setPlayerPosition(playerPosition.All);
		pc.setSortOpinions(sortOpinions.Null);
		
		b.setPlayerName("Kobe Bryant");
		c=si.getSinglePlayerInfo(b);
		System.out.println(c.getAge());
		
		b.setPlayerName("LeBron James");
		c=si.getSinglePlayerInfo(b);
		System.out.println(c.getAge());
		
		playerInfoCalculate pic=new playerInfoCalculate();
		a=si.getPlayerInfo(pc);
		System.out.println(a.size());
		for(int i=0;i<a.size();i++){
			System.out.println(i+"\t"+a.get(i).getPoints()+"\t"+a.get(i).getPosition()+"\t"+i+a.get(i).getPlayerName()+"\t"+a.get(i).getAge()+"\t"+a.get(i).getAssists()+"\t"+a.get(i).getAssisyRating()+"\t"+a.get(i).getBirth()+"\t"+a.get(i).getBlockRating()+"\t"+a.get(i).getBlocks()+"\t"+a.get(i).getDefensiveReboundRating()+"\t"+a.get(i).getDefensiveRebounds()+"\t"+a.get(i).getDoubleDouble()+"\t"+a.get(i).getEfficiency()+"\t"+a.get(i).getExp()+"\t"+a.get(i).getFieldGoalsPercentage()+"\t"+a.get(i).getFouls()+"\t"+a.get(i).getFreeThrowsPercentage()+"\t"+a.get(i).getGamesPlayed()+"\t"+a.get(i).getGamesStarting()+"\t"+a.get(i).getGmSc()+"\t"+a.get(i).getHeight()+"\t"+a.get(i).getMinutes()+"\t"+a.get(i).getNumber()+"\t"+a.get(i).getOffensiveReboundRating()
					+"\t"+a.get(i).getOffensiveRebounds()+"\t"+a.get(i).getPlayerName()+"\t"+a.get(i).getPoints()+"\t"+a.get(i).getPosition()+"\t"+a.get(i).getReboundRating()+"\t"+a.get(i).getRebounds()+"\t"+a.get(i).getSchool()+"\t"+a.get(i).getShootingEfficiency()+"\t"+a.get(i).getStealRating()+"\t"+a.get(i).getSteals()+"\t"+a.get(i).getTeamName()+"\t"+a.get(i).getThreePointFieldGoalsPercentage()+"\t"+a.get(i).getTrueShootingPercentage()+"\t"+a.get(i).getTurnoverRating()+"\t"+a.get(i).getTurnovers()+"\t"+a.get(i).getUtilizationRating()+"\t"+a.get(i).getWeight());
		}
		
		
		
	}*/
	

	/*public static void main(String []args){
		ServiceImp si=new ServiceImp();
		teamCondition tc=new teamCondition();
		tc.setTeampartion(teamPartion.East);
		ArrayList<teamInfoVO> teaminfo=si.getTeamInfo(tc);
		System.out.println(teaminfo.size());
		for(int i=0;i<teaminfo.size();i++){
			System.out.println(i+";"+teaminfo.get(i).getTeamName()+";"+teaminfo.get(i).getGamesPlayed()+";"+teaminfo.get(i).getFieldGoalsMade()+";"+teaminfo.get(i).getFieldGoalsAttempted()+";"+teaminfo.get(i).getThreePointFieldGoalsMade()
					+";"+teaminfo.get(i).getThreePointFieldGoalsAttempted()+";"+teaminfo.get(i).getFreeThrowsMade()+";"+teaminfo.get(i).getFreeThrowsAttempted()+";"+teaminfo.get(i).getOffensiveRebounds()+";"+teaminfo.get(i).getDefensiveRebounds()
					+";"+teaminfo.get(i).getRebounds()+";"+teaminfo.get(i).getAssists()+";"+teaminfo.get(i).getSteals()+";"+teaminfo.get(i).getBlocks()+";"+teaminfo.get(i).getTurnovers()+";"+teaminfo.get(i).getFouls()+";"+teaminfo.get(i).getPoints()
					+";"+teaminfo.get(i).getFieldGoalPercentage()+";"+teaminfo.get(i).getThreePointFieldGoalPercentage()+";"+teaminfo.get(i).getFreeThrowPercentage()+";"+teaminfo.get(i).getWinPercentage()+";"+teaminfo.get(i).getPossessions()
					+";"+teaminfo.get(i).getOffensiveRating()+";"+teaminfo.get(i).getDefensiveRating()+";"+teaminfo.get(i).getOffensiveReboundPercentage()+";"+teaminfo.get(i).getDefensiveReboundPercentage()+";"+teaminfo.get(i).getStealPercentage()
					+";"+teaminfo.get(i).getAssistPercentage()+";"+teaminfo.get(i).getFullName()+";"+teaminfo.get(i).getCity()+";"+teaminfo.get(i).getZone()+";"+teaminfo.get(i).getSubarea()+";"+teaminfo.get(i).getHomeCourt()+";"+teaminfo.get(i).getCreateTime());
		}
	}*/
}
