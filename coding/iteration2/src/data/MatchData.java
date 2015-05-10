package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;
import dataService.MatchDataService;

public class MatchData implements MatchDataService{
	
	public static void main(String[]args){
		MatchData md=new MatchData();
		md.getSingleMatchInfo("a", "b");
	}
	
	public MatchPO getSingleMatchInfo(String teamName,String date){
		MatchPO result=new MatchPO();
		BasicMatchData bmd=new BasicMatchData();
		String Dpath="Data\\matches";
		File f = new File(Dpath);
		String[] filelist = f.list();
		for(int i=0;i<filelist.length;i++){
			String [] temp1=filelist[i].split("_");
			String [] temp2=temp1[2].split("-");
			if(temp1[1].equals(date)&&(teamName.equals(temp2[0])||teamName.equals(temp2[1]))){
				result=bmd.getOneMatchOriginal(Dpath+"\\"+filelist[i]);
				break;
			}
		}
		return result;
	}
	
	
	

	public ArrayList<MatchPO> getAllMatchInfo(){
		BasicMatchData bmd=new BasicMatchData(); 
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		result=bmd.getMatchOriginal();
		return result;
	}
	
	public ArrayList<MatchPO> getTeamRecentMatchInfo(int number,String teamName){
		BasicMatchData bmd=new BasicMatchData();
		MatchDataCalculate mdc=new MatchDataCalculate();
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		ArrayList<String> allpath=mdc.getSortedFile();
		String []temp;
		String[]temp1;
		
		for(int i=allpath.size()-1;i>=0;i--){
			temp=allpath.get(i).split("_");
			temp1=temp[2].split("-");
			if(temp1[0].equals(teamName)||temp1[1].equals(teamName)){
				result.add(bmd.getOneMatchOriginal(allpath.get(i)));
			}
		}
		
		return result;
	}
	
	public ArrayList<MatchPO> getPlayerRecentMatchInfo(int number,String playerName){
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		MatchPO temp=new MatchPO();
		BasicMatchData bmd =new BasicMatchData();
		
		MatchDataCalculate mdc=new MatchDataCalculate();
		ArrayList<String> allpath=mdc.getSortedFile();
		
		for(int i=allpath.size()-1;i>=0;i--){
			temp=bmd.getOneMatchOriginal(allpath.get(i));
			for(int j=0;j<temp.getTeam1().getPlayers().size();j++){
				if(temp.getTeam1().getPlayers().get(j).getPlayerName().equals(playerName)){
					result.add(temp);
					break;
				}
			}
			for(int j1=0;j1<temp.getTeam1().getPlayers().size();j1++){
				if(temp.getTeam2().getPlayers().get(j1).getPlayerName().equals(playerName)){
					result.add(temp);
					break;
				}
			}
		}
		
		return result;
	}
	
	public String getDate(){
		String Dpath="Data\\matches";
		File f = new File(Dpath);
		String[] filelist = f.list();
		
		int length=filelist.length;
		String[] temp=filelist[length-1].split("_");
		
		return temp[1]; 
	}
	
	public ArrayList<MatchPO> getTodayMatchInfo(String date){
		ArrayList<MatchPO> result=new ArrayList<MatchPO>();
		BasicMatchData bmd=new BasicMatchData();
		String Dpath="Data\\matches";
		File f = new File(Dpath);
		String[] filelist = f.list();
		for(int i=0;i<filelist.length;i++){
			String [] temp1=filelist[i].split("_");
			String [] temp2=temp1[2].split("-");
			if(temp1[1].equals(date)){
				result.add(bmd.getOneMatchOriginal(Dpath+"\\"+filelist[i]));
				break;
			}
		}
		
		return result;
	}
	
	
	
}
