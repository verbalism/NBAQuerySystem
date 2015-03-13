package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;

import vo.playerInfoVO;

import vo.teamInfoVO;


public interface IService {
	public teamInfoVO getSingleTeamInfo(teamInfoVO t);
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p);
	
	public ArrayList<teamInfoVO> getTeamInfo();
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc);
}
