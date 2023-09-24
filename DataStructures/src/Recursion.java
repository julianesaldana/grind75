import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "",0,0, n);
        return result;
    }

    // only add parenthesis if open < n
    // only add closing parenthesis if closed < open
    // combination is valid if open == closed == n

    private void backtrack(List<String> result, String combo, int open, int close, int max) {
        // base case, if open == close == max, max being n
        // means that parentheses are valid and meets n requirement
        if (open == close && close == max) {
            result.add(combo);
            return;     // finished combo
        }

        // rule: add "(" first if amount is less than n
        if (open < max) {
            backtrack(result, combo+"(", open + 1, close, max);
        }

        // rule: add ")" if not enough
        if (close < open) {
            backtrack(result, combo+")", open, close + 1, max);
        }
    }
}
