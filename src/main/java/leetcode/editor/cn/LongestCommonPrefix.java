//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1247 👎 0

package leetcode.editor.cn;

public class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution =  new LongestCommonPrefix().new Solution();
        String[] strs = new String [] {"","b"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
    
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String commonStr = null;
        int lastIndex = 0;
        int matchedCount = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                continue;
            }

            if (commonStr == null) {
                commonStr = strs[i];
                lastIndex = strs[i].length();
            }

            while(true) {
                if (strs[i].startsWith(commonStr)) {
                    matchedCount ++;
                    break;
                }

                lastIndex --;
                if (lastIndex <= 0) {
                    break;
                }
                commonStr = commonStr.substring(0, lastIndex);
            }
        }


        return matchedCount == strs.length ? commonStr : "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

