package dataService;

import java.util.ArrayList;

import po.TeamPO;

public interface TeamDataService {
	public TeamPO getSingleTeamInfo(String teamName);//��õ��������Ϣ���������
	
	public ArrayList<TeamPO> getAllTeamInfo();//��ȡ���������Ϣ������arraylist
	
	public void updateAllTeam();//�������������Ϣ
}
