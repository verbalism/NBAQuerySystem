package businesslogicService;

import java.util.ArrayList;

import vo.MatchVO;
import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
import vo.SortType;
import vo.TeamVO;
import vo.TodayPlayerVO;

public interface AnalysisBLService {
	public ArrayList<PlayerVO> sortPlayer (ArrayList<PlayerVO> playerlist, String keyword, SortType type);
	public ArrayList<TeamVO> sortTeam(ArrayList<TeamVO> teamlist, String keyword, SortType type);
	public ArrayList<PlayerVO> getTopFiftyPlayer (PlayerPosition position, PlayerPartition partition, String keyword);
	public ArrayList<TodayPlayerVO> getTodayHotSpotPlayer (String keyword);
	public ArrayList<PlayerVO> getSeasonHotSpotPlayer (String keyword);
	public ArrayList<TeamVO> getSeasonHotSpotTeam (String keyword);
	public ArrayList<PlayerVO> getProgressivePlayer (String keyword);
	public ArrayList<MatchVO> getTodayMatch ();
}
