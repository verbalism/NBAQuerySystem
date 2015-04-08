package dataService;

import java.util.ArrayList;

import po.PlayerPO;
import po.TodayPlayerPO;

public interface PlayerDataService {
	public PlayerPO getSinglePlayerInfo(String playerName);
	
	public ArrayList<PlayerPO> getAllPlayerInfo();
	
	public ArrayList<TodayPlayerPO> getTodayPlayerInfo(String date);
	
}
