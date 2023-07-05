public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int test = 1;
        System.out.println(test / 2);       // dividing always rounds down, ignores the remainder, 5/2 = 2
        //        // System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        // these three bounds represent indexes
        int leftBound = 0;
        int rightBound = nums.length - 1;   // keep index numbers only
        int middle = rightBound / 2; // keep index numbers only

        // algo
        while (target != nums[middle]) {    // will be dividing until target becomes the middle
            if (rightBound - leftBound <= 1) {
                if (nums[rightBound] != target)     // middle is left element if two elements are left, so it will be checked already in the while statement, check for the right element of the pair
                    return -1;  // only two elements left, both checked therefore not in list, return -1 per requirement
            }

            if (target < nums[middle])
                rightBound = middle - 1;
            
            if (target > nums[middle])
                leftBound = middle + 1;

            middle = leftBound + ((rightBound - leftBound) / 2);    // middle is always the same
        }

        return middle;  // if passes, middle is the target index
    }
}
