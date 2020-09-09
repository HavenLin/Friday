//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 428 👎 0

package leetcode.editor.cn;

public class BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution =  new BalancedBinaryTree().new Solution();
        String input = "[1,2,2,3,null,null,3,4,null,null,4]";
        TreeNode treeNode = TreeNodeUtil.stringToTreeNode(input);
        System.out.println(solution.isBalanced(treeNode));
    }
    
   //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getDepth(root) >= 0;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lt = getDepth(root.left);
        int rt = getDepth(root.right);

        if (lt >= 0 && rt >= 0 && Math.abs(lt - rt) <= 1) {
            return Math.max(lt, rt) + 1;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

