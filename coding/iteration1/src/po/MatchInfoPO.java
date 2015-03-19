package po;

import java.util.ArrayList;

public class MatchInfoPO {
	private String matchTime;			//比赛时间
	private String teams;				//对阵队伍
	private String score;				//总比分
	private String score_1,score_2, score_3, score_4;	//各小节比分
	private ArrayList<String> extraScores;
	private MatchTeam team1, team2;
	
	public void setExtraScores(ArrayList<String> s){
		this.extraScores = s;
	}
	public ArrayList<String> getExtreaScores(){
		return extraScores;
	}
	public void setMatchTime(String t){
		this.matchTime = t;
	}
	public String getMatchTime(){
		return matchTime;
	}
	public void setTeams(String t){
		this.teams = t;
	}
	public String getTeams(){
		return teams;
	}
	public void setScore(String s){
		this.score = s;
	}
	public String getScore(){
		return score;
	}
	public void setScore1(String s){
		this.score_1 = s;
	}
	public String getScore1(){
		return score_1;
	}
	public void setScore2(String s){
		this.score_2 = s;
	}
	public String getScore2(){
		return score_2;
	}
	public void setScore3(String s){
		this.score_3 = s;
	}
	public String getScore3(){
		return score_3;
	}
	public void setScore4(String s){
		this.score_4 = s;
	}
	public String getScore4(){
		return score_4;
	}
	public void setTeam1(MatchTeam t){
		this.team1 = t;
	}
	public MatchTeam getTeam1(){
		return team1;
	}
	public void setTeam2(MatchTeam t){
		this.team2 = t;
	}
	public MatchTeam getTeam2(){
		return team2;
	}
}
