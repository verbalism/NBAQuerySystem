package dataService;

import java.util.ArrayList;

import po.PlayerPO;
import po.TodayPlayerPO;

public interface PlayerDataService {
	public PlayerPO getSinglePlayerInfo(String playerName,String season);//��ѯ������Ա��Ϣ
	
	public ArrayList<PlayerPO> getAllPlayerInfo(String season);//��ѯȫ����Ա��Ϣ
	
	public ArrayList<TodayPlayerPO> getTodayPlayerInfo(String date,String season);//��ѯ������Ա��Ϣ
	
	//public void updatePlayerInfo(int matchID);//������Ϣ
	
	//public void updateBasicPlayerInfo();//������Ϣ
}
