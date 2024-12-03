import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int length = s.length();

        for(int i = 0; i<length; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(String.valueOf(s.charAt(i)));
            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                if (stack.isEmpty()) {
                    break;
                }
                char topChar = stack.peek().charAt(0);
                if (currentChar == ')' && topChar == '(' ||
                        currentChar == '}' && topChar == '{' ||
                        currentChar == ']' && topChar == '[') {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
            if (stack.isEmpty()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

        }
    }
