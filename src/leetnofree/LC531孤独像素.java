package leetnofree;
/*
* 给定一幅黑白像素组成的图像, 计算黑色孤独像素的数量。

图像由一个由‘B’和‘W’组成二维字符数组表示, ‘B’和‘W’分别代表黑色像素和白色像素。

黑色孤独像素指的是在同一行和同一列不存在其他黑色像素的黑色像素。

示例:

输入:
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

输出: 3
解析: 全部三个'B'都是黑色孤独像素。

*/
/**
 * @author szl
 * @date 2022/1/29  16:36
 */
public class LC531孤独像素 {
    public static void main(String[] args) {
        Solution solution = new LC531孤独像素().new Solution();
    }

    class Solution {
        public int findLonelyPixel(char[][] picture) {
            int m = picture.length, n = picture[0].length;
            int[] rows = new int[m];
            int[] cols = new int[n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (picture[i][j] == 'B') {
                        ++rows[i];
                        ++cols[j];
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < m; ++i) {
                if (rows[i] == 1) {
                    for (int j = 0; j < n; ++j) {
                        if (picture[i][j] == 'B' && cols[j] == 1) {
                            ++res;
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
}


