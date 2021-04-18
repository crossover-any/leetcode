/**
 * @Classname multiply43
 * @Description TODO
 * @Date 2019/11/2 13:19
 * @Created by Tengxq
 */
public class multiply43 {
    public String multiply(String num1, String num2) {
        int tmr = 0;
        int n1 = 0;
        int n2 = 0;
        int carry = 0;
        int sum = 0;
        int num = 0;
        for(int i = num1.length()-1; i>=0;i--){
            for(int j = num2.length(); j>=0; j-- ){
                n1 = num1.charAt(i)-'0';
                n2 = num2.charAt(j)-'0';
                sum = n1 * n2;
                carry = sum/10;
                num = sum%10;
            }
        }
        return null;
    }
}
