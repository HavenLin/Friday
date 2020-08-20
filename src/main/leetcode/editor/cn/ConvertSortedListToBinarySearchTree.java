//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 347 👎 0

package leetcode.editor.cn;

public class ConvertSortedListToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution =  new ConvertSortedListToBinarySearchTree().new Solution();
        //[-10,-3,0,5,9]
        ListNode listNode = new ListNode(-10,
                new ListNode(-3,
                        new ListNode(0,
                                new ListNode(5,
                                        new ListNode(9)))));
        TreeNode root = solution.sortedListToBST(listNode);
        System.out.println(root);
    }
    
   //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = new TreeNode();
        return convertBst(root, head);
    }

    TreeNode convertBst(TreeNode root, ListNode head) {
        if (head == null) {
            return root;
        }

        if (root.val == 0) {
            root.val = head.val;
            head = head.next;
        }

        if (head.val > root.val) {
            root.right = new TreeNode(head.val);
            root = convertBst(root.right, head.next);
        } else {
            root.left = new TreeNode(head.val);
            root = convertBst(root.left, head.next);
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

