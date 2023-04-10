import java.io.File;
import java.util.Locale;

public class CountFileSizeWrapper {
    private static final String BASE_PATH = "/Users/duke/Desktop/";
    private static final String UNIT_KB = "kb";
    private static final String UNIT_MB = "mb";
    private static final String UNIT_GB = "gb";
    private static final String UNIT_EXPLAIN = "KB, MB, GB";

    public static void main(String[] args) {
        if (!checkParams(args)) {
            System.out.println("参数说明(参数之间使用空格分割)：");
            System.out.println("参数1：KB");
            System.out.println("参数2：/User/xxx/a.txt");
            System.out.println("参数3：/User/xxx/f.txt");
            System.out.println("参数N：。。。");
            return;
        }
        String result = countFile(args);
        System.out.println(result);
    }

    private static boolean checkParams(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("请输入参数，格式化单位 和 文件路径");
            return false;
        }
        if (args.length < 2) {
            System.out.println("请输入文件路径");
            return false;
        }
        if (!args[0].toLowerCase(Locale.ROOT).equals(UNIT_KB)
                && !args[0].toLowerCase(Locale.ROOT).equals(UNIT_MB)
                && !args[0].toLowerCase(Locale.ROOT).equals(UNIT_GB)) {
            System.out.println("格式化单位必须是 " + UNIT_EXPLAIN + " 之一");
            return false;
        }
        return true;
    }

    private static String countFile(String[] args) {
        String unitStr = args[0].toLowerCase(Locale.ROOT);
        long unitLong = 1024;
        if (UNIT_MB.toLowerCase(Locale.ROOT).equals(unitStr)) {
            unitLong = 1024 * 1024;
        } else if (UNIT_GB.toLowerCase(Locale.ROOT).equals(unitStr)) {
            unitLong = 1024 * 1024 * 1024;
        }
        StringBuilder sb = new StringBuilder(">>> 输出计算结果: \r\n");
        // 第一个是单位参数，跳过
        for (int i = 1; i < args.length; i++) {
            String item = args[i];
            File file = new File(item);
            if (!file.exists()) {
                file = new File(BASE_PATH, item);
            }
            if (!file.exists()) {
                sb.append(file.getName());
                sb.append(" 不存在");
                sb.append("\r\n");
            } else {
                sb.append(file.getName());
                sb.append(" 大小为：");
                sb.append(file.length() * 1.0F / unitLong);
                sb.append(" ");
                sb.append(unitStr.toUpperCase(Locale.ROOT));
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

}
