package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import po.BasicPlayerPO;
import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;
import po.PlayerPO;
import po.TodayPlayerPO;
import dataService.PlayerDataService;

public class PlayerData implements PlayerDataService{
	public PlayerPO getSinglePlayerInfo(String playerName){
		PlayerPO result=new PlayerPO();
		
		BasicPlayerData pd=new BasicPlayerData();
		
		BasicPlayerPO pp=pd.getSinglePlayerOriginal(playerName);
		
		result.setPlayerName(playerName);
		result.setNumber(pp.getNumber());
		result.setPosition(pp.getPosition());
		result.setHeight(pp.getHeight());
		result.setWeight(pp.getWeight());
		result.setBirth(pp.getBirth());
		result.setAge(pp.getAge());
		result.setExp(pp.getExp());
		result.setSchool(pp.getSchool());
		//添加球员基本信息
		
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		MatchDataCalculate mdc=new MatchDataCalculate();
		ArrayList<String> sortMatch=mdc.getSortedFile();
		BasicMatchData bmd=new BasicMatchData();
		for(int i=0;i<sortMatch.size();i++){
			mp.add(bmd.getOneMatchOriginal(sortMatch.get(i)));
		}
		ArrayList<MatchPO> mpSelected=new ArrayList<MatchPO>();//该球员参加的比赛
		ArrayList<MatchPlayer> MP=new ArrayList<MatchPlayer>();//该球员参加的比赛的个人数据
		ArrayList<MatchTeam> MT=new ArrayList<MatchTeam>();//该球员参加的比赛的队伍
		ArrayList<MatchTeam> MT2=new ArrayList<MatchTeam>();//该球员参加的比赛的对手队伍
		
		for(int i=0;i<mp.size();i++){
			ArrayList<MatchPlayer> tp=mp.get(i).getTeam1().getPlayers();
			for(int j=0;j<tp.size();j++){
				if(tp.get(j).getPlayerName().equals(playerName)){
					mpSelected.add(mp.get(i));
					MP.add(tp.get(j));
					MT.add(mp.get(i).getTeam1());
					MT2.add(mp.get(i).getTeam2());
				}
			}
			ArrayList<MatchPlayer> tp2=mp.get(i).getTeam2().getPlayers();
			for(int j=0;j<tp2.size();j++){
				if(tp2.get(j).getPlayerName().equals(playerName)){
					mpSelected.add(mp.get(i));
					MP.add(tp2.get(j));
					MT.add(mp.get(i).getTeam2());
					MT2.add(mp.get(i).getTeam1());
				}
			}
			
		}
		//筛选球员参与的比赛
		
		PlayerDataCalculate pic=new PlayerDataCalculate();
		
		if(mpSelected.size()==0){
			result.setTeamName("Unknow");
		}else{
			result.setTeamName(pic.CalculateTeam(playerName,mpSelected.get(mpSelected.size()-1)));
			result.setGamesPlayed(mpSelected.size());
			result.setGamesStarting(pic.CalculateGamesStarting(playerName, mpSelected));
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
			result.setIncreaseOfAssists(pic.CalculateIncreaseOfAssists(MP));
			result.setIncreaseOfPoints(pic.CalculateIncreaseOfPoints(MP));
			result.setIncreaseOfRebounds(pic.CalculateIncreaseOfRebounds(MP));
		}
		
		return result;
	}
	
	public ArrayList<PlayerPO> getAllPlayerInfo(){
		ArrayList<PlayerPO> result=new ArrayList<PlayerPO>();
		
		File file = new File("Data//playerInfoVO.txt");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while((s = br.readLine())!=null){
				String[] temp=s.split(";");
				PlayerPO piv=new PlayerPO();
				piv.setPlayerName(temp[0]);
				piv.setTeamName(temp[1]);
				piv.setGamesPlayed(Integer.parseInt(temp[2]));
				piv.setGamesStarting(Integer.parseInt(temp[3]));
				piv.setRebounds(Double.valueOf(temp[4]));
				piv.setAssists(Double.valueOf(temp[5]));
				piv.setMinutes(temp[6]);
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
				piv.setIncreaseOfPoints(Double.valueOf(temp[38]));
				piv.setIncreaseOfAssists(Double.valueOf(temp[39]));
				piv.setIncreaseOfRebounds(Double.valueOf(temp[40]));
				result.add(piv);

			}
			br.close();    
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TodayPlayerPO> getTodayPlayerInfo(String date){
		ArrayList<TodayPlayerPO> result=new ArrayList<TodayPlayerPO>();
		BasicMatchData bmd=new BasicMatchData();
		ArrayList<MatchPO> mp=bmd.getMatchOriginal();
		for(int i=0;i<mp.size();i++){
			if(mp.get(i).getMatchTime().equals(date)){
				ArrayList<MatchPlayer> temp1=mp.get(i).getTeam1().getPlayers();
				ArrayList<MatchPlayer> temp2=mp.get(i).getTeam2().getPlayers();
				for(int j=0;j<temp1.size();j++){
					TodayPlayerPO t=new TodayPlayerPO();
					t.setTeamName(mp.get(j).getTeam1().getTeamName());
					t.setOppositeTeamName(mp.get(j).getTeam2().getTeamName());
					t.setPlayerName(temp1.get(j).getPlayerName());
					t.setPosition(temp1.get(j).getPosition());
					t.setMatchTime(temp1.get(j).getMatchTime());
					t.setFieldGoal(temp1.get(j).getFieldGoal());
					t.setFieldGoalAttempts(temp1.get(j).getFieldGoalAttempts());
					t.setThreepointShot(temp1.get(j).getThreePointShot());
					t.setThreepointAttempts(temp1.get(j).getThreePointAttempts());
					t.setFreeThrowGoal(temp1.get(j).getFreeThrowGoal());
					t.setFreeThrowAttempts(temp1.get(j).getFreeThrowAttempts());
					t.setOffensiveRebound(temp1.get(j).getOffensiveRebound());
					t.setDefensiveRebound(temp1.get(j).getDefensiveRebound());
					t.setRebound(temp1.get(j).getRebound());
					t.setAssist(temp1.get(j).getAssist());
					t.setSt(temp1.get(j).getST());
					t.setBlockShot(temp1.get(j).getBlockShot());
					t.setError(temp1.get(j).getError());
					t.setFoul(temp1.get(j).getFoul());
					t.setScore(temp1.get(j).getScore());
					result.add(t);
				}
				for(int j=0;j<temp2.size();j++){
					TodayPlayerPO t=new TodayPlayerPO();
					t.setTeamName(mp.get(j).getTeam2().getTeamName());
					t.setOppositeTeamName(mp.get(j).getTeam1().getTeamName());
					t.setPlayerName(temp2.get(j).getPlayerName());
					t.setPosition(temp2.get(j).getPosition());
					t.setMatchTime(temp2.get(j).getMatchTime());
					t.setFieldGoal(temp2.get(j).getFieldGoal());
					t.setFieldGoalAttempts(temp2.get(j).getFieldGoalAttempts());
					t.setThreepointShot(temp2.get(j).getThreePointShot());
					t.setThreepointAttempts(temp2.get(j).getThreePointAttempts());
					t.setFreeThrowGoal(temp2.get(j).getFreeThrowGoal());
					t.setFreeThrowAttempts(temp2.get(j).getFreeThrowAttempts());
					t.setOffensiveRebound(temp2.get(j).getOffensiveRebound());
					t.setDefensiveRebound(temp2.get(j).getDefensiveRebound());
					t.setRebound(temp2.get(j).getRebound());
					t.setAssist(temp2.get(j).getAssist());
					t.setSt(temp2.get(j).getST());
					t.setBlockShot(temp2.get(j).getBlockShot());
					t.setError(temp2.get(j).getError());
					t.setFoul(temp2.get(j).getFoul());
					t.setScore(temp2.get(j).getScore());
					result.add(t);
				}
			}
		}
		return result;
	}
	
	public void updatePlayerInfo(int matchID){
	}
	
	public void updateBasicPlayerInfo(){
		PlayerDataCalculate pic=new PlayerDataCalculate();
		pic.savePlayerInfoVO();
	}
	
	/*public static void main(String []args){
		PlayerData pd=new PlayerData();
		
		PlayerPO pp=pd.getSinglePlayerInfo("LeBron James");
		System.out.println(pp.getMinutes());
		
		ArrayList<TodayPlayerPO> tpp=pd.getTodayPlayerInfo("01-02");
		for(int i=0;i<tpp.size();i++)
			System.out.println(tpp.get(i).getPlayerName());
	}*/
}
