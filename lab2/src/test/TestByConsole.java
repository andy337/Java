package test;

import model.Cilinder;
import model.IWeight;
import model.Timber;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

import java.util.Scanner;

public class TestByConsole {

    private Scanner scan = new Scanner(System.in);
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public void Start(){
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
                    alive = false;
                    break;
            }
        }
    }

    private void addWood(){
        System.out.println("Ведіть деревину: id, name, density");
        scan.nextLine();
        String s = scan.nextLine();
        String[] str = s.split(" ");
        wd.add(new Wood(Integer.parseInt(str[0]),str[1],Float.parseFloat(str[2])));
    }

    private void addTimber(){
        System.out.println("Введіть брусок: id, length, height, width");
        scan.nextLine();
        String s = scan.nextLine();
        String[] str = s.split(" ");
        ps.add(new Timber(wd.get(Integer.parseInt(str[0])),Float.parseFloat(str[1]),Float.parseFloat(str[2]),Float.parseFloat(str[3])));
    }

    private void addCilinder(){
        System.out.println("Введіть циліндер: id, diameter, length");
        scan.nextLine();
        String s = scan.nextLine();
        String[] str = s.split(" ");
        ps.add(new Cilinder(wd.get(Integer.parseInt(str[0])),Float.parseFloat(str[1]),Float.parseFloat(str[2])));
    }

    private void calcWeight() {
        float fullWeight = 0;
        for(Object arr : ps.getArr()){
            fullWeight += ((IWeight)arr).weight();
        }
        System.out.println(fullWeight);
    }
}
