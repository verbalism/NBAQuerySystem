package com.nba;

import java.io.PrintStream;
import java.util.ArrayList;

import businesslogic.AnalysisBL;
import businesslogicService.AnalysisBLService;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import vo.PlayerAge;
import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
import vo.SortType;
import vo.TeamVO;
import vo.TodayPlayerVO;
import de.tototec.cmdoption.*;
public class Console {
	public  void execute(PrintStream out,String[] args) {
		Config config = new Config();
		Player player = new Player();
		Team team = new Team();
		CmdlineParser cp;
		AnalysisBLService abl = new AnalysisBL();
		int j=0;
		if(args[0].equals("-player")){
			cp = new CmdlineParser(new Object[] { player});
		}
		else if(args[0].equals("-team")){
			cp = new CmdlineParser(new Object[] { team});
		}
		else
			cp = new CmdlineParser(new Object[] {config});
		while(j<args.length){
			if(args[j].equals("--datasourse")){
				cp.parse(args[j],args[j+1]);
				j++;
			}
			else if(args[j].equals("-player")||args[j].equals("-team")){
				
			}
			else if(args[j].equals("-n")){
				cp.parse(new String[]{args[j],args[j+1]});
				j++;
			}
			else if(args[j].equals("-fliter")||args[j].equals("-sort")||args[j].equals("-king")||args[j].equals("-hots")){
				cp.parse(new String[]{args[j],args[j+1]});
				j++;
			}
			else{
				
				cp.parse(args[j]);
			}
			j++;
		}
			
		if(args[0].equals("-player")){
			ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
			String keyword="";
			/**热点球员*/
			if(player.kingPlayers){	
				PlayerKingInfo king = new PlayerKingInfo();
				if(player.seasonKing){
					if(player.superField.equals("score"))
						keyword = "points";
					if(player.superField.equals("rebound"))
						keyword = "rebounds";
					if(player.superField.equals("assist"))
						keyword = "assists";
					players = abl.getSeasonHotSpotPlayer(keyword);
					for(int k=0;k<players.size();k++){
						king.setField(player.superField);
						king.setName(players.get(k).getPlayerName());
						king.setPosition(players.get(k).getPosition());
						king.setTeamName(players.get(k).getTeamName());
						if(player.superField.equals("score"))
							king.setValue(players.get(k).getPoints());
						if(player.superField.equals("rebound"))
							king.setValue(players.get(k).getRebounds());
						if(player.superField.equals("assist"))
							king.setValue(players.get(k).getAssists());

						out.print(king.toString());	
					}		
				}
				if(player.dailyKing){
					ArrayList<TodayPlayerVO> tdplayers = new ArrayList<TodayPlayerVO>();
					keyword = player.superField;
					tdplayers = abl.getTodayHotSpotPlayer(keyword);
					for(int k=0;k<tdplayers.size();k++){
						king.setField(player.superField);
						king.setName(tdplayers.get(k).getPlayerName());
						king.setPosition(tdplayers.get(k).getPosition());
						king.setTeamName(tdplayers.get(k).getTeamName());
						if(player.superField.equals("score"))
							king.setValue(tdplayers.get(k).getScore());
						if(player.superField.equals("rebound"))
							king.setValue(tdplayers.get(k).getRebound());
						if(player.superField.equals("assist"))
							king.setValue(tdplayers.get(k).getAssist());
						out.print(king.toString());
					}
				}
			}
			/**进步最快球员*/
			else if(player.hotPlayers){
				PlayerHotInfo hotPlayer = new PlayerHotInfo();
				if(player.superField.equals("score"))
					keyword = "increaseOfPoints";
				if(player.superField.equals("rebound"))
					keyword = "increaseOfRebounds";
				if(player.superField.equals("assist"))
					keyword = "increaseOfAssists";
				players = abl.getProgressivePlayer(keyword);
				for(int k=0;k<players.size();k++){
					hotPlayer.setField(player.superField);
					hotPlayer.setName(players.get(k).getPlayerName());
					hotPlayer.setPosition(players.get(k).getPosition());
					hotPlayer.setTeamName(players.get(k).getTeamName());
					if(keyword=="points")
						hotPlayer.setValue(players.get(k).getIncreaseOfPoints());
					if(keyword=="rebounds")
						hotPlayer.setValue(players.get(k).getIncreaseOfRebounds());
					if(keyword=="assists")
						hotPlayer.setValue(players.get(k).getIncreaseOfAssists());
					out.print(hotPlayer.toString());
				}
			}
			/**筛选全部球员*/
			else if(player.allPlayers){
				String[] field ;
				SortType[] type ;
				if(player.getSortField){
					field = player.sortFields;
					type = player.sortType;
				}
				else if(player.highData){
					field = new String[]{"trueShootingPercentage"};				
					type = new SortType[]{SortType.Descending};
				}
			
				else{
					field = new String[]{"points"};
					type = new SortType[]{SortType.Descending};
				}
				players = abl.getTopNPlayers(player.n, player.position, player.league, player.age, field, type);
					
				if(player.highData){
					for(int k=0;k<players.size();k++){
						PlayerHighInfo highPlayer = new PlayerHighInfo();
						highPlayer.setAssistEfficient(players.get(k).getAssisyRating());
						highPlayer.setBlockShotEfficient(players.get(k).getBlockRating());
						highPlayer.setDefendReboundEfficient(players.get(k).getDefensiveReboundRating());
						highPlayer.setFaultEfficient(players.get(k).getTurnoverRating());
						highPlayer.setFrequency(players.get(k).getUtilizationRating());
						highPlayer.setGmSc(players.get(k).getGmSc());
						highPlayer.setLeague(players.get(k).getLeague());
						highPlayer.setName(players.get(k).getPlayerName());
						highPlayer.setOffendReboundEfficient(players.get(k).getOffensiveReboundRating());
						highPlayer.setPosition(players.get(k).getPosition());
						highPlayer.setRealShot(players.get(k).getTrueShootingPercentage());	
						highPlayer.setReboundEfficient(players.get(k).getReboundRating());
						highPlayer.setShotEfficient(players.get(k).getShootingEfficiency());
						highPlayer.setStealEfficient(players.get(k).getStealRating());
						highPlayer.setTeamName(players.get(k).getTeamName());
						
						out.print(highPlayer.toString());						
					}
				}
				else{
					if(!player.avgValue){
						for(int k=0;k<players.size();k++){
							PlayerNormalInfo normal = new PlayerNormalInfo();
							normal.setAge(Integer.parseInt(players.get(k).getAge()));
							normal.setName(players.get(k).getPlayerName());
							normal.setTeamName(players.get(k).getTeamName());
							normal.setPenalty(players.get(k).getFreeThrowsPercentage());
							normal.setShot(players.get(k).getFieldGoalsPercentage());
							normal.setThree(players.get(k).getThreePointFieldGoalsPercentage());
							normal.setAssist(players.get(k).getAssists());
							normal.setBlockShot(players.get(k).getBlocks());
							normal.setDefend(players.get(k).getDefensiveRebounds());
							normal.setEfficiency(players.get(k).getEfficiency());
							normal.setFault(players.get(k).getTurnovers());
							normal.setFoul(players.get(k).getFouls());
							normal.setMinute(players.get(k).getMinutes2());
							normal.setNumOfGame(players.get(k).getGamesPlayed());
							normal.setOffend(players.get(k).getOffensiveRebounds());
							normal.setPoint(players.get(k).getPoints());
							normal.setRebound(players.get(k).getRebounds());
							normal.setStart(players.get(k).getGamesStarting());
							normal.setSteal(players.get(k).getSteals());
							
							out.print(normal.toString());
						}
					}
					else{
						for(int k=0;k<players.size();k++){
							PlayerNormalInfo normal = new PlayerNormalInfo();
							normal.setAge(Integer.parseInt(players.get(k).getAge()));
							normal.setName(players.get(k).getPlayerName());
							normal.setTeamName(players.get(k).getTeamName());
							normal.setPenalty(players.get(k).getFreeThrowsPercentage());
							normal.setShot(players.get(k).getFieldGoalsPercentage());
							normal.setThree(players.get(k).getThreePointFieldGoalsPercentage());
							normal.setAssist(players.get(k).getAssists()/players.get(k).getGamesPlayed());
							normal.setBlockShot(players.get(k).getBlocks()/players.get(k).getGamesPlayed());
							normal.setDefend(players.get(k).getDefensiveRebounds()/players.get(k).getGamesPlayed());							
							normal.setEfficiency(players.get(k).getEfficiency());
							normal.setFault(players.get(k).getTurnovers()/players.get(k).getGamesPlayed());
							normal.setFoul(players.get(k).getFouls()/players.get(k).getGamesPlayed());
							normal.setMinute(players.get(k).getMinutes2()/players.get(k).getGamesPlayed());
							normal.setNumOfGame(players.get(k).getGamesPlayed()/players.get(k).getGamesPlayed());
							normal.setOffend(players.get(k).getOffensiveRebounds()/players.get(k).getGamesPlayed());
							normal.setPoint(players.get(k).getPoints()/players.get(k).getGamesPlayed());
							normal.setRebound(players.get(k).getRebounds()/players.get(k).getGamesPlayed());
							normal.setStart(players.get(k).getGamesStarting()/players.get(k).getGamesPlayed());
							normal.setSteal(players.get(k).getSteals()/players.get(k).getGamesPlayed());
						
							out.print(normal.toString());
						}
					}
				}
			}
		}
			
		if(args[0].equals("-team")){
			ArrayList<TeamVO> teams = new ArrayList<TeamVO>();
			String keyword="";
			/**热点球队*/
			if(team.hotTeams){
				if(team.superField.equals("score"))
					keyword = "points";
				if(team.superField.equals("rebound")||team.superField.equals("assist")||team.superField.equals("steal")||team.superField.equals("foul"))
					keyword=team.superField+"s";
				if(team.superField.equals("blockShot"))
					keyword="blocks";
				if(team.superField.equals("fault"))
					keyword="turnovers";
				if(team.superField.equals("shot"))
					keyword="fieldGoalPercentage";
				if(team.superField.equals("three"))
					keyword="threePointFieldGoalPercentage";
				if(team.superField.equals("penalty"))
					keyword="freeThrowPercentage";
				if(team.superField.equals("defendRebound"))
					keyword="defensiveRebounds";
				if(team.superField.equals("offendRebound"))
					keyword="offensiveRebounds";
				
				teams = abl.getSeasonHotSpotTeam(keyword);
				for(int k=0;k<teams.size();k++){
					TeamHotInfo hotTeam = new TeamHotInfo();
					hotTeam.setField(team.superField);
					if(teams.get(k).getZone().equals("W"))
						hotTeam.setLeague("West");
					else
						hotTeam.setLeague("East");
					hotTeam.setTeamName(teams.get(k).getTeamName());
					if(team.superField.equals("score"))
						hotTeam.setValue(teams.get(k).getPoints());
					if(team.superField.equals("rebound"))
						hotTeam.setValue(teams.get(k).getRebounds());
					if(team.superField.equals("assist"))
						hotTeam.setValue(teams.get(k).getAssists());
					if(team.superField.equals("steal"))
						hotTeam.setValue(teams.get(k).getSteals());
					if(team.superField.equals("foul"))
						hotTeam.setValue(teams.get(k).getFouls());
					if(team.superField.equals("blockShot"))
						hotTeam.setValue(teams.get(k).getBlocks());
					if(team.superField.equals("fault"))
						hotTeam.setValue(teams.get(k).getTurnovers());
					if(team.superField.equals("shot"))
						hotTeam.setValue(teams.get(k).getFieldGoalPercentage());
					if(team.superField.equals("three"))
						hotTeam.setValue(teams.get(k).getThreePointFieldGoalPercentage());
					if(team.superField.equals("penalty"))
						hotTeam.setValue(teams.get(k).getFreeThrowPercentage());
					if(team.superField.equals("defendRebound"))
						hotTeam.setValue(teams.get(k).getDefensiveRebounds());
					if(team.superField.equals("offendRebound"))
						hotTeam.setValue(teams.get(k).getOffensiveRebounds());
					
					out.print(hotTeam.toString());
				}
			}
			/**筛选所有球队并输出*/
			else{
				Object[][] field = new Object[1][2];
				if(team.getSortField){
					field = team.sortField;
				}
				else if(team.highData)
					field = new Object[][]{{"winPercentage",SortType.Descending}};
				else
					field = new Object[][]{{"points",SortType.Descending}};
				
				teams = abl.getTopNTeams(team.n, (String) field[0][0],(SortType) field[0][1]);
				
				if(team.highData){
					for(int k=0;k<teams.size();k++){
						TeamHighInfo highTeam = new TeamHighInfo();
						highTeam.setTeamName(teams.get(k).getTeamName());
						highTeam.setAssistEfficient(teams.get(k).getAssistPercentage());
						highTeam.setDefendEfficient(teams.get(k).getDefensiveRating());
						highTeam.setDefendReboundEfficient(teams.get(k).getDefensiveReboundPercentage());
						highTeam.setOffendEfficient(teams.get(k).getOffensiveRating());
						highTeam.setOffendReboundEfficient(teams.get(k).getOffensiveReboundPercentage());
						highTeam.setStealEfficient(teams.get(k).getStealPercentage());
						highTeam.setWinRate(teams.get(k).getWinPercentage());
						if(!team.avgValue)
							highTeam.setOffendRound(teams.get(k).getPossessions());
						else
							highTeam.setOffendRound(teams.get(k).getPossessions()/teams.get(k).getGamesPlayed());
						
						out.print(highTeam.toString());
					}
				}
				else{
					if(!team.avgValue){
						for(int k=0;k<teams.size();k++){
							TeamNormalInfo normalTeam = new TeamNormalInfo();
							normalTeam.setTeamName(teams.get(k).getTeamName());
							normalTeam.setPenalty(teams.get(k).getFreeThrowPercentage());
							normalTeam.setShot(teams.get(k).getFieldGoalPercentage());
							normalTeam.setThree(teams.get(k).getThreePointFieldGoalPercentage());
							normalTeam.setAssist(teams.get(k).getAssists());
							normalTeam.setBlockShot(teams.get(k).getBlocks());
							normalTeam.setDefendRebound(teams.get(k).getDefensiveRebounds());
							normalTeam.setFault(teams.get(k).getTurnovers());
							normalTeam.setFoul(teams.get(k).getFouls());
							normalTeam.setNumOfGame(teams.get(k).getGamesPlayed());
							normalTeam.setOffendRebound(teams.get(k).getOffensiveRebounds());
							normalTeam.setPoint(teams.get(k).getPoints());
							normalTeam.setRebound(teams.get(k).getRebounds());
							normalTeam.setSteal(teams.get(k).getSteals());
							
							out.print(normalTeam.toString());
						}
					}
					else{
						for(int k=0;k<teams.size();k++){
							TeamNormalInfo normalTeam = new TeamNormalInfo();
							normalTeam.setTeamName(teams.get(k).getTeamName());
							normalTeam.setPenalty(teams.get(k).getFreeThrowPercentage());	
							normalTeam.setShot(teams.get(k).getFieldGoalPercentage());
							normalTeam.setThree(teams.get(k).getThreePointFieldGoalPercentage());
							normalTeam.setAssist(teams.get(k).getAssists()/teams.get(k).getGamesPlayed());
							normalTeam.setBlockShot(teams.get(k).getBlocks()/teams.get(k).getGamesPlayed());
							normalTeam.setDefendRebound(teams.get(k).getDefensiveRebounds()/teams.get(k).getGamesPlayed());
							normalTeam.setFault(teams.get(k).getTurnovers()/teams.get(k).getGamesPlayed());
							normalTeam.setFoul(teams.get(k).getFouls()/teams.get(k).getGamesPlayed());
							normalTeam.setNumOfGame(teams.get(k).getGamesPlayed()/teams.get(k).getGamesPlayed());
							normalTeam.setOffendRebound(teams.get(k).getOffensiveRebounds()/teams.get(k).getGamesPlayed());
							normalTeam.setPoint(teams.get(k).getPoints()/teams.get(k).getGamesPlayed());
							normalTeam.setRebound(teams.get(k).getRebounds()/teams.get(k).getGamesPlayed());
							normalTeam.setSteal(teams.get(k).getSteals()/teams.get(k).getGamesPlayed());
							
							out.print(normalTeam.toString());
						}
					}
				}
			}
				
		}
			
	}
}

class Config {
	@CmdOption(names = { "--datasourse"}, args = {"sourse"}, description = "set data")
	public void setData(String sourse){
		//AnalysisBLService abl = new AnalysisBL();
		//abl.getData(sourse);
		System.out.println(sourse);
	}
}

//@CmdCommand(names = { "-player" }, description = "player mode")
class Player {
	int n = 50;
	boolean avgValue = true;
	boolean allPlayers = true;
	boolean kingPlayers = false;
	boolean hotPlayers = false;
	boolean highData = false;
	boolean getSortField = false;
	boolean seasonKing = false;
	boolean dailyKing = false;
	PlayerPartition league = PlayerPartition.All;
	PlayerPosition position = PlayerPosition.All;
	PlayerAge age = PlayerAge.all;
	String superField;
	String[] sortFields;
	SortType[] sortType;
	@CmdOption(names = { "-total" }, description = "show total", conflictsWith = {"-avg"})
	public void setShowTotal() {
		this.avgValue = false;
	}
	@CmdOption(names = {"-avg"}, description = "show average", conflictsWith = {"-total"})
	public void setAvg(){
		this.avgValue = true;
	}
	@CmdOption(names = {"-all"},description = "show all players", conflictsWith = {"-king","-hot"})
	public void setAll(){
		this.allPlayers = true;
	}
	@CmdOption(names = {"-season"},description = "show season king", conflictsWith = {"-daily"})
	public void setSeason(){
		this.seasonKing = true;
		this.allPlayers = false;
	}
	@CmdOption(names = {"-daily"},description = "show all players", conflictsWith = {"-season"})
	public void setDaily(){
		this.dailyKing = true;
		this.allPlayers = false;
	}
	@CmdOption(names = {"-king"}, args = {"field"}, description = "show king players", conflictsWith = {"-all","-hot","-avg","-total","-sort"})
	public void setKing(String field){
		this.kingPlayers = true;
		this.allPlayers = false;
		this.hotPlayers = false;
		superField = field;
	}
	@CmdOption(names = {"-hot"}, args = {"field"}, description = "show hot players", conflictsWith = {"-all","-king","-avg","-total","-sort"})
	public void setHot(String field){
		this.hotPlayers = true;
		this.allPlayers = false;
		this.kingPlayers = false;
		superField = field;
	}
	@CmdOption(names = {"-high"}, description = "show high data")
	public void setHigh(){
		this.highData = true;
	}
	@CmdOption(names = {"-n"}, args = {"num"}, description = "set num of players")
	public void setNum(String num) {
		this.n = Integer.parseInt(num);
	}
	@CmdOption(names = {"-fliter"}, args = {"field"}, description = "set fliter")
	public void setFliter(String field){
		String[] temp = field.split(",");
		for(int i=0;i<temp.length;i++){
			String f = temp[i].split(".")[0];
			String value = temp[i].split(".")[1];
			if(f.equals("position")){
				switch(value){
				case "F":
					this.position = PlayerPosition.Forward;
					break;
				case "G":
					this.position = PlayerPosition.Guard;
					break;
				case "C":
					this.position = PlayerPosition.Center;
					break;
				case "All":
					this.position = PlayerPosition.All;
					break;
				default:
					break;
				}
			}
			else if(f.equals("league")){
				switch(value){
				case "West":
					this.league = PlayerPartition.West;
					break;
				case "East":
					this.league = PlayerPartition.East;
					break;
				case "All":
					this.league = PlayerPartition.All;
					break;
				default:
					break;
				}
			}
			else if(f.equals("age")){
				switch(value){
				case "<=22":
					this.age = PlayerAge.lessthan23;
					break;
				case "22<X<=25":
					this.age = PlayerAge.from23to25;
					break;
				case "25<X<=30":
					this.age = PlayerAge.from26to30;
					break;
				case ">30":
					this.age = PlayerAge.morethan30;
					break;
				case "All":
					this.age = PlayerAge.all;
					break;
				default:
					this.age = PlayerAge.all;
					break;
				}
			}
		}
	}
	@CmdOption(names = {"-sort"}, args = {"field"}, description = "set sort filed")
	public void setSort(String field){
		this.getSortField = true;
		String[] temp = field.split(",");
		sortFields = new String[temp.length];
		sortType = new SortType[temp.length];
		for(int i=0;i<temp.length;i++){
			String f = temp[i].split(".")[0];
			if(f.equals("point")||f.equals("rebound")||f.equals("assist")||f.equals("steal")||f.equals("foul")||f.equals("minute"))
				f=f+"s";
			if(f.equals("blockShot"))
				f="blocks";
			if(f.equals("fault"))
				f="turnovers";
			if(f.equals("efficient"))
				f="efficiency";
			if(f.equals("shot"))
				f="fieldGoalsPercentage";
			if(f.equals("three"))
				f="threePointFieldGoalsPercentage";
			if(f.equals("penalty"))
				f="freeThrowsPercentage";
			if(f.equals("doubleTwo"))
				f="doubleDouble";
			if(f.equals("realShot"))
				f="trueShootingPercentage";
			if(f.equals("GmSc"))
				f="GmSc";
			if(f.equals("shotEfficient"))
				f="shootingEfficiency";
			if(f.equals("reboundEfficient"))
				f="reboundRating";
			if(f.equals("offendReboundEfficient"))
				f="offensiveReboundRating";
			if(f.equals("defendReboundEfficient"))
				f="defensiveReboundRating";
			if(f.equals("assistEfficient"))
				f="assisyRating";
			if(f.equals("stealEfficient"))
				f="stealRating";
			if(f.equals("blockShotEfficient"))
				f="blockRating";
			if(f.equals("faultEfficient"))
				f="turnoverRating";
			if(f.equals("frequency"))
				f="utilizationRating";
			
			sortFields[i] = f;
			String type = temp[i].split(".")[1];
			switch(type){
			case "desc":
				sortType[i] = SortType.Descending;
				break;
			case "asc":
				sortType[i] = SortType.Ascending;
				break;
			default:
				sortType[i] = SortType.Descending;
				break;
			}
		}
	}
}

//@CmdCommand(names = { "-team" }, description = "team mode")
class Team{
	int n = 30;
	boolean avgValue = true;
	boolean allTeams = true;
	boolean hotTeams = false;
	boolean highData = false;
	boolean getSortField = false;
	String superField;
	Object sortField[][];
	@CmdOption(names = { "-total" }, description = "show total", conflictsWith = {"-avg"})
	public void setShowTotal() {
		this.avgValue = false;
	}
	@CmdOption(names = {"-avg"}, description = "show average", conflictsWith = {"-total"})
	public void setAvg(){
		this.avgValue = true;
	}
	@CmdOption(names = {"-all"},description = "show all teams", conflictsWith = {"-hot"})
	public void setAll(){
		this.allTeams = true;
		
	}
	@CmdOption(names = {"-hot"}, args = {"field"}, description = "show hot teams", conflictsWith = {"-all","-avg","-total","-sort"})
	public void setHot(String field){
		this.hotTeams = true;
		this.allTeams = false;
		superField = field;
	}
	@CmdOption(names = {"-high"}, description = "show high data")
	public void setHigh(){
		this.highData = true;
	}
	@CmdOption(names = {"-n"}, args = {"num"}, description = "set num of players")
	public void setNum(String num) {
		this.n = Integer.parseInt(num);
	}
	@CmdOption(names = {"-sort"}, args = {"field"}, description = "set sort filed")
	public void setSort(String field){
		this.getSortField = true;
		sortField = new Object[1][2];
		String type = field.split(".")[1];
		switch(type){
		case "desc":
			sortField[0][1] = SortType.Descending;
			break;
		case "asc":
			sortField[0][1] = SortType.Ascending;
			break;
		default:
			sortField[0][1] = SortType.Descending;
			break;
		}
		String f = field.split(".")[0];
		if(f.equals("point")||f.equals("rebound")||f.equals("assist")||f.equals("steal")||f.equals("foul"))
			f=f+"s";
		if(f.equals("blockShot"))
			f="blocks";
		if(f.equals("fault"))
			f="turnovers";
		if(f.equals("shot"))
			f="fieldGoalPercentage";
		if(f.equals("three"))
			f="threePointFieldGoalPercentage";
		if(f.equals("penalty"))
			f="freeThrowPercentage";
		if(f.equals("defendRebound"))
			f="defensiveRebounds";
		if(f.equals("offendRebound"))
			f="offensiveRebounds";
		if(f.equals("winRate"))
			f="winPercentage";
		if(f.equals("offendRound"))
			f="possessions";
		if(f.equals("offendEfficient"))
			f="offensiveRating";
		if(f.equals("defendEfficient"))
			f="defensiveRating";
		if(f.equals("offendReboundEfficient"))
			f="offensiveReboundPercentage";
		if(f.equals("defendReboundEfficient"))
			f="defensiveReboundPercentage";
		if(f.equals("assistEfficient"))
			f="assistPercentage";
		if(f.equals("stealEfficient"))
			f="stealPercentage";
		sortField[0][0] = f;
	}
	
}