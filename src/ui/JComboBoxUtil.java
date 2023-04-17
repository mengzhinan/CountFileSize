package ui;

import javax.swing.*;

public class JComboBoxUtil {

    public static final long UNIT_KB_LONG = 1024;
    public static final long UNIT_MB_LONG = 1024 * 1024;
    public static final long UNIT_GB_LONG = 1024 * 1024 * 1024;
    private static final String UNIT_KB = "KB";
    private static final String UNIT_MB = "MB";
    private static final String UNIT_GB = "GB";

    private static long finalUnitLong = UNIT_MB_LONG;
    private static String finalUnitStr = UNIT_MB;

    public static long getUnitLong() {
        return finalUnitLong;
    }

    public static String getUnitStr() {
        return finalUnitStr;
    }

    private static final String[] LIST_DATA = {UNIT_KB, UNIT_MB, UNIT_GB};

    public static void addJComboBox(JPanel panel) {
        JComboBox<String> jComboBox = new JComboBox<String>(LIST_DATA);
        jComboBox.setBounds(0, 0, 100, 50);
        jComboBox.setSelectedIndex(1);
        jComboBox.addActionListener(e -> {
            UnitBean unitBean = countUnitLong(jComboBox);
            finalUnitLong = unitBean.unitLong;
            finalUnitStr = unitBean.unitStr;
        });
        panel.add(jComboBox);
    }

    public static UnitBean countUnitLong(JComboBox<String> jComboBox) {
        UnitBean unitBean = new UnitBean();
        unitBean.unitLong = UNIT_MB_LONG;
        unitBean.unitStr = UNIT_MB;
        if (jComboBox == null) {
            return unitBean;
        }
        String value = String.valueOf(jComboBox.getSelectedItem());
        if (UNIT_KB.equals(value)) {
            unitBean.unitLong = UNIT_KB_LONG;
            unitBean.unitStr = UNIT_KB;
        } else if (UNIT_MB.equals(value)) {
            unitBean.unitLong = UNIT_MB_LONG;
            unitBean.unitStr = UNIT_MB;
        } else if (UNIT_GB.equals(value)) {
            unitBean.unitLong = UNIT_GB_LONG;
            unitBean.unitStr = UNIT_GB;
        }
        return unitBean;
    }

    private static class UnitBean {
        String unitStr;
        long unitLong;
    }
}
