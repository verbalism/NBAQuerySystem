package businesslogicService;

import java.util.ArrayList;

import vo.MatchVO;
import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
import vo.ScoreWay;
import vo.TeamType;
import vo.TeamVO;
import vo.TodayPlayerVO;

public interface AnalysisBLService {
	public ArrayList<PlayerVO> getTopFiftyPlayer (PlayerPosition position, PlayerPartition partition, String keyword,String season);//Season示例14_15;14_15_after
	public ArrayList<TodayPlayerVO> getTodayHotSpotPlayer (String keyword);
	public ArrayList<PlayerVO> getSeasonHotSpotPlayer (String keyword,String season);
	public ArrayList<TeamVO> getSeasonHotSpotTeam (String keyword,String season);
	public ArrayList<PlayerVO> getProgressivePlayer (String keyword,String season);
	public ArrayList<MatchVO> getTodayMatch ();
	public double getScoreAnalysis (String teamName,String season,ScoreWay scoreWay );//teamName为缩写，下同
	public String getHighestScoringPlayer (String teamName,String season,ScoreWay scoreWay );
	public TeamType getTeamType(String teamName,String season );
	public String getBestOffensivePlayer(String teamName,String season );
	public String getTheMostPotentialOffensivePlayer(String teamName,String season );
	public String getBestDefensivePlayer(String teamName,String season );
	public String getTheMostPotentialDefensivePlayer(String teamName,String season );
	public void updateData();//更新数据
	
}
