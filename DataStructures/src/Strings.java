import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class Strings {
    public boolean isAnagram(String s, String t) {
        // base case, if the strings arent the same length
        if (s.length() != t.length()) {
            return false;
        }

        // converting to char array and sorting
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // if not same values, then not an anagram
        if (Arrays.equals(sArray, tArray)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String s) {
        // first convert all into lowercase
        s = s.toLowerCase();

        // then remove non-alphanumeric characters
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                temp.append(c);
            }
        }
        String newString = temp.toString();



        // base case, length size 1 string
        if (newString.length() == 1)
            return true;

        // else, compare forwards to backwards
        int lastCtr = newString.length() - 1;
        for (int i = 0; i < newString.length(); i++) {
            if (newString.charAt(i) != newString.charAt(lastCtr)) {
                return false;
            }
            lastCtr--;
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) { // FIXME: not implemented correctly
        // base case, if string is of length 1
        if (s.length() == 1)
            return 1;

        // base case 2, empty string length 0
        if (s.length() == 0)
            return 0;

        // algo
        HashMap<Character, Integer> maxCharLengths = new HashMap<Character, Integer>();     // keeping track of max substring lengths for each unique char in string


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ctr = 0;

            if (!maxCharLengths.containsKey(c)) {
                maxCharLengths.put(c, ++ctr);   // adding to unique chars list
            }

            int leftEnd = i;
            int rightEnd = s.length() - 1;

            for (int j = leftEnd; j < s.length(); j++) {

            }
        }
    }
}
