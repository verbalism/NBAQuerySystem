package ui;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
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
	  spiderwebplot.setSeriesPaint(0,new Color(30,81,140));
	  spiderwebplot.setSeriesPaint(1,new Color(0,93,172));
	  spiderwebplot.setSeriesPaint(2,new Color(112,200,218));
	  spiderwebplot.setSeriesPaint(3,new Color(199,232,250));
	  spiderwebplot.setSeriesPaint(4,new Color(77,67,152));
	  spiderwebplot.setLabelFont(new Font("微软雅黑",0,13));
	  
	  JFreeChart jfreechart = new JFreeChart("", TextTitle.DEFAULT_FONT, spiderwebplot, false);
	  LegendTitle legendtitle = new LegendTitle(spiderwebplot);
	  legendtitle.setPosition(RectangleEdge.BOTTOM);
	  jfreechart.addSubtitle(legendtitle);
	  jfreechart.setBackgroundPaint(Color.white);
	  
	  return jfreechart;
	 }

}
