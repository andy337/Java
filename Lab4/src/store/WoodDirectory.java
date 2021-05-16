package store;

import model.Wood;
import java.io.Serializable;

import java.util.Arrays;

public class WoodDirectory extends AbstractStore implements Serializable {

    public Wood get(int id){
        for(int i = 0; i < count; i++){
            Wood wood = (Wood) arr[i];
            if(wood.getId() == id){
                return wood;
            }
        }
        return null;
    }

    public boolean add(Wood newWood){
        if(get(newWood.getId()) != null){
            return false;
        }
        if(arr.length == count){
            arr = Arrays.copyOf(arr,count + count/2);
        }
        super.add(newWood);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Каталог древини:\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
