package datatruct;

/**
 * @Classname MyArray
 * @Description 数组
 * @Date 2020/1/5 18:05
 * @Created by Tengxq
 */
public class MyArray<E> {
    private E[] data = null;
    private int size = 0;

    public MyArray() {
        this(10);
    }

    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int getSize() {
        return size;
    }

    public boolean isContains(E e) {
        return findIndex(e) != -1;
    }

    public int findIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int getCapacity() {
        return data.length;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index must bettwen 0 and size");
        }
        data[index] = e;

    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index must bettwen 0 and size");
        }
        return data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index must bettwen 0 and size");
        }
        E e = data[index];
        for (int i = index; i < size; i--) {
            data[i] = data[i + 1];
        }
        data[size] = null;
        size--;
        if (size == getCapacity() / 2 && getCapacity() / 2 != 0) {
            resize(size / 2);
        }
        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = findIndex(e);
        if (index != -1) {
            remove(findIndex(e));
        }
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(getSize() - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < size - 1; i++) {
            res.append(data[i] + ",");
        }
        res.append(data[size - 1] + "]");
        return res.toString();
    }


    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>();
        for (int i = 1; i < 10; i++) {
            array.addLast(i);
        }
        array.add(10, 10);
        System.out.println(array.getCapacity());
        System.out.println(array.getSize());
        array.addLast(10);
        array.addLast(11);
        System.out.println(array.toString());
        System.out.println(array.getCapacity());
        System.out.println(array.getSize());
    }
}
