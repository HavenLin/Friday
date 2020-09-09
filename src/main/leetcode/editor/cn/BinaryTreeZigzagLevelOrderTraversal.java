//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 261 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution =  new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        String input = "[3,9,20,null,null,15,7]";
        TreeNode treeNode = TreeNodeUtil.stringToTreeNode(input);
        solution.zigzagLevelOrder(treeNode);
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zzList = new ArrayList<>();
        if (root == null) {
            return zzList;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int directionCount = 1;
        while (!queue.isEmpty()) {
            List<Integer> listPerLevel = new ArrayList<>();
            int sizePerLevel = queue.size();
            for (int i = 0; i < sizePerLevel; i++) {
                TreeNode treeNode = queue.pop();
                listPerLevel.add(treeNode.val);
                System.out.println(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            if (directionCount % 2 == 0) {
                Collections.reverse(listPerLevel);
            }
            directionCount ++;
            zzList.add(listPerLevel);
        }

        return zzList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

