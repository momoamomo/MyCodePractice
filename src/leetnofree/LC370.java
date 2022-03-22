package leetnofree;

/**
 * @author szl
 * @date 2022/1/29  15:42
 */
public class LC370 {
    public static void main(String[] args) {
        Solution solution = new LC370().new Solution();
//        solution.getModifiedArray();

    }
    class Solution{
        public int[] getModifiedArray(int length, int[][] updates){
            int[] result = new int[length];
            for (int[] e : updates) {
                result[e[0]] += e[2];
                if (e[1] + 1 < length) {
                    result[e[1] + 1] -= e[2];
                }
            }
            for (int i = 1; i < length; ++i) {
                result[i] += result[i - 1];
            }
            return result;
        }
    }
}


