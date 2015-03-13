package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;
import vo.playerInfo;
import vo.teamInfo;

public interface IService {
	public teamInfo getSingleTeamInfo(teamInfo t);
	
	public playerInfo getSinglePlayerInfo(playerInfo p);
	
	public ArrayList<teamInfo> getTeamInfo();
	
	public ArrayList<playerInfo> getPlayerInfo(playerCondition pc);
}
