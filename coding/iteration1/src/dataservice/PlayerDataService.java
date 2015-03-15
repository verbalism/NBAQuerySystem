package dataservice;

import java.util.ArrayList;

import po.PlayerInfoPO;

public interface PlayerDataService {
	public ArrayList<PlayerInfoPO> getPlayerOriginal() ;
	public PlayerInfoPO getSinglePlayerOriginal (String playerName);
	
}
