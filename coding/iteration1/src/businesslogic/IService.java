package businesslogic;

import java.util.ArrayList;

import vo.playerCondition;
import vo.playerInfoVO;
import vo.teamCondition;
import vo.teamInfoVO;


public interface IService {
	public teamInfoVO getSingleTeamInfo(teamInfoVO t);//����FullName��ѯ�������
	
	public playerInfoVO getSinglePlayerInfo(playerInfoVO p);//��ѯ������Ա
	
	public ArrayList<teamInfoVO> getTeamInfo(teamCondition tc);//��ѯ�������
	
	public ArrayList<playerInfoVO> getPlayerInfo(playerCondition pc);//��ѯ������Ա
	
	public ArrayList<teamInfoVO> sortTeam(ArrayList<teamInfoVO> original ,String s );//�������������Ϣ
}
