package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import po.MatchPO;




public class Update {  
    public void AutoUpdate(String path) throws Exception  {  
    	TeamDataCalculate tdc=new TeamDataCalculate();
    	TeamData td=new TeamData();
    	PlayerData pd=new PlayerData();
    	
    	File filename=new File("D://path.txt");
    	if (!filename.exists()) {
    		filename.createNewFile();
    	}
    	filename=new File("D://playerInfoVO.txt");
    	if (!filename.exists()) {
    		filename.createNewFile();
    	}
    	filename=new File("D://teamInfoVO.txt");
    	if (!filename.exists()) {
    		filename.createNewFile();
    	}
    	

		FileWriter fw;
		File f = new File("D://path.txt");
		BufferedWriter bw;
		try{		
			fw = new FileWriter(f);
			fw.write(path);
			fw.close();
		}catch(Exception e) {
        	e.printStackTrace();
        }
		
		f = new File("D://teamInfoPO.txt");
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
    
   
}  