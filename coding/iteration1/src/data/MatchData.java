package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import po.MatchInfoPO;
import po.MatchPlayer;
import po.MatchTeam;
import dataservice.MatchDataService;

public class MatchData implements MatchDataService{
	public ArrayList<MatchInfoPO> getMatchOriginal() {
		ArrayList<MatchInfoPO> allMatches = new ArrayList<MatchInfoPO>();
		
		String Dpath="Data\\matches";
		File f = new File(Dpath);
		String[] filelist = f.list();
		for(int i=0; i<filelist.length; i++){
			File readfile = new File(Dpath+"\\"+filelist[i]);
			try {
				ArrayList<String> wtf = new ArrayList<String>();
				InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
				BufferedReader br = new BufferedReader( read);
				for(String s = br.readLine();s != null; s = br.readLine()){
					wtf.add(s);
				}
				br.close();
				
				MatchInfoPO oneMatch = new MatchInfoPO();
				oneMatch.setMatchTime(wtf.get(0).split(";")[0]);
				oneMatch.setTeams(wtf.get(0).split(";")[1]);
				oneMatch.setScore(wtf.get(0).split(";")[2]);
				oneMatch.setScore1(wtf.get(1).split(";")[0]);oneMatch.setScore2(wtf.get(1).split(";")[1]);oneMatch.setScore3(wtf.get(1).split(";")[2]);oneMatch.setScore4(wtf.get(1).split(";")[3]);
				int index=3;
				while(wtf.get(index).split(";").length>1)
					index++;
				MatchTeam team1 = getTeamInfo(wtf,2,index-1);
				MatchTeam team2 = getTeamInfo(wtf,index,wtf.size()-1);
				oneMatch.setTeam1(team1);
				oneMatch.setTeam2(team2);
				
				allMatches.add(oneMatch);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return allMatches;
	}
	
	public static MatchTeam getTeamInfo(ArrayList<String> list, int start, int end){
		MatchTeam team = new MatchTeam();
		team.setTeamName(list.get(start));
		for(int i=start+1;i<=end;i++){
			String wtf[] = list.get(i).split(";");
			MatchPlayer player = new MatchPlayer();
			player.setPlayerName(wtf[0]);
			player.setPosition(wtf[1]);
			player.setMatchTime(wtf[2]);
			player.setFieldGoal(Integer.parseInt(wtf[3]));
			player.setFieldGoalAttempts(Integer.parseInt(wtf[4]));
			player.setThreePointShot(Integer.parseInt(wtf[5]));
			player.setThreePointAttempts(Integer.parseInt(wtf[6]));
			player.setFreeThrowGoal(Integer.parseInt(wtf[7]));
			player.setFreeThrowAttempts(Integer.parseInt(wtf[8]));
			player.setOffensiveRebound(Integer.parseInt(wtf[9]));
			player.setDefensiveRebound(Integer.parseInt(wtf[10]));
			player.setRebound(Integer.parseInt(wtf[11]));
			player.setAssist(Integer.parseInt(wtf[12]));
			player.setST(Integer.parseInt(wtf[13]));
			player.setBlockShot(Integer.parseInt(wtf[14]));
			player.setError(Integer.parseInt(wtf[15]));
			player.setFoul(Integer.parseInt(wtf[16]));
			player.setScore(Integer.parseInt(wtf[17]));
			team.addPlayer(player);
		}
		return team;
	}

}
