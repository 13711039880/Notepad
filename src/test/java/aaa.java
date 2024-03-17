//import javax.swing.*;
//import java.io.File;
//import java.util.ArrayList;
//public class aaa {
//    public static void main(String[] args) {
//        String AppDataPath = "C:\\users\\" + System.getProperty("user.name") + "\\AppData\\Notepad\\";
//        String DataPath = AppDataPath + "Data\\";
//        String PropertiesPath = AppDataPath + "Notepad.properties";
//        ArrayList<String> ThingList = new ArrayList<>();
//        DefaultListCellRenderer cellRenderer = new DefaultListCellRenderer();
//        JList ThingListUI = new JList<>();
//        Main.panel.add(ThingListUI);
//        File DataPathFile = new File(DataPath);
//        File[] ThingFileList = DataPathFile.listFiles();
//        // 将文件列表转换为一个字符串
//        StringBuilder fileListStringBuilder = new StringBuilder();
//        for (File file : ThingFileList) {
//            fileListStringBuilder.append(file.getName()).append(" ");
//        }
//        String thingListAsString = fileListStringBuilder.toString();
//        // 创建一个 DefaultListCellRenderer
//
////        cellRenderer.setListCellRendererComponent(new DefaultListCellRenderer.DefaultListCell(thingListAsString));
//
//        // 将 DefaultListCellRenderer 添加到 JList
//        ThingListUI.setCellRenderer(cellRenderer);
//        // 显示窗口
//        Main.panel.setVisible(true);
//    }
//}


public class aaa {
    public static void main(String[] args) {
        String a = "aaa";
        System.out.println(a);
        a = a + "a";
        System.out.println(a);
    }
}