package data;

import java.io.File;

public class getFullPatch {
	public String getFullPath(){
		String courseFile="";
		try{
			File directory = new File("");
			courseFile = directory.getCanonicalPath() ;
		}catch(Exception e){
		}
		return courseFile;
	}
}
