public class ValidPalindrome2 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "race a car";
        System.out.println(isPalindrome(s));

        s = " ";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {      // optimized version of valid palindrome
        // comparing back to front
        int front = 0;
        int end = s.length() - 1;

        while (front <= end) {  // stopping till at same letter or when front passes back
            if (!Character.isLetterOrDigit(s.charAt(front))) {      // if char not alphanumeric, skip to next char
                front++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(end))) {    // same as above, both chars must be alphanumeric to be compared
                end--;
                continue;
            }

            char charFront = Character.toLowerCase(s.charAt(front));
            char charEnd = Character.toLowerCase(s.charAt(end));
            if (charFront != charEnd) {    // if letters are NOT same, return false
                return false;
            }
            front++;
            end--;
        }

        return true;    // returns true if all chars are same front to back, or if empty string (still a palindrome)
    }
}
