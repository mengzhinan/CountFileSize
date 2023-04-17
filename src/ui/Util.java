package ui;

import java.awt.*;

public class Util {

    private static Dimension getDimension() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static int getScreenWidth() {
        return (int) getDimension().getWidth();
    }

    public static int getScreenHeight() {
        return (int) getDimension().getHeight();
    }


}
