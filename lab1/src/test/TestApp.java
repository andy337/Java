package test;

import model.Timber;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

import java.util.Scanner;

public class TestApp {

    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public static void main(String[] args) {
        TestApp app = new TestApp();
        TestByConsole test = new TestByConsole();
        app.startApp();
        //test.Start();
    }

    private float calcWeight() {
        float fullWeight = 0;
        for(Timber timber : ps.getArr()){
            fullWeight+=timber.weight();
        }
        return fullWeight;
    }

    private void startApp(){
        ps.add(new Timber(wd.get(0),5f,0.5f,0.4f));
        ps.add(new Timber(wd.get(1), 10f,0.5f, 0.4f));
        wd.add(new Wood(3,"Дуб", 1.5f));

        System.out.println(wd);
        System.out.println(ps);

        System.out.println("Загальна вага: " + calcWeight());
    }
}
