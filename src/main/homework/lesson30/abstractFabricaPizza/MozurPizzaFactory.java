package main.homework.lesson30.abstractF;

public class MozurPizzaFactory extends PizzaStore {

    @Override
    Pizza creatPizza(String type) {
        if (type.equals("cheese")) {
            return new MozurStyleCheesePizza();
        } else {
            return new MozurStylePepperoniPizza();
        }
    }

}
