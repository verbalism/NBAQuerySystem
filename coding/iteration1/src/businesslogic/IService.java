package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;
import vo.playerInfoVO;
import vo.teamInfo;

public interface IService {
	public teamInfo getSingleTeamInfo(teamInfo t);
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p);
	
	public ArrayList<teamInfo> getTeamInfo();
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc);
}
