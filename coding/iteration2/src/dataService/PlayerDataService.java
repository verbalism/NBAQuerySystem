package dataService;

import java.util.ArrayList;

import po.PlayerPO;
import po.TodayPlayerPO;

public interface PlayerDataService {
	public PlayerPO getSinglePlayerInfo(String playerName);//��ѯ������Ա��Ϣ
	
	public ArrayList<PlayerPO> getAllPlayerInfo();//��ѯȫ����Ա��Ϣ
	
	public ArrayList<TodayPlayerPO> getTodayPlayerInfo(String date);//��ѯ������Ա��Ϣ
	
	public void updatePlayerInfo(int matchID);//������Ϣ
	
	public void updateBasicPlayerInfo();//������Ϣ
}
