/**
 * @Classname steelPipeCut
 * @Description TODO
 * @Date 2019/11/19 21:00
 * @Created by Tengxq
 */
public class steelPipeCut {

    private int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public int steelPipeCutMaxProfit(int n) {
        int[] dic = new int[n + 1];
        int q = -1;
        for (int i = 1; i <= n; i++) {
            q = -1;
            for (int j = 1; j <= i; j++) {
                if (i >= prices.length && j == 1) {
                    continue;
                }
                if (q < prices[j] + dic[i - j]) {
                    q = prices[j] + dic[i - j];
                }
            }
            dic[i] = q;
        }
        return dic[n];
    }

    public static void main(String[] args) {
        steelPipeCut test = new steelPipeCut();
        int i = test.steelPipeCutMaxProfit(7);
        System.out.println(i);
    }
}
