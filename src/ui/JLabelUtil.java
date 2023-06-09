package ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Locale;

public class JLabelUtil {

    private static JLabel label;
    private static final String TEXT_DEFAULT = "显示计算结果";

    private static final String BR = "<br/>";

    private static JLabel getLabel() {
        if (label == null) {
            label = new JLabel();
        }
        return label;
    }

    public static void addLabel(JPanel panel) {
        getLabel().setText(TEXT_DEFAULT);
        getLabel().setFont(new Font("", 1, 16));
        getLabel().setHorizontalTextPosition(JLabel.RIGHT);
        getLabel().setForeground(Color.BLUE);
        getLabel().setBackground(Color.decode("#DDDDDD"));
        getLabel().setOpaque(true);
//        getLabel().setBorder(new CompoundBorder());//？没用
//        getLabel().setBounds(0,0,Util.getScreenWidth(),Util.getScreenHeight());//？没用
//        getLabel().setSize(Util.getScreenWidth(), Util.getScreenHeight());//？没用
        panel.add(getLabel());
    }

    public static void resetLabel() {
        getLabel().setText(TEXT_DEFAULT);
    }

    public static void setLabelText(File[] files, long unitLong, String unitStr) {
        if (getLabel() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("<html>");
        String labelText = getLabel().getText().replace("<html>", "").replace("</html>", "");
        if (!TEXT_DEFAULT.contentEquals(labelText)) {
            sb.append(labelText);
        }
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (!file.exists()) {
                sb.append(file.getName());
                sb.append(" -> 文件不存在");
                sb.append(BR);
                sb.append(BR);
            } else {
                sb.append(file.getName());
                sb.append(" -> 大小为：");
                sb.append(getFileSizeStr(file.length() * 1.0F / unitLong));
                sb.append(" ");
                sb.append(getSizeUnitStr(unitStr.toUpperCase(Locale.ROOT)));
                sb.append(BR);
                sb.append(BR);
            }
        }
        sb.append("</html>");
        getLabel().setText(sb.toString());
    }

    private static String getFileSizeStr(float sizeF) {
        return makeColorFont(String.valueOf(sizeF), "#FF0000");
    }

    private static String getSizeUnitStr(String unitStr) {
        return makeColorFont(unitStr, "#000000");
    }

    /**
     * 拼接 font 标签
     *
     * @param text     text
     * @param colorStr colorStr
     * @return html
     */
    private static String makeColorFont(String text, String colorStr) {
        StringBuilder sb = new StringBuilder();
        sb.append("<font color=\"");
        sb.append(colorStr);
        sb.append("\">");
        sb.append(text);
        sb.append("</font>");
        return sb.toString();
    }

}
