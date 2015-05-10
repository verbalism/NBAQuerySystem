package data;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import po.MatchPO;

public class MatchDataCalculate {
	public ArrayList <String> getSortedFile(){
		ArrayList<String> result=new ArrayList<String>();
		BasicMatchData bmd=new BasicMatchData();
		
		int shut=0;
		String Dpath=bmd.getPath();
		File f = new File(Dpath);
		String[] filelist = f.list();
		
		String []temp=filelist[0].split("_");
		String []temp1=temp[1].split("-");
		if(Integer.parseInt(temp1[0])>9){
			for(int i=0;i<filelist.length;i++){
				result.add(filelist[i]);
			}
		}
		else{
			for(int i1=0;i1<filelist.length;i1++){
				temp=filelist[i1].split("_");
				temp1=temp[1].split("-");
				if(Integer.parseInt(temp1[0])>9){
					shut=i1;
					break;
				}
			}
		}
		
		if(shut!=0){
			for(int j=shut;j<filelist.length;j++){
				result.add(filelist[j]);
			}
			for(int j1=0;j1<shut;j1++){
				result.add(filelist[j1]);
			}
		}
		
		return result;
	}
	
}
