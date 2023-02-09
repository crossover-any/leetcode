package datatruct;

import datatruct.util.Stack;

/**
 * @Classname ArrayStack
 * @Description TODO
 * @Date 2020/1/6 22:20
 * @Created by Tengxq
 */
public class ArrayStack<E> implements Stack<E> {
    MyArray<E> array;

    public ArrayStack(int capacity) {
        array = new MyArray<>(capacity);
    }

    public ArrayStack() {
        array = new MyArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }


    @Override
    public E pop() {
        E e = array.getLast();
        array.removeLast();
        return e;
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity() {
        return array.getCapacity();
    }
}
