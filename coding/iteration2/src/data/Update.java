package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import po.MatchPO;




public class Update {  
    public void AutoUpdate(String path) throws Exception  {  
    	TeamDataCalculate tdc=new TeamDataCalculate();
    	TeamData td=new TeamData();
    	PlayerData pd=new PlayerData();
    	
    	File f = new File(new getFullPatch()+"//Data//path.txt");
		FileWriter fw;
		BufferedWriter bw;
		try{		
			fw = new FileWriter(f);
			fw.write(path);
			fw.close();
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
		f = new File(new getFullPatch()+"//Data//teamInfoPO.txt");
		try{		
			fw = new FileWriter(f);
			fw.write("");
			fw.close();
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
		td.getAllTeamInfo();
		pd.updateBasicPlayerInfo();
    }
    
    /*public static void main(String[]args){
    	Update u=new Update();
    	try {
			u.AutoUpdate("C:\\Users\\Administrator\\Desktop\\NBAQuerySystem\\coding\\iteration2\\Data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ArrayList<MatchPO> result=new MatchData().getAllMatchInfo();
    	System.out.println(result.size());
    	System.out.println(result.get(0).getMatchTime());
    }*/
}  