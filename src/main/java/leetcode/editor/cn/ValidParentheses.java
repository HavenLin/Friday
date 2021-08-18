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

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParentheses{
    public static void main(String[] args) {
        List<String> tests = Arrays.asList("([)]", "()[]{}", "", "((", "(]", "{[]}", "([)", "(([]){})");
        List<Boolean> results = Arrays.asList(false, true, true, false, false, true, false, true);
        Solution solution =  new ValidParentheses().new Solution();
        for (int i = 0; i < tests.size(); i++) {
            try {
                if (solution.isValid(tests.get(i)) != results.get(i)) {
                    throw new NullPointerException("test failed");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + " - " + tests.get(i)
                        + " - Output:" + solution.isValid(tests.get(i))
                        + " - Expected:" + results.get(i));
            }
        }
    }
    
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }

        return stack.isEmpty();
    }
   }
//leetcode submit region end(Prohibit modification and deletion)

}

