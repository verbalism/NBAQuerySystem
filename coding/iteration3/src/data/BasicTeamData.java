package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import po.TeamPO;


public class BasicTeamData {
	public ArrayList<TeamPO> getTeamInfo(String filename){
		File readfile = new File("C:\\Users\\yq13y_000\\Desktop\\team\\"+filename);
		ArrayList<TeamPO> result= new ArrayList<TeamPO>();
		try {
			ArrayList<String> wtf = new ArrayList<String>();
			InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
			BufferedReader br = new BufferedReader( read);
			for(String s = br.readLine();s != null; s = br.readLine()){
				wtf.add(s);
			}
			br.close();
			for(int i=0;i<wtf.size();i++){
				TeamPO temp=new TeamPO();
				String[] c=wtf.get(i).split(";");
				temp.setTeamName(c[0]);
				temp.setGamesPlayed(Integer.parseInt(c[1]));
				temp.setFieldGoalsMade(Double.parseDouble(c[2]));
				temp.setFieldGoalsAttempted(Double.parseDouble(c[3]));
				temp.setThreePointFieldGoalsMade(Double.parseDouble(c[4]));
				temp.setThreePointFieldGoalsAttempted(Double.parseDouble(c[5]));
				temp.setFreeThrowsMade(Double.parseDouble(c[6]));
				temp.setFreeThrowsAttempted(Double.parseDouble(c[7]));
				temp.setOffensiveRebounds(Double.parseDouble(c[8]));
				temp.setDefensiveRebounds(Double.parseDouble(c[9]));
				temp.setRebounds(Double.parseDouble(c[10]));
				temp.setAssists(Double.parseDouble(c[11]));
				temp.setSteals(Double.parseDouble(c[12]));
				temp.setBlocks(Double.parseDouble(c[13]));
				temp.setTurnovers(Double.parseDouble(c[14]));
				temp.setFouls(Double.parseDouble(c[15]));
				temp.setPoints(Double.parseDouble(c[16]));
				temp.setFieldGoalPercentage(Double.parseDouble(c[17]));
				temp.setThreePointFieldGoalPercentage(Double.parseDouble(c[18]));
				temp.setFreeThrowPercentage(Double.parseDouble(c[19]));
				temp.setWinPercentage(Double.parseDouble(c[20]));
				temp.setPossessions(Double.parseDouble(c[21]));
				temp.setOffensiveRating(Double.parseDouble(c[22]));
				temp.setDefensiveRating(Double.parseDouble(c[23]));
				temp.setOffensiveReboundPercentage(Double.parseDouble(c[24]));
				temp.setDefensiveReboundPercentage(Double.parseDouble(c[25]));
				temp.setStealPercentage(Double.parseDouble(c[26]));
				temp.setAssistPercentage(Double.parseDouble(c[27]));
				temp.setFullName((c[28]));
				temp.setCity((c[29]));
				temp.setZone((c[30]));
				temp.setSubarea((c[31]));
				temp.setHomeCourt((c[32]));
				temp.setCreateTime((c[33]));
				temp.setGamesPlayedWin(Double.parseDouble(c[34]));
				temp.setTeamID(c[35]);
				result.add(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[]args){
		BasicTeamData btd=new BasicTeamData();
		SaveInfo si=new SaveInfo();
		String[] filename={"05-06playoff","05-06regular","06-07playoff","06-07regular","07-08playoff","07-08regular","08-09playoff","08-09regular","09-10playoff","09-10regular","10-11playoff","10-11regular","11-12playoff","11-12regular","12-13playoff","12-13regular","13-14playoff","13-14regular","14-15playoff","14-15regular"};
		String[] season={"05_06_after","05_06","06_07_after","06_07","07_08_after","07_08","08_09_after","08_09","09_10_after","09_10","10_11_after","10_11","11_12_after","11_12","12_13_after","12_13","13_14_after","13_14","14_15_after","14_15"};
		for(int i=0;i<filename.length;i++){
			ArrayList<TeamPO> a=btd.getTeamInfo(filename[i]);
			for(int k=0;k<a.size();k++){
				try {
					si.saveTeamInfo(season[i],a.get(k));
				} catch (Exception e) {
				}
			}
		}
		ArrayList<TeamPO> b=btd.getTeamInfo(filename[19]);
		for(int k=0;k<b.size();k++){
			try {
				si.saveTeamID(b.get(k));
			} catch (Exception e) {
			}
		}
	}
}
