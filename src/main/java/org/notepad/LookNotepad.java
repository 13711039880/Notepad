package org.notepad;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Stream;

public interface LookNotepad {
    static void main(File DataPath) {
        Main.jf.setTitle("查看记事");
        JButton ball = new JButton("所有记事");
        JButton bfind = new JButton("搜索记事");
        JButton bdetailed = new JButton("详细记事");
        JButton bback = new JButton("返回");

        ball.addActionListener(ballE -> {
            dp.info("b ball:点击");
            Main.panel.remove(ball);
            Main.panel.remove(bfind);
            Main.panel.remove(bdetailed);
            Main.panel.remove(bback);
            Main.panel.revalidate();
            Main.panel.repaint();
            Main.jf.setTitle("查看记事 - 所有记事");
            Main.panel.add(bback);
            dp.info("w 查看记事_所有记事:按钮已加载");
            dp.info("b ball:点击");
            File DataPathFile = new File(String.valueOf(DataPath));
            File[] FileListOriginal = DataPathFile.listFiles();
            JLabel ThingList = new JLabel("<html>" + getFileNames(Objects.requireNonNull(FileListOriginal)) + "</html>");
            Main.panel.add(ThingList);
        });
        bfind.addActionListener(bfindE -> {
            dp.info("b bfind:点击");
            Main.panel.remove(ball);
            Main.panel.remove(bdetailed);
            Main.panel.remove(bback);
            Main.panel.revalidate();
            Main.panel.repaint();
            Main.jf.setTitle("查看记事 - 搜索记事");
            JButton bfind_CreDate = new JButton("日期搜索");
            JButton bfind_ThingName = new JButton("记事名搜索");
            Main.panel.remove(bfind);
            bfind_CreDate.addActionListener(bfind_CreDate_E -> {
                dp.info("b bfind_CreDate:点击");
                Main.jf.setTitle("查看记事 - 搜索记事(日期搜索)");
                Main.panel.remove(bfind_CreDate);
                Main.panel.remove(bfind_ThingName);
                Main.panel.remove(bback);
                Main.panel.revalidate();
                Main.panel.repaint();
                JLabel ThingListTip = new JLabel("年, 月, 日");
                Main.panel.add(ThingListTip);
                dp.info("w 查看记事_搜索记事_日期搜索:提示已加载");
                JTextField icy = new JTextField(20);
                Main.panel.add(icy);
                JTextField icm = new JTextField(20);
                Main.panel.add(icm);
                JTextField icd = new JTextField(20);
                Main.panel.add(icd);
                dp.info("w 查看记事_搜索记事_日期搜索:输入框已加载");
                JButton bfindst = new JButton("搜索");
                bfindst.addActionListener(bfindstE -> {
                    StringBuilder ThingListString = new StringBuilder("搜索到的结果:\n     ");
                    File DataPathFile = new File(String.valueOf(DataPath));
                    File[] FileList = DataPathFile.listFiles();
                    dp.info("搜索(" + DataPathFile + "):");
                    for (File file : Objects.requireNonNull(FileList)) {
                        try (FileInputStream fis = new FileInputStream(file.getPath())) {
                            dp.info("   " + file.getPath());
                            Properties properties = new Properties();
                            properties.load(fis);
                            String ct = properties.getProperty("CreTimeY") + "." + properties.getProperty("CreTimeM") + "." + properties.getProperty("CreTimeD");
                            String it = icy.getText() + "." + icm.getText() + "." + icd.getText();
                            if (ct.equals(it)) {
                                ThingListString.append(file.getName()).append("\n     ");
                            }
                        } catch (IOException FindThing) {
                            dp.error("错误:");
                            FindThing.printStackTrace();
                        }
                    }
                    JOptionPane.showMessageDialog(null, ThingListString.toString());
                });
                Main.panel.add(bfindst);
                Main.panel.add(bback);
                dp.info("w 查看记事_搜索记事_日期搜索:按钮已加载");
            });
            bfind_ThingName.addActionListener(bfind_CreDate_E -> {
                dp.info("b bfind_ThingName:点击");
                Main.jf.setTitle("查看记事 - 搜索记事(记事名搜索)");
                Main.panel.remove(bfind_CreDate);
                Main.panel.remove(bfind_ThingName);
                Main.panel.remove(bback);
                Main.panel.revalidate();
                Main.panel.repaint();
                JTextField inp = new JTextField(20);
                inp.setText("名");
                Main.panel.add(inp);
                dp.info("w 查看记事_搜索记事_记事名搜索:输入框已加载");
                JButton bfindst = new JButton("搜索");
                bfindst.addActionListener(bfindstE -> {
                    StringBuilder ThingListSt = new StringBuilder("搜索到的结果:");
                    try (Stream<Path> paths = Files.walk(DataPath.toPath())) {
                        List<Path> files = paths.filter(Files::isRegularFile).filter(path -> path.getFileName().toString().contains(inp.getText())).toList();
                        for (Path file : files) {
                            ThingListSt.append("\n").append(removeSuffix(file.getFileName().toString()));
                        }
                    } catch (IOException FindThing) {
                        dp.err(FindThing.getMessage(), "搜索记事记事时发生了错误", 1);
                    }
                    JOptionPane.showMessageDialog(null, ThingListSt.toString());
                    dp.gomain();
                });
                Main.panel.add(bfindst);
                Main.panel.add(bback);
                dp.info("w 查看记事_搜索记事_记事名搜索:按钮已加载");
            });
            Main.panel.add(bfind_CreDate);
            Main.panel.add(bfind_ThingName);
            Main.panel.add(bback);
            dp.info("w 查看记事_搜索记事:按钮已加载");
        });
        bdetailed.addActionListener(bdetailedE -> {
            Main.panel.remove(ball);
            Main.panel.remove(bdetailed);
            Main.panel.remove(bback);
            Main.panel.remove(bfind);
            Main.panel.revalidate();
            Main.panel.repaint();
            dp.info("b bdetailed:点击");
            JTextField ThingNameInp = new JTextField(20);
            ThingNameInp.setText("记事名");
            Main.panel.add(ThingNameInp);
            dp.info("w 查看记事_详细记事:输入框已加载");
            JButton blook = new JButton("查看");
            blook.addActionListener(blookE -> {
                File ThingPath = new File(DataPath + "\\" + ThingNameInp.getText() + ".ntp");
                if (ThingPath.exists()) {
                    try (FileInputStream fis = new FileInputStream(ThingPath)) {
                        Properties properties = new Properties();
                        properties.load(fis);
                        String ContentValue = properties.getProperty("content");
                        JOptionPane.showMessageDialog(null, "内容:\n" + ContentValue);
                    } catch (IOException ReadThing) {
                        dp.error("错误:");
                        ReadThing.printStackTrace();
                        dp.err(ReadThing.getMessage(), "读取记事时发生了错误", 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "记事不存在");
                }
                dp.gomain();
            });
            Main.panel.add(bback);
            Main.panel.add(blook);
        });
        dp.info("w 查看记事_详细记事:按钮已加载");
        bback.addActionListener(bbackE -> {
            dp.info("b bback:点击");
            dp.gomain();
        });
        Main.panel.add(ball);
        Main.panel.add(bfind);
        Main.panel.add(bdetailed);
        Main.panel.add(bback);
        dp.info("w 查看记事:按钮已加载");
    }

    private static String getFileNames(File[] fileList) {
        StringBuilder fileNames = new StringBuilder();
        for (File file : fileList) {
            String fileName = file.getName().replace(".ntp", "");
            fileNames.append(fileName).append("<br>");
        }
        return fileNames.toString();
    }

    static String removeSuffix(String FileName) {
        Path path = Paths.get(FileName);
        return path.getFileName().toString().replaceAll("\\.[^.]+$", "");
    }
}
