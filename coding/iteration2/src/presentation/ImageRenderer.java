package presentation;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ImageRenderer implements TableCellRenderer{

  public Component getTableCellRendererComponent(
          JTable table, Object value, boolean isSelected, 
          boolean hasFocus, int rowIndex, int columnIndex) {
    
    if( value instanceof ImageIcon ){
    	JLabel lb = new JLabel();
    	lb.setIcon((Icon) value);
    	//lb.setOpaque(false);
    	lb.setBackground(null);
    	return lb;
    }
    else if( value instanceof File ) {
      try {
        return new JLabel(new ImageIcon(ImageIO.read((File)value)));
      } catch(IOException ex) {
        throw new RuntimeException(ex.getMessage(), ex);
      }
    }
    
    else {
      String val = String.valueOf(value);
      try {
        return new JLabel(new ImageIcon(ImageIO.read(new File(val))));
      } catch(IOException ex) {
        throw new RuntimeException(ex.getMessage(), ex);
      }
    }
  }
}

