package businesslogicService;

import java.util.ArrayList;

import vo.MatchVO;
import vo.PlayerAge;
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
	public void updateData();//更新数据
	ArrayList<PlayerVO> getTopNPlayers(int n, PlayerPosition position, PlayerPartition partition, PlayerAge age, String[] keyword,SortType[] sorttype);
	void getData(String dataSourse);
	ArrayList<TeamVO> getTopNTeams(int n, String keyword, SortType type);
}
