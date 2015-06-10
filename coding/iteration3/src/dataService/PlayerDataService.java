package dataService;

import java.util.ArrayList;

import po.PlayerPO;
import po.TodayPlayerPO;

public interface PlayerDataService {
	public PlayerPO getSinglePlayerInfo(String playerName,String season);//查询单个球员信息
	
	public ArrayList<PlayerPO> getAllPlayerInfo(String season);//查询全部球员信息
	
	public ArrayList<TodayPlayerPO> getTodayPlayerInfo(String date,String season);//查询当天球员信息
	
	//public void updatePlayerInfo(int matchID);//更新信息
	
	//public void updateBasicPlayerInfo();//基本信息
}
