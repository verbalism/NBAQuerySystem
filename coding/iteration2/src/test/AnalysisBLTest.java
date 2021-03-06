package test;

import java.util.ArrayList;

import data.PlayerData;
import dataService.PlayerDataService;
import po.TodayPlayerPO;
import vo.MatchVO;
import vo.PlayerAge;
import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
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
		
		/*ArrayList<PlayerVO> p=a.sortPlayer(d.getAllPlayerInfo(),"stealRating",SortType.Descending);
		for(int i=0;i<p.size();i++){
			System.out.println(p.get(i).getStealRating());
		}
		
		ArrayList<TeamVO> t=a.sortTeam(d.getAllTeamInfo(),"fieldGoalsMade",SortType.Descending);
		for(int i=0;i<t.size();i++){
			System.out.println(t.get(i).getFieldGoalsMade());
		}
		
		PlayerVO pp=d.getSinglePlayerInfo("Jared Sullinger");
		System.out.println(pp.getTeamName());
		TeamVO tt=d.getSingleTeamInfo(pp.getTeamName());
		System.out.println(tt.getSubarea());*/
		
		ArrayList<PlayerVO> p2=a.getTopFiftyPlayer(PlayerPosition.All, PlayerPartition.All, "rebounds");
		for(int i=0;i<p2.size();i++){
			System.out.print(i);System.out.print("      ");
			System.out.print(p2.get(i).getPlayerName());System.out.print("      ");
			System.out.print(p2.get(i).getRebounds());System.out.print("      ");
			System.out.print(p2.get(i).getAssists());System.out.print("      ");
			System.out.println();
		}
		System.out.println("***********************************************************************************");
		String[] keyword={"rebounds","assists","point"};
		SortType[] sortType={SortType.Descending,SortType.Ascending,SortType.Ascending};
		ArrayList<PlayerVO> p6=a.getTopNPlayers(100, PlayerPosition.All, PlayerPartition.All,PlayerAge.from23to25, keyword, sortType);
		for(int i=0;i<p6.size();i++){
			System.out.print(i);System.out.print("      ");
			System.out.print(p6.get(i).getPlayerName());System.out.print("      ");
			System.out.print(p6.get(i).getRebounds());System.out.print("      ");
			System.out.print(p6.get(i).getAssists());System.out.print("      ");
			System.out.print(p6.get(i).getAge());System.out.print("      ");
			System.out.println();
		}
		/* ArrayList<TodayPlayerVO> p3=a.getTodayHotSpotPlayer("rebound");
		 for(int i=0;i<p3.size();i++){
				System.out.println(p3.get(i).getRebound());
			}
		
		 ArrayList<PlayerVO> p4=a.getSeasonHotSpotPlayer("rebounds");
		 for(int i=0;i<p4.size();i++){
				System.out.println(p4.get(i).getRebounds());
		}
		 
		 ArrayList<TeamVO> t2=a.getSeasonHotSpotTeam("rebounds");
		 for(int i=0;i<t2.size();i++){
				
				System.out.println(t2.get(i).getRebounds());
		}

		 ArrayList<PlayerVO> p5=a.getProgressivePlayer("increaseOfPoints");
		 for(int i=0;i<p5.size();i++){
				System.out.println(p5.get(i).getIncreaseOfPoints());
		}
		 
		 ArrayList<MatchVO> m=a.getTodayMatch();
		 System.out.println(m.get(0).getMatchTime());
		 System.out.println(m.size());*/
		
	}
}
