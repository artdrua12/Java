package main.homework.lesson19.Star;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<String> products = new ArrayList<>();

    public synchronized int buy() {
        if (this.products.size() > 0) {
            products.remove(products.size() - 1);
            return 1;
        } else {
            return 0;
        }
    }

    public synchronized int addProduct(String product) {
        if (this.products.size() < 3) {
            this.products.add(product);
            return 1;
        } else {
            return 0;
        }
    }

}
