package test;

import model.*;
import store.AbstractStore;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.*;
import java.util.Iterator;
import java.util.ListIterator;

public class TestApp {

    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();
    public AbstractStore ts = new AbstractStore();

    public static void main(String[] args) throws Exception {
        TestApp app = new TestApp();
        app.startApp();

        //TestByConsole tb = new TestByConsole();
        //tb.Start();
    }

    private float calcWeight() {
        float fullWeight = 0;
        for(Object arr : ps.getArr()){
            fullWeight += ((IWeight)arr).weight();
        }
        return fullWeight;
    }

    private void startApp() throws Exception {
        try{
            wd.add(new Wood(0,"Дуб", 1.5f));
            wd.add(new Wood(1,"Сосна", 1.7f));
            wd.add(new Wood(2,"Липа", 2.4f));
            wd.add(new Wood(3, "Груша", 1.2f));

            ps.add(new Timber(wd.get(0),5f,0.5f,0.4f));
            ps.add(new Timber(wd.get(1), 10f,0.5f, 0.4f));
            ps.add(new Cilinder(wd.get(2),1.2f,4.3f));

            //ps.add(new Waste(0.020));

            System.out.println(wd);
            System.out.println(ps);

            System.out.println("Загальна вага: " + calcWeight());

            System.out.println("Перелік виробів до вилучення");
            System.out.println(ps.toString());

            /*Iterator<Object> itr = ps.iterator();
            while(itr.hasNext()){
                IWeight obj = (IWeight) itr.next();
                if(obj.weight() > 10.3f) itr.remove();
            }*/

            ListIterator<Object> litr = ps.listIterator();
            litr.add(new Cilinder(wd.get(3),1.4f, 3.2f));

            while(litr.hasNext()){
                IWeight obj = (IWeight) litr.next();
                if(obj.weight() > 10.3f)
                    litr.remove();
            }

            System.out.println("Перелік виробів після вилучення");
            System.out.println(ps.toString());

        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
    }
}
