package designPattern.factory.simplefactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Classname OrderPizza
 * @Description TODO
 * @Date 2019/12/30 21:50
 * @Created by Tengxq
 */
public class OrderPizza {

    public OrderPizza() {
        String type = getType();
        Pizza pizza = null;
        do {
            if ("cheesePizza".equals(type)) {
                pizza = new cheesePizza();
            } else if ("greekPizza".equals(type)) {
                pizza = new GreekPizza();
            } else {
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String type = reader.readLine();
            return type;
        } catch (Exception e) {
            return "";
        }
    }
}
