package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;

public class BasicMatchData {

	public ArrayList<MatchPO> getMatchOriginal() {
		BasicMatchData bmd=new BasicMatchData();
		ArrayList<MatchPO> allMatches = new ArrayList<MatchPO>();
		String path=bmd.getPath();
		String Dpath=path+"\\matches\\";
		File f = new File(Dpath);
		String[] filelist = f.list();
		for(int i=0; i<filelist.length; i++){
			
			File readfile = new File(Dpath+filelist[i]);
			try {
				ArrayList<String> wtf = new ArrayList<String>();
				InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
				BufferedReader br = new BufferedReader( read);
				for(String s = br.readLine();s != null; s = br.readLine()){
					wtf.add(s);
				}
				br.close();
				
				MatchPO oneMatch = new MatchPO();
				oneMatch.setMatchTime(wtf.get(0).split(";")[0]);
				oneMatch.setTeams(wtf.get(0).split(";")[1]);
				oneMatch.setScore(wtf.get(0).split(";")[2]);
				oneMatch.setScore1(wtf.get(1).split(";")[0]);oneMatch.setScore2(wtf.get(1).split(";")[1]);oneMatch.setScore3(wtf.get(1).split(";")[2]);oneMatch.setScore4(wtf.get(1).split(";")[3]);
				ArrayList<String> temp = new ArrayList<String>();
				for(int j=4;j<wtf.get(1).split(";").length;j++){
					temp.add(wtf.get(1).split(";")[j]);
				}
				oneMatch.setExtraScores(temp);
				int index=3;
				while(wtf.get(index).split(";").length>1)
					index++;
				int extra = 0;
				if(!(temp==null))
					extra = temp.size();
				
				MatchTeam team1 = getTeamInfo(wtf,2,index-1);
				checkScore(team1,Integer.parseInt(oneMatch.getScore().split("-")[0]));
				checkTime(team1,extra);
				MatchTeam team2 = getTeamInfo(wtf,index,wtf.size()-1);
				checkScore(team2,Integer.parseInt(oneMatch.getScore().split("-")[1]));
				checkTime(team2,extra);
				
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
	
	public MatchPO getOneMatchOriginal(String path) {
		    BasicMatchData bmd =new BasicMatchData();
		    
			MatchPO oneMatch = new MatchPO();
			File readfile = new File(bmd.getPath()+"\\matches\\"+path);
			try {
				ArrayList<String> wtf = new ArrayList<String>();
				InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
				BufferedReader br = new BufferedReader( read);
				for(String s = br.readLine();s != null; s = br.readLine()){
					wtf.add(s);
				}
				br.close();
			
				oneMatch.setMatchTime(wtf.get(0).split(";")[0]);
				oneMatch.setTeams(wtf.get(0).split(";")[1]);
				oneMatch.setScore(wtf.get(0).split(";")[2]);
				oneMatch.setScore1(wtf.get(1).split(";")[0]);oneMatch.setScore2(wtf.get(1).split(";")[1]);oneMatch.setScore3(wtf.get(1).split(";")[2]);oneMatch.setScore4(wtf.get(1).split(";")[3]);
				ArrayList<String> temp = new ArrayList();
				for(int j=4;j<wtf.get(1).split(";").length;j++){
					temp.add(wtf.get(1).split(";")[j]);
				}
				oneMatch.setExtraScores(temp);
				int index=3;
				while(wtf.get(index).split(";").length>1)
					index++;
				int extra = 0;
				if(!(temp==null))
					extra = temp.size();
				
				MatchTeam team1 = getTeamInfo(wtf,2,index-1);
				checkScore(team1,Integer.parseInt(oneMatch.getScore().split("-")[0]));
				checkTime(team1,extra);
				MatchTeam team2 = getTeamInfo(wtf,index,wtf.size()-1);
				checkScore(team2,Integer.parseInt(oneMatch.getScore().split("-")[1]));
				checkTime(team2,extra);
				
				oneMatch.setTeam1(team1);
				oneMatch.setTeam2(team2);
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return oneMatch;
	}
	
	public static void checkTime(MatchTeam team,int extraTimes){
		int n=0;
		for(;n<team.getPlayers().size();n++){
			if(team.getPlayers().get(n).getMatchTime().equals("null")||team.getPlayers().get(n).getMatchTime().equals("None")){
				setTime(team,extraTimes,n);
				break;
			}
		}
		
	}
	
	public static void setTime(MatchTeam team, int extraTimes, int n){
		int minToSet = 0; int secToSet = 0;
		for(int i=0;i<n;i++){
			minToSet = minToSet+Integer.parseInt(team.getPlayers().get(i).getMatchTime().split(":")[0]) ;
			secToSet = secToSet+Integer.parseInt(team.getPlayers().get(i).getMatchTime().split(":")[1]) ;
		}
		for(int i=n+1;i<team.getPlayers().size();i++){
			minToSet = minToSet+Integer.parseInt(team.getPlayers().get(i).getMatchTime().split(":")[0]) ;
			secToSet = secToSet+Integer.parseInt(team.getPlayers().get(i).getMatchTime().split(":")[1]) ;
		}
		int sec = 240*60;
		for(int t=0;t<extraTimes;t++)
			sec= sec+25*60;
		sec = sec-minToSet*60 - secToSet;
		int min=0;
		while(sec/60>0){
			min = min+1;
			sec = sec-60;
		}
		String time = Integer.toString(min)+":"+Integer.toString(sec);
		team.getPlayers().get(n).setMatchTime(time);
	}
	
	
	public static void checkScore(MatchTeam team,int score ){
		int i=0;
		for(;i<team.getPlayers().size();i++){
			if(team.getPlayers().get(i).getScore()<0){
				for(int j=0;j<i;j++)
					score = score-team.getPlayers().get(j).getScore();
				for(int j=i+1;j<team.getPlayers().size();j++)
					score = score-team.getPlayers().get(j).getScore();
				team.getPlayers().get(i).setScore(score);
				break;
			}
				
		}
		
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
			if(!(wtf[17].equals("null"))){
				player.setScore(Integer.parseInt(wtf[17]));}
			else
				player.setScore(-1);
			team.addPlayer(player);
		}
		return team;
	}
	
	public String getPath(){
		File f = new File("E://SE3//NBAQuerySystem//coding//iteration2//Data//path.txt");
		String result="";
		try{
			BufferedReader br=new BufferedReader(new FileReader(f));
			String s="";
			while((s=br.readLine())!=null){
				result=s;
			}
			br.close();    
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
