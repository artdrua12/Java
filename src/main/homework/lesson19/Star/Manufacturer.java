package main.homework.lesson19.Star;

public class Manufacturer implements Runnable {

    private Store store;

    public Manufacturer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("Запускаем производителя");
        try {
            genereteProduct();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void genereteProduct() throws InterruptedException {
        while (store.addProduct("конфета") == 1) {
            System.err.println("Конфета добавлена");
        }
        Thread t = Thread.currentThread();
        t.sleep(100);
    }

}
