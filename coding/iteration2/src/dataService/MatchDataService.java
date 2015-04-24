package dataService;

import java.util.ArrayList;

import po.MatchPO;

public interface MatchDataService {
	public MatchPO getSingleMatchInfo(String teamName,String date);
	
	public ArrayList<MatchPO> getAllMatchInfo();
	
	public ArrayList<MatchPO> getTeamRecentMatchInfo(int number,String teamName);
	
	public ArrayList<MatchPO> getPlayerRecentMatchInfo(int number,String playerName);
}
