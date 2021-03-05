package store;
import model.IWeight;
import java.util.Arrays;

public class ProductStore extends AbstractStore {

    public void add(IWeight newForm) {
        if (arr.length == count) {
            arr = Arrays.copyOf(arr, count + count / 2);
        }
        arr[count++] = newForm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Вміст сховища продуктів:\n");
        sb.append(super.toString());
        return sb.toString();
        }
}
