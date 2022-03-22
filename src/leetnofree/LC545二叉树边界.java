package leetnofree;
/*输入：root = [1,null,2,3,4]
        输出：[1,3,4,2]
        解释：
        - 左边界为空，因为二叉树不含左子节点。
        - 右边界是 [2] 。从根节点的右子节点开始的路径为 2 -> 4 ，但 4 是叶节点，所以右边界只有 2 。
        - 叶节点从左到右是 [3,4] 。
        按题目要求依序连接得到结果 [1] + [] + [3,4] + [2] = [1,3,4,2] 。*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author szl
 * @date 2022/1/30  11:01
 */
public class LC545二叉树边界 {
    public static void main(String[] args) {

    }

    class Solution {
        private List<Integer> res;

        public List<Integer> boundaryOfBinaryTree(leetnofree.TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            res = new ArrayList<>();

            if (!isLeaf(root)) {
                res.add(root.val);
            }

            //左子树
            leetnofree.TreeNode t = root.left;
            while (t != null) {
                if (!isLeaf(t)) {
                    res.add(t.val);
                }
                t = t.left == null ? t.right : t.left;
            }
            addLeaves(root);
            //右子树，显示顺序与遍历顺序相反，使用栈的特性
            Stack<Integer> stack = new Stack<>();
            t = root.right;
            while (t != null) {
                if (!isLeaf(t)) {
                    stack.push(t.val);
                }
                t = t.right == null ? t.left : t.right;
            }
            while (!stack.isEmpty()) {
                res.add(stack.pop());
            }
            return res;
        }

        private void addLeaves(TreeNode root) {
            if (isLeaf(root)) {
                res.add(root.val);
                return;
            }
            if (root.left != null) {
                addLeaves(root.left);
            }
            if (root.right != null) {
                addLeaves(root.right);
            }
        }

        private boolean isLeaf(TreeNode node) {
            return node != null && node.left == null && node.right == null;
        }
    }
}
