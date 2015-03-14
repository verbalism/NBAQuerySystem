package dataservice;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import po.PlayerInfoPO;

public interface PlayerDataService {
	public ArrayList<PlayerInfoPO> getPlayerOriginal() ;
	public PlayerInfoPO getSinglePlayerOriginal (String playerName);
	
}
