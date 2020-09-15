//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 586 👎 0

package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution =  new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int [] nums = new int[] {2,2};
        int [] result = solution.searchRange(nums, 3);
        System.out.println(result[0] + " :: " + result[1]);
    }
    
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[] {-1, -1};
        if (nums.length == 0) {
            return result;
        }

        int start = 0;
        int end = nums.length - 1;
        while (end >= start) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                start = mid;
                end = mid;
                while(start - 1 >= 0 && nums[start - 1] == target) {
                    start --;
                }

                while(end + 1 < nums.length && nums[end + 1] == target) {
                    end ++;
                }

                return new int[] {start, end};
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

