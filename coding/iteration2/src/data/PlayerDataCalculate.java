package data;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import po.BasicPlayerPO;
import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;
import po.PlayerPO;

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
	
	public String CalculateMinutes(ArrayList<MatchPlayer> MP){
		String result="0:0";
		PlayerDataCalculate pdc=new PlayerDataCalculate();
		for(int i=0;i<MP.size();i++){
			result=pdc.calTime(result,MP.get(i).getMatchTime());
		}
		return result;
	}//计算在场时间
	
	public String calTime(String a,String b){
		if(a==null || a.equals(""))
			a="0:0";
		if(b==null || b.equals(""))
			b="0:0";
		String[] xa=a.split(":");
		String[] xb=b.split(":");
		int second1=Integer.parseInt(xa[1]);
		int second2=Integer.parseInt(xb[1]);
		int minute1=Integer.parseInt(xa[0]);
		int minute2=Integer.parseInt(xb[0]);
		
		int minute=(second1+second2)/60+minute1+minute2;
		int second=(second1+second2)%60;
		
		String result=String.valueOf(minute)+":"+String.valueOf(second);
		
		return result;
	}//计算两时间之和
	
	public double getTime(String time){
		if(time==null || time.equals(""))
			time="0:0";
		String []t=time.split(":");
		double min=Double.valueOf(t[0]);
		double sec=Double.valueOf(t[1]);
		double result=min+sec/60;
		return result;
	}//计算时间值
	
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
			allTime=allTime+c.getTime(c.CalculateMinutes(matchPlayer));
			rebounds1=rebounds1+c.CalculateRebounds(matchPlayer);
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			rebounds2=rebounds2+c.CalculateRebounds(matchPlayer);
		}
		result=c.CalculateRebounds(MP)*(allTime/5)/c.getTime(c.CalculateMinutes(MP))/(rebounds1+rebounds2);
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
			allTime=allTime+c.getTime(c.CalculateMinutes(matchPlayer));
			offensiveRebounds1=offensiveRebounds1+c.CalculateOffensiveRebounds(matchPlayer);
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			offensiveRebounds2=offensiveRebounds2+c.CalculateOffensiveRebounds(matchPlayer);
		}
		result=c.CalculateOffensiveRebounds(MP)*(allTime/5)/c.getTime(c.CalculateMinutes(MP))/(offensiveRebounds1+offensiveRebounds2);
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
			allTime=allTime+c.getTime(c.CalculateMinutes(matchPlayer));
			defensiveRebounds1=defensiveRebounds1+c.CalculateDefensiveRebounds(matchPlayer);
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			defensiveRebounds2=defensiveRebounds2+c.CalculateDefensiveRebounds(matchPlayer);
		}
		result=c.CalculateDefensiveRebounds(MP)*(allTime/5)/c.getTime(c.CalculateMinutes(MP))/(defensiveRebounds1+defensiveRebounds2);
		return result;
	}//计算防守篮板率
	
	public double CalculateAssisyRating(ArrayList<MatchTeam> MT,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double allFieldGoalsMade=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.getTime(c.CalculateMinutes(matchPlayer));
			allFieldGoalsMade=allFieldGoalsMade+c.CalculateFieldGoalsMade(matchPlayer);
		}
		result=c.CalculateAssists(MP)/(c.getTime(c.CalculateMinutes(MP))/(allTime/5)*allFieldGoalsMade-c.CalculateFieldGoalsMade(MP));
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
			allTime=allTime+c.getTime(c.CalculateMinutes(matchPlayer));
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
		result=c.CalculateSteals(MP)*(allTime/5)/c.getTime(c.CalculateMinutes(MP))/oppositeOffenses;
		return result;
	}//计算抢断率
	
	public double CalculateBlockRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double oppositeTwo=0;
		PlayerDataCalculate c=new PlayerDataCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.getTime(c.CalculateMinutes(matchPlayer));
		}
		for(int i=0;i<MT2.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT2.get(i).getPlayers();
			oppositeTwo=oppositeTwo+c.CalculateFieldGoalsMade(matchPlayer)-c.CalculateThreePointFieldGoalsMade(matchPlayer);
		}
		result=c.CalculateBlocks(MP)*(allTime/5)/c.getTime(c.CalculateMinutes(MP))/oppositeTwo;
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
			allTime=allTime+c.getTime(c.CalculateMinutes(matchPlayer));
			allFieldGoalsAttemps=allFieldGoalsAttemps+c.CalculateFieldGoalAttempts(matchPlayer);
			allFreeGoalsAttemps=allFreeGoalsAttemps+c.CalculateFieldGoalAttempts(matchPlayer);
			allTurnover=allTurnover+c.CalculateTurnovers(matchPlayer);
		}
		result=(c.CalculateFieldGoalAttempts(MP)+0.44*c.CalculateFreeThrowAttempts(MP)+c.CalculateTurnovers(MP))
				*(allTime/5)/c.getTime(c.CalculateMinutes(MP))/
				(allFieldGoalsAttemps+0.44*allFreeGoalsAttemps+allTurnover);
		return result;
	}//计算使用率
	
	public double CalculateDoubleDouble(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			if((MP.get(i).getScore()>=10&&MP.get(i).getAssist()>=10) || (MP.get(i).getScore()>=10&&MP.get(i).getRebound()>=10 )
					|| (MP.get(i).getScore()>=10&&MP.get(i).getST()>=10) || (MP.get(i).getScore()>=10&&MP.get(i).getBlockShot()>=10 )
					|| (MP.get(i).getAssist()>=10&&MP.get(i).getBlockShot()>=10) || (MP.get(i).getAssist()>=10&&MP.get(i).getRebound()>=10 )
					|| (MP.get(i).getAssist()>=10&&MP.get(i).getST()>=10) || (MP.get(i).getST()>=10&&MP.get(i).getBlockShot()>=10 )
					|| (MP.get(i).getST()>=10&&MP.get(i).getRebound()>=10) || (MP.get(i).getRebound()>=10&&MP.get(i).getBlockShot()>=10)){
				result=result+1;
			}
		}
		return result;
	}//计算两双
	
	public double CalculateIncreaseOfPoints(ArrayList<MatchPlayer> MP){
		int num=MP.size();
		double A=0,B=0,result=0;
		if(num>=6){
			for(int i=num-1;i>=num-5;i--){
				B=MP.get(i).getScore()+B;
			}
			B=B/5;
			for(int i=num-6;i>=0;i--){
				A=MP.get(i).getScore()+A;
			}
			A=A/(num-5);
			if(A!=0)
				result=(B-A)/A;
		}
		return result;
	}
	
	public double CalculateIncreaseOfAssists(ArrayList<MatchPlayer> MP){
		int num=MP.size();
		double A=0,B=0,result=0;
		if(num>=6){
			for(int i=num-1;i>=num-5;i--){
				B=MP.get(i).getAssist()+B;
			}
			B=B/5;
			for(int i=num-6;i>=0;i--){
				A=MP.get(i).getAssist()+A;
			}
			A=A/(num-5);
			if(A!=0)
				result=(B-A)/A;
		}
		return result;
	}
	
	public double CalculateIncreaseOfRebounds(ArrayList<MatchPlayer> MP){
		int num=MP.size();
		double A=0,B=0,result=0;
		if(num>=6){
			for(int i=num-1;i>=num-5;i--){
				B=MP.get(i).getRebound()+B;
			}
			B=B/5;
			for(int i=num-6;i>=0;i--){
				A=MP.get(i).getRebound()+A;
			}
			A=A/(num-5);
			if(A!=0)
				result=(B-A)/A;
		}
		return result;
	}
	
	public void savePlayerInfoVO(){
		getFullPatch gfp=new getFullPatch();
		String s=gfp.getFullPath();
		try{
			File path=new File(s+"//Data");
			File dir=new File(path,"playerInfoVO.txt");
			if(!dir.exists()) 
				dir.createNewFile(); 
		}catch(Exception e){
			 System.out.print("创建失败");
		}
		 
		ArrayList<PlayerPO> result=new ArrayList<PlayerPO>();
		
		BasicPlayerData pd=new BasicPlayerData();
		ArrayList<BasicPlayerPO> pip=pd.getPlayerOriginal();
		for(int i=0;i<pip.size();i++){
			String temp=pip.get(i).getName();
			PlayerData si=new PlayerData();
			PlayerPO piv=si.getSinglePlayerInfo(temp);
			result.add(piv);
		}
		/*for(int i=result.size()-1;i>=0;i--){
			if(result.get(i).getTeamName().equals("Unknow"))
				result.remove(i);
		}*/
		
		File f = new File(s+"//Data//playerInfoVO.txt");
		FileWriter fw;
		BufferedWriter bw;
		try{		
			fw = new FileWriter(f);
			fw.write("");
			fw.close();
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
		try{		
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);

			for(int i=0;i<result.size();i++){
				bw.write(result.get(i).getPlayerName()+";"+result.get(i).getTeamName()+";"+result.get(i).getGamesPlayed()+";"+result.get(i).getGamesStarting()+";"+result.get(i).getRebounds()+";"+result.get(i).getAssists()+";"+result.get(i).getMinutes()+";"+result.get(i).getFieldGoalsPercentage()+";"+result.get(i).getThreePointFieldGoalsPercentage()+";"+result.get(i).getFreeThrowsPercentage()+";"+result.get(i).getOffensiveRebounds()+";"+result.get(i).getDefensiveRebounds()+";"+result.get(i).getSteals()+";"+result.get(i).getBlocks()+";"+result.get(i).getTurnovers()+";"+result.get(i).getFouls()+";"+result.get(i).getPoints()+";"+result.get(i).getEfficiency()+";"+result.get(i).getGmSc()+";"+result.get(i).getTrueShootingPercentage()+";"+result.get(i).getShootingEfficiency()+";"+result.get(i).getReboundRating()+";"+result.get(i).getOffensiveReboundRating()+";"+result.get(i).getDefensiveReboundRating()+";"+result.get(i).getAssisyRating()+";"+result.get(i).getStealRating()+";"+result.get(i).getBlockRating()+";"+result.get(i).getTurnoverRating()+";"+result.get(i).getUtilizationRating()+";"+result.get(i).getNumber()+";"+result.get(i).getPosition()+";"+result.get(i).getHeight()+";"+result.get(i).getWeight()+";"+result.get(i).getBirth()+";"+result.get(i).getAge()+";"+result.get(i).getExp()+";"+result.get(i).getSchool()+";"+result.get(i).getDoubleDouble()+";"+result.get(i).getIncreaseOfPoints()+";"+result.get(i).getIncreaseOfAssists()+";"+result.get(i).getIncreaseOfRebounds());
				bw.write("\r\n");
			}

			bw.flush();
			bw.close();
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}//保存球员VO信息
	
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
	
	/*public static void main(String []args ){
		PlayerDataCalculate pic=new PlayerDataCalculate();
		pic.savePlayerInfoVO();
	}*/
		
}


