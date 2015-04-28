package data;

import java.nio.file.FileSystems;  
import java.nio.file.Paths;  
import java.nio.file.StandardWatchEventKinds;  
import java.nio.file.WatchEvent;  
import java.nio.file.WatchKey;  
import java.nio.file.WatchService;  

import data.DataUpdate;

public class Update {  
    public void AutoUpdate() throws Exception  {  
    	TeamDataCalculate tdc=new TeamDataCalculate();
        PlayerData pds=new PlayerData();
        int generalID=0;
        
        WatchService watchService=FileSystems.getDefault().newWatchService();  
        DataUpdate du=new DataUpdate();
        Paths.get("C:\\data").register(watchService,   
                StandardWatchEventKinds.ENTRY_CREATE,  
                StandardWatchEventKinds.ENTRY_DELETE,  
                StandardWatchEventKinds.ENTRY_MODIFY);  
        while(true){  
            WatchKey key=watchService.take();  
            for(WatchEvent<?> event:key.pollEvents()){  
                System.out.println(event.context()+"发生了"+event.kind()+"事件");  
                if(event.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY)){
                	generalID=du.update("C:\\data\\"+event.context());
                	pds.updatePlayerInfo(generalID);
                }
            }  
            if(!key.reset()){  
                break;  
            }  
        }  
    }  
    
    public static void main(String[]args){
   
    	TeamDataCalculate tdc=new TeamDataCalculate();
        PlayerData pds=new PlayerData();
        pds.updateBasicPlayerInfo();
        try {
			tdc.BasicTeamOriginal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}  