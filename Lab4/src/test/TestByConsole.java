package test;

import model.Cilinder;
import model.IWeight;
import model.Timber;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TestByConsole {

    private Scanner scan = new Scanner(System.in);
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();
    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    private BufferedWriter writer;

    public void Start() throws Exception {
        try{
            writer = new BufferedWriter(new FileWriter("Log.txt",true));
            writeString("Андрій Дорожко КН-19");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        wd.add(new Wood(1, "Дуб", 3.2f));
        boolean alive = true;
        while(alive){
            System.out.println("1. Додати деревину: \n2. Додати брус \n3. Додати циліндр: \n4. Підрахувати загальну вагу");
            System.out.println("5. Завершити роботу");

            int command = scan.nextInt();

            switch (command){

                case 1:
                    addWood();
                    System.out.println(wd);
                    break;

                case 2:
                    addTimber();
                    System.out.println(ps);
                    break;

                case 3:
                    addCilinder();
                    break;

                case 4:
                    calcWeight();
                    break;

                case 5:
                    writer.close();
                    alive = false;
                    break;
            }
        }
    }

    private void writeString(String str){
        try{
            writer.write(dateFormat.format(System.currentTimeMillis()) + " ");
            writer.write(str);
            writer.newLine();
            writer.flush();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void serialization(Object obj){
        File f = new File("wd.object");
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void deserializationWood(){
        File f = new File("wd.object");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wd = (WoodDirectory) ois.readObject();
            ois.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void deserializationProduct(){
        File f = new File("ps.object");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wd = (WoodDirectory) ois.readObject();
            ois.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void addWood() {
        System.out.println("Ведіть деревину: id, name, density");
        scan.nextLine();
        String s = scan.nextLine();
        String[] str = s.split(" ");
        try{
            wd.add(new Wood(Integer.parseInt(str[0]),str[1],Float.parseFloat(str[2])));
            writeString(wd.get(Integer.parseInt(str[0])).toString());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("Спробуйте ще раз: ");
            addWood();
        }
    }

    private void addTimber() {
        System.out.println("Введіть брусок: id, length, height, width");
        scan.nextLine();
        String s = scan.nextLine();
        String[] str = s.split(" ");
        try {
            ps.add(new Timber(wd.get(Integer.parseInt(str[0])),Float.parseFloat(str[1]),Float.parseFloat(str[2]),Float.parseFloat(str[3])));
            writeString(ps.getArr()[Integer.parseInt(str[0])].toString());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("Спробуйте ще раз: ");
            addTimber();
        }
    }

    private void addCilinder() {
        System.out.println("Введіть циліндер: id, diameter, length");
        scan.nextLine();
        String s = scan.nextLine();
        String[] str = s.split(" ");
        try{
            ps.add(new Cilinder(wd.get(Integer.parseInt(str[0])),Float.parseFloat(str[1]),Float.parseFloat(str[2])));
            writeString(ps.getArr()[Integer.parseInt(str[0])].toString());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("Спробуйте ще раз: ");
            addCilinder();
        }
    }

    private void calcWeight() {
        float fullWeight = 0;
        for(Object arr : ps.getArr()){
            fullWeight += ((IWeight)arr).weight();
        }
        System.out.println(fullWeight);
    }
}
