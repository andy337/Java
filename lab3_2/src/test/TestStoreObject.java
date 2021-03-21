package test;

import model.Wood;
import store.WoodDirectory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestStoreObject {

    public static void main(String[] args) {
        WoodDirectory wd = new WoodDirectory();
        wd.add(new Wood(4, "Дуб", 1f));
        wd.add(new Wood(5, "Липа", 2.3f));
        File f = new File("wd.object");
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wd);
            System.out.println("successful");
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
