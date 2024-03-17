import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class conair extends JFrame {
    public static class Main extends JFrame {
        public static void main(String[] args) {
            Main frame = new Main();
            frame.setVisible(true);
        }
        public Main() {
            setTitle("记事本");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            JButton bd = new JButton("确定");
            JButton bc = new JButton("取消");
            bd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    loginfo("b bdetermine：点击");
                }
            });
            bc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    loginfo("b bcancel：点击");
                    exit(0);
                }
            });
            JDialog confirmDialog = new JDialog(this, "确认", true);
            confirmDialog.setSize(300, 100);
            confirmDialog.setLocationRelativeTo(null);
            panel = new JPanel();
            JTextField text = new JTextField(20);
            text.setText("确认删除？");
            text.setEditable(false);
            panel.add(text);
            panel.add(bd);
            panel.add(bc);
            confirmDialog.setContentPane(panel);
            confirmDialog.setVisible(true);
            loginfo("w 确认删除：按钮已加载");
        }
        private void loginfo(String info) {
            System.out.println("[INFO]"+info);
        }
        public void exit(int status) {
            loginfo("退出 退出码："+status);
            System.exit(status);
        }
    }

    public static @interface tmp {
    //        jf = null;
    //        panel = null;
    //        badd = null;
    //        bdel = null;
    //        blist = null;
    //        bset = null;
    //        bexit = null;
    }
}