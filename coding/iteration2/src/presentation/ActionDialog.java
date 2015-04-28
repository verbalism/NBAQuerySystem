package presentation;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ActionDialog extends JDialog{
	
	 	JLabel info;
	 	JDialog ActionDialog = new JDialog();
		public ActionDialog(String str) {
	 		this.setTitle("操作提示");
	 		info = new JLabel(str);
	 		info.setFont(new Font("微软雅黑",Font.BOLD,14));
	 		this.setSize(300, 180);
	 		info.setHorizontalAlignment(SwingConstants.CENTER);
	 		this.setLocationRelativeTo(null);
	 		this.getContentPane().add(info, BorderLayout.CENTER);
	 		this.show();
	    }
	
}