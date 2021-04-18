package designPattern.factory.simplefactory;

/**
 * @Classname GreekPizza
 * @Description TODO
 * @Date 2019/12/30 21:48
 * @Created by Tengxq
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给希腊披萨准备原材料");
    }
}
