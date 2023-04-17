package ui;

import javax.swing.*;
import java.io.File;
import java.util.Locale;

public class JLabelUtil {

    private static JLabel label;
    private static final String TEXT_DEFAULT = "显示计算结果";

    private static JLabel getLabel() {
        if (label == null) {
            label = new JLabel();
        }
        return label;
    }

    public static void addLabel(JPanel panel) {
        getLabel().setSize(Util.getScreenWidth(), Util.getScreenHeight());
        getLabel().setText(TEXT_DEFAULT);
        panel.add(getLabel());
    }

    public static void resetLabel() {
        getLabel().setText(TEXT_DEFAULT);
    }

    public static void setLabelText(File[] files, long unitLong, String unitStr) {
        if (getLabel() == null) {
            return;
        }
        StringBuffer sb = new StringBuffer();
        String labelText = getLabel().getText();
        if (!TEXT_DEFAULT.contentEquals(labelText)) {
            sb.append(labelText);
            sb.append("\r\n");
        }
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (!file.exists()) {
                sb.append(file.getName());
                sb.append(" -> 文件不存在");
                sb.append("\r\n");
            } else {
                sb.append(file.getName());
                sb.append(" -> 大小为：");
                sb.append(file.length() * 1.0F / unitLong);
                sb.append(" ");
                sb.append(unitStr.toUpperCase(Locale.ROOT));
                sb.append("\r\n");
            }
        }
        getLabel().setText(sb.toString());
    }

}
