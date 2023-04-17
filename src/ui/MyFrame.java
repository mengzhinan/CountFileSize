package ui;

import javax.swing.*;
import java.awt.*;

public class MyFrame {

    private static final String PAGE_TITLE = "Count File Real Size";

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(MyFrame::showUI);
    }

    private static void showUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame(PAGE_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Util.getScreenWidth(), Util.getScreenHeight());
        frame.setLocation(0, 0);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        addToTopJPanel(frame, topPanel);
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        addToCenterJPanel(centerPanel);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    private static void addToTopJPanel(JFrame frame, JPanel panel) {
        JComboBoxUtil.addJComboBox(panel);
        JButtonUtil.clearRecordButton(panel, e -> JLabelUtil.resetLabel());

        JButtonUtil.addFileButton(panel, e -> JFileChooserUtil.showFileChooserDialog(frame, files -> JLabelUtil.setLabelText(files, JComboBoxUtil.getUnitLong(), JComboBoxUtil.getUnitStr())));
    }

    private static void addToCenterJPanel(JPanel panel) {
        JLabelUtil.addLabel(panel);
    }

}
