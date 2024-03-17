package org.notepad;

import javax.swing.*;
import java.util.Calendar;

public interface dp {
    static void gomain() {
        info("w 窗口已关闭");
        Main.jf.dispose();
        Main.main(new String[]{"a"});
    }

    static void info(String info) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("[" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + " INFO]" + info);
    }

    static void warn(String info) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("\033[33m[" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + " WARN]" + info + "\033[0m");
    }

    static void error(String info) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("\033[31m[" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + " ERROR]" + info + "\033[0m");
    }

    static void exit(int status) {
        info("退出 退出码:" + status);
        System.exit(status);
    }

    static void err(String ErrInfo, String ErrTitle, int ExitStatus) {
        dp.error(ErrTitle + ":");
        dp.error("  " + ErrInfo);
        JOptionPane.showMessageDialog(Main.jf, ErrTitle + ":\n    " + ErrInfo);
        exit(ExitStatus);
    }
}