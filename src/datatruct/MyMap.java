package datatruct;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/11/21 19:15
 * @Created by Tengxq
 */
public class MyMap {
    Entry[] array;
    int size;
    public MyMap(){
        this(10);
    }
    public MyMap(int initLength){
        array = new Entry[initLength];
    }
    // 扩容
    public Entry[] expandLength(Entry[] array){
        Entry[] newArray = new Entry[array.length * 2 + 1];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }
    public boolean put(Object key, Object value){
        if(size == array.length){
            array = expandLength(array);
        }
        // 判断键是否已经存在，存在的话则更新
        for(int i = 0; i < array.length; i++){
            if(array[i].key.equals(key)){
                array[i].value = value;
                return true;
            }
        }
        array[size] = new Entry(key, value);
        size++;
        return true;
    }
    public Object get(Object key){
        if(size != 0){
            for (int i = 0; i < size; i++){
                if(array[i].key.equals(key)){
                    return array[i].value;
                }
            }
        }
        return null;
    }
    public boolean containsKey(Object key){
        for(int i= 0; i < array.length; i++){
            if(array[i].key.equals(key))
                return true;
        }
        return false;
    }
    public boolean containsValue(Object value){
        for (int i = 0; i < array.length; i++){
            if(array[i].value.equals(value)){
                return true;
            }
        }
        return false;
    }
    public void clear(){
        Entry[] newArray = new Entry[array.length];
        array = newArray;
        size = 0;
    }
}
