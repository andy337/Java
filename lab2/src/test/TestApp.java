package test;

import model.*;
import store.ProductStore;
import store.WoodDirectory;

public class TestApp {

    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public static void main(String[] args) {
        TestApp app = new TestApp();
        TestByConsole test = new TestByConsole();
        app.startApp();
        test.Start();
    }

    private float calcWeight() {
        float fullWeight = 0;
        for(Object arr : ps.getArr()){
            fullWeight += ((IWeight)arr).weight();
        }
        return fullWeight;
    }

    private void startApp(){
        wd.add(new Wood(0,"Дуб", 1.5f));
        wd.add(new Wood(1,"Сосна", 1.7f));
        wd.add(new Wood(2,"Липа", 2.4f));

        ps.add(new Timber(wd.get(0),5f,0.5f,0.4f));
        ps.add(new Timber(wd.get(1), 10f,0.5f, 0.4f));
        ps.add(new Cilinder(wd.get(2),1.2f,4.3f));

        System.out.println(wd);
        System.out.println(ps);

        System.out.println("Загальна вага: " + calcWeight());
    }
}
