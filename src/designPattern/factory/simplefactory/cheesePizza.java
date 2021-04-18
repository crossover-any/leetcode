package designPattern.factory.simplefactory;

/**
 * @Classname cheesePizza
 * @Description TODO
 * @Date 2019/12/30 21:47
 * @Created by Tengxq
 */
public class cheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给奶酪披萨准备原材料");
    }
}
