package leetnofree;

/**
 * @author szl
 * @date 2022/1/30  11:14
 */
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
        int[] prices = {7,6,4,3,1};
}
