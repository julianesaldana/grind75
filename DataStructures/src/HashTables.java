import java.util.HashMap;
import java.util.HashSet;

public class HashTables {
    public int[] twoSum(int[] nums, int target) {
        // runtime O(n^2)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return {};

        HashMap<Integer, Integer> mapped = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (mapped.containsKey(complement)){
                return new int[]{mapped.get(complement), i};
            }
            mapped.put(nums[i], i);
        }

        return new int[]{};
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // base case 1, if magazine contains less chars than ransomNote needs
        if (magazine.length() < ransomNote.length())
            return false;

        // converting magazine chars to hashmap
        HashMap<Character, Integer> magazineLetters = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (!magazineLetters.containsKey(c)) {  // starting as 1 if not inputted already
                magazineLetters.put(c, 1);
            } else {
                int increment = magazineLetters.get(c) + 1; // increment by 1 if already inside hashmap
                magazineLetters.put(c, increment);
            }
        }

        // iterating through ransomNote and determining if enough chars in magazine to complete
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!magazineLetters.containsKey(c)){   // base case, if not in magazine then cant complete ransom note
                return false;
            }

            // if magazine letters contains char
            int decrement = magazineLetters.get(c) - 1;     // decrement by 1 as char will be used
            if (decrement == 0) {   // if char amount available turns to 0, remove char as available
                magazineLetters.remove(c);
            } else {
                magazineLetters.put(c, decrement);  // input decremented new amount
            }
        }
        return true;    // if successfully completes, ransomNote can be made, therefore true
    }
}
