package businesslogic;

import java.util.ArrayList;

import businesslogicService.DataBLService;
import po.MatchPO;
import po.PlayerPO;
import po.TeamPO;
import data.MatchData;
import data.PlayerData;
import data.TeamData;
import dataService.MatchDataService;
import dataService.PlayerDataService;
import dataService.TeamDataService;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;

public class DataBL implements DataBLService {

	public ArrayList<MatchVO> findMatchByTeam(String teamName) {
		ArrayList<MatchVO> result=new ArrayList<MatchVO>();
		MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=new ArrayList<MatchPO>();
		m=md.getTeamRecentMatchInfo(5,teamName);
		for(int j=0;j<m.size();j++){
			MatchVO temp=new MatchVO();
			temp.setMatchTime(m.get(j).getMatchTime());
			temp.setTeams(m.get(j).getTeams());
			temp.setScore(m.get(j).getScore());
			temp.setScore1(m.get(j).getScore1());
			temp.setScore2(m.get(j).getScore2());
			temp.setScore3(m.get(j).getScore3());
			temp.setScore4(m.get(j).getScore4());
			temp.setExtraScores(m.get(j).getExtraScores());
			vo.MatchTeam t1=new vo.MatchTeam();
			vo.MatchTeam t2=new vo.MatchTeam();
			t1.setTeamName(m.get(j).getTeam1().getTeamName());
			t2.setTeamName(m.get(j).getTeam2().getTeamName());
			for(int i=0;i<m.get(j).getTeam1().getPlayers().size();i++){
				vo.MatchPlayer mp=new vo.MatchPlayer();
				mp.setPlayerName(m.get(j).getTeam1().getPlayers().get(i).getPlayerName());
				mp.setPosition(m.get(j).getTeam1().getPlayers().get(i).getPosition());
				mp.setMatchTime(m.get(j).getTeam1().getPlayers().get(i).getMatchTime());
				mp.setFieldGoal(m.get(j).getTeam1().getPlayers().get(i).getFieldGoal());
				mp.setFieldGoalAttempts(m.get(j).getTeam1().getPlayers().get(i).getFieldGoalAttempts());
				mp.setThreePointShot(m.get(j).getTeam1().getPlayers().get(i).getThreePointShot());
				mp.setThreePointAttempts(m.get(j).getTeam1().getPlayers().get(i).getThreePointAttempts());
				mp.setFreeThrowGoal(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowGoal());
				mp.setFreeThrowAttempts(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowAttempts());
				mp.setOffensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getOffensiveRebound());
				mp.setDefensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getDefensiveRebound());
				mp.setRebound(m.get(j).getTeam1().getPlayers().get(i).getRebound());
				mp.setAssist(m.get(j).getTeam1().getPlayers().get(i).getAssist());
				mp.setST(m.get(j).getTeam1().getPlayers().get(i).getST());
				mp.setBlockShot(m.get(j).getTeam1().getPlayers().get(i).getBlockShot());
				mp.setError(m.get(j).getTeam1().getPlayers().get(i).getError());
				mp.setFoul(m.get(j).getTeam1().getPlayers().get(i).getFoul());
				mp.setScore(m.get(j).getTeam1().getPlayers().get(i).getScore());
				t1.addPlayer(mp);
			}
			
			for(int i=0;i<m.get(j).getTeam2().getPlayers().size();i++){
				vo.MatchPlayer mp=new vo.MatchPlayer();
				mp.setPlayerName(m.get(j).getTeam2().getPlayers().get(i).getPlayerName());
				mp.setPosition(m.get(j).getTeam2().getPlayers().get(i).getPosition());
				mp.setMatchTime(m.get(j).getTeam2().getPlayers().get(i).getMatchTime());
				mp.setFieldGoal(m.get(j).getTeam2().getPlayers().get(i).getFieldGoal());
				mp.setFieldGoalAttempts(m.get(j).getTeam2().getPlayers().get(i).getFieldGoalAttempts());
				mp.setThreePointShot(m.get(j).getTeam2().getPlayers().get(i).getThreePointShot());
				mp.setThreePointAttempts(m.get(j).getTeam2().getPlayers().get(i).getThreePointAttempts());
				mp.setFreeThrowGoal(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowGoal());
				mp.setFreeThrowAttempts(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowAttempts());
				mp.setOffensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getOffensiveRebound());
				mp.setDefensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getDefensiveRebound());
				mp.setRebound(m.get(j).getTeam2().getPlayers().get(i).getRebound());
				mp.setAssist(m.get(j).getTeam2().getPlayers().get(i).getAssist());
				mp.setST(m.get(j).getTeam2().getPlayers().get(i).getST());
				mp.setBlockShot(m.get(j).getTeam2().getPlayers().get(i).getBlockShot());
				mp.setError(m.get(j).getTeam2().getPlayers().get(i).getError());
				mp.setFoul(m.get(j).getTeam2().getPlayers().get(i).getFoul());
				mp.setScore(m.get(j).getTeam2().getPlayers().get(i).getScore());
				t2.addPlayer(mp);
			}
			temp.setTeam1(t1);
			temp.setTeam2(t2);
			result.add(temp);
		}
		return result;
	}

	public ArrayList<MatchVO> findMatchByDate(String matchDate,String season) {
		ArrayList<MatchVO> result=new ArrayList<MatchVO>();
		MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=new ArrayList<MatchPO>();
		m=md.getTodayMatchInfo(matchDate, season);
		System.out.println("比赛场数："+m.size());
		for(int j=0;j<m.size();j++){
			
			MatchVO temp=new MatchVO();
			temp.setMatchTime(m.get(j).getMatchTime());
			temp.setTeams(m.get(j).getTeams());
			temp.setScore(m.get(j).getScore());
			temp.setScore1(m.get(j).getScore1());
			temp.setScore2(m.get(j).getScore2());
			temp.setScore3(m.get(j).getScore3());
			temp.setScore4(m.get(j).getScore4());
			temp.setExtraScores(m.get(j).getExtraScores());
			vo.MatchTeam t1=new vo.MatchTeam();
			vo.MatchTeam t2=new vo.MatchTeam();
			t1.setTeamName(m.get(j).getTeam1().getTeamName());
			t2.setTeamName(m.get(j).getTeam2().getTeamName());
			for(int i=0;i<m.get(j).getTeam1().getPlayers().size();i++){
				vo.MatchPlayer mp=new vo.MatchPlayer();
				mp.setPlayerName(m.get(j).getTeam1().getPlayers().get(i).getPlayerName());
				mp.setPosition(m.get(j).getTeam1().getPlayers().get(i).getPosition());
				mp.setMatchTime(m.get(j).getTeam1().getPlayers().get(i).getMatchTime());
				mp.setFieldGoal(m.get(j).getTeam1().getPlayers().get(i).getFieldGoal());
				mp.setFieldGoalAttempts(m.get(j).getTeam1().getPlayers().get(i).getFieldGoalAttempts());
				mp.setThreePointShot(m.get(j).getTeam1().getPlayers().get(i).getThreePointShot());
				mp.setThreePointAttempts(m.get(j).getTeam1().getPlayers().get(i).getThreePointAttempts());
				mp.setFreeThrowGoal(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowGoal());
				mp.setFreeThrowAttempts(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowAttempts());
				mp.setOffensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getOffensiveRebound());
				mp.setDefensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getDefensiveRebound());
				mp.setRebound(m.get(j).getTeam1().getPlayers().get(i).getRebound());
				mp.setAssist(m.get(j).getTeam1().getPlayers().get(i).getAssist());
				mp.setST(m.get(j).getTeam1().getPlayers().get(i).getST());
				mp.setBlockShot(m.get(j).getTeam1().getPlayers().get(i).getBlockShot());
				mp.setError(m.get(j).getTeam1().getPlayers().get(i).getError());
				mp.setFoul(m.get(j).getTeam1().getPlayers().get(i).getFoul());
				mp.setScore(m.get(j).getTeam1().getPlayers().get(i).getScore());
				t1.addPlayer(mp);
			}
			
			for(int i=0;i<m.get(j).getTeam2().getPlayers().size();i++){
				vo.MatchPlayer mp=new vo.MatchPlayer();
				mp.setPlayerName(m.get(j).getTeam2().getPlayers().get(i).getPlayerName());
				mp.setPosition(m.get(j).getTeam2().getPlayers().get(i).getPosition());
				mp.setMatchTime(m.get(j).getTeam2().getPlayers().get(i).getMatchTime());
				mp.setFieldGoal(m.get(j).getTeam2().getPlayers().get(i).getFieldGoal());
				mp.setFieldGoalAttempts(m.get(j).getTeam2().getPlayers().get(i).getFieldGoalAttempts());
				mp.setThreePointShot(m.get(j).getTeam2().getPlayers().get(i).getThreePointShot());
				mp.setThreePointAttempts(m.get(j).getTeam2().getPlayers().get(i).getThreePointAttempts());
				mp.setFreeThrowGoal(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowGoal());
				mp.setFreeThrowAttempts(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowAttempts());
				mp.setOffensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getOffensiveRebound());
				mp.setDefensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getDefensiveRebound());
				mp.setRebound(m.get(j).getTeam2().getPlayers().get(i).getRebound());
				mp.setAssist(m.get(j).getTeam2().getPlayers().get(i).getAssist());
				mp.setST(m.get(j).getTeam2().getPlayers().get(i).getST());
				mp.setBlockShot(m.get(j).getTeam2().getPlayers().get(i).getBlockShot());
				mp.setError(m.get(j).getTeam2().getPlayers().get(i).getError());
				mp.setFoul(m.get(j).getTeam2().getPlayers().get(i).getFoul());
				mp.setScore(m.get(j).getTeam2().getPlayers().get(i).getScore());
				t2.addPlayer(mp);
			}
			temp.setTeam1(t1);
			temp.setTeam2(t2);
			result.add(temp);
			
		}
		
		if(result.size()==0)
			return null;
		return result;
	}

	public TeamVO getSingleTeamInfo(String teamName,String season) {
		TeamDataService td=new TeamData();
		TeamVO result=new TeamVO();
		TeamPO tp=new TeamPO();
		if(teamName.equals("NBA")){
			ArrayList<TeamVO> ttt=getAllTeamInfo(season);
			double point=0.0;
			double assists=0.0;
			double steals=0.0;
			double blocks=0.0;
			double rebounds=0.0;
			double threePointFieldGoalPercentage=0.0;
			double freeThrowPercentage=0.0;
			double fieldGoalPercentage=0.0;
			
			for(int i=0;i<ttt.size();i++){
				point+=ttt.get(i).getPoints();
				assists+=ttt.get(i).getAssists();
				blocks+=ttt.get(i).getBlocks();
				steals+=ttt.get(i).getSteals();
				rebounds+=ttt.get(i).getRebounds();
				threePointFieldGoalPercentage+=ttt.get(i).getThreePointFieldGoalPercentage();
				freeThrowPercentage+=ttt.get(i).getFreeThrowPercentage();
				fieldGoalPercentage+=ttt.get(i).getFieldGoalPercentage();
			}
			point/=ttt.size();
			assists/=ttt.size();
			blocks/=ttt.size();
			steals/=ttt.size();
			rebounds/=ttt.size();
			threePointFieldGoalPercentage/=ttt.size();
			freeThrowPercentage/=ttt.size();
			fieldGoalPercentage/=ttt.size();
			
			result.setTeamName(teamName);
			result.setRebounds(rebounds);
			result.setAssists(assists);
			result.setSteals(steals);
			result.setBlocks(blocks);
			result.setPoints(point);
			result.setFieldGoalPercentage(fieldGoalPercentage);
			result.setThreePointFieldGoalPercentage(threePointFieldGoalPercentage);
			result.setFreeThrowPercentage(freeThrowPercentage);
			return result;
		}		
		
		tp=td.getSingleTeamInfo(teamName,season);
		result.setTeamName(teamName);
		result.setGamesPlayed(tp.getGamesPlayed());
		result.setFieldGoalsMade(tp.getFieldGoalsMade());
		result.setFieldGoalsAttempted(tp.getFieldGoalsAttempted());
		result.setThreePointFieldGoalsMade(tp.getThreePointFieldGoalsMade());
		result.setThreePointFieldGoalsAttempted(tp.getThreePointFieldGoalsAttempted());
		result.setFreeThrowsMade(tp.getFreeThrowsMade());
		result.setFreeThrowsAttempted(tp.getFreeThrowsAttempted());	
		result.setOffensiveRebounds(tp.getOffensiveRebounds());
		result.setDefensiveRebounds(tp.getDefensiveRebounds());
		result.setRebounds(tp.getRebounds());
		result.setAssists(tp.getAssists());
		result.setSteals(tp.getSteals());
		result.setBlocks(tp.getBlocks());
		result.setTurnovers(tp.getTurnovers());
		result.setFouls(tp.getFouls());
		result.setPoints(tp.getPoints());
		result.setFieldGoalPercentage(tp.getFieldGoalPercentage());
		result.setThreePointFieldGoalPercentage(tp.getThreePointFieldGoalPercentage());
		result.setFreeThrowPercentage(tp.getFreeThrowPercentage());
		result.setWinPercentage(tp.getWinPercentage());
		result.setPossessions(tp.getPossessions());
		result.setOffensiveRating(tp.getOffensiveRating());
		result.setDefensiveRating(tp.getDefensiveRating());
		result.setOffensiveReboundPercentage(tp.getOffensiveReboundPercentage());
		result.setDefensiveReboundPercentage(tp.getDefensiveReboundPercentage());
		result.setStealPercentage(tp.getStealPercentage());
		result.setAssistPercentage(tp.getAssistPercentage());
		
		result.setFullName(tp.getFullName());
		result.setCity(tp.getCity());
		result.setZone(tp.getZone());
		result.setSubarea(tp.getSubarea());
		result.setHomeCourt(tp.getHomeCourt());
		result.setCreateTime(tp.getCreateTime());
		
		
		return result;
	}

	public ArrayList<TeamVO> getAllTeamInfo(String season) {
		TeamDataService td=new TeamData();
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		ArrayList<TeamPO> tp=new ArrayList<TeamPO>();
		tp=td.getAllTeamInfo(season);
		for(int i=0;i<tp.size();i++){
			TeamVO t=new TeamVO();
			t.setTeamName(tp.get(i).getTeamName());
			t.setGamesPlayed(tp.get(i).getGamesPlayed());
			t.setFieldGoalsMade(tp.get(i).getFieldGoalsMade());
			t.setFieldGoalsAttempted(tp.get(i).getFieldGoalsAttempted());
			t.setThreePointFieldGoalsMade(tp.get(i).getThreePointFieldGoalsMade());
			t.setThreePointFieldGoalsAttempted(tp.get(i).getThreePointFieldGoalsAttempted());
			t.setFreeThrowsMade(tp.get(i).getFreeThrowsMade());
			t.setFreeThrowsAttempted(tp.get(i).getFreeThrowsAttempted());
			t.setOffensiveRebounds(tp.get(i).getOffensiveRebounds());
			t.setDefensiveRebounds(tp.get(i).getDefensiveRebounds());
			t.setRebounds(tp.get(i).getRebounds());
			t.setAssists(tp.get(i).getAssists());
			t.setSteals(tp.get(i).getSteals());
			t.setBlocks(tp.get(i).getBlocks());
			t.setTurnovers(tp.get(i).getTurnovers());
			t.setFouls(tp.get(i).getFouls());
			t.setPoints(tp.get(i).getPoints());
			t.setFieldGoalPercentage(tp.get(i).getFieldGoalPercentage());
			t.setThreePointFieldGoalPercentage(tp.get(i).getThreePointFieldGoalPercentage());
			t.setFreeThrowPercentage(tp.get(i).getFreeThrowPercentage());
			t.setWinPercentage(tp.get(i).getWinPercentage());
			t.setPossessions(tp.get(i).getPossessions());
			t.setOffensiveRating(tp.get(i).getOffensiveRating());
			t.setDefensiveRating(tp.get(i).getDefensiveRating());
			t.setOffensiveReboundPercentage(tp.get(i).getOffensiveReboundPercentage());
			t.setDefensiveReboundPercentage(tp.get(i).getDefensiveReboundPercentage());
			t.setStealPercentage(tp.get(i).getStealPercentage());
			t.setAssistPercentage(tp.get(i).getAssistPercentage());		
			t.setFullName(tp.get(i).getFullName());
			t.setCity(tp.get(i).getCity());
			t.setZone(tp.get(i).getZone());
			t.setSubarea(tp.get(i).getSubarea());
			t.setHomeCourt(tp.get(i).getHomeCourt());
			t.setCreateTime(tp.get(i).getCreateTime());
			result.add(t);
		}	
		return result;
	}

	public ArrayList<MatchVO> findMatchByPlayer(String playerName) {
		ArrayList<MatchVO> result=new ArrayList<MatchVO>();
		MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=new ArrayList<MatchPO>();
		m=md.getPlayerRecentMatchInfo(5,playerName);
		for(int j=0;j<m.size();j++){
			MatchVO temp=new MatchVO();
			temp.setMatchTime(m.get(j).getMatchTime());
			temp.setTeams(m.get(j).getTeams());
			temp.setScore(m.get(j).getScore());
			temp.setScore1(m.get(j).getScore1());
			temp.setScore2(m.get(j).getScore2());
			temp.setScore3(m.get(j).getScore3());
			temp.setScore4(m.get(j).getScore4());
			temp.setExtraScores(m.get(j).getExtraScores());
			
			vo.MatchTeam t1=new vo.MatchTeam();
			vo.MatchTeam t2=new vo.MatchTeam();
			t1.setTeamName(m.get(j).getTeam1().getTeamName());
			t2.setTeamName(m.get(j).getTeam2().getTeamName());
			for(int i=0;i<m.get(j).getTeam1().getPlayers().size();i++){
				vo.MatchPlayer mp=new vo.MatchPlayer();
				mp.setPlayerName(m.get(j).getTeam1().getPlayers().get(i).getPlayerName());
				mp.setPosition(m.get(j).getTeam1().getPlayers().get(i).getPosition());
				mp.setMatchTime(m.get(j).getTeam1().getPlayers().get(i).getMatchTime());
				mp.setFieldGoal(m.get(j).getTeam1().getPlayers().get(i).getFieldGoal());
				mp.setFieldGoalAttempts(m.get(j).getTeam1().getPlayers().get(i).getFieldGoalAttempts());
				mp.setThreePointShot(m.get(j).getTeam1().getPlayers().get(i).getThreePointShot());
				mp.setThreePointAttempts(m.get(j).getTeam1().getPlayers().get(i).getThreePointAttempts());
				mp.setFreeThrowGoal(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowGoal());
				mp.setFreeThrowAttempts(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowAttempts());
				mp.setOffensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getOffensiveRebound());
				mp.setDefensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getDefensiveRebound());
				mp.setRebound(m.get(j).getTeam1().getPlayers().get(i).getRebound());
				mp.setAssist(m.get(j).getTeam1().getPlayers().get(i).getAssist());
				mp.setST(m.get(j).getTeam1().getPlayers().get(i).getST());
				mp.setBlockShot(m.get(j).getTeam1().getPlayers().get(i).getBlockShot());
				mp.setError(m.get(j).getTeam1().getPlayers().get(i).getError());
				mp.setFoul(m.get(j).getTeam1().getPlayers().get(i).getFoul());
				mp.setScore(m.get(j).getTeam1().getPlayers().get(i).getScore());
				t1.addPlayer(mp);
			}
			
			for(int i=0;i<m.get(j).getTeam2().getPlayers().size();i++){
				vo.MatchPlayer mp=new vo.MatchPlayer();
				mp.setPlayerName(m.get(j).getTeam2().getPlayers().get(i).getPlayerName());
				mp.setPosition(m.get(j).getTeam2().getPlayers().get(i).getPosition());
				mp.setMatchTime(m.get(j).getTeam2().getPlayers().get(i).getMatchTime());
				mp.setFieldGoal(m.get(j).getTeam2().getPlayers().get(i).getFieldGoal());
				mp.setFieldGoalAttempts(m.get(j).getTeam2().getPlayers().get(i).getFieldGoalAttempts());
				mp.setThreePointShot(m.get(j).getTeam2().getPlayers().get(i).getThreePointShot());
				mp.setThreePointAttempts(m.get(j).getTeam2().getPlayers().get(i).getThreePointAttempts());
				mp.setFreeThrowGoal(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowGoal());
				mp.setFreeThrowAttempts(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowAttempts());
				mp.setOffensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getOffensiveRebound());
				mp.setDefensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getDefensiveRebound());
				mp.setRebound(m.get(j).getTeam2().getPlayers().get(i).getRebound());
				mp.setAssist(m.get(j).getTeam2().getPlayers().get(i).getAssist());
				mp.setST(m.get(j).getTeam2().getPlayers().get(i).getST());
				mp.setBlockShot(m.get(j).getTeam2().getPlayers().get(i).getBlockShot());
				mp.setError(m.get(j).getTeam2().getPlayers().get(i).getError());
				mp.setFoul(m.get(j).getTeam2().getPlayers().get(i).getFoul());
				mp.setScore(m.get(j).getTeam2().getPlayers().get(i).getScore());
				t2.addPlayer(mp);
			}
			temp.setTeam1(t1);
			temp.setTeam2(t2);
			result.add(temp);
		}
		return result;
	}

	public MatchVO getSingleMatchInfo(String matchDate, String team,String season) {
		MatchVO result =new MatchVO();
		MatchDataService md=new MatchData();
		MatchPO m=new MatchPO();
		m=md.getSingleMatchInfo(team,matchDate,season);
		result.setMatchTime(m.getMatchTime());
		result.setTeams(m.getTeams());
		result.setScore(m.getScore());
		result.setScore1(m.getScore1());
		result.setScore2(m.getScore2());
		result.setScore3(m.getScore3());
		result.setScore4(m.getScore4());
		result.setExtraScores(m.getExtraScores());
		vo.MatchTeam t1=new vo.MatchTeam();
		vo.MatchTeam t2=new vo.MatchTeam();
		t1.setTeamName(m.getTeam1().getTeamName());
		t2.setTeamName(m.getTeam2().getTeamName());
		for(int i=0;i<m.getTeam1().getPlayers().size();i++){
			vo.MatchPlayer mp=new vo.MatchPlayer();
			mp.setPlayerName(m.getTeam1().getPlayers().get(i).getPlayerName());
			mp.setPosition(m.getTeam1().getPlayers().get(i).getPosition());
			mp.setMatchTime(m.getTeam1().getPlayers().get(i).getMatchTime());
			mp.setFieldGoal(m.getTeam1().getPlayers().get(i).getFieldGoal());
			mp.setFieldGoalAttempts(m.getTeam1().getPlayers().get(i).getFieldGoalAttempts());
			mp.setThreePointShot(m.getTeam1().getPlayers().get(i).getThreePointShot());
			mp.setThreePointAttempts(m.getTeam1().getPlayers().get(i).getThreePointAttempts());
			mp.setFreeThrowGoal(m.getTeam1().getPlayers().get(i).getFreeThrowGoal());
			mp.setFreeThrowAttempts(m.getTeam1().getPlayers().get(i).getFreeThrowAttempts());
			mp.setOffensiveRebound(m.getTeam1().getPlayers().get(i).getOffensiveRebound());
			mp.setDefensiveRebound(m.getTeam1().getPlayers().get(i).getDefensiveRebound());
			mp.setRebound(m.getTeam1().getPlayers().get(i).getRebound());
			mp.setAssist(m.getTeam1().getPlayers().get(i).getAssist());
			mp.setST(m.getTeam1().getPlayers().get(i).getST());
			mp.setBlockShot(m.getTeam1().getPlayers().get(i).getBlockShot());
			mp.setError(m.getTeam1().getPlayers().get(i).getError());
			mp.setFoul(m.getTeam1().getPlayers().get(i).getFoul());
			mp.setScore(m.getTeam1().getPlayers().get(i).getScore());
			t1.addPlayer(mp);
		}
		for(int i=0;i<m.getTeam2().getPlayers().size();i++){
			vo.MatchPlayer mp=new vo.MatchPlayer();
			mp.setPlayerName(m.getTeam2().getPlayers().get(i).getPlayerName());
			mp.setPosition(m.getTeam2().getPlayers().get(i).getPosition());
			mp.setMatchTime(m.getTeam2().getPlayers().get(i).getMatchTime());
			mp.setFieldGoal(m.getTeam2().getPlayers().get(i).getFieldGoal());
			mp.setFieldGoalAttempts(m.getTeam2().getPlayers().get(i).getFieldGoalAttempts());
			mp.setThreePointShot(m.getTeam2().getPlayers().get(i).getThreePointShot());
			mp.setThreePointAttempts(m.getTeam2().getPlayers().get(i).getThreePointAttempts());
			mp.setFreeThrowGoal(m.getTeam2().getPlayers().get(i).getFreeThrowGoal());
			mp.setFreeThrowAttempts(m.getTeam2().getPlayers().get(i).getFreeThrowAttempts());
			mp.setOffensiveRebound(m.getTeam2().getPlayers().get(i).getOffensiveRebound());
			mp.setDefensiveRebound(m.getTeam2().getPlayers().get(i).getDefensiveRebound());
			mp.setRebound(m.getTeam2().getPlayers().get(i).getRebound());
			mp.setAssist(m.getTeam2().getPlayers().get(i).getAssist());
			mp.setST(m.getTeam2().getPlayers().get(i).getST());
			mp.setBlockShot(m.getTeam2().getPlayers().get(i).getBlockShot());
			mp.setError(m.getTeam2().getPlayers().get(i).getError());
			mp.setFoul(m.getTeam2().getPlayers().get(i).getFoul());
			mp.setScore(m.getTeam2().getPlayers().get(i).getScore());
			t2.addPlayer(mp);
		}
		result.setTeam1(t1);
		result.setTeam2(t2);
		return result;
	}

	public ArrayList<PlayerVO> getAllPlayerInfo(String season) {
		PlayerDataService pd=new PlayerData();
		ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> pp=pd.getAllPlayerInfo(season);
		for(int i=0;i<pp.size();i++){
			PlayerVO temp=new PlayerVO();
			String t=pp.get(i).getTeamName();
			if(t.equals("CHI")||t.equals("CLE")||t.equals("DET")||t.equals("IND")||t.equals("MIL")||
					t.equals("BKN")||t.equals("BOS")||t.equals("NYK")||t.equals("PHI")||t.equals("TOR")||
					t.equals("ALT")||t.equals("CHA")||t.equals("MIA")||t.equals("ORL")||t.equals("WAS")){
				temp.setLeague("East");
			}else if(t.equals("DAL")||t.equals("HOU")||t.equals("MEM")||t.equals("NOP")||t.equals("SAS")
					||t.equals("GSW")||t.equals("LAC")||t.equals("LAL")||t.equals("PHX")||t.equals("SAC")
					||t.equals("DEN")||t.equals("MIN")||t.equals("OKC")||t.equals("POR")||t.equals("UTA")){
				temp.setLeague("West");
			}else{
				temp.setLeague("未知");
			}
			temp.setMinutes(pp.get(i).getMinutes());
			temp.setPlayerName(pp.get(i).getPlayerName());
			temp.setNumber(pp.get(i).getNumber());
			temp.setPosition(pp.get(i).getPosition());
			temp.setHeight(pp.get(i).getHeight());
			temp.setWeight(pp.get(i).getWeight());
			temp.setBirth(pp.get(i).getBirth());
			temp.setAge(pp.get(i).getAge());
			temp.setExp(pp.get(i).getExp());
			temp.setSchool(pp.get(i).getSchool());
			temp.setTeamName(pp.get(i).getTeamName());
			temp.setGamesPlayed(pp.get(i).getGamesPlayed());
			temp.setGamesStarting(pp.get(i).getGamesStarting());
			temp.setRebounds(pp.get(i).getRebounds());
			temp.setAssists(pp.get(i).getAssists());
			temp.setMinutes(pp.get(i).getMinutes());
			temp.setFieldGoalsPercentage(pp.get(i).getFieldGoalsPercentage());
			temp.setThreePointFieldGoalsPercentage(pp.get(i).getThreePointFieldGoalsPercentage());
			temp.setFreeThrowsPercentage(pp.get(i).getFreeThrowsPercentage());
			temp.setOffensiveRebounds(pp.get(i).getOffensiveRebounds());
			temp.setDefensiveRebounds(pp.get(i).getDefensiveRebounds());
			temp.setSteals(pp.get(i).getSteals());
			temp.setBlocks(pp.get(i).getBlocks());
			temp.setTurnovers(pp.get(i).getTurnovers());
			temp.setFouls(pp.get(i).getFouls());
			temp.setPoints(pp.get(i).getPoints());
			temp.setEfficiency(pp.get(i).getEfficiency());
			temp.setGmSc(pp.get(i).getGmSc());
			temp.setTrueShootingPercentage(pp.get(i).getTrueShootingPercentage());
			temp.setShootingEfficiency(pp.get(i).getShootingEfficiency());
			temp.setReboundRating(pp.get(i).getReboundRating());
			temp.setOffensiveReboundRating(pp.get(i).getOffensiveReboundRating());
			temp.setDefensiveReboundRating(pp.get(i).getDefensiveReboundRating());
			temp.setAssisyRating(pp.get(i).getAssisyRating());
			temp.setStealRating(pp.get(i).getStealRating());
			temp.setBlockRating(pp.get(i).getBlockRating());
			temp.setTurnoverRating(pp.get(i).getTurnoverRating());
			temp.setUtilizationRating(pp.get(i).getUtilizationRating());
			temp.setDoubleDouble(pp.get(i).getDoubleDouble());
			temp.setIncreaseOfPoints(pp.get(i).getIncreaseOfPoints());
			temp.setIncreaseOfRebounds(pp.get(i).getIncreaseOfRebounds());
			temp.setIncreaseOfAssists(pp.get(i).getIncreaseOfAssists());
			result.add(temp);
		}
		return result;
	}

	public PlayerVO getSinglePlayerInfo(String playerName,String season){
		PlayerDataService pd=new PlayerData();
		PlayerVO result=new PlayerVO();
		PlayerPO pp=pd.getSinglePlayerInfo(playerName,season);
		String t=pp.getTeamName();
		if(t.equals("CHI")||t.equals("CLE")||t.equals("DET")||t.equals("IND")||t.equals("MIL")||
				t.equals("BKN")||t.equals("BOS")||t.equals("NYK")||t.equals("PHI")||t.equals("TOR")||
				t.equals("ALT")||t.equals("CHA")||t.equals("MIA")||t.equals("ORL")||t.equals("WAS")){
			result.setLeague("East");
		}else if(t.equals("DAL")||t.equals("HOU")||t.equals("MEM")||t.equals("NOP")||t.equals("SAS")
				||t.equals("GSW")||t.equals("LAC")||t.equals("LAL")||t.equals("PHX")||t.equals("SAC")
				||t.equals("DEN")||t.equals("MIN")||t.equals("OKC")||t.equals("POR")||t.equals("UTA")){
			result.setLeague("West");
		}else{
			result.setLeague("未知");
		}
		result.setMinutes(pp.getMinutes());
		result.setPlayerName(playerName);
		result.setNumber(pp.getNumber());
		result.setPosition(pp.getPosition());
		result.setHeight(pp.getHeight());
		result.setWeight(pp.getWeight());
		result.setBirth(pp.getBirth());
		result.setAge(pp.getAge());
		result.setExp(pp.getExp());
		result.setSchool(pp.getSchool());
		result.setTeamName(pp.getTeamName());
		result.setGamesPlayed(pp.getGamesPlayed());
		result.setGamesStarting(pp.getGamesStarting());
		result.setRebounds(pp.getRebounds());
		result.setAssists(pp.getAssists());
		result.setMinutes(pp.getMinutes());
		result.setFieldGoalsPercentage(pp.getFieldGoalsPercentage());
		result.setThreePointFieldGoalsPercentage(pp.getThreePointFieldGoalsPercentage());
		result.setFreeThrowsPercentage(pp.getFreeThrowsPercentage());
		result.setOffensiveRebounds(pp.getOffensiveRebounds());
		result.setDefensiveRebounds(pp.getDefensiveRebounds());
		result.setSteals(pp.getSteals());
		result.setBlocks(pp.getBlocks());
		result.setTurnovers(pp.getTurnovers());
		result.setFouls(pp.getFouls());
		result.setPoints(pp.getPoints());
		result.setEfficiency(pp.getEfficiency());
		result.setGmSc(pp.getGmSc());
		result.setTrueShootingPercentage(pp.getTrueShootingPercentage());
		result.setShootingEfficiency(pp.getShootingEfficiency());
		result.setReboundRating(pp.getReboundRating());
		result.setOffensiveReboundRating(pp.getOffensiveReboundRating());
		result.setDefensiveReboundRating(pp.getDefensiveReboundRating());
		result.setAssisyRating(pp.getAssisyRating());
		result.setStealRating(pp.getStealRating());
		result.setBlockRating(pp.getBlockRating());
		result.setTurnoverRating(pp.getTurnoverRating());
		result.setUtilizationRating(pp.getUtilizationRating());
		result.setDoubleDouble(pp.getDoubleDouble());
		result.setIncreaseOfPoints(pp.getIncreaseOfPoints());
		result.setIncreaseOfRebounds(pp.getIncreaseOfRebounds());
		result.setIncreaseOfAssists(pp.getIncreaseOfAssists());
		return result;
	}

	

}
