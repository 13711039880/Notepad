//import org.notepad.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//public class Main {
//    public static JFrame jf;
//    public static JPanel panel;
//
//    public static void main(String[] args) {
//        String AppDataPath = "C:\\users\\" + System.getProperty("user.name") + "\\AppData\\Notepad\\";
//        String DataPath = AppDataPath + "Data\\";
//        String PropertiesPath = AppDataPath + "Notepad.properties";
//        Path path = Paths.get(DataPath);
//        dp.info("AppDataPath:" + AppDataPath);
//
//        if (!Files.exists(path)) {
//            try {
//                Files.createDirectories(path);
//                dp.warn("Data文件夹不存在");
//                dp.info("正在创建Data文件夹");
//            } catch (IOException e) {
//                dp.error("在新建文件夹时发生了错误:");
//                dp.error("  " + e.getMessage());
//                JOptionPane.showMessageDialog(null, "在新建文件夹时发生了错误:\n    " + e.getMessage());
//                dp.exit(1);
//            }
//        }
//
//        File file = new File(PropertiesPath);
//
//        if (!file.exists()) {
//            dp.warn("设置文件不存在");
//            dp.info("正在创建设置文件");
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                dp.error("在新建文件时发生了错误:");
//                dp.error("  " + e.getMessage());
//                JOptionPane.showMessageDialog(null, "在新建文件时发生了错误:\n    " + e.getMessage());
//                dp.exit(1);
//            }
//
//            try (FileWriter writer = new FileWriter(file)) {
//                writer.write("color=shallow");
//                writer.write(System.lineSeparator());
//            } catch (IOException e) {
//                dp.error("在写入文件时发生了错误:");
//                dp.error("  " + e.getMessage());
//                JOptionPane.showMessageDialog(null, "在写入文件时发生了错误:\n    " + e.getMessage());
//                dp.exit(1);
//            }
//        }
//
//        String color = null;
//
//        try (FileInputStream fis = new FileInputStream(PropertiesPath)) {
//            Properties properties = new Properties();
//            properties.load(fis);
//            color = properties.getProperty("color");
//            for (String key : properties.stringPropertyNames()) {
//                String value = properties.getProperty(key);
//                dp.info("设置(" + PropertiesPath + "):");
//                dp.info("   " + key + " = " + value);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        File DataPathFile = new File(DataPath);
//        File[] FileList = DataPathFile.listFiles();
//        dp.info("记事(" + DataPathFile + "):");
//        for (File filec : FileList) {
//            dp.info("    " + filec.getName());
//        }
//
//        new Main(DataPath, color, PropertiesPath);
//    }
//
//    public Main(String DataPath, String color, String PropertiesPath) {
//        panel = new JPanel(new FlowLayout());
//        jf = new JFrame();
//        jf.setTitle("记事本");
//        jf.setSize(400, 300);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        if (color.equals("shallow")) {
//            jf.setBackground(Color.WHITE);
//        } else if (color.equals("deep")) {
//            jf.setBackground(Color.DARK_GRAY);
//        } else {
//            System.out.println(color);
//            dp.err("color = " + color, "错误的设置", 1);
//        }
//
//        jf.setVisible(true);
//        jf.setLocationRelativeTo(null);
//        dp.info("w 记事本:窗口已加载(" + jf + jf.getBackground() + ")");
//        panel.setLayout(new FlowLayout());
//        JButton badd = new JButton("添加记事");
//        JButton bdel = new JButton("删除记事");
//        JButton blist = new JButton("查看记事");
//        JButton bset = new JButton("设置");
//        JButton bexit = new JButton("退出");
//
//        badd.addActionListener(e -> {
//            dp.info("b badd:点击");
//            panel.remove(badd);
//            panel.remove(bdel);
//            panel.remove(blist);
//            panel.remove(bexit);
//            panel.remove(bset);
//            panel.revalidate();
//            panel.repaint();
//            add.add(DataPath);
//        });
//
//        bdel.addActionListener(e -> {
//            dp.info("b bdel:点击");
//            panel.remove(badd);
//            panel.remove(bdel);
//            panel.remove(blist);
//            panel.remove(bexit);
//            panel.remove(bset);
//            panel.revalidate();
//            panel.repaint();
//            del.delinp(DataPath);
//        });
//
//        blist.addActionListener(e -> {
//            dp.info("b blist:点击");
//            panel.remove(badd);
//            panel.remove(bdel);
//            panel.remove(blist);
//            panel.remove(bexit);
//            panel.remove(bset);
//            panel.revalidate();
//            panel.repaint();
//            LookNotepad.LookNotepad(DataPath);
//        });
//
//        bset.addActionListener(e -> {
//            dp.info("b bset:点击");
//            panel.remove(badd);
//            panel.remove(bdel);
//            panel.remove(blist);
//            panel.remove(bexit);
//            panel.remove(bset);
//            set.set(color, PropertiesPath);
//        });
//
//        bexit.addActionListener(e -> {
//            dp.info("b bexit:点击");
//            dp.exit(0);
//        });
//
//        panel.add(badd);
//        panel.add(bdel);
//        panel.add(blist);
//        panel.add(bset);
//        panel.add(bexit);
//        dp.info("w 记事本:按钮已加载");
//        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        jf.setExtendedState(JFrame.NORMAL);
//        jf.add(panel);
//    }
//}