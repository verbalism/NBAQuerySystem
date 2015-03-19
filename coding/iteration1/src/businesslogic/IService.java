package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;

import vo.playerInfoVO;

import vo.teamInfoVO;


public interface IService {
	public teamInfoVO getSingleTeamInfo(teamInfoVO t);//查询单个球队
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p);//查询单个球员
	
	public ArrayList<teamInfoVO> getTeamInfo();//查询所有球队
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc);//查询所有球员
}
