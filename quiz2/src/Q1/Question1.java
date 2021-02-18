package Q1;

import java.util.Stack;

public class Question1 {

    public static void main(String[] args) {
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }

    private static boolean checkForPalindrome(String str) {
        String[] words = str.replaceAll("[^a-zA-Z]", "").toLowerCase().split(""); //I assumed that numbers should be ignored as well!
        Stack<String> stack = new Stack<>();
        for(int i=0;i<words.length;i++) {
            if(words.length %2 != 0 && i == (words.length/2)) continue;
            if(i < words.length / 2) stack.push(words[i]);
            if(i >= (words.length / 2) && !stack.pop().equalsIgnoreCase(words[i])) {
                return false;
            }
        }
        return true;
    }
}
