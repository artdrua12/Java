package main.homework.lesson19.Star;

public class Buyer implements Runnable {
    private Store store;

    public Buyer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("Покупатель идет за покупками");
        while (store.buy() == 1) {
            System.out.println("Конфета куплена");
        }
    }

}
