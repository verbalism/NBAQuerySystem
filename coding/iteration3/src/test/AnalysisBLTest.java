package test;

import java.util.ArrayList;

import data.MatchData;
import data.PlayerData;
import dataService.MatchDataService;
import dataService.PlayerDataService;
import po.MatchPO;
import po.TodayPlayerPO;
import vo.MatchVO;
import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
import vo.ScoreWay;
import vo.SortType;
import vo.TeamVO;
import vo.TodayPlayerVO;
import businesslogic.AnalysisBL;
import businesslogic.DataBL;
import businesslogicService.AnalysisBLService;
import businesslogicService.DataBLService;

public class AnalysisBLTest {
	public static void main(String []args){
		AnalysisBLService a=new AnalysisBL();
		DataBLService d=new DataBL();
		MatchDataService md=new MatchData();
	
		/*ArrayList<PlayerVO> p=a.sortPlayer(d.getAllPlayerInfo("14_15"),"stealRating");
		for(int i=0;i<p.size();i++){
			System.out.println(p.get(i).getStealRating());
		}
		
		ArrayList<TeamVO> t=a.sortTeam(d.getAllTeamInfo("14_15"),"fieldGoalsMade");
		for(int i=0;i<t.size();i++){
			System.out.println(t.get(i).getFieldGoalsMade());
		}*/
		
		PlayerVO pp=d.getSinglePlayerInfo("Jared Sullinger","14_15");
		System.out.println(pp.getTeamName());
		TeamVO tt=d.getSingleTeamInfo(pp.getTeamName(),"14_15");
		System.out.println(tt.getSubarea());
		
		ArrayList<PlayerVO> p2=a.getTopFiftyPlayer(PlayerPosition.All, PlayerPartition.All, "rebounds","14_15");
		for(int i=0;i<p2.size();i++){
			System.out.print(i+1);System.out.print("      ");
			System.out.print(p2.get(i).getPlayerName());System.out.print("      ");
			System.out.print(p2.get(i).getRebounds());System.out.print("      ");
			System.out.print(p2.get(i).getAssists());System.out.print("      ");
			System.out.println();
		}
		System.out.println(a.getScoreAnalysis("CHA", "14_15",ScoreWay.threePointFieldGoals));
		System.out.println("***********************************************************************************");
		System.out.println(a.getTheMostPotentialOffensivePlayer("CHA", "14_15"));
		
		System.out.println(a.getBestOffensivePlayer("CHA", "14_15"));
	
		ArrayList<TodayPlayerVO> p3=a.getTodayHotSpotPlayer("rebound");
		 for(int i=0;i<p3.size();i++){
				System.out.println(p3.get(i).getRebound());
			}
		 System.out.println("*****************************************************************************************");
		ArrayList<PlayerVO> p4=a.getSeasonHotSpotPlayer("rebounds","14_15_after");
		 for(int i=0;i<p4.size();i++){
			 	System.out.print(p4.get(i).getPlayerName());
			 	System.out.print("\t\t");
				System.out.println(p4.get(i).getRebounds());
		}
		 System.out.println("*****************************************************************************************");
		 ArrayList<TeamVO> t2=a.getSeasonHotSpotTeam("rebounds","14_15_after");
		 for(int i=0;i<t2.size();i++){
			 System.out.print(i+1);
			 System.out.print(t2.get(i).getFullName());
			 System.out.print("\t\t");
			System.out.println(t2.get(i).getRebounds());
		}
		 System.out.println("*****************************************************************************************");
		 ArrayList<PlayerVO> p5=a.getProgressivePlayer("increaseOfPoints","14_15_after");
		 for(int i=0;i<p5.size();i++){
				System.out.println(p5.get(i).getIncreaseOfPoints());
		}
		 System.out.println("*****************************************************************************************");
		 System.out.println(a.getScoreAnalysis("CHA", "14_15",ScoreWay.threePointFieldGoals));
		 System.out.println("*****************************************************************************************");
	

		 
		
	}
}
