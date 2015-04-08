package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import po.BasicTeamPO;

public class BasicTeamData {
public ArrayList<BasicTeamPO> getTeamOriginal() {
		
		File readfile = new File("Data\\teams\\teams");
		ArrayList<BasicTeamPO> allTeams = new ArrayList<BasicTeamPO>();
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
				BasicTeamPO team = new BasicTeamPO();
				String[] temp = infos.split("│");
				team.setFullName(removeBlankSpace(temp[0]));
				team.setAbbreviation(removeBlankSpace(temp[1]));
				team.setCity(removeBlankSpace(temp[2]));
				if(i==3)
					team.setZone("E");
				else
					team.setZone(removeBlankSpace(temp[3]));
				team.setSubarea(removeBlankSpace(temp[4]));
				team.setHomeCourt(removeBlankSpace(temp[5]));
				team.setCreateTime(removeBlankSpace(temp[6]));
				allTeams.add(team);
			}
			
		} catch (FileNotFoundException e) {
			return null;//未找到文件
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allTeams;
	}

	public BasicTeamPO getSingleTeamOriginal(String teamName) {
		File readfile = new File("Data\\teams\\teams");
		int length = teamName.length();
		BasicTeamPO team = new BasicTeamPO();
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
					team.setAbbreviation(removeBlankSpace(temp[1]));
					team.setCity(removeBlankSpace(temp[2]));
					if(i==3)
						team.setZone("E");
					else
						team.setZone(removeBlankSpace(temp[3]));
					team.setSubarea(removeBlankSpace(temp[4]));
					team.setHomeCourt(removeBlankSpace(temp[5]));
					team.setCreateTime(removeBlankSpace(temp[6]));
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
	
	public static String removeBlankSpace(String s){
		
		while(' '==s.charAt(s.length()-1)||'\t'==s.charAt(s.length()-1)){
			s=s.substring(0, s.length()-1);
		}
		
		return s;
	}
}
