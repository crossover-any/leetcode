package datatruct;

import datatruct.util.Queue;

/**
 * @Classname ArrayQueue
 * @Description TODO
 * @Date 2020/1/8 22:08
 * @Created by Tengxq
 */
public class ArrayQueue<E> implements Queue<E> {
    private MyArray<E> queue;

    public ArrayQueue(int capacity){
        queue = new MyArray(capacity);
    }

    public ArrayQueue(){
        queue = new MyArray<>();
    }
    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

    @Override
    public E getFront() {
        return queue.getFirst();
    }
}
