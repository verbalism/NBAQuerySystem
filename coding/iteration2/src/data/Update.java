package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;  
import java.nio.file.Paths;  
import java.nio.file.StandardWatchEventKinds;  
import java.nio.file.WatchEvent;  
import java.nio.file.WatchKey;  
import java.nio.file.WatchService;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import data.DataUpdate;

public class Update {  
    public void AutoUpdate() throws Exception  {  
    	TeamDataCalculate tdc=new TeamDataCalculate();
        PlayerData pds=new PlayerData();
        Update u=new Update();
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
            	File file=new File("C:\\data"); 
        		if(file.list().length==0){
        			System.out.println("删除");
        			u.deleteAll();
        			pds.updateBasicPlayerInfo();
        	        try {
        				tdc.BasicTeamOriginal();
        			} catch (Exception e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}
        		
                //System.out.println(event.context()+"发生了"+event.kind()+"事件");  
                if(event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)){
                	file=new File("C:\\data\\"+event.context());
            			if(!file.exists()){
            				generalID=-1;
            			}
            			else{
            				generalID=du.update("C:\\data\\"+event.context());
            			}
            			pds.updatePlayerInfo(generalID);
            		}
                
            }  
            if(!key.reset()){  
                break;  
            }  
        }  
    }  
    
    public void deleteAll()throws Exception{
		 File f=new File("");
		 	String s=f.getCanonicalPath();
		 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
			Statement stmt=conn.createStatement();
			
			stmt.executeUpdate("delete * from generalMatchInfo");
			stmt.executeUpdate("delete * from playerMatchInfo");
			stmt.executeUpdate("delete * from playerInfo");
			stmt.executeUpdate("delete * from teamInfo");
			
			
			stmt.close();
			conn.close();
			
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