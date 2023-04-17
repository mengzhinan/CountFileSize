package ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JButtonUtil {

    public static void clearRecordButton(JPanel panel, ActionListener listener) {
        JButton jButton = new JButton();
        jButton.setText("请空记录");
        jButton.addActionListener(listener);
        panel.add(jButton);
    }

    public static void addFileButton(JPanel panel, ActionListener listener) {
        JButton jButton = new JButton();
        jButton.setText("添加文件");
        jButton.addActionListener(listener);
        panel.add(jButton);
    }

}
