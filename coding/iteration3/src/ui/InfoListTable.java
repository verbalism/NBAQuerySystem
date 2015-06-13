package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class InfoListTable extends JTable{
	JTable InfoListTable;
	public InfoListTable(DefaultTableModel mode){
		super(mode);
		Dimension size = this.getTableHeader().getPreferredSize();
		size.height = 25;
		JTableHeader tableH = this.getTableHeader();
		
		DefaultTableCellRenderer hr = new DefaultTableCellRenderer();
		hr.setHorizontalAlignment(SwingConstants.CENTER);
		hr.setPreferredSize(size);
		hr.setFont(new Font("微软雅黑",Font.BOLD,14));
		hr.setBackground(new Color(158,158,158));
		hr.setForeground(Color.white);
		hr.setBorder(null);
		tableH.setDefaultRenderer(hr);
		
		makeFace(this);
		this.setShowVerticalLines(false);
		this.setShowVerticalLines(false);
		this.setShowGrid(false);
		this.setFont(new Font("微软雅黑",0,14));
	    this.setRowHeight(30);
	    
	    
	    final TableRowSorter sorter = new TableRowSorter(mode); 
	    this.setRowSorter(sorter);
	    
	    
	     
	}
	
	public static void makeFace(JTable table) {
		   try {
		    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
		     public Component getTableCellRendererComponent(JTable table,
		       Object value, boolean isSelected, boolean hasFocus,
		       int row, int column) {
		    	 setHorizontalAlignment(SwingConstants.CENTER);
		    	 setForeground(new Color(51,51,51));
		      if (row % 2 == 0)
		       setBackground(Color.white); // ���������е�ɫ
		      else if (row % 2 == 1){
		       setBackground(new Color(246, 246, 246));
		      } // ����ż���е�ɫ
		      return super.getTableCellRendererComponent(table, value,
		        isSelected, hasFocus, row, column);
		     }
		    };
		    for (int i = 0; i < table.getColumnCount(); i++) {
		     table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
		    }
		   } catch (Exception ex) {
		    ex.printStackTrace();
		   }
		}

}
