package ui;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

public class SeriesChart extends ChartPanel{
	public SeriesChart(DefaultCategoryDataset dataset){
		super(CreateSeriesChart(dataset));
	}

	public static JFreeChart CreateSeriesChart(DefaultCategoryDataset dataset){  
 
        JFreeChart chart = ChartFactory.createLineChart(null,// 报表题目，字符串类型
                "", // 横轴
                "", // 纵轴
                dataset, // 获得数据集
                PlotOrientation.VERTICAL, // 图标方向垂直
                true, // 显示图例
                false, // 不用生成工具
                false // 不用生成URL地址
                );
        chart.setBackgroundPaint(Color.white);  
        // 生成图形
        
        CategoryPlot plot = chart.getCategoryPlot();
        // 图像属性部分
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinesVisible(false);  //设置背景网格线是否可见
        //plot.setDomainGridlinePaint(Color.BLACK); //设置背景网格线颜色
        plot.setRangeGridlinesVisible(false);
        plot.setNoDataMessage("没有数据");//没有数据时显示的文字说明。 
        
        // 数据轴属性部分
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true); //自动生成
        rangeAxis.setUpperMargin(0.20);
        rangeAxis.setLabelAngle(Math.PI / 2.0); 
        rangeAxis.setAutoRange(false);
        
        // 数据渲染部分 主要是对折线做操作
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseItemLabelsVisible(false);
       // renderer.setBaseItemLabelPaint(new Color(102, 102, 102));// 显示折点数值字体的颜色  
       // renderer.setBaseItemLabelFont(new Font("Dialog", 0, 13));  //设置提示折点数据形状
        renderer.setBaseShapesFilled(true);     
       // renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());          
        renderer.setSeriesShapesVisible(0, true);  
        renderer.setSeriesShapesVisible(1, true);  
        renderer.setSeriesShapesVisible(2, true);
        //第一条折线的颜色  
        renderer.setSeriesFillPaint(0, new Color(30,81,140));  
        renderer.setSeriesPaint(0, new Color(30,81,140));  
        //第二条折线的颜色  
        renderer.setSeriesFillPaint(1, new Color(142,142,142));  
        renderer.setSeriesPaint(1, new Color(142,142,142)); 
        //第三条折线的颜色
        renderer.setSeriesFillPaint(2, new Color(228,26,76));  
        renderer.setSeriesPaint(2, new Color(228,26,76)); 
        plot.setRenderer(renderer);
        
    
        
        
        return chart;
    }   
	
	
}
