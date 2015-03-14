package dataservice;

import java.util.ArrayList;

import po.TeamInfoPO;

public interface TeamDataService {
	public ArrayList<TeamInfoPO> getTeamOriginal() ;
	public TeamInfoPO getSingleTeamOriginal (String teamName);
}
