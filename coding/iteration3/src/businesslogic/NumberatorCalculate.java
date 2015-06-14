package businesslogic;

import java.util.List;

public class NumberatorCalculate {  
	      
	    //add global varieties  
	    protected List<String> xList , yList;  
	      
	    public NumberatorCalculate(List<String> xList ,List<String> yList){  
	        this.xList = xList;  
	        this.yList = yList;  
	    }  
	      
	    /** 
	     * add operate method 
	     */  
	    public double calculateNumberator(){  
	        double result =0.0;  
	        double xAverage = 0.0;  
	        double temp = 0.0;  
	          
	        int xSize = xList.size();  
	        for(int x=0;x<xSize;x++){  
	            temp += Double.parseDouble(xList.get(x));  
	        }  
	        xAverage = temp/xSize;  
	          
	        double yAverage = 0.0;  
	        temp = 0.0;  
	        int ySize = yList.size();  
	        for(int x=0;x<ySize;x++){  
	            temp += Double.parseDouble(yList.get(x));  
	        }  
	        yAverage = temp/ySize;  
	          
	        //double sum = 0.0;  
	        for(int x=0;x<xSize;x++){  
	            result+=(Double.parseDouble(xList.get(x))-xAverage)*(Double.parseDouble(yList.get(x))-yAverage);  
	        }  
	        return result;  
	    }  
	    
	
}
