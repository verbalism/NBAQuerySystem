package dataService;

import java.util.ArrayList;

import po.TeamPO;

public interface TeamDataService {
	public TeamPO getSingleTeamInfo(String teamName,String season);//��õ��������Ϣ���������
	
	public ArrayList<TeamPO> getAllTeamInfo(String season);//��ȡ���������Ϣ������arraylist
	
	//public void updateAllTeam();//�������������Ϣ
}
