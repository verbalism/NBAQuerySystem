package presentation;

import vo.TeamVO;

public class test {
	public static void main(String args[]){
		TeamVO team = new TeamVO();
		team.setTeamName("ATL");
		new TeamInfoFrame(team);
	}
}
