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
		
		PlayerVO p=d.getSinglePlayerInfo("Aaron Brooks");
		System.out.println(p.getTeamName());
		System.out.println(p.getMinutes());
		System.out.println(p.getMinutes2());
		System.out.println(p.getLeague());
		
		
		ArrayList<PlayerVO> pl=d.getAllPlayerInfo();
		System.out.println(pl.size());
		System.out.println(pl.get(2).getTeamName());
		System.out.println(pl.get(2).getMinutes());
		System.out.println(pl.get(2).getMinutes2());
		System.out.println(pl.get(2).getLeague());
		
		/*
		MatchVO m=d.getSingleMatchInfo("01-01","CHA");		
		System.out.println(m.getMatchTime());
		System.out.println(m.getTeam1().getTeamName());
		System.out.println(m.getTeam2().getTeamName());
		System.out.println(m.getTeam2().getPlayers().get(0).getPlayerName());
		System.out.println(m.getTeam2().getPlayers().get(1).getPlayerName());
		System.out.println(m.getTeam2().getPlayers().get(2).getPlayerName());
		System.out.println(m.getTeam2().getPlayers().get(3).getPlayerName());
		
		
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
		
		ArrayList<MatchVO> m6=d.findMatchByDate("01-01");
		System.out.println(m6.size());
		System.out.println(m6.get(1).getTeam1().getPlayers().get(5).getPlayerName());
		
		/*TeamVO t=d.getSingleTeamInfo("CHA");
		System.out.println(t.getFullName());
		
		ArrayList<TeamVO> t2=d.getAllTeamInfo();
		System.out.println(t2.size());*/
		
	}
}
