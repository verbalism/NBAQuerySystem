package businesslogic;


import java.util.ArrayList;

import data.BasicMatchData;
import data.PlayerData;
import dataService.MatchDataService;
import dataService.PlayerDataService;
import dataService.TeamDataService;
import po.MatchPO;
import po.PlayerPO;
import po.TeamPO;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;
import businesslogicService.DataBLService;

public class DataBL implements DataBLService {
	public PlayerVO getSinglePlayerInfo(String playerName){
		PlayerDataService pd=new PlayerData();
		PlayerVO result=new PlayerVO();
		PlayerPO pp=pd.getSinglePlayerInfo(playerName);
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
		result.setAllTimeOfTeam(pp.getAllTimeOfTeam());
		result.setAllReboundsOfTeam(pp.getAllReboundsOfTeam());
		result.setAllOffensiveReboundsOfTeam(pp.getAllOffensiveReboundsOfTeam());
		result.setAlldefensiveReboundsOfTeam(pp.getAlldefensiveReboundsOfTeam());
		result.setAllReboundsOfOpposite(pp.getAllReboundsOfOpposite());
		result.setAllOffensiveReboundsOfOpposite(pp.getAllOffensiveReboundsOfOpposite());
		result.setAlldefensiveReboundsOfOpposite(pp.getAlldefensiveReboundsOfOpposite());
		result.setAllFieldGoalsMade(pp.getAllFieldGoalsMade());
		result.setAllDefenseOfOpposite(pp.getAllDefenseOfOpposite());
		result.setTwoPointFieldGoalsAttemptsOfOpposite(pp.getTwoPointFieldGoalsAttemptsOfOpposite());
		result.setTwoPointFieldGoalsAttempts(pp.getTwoPointFieldGoalsAttempts());
		result.setAllFieldGoalsAttemptsOfTeam(pp.getAllFieldGoalsAttemptsOfTeam());
		result.setAllFreeGoalsAttemptsOfTeam(pp.getAllFreeGoalsAttemptsOfTeam());
		result.setAllturnoversOfTeam(pp.getAllturnoversOfTeam());
		result.setAllFieldGoalsAttemptsOfOpposite(pp.getAllFieldGoalsAttemptsOfOpposite());
		result.setAllFreeGoalsAttemptsOfOpposite(pp.getAllFreeGoalsAttemptsOfOpposite());
		result.setAllMissedGoalsOfOpposite(pp.getAllMissedGoalsOfOpposite());
		result.setAllturnoversOfOpposite(pp.getAllturnoversOfOpposite());
		result.setIncreaseOfPoints(pp.getIncreaseOfPoints());
		result.setIncreaseOfRebounds(pp.getIncreaseOfRebounds());
		result.setIncreaseOfAssists(pp.getIncreaseOfAssists());
		return result;
	}

	public ArrayList<PlayerVO> getAllPlayerInfo() {
		PlayerDataService pd=new PlayerData();
		ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> pp=pd.getAllPlayerInfo();
		for(int i=0;i<pp.size();i++){
			PlayerVO temp=new PlayerVO();
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
			temp.setAllTimeOfTeam(pp.get(i).getAllTimeOfTeam());
			temp.setAllReboundsOfTeam(pp.get(i).getAllReboundsOfTeam());
			temp.setAllOffensiveReboundsOfTeam(pp.get(i).getAllOffensiveReboundsOfTeam());
			temp.setAlldefensiveReboundsOfTeam(pp.get(i).getAlldefensiveReboundsOfTeam());
			temp.setAllReboundsOfOpposite(pp.get(i).getAllReboundsOfOpposite());
			temp.setAllOffensiveReboundsOfOpposite(pp.get(i).getAllOffensiveReboundsOfOpposite());
			temp.setAlldefensiveReboundsOfOpposite(pp.get(i).getAlldefensiveReboundsOfOpposite());
			temp.setAllFieldGoalsMade(pp.get(i).getAllFieldGoalsMade());
			temp.setAllDefenseOfOpposite(pp.get(i).getAllDefenseOfOpposite());
			temp.setTwoPointFieldGoalsAttemptsOfOpposite(pp.get(i).getTwoPointFieldGoalsAttemptsOfOpposite());
			temp.setTwoPointFieldGoalsAttempts(pp.get(i).getTwoPointFieldGoalsAttempts());
			temp.setAllFieldGoalsAttemptsOfTeam(pp.get(i).getAllFieldGoalsAttemptsOfTeam());
			temp.setAllFreeGoalsAttemptsOfTeam(pp.get(i).getAllFreeGoalsAttemptsOfTeam());
			temp.setAllturnoversOfTeam(pp.get(i).getAllturnoversOfTeam());
			temp.setAllFieldGoalsAttemptsOfOpposite(pp.get(i).getAllFieldGoalsAttemptsOfOpposite());
			temp.setAllFreeGoalsAttemptsOfOpposite(pp.get(i).getAllFreeGoalsAttemptsOfOpposite());
			temp.setAllMissedGoalsOfOpposite(pp.get(i).getAllMissedGoalsOfOpposite());
			temp.setAllturnoversOfOpposite(pp.get(i).getAllturnoversOfOpposite());
			temp.setIncreaseOfPoints(pp.get(i).getIncreaseOfPoints());
			temp.setIncreaseOfRebounds(pp.get(i).getIncreaseOfRebounds());
			temp.setIncreaseOfAssists(pp.get(i).getIncreaseOfAssists());
			result.add(temp);
		}
		return result;
	}


	public MatchVO getSingleMatchInfo(String matchDate, String team) {
		MatchVO result =new MatchVO();
		//MatchDataService md=new MatchData();
		MatchPO m=new MatchPO();
		//m=md.getSingleMatchInfo(team,matchDate);
		result.setMatchTime(m.getMatchTime());
		result.setTeams(m.getTeams());
		result.setScore(m.getScore());
		result.setScore1(m.getScore1());
		result.setScore2(m.getScore2());
		result.setScore3(m.getScore3());
		result.setScore4(m.getScore4());
		result.setExtraScores(m.getExtraScores());
		result.getTeam1().setTeamName(m.getTeam1().getTeamName());
		for(int i=0;i<m.getTeam1().getPlayers().size();i++){
			result.getTeam1().getPlayers().get(i).setPlayerName(m.getTeam1().getPlayers().get(i).getPlayerName());
			result.getTeam1().getPlayers().get(i).setPosition(m.getTeam1().getPlayers().get(i).getPosition());
			result.getTeam1().getPlayers().get(i).setMatchTime(m.getTeam1().getPlayers().get(i).getMatchTime());
			result.getTeam1().getPlayers().get(i).setFieldGoal(m.getTeam1().getPlayers().get(i).getFieldGoal());
			result.getTeam1().getPlayers().get(i).setFieldGoalAttempts(m.getTeam1().getPlayers().get(i).getFieldGoalAttempts());
			result.getTeam1().getPlayers().get(i).setThreePointShot(m.getTeam1().getPlayers().get(i).getThreePointShot());
			result.getTeam1().getPlayers().get(i).setThreePointAttempts(m.getTeam1().getPlayers().get(i).getThreePointAttempts());
			result.getTeam1().getPlayers().get(i).setFreeThrowGoal(m.getTeam1().getPlayers().get(i).getFreeThrowGoal());
			result.getTeam1().getPlayers().get(i).setFreeThrowAttempts(m.getTeam1().getPlayers().get(i).getFreeThrowAttempts());
			result.getTeam1().getPlayers().get(i).setOffensiveRebound(m.getTeam1().getPlayers().get(i).getOffensiveRebound());
			result.getTeam1().getPlayers().get(i).setDefensiveRebound(m.getTeam1().getPlayers().get(i).getDefensiveRebound());
			result.getTeam1().getPlayers().get(i).setRebound(m.getTeam1().getPlayers().get(i).getRebound());
			result.getTeam1().getPlayers().get(i).setAssist(m.getTeam1().getPlayers().get(i).getAssist());
			result.getTeam1().getPlayers().get(i).setST(m.getTeam1().getPlayers().get(i).getST());
			result.getTeam1().getPlayers().get(i).setBlockShot(m.getTeam1().getPlayers().get(i).getBlockShot());
			result.getTeam1().getPlayers().get(i).setError(m.getTeam1().getPlayers().get(i).getError());
			result.getTeam1().getPlayers().get(i).setFoul(m.getTeam1().getPlayers().get(i).getFoul());
			result.getTeam1().getPlayers().get(i).setScore(m.getTeam1().getPlayers().get(i).getScore());
		}
		result.getTeam2().setTeamName(m.getTeam2().getTeamName());
		for(int i=0;i<m.getTeam2().getPlayers().size();i++){
			result.getTeam2().getPlayers().get(i).setPlayerName(m.getTeam2().getPlayers().get(i).getPlayerName());
			result.getTeam2().getPlayers().get(i).setPosition(m.getTeam2().getPlayers().get(i).getPosition());
			result.getTeam2().getPlayers().get(i).setMatchTime(m.getTeam2().getPlayers().get(i).getMatchTime());
			result.getTeam2().getPlayers().get(i).setFieldGoal(m.getTeam2().getPlayers().get(i).getFieldGoal());
			result.getTeam2().getPlayers().get(i).setFieldGoalAttempts(m.getTeam2().getPlayers().get(i).getFieldGoalAttempts());
			result.getTeam2().getPlayers().get(i).setThreePointShot(m.getTeam2().getPlayers().get(i).getThreePointShot());
			result.getTeam2().getPlayers().get(i).setThreePointAttempts(m.getTeam2().getPlayers().get(i).getThreePointAttempts());
			result.getTeam2().getPlayers().get(i).setFreeThrowGoal(m.getTeam2().getPlayers().get(i).getFreeThrowGoal());
			result.getTeam2().getPlayers().get(i).setFreeThrowAttempts(m.getTeam2().getPlayers().get(i).getFreeThrowAttempts());
			result.getTeam2().getPlayers().get(i).setOffensiveRebound(m.getTeam2().getPlayers().get(i).getOffensiveRebound());
			result.getTeam2().getPlayers().get(i).setDefensiveRebound(m.getTeam2().getPlayers().get(i).getDefensiveRebound());
			result.getTeam2().getPlayers().get(i).setRebound(m.getTeam2().getPlayers().get(i).getRebound());
			result.getTeam2().getPlayers().get(i).setAssist(m.getTeam2().getPlayers().get(i).getAssist());
			result.getTeam2().getPlayers().get(i).setST(m.getTeam2().getPlayers().get(i).getST());
			result.getTeam2().getPlayers().get(i).setBlockShot(m.getTeam2().getPlayers().get(i).getBlockShot());
			result.getTeam2().getPlayers().get(i).setError(m.getTeam2().getPlayers().get(i).getError());
			result.getTeam2().getPlayers().get(i).setFoul(m.getTeam2().getPlayers().get(i).getFoul());
			result.getTeam2().getPlayers().get(i).setScore(m.getTeam2().getPlayers().get(i).getScore());
		}
		return result;
	}


	public ArrayList<MatchVO> findMatchByPlayer(String playerName) {
		ArrayList<MatchVO> result=new ArrayList<MatchVO>();
		//MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=new ArrayList<MatchPO>();
		//m=md.getPlayerRecentMatchInfo(5,playerName);
		for(int j=0;j<m.size();j++){
			result.get(j).setMatchTime(m.get(j).getMatchTime());
			result.get(j).setTeams(m.get(j).getTeams());
			result.get(j).setScore(m.get(j).getScore());
			result.get(j).setScore1(m.get(j).getScore1());
			result.get(j).setScore2(m.get(j).getScore2());
			result.get(j).setScore3(m.get(j).getScore3());
			result.get(j).setScore4(m.get(j).getScore4());
			result.get(j).setExtraScores(m.get(j).getExtraScores());
			result.get(j).getTeam1().setTeamName(m.get(j).getTeam1().getTeamName());
			for(int i=0;i<m.get(j).getTeam1().getPlayers().size();i++){
				result.get(j).getTeam1().getPlayers().get(i).setPlayerName(m.get(j).getTeam1().getPlayers().get(i).getPlayerName());
				result.get(j).getTeam1().getPlayers().get(i).setPosition(m.get(j).getTeam1().getPlayers().get(i).getPosition());
				result.get(j).getTeam1().getPlayers().get(i).setMatchTime(m.get(j).getTeam1().getPlayers().get(i).getMatchTime());
				result.get(j).getTeam1().getPlayers().get(i).setFieldGoal(m.get(j).getTeam1().getPlayers().get(i).getFieldGoal());
				result.get(j).getTeam1().getPlayers().get(i).setFieldGoalAttempts(m.get(j).getTeam1().getPlayers().get(i).getFieldGoalAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setThreePointShot(m.get(j).getTeam1().getPlayers().get(i).getThreePointShot());
				result.get(j).getTeam1().getPlayers().get(i).setThreePointAttempts(m.get(j).getTeam1().getPlayers().get(i).getThreePointAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setFreeThrowGoal(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowGoal());
				result.get(j).getTeam1().getPlayers().get(i).setFreeThrowAttempts(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setOffensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getOffensiveRebound());
				result.get(j).getTeam1().getPlayers().get(i).setDefensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getDefensiveRebound());
				result.get(j).getTeam1().getPlayers().get(i).setRebound(m.get(j).getTeam1().getPlayers().get(i).getRebound());
				result.get(j).getTeam1().getPlayers().get(i).setAssist(m.get(j).getTeam1().getPlayers().get(i).getAssist());
				result.get(j).getTeam1().getPlayers().get(i).setST(m.get(j).getTeam1().getPlayers().get(i).getST());
				result.get(j).getTeam1().getPlayers().get(i).setBlockShot(m.get(j).getTeam1().getPlayers().get(i).getBlockShot());
				result.get(j).getTeam1().getPlayers().get(i).setError(m.get(j).getTeam1().getPlayers().get(i).getError());
				result.get(j).getTeam1().getPlayers().get(i).setFoul(m.get(j).getTeam1().getPlayers().get(i).getFoul());
				result.get(j).getTeam1().getPlayers().get(i).setScore(m.get(j).getTeam1().getPlayers().get(i).getScore());
			}
			result.get(j).getTeam2().setTeamName(m.get(j).getTeam2().getTeamName());
			for(int i=0;i<m.get(j).getTeam2().getPlayers().size();i++){
				result.get(j).getTeam2().getPlayers().get(i).setPlayerName(m.get(j).getTeam2().getPlayers().get(i).getPlayerName());
				result.get(j).getTeam2().getPlayers().get(i).setPosition(m.get(j).getTeam2().getPlayers().get(i).getPosition());
				result.get(j).getTeam2().getPlayers().get(i).setMatchTime(m.get(j).getTeam2().getPlayers().get(i).getMatchTime());
				result.get(j).getTeam2().getPlayers().get(i).setFieldGoal(m.get(j).getTeam2().getPlayers().get(i).getFieldGoal());
				result.get(j).getTeam2().getPlayers().get(i).setFieldGoalAttempts(m.get(j).getTeam2().getPlayers().get(i).getFieldGoalAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setThreePointShot(m.get(j).getTeam2().getPlayers().get(i).getThreePointShot());
				result.get(j).getTeam2().getPlayers().get(i).setThreePointAttempts(m.get(j).getTeam2().getPlayers().get(i).getThreePointAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setFreeThrowGoal(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowGoal());
				result.get(j).getTeam2().getPlayers().get(i).setFreeThrowAttempts(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setOffensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getOffensiveRebound());
				result.get(j).getTeam2().getPlayers().get(i).setDefensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getDefensiveRebound());
				result.get(j).getTeam2().getPlayers().get(i).setRebound(m.get(j).getTeam2().getPlayers().get(i).getRebound());
				result.get(j).getTeam2().getPlayers().get(i).setAssist(m.get(j).getTeam2().getPlayers().get(i).getAssist());
				result.get(j).getTeam2().getPlayers().get(i).setST(m.get(j).getTeam2().getPlayers().get(i).getST());
				result.get(j).getTeam2().getPlayers().get(i).setBlockShot(m.get(j).getTeam2().getPlayers().get(i).getBlockShot());
				result.get(j).getTeam2().getPlayers().get(i).setError(m.get(j).getTeam2().getPlayers().get(i).getError());
				result.get(j).getTeam2().getPlayers().get(i).setFoul(m.get(j).getTeam2().getPlayers().get(i).getFoul());
				result.get(j).getTeam2().getPlayers().get(i).setScore(m.get(j).getTeam2().getPlayers().get(i).getScore());
			}
		}
		return result;
	}


	public ArrayList<MatchVO> findMatchByTeam(String teamName) {
		ArrayList<MatchVO> result=new ArrayList<MatchVO>();
		//MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=new ArrayList<MatchPO>();
		//m=md.getTeamRecentMatchInfo(5s,teamName);
		for(int j=0;j<m.size();j++){
			result.get(j).setMatchTime(m.get(j).getMatchTime());
			result.get(j).setTeams(m.get(j).getTeams());
			result.get(j).setScore(m.get(j).getScore());
			result.get(j).setScore1(m.get(j).getScore1());
			result.get(j).setScore2(m.get(j).getScore2());
			result.get(j).setScore3(m.get(j).getScore3());
			result.get(j).setScore4(m.get(j).getScore4());
			result.get(j).setExtraScores(m.get(j).getExtraScores());
			result.get(j).getTeam1().setTeamName(m.get(j).getTeam1().getTeamName());
			for(int i=0;i<m.get(j).getTeam1().getPlayers().size();i++){
				result.get(j).getTeam1().getPlayers().get(i).setPlayerName(m.get(j).getTeam1().getPlayers().get(i).getPlayerName());
				result.get(j).getTeam1().getPlayers().get(i).setPosition(m.get(j).getTeam1().getPlayers().get(i).getPosition());
				result.get(j).getTeam1().getPlayers().get(i).setMatchTime(m.get(j).getTeam1().getPlayers().get(i).getMatchTime());
				result.get(j).getTeam1().getPlayers().get(i).setFieldGoal(m.get(j).getTeam1().getPlayers().get(i).getFieldGoal());
				result.get(j).getTeam1().getPlayers().get(i).setFieldGoalAttempts(m.get(j).getTeam1().getPlayers().get(i).getFieldGoalAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setThreePointShot(m.get(j).getTeam1().getPlayers().get(i).getThreePointShot());
				result.get(j).getTeam1().getPlayers().get(i).setThreePointAttempts(m.get(j).getTeam1().getPlayers().get(i).getThreePointAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setFreeThrowGoal(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowGoal());
				result.get(j).getTeam1().getPlayers().get(i).setFreeThrowAttempts(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setOffensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getOffensiveRebound());
				result.get(j).getTeam1().getPlayers().get(i).setDefensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getDefensiveRebound());
				result.get(j).getTeam1().getPlayers().get(i).setRebound(m.get(j).getTeam1().getPlayers().get(i).getRebound());
				result.get(j).getTeam1().getPlayers().get(i).setAssist(m.get(j).getTeam1().getPlayers().get(i).getAssist());
				result.get(j).getTeam1().getPlayers().get(i).setST(m.get(j).getTeam1().getPlayers().get(i).getST());
				result.get(j).getTeam1().getPlayers().get(i).setBlockShot(m.get(j).getTeam1().getPlayers().get(i).getBlockShot());
				result.get(j).getTeam1().getPlayers().get(i).setError(m.get(j).getTeam1().getPlayers().get(i).getError());
				result.get(j).getTeam1().getPlayers().get(i).setFoul(m.get(j).getTeam1().getPlayers().get(i).getFoul());
				result.get(j).getTeam1().getPlayers().get(i).setScore(m.get(j).getTeam1().getPlayers().get(i).getScore());
			}
			result.get(j).getTeam2().setTeamName(m.get(j).getTeam2().getTeamName());
			for(int i=0;i<m.get(j).getTeam2().getPlayers().size();i++){
				result.get(j).getTeam2().getPlayers().get(i).setPlayerName(m.get(j).getTeam2().getPlayers().get(i).getPlayerName());
				result.get(j).getTeam2().getPlayers().get(i).setPosition(m.get(j).getTeam2().getPlayers().get(i).getPosition());
				result.get(j).getTeam2().getPlayers().get(i).setMatchTime(m.get(j).getTeam2().getPlayers().get(i).getMatchTime());
				result.get(j).getTeam2().getPlayers().get(i).setFieldGoal(m.get(j).getTeam2().getPlayers().get(i).getFieldGoal());
				result.get(j).getTeam2().getPlayers().get(i).setFieldGoalAttempts(m.get(j).getTeam2().getPlayers().get(i).getFieldGoalAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setThreePointShot(m.get(j).getTeam2().getPlayers().get(i).getThreePointShot());
				result.get(j).getTeam2().getPlayers().get(i).setThreePointAttempts(m.get(j).getTeam2().getPlayers().get(i).getThreePointAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setFreeThrowGoal(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowGoal());
				result.get(j).getTeam2().getPlayers().get(i).setFreeThrowAttempts(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setOffensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getOffensiveRebound());
				result.get(j).getTeam2().getPlayers().get(i).setDefensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getDefensiveRebound());
				result.get(j).getTeam2().getPlayers().get(i).setRebound(m.get(j).getTeam2().getPlayers().get(i).getRebound());
				result.get(j).getTeam2().getPlayers().get(i).setAssist(m.get(j).getTeam2().getPlayers().get(i).getAssist());
				result.get(j).getTeam2().getPlayers().get(i).setST(m.get(j).getTeam2().getPlayers().get(i).getST());
				result.get(j).getTeam2().getPlayers().get(i).setBlockShot(m.get(j).getTeam2().getPlayers().get(i).getBlockShot());
				result.get(j).getTeam2().getPlayers().get(i).setError(m.get(j).getTeam2().getPlayers().get(i).getError());
				result.get(j).getTeam2().getPlayers().get(i).setFoul(m.get(j).getTeam2().getPlayers().get(i).getFoul());
				result.get(j).getTeam2().getPlayers().get(i).setScore(m.get(j).getTeam2().getPlayers().get(i).getScore());
			}
		}
		return result;
	}


	public ArrayList<MatchVO> findMatchByDate(String matchDate) {
		ArrayList<MatchVO> result=new ArrayList<MatchVO>();
		//MatchDataService md=new MatchData();
		ArrayList<MatchPO> m=new ArrayList<MatchPO>();
		//m=md.getAllMatchInfo();
		for(int j=0;j<m.size();j++){
			result.get(j).setMatchTime(m.get(j).getMatchTime());
			result.get(j).setTeams(m.get(j).getTeams());
			result.get(j).setScore(m.get(j).getScore());
			result.get(j).setScore1(m.get(j).getScore1());
			result.get(j).setScore2(m.get(j).getScore2());
			result.get(j).setScore3(m.get(j).getScore3());
			result.get(j).setScore4(m.get(j).getScore4());
			result.get(j).setExtraScores(m.get(j).getExtraScores());
			result.get(j).getTeam1().setTeamName(m.get(j).getTeam1().getTeamName());
			for(int i=0;i<m.get(j).getTeam1().getPlayers().size();i++){
				result.get(j).getTeam1().getPlayers().get(i).setPlayerName(m.get(j).getTeam1().getPlayers().get(i).getPlayerName());
				result.get(j).getTeam1().getPlayers().get(i).setPosition(m.get(j).getTeam1().getPlayers().get(i).getPosition());
				result.get(j).getTeam1().getPlayers().get(i).setMatchTime(m.get(j).getTeam1().getPlayers().get(i).getMatchTime());
				result.get(j).getTeam1().getPlayers().get(i).setFieldGoal(m.get(j).getTeam1().getPlayers().get(i).getFieldGoal());
				result.get(j).getTeam1().getPlayers().get(i).setFieldGoalAttempts(m.get(j).getTeam1().getPlayers().get(i).getFieldGoalAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setThreePointShot(m.get(j).getTeam1().getPlayers().get(i).getThreePointShot());
				result.get(j).getTeam1().getPlayers().get(i).setThreePointAttempts(m.get(j).getTeam1().getPlayers().get(i).getThreePointAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setFreeThrowGoal(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowGoal());
				result.get(j).getTeam1().getPlayers().get(i).setFreeThrowAttempts(m.get(j).getTeam1().getPlayers().get(i).getFreeThrowAttempts());
				result.get(j).getTeam1().getPlayers().get(i).setOffensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getOffensiveRebound());
				result.get(j).getTeam1().getPlayers().get(i).setDefensiveRebound(m.get(j).getTeam1().getPlayers().get(i).getDefensiveRebound());
				result.get(j).getTeam1().getPlayers().get(i).setRebound(m.get(j).getTeam1().getPlayers().get(i).getRebound());
				result.get(j).getTeam1().getPlayers().get(i).setAssist(m.get(j).getTeam1().getPlayers().get(i).getAssist());
				result.get(j).getTeam1().getPlayers().get(i).setST(m.get(j).getTeam1().getPlayers().get(i).getST());
				result.get(j).getTeam1().getPlayers().get(i).setBlockShot(m.get(j).getTeam1().getPlayers().get(i).getBlockShot());
				result.get(j).getTeam1().getPlayers().get(i).setError(m.get(j).getTeam1().getPlayers().get(i).getError());
				result.get(j).getTeam1().getPlayers().get(i).setFoul(m.get(j).getTeam1().getPlayers().get(i).getFoul());
				result.get(j).getTeam1().getPlayers().get(i).setScore(m.get(j).getTeam1().getPlayers().get(i).getScore());
			}
			result.get(j).getTeam2().setTeamName(m.get(j).getTeam2().getTeamName());
			for(int i=0;i<m.get(j).getTeam2().getPlayers().size();i++){
				result.get(j).getTeam2().getPlayers().get(i).setPlayerName(m.get(j).getTeam2().getPlayers().get(i).getPlayerName());
				result.get(j).getTeam2().getPlayers().get(i).setPosition(m.get(j).getTeam2().getPlayers().get(i).getPosition());
				result.get(j).getTeam2().getPlayers().get(i).setMatchTime(m.get(j).getTeam2().getPlayers().get(i).getMatchTime());
				result.get(j).getTeam2().getPlayers().get(i).setFieldGoal(m.get(j).getTeam2().getPlayers().get(i).getFieldGoal());
				result.get(j).getTeam2().getPlayers().get(i).setFieldGoalAttempts(m.get(j).getTeam2().getPlayers().get(i).getFieldGoalAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setThreePointShot(m.get(j).getTeam2().getPlayers().get(i).getThreePointShot());
				result.get(j).getTeam2().getPlayers().get(i).setThreePointAttempts(m.get(j).getTeam2().getPlayers().get(i).getThreePointAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setFreeThrowGoal(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowGoal());
				result.get(j).getTeam2().getPlayers().get(i).setFreeThrowAttempts(m.get(j).getTeam2().getPlayers().get(i).getFreeThrowAttempts());
				result.get(j).getTeam2().getPlayers().get(i).setOffensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getOffensiveRebound());
				result.get(j).getTeam2().getPlayers().get(i).setDefensiveRebound(m.get(j).getTeam2().getPlayers().get(i).getDefensiveRebound());
				result.get(j).getTeam2().getPlayers().get(i).setRebound(m.get(j).getTeam2().getPlayers().get(i).getRebound());
				result.get(j).getTeam2().getPlayers().get(i).setAssist(m.get(j).getTeam2().getPlayers().get(i).getAssist());
				result.get(j).getTeam2().getPlayers().get(i).setST(m.get(j).getTeam2().getPlayers().get(i).getST());
				result.get(j).getTeam2().getPlayers().get(i).setBlockShot(m.get(j).getTeam2().getPlayers().get(i).getBlockShot());
				result.get(j).getTeam2().getPlayers().get(i).setError(m.get(j).getTeam2().getPlayers().get(i).getError());
				result.get(j).getTeam2().getPlayers().get(i).setFoul(m.get(j).getTeam2().getPlayers().get(i).getFoul());
				result.get(j).getTeam2().getPlayers().get(i).setScore(m.get(j).getTeam2().getPlayers().get(i).getScore());
			}
		}
		for(int i=result.size();i>0;i--){
			if(!result.get(i).getMatchTime().equals(matchDate)){
				result.remove(i);			
			}
		}
		return result;
	}

	
	public TeamVO getSingleTeamInfo(String teamName) {
		//TeamDataService td=new TeamData();
		TeamVO result=new TeamVO();
		TeamPO tp=new TeamPO();
		//tp=td.getSingleTeamInfo(teamName);
		result.setTeamName(teamName);
		result.setGamesPlayed(tp.getGamesPlayed());
		result.setFieldGoalsMade(tp.getFieldGoalsMade());
		result.setFieldGoalsAttempted(tp.getFieldGoalsAttempted());
		result.setThreePointFieldGoalsMade(tp.getThreePointFieldGoalsMade());
		result.setThreePointFieldGoalsAttempted(tp.getThreePointFieldGoalsAttempted());
		result.setFreeThrowsMade(tp.getFreeThrowsMade());
		result.setFieldGoalsAttempted(tp.getFreeThrowsAttempted());	
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
		
		result.setGamesPlayedWin(tp.getGamesPlayedWin());
		result.setOppFieldGoalsMade(tp.getOppFieldGoalsMade());
		result.setOppFieldGoalsAttempted(tp.getOppFieldGoalsAttempted());
		result.setOppFreeThrowsAttempted(tp.getOppFreeThrowsAttempted());
		result.setOppTurnovers(tp.getOppTurnovers());
		result.setOppSteals(tp.getOppSteals());
		result.setOppAssists(tp.getOppAssists());
		result.setOppOffensiveRebounds(tp.getOppOffensiveRebounds());
		result.setOppDefensiveRebounds(tp.getOppDefensiveRebounds());
		result.setOppPoints(tp.getOppPoints());
		result.setOppPossessions(tp.getOppPossessions());
		
		return result;
	}


	public ArrayList<TeamVO> getAllTeamInfo() {
		//TeamDataService td=new TeamData();
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		ArrayList<TeamPO> tp=new ArrayList<TeamPO>();
		//tp=td.getAllTeamInfo();
		for(int i=0;i<tp.size();i++){
			result.get(i).setTeamName(tp.get(i).getTeamName());
			result.get(i).setGamesPlayed(tp.get(i).getGamesPlayed());
			result.get(i).setFieldGoalsMade(tp.get(i).getFieldGoalsMade());
			result.get(i).setFieldGoalsAttempted(tp.get(i).getFieldGoalsAttempted());
			result.get(i).setThreePointFieldGoalsMade(tp.get(i).getThreePointFieldGoalsMade());
			result.get(i).setThreePointFieldGoalsAttempted(tp.get(i).getThreePointFieldGoalsAttempted());
			result.get(i).setFreeThrowsMade(tp.get(i).getFreeThrowsMade());
			result.get(i).setFieldGoalsAttempted(tp.get(i).getFreeThrowsAttempted());	
			result.get(i).setOffensiveRebounds(tp.get(i).getOffensiveRebounds());
			result.get(i).setDefensiveRebounds(tp.get(i).getDefensiveRebounds());
			result.get(i).setRebounds(tp.get(i).getRebounds());
			result.get(i).setAssists(tp.get(i).getAssists());
			result.get(i).setSteals(tp.get(i).getSteals());
			result.get(i).setBlocks(tp.get(i).getBlocks());
			result.get(i).setTurnovers(tp.get(i).getTurnovers());
			result.get(i).setFouls(tp.get(i).getFouls());
			result.get(i).setPoints(tp.get(i).getPoints());
			result.get(i).setFieldGoalPercentage(tp.get(i).getFieldGoalPercentage());
			result.get(i).setThreePointFieldGoalPercentage(tp.get(i).getThreePointFieldGoalPercentage());
			result.get(i).setFreeThrowPercentage(tp.get(i).getFreeThrowPercentage());
			result.get(i).setWinPercentage(tp.get(i).getWinPercentage());
			result.get(i).setPossessions(tp.get(i).getPossessions());
			result.get(i).setOffensiveRating(tp.get(i).getOffensiveRating());
			result.get(i).setDefensiveRating(tp.get(i).getDefensiveRating());
			result.get(i).setOffensiveReboundPercentage(tp.get(i).getOffensiveReboundPercentage());
			result.get(i).setDefensiveReboundPercentage(tp.get(i).getDefensiveReboundPercentage());
			result.get(i).setStealPercentage(tp.get(i).getStealPercentage());
			result.get(i).setAssistPercentage(tp.get(i).getAssistPercentage());
			
			result.get(i).setFullName(tp.get(i).getFullName());
			result.get(i).setCity(tp.get(i).getCity());
			result.get(i).setZone(tp.get(i).getZone());
			result.get(i).setSubarea(tp.get(i).getSubarea());
			result.get(i).setHomeCourt(tp.get(i).getHomeCourt());
			result.get(i).setCreateTime(tp.get(i).getCreateTime());
			
			result.get(i).setGamesPlayedWin(tp.get(i).getGamesPlayedWin());
			result.get(i).setOppFieldGoalsMade(tp.get(i).getOppFieldGoalsMade());
			result.get(i).setOppFieldGoalsAttempted(tp.get(i).getOppFieldGoalsAttempted());
			result.get(i).setOppFreeThrowsAttempted(tp.get(i).getOppFreeThrowsAttempted());
			result.get(i).setOppTurnovers(tp.get(i).getOppTurnovers());
			result.get(i).setOppSteals(tp.get(i).getOppSteals());
			result.get(i).setOppAssists(tp.get(i).getOppAssists());
			result.get(i).setOppOffensiveRebounds(tp.get(i).getOppOffensiveRebounds());
			result.get(i).setOppDefensiveRebounds(tp.get(i).getOppDefensiveRebounds());
			result.get(i).setOppPoints(tp.get(i).getOppPoints());
			result.get(i).setOppPossessions(tp.get(i).getOppPossessions());
		}	
		return result;
	}



}
