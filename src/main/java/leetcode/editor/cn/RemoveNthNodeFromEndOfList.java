//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 964 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.ListNode;

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution =  new RemoveNthNodeFromEndOfList().new Solution();
//        ListNode node = new ListNode(4, new ListNode(5, new ListNode(4)));
//        ListNode node = new ListNode(1);
        ListNode node = new ListNode(1, new ListNode(2));
        node = solution.removeNthFromEnd(node, 2);
        System.out.println(node);
    }
    
   //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = head;
        int i = 0;
        int len = 0;
        while(fast != null) {
            fast = fast.next;
            if (i >= n) {
                slowPre = slow;
                slow = slow.next;
            } else {
                i ++;
            }
            len ++;
        }

        if (len == n) {
            dummyNode.next = slow.next;
        } else {
            slowPre.next = slow.next;
        }

        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

