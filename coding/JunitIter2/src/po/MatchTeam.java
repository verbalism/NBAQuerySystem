package po;

import java.util.ArrayList;

public class MatchTeam {
	private String teamName;
	private ArrayList<MatchPlayer> players = new ArrayList<MatchPlayer>();

	public void setTeamName(String n){
		this.teamName = n;
	}
	public String getTeamName(){
		return teamName;
	}
	
	public void setPlayers(ArrayList<MatchPlayer> p){
		this.players = p;
	}
	public ArrayList<MatchPlayer> getPlayers(){
		return players;
	}
	public void addPlayer(MatchPlayer p){
		this.players.add(p);
	}
}
