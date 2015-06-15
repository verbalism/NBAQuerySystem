package test;

import java.util.ArrayList;

import data.MatchData;
import dataService.MatchDataService;
import po.MatchPO;
import po.PlayerPO;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;
import businesslogic.DataBL;
import businesslogicService.DataBLService;

public class DataBLTest {
	public static void main(String []args){
		
		
		DataBLService d=new DataBL();
		MatchDataService md=new MatchData();
		
		/*PlayerVO p=d.getSinglePlayerInfo("Aaron Brooks","14_15");
		System.out.println(p.getTeamName());
		System.out.println(p.getMinutes());
		System.out.println(p.getLeague());
		
		
		ArrayList<PlayerVO> pl=d.getAllPlayerInfo("14_15_after");
		System.out.println(pl.size());
		System.out.println(pl.get(2).getTeamName());
		System.out.println(pl.get(2).getMinutes());
		System.out.println(pl.get(2).getLeague());
		
		*/
		ArrayList<MatchPO> m=md.getAllMatchInfo("14_15_after");
		for(int i=0;i<m.size();i++){
			System.out.println(m.get(i).getMatchTime()+m.get(i).getTeam1().getTeamName());
		}
		/*MatchVO mm=d.getSingleMatchInfo("06-11","CLE","14_15_after");		
		System.out.println(mm.getMatchTime());
		System.out.println(mm.getTeam1().getTeamName());
		System.out.println(mm.getTeam2().getTeamName());
		System.out.println(mm.getTeam2().getPlayers().get(0).getPlayerName());
		System.out.println(mm.getTeam2().getPlayers().get(1).getPlayerName());
		System.out.println(mm.getTeam2().getPlayers().get(2).getPlayerName());
		System.out.println(mm.getTeam2().getPlayers().get(3).getPlayerName());
		
		
		ArrayList<MatchVO> ml=d.findMatchByPlayer("Aaron Brooks");
		System.out.println(ml.size());
		ArrayList<MatchPO> m3=md.getPlayerRecentMatchInfo(5,"Josh McRoberts");
		System.out.println(m3.size());
		
		ArrayList<MatchVO> m4=d.findMatchByTeam("CHA");
		ArrayList<MatchPO> m5=md.getTeamRecentMatchInfo(5, "CHA");
		System.out.println(m4.size());
		System.out.println(m4.get(0).getMatchTime());
		System.out.println(m4.get(1).getMatchTime());
		System.out.println(m4.get(2).getMatchTime());
		System.out.println(m4.get(3).getMatchTime());
		System.out.println(m4.get(4).getMatchTime());	*/
		
		ArrayList<MatchVO> m6=d.findMatchByDate("04-28","14_15_after");
		System.out.println(m6.size());
		System.out.println(m6.get(1).getTeam1().getPlayers().get(6).getDefensiveRebound());
		
		TeamVO t=d.getSingleTeamInfo("CLE","14_15_after");
		System.out.println(t.getFullName());
		
		ArrayList<TeamVO> t2=d.getAllTeamInfo("14_15_after");
		System.out.println(t2.size());
		
	}
}
