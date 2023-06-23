import java.util.Arrays;
import java.util.*;

class TwoSum {
    public static void main(String[] args) {    // using inputs from prompt
        int[] nums = {2,7,11,1};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    // not exceptionally fast but works
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {     // dont check indexes that already have been checked
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

}