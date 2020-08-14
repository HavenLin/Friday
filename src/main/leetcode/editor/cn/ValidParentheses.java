//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1768 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses{
    public static void main(String[] args) {
        String test = "([)]";
        Solution solution =  new ValidParentheses().new Solution();
        boolean testResult = solution.isValid(test);
        assert testResult;
    }
    
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        char [] ss = s.toCharArray();
        Stack<Integer> descOrder = new Stack<>();
        Queue<Integer> acsOrder = new ArrayDeque<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(' || ss[i] == ')') {
                descOrder.add(1);
                acsOrder.add(1);
            } else if (ss[i] == '{' || ss[i] == '}') {
                acsOrder.add(2);
                descOrder.add(2);
            } else if (ss[i] == '[' || ss[i] == ']') {
                acsOrder.add(3);
                descOrder.add(3);
            }
        }

        boolean isValid = true;
        for (int i = 0; i < ss.length; i++) {
            int headBracket = acsOrder.poll();
            int tailBracket = descOrder.pop();
            if (i % 2 != 0 && i+1 <= ss.length - 1 && headBracket == ss[i+1]) {
                continue;
            }

            if (headBracket != tailBracket) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

