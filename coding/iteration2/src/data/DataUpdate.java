package data;

import java.io.File;
import java.util.ArrayList;

import po.MatchPO;

public class DataUpdate {
	public int update(String path){
		DataUpdate du=new DataUpdate();
		BasicMatchData bmd=new BasicMatchData();
		MatchDataCalculate mdc=new MatchDataCalculate();
		TeamDataCalculate tdc=new TeamDataCalculate();
		int generalMatchID=0;
	
		MatchPO matchesAdded=bmd.getOneMatchOriginal(path);
		try {
			generalMatchID=mdc.BasicOneMatchOriginal(matchesAdded);
			if(generalMatchID!=-1){
				tdc.addSingleMatchTeam(generalMatchID);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generalMatchID;
	}		
			
	/*public ArrayList<String> getFilesChanged(String path){
		DataUpdate du=new DataUpdate();
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<String> allfiles=du.getAllFiles(path);
		MatchData md=new MatchData();
		String date=md.getDate();
		System.out.println(date);
		String []temp;
		for(int i=0;i<allfiles.size();i++){
			temp=allfiles.get(i).split("_");
			if(dateLater(date,temp[1])){
				result.add(allfiles.get(i));
			}
		}
		return result;
	}
	
	public boolean dateLater(String date1,String date2){
		boolean result=false;
		String[] temp1=date1.split("-");
		String[] temp2=date2.split("-");
		int day1=Integer.parseInt(temp1[0])*30+Integer.parseInt(temp1[1]);
		int day2=Integer.parseInt(temp2[0])*30+Integer.parseInt(temp2[1]);
		if(day1<day2){
			result=true;
		}
		return result;
	}
	
	
	public ArrayList<String> getAllFiles(String path){
		File file=new File(path);
		ArrayList<String>result=new ArrayList<String>();
		String test[];
		test=file.list();
		for(int i=0;i<test.length;i++){
		   System.out.println(test[i]);
		   result.add(test[i]);
		}
		return result;
	}
	*/
	
	public static void main(String[]args){
		DataUpdate du=new DataUpdate();
		du.update("C:\\data");
	}
}
