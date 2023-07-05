import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        // base case, if not same length cant be anagram
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> sLetters = new HashMap<Character, Integer>();

        // if same length, total up letter counts, only need to do for one word
        for (int i = 0; i < s.length(); i++) {
            if (!(sLetters.containsKey(s.charAt(i)))) {     // if encounter new letter, add to hashmap
                sLetters.put(s.charAt(i), 1);
            } else {        // if encountered letter already added, increment
                int increment = sLetters.get(s.charAt(i)) + 1;
                sLetters.put(s.charAt(i), increment);
            }
        }

        // compare character counts to other word
        for (int i = 0; i < t.length(); i++) {
            if (sLetters.get(t.charAt(i)) == null)  // if letter not found, exit, cant be anagram
                return false;
            else if (sLetters.get(t.charAt(i)) < 1) {   // if found letter and it has less than 1 available
                return false;
            }
            else {      // if letter found, decrement and keep going
                int decrement = sLetters.get(t.charAt(i)) - 1;
                sLetters.put(t.charAt(i), decrement);
            }
        }

        return true;
    }
}
