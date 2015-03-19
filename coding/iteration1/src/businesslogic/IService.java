package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;

import vo.playerInfoVO;

import vo.teamInfoVO;


public interface IService {
	public teamInfoVO getSingleTeamInfo(teamInfoVO t);//��ѯ�������
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p);//��ѯ������Ա
	
	public ArrayList<teamInfoVO> getTeamInfo();//��ѯ�������
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc);//��ѯ������Ա
}
