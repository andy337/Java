package store;

import model.Timber;

import java.util.Arrays;

public class ProductStore {

    private int count = 0;
    private Timber[] tb = new Timber[3];

    public Timber[] getArr(){
        return Arrays.copyOf(tb,count);
    }
    public void add(Timber newTimber){
        if(tb.length == count){
            tb = Arrays.copyOf(tb,count + count/2);
        }
        tb[count++] = newTimber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Каталог брусків:\n");
        for(int i = 0; i < count; i++){
            sb.append(tb[i]).append("\n");
        }
        return sb.toString();
    }
}
