package test;

import javax.swing.*;
import java.io.File;

public class DialogTest {

    public JFileChooser dialog = new JFileChooser();

    public void Start(){
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setDialogTitle("Виберіть потрібні файли і папки (Дорожко Андрій КН-19)");
        dialog.setApproveButtonText("Відкрити");
        dialog.setMultiSelectionEnabled(true);
        dialog.showOpenDialog(null);
        File[] ff = dialog.getSelectedFiles();
        if(ff != null){
            for (File f : ff)
                System.out.println(f.getAbsolutePath());
        }
    }
}
