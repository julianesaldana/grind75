import java.util.*;
import java.io.*;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
        s = "()[]{}";
        System.out.println(isValid(s));
        s = "()[{]]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> leftSide = new Stack<Character>();

        // keeping track of left side of brackets, brackets also follow LIFO ({}) or (){}
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
               leftSide.push(s.charAt(i));  // tracking left side brackets
            }

            // if next right bracket matches the left side in the stack, bracket is valid
            else if (!leftSide.isEmpty() && s.charAt(i) == ')' && leftSide.peek() == '(') {
                leftSide.pop();
            }
            else if (!leftSide.isEmpty() && s.charAt(i) == ']' && leftSide.peek() == '[') {
                leftSide.pop();
            }
            else if (!leftSide.isEmpty() && s.charAt(i) == '}' && leftSide.peek() == '{') {
                leftSide.pop();
            }
            else {
                return false;
            }
        }
        return leftSide.isEmpty();  // if the stack is empty, that means that all brackets were valid
    }
}
