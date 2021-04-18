package datatruct.util;

/**
 * @Classname Queue
 * @Description TODO
 * @Date 2020/1/8 22:07
 * @Created by Tengxq
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e );
    E dequeue();
    E getFront();
}
