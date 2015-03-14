package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import po.TeamInfoPO;
import dataservice.TeamDataService;

public class TeamData implements TeamDataService{
	public static void main(String args[]){
		TeamData pd = new TeamData();
		TeamInfoPO a = pd.getSingleTeamOriginal("Rcke");
		System.out.print(a.getSubarea());
	}
	public ArrayList<TeamInfoPO> getTeamOriginal() {
		
		File readfile = new File("Data\\teams\\teams");
		ArrayList<TeamInfoPO> allTeams = new <TeamInfoPO>ArrayList();
		try {
			ArrayList<String> wtf = new ArrayList<String>();
			InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
			BufferedReader br = new BufferedReader( read);
			for(String s = br.readLine();s != null; s = br.readLine()){
				wtf.add(s);
			}
			br.close();
			for(int i=1;i<wtf.size()-1;i++){
				String infos = wtf.get(i).split("║")[1];
				TeamInfoPO team = new TeamInfoPO();
				String[] temp = infos.split("│");
				team.setFullName(temp[0]);
				team.setAbbreviation(temp[1]);
				team.setCity(temp[2]);
				team.setZone(temp[3]);
				team.setSubarea(temp[4]);
				team.setHomeCourt(temp[5]);
				team.setCreateTime(temp[6]);
				allTeams.add(team);
			}
			
		} catch (FileNotFoundException e) {
			return null;//未找到文件
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allTeams;
	}

	public TeamInfoPO getSingleTeamOriginal(String teamName) {
		File readfile = new File("Data\\teams\\teams");
		int length = teamName.length();
		TeamInfoPO team = new TeamInfoPO();
		try {
			ArrayList<String> wtf = new ArrayList<String>();
			InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
			BufferedReader br = new BufferedReader( read);
			for(String s = br.readLine();s != null; s = br.readLine()){
				wtf.add(s);
			}
			br.close();
			for(int i=1;i<wtf.size()-1;i++){
				String infos = wtf.get(i).split("║")[1];
				if(infos.subSequence(0, length).equals(teamName)){
					String[] temp = infos.split("│");
					team.setFullName(teamName);
					team.setAbbreviation(temp[1]);
					team.setCity(temp[2]);
					team.setZone(temp[3]);
					team.setSubarea(temp[4]);
					team.setHomeCourt(temp[5]);
					team.setCreateTime(temp[6]);
					return team;
				}
			}
			
		} catch (FileNotFoundException e) {
			return null;//未找到文件
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
