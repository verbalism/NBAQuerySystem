package dataService;

import java.util.ArrayList;

import po.TeamPO;

public interface TeamDataService {
	public TeamPO getSingleTeamInfo(String teamName);//获得单个球队信息根据球队名
	
	public ArrayList<TeamPO> getAllTeamInfo();//获取所有球队信息。返回arraylist
	
	public void updateAllTeam();//更新所有球队信息
}
