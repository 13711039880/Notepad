package org.notepad;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface del {
    static void delinp(File DataPath) {
        Main.jf.setTitle("删除记事");
        JTextField inp = new JTextField(20);
        inp.setText("记事名");
        Main.panel.add(inp);
        dp.info("w 删除记事:输入框已加载");
        JButton bcancel = new JButton("取消");
        JButton bdel = new JButton("删除");

        bcancel.addActionListener(e -> {
            dp.info("b bcancel:点击");
            dp.gomain();
        });

        bdel.addActionListener(e -> {
            dp.info("b bdel:点击");
            String delname = inp.getText();
            Main.panel.remove(inp);
            Main.panel.remove(bcancel);
            Main.panel.remove(bdel);
            Main.panel.revalidate();
            Main.panel.repaint();
            delconfirm(delname, DataPath);
        });

        Main.panel.add(bcancel);
        Main.panel.add(bdel);
        dp.info("w 删除记事:按钮已加载");
    }

    static void delconfirm(String OriginalDelname, File DataPath) {
        Main.jf.setTitle("删除记事");
        JButton bdetermine = new JButton("确定");
        JButton bcancel = new JButton("取消");

        bdetermine.addActionListener(e -> {
            dp.info("b bdetermine:点击");
            String delname = DataPath + "\\" + OriginalDelname + ".ntp";
            dp.info("记事名:" + delname);
            Path path = Paths.get(delname);

            if (Files.exists(path)) {
                dp.info("正在删除...");
                dp.gomain();

                try {
                    Files.deleteIfExists(path);
                    Files.delete(path);
                } catch (Exception DelThing) {
                    dp.error("错误:");
                    throw new RuntimeException(DelThing);
                }
            } else {
                dp.warn("记事不存在");
                JOptionPane.showMessageDialog(null, "记事不存在");
                dp.gomain();
            }
        });

        bcancel.addActionListener(e -> {
            dp.info("b bcancel:点击");
            dp.gomain();
        });

        Main.panel.add(bcancel);
        Main.panel.add(bdetermine);
        dp.info("w 确认删除:按钮已加载");
        JTextField text = new JTextField(20);
        text.setText("确认删除?");
        text.setEditable(false);
        Main.panel.add(text);
        dp.info("w 确认删除:提示框已加载");
        Main.jf.add(Main.panel);
    }
}