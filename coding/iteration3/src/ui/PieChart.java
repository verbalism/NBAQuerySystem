package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart extends ChartPanel{
	public PieChart(DefaultPieDataset dataset){
		super(CreatePieChart(dataset));
	}
	
	public static JFreeChart CreatePieChart(DefaultPieDataset dataset){ 
		JFreeChart pieChart = ChartFactory.createPieChart("",   dataset, true, true, false);  
        pieChart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,  
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);  
        // 得到饼图的plot对象  
        PiePlot piePlot = (PiePlot) pieChart.getPlot();  
        // 设置透明度 
        piePlot.setLabelFont((new Font("宋体", Font.PLAIN, 14)));
        piePlot.setShadowPaint(null);
  	  	piePlot.setBackgroundAlpha(0);
  	  	piePlot.setOutlinePaint(Color.WHITE); // 设置绘图面板外边的填充颜色
  	  	
  	  	DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
  	  	NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
  	  	StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
  	  	piePlot.setLabelGenerator(sp1);//设置饼图显示百分比 
  	  	
  	  	//piePlot.setLabelLinkMargin(-0.8);
  	  	//是否显示线 fasle就不显示了
  	  	//piePlot.setLabelLinksVisible(false);
  	  	piePlot.setLabelBackgroundPaint(Color.white);
  	  	piePlot.setLabelShadowPaint(null);
  	  	
  	  	
        // 设置标题字体  
        pieChart.getTitle().setFont(new Font("隶书", Font.BOLD, 20));  
        // 设置图例类别字体  
        pieChart.getLegend().setItemFont(new Font("微软雅黑", Font.BOLD, 14)); 
        
        pieChart.setBackgroundPaint(Color.white);
        
        PieRenderer renderer = new PieRenderer();  
        renderer.setColor(piePlot, dataset);
        
        return pieChart;
	}
	
	private static class PieRenderer {  
        private static final Paint[] COLORS = { new Color(49,72,118),  new Color(168,194,191), new Color(48,48,73), new Color(142,168,190)};  
  
        public void setColor(PiePlot plot, DefaultPieDataset dataset) {  
            List keys = dataset.getKeys();  
            for (int i = 0; i < keys.size(); i++) {  
                plot.setSectionPaint(keys.get(i).toString(), COLORS[i  
                        % COLORS.length]);  
            }  
        }  
    } 

}
