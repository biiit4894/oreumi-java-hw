package stringdistinction;

import java.util.Scanner;
import java.util.Stack;

public class StringDistinction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean answer = true;
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                charStack.push('(');
            } else if (s.charAt(i) == ')') {
                if (charStack.empty()) {
                    answer = false;
                } else {
                    charStack.pop();
                }
            }
        }
        if(!charStack.empty()) {
            answer = false;
        }
        System.out.println("정답: " + answer);

    }
}