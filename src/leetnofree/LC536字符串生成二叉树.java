package leetnofree;
/*
* 你需要从一个包括括号和整数的字符串构建一棵二叉树。

输入的字符串代表一棵二叉树。它包括整数和随后的 0 ，1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。

若存在左子结点，则从左子结点开始构建。



示例：

输入："4(2(3)(1))(6(5))"
输出：返回代表下列二叉树的根节点:

       4
     /   \
    2     6
   / \   /
  3   1 5


提示：

输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9'
空树由 "" 而非"()"表示。

* */
/**
 * @author szl
 * @date 2022/1/29  16:48
 */
public class LC536字符串生成二叉树 {
    public static void main(String[] args) {
        String ss = "4(2(3))(6(7))";
        int p = ss.indexOf("(");

        String sub =ss.substring(0, p);
        System.out.println(p +":"+sub);

    }

    class Solution {
        public TreeNode str2tree(String s) {
            return dfs(s);
        }

        private TreeNode dfs(String s) {
            if ("".equals(s)) {
                return null;
            }
            //如果没有左括号，说明是单节点，直接返回一个单节点的二叉树
            int p = s.indexOf("(");
            if (p == -1) {
                return new TreeNode(Integer.parseInt(s));
            }
            TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, p)));
            int start = p;
            int cnt = 0;
            for (int i = p; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    ++cnt;
                } else if (s.charAt(i) == ')') {
                    --cnt;
                }
                if (cnt == 0) {
                    if (start == p) {
                        root.left = dfs(s.substring(start + 1, i));
                        start = i + 1;
                    } else {
                        root.right = dfs(s.substring(start + 1, i));
                    }
                }
            }
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
