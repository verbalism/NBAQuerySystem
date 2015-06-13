package ui;

import java.awt.Color;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

public class SpiderWebChart extends ChartPanel{

	public SpiderWebChart(DefaultCategoryDataset dataset) {
		super(createChart(dataset));
		// TODO Auto-generated constructor stub
	}
	
	private static JFreeChart createChart(CategoryDataset categorydataset){
	  MySpiderWebPlot spiderwebplot = new MySpiderWebPlot(categorydataset);
	  spiderwebplot.setDrawRing(true);
	  spiderwebplot.setDrawValue(true);
	  spiderwebplot.setStartAngle(54D);
	  spiderwebplot.setOutlinePaint(Color.WHITE); // 设置绘图面板外边的填充颜色
	  //spiderwebplot.setInteriorGap(0.40000000000000002D);
	  spiderwebplot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
	  JFreeChart jfreechart = new JFreeChart("", TextTitle.DEFAULT_FONT, spiderwebplot, false);
	  LegendTitle legendtitle = new LegendTitle(spiderwebplot);
	  legendtitle.setPosition(RectangleEdge.BOTTOM);
	  jfreechart.addSubtitle(legendtitle);
	  jfreechart.setBackgroundPaint(Color.white);
	  
	  return jfreechart;
	 }

}
