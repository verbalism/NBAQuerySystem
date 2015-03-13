package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;
import vo.playerInfo;
import vo.teamInfoVO;

public interface IService {
	public teamInfoVO getSingleTeamInfo(teamInfoVO t);
	
	public playerInfo getSinglePlayerInfo(playerInfo p);
	
	public ArrayList<teamInfoVO> getTeamInfo();
	
	public ArrayList<playerInfo> getPlayerInfo(playerCondition pc);
}
