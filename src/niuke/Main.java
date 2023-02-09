package niuke;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/11/27 21:51
 * @Created by Tengxq
 */

import java.util.*;

public class Main {
    /*public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        while(num > 0){
            int n = in.nextInt();
            String road = in.next();
            int i = 0;
            int res = 0;
            while(i< n){
                if(road.charAt(i) == 'X'){
                    i++;
                }else{
                    res++;
                    i+=3;
                }
            }
            System.out.println(res);
            num--;
        }
    }*/

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap();
        map.put(0, "N");
        map.put(1, "E");
        map.put(2, "S");
        map.put(3, "W");

        int n = 1000;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append("L");
        }
        String direc = str.toString();
        int num = 0;
        int i = 0;
        while (i < n) {
            if (direc.charAt(i) == 'L') {
                num += 3;
            } else {
                num += 1;
            }
            i++;
        }
        num = num % 4;
        System.out.println(map.get(num));
    }
}
