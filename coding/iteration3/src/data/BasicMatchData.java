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

	public ArrayList<MatchPO> getMatchOriginal(String path) {
		ArrayList<MatchPO> allMatches = new ArrayList<MatchPO>();
		String Dpath="C:\\Users\\yq13y_000\\Desktop\\Iter3Data\\match\\"+path+"\\";
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
	
	public MatchPO getOneMatchOriginal(String path,String fileName) {
		MatchPO oneMatch = new MatchPO();
		File readfile = new File("C:\\Users\\yq13y_000\\Desktop\\Iter3Data\\match\\"+path+"\\"+fileName);
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
	
	public ArrayList <String> getSortedFile(String path){
		ArrayList<String> result=new ArrayList<String>();
		
		String Dpath="C:\\Users\\yq13y_000\\Desktop\\Iter3Data\\match\\"+path;
		File f = new File(Dpath);
		String[] filelist = f.list();
		
		int x=-1;
		for(int i=0;i<filelist.length;i++){
			String []temp=filelist[i].split("_");
			String []date=temp[0].split("-");
			String month=date[0];
			if(Integer.parseInt(month)>9){
				x=i;
				break;
			}
		}
		
		if(x==-1){
			for(int i=0;i<filelist.length;i++)
				result.add(filelist[i]);
		}else{
			for(int i=x;i<filelist.length;i++)
				result.add(filelist[i]);
			for(int i=0;i<x;i++)
				result.add(filelist[i]);
		}
		
		return result;
	}
	
	public static void main(String[] args){
		BasicMatchData bmd=new BasicMatchData();
		SaveInfo si=new SaveInfo();
		String[] p={"05-06\\playoff","05-06\\regular","06-07\\playoff","06-07\\regular","07-08\\playoff","07-08\\regular","08-09\\playoff","08-09\\regular","09-10\\playoff","09-10\\regular","10-11\\playoff","10-11\\regular","11-12\\playoff","11-12\\regular","12-13\\playoff","12-13\\regular","13-14\\playoff","13-14\\regular","14-15\\playoff","14-15\\regular"};
		String[] season={"05_06_after","05_06","06_07_after","06_07","07_08_after","07_08","08_09_after","08_09","09_10_after","09_10","10_11_after","10_11","11_12_after","11_12","12_13_after","12_13","13_14_after","13_14","14_15_after","14_15"};
		for(int i=0;i<p.length;i++){
			ArrayList<MatchPO> a=new ArrayList<MatchPO>();
			ArrayList<String> pa=bmd.getSortedFile(p[i]);
			for(int j=0;j<pa.size();j++){
				MatchPO temp=new MatchPO();
				temp=bmd.getOneMatchOriginal(p[i],pa.get(j));
				a.add(temp);
			}
			System.out.println(a.size());
			for(int k=0;k<a.size();k++){
				try {
					si.saveMatchInfo(season[i], k+1, a.get(k));
				} catch (Exception e) {
				}
			}
		}
		
	}

}
