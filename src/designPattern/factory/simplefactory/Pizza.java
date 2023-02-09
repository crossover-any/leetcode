package designPattern.factory.simplefactory;

/**
 * @Classname Pizza
 * @Description TODO
 * @Date 2019/12/30 21:41
 * @Created by Tengxq
 */
public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake() {
        System.out.println(name + "is baking");
    }

    public void cut() {
        System.out.println(name + "is cuting");
    }

    public void box() {
        System.out.println(name + "is boxing");
    }
}
