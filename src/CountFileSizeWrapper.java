import java.io.File;
import java.util.Locale;

public class CountFileSizeWrapper {
    private static final String UNIT_KB = "kb".toLowerCase(Locale.ROOT);
    private static final String UNIT_MB = "mb".toLowerCase(Locale.ROOT);
    private static final String UNIT_GB = "gb".toLowerCase(Locale.ROOT);
    private static final String UNIT_DEFAULT = UNIT_MB;
    private static final long UNIT_DEFAULT_LONG = 1024 * 1024;


    public static void main(String[] args) {
        if (!checkParams(args)) {
            System.out.println("格式说明：java -jar xxx/CountFileSize.jar xxx/a.txt xxx/b.app xxx/z.pdf [单位: KB/MB/GB]");
            System.out.println("例如：计算文件 a.txt, k.pdf 的大小，单位为 MB");
            System.out.println("Code>：java -jar xxx/CountFileSize.jar a.txt k.pdf MB");
            return;
        }
        String result = countFile(args);
        System.out.println(result);
    }

    private static boolean checkParams(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("请输入有效的参数！");
            return false;
        }
        return true;
    }

    private static String countFile(String[] args) {
        // args != null && args.length > 0
        String lastItem = args[args.length - 1].toLowerCase(Locale.ROOT);
        String unitStr = UNIT_DEFAULT;
        long unitLong = UNIT_DEFAULT_LONG;
        boolean hasUnit = false;
        if (UNIT_KB.equals(lastItem)) {
            unitStr = UNIT_KB;
            unitLong = 1024;
            hasUnit = true;
        } else if (UNIT_MB.equals(lastItem)) {
            unitStr = UNIT_MB;
            unitLong = 1024 * 1024;
            hasUnit = true;
        } else if (UNIT_GB.equals(unitStr)) {
            unitStr = UNIT_GB;
            unitLong = 1024 * 1024 * 1024;
            hasUnit = true;
        }
        StringBuilder sb = new StringBuilder(">>> 输出计算结果: \r\n");
        int lastIndex = args.length;
        if (hasUnit) {
            // 最后一个是单位参数，跳过
            lastIndex -= 1;
        }
        for (int i = 0; i < lastIndex; i++) {
            String item = args[i];
            File file = new File(item);
            if (!file.exists()) {
                sb.append(file.getName());
                sb.append(" 文件不存在");
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
