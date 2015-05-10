package businesslogicService;

import java.util.ArrayList;

import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;

public interface DataBLService {
	public PlayerVO getSinglePlayerInfo (String playerName);
	public ArrayList<PlayerVO> getAllPlayerInfo ();
	public MatchVO getSingleMatchInfo(String matchDate, String team);
	public ArrayList<MatchVO> findMatchByPlayer (String playerName);
	public ArrayList<MatchVO> findMatchByTeam (String teamName);
	public ArrayList<MatchVO> findMatchByDate (String matchDate);	
	public TeamVO getSingleTeamInfo(String teamName);
	public ArrayList<TeamVO> getAllTeamInfo();
}
