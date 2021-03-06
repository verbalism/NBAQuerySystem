package ui;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * 进度条测试程序
 *
 * @author ygh
 *
 */
public class ProgressBar implements ActionListener {

    private static final String DEFAULT_STATUS = "Please Waiting";
    private static JDialog dialog;
    private JProgressBar progressBar;
    private JLabel lbStatus;
    private JButton btnCancel;
    private Window parent;
    private Thread thread; // 处理业务的线程
    private String statusInfo;
    private String resultInfo;
    private String cancelInfo;
    /**
     * 显示进度条测试对话框
     * @param parent
     * @param thread
     */
    public ProgressBar(Window parent, String statusInfo){
    	this.parent = parent;
        this.thread = null;
        this.statusInfo = statusInfo;
        this.resultInfo = null;
        this.cancelInfo = null;
        //initUI();
        //startThread();
        //dialog.setVisible(true);
    	//new ProgressBar(parent, null, statusInfo, null, null);
    }
    public ProgressBar(Window parent, Thread thread) {
    	this.parent = parent;
        this.thread = thread;
        this.statusInfo = DEFAULT_STATUS;
        this.resultInfo = null;
        this.cancelInfo = null;
        //initUI();
        //startThread();
        //dialog.setVisible(true);
        //new ProgressBar(parent, thread, DEFAULT_STATUS, null, null);
    }
    /**
     * 显示进度条测试对话框
     * @param parent
     * @param thread
     * @param statusInfo
     */
    public ProgressBar(Window parent, Thread thread, String statusInfo) {
    	this.parent = parent;
        this.thread = thread;
        this.statusInfo = statusInfo;
        this.resultInfo = null;
        this.cancelInfo = null;
        //initUI();
        //startThread();
        //dialog.setVisible(true);
        //new ProgressBar(parent, thread, statusInfo, null, null);
    }

    /**
     * 显示对话框
     * @param parent
     * @param thread
     * @param statusInfo
     * @param resultInfo
     * @param cancelInfo
     */
   /** public ProgressBar(Window parent, Thread thread, String statusInfo,
            String resultInfo, String cancelInfo) {
        new ProgressBar(parent, thread, statusInfo, resultInfo, cancelInfo);
    }**/
    
    public static void close(){
    	dialog.dispose();
    }

    /**
     * 对话框构造函数
     * @param parent
     * @param thread
     * @param statusInfo
     * @param resultInfo
     * @param cancelInfo
     */
    public ProgressBar(Window parent, Thread thread, String statusInfo,
            String resultInfo, String cancelInfo) {
        this.parent = parent;
        this.thread = thread;
        this.statusInfo = statusInfo;
        this.resultInfo = resultInfo;
        this.cancelInfo = cancelInfo;
        //initUI();
        //startThread();
        //dialog.setVisible(true);
    }
    
    public  void show(){
    	initUI();
    	dialog.setVisible(true);
    }
    /**
     * 构建显示进度条的对话框
     */
    private void initUI() {
        if (parent instanceof Dialog) {
            dialog = new JDialog((Dialog) parent, true);
        } else if (parent instanceof Frame) {
            dialog = new JDialog((Frame) parent, true);
        } else {
            dialog = new JDialog((Frame) null, true);
        }

        final JPanel mainPane = new JPanel(null);
        progressBar = new JProgressBar();
        lbStatus = new JLabel("" + statusInfo,JLabel.CENTER);
        btnCancel = new JButton("Cancel");
        progressBar.setIndeterminate(true);
        lbStatus.setFont(new Font("微软雅黑",0,14));
        //progressBar.setForeground(new Color(0,103,175));
        btnCancel.addActionListener(this);

        mainPane.add(progressBar);
        mainPane.add(lbStatus);
        // mainPane.add(btnCancel);

        dialog.getContentPane().add(mainPane);
        dialog.setUndecorated(true); // 除去title
        dialog.setResizable(true);
        dialog.setSize(390, 100);
        dialog.setBackground(null);
        dialog.setLocationRelativeTo(parent); // 设置此窗口相对于指定组件的位置

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // 不允许关闭

        mainPane.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                layout(mainPane.getWidth(), mainPane.getHeight());
            }
        });
    }
    
    /**
     * 启动线程，测试进度条
     */
    private void startThread() {
        new Thread() {
            public void run() {
                try {
                    thread.start(); // 处理耗时任务
                    // 等待事务处理线程结束
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 关闭进度提示框
                    dialog.dispose();

                    if (resultInfo != null && !resultInfo.trim().equals("")) {
                        /*String title = "Info";
                        JOptionPane.showMessageDialog(parent, resultInfo,
                                title,
                                JOptionPane.INFORMATION_MESSAGE);*/
                    }
                }
            }
        }.start();
    }
    /**
     * 设置控件的位置和大小
     * @param width
     * @param height
     */
    private void layout(int width, int height) {
        progressBar.setBounds(20, 20, 350, 15);
        lbStatus.setBounds(20, 50, 350, 25);
        btnCancel.setBounds(width - 85, height - 31, 75, 21);
    }

    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e) {
        resultInfo = cancelInfo;
        thread.stop();
    }

    /**
     * 入口主函数
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 用于测试进度条的线程
        Thread thread = new Thread() {
            public void run() {
                int index = 0;

                while (index < 5) {
                    try {
                        sleep(1000);
                        System.out.println(++index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //显示进度条测试对话框
        //ProgressBar.show((Frame) null, thread, "加载中", "Result", "Cancel");

    }
}