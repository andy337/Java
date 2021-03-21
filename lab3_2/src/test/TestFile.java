package test;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class TestFile {

    public static void main(String[] args) {
        JFileChooser dialog = new JFileChooser();
        dialog.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f != null){
                    return f.isDirectory() || f.toString().endsWith(".txt");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "Файл типу *.txt";
            }
        });
        dialog.showOpenDialog(null);
        File f = dialog.getSelectedFile();


        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write("Дорожко Андрій КН-19");
            writer.newLine();
            writer.close();
        }
        catch (Exception ex){}
        if(f != null){
            System.out.println(f.getName());
            System.out.println(f.getAbsolutePath());
        }

        BufferedReader reader = null;
        if(f != null){
            try{
                reader = new BufferedReader(new FileReader(f));
                String s;
                while ((s = reader.readLine()) != null){
                    System.out.println(s);
                }
                reader.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
