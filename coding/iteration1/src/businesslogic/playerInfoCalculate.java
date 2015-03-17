package businesslogic;

import java.util.ArrayList;

import po.MatchInfoPO;
import po.MatchPlayer;
import po.MatchTeam;
import vo.playerInfoVO;

public class playerInfoCalculate {
	public String CalculateTeam(String playerName,MatchInfoPO match){
		ArrayList<MatchPlayer> tp=match.getTeam1().getPlayers();
		for(int j=0;j<tp.size();j++){
			if(tp.get(j).getPlayerName().equals(playerName)){
				return match.getTeam1().getTeamName();
			}
		}
		return match.getTeam2().getTeamName();
	}//�����������
	
	public int CalculateGamesStarting(String playerName,ArrayList<MatchInfoPO> mpSelected){
		int result=0;
		for(int i=0;i<mpSelected.size();i++){
			MatchTeam team1=mpSelected.get(i).getTeam1();
			MatchTeam team2=mpSelected.get(i).getTeam2();
			for(int j=0;j<5;j++){
				if(team1.getPlayers().get(j).equals(playerName)){
					result++;
				}
			}
			for(int j=0;j<5;j++){
				if(team2.getPlayers().get(j).equals(playerName)){
					result++;
				}
			}
		}
		return result;
	}//�����ȷ�����
	
	public double CalculateRebounds(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getRebound();
		}
		return result;
	}//����������
	
	public double CalculateAssists(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getAssist();
		}
		return result;
	}//����������
	
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
	}//�����ڳ�ʱ��
	
	public double CalculateFieldGoalsMade(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFieldGoal();
		}
		return result;
	}//����Ͷ��������
	
	public double CalculateThreePointFieldGoalsMade(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getThreePointShot();
		}
		return result;
	}//��������������
	
	public double CalculateFreeThrowsMade(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFreeThrowGoal();
		}
		return result;
	}//���㷣��������
	
	public double CalculateOffensiveRebounds(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getOffensiveRebound();
		}
		return result;
	}//�������������
	
	public double CalculateDefensiveRebounds(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getDefensiveRebound();
		}
		return result;
	}//�������������
	
	public double CalculateSteals(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getST();
		}
		return result;
	}//����������
	
	public double CalculateBlocks(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getBlockShot();
		}
		return result;
	}//�����ñ��
	
	public double CalculateTurnovers(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getError();
		}
		return result;
	}//����ʧ����
	
	public double CalculateFouls(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFoul();
		}
		return result;
	}//���㷸����
	
	public double CalculatePoints(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getScore();
		}
		return result;
	}//����÷�
	
	public double CalculateFieldGoalAttempts(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFieldGoalAttempts();
		}
		return result;
	}//����Ͷ��������
	
	public double CalculateThreePointAttempts(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getThreePointAttempts();
		}
		return result;
	}//�������ֳ�����
	
	public double CalculateFreeThrowAttempts(ArrayList<MatchPlayer> MP){
		double result=0;
		for(int i=0;i<MP.size();i++){
			result=result+MP.get(i).getFreeThrowAttempts();
		}
		return result;
	}//���㷣�������
	
	public double CalculateEfficiency(ArrayList<MatchPlayer> MP){
		double result=0;
		playerInfoCalculate c=new playerInfoCalculate();
		result=(c.CalculatePoints(MP)+c.CalculateRebounds(MP)+c.CalculateAssists(MP)+c.CalculateBlocks(MP)+c.CalculateSteals(MP))
				-(c.CalculateFieldGoalAttempts(MP)-c.CalculateFieldGoalsMade(MP))
				-(c.CalculateFreeThrowAttempts(MP)-c.CalculateFreeThrowsMade(MP))
				-c.CalculateTurnovers(MP);
		return result;
	}//����Ч��
	
	public double CalculateGmSc(ArrayList<MatchPlayer> MP){
		double result=0;
		playerInfoCalculate c=new playerInfoCalculate();
		result=c.CalculatePoints(MP)+0.4*c.CalculateFieldGoalsMade(MP)-0.7*c.CalculateFreeThrowAttempts(MP)
				-0.4*(c.CalculateFreeThrowAttempts(MP)-c.CalculateFreeThrowsMade(MP))
				+0.7*c.CalculateOffensiveRebounds(MP)+0.3*c.CalculateDefensiveRebounds(MP)
				+c.CalculateSteals(MP)+0.7*c.CalculateAssists(MP)+0.7*c.CalculateRebounds(MP)
				-0.4*c.CalculateFouls(MP)-c.CalculateTurnovers(MP);
		return result;
	}//����GmSc
	
	public double CalculateTrueShootingPercentage(ArrayList<MatchPlayer> MP){
		double result=0;
		playerInfoCalculate c=new playerInfoCalculate();
		result=c.CalculatePoints(MP)/(2*(c.CalculateFieldGoalAttempts(MP)+0.44*c.CalculateFreeThrowAttempts(MP)));
		return result;
	}//������ʵ������
	
	public double CalculateShootingEfficiency(ArrayList<MatchPlayer> MP){
		double result=0;
		playerInfoCalculate c=new playerInfoCalculate();
		result=(c.CalculateFieldGoalsMade(MP)+0.5*c.CalculateThreePointFieldGoalsMade(MP))/c.CalculateFieldGoalAttempts(MP);
		return result;
	}//����Ͷ��Ч��
	
	public double CalculateReboundRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double rebounds1=0;
		double rebounds2=0;
		playerInfoCalculate c=new playerInfoCalculate();
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
	}//����������
	
	public double CalculateOffensiveReboundRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double offensiveRebounds1=0;
		double offensiveRebounds2=0;
		playerInfoCalculate c=new playerInfoCalculate();
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
	}//�������������
	
	public double CalculateDefensiveReboundRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double defensiveRebounds1=0;
		double defensiveRebounds2=0;
		playerInfoCalculate c=new playerInfoCalculate();
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
	}//�������������
	
	public double CalculateAssisyRating(ArrayList<MatchTeam> MT,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double allFieldGoalsMade=0;
		playerInfoCalculate c=new playerInfoCalculate();
		for(int i=0;i<MT.size();i++){
			ArrayList<MatchPlayer> matchPlayer=MT.get(i).getPlayers();
			allTime=allTime+c.CalculateMinutes(matchPlayer);
			allFieldGoalsMade=allFieldGoalsMade+c.CalculateFieldGoalsMade(matchPlayer);
		}
		result=c.CalculateAssists(MP)/(c.CalculateMinutes(MP)/(allTime/5)*allFieldGoalsMade-c.CalculateFieldGoalsMade(MP));
		return result;
	}//����������
	
	public double CalculateStealRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double oppositeFieldGoalsAttempt=0;
		double oppositeFreeGoalsAttempt=0;
		double oppositeOffensiveRebounds=0;
		double defensiveRebounds=0;
		double opposiveFieldGoalsMiss=0;
		double opposiveTurnovers=0;
		playerInfoCalculate c=new playerInfoCalculate();
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
	}//����������
	
	public double CalculateBlockRating(ArrayList<MatchTeam> MT,ArrayList<MatchTeam> MT2,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double oppositeTwo=0;
		playerInfoCalculate c=new playerInfoCalculate();
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
	}//�����ñ��
	
	public double CalculateTurnoverRating(ArrayList<MatchPlayer> MP){
		double result=0;
		playerInfoCalculate c=new playerInfoCalculate();
		result=c.CalculateTurnovers(MP)/(c.CalculateFieldGoalAttempts(MP)-
				c.CalculateThreePointAttempts(MP)+0.44*c.CalculateFieldGoalAttempts(MP)+c.CalculateTurnovers(MP));
		return result;
	}//����ʧ����
	
	public double CalculateUtilizationRating(ArrayList<MatchTeam> MT,ArrayList<MatchPlayer> MP){
		double result=0;
		double allTime=0;
		double allFieldGoalsAttemps=0;
		double allFreeGoalsAttemps=0;
		double allTurnover=0;
		playerInfoCalculate c=new playerInfoCalculate();
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
	}//����ʹ����
	
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
	}//������˫
	
	public ArrayList<playerInfoVO> ascendingOrder(ArrayList<playerInfoVO> piv,String s){
		ArrayList<playerInfoVO> result=new ArrayList<playerInfoVO>();
		if(s.equals("rebounds")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getRebounds()>piv.get(j).getRebounds())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("assists")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getAssists()>piv.get(j).getAssists())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("minutes")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getMinutes()>piv.get(j).getMinutes())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("fieldGoalsMade")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getFieldGoalsMade()>piv.get(j).getFieldGoalsMade())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("threePointFieldGoalsMade")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getThreePointFieldGoalsMade()>piv.get(j).getThreePointFieldGoalsMade())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("freeThrowsMade")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getFreeThrowsMade()>piv.get(j).getFreeThrowsMade())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("offensiveRebounds")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getOffensiveRebounds()>piv.get(j).getOffensiveRebounds())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("defensiveRebounds")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getDefensiveRebounds()>piv.get(j).getDefensiveRebounds())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("steals")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getSteals()>piv.get(j).getSteals())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("blocks")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getBlocks()>piv.get(j).getBlocks())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("turnovers")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getTurnovers()>piv.get(j).getTurnovers())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("fouls")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getFouls()>piv.get(j).getFouls())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("points")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getPoints()>piv.get(j).getPoints())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("efficiency")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getEfficiency()>piv.get(j).getEfficiency())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("GmSc")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getGmSc()>piv.get(j).getGmSc())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("trueShootingPercentage")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getTrueShootingPercentage()>piv.get(j).getTrueShootingPercentage())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("shootingEfficiency")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getShootingEfficiency()>piv.get(j).getShootingEfficiency())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("reboundRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getReboundRating()>piv.get(j).getReboundRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("offensiveReboundRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getOffensiveReboundRating()>piv.get(j).getOffensiveReboundRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("defensiveReboundRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getDefensiveReboundRating()>piv.get(j).getDefensiveReboundRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("assisyRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getAssisyRating()>piv.get(j).getAssisyRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("stealRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getStealRating()>piv.get(j).getStealRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("blockRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getBlockRating()>piv.get(j).getBlockRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("turnoverRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getTurnoverRating()>piv.get(j).getTurnoverRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("utilizationRating")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getUtilizationRating()>piv.get(j).getUtilizationRating())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}
		return result;
	}//��������
	
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
		}else if(s.equals("fieldGoalsMade")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getFieldGoalsMade()<piv.get(j).getFieldGoalsMade())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("threePointFieldGoalsMade")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getThreePointFieldGoalsMade()<piv.get(j).getThreePointFieldGoalsMade())
						i=j;
				}
				result.add(piv.get(i));
				piv.remove(i);
			}
		}else if(s.equals("freeThrowsMade")){
			while(piv.size()>0){
				int i=0;
				for(int j=i+1;j<piv.size();j++){
					if(piv.get(i).getFreeThrowsMade()<piv.get(j).getFreeThrowsMade())
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
	}//��������
	
	
	public ArrayList<playerInfoVO> sort50(ArrayList<playerInfoVO> piv,String s){
		ArrayList<playerInfoVO> result=new ArrayList<playerInfoVO>();
		playerInfoCalculate pc=new playerInfoCalculate();
		if(s.equals("Points")){
			result=pc.descendingOrder(piv, "points");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("Rebounds")){
			result=pc.descendingOrder(piv, "rebounds");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("Assists")){
			result=pc.descendingOrder(piv, "assists");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("PointsReboundsAssists")){
			result=pc.descendingOrder(piv, "pointsReboundsAssists");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("Blocks")){
			result=pc.descendingOrder(piv, "blocks");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("Steals")){
			result=pc.descendingOrder(piv, "steals");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("Fouls")){
			result=pc.descendingOrder(piv, "fouls");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("Turnovers")){
			result=pc.descendingOrder(piv, "turnovers");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("Minutes")){
			result=pc.descendingOrder(piv, "minutes");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("Efficiency")){
			result=pc.descendingOrder(piv, "efficiency");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("FieldGoalsMade")){
			result=pc.descendingOrder(piv, "fieldGoalsMade");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("ThreePointFieldGoalsMade")){
			result=pc.descendingOrder(piv, "threePointFieldGoalsMade");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("FreeThrowsMade")){
			result=pc.descendingOrder(piv, "freeThrowsMade");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}else if(s.equals("DoubleDouble")){
			result=pc.descendingOrder(piv, "doubledouble");
			if(result.size()>50){
				for(int i=50;i<result.size();i++){
					result.remove(i);
				}
			}
		}
		
		return result;
	}
	
}
