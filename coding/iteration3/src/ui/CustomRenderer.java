package ui;

import java.awt.Color;
import java.awt.Paint;

public class CustomRenderer extends org.jfree.chart.renderer.category.BarRenderer {  
	  
    /**  
     *   
     */   
    private Paint[] colors;  
    //初始化柱子颜色  
    private String[] colorValues;
    public CustomRenderer(String[] c) {  
    	colorValues = c;
        colors = new Paint[colorValues.length];  
        for (int i = 0; i < colorValues.length; i++) {  
            colors[i] = Color.decode(colorValues[i]);  
        }  
    }  
  
    //每根柱子以初始化的颜色不断轮循  
    public Paint getItemPaint(int i, int j) {  
        return colors[j % colors.length];  
    } 
    
    
}