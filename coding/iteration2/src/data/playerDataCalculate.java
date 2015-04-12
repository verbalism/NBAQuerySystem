package data;
import java.util.ArrayList;

import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;

public class PlayerDataCalculate {
	public String CalculateTeam(String playerName,MatchPO match){
		PlayerDataCalculate pic=new PlayerDataCalculate();
		ArrayList<MatchPlayer> tp=match.getTeam1().getPlayers();
		for(int j=0;j<tp.size();j++){
			if(tp.get(j).getPlayerName().equals(playerName)){
				return pic.getFullName(match.getTeam1().getTeamName());
			}
		}
		return pic.getFullName(match.getTeam2().getTeamName());
	}//计算所属球队
	
	public int CalculateGamesStarting(String playerName,ArrayList<MatchPO> mpSelected){
		int result=0;
		for(int i=0;i<mpSelected.size();i++){
			MatchTeam team1=mpSelected.get(i).getTeam1();
			MatchTeam team2=mpSelected.get(i).getTeam2();
			for(int j=0;j<5;j++){
				if(team1.getPlayers().get(j).getPlayerName().equals(playerName)){
					result++;
				}
			}
			for(int j=0;j<5;j++){
				if(team2.getPlayers().get(j).getPlayerName().equals(playerName)){
					result++;
				}
			}
		}
		return result;
	}//计算先发场数
	
	public double CalculateRebounds(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getRebound();
		}
		return result;
	}//计算篮板数
	
	public double CalculateAssists(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getAssist();
		}
		return result;
	}//计算助攻数
	
	public double CalculateMinutes(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			String[] t=MP.get(i).getMatchTime().split(":");
			double min=Double.valueOf(t[0]);
			double second=Double.valueOf(t[1]);
			double time=min+second/60;
			result=result+(int)time;
		}
		return result;
	}//计算在场时间
	
	public double CalculateFieldGoalsMade(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFieldGoal();
		}
		return result;
	}//计算投篮命中数
	
	public double CalculateThreePointFieldGoalsMade(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getThreePointShot();
		}
		return result;
	}//计算三分命中数

	public double CalculateFreeThrowsMade(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFreeThrowGoal();
		}
		return result;
	}//计算罚球命中数
	
	public double CalculateFieldGoalsPercentage(ArrayList<MatchPlayer> MP){
		double result1=0;
		double result2=0;
		for(int i=0;i<MP.size();i++){
			result1=result1+MP.get(i).getFieldGoal();
			result2=result2+MP.get(i).getFieldGoalAttempts();
		}
		if(result2==0)
			return 0;
		else 
			return result1/result2;
	}//计算投篮命中率
	
	public double CalculateThreePointFieldGoalsPercentage(ArrayList<MatchPlayer> MP){
		double result1=0;
		double result2=0;
		for(int i=0;i<MP.size();i++){
			result1=result1+MP.get(i).getThreePointShot();
			result2=result2+MP.get(i).getThreePointAttempts();
		}
		if(result2==0)
			return 0;
		else 
			return result1/result2;
	}//计算三分命中率
	
	public double CalculateFreeThrowsPercentage(ArrayList<MatchPlayer> MP){
		double result1=0;
		double result2=0;
		for(int i=0;i<MP.size();i++){
			result1=result1+MP.get(i).getFreeThrowGoal();
			result2=result2+MP.get(i).getFreeThrowAttempts();
		}
		
		if(result2==0)
			return 0;
		else 
			return result1/result2;
	}//计算罚球命中率
	
	public double CalculateOffensiveRebounds(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getOffensiveRebound();
		}
		return result;
	}//计算进攻篮板数
	
	public double CalculateDefensiveRebounds(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getDefensiveRebound();
		}
		return result;
	}//计算防守篮板数
	
	public double CalculateSteals(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getST();
		}
		return result;
	}//计算抢断数
	
	public double CalculateBlocks(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getBlockShot();
		}
		return result;
	}//计算盖帽数
	
	public double CalculateTurnovers(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getError();
		}
		return result;
	}//计算失误数
	
	public double CalculateFouls(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFoul();
		}
		return result;
	}//计算犯规数
	
	public double CalculatePoints(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getScore();
		}
		return result;
	}//计算得分
	
	public double CalculateFieldGoalAttempts(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFieldGoalAttempts();
		}
		return result;
	}//计算投篮出手数
	
	public double CalculateThreePointAttempts(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getThreePointAttempts();
		}
		return result;
	}//计算三分出手数
	
	public double CalculateFreeThrowAttempts(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFreeThrowAttempts();
		}
		return result;
	}//计算罚球出手数
	
	public double CalculateEfficiency(ArrayList<MatchPlayer> MP){
		double result=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		result=(c.CalculatePoints(MP)+c.CalculateRebounds(MP)+c.CalculateAssists(MP)+c.CalculateBlocks(MP)+c.CalculateSteals(MP))
				-(c.CalculateFieldGoalAttempts(MP)-c.CalculateFieldGoalsMade(MP))
				-(c.CalculateFreeThrowAttempts(MP)-c.CalculateFreeThrowsMade(MP))
				-c.CalculateTurnovers(MP);
		return result;
	}//计算效率
	
	public double CalculateGmSc(ArrayList<MatchPlayer> MP){
		double result=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		result=c.CalculatePoints(MP)+0.4*c.CalculateFieldGoalsMade(MP)-0.7*c.CalculateFreeThrowAttempts(MP)
				-0.4*(c.CalculateFreeThrowAttempts(MP)-c.CalculateFreeThrowsMade(MP))
				+0.7*c.CalculateOffensiveRebounds(MP)+0.3*c.CalculateDefensiveRebounds(MP)
				+c.CalculateSteals(MP)+0.7*c.CalculateAssists(MP)+0.7*c.CalculateRebounds(MP)
				-0.4*c.CalculateFouls(MP)-c.CalculateTurnovers(MP);
		return result;
	}//计算GmSc
	
	public double CalculateTrueShootingPercentage(ArrayList<MatchPlayer> MP){
		double result=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		result=c.CalculatePoints(MP)/(2*(c.CalculateFieldGoalAttempts(MP)+0.44*c.CalculateFreeThrowAttempts(MP)));
		return result;
	}//计算真实命中率
	
	public double CalculateShootingEfficiency(ArrayList<MatchPlayer> MP){
		double result=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		result=(c.CalculateFieldGoalsMade(MP)+0.5*c.CalculateThreePointFieldGoalsMade(MP))/c.CalculateFieldGoalAttempts(MP);
		return result;
	}//计算投篮效率
	
	public double CalculateReboundRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double rebounds1=0;
		double rebounds2=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.CalculateMinutes(matchPlayer);
			rebounds1=rebounds1+c.CalculateRebounds(matchPlayer);
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			rebounds2=rebounds2+c.CalculateRebounds(matchPlayer);
		}
		result=c.CalculateRebounds(MP)*(allTime/5)/c.CalculateMinutes(MP)/(rebounds1+rebounds2);
		return result;
	}//计算篮板率
	
	public double CalculateOffensiveReboundRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double offensiveRebounds1=0;
		double offensiveRebounds2=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.CalculateMinutes(matchPlayer);
			offensiveRebounds1=offensiveRebounds1+c.CalculateOffensiveRebounds(matchPlayer);
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			offensiveRebounds2=offensiveRebounds2+c.CalculateOffensiveRebounds(matchPlayer);
		}
		result=c.CalculateOffensiveRebounds(MP)*(allTime/5)/c.CalculateMinutes(MP)/(offensiveRebounds1+offensiveRebounds2);
		return result;
	}//计算进攻篮板率
	
	public double CalculateDefensiveReboundRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double defensiveRebounds1=0;
		double defensiveRebounds2=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.CalculateMinutes(matchPlayer);
			defensiveRebounds1=defensiveRebounds1+c.CalculateDefensiveRebounds(matchPlayer);
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			defensiveRebounds2=defensiveRebounds2+c.CalculateDefensiveRebounds(matchPlayer);
		}
		result=c.CalculateDefensiveRebounds(MP)*(allTime/5)/c.CalculateMinutes(MP)/(defensiveRebounds1+defensiveRebounds2);
		return result;
	}//计算防守篮板率
	
	public double CalculateAssisyRating(ArrayList<MatchTeam> MT,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double allFieldGoalsMade=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.CalculateMinutes(matchPlayer);
			allFieldGoalsMade=allFieldGoalsMade+c.CalculateFieldGoalsMade(matchPlayer);
		}
		result=c.CalculateAssists(MP)/(c.CalculateMinutes(MP)/(allTime/5)*allFieldGoalsMade-c.CalculateFieldGoalsMade(MP));
		return result;
	}//计算助攻率
	
	public double CalculateStealRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double oppositeFieldGoalsAttempt=0;
		double oppositeFreeGoalsAttempt=0;
		double oppositeOffensiveRebounds=0;
		double defensiveRebounds=0;
		double opposiveFieldGoalsMiss=0;
		double opposiveTurnovers=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.CalculateMinutes(matchPlayer);
			defensiveRebounds=defensiveRebounds+c.CalculateDefensiveRebounds(matchPlayer);
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			oppositeFieldGoalsAttempt=oppositeFieldGoalsAttempt+c.CalculateFieldGoalAttempts(matchPlayer);
			oppositeFreeGoalsAttempt=oppositeFreeGoalsAttempt+c.CalculateFreeThrowAttempts(matchPlayer);
			oppositeOffensiveRebounds=oppositeOffensiveRebounds+c.CalculateOffensiveRebounds(matchPlayer);
			opposiveFieldGoalsMiss=opposiveFieldGoalsMiss+c.CalculateFieldGoalAttempts(matchPlayer)-
					c.CalculateFieldGoalsMade(matchPlayer);
			opposiveTurnovers=opposiveTurnovers+c.CalculateTurnovers(matchPlayer);
		}
		double oppositeOffenses=oppositeFieldGoalsAttempt+0.4*oppositeFreeGoalsAttempt
				-1.07*(oppositeOffensiveRebounds/(oppositeOffensiveRebounds+defensiveRebounds)*opposiveFieldGoalsMiss)
				+1.07*opposiveTurnovers;
		result=c.CalculateSteals(MP)*(allTime/5)/c.CalculateMinutes(MP)/oppositeOffenses;
		return result;
	}//计算抢断率
	
	public double CalculateBlockRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double oppositeTwo=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.CalculateMinutes(matchPlayer);
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			oppositeTwo=oppositeTwo+c.CalculateFieldGoalsMade(matchPlayer)-c.CalculateThreePointFieldGoalsMade(matchPlayer);
		}
		result=c.CalculateBlocks(MP)*(allTime/5)/c.CalculateMinutes(MP)/oppositeTwo;
		return result;
	}//计算盖帽率
	
	public double CalculateTurnoverRating(ArrayList<MatchPlayer> MP){
		double result=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		result=c.CalculateTurnovers(MP)/(c.CalculateFieldGoalAttempts(MP)-
				c.CalculateThreePointAttempts(MP)+0.44*c.CalculateFieldGoalAttempts(MP)+c.CalculateTurnovers(MP));
		return result;
	}//计算失误率
	
	public double CalculateUtilizationRating(ArrayList<MatchTeam> MT,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double allFieldGoalsAttemps=0;
		double allFreeGoalsAttemps=0;
		double allTurnover=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.CalculateMinutes(matchPlayer);
			allFieldGoalsAttemps=allFieldGoalsAttemps+c.CalculateFieldGoalAttempts(matchPlayer);
			allFreeGoalsAttemps=allFreeGoalsAttemps+c.CalculateFieldGoalAttempts(matchPlayer);
			allTurnover=allTurnover+c.CalculateTurnovers(matchPlayer);
		}
		result=(c.CalculateFieldGoalAttempts(MP)+0.44*c.CalculateFreeThrowAttempts(MP)+c.CalculateTurnovers(MP))
				*(allTime/5)/c.CalculateMinutes(MP)/
				(allFieldGoalsAttemps+0.44*allFreeGoalsAttemps+allTurnover);
		return result;
	}//计算使用率
	
	public double CalculateDoubleDouble(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			if(MP.get(i).getScore()+MP.get(i).getAssist()>=10 || MP.get(i).getScore()+MP.get(i).getRebound()>=10 
					|| MP.get(i).getScore()+MP.get(i).getST()>=10 || MP.get(i).getScore()+MP.get(i).getBlockShot()>=10 
					|| MP.get(i).getAssist()+MP.get(i).getBlockShot()>=10 || MP.get(i).getAssist()+MP.get(i).getRebound()>=10 
					|| MP.get(i).getAssist()+MP.get(i).getST()>=10 || MP.get(i).getST()+MP.get(i).getBlockShot()>=10 
					|| MP.get(i).getST()+MP.get(i).getRebound()>=10 || MP.get(i).getRebound()+MP.get(i).getBlockShot()>=10){
				result=result+1;
			}
		}
		return result;
	}//计算两双

	
	public String getFullName(String s){
		if(s.equals("ATL")){
			return "Hawks";
		}else if(s.equals("BKN")){
			return "Nets";
		}else if(s.equals("BOS")){
			return "Celtics";
		}else if(s.equals("CHA")){
			return "Hornets";
		}else if(s.equals("CHI")){
			return "Bulls";
		}else if(s.equals("CLE")){
			return "Cavaliers";
		}else if(s.equals("DAL")){
			return "Mavericks";
		}else if(s.equals("DEN")){
			return "Nuggets";
		}else if(s.equals("DET")){
			return "Pistons";
		}else if(s.equals("GSW")){
			return "Warriors";
		}else if(s.equals("HOU")){
			return "Rockets";
		}else if(s.equals("IND")){
			return "Pacers";
		}else if(s.equals("LAC")){
			return "Clippers";
		}else if(s.equals("LAL")){
			return "Lakers";
		}else if(s.equals("MEM")){
			return "Grizzlies";
		}else if(s.equals("MIA")){
			return "Heat";
		}else if(s.equals("MIL")){
			return "Bucks";
		}else if(s.equals("MIN")){
			return "Timberwolves";
		}else if(s.equals("NOP")){
			return "Pelicans";
		}else if(s.equals("NYK")){
			return "Knicks";
		}else if(s.equals("OKC")){
			return "Thunder";
		}else if(s.equals("ORL")){
			return "Magic";
		}else if(s.equals("PHI")){
			return "76ers";
		}else if(s.equals("PHX")){
			return "Suns";
		}else if(s.equals("POR")){
			return "Trail Blazers";
		}else if(s.equals("SAC")){
			return "Kings";
		}else if(s.equals("SAS")){
			return "Spurs";
		}else if(s.equals("TOR")){
			return "Raptors";
		}else if(s.equals("UTA")){
			return "Jazz";
		}else if(s.equals("WAS")){
			return "Wizards";
		}
		return "Unknow";
	}//球队全称

}
