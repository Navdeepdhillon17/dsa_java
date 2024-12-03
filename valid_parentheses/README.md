# Valid Parentheses Checker with Interactive Input

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{}`, `'}'`, `'['`, and `']'`, determine if the input string is valid.  

A string is considered valid if:
1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every closing bracket has a corresponding opening bracket.

---

## How the Program Works

### Key Steps:
1. **Take Input**: The program takes a string input using `Scanner`.
2. **Use a Stack**:
   - Push all opening brackets onto the stack.
   - For closing brackets:
     - Check if the stack is empty (invalid case).
     - Match the top of the stack with the corresponding opening bracket. If it matches, pop the stack; otherwise, break the loop.
3. **Final Validation**:
   - After processing the string, check if the stack is empty. If it is, the input string is valid.

---

## Code Implementation

```java
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int length = s.length();

        for (int i = 0; i < length; i++) {
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
```

---

## Example Walkthroughs

### Example 1: Input `"()"`
1. Enter the string `()` at runtime.
2. Iteration steps:
   - Process `'('`: Push to stack → `stack = ['(']`.
   - Process `')'`: Matches `'('` at the top of the stack, so pop → `stack = []`.
3. Final stack state: `stack.isEmpty() == true`.
4. **Output**: `true`.

---

### Example 2: Input `"([{}])"`
1. Enter the string `([{}])` at runtime.
2. Iteration steps:
   - Push `'('`, `'['`, `'{'` to stack → `stack = ['(', '[', '{']`.
   - Process `'}'`: Matches `'{'` → pop → `stack = ['(', '[']`.
   - Process `']'`: Matches `'['` → pop → `stack = ['(']`.
   - Process `')'`: Matches `'('` → pop → `stack = []`.
3. Final stack state: `stack.isEmpty() == true`.
4. **Output**: `true`.

---

### Example 3: Input `"([)]"`
1. Enter the string `([)]` at runtime.
2. Iteration steps:
   - Push `'('`, `'['` to stack → `stack = ['(', '[']`.
   - Process `')'`: Doesn't match `'['` → break.
3. Final stack state: `stack.isEmpty() == false`.
4. **Output**: `false`.

---

## How to Run the Program

1. Copy the code into an IDE like IntelliJ IDEA, Eclipse, or VS Code.
2. Run the program.
3. Input a string of parentheses (e.g., `()`, `([{}])`, or `(])`) in the console when prompted.
4. The program will print `true` or `false` based on whether the input is valid.


## Complexity Analysis

1. **Time Complexity**:  
   \( O(n) \) — Each character in the string is processed exactly once.

2. **Space Complexity**:  
   \( O(n) \) — The stack may grow to the size of the input string in the worst case (all opening brackets).

---

## Edge Cases

1. **Empty String**: Input `""` should return `true` (no unmatched brackets).
2. **Single Closing Bracket**: Input `")"` should return `false` (no matching opening bracket).
3. **Unmatched Opening Brackets**: Input `"((("` should return `false` (stack is not empty at the end).

---
