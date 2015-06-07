package dataService;

import java.util.ArrayList;

import po.MatchPO;

public interface MatchDataService {
	public MatchPO getSingleMatchInfo(String teamName,String date,String season);//���ݶ����ͱ���ʱ���ȡ������Ϣmatchpo
	
	public ArrayList<MatchPO> getAllMatchInfo(String season);//��ȡ���б�����Ϣ
	
	public ArrayList<MatchPO> getTeamRecentMatchInfo(int number,String teamName);//��ȡ������������numberΪ����������teamNameΪ����
	
	public ArrayList<MatchPO> getPlayerRecentMatchInfo(int number,String playerName);//��ȡ��Ա���������numberΪ����������playernameΪ��Ա��
	
	public String getDate();//��ȡ���ݿ��� ���һ������ʱ��
	
	public ArrayList<MatchPO> getTodayMatchInfo(String date,String season);//��ȡĳ�ձ�����ʱ��
	
	//public void updateMatchInfo();//���±�����Ϣ
}
