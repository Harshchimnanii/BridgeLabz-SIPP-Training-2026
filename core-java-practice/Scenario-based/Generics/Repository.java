import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public List<T> findAll() {
        return new ArrayList<>(items);
    }
}
