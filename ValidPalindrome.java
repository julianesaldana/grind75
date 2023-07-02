public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "race a car";
        System.out.println(isPalindrome(s));

        s = " ";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder result = new StringBuilder();     // removing non-alphanumeric chars from string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result.append(Character.toLowerCase(c));
            }
        }

//        // todo: DEBUGGING HERE
//        System.out.println(result);

        // base case, if empty string return true
        if (s.equals("")) {
            return true;
        }

        // comparing back to front
        int front = 0;
        int end = result.length() - 1;
        while (front <= end) {  // stopping till at same letter or when front passes back
            if (!(result.charAt(front) == result.charAt(end))) {    // if letters arent the same, return false
                return false;
            }
            front++;
            end--;
        }

        return true;        // can most likely check to see if string index is a character as the algo goes to optimize
    }
}
