package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;
import vo.playerInfoVO;
import vo.teamCondition;
import vo.teamInfoVO;


public interface IService {
	public teamInfoVO getSingleTeamInfo(teamInfoVO t);//根据FullName查询单个球队
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p);//查询单个球员
	
	public ArrayList<teamInfoVO> getTeamInfo(teamCondition tc);//查询所有球队
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc);//查询所有球员
	
	public ArrayList<teamInfoVO> sortTeam(ArrayList<teamInfoVO> original ,String s );//降序排列球队信息
}
