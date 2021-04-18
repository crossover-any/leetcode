package niuke;

import datatruct.ListNode;

import java.util.*;

/**
 * @Classname FirstCharOfStream
 * @Description TODO
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @Date 2020/1/4 12:11
 * @Created by Tengxq
 */
public class FirstCharOfStream {
    Queue queue = new LinkedList();
    HashSet<ListNode> set = new HashSet<>();
    LinkedHashMap<Character, Integer> dic = new LinkedHashMap<>();

    public void Insert(char ch) {
        if (dic.containsKey(ch)) {
            dic.put(ch, dic.get(ch) + 1);
        } else {
            dic.put(ch, 1);
            StringBuilder s = new StringBuilder();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Iterator iterator = dic.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) iterator.next();
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}
