package datatruct;

import datatruct.util.Queue;

/**
 * @Classname LoopQueue
 * @Description TODO
 * @Date 2020/1/8 22:16
 * @Created by Tengxq
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] queue;
    private int front = 0;
    private int tail = 0;
    private int size = 0;
    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int capacity){
        queue = (E[]) new Object[capacity];
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return queue.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail+1 % queue.length == 0){
            reSize(queue.length*2);
        }
        queue[tail++] = e;
        size++;
    }

    private void reSize(int newCapacity) {
        E[] newQueue = (E[]) new Object[newCapacity];
        for (int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[(i+front)%queue.length];
        }
        queue = newQueue;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new NullPointerException("queue is emtpty");
        }
        tail = (tail+1)%queue.length;
        size--;
        if (tail == queue.length/2 && size/2!=0){
            reSize(size);
        }
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
