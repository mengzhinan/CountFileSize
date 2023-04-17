package ui;

import javax.swing.*;
import java.io.File;

public class JFileChooserUtil {

    private static JFileChooser fileChooser;

    public static void showFileChooserDialog(JFrame frame, OnFileSelectInterface listener) {
        if (fileChooser != null) {
            return;
        }
        fileChooser = new JFileChooser(".");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        int status = fileChooser.showOpenDialog(frame);
        File[] files = fileChooser.getSelectedFiles();
        if (status == JFileChooser.OPEN_DIALOG && files != null && files.length > 0) {
            if (listener != null) {
                listener.onFileSelected(files);
            }
        }
        fileChooser = null;
    }

    interface OnFileSelectInterface {
        void onFileSelected(File[] files);
    }

}
