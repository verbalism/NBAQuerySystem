package businesslogicService;

import java.util.ArrayList;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;

public interface DataBLService {
	public PlayerVO getSinglePlayerInfo (String playerName,String season);//获取该赛季单个球员信息
	public TeamVO getSingleTeamInfo(String teamName,String season);//获取该赛季单个球队信息
	public ArrayList<PlayerVO> getAllPlayerInfo (String season);//获取该赛季所有球员信息
	public MatchVO getSingleMatchInfo(String matchDate, String team,String season);//通过比赛日期球队和赛季获取比赛信息  mathDate示例01-01;下同
	public ArrayList<MatchVO> findMatchByPlayer (String playerName);//查找该球员参与的最近五场比赛，返回这五场比赛所有信息
	public ArrayList<MatchVO> findMatchByTeam (String teamName);//查找该球队的最近五场比赛，返回这五场比赛所有信息
	public ArrayList<MatchVO> findMatchByDate (String matchDate,String season);//通过日期获取比赛信息
	public ArrayList<TeamVO> getAllTeamInfo(String season);//获取该赛季所有球队信息
}
