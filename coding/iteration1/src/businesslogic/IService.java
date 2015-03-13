package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;
<<<<<<< HEAD
import vo.playerInfoVO;
import vo.teamInfo;
=======
import vo.playerInfo;
import vo.teamInfoVO;
>>>>>>> 579efd6e74d948d617ed568517e11a9c4b13685c

public interface IService {
	public teamInfoVO getSingleTeamInfo(teamInfoVO t);
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p);
	
	public ArrayList<teamInfoVO> getTeamInfo();
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc);
}
