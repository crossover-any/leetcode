package leetcode.order;

/**
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * <p>
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * <p>
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的
 * 子字符串
 * 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10101", k = 1
 * <p>
 * 输出：12
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "1010101", k = 2
 * <p>
 * 输出：25
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "11111", k = 1
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串都满足 k 约束。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= k <= s.length
 * s[i] 是 '0' 或 '1'。
 *
 * @author tengxq
 */
public class LeetCode3258CountKConstraintSubstrings {

    public static void main(String[] args) {
        LeetCode3258CountKConstraintSubstrings test = new LeetCode3258CountKConstraintSubstrings();
        System.out.println(test.countKConstraintSubstrings("10101", 1));
    }

    public int countKConstraintSubstrings(String s, int k) {
        char[] charArray = s.toCharArray();
        int[] dic = new int[2];
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            dic[0] = 0;
            dic[1] = 0;
            for (int j = i; j < charArray.length; j++) {
                dic[charArray[j] - '0']++;
                if (dic[0] <= k || dic[1] <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 计算字符串中满足特定约束条件的子字符串数量
     * 子字符串必须满足其中的0和1的数量都不超过k
     *
     * @param S 输入的字符串，由字符'0'和'1'组成
     * @param k 子字符串中'0'和'1'最大允许的数量
     * @return 满足约束条件的子字符串数量
     */
    public int countKConstraintSubstrings2(String S, int k) {
        // 将输入字符串转换为字符数组，便于逐个字符处理
        char[] s = S.toCharArray();
        // 初始化满足条件的子字符串数量为0
        int ans = 0;
        // 初始化滑动窗口的左边界
        int left = 0;
        // 初始化计数数组，用于记录当前窗口内'0'和'1'的数量
        int[] cnt = new int[2];

        // 遍历字符串中的每个字符
        for (int i = 0; i < s.length; i++) {
            // 更新当前字符的计数，使用位运算来确定字符是'0'还是'1'
            cnt[s[i] & 1]++;

            // 当窗口内'0'和'1'的数量都超过k时，调整窗口的左边界
            while (cnt[0] > k && cnt[1] > k) {
                // 减少左边界字符的计数
                cnt[s[left] & 1]--;
                // 右移左边界
                left++;
            }

            // 累加当前窗口大小到答案中，因为每个位置都可能形成新的满足条件的子字符串
            ans += i - left + 1;
        }

        // 返回满足条件的子字符串总数
        return ans;
    }

}
