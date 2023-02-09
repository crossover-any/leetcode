/**
 * @Classname countAndSay38
 * @Description 初始值第一行是1。
 * <p>
 * 第二行读第一行，1个1，去掉个字，所以第二行就是11。
 * <p>
 * 第三行读第二行，2个1，去掉个字，所以第三行就是21。
 * <p>
 * 第四行读第三行，1个2，1个1，去掉所有个字，所以第四行就是1211。
 * <p>
 * 第五行读第四行，1个1，1个2，2个1，去掉所有个字，所以第五航就是111221。
 * <p>
 * 第六行读第五行，3个1，2个2，1个1，去掉所以个字，所以第六行就是312211。
 * <p>
 * 然后修订要求输入1-30的任意行数，输出该行是啥。
 * @Date 2019/11/11 21:48
 * @Created by Tengxq
 */
public class countAndSay38 {
    public String countAndSay(int n) {
        //第一行就直接输出
        if (n == 1) {
            return "1";
        }
        //得到上一行的字符串
        String last = countAndSay(n - 1);
        //输出当前行的字符串
        return getNextString(last);

    }

    private String getNextString(String last) {
        //长度为 0 就返回空字符串
        if (last.length() == 0) {
            return "";
        }
        //得到第 1 个字符重复的次数
        int num = getRepeatNum(last);
        // 次数 + 当前字符 + 其余的字符串的情况
        return num + "" + last.charAt(0) + getNextString(last.substring(num));
    }

    //得到字符 string[0] 的重复个数，例如 "111221" 返回 3
    private int getRepeatNum(String string) {
        int count = 1;
        char same = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (same == string.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char c = '1';
    }
}
