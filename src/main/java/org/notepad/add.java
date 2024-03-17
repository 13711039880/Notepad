package org.notepad;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public interface add {
    static void main(File DataPath) {
        Main.jf.setTitle("添加记事");
        JTextField iname = new JTextField(20);
        JTextField icontent = new JTextField(20);
        iname.setText("记事名");
        icontent.setText("记事内容(用反\\n换行)");
        Main.panel.add(iname);
        Main.panel.add(icontent);
        dp.info("w 添加记事:输入框已加载");
        JButton badd = new JButton("确定");
        JButton bcancel = new JButton("取消");

        badd.addActionListener(e -> {
            dp.info("b badd:点击");
            String name = iname.getText();
            String content = icontent.getText();
            String cre = DataPath + "\\" + name + ".ntp";
            dp.info("记事名:" + cre);
            Path path = Paths.get(cre);
            dp.info("正在创建...");

            if (Files.exists(path)) {
                dp.warn("记事已存在");
                JOptionPane.showMessageDialog(null, "记事已存在");
                dp.gomain();
            } else {
                try {
                    Files.createFile(path);
                } catch (Exception DelThing) {
                    dp.error("创建文件时发生了错误:");
                    throw new RuntimeException(DelThing);
                }

                Calendar calendar = Calendar.getInstance();
                int CreTimeY = calendar.get(Calendar.YEAR);
                int CreTimeM = calendar.get(Calendar.MONTH) + 1;
                int CreTimeD = calendar.get(Calendar.DAY_OF_MONTH);

                try (FileWriter fileWriter = new FileWriter(cre);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write("content=" + content + "\nCreTimeY=" + CreTimeY + "\nCreTimeM=" + CreTimeM + "\nCreTimeD=" + CreTimeD);
                    dp.info("Ntp(" + cre + ")写入成功:");
                    dp.info("    " + "content=" + content + "\n                   CreTimeY" + CreTimeY + "\n                   CreTimeM" + CreTimeM + "\n                   CreTimeD" + CreTimeD);
                    bufferedWriter.flush();
                } catch (IOException WriteJson) {
                    dp.error("写入文件时发生了错误:");
                    WriteJson.printStackTrace();
                }

                dp.info("创建成功");
                JOptionPane.showMessageDialog(null, "创建成功");
                dp.gomain();
            }
        });

        bcancel.addActionListener(e -> {
            dp.info("b bcancel:点击");
            dp.gomain();
        });

        Main.panel.add(badd);
        Main.panel.add(bcancel);
        dp.info("w 添加记事:按钮已加载");
    }
}
