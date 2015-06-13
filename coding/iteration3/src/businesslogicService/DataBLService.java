package businesslogicService;

import java.util.ArrayList;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;

public interface DataBLService {
	public PlayerVO getSinglePlayerInfo (String playerName,String season);//��ȡ������������Ա��Ϣ
	public TeamVO getSingleTeamInfo(String teamName,String season);//��ȡ���������������Ϣ
	public ArrayList<PlayerVO> getAllPlayerInfo (String season);//��ȡ������������Ա��Ϣ
	public MatchVO getSingleMatchInfo(String matchDate, String team,String season);//ͨ������������Ӻ�������ȡ������Ϣ  mathDateʾ��01-01;��ͬ
	public ArrayList<MatchVO> findMatchByPlayer (String playerName);//���Ҹ���Ա���������峡�������������峡����������Ϣ
	public ArrayList<MatchVO> findMatchByTeam (String teamName);//���Ҹ���ӵ�����峡�������������峡����������Ϣ
	public ArrayList<MatchVO> findMatchByDate (String matchDate,String season);//ͨ�����ڻ�ȡ������Ϣ
	public ArrayList<TeamVO> getAllTeamInfo(String season);//��ȡ���������������Ϣ
}
