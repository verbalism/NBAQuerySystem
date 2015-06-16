package ui;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class LeftHorizontalBarChart extends ChartPanel{
	public LeftHorizontalBarChart(DefaultCategoryDataset dataset, String[] chartColor){
		super(createChart(dataset, chartColor));
	}
	
	
	
	public static JFreeChart createChart(CategoryDataset dataset, String[] chartColor) {
		JFreeChart chart = ChartFactory.createBarChart("",  
                "",  
                "",  
                dataset,  
                PlotOrientation.HORIZONTAL,  
                false,  
                false,  
                false);  
		chart.setBackgroundPaint(null);
		
		  CategoryPlot plot = chart.getCategoryPlot();//设置图的高级属性
		  //设置网格背景颜色
		  plot.setBackgroundPaint(Color.white);
		  plot.setRangeGridlinesVisible(false);
		  plot.setDomainGridlinesVisible(false);
		  plot.setAxisOffset(new RectangleInsets(0, 0, 0, 0)); 
		  
		  //显示每个柱的数值，并修改该数值的字体属性
		  BarRenderer renderer = new CustomRenderer(chartColor);  
		  renderer.setBaseItemLabelGenerator(new LabelGenerator());
		  //renderer.setBaseItemLabelGenerator( new StandardCategoryItemLabelGenerator());
		  renderer.setBaseItemLabelsVisible(true);
		   
		  //默认的数字显示在柱子中，通过如下两句可调整数字的显示
		  //注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
		  renderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE8, TextAnchor.BASELINE_LEFT));
		  renderer.setItemLabelAnchorOffset(60D);
		  renderer.setBaseItemLabelFont(new Font("Arial Narrow",Font.BOLD,24));
		  
		  
		  //renderer.setMaximumBarWidth(0.5);
		  //renderer.setMinimumBarLength(0.5);
		  //renderer.setItemMargin(0.001);
		  
		  
		  // renderer.setShadowVisible(false);
		  
		  
		  plot.setRenderer(renderer);//将修改后的属性值保存到图中
		  
		  
		  
		  Axis domainAxis = plot.getDomainAxis();  
		  domainAxis.setVisible(false);
		  Axis rangeAxis = plot.getRangeAxis();
		  rangeAxis.setVisible(false);
		  ((ValueAxis) rangeAxis).setUpperBound(0);
		  ((ValueAxis) rangeAxis).setLowerBound(-130);
		  
		  plot.setForegroundAlpha(0.6f);//柱的透明度
		  plot.setBackgroundAlpha(0);
		  plot.setOutlinePaint(Color.WHITE); // 设置绘图面板外边的填充颜色
		  
		  return chart;
	}
	
	static class LabelGenerator extends AbstractCategoryItemLabelGenerator  implements CategoryItemLabelGenerator{
		//private double threshold;
		public LabelGenerator(){
			super("", NumberFormat.getInstance());
			//threshold = d;
		}
		
		public String generateLabel(CategoryDataset categorydataset, int i,int i_0_){
			String string = null;
			Number number = categorydataset.getValue(i, i_0_);
			if (number != null)	{
				double d = - number.doubleValue();
				if (d > 0)
				string = Double.toString(d);
			}
			return string;

		}
	}
}
