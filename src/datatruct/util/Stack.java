package datatruct.util;

/**
 * @Classname Stack
 * @Description TODO
 * @Date 2020/1/6 22:18
 * @Created by Tengxq
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
