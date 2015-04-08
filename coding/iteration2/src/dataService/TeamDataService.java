package dataService;

import java.util.ArrayList;

import po.TeamPO;

public interface TeamDataService {
	public TeamPO getSingleTeamInfo(String teamName);
	
	public ArrayList<TeamPO> getAllTeamInfo();
}
