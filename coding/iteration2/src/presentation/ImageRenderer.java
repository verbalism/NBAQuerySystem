package presentation;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ImageRenderer 
extends JLabel implements TableCellRenderer
{
private static final long serialVersionUID = 1L;
//定义构造器
public  ImageRenderer ()
{
//设置标签为不透明状态
this.setOpaque(false);
//设置标签的文本对齐方式为居中
this.setHorizontalAlignment(JLabel.CENTER);
}
//实现获取呈现控件的getTableCellRendererComponent方法
public Component getTableCellRendererComponent(JTable table,Object value,
       boolean isSelected,boolean hasFocus,int row,int column)
{            
	this.setIcon((Icon) value);
	if(row%2==1){
		this.setBackground(new Color(246, 246, 246));
	}
//获取要呈现的颜色
//Color c=(Color)value;
//根据参数value设置背景色
//this.setBackground(c);
//设置前景色为背景色反色
//this.setForeground(new Color(255-c.getRed()
//            ,255-c.getGreen(),255-c.getBlue()));
//设置标签中显示RGB的值
//this.setText("["+c.getRed()+","+c.getGreen()+","+c.getBlue()+"]");
//将自己返回
return this;    
}
}    