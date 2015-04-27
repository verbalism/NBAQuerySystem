package dataService;

import java.util.ArrayList;

import po.MatchPO;

public interface MatchDataService {
	public MatchPO getSingleMatchInfo(String teamName,String date);//根据队名和比赛时间获取比赛信息matchpo
	
	public ArrayList<MatchPO> getAllMatchInfo();//获取所有比赛信息
	
	public ArrayList<MatchPO> getTeamRecentMatchInfo(int number,String teamName);//获取球队最近比赛，number为比赛场数，teamName为队名
	
	public ArrayList<MatchPO> getPlayerRecentMatchInfo(int number,String playerName);//获取球员最近比赛，number为比赛场数，playername为队员名
	
	public String getDate();//获取数据库中 最后一场比赛时间
	
	public ArrayList<MatchPO> getTodayMatchInfo(String date);//获取某日比赛啊时间
	
	//public void updateMatchInfo();//更新比赛信息
}
