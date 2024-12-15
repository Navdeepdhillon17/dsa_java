# **Plus One Problem Solution**

## Problem Statement

You are given a large integer represented as an array of digits, where each element in the array corresponds to a single digit. Your task is to increment this number by one and return the resulting array of digits.

### Examples

- **Input**: `[1, 2, 3]`  
  **Output**: `[1, 2, 4]`  
  **Explanation**: The number `123` becomes `124`.

- **Input**: `[9, 9, 9]`  
  **Output**: `[1, 0, 0, 0]`  
  **Explanation**: The number `999` becomes `1000`.

---

## Approach and Explanation

### Key Challenges

1. **Carry Handling**:  
   Adding 1 may result in a carry, especially when a digit is `9`. If this happens, the current digit is set to `0`, and the carry propagates to the next most significant digit.  

2. **Edge Case: All 9s**:  
   If all digits are `9`, adding 1 will create a new most significant digit. For example, `[9, 9, 9]` becomes `[1, 0, 0, 0]`.

### Why This Approach?

The problem requires an efficient and direct solution. Instead of converting the array into an integer (or string), this approach directly manipulates the digits, keeping the process space-efficient.

---

## Code Explanation

### Step-by-Step Breakdown

```java
public static int[] plusOne(int[] digits) {
    int n = digits.length; // Find the length of the array
```

1. **Start from the least significant digit**:  
   - The loop begins from the last digit (`n - 1`) and moves toward the first digit (`0`).
   - This is because incrementing affects the least significant digit first.

```java
    for (int i = n - 1; i >= 0; i--) {
        digits[i] += 1; // Add 1 to the current digit
```

2. **Check if there’s a carry**:  
   - If the result of adding 1 is less than 10, there’s no carry. In this case, we can return the modified array immediately, as no further updates are required.

```java
        if (digits[i] < 10) { 
            // If no carry, return the updated array
            return digits;
        }
```

3. **Handle Carry Forward**:  
   - If the digit becomes 10, it is reset to `0`, and the carry propagates to the next significant digit.

```java
        digits[i] = 0; // Reset to 0 and propagate carry
```

4. **Special Case: All Digits Are 9**:  
   - If all digits become `0` after the loop ends, it means the original array was all 9s (e.g., `[9, 9, 9]`).
   - Create a new array with an extra leading digit (`1`) to handle the carry.

```java
    }
    // If we exit the loop, all digits were 9
    int[] result = new int[n + 1]; // Create a new array with one extra digit
    result[0] = 1; // Set the first digit to 1
    return result;
}
```

5. **Optimization for Midway Carry**:  
   - If a carry occurs, but the next digit is less than 9, there’s no need to create a new array. This optimization is handled by returning the modified array as soon as a digit is updated without creating another carry.

---

### Full Code with Comments

```java
import java.util.Arrays;

public class Solution {
    public static int[] plusOne(int[] digits) {
        int n = digits.length; // Get the length of the array
        
        // Start iterating from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += 1; // Add 1 to the current digit
            
            if (digits[i] < 10) {
                // If no carry, return the array as it is now correct
                return digits;
            }
            
            // If there is a carry, reset the current digit to 0
            digits[i] = 0;
        }
        
        // If all digits were 9 (e.g., [9, 9, 9]), create a new array
        int[] result = new int[n + 1]; // New array with one extra digit
        result[0] = 1; // Set the first digit to 1
        // All other digits are already 0 by default
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {9};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {9, 9, 9};
        int[] arr4 = {1, 9, 9};

        // Test case 1
        int[] result1 = plusOne(arr1);
        System.out.println(Arrays.toString(result1)); // Output: [1, 0]

        // Test case 2
        int[] result2 = plusOne(arr2);
        System.out.println(Arrays.toString(result2)); // Output: [1, 2, 4]

        // Test case 3
        int[] result3 = plusOne(arr3);
        System.out.println(Arrays.toString(result3)); // Output: [1, 0, 0, 0]

        // Test case 4
        int[] result4 = plusOne(arr4);
        System.out.println(Arrays.toString(result4)); // Output: [2, 0, 0]
    }
}
```

---

## Dry Run of the Code

### Input: `[1, 9, 9]`
1. Start with `[1, 9, 9]`.  
2. Add 1 to the last digit: `digits[2] = 9 + 1 = 10`.  
   - Set `digits[2] = 0` and propagate the carry.  
3. Add the carry to the next digit: `digits[1] = 9 + 1 = 10`.  
   - Set `digits[1] = 0` and propagate the carry.  
4. Add the carry to the next digit: `digits[0] = 1 + 1 = 2`.  
   - No further carry, return `[2, 0, 0]`.  

### Input: `[9, 9, 9]`
1. Start with `[9, 9, 9]`.  
2. Add 1 to the last digit: `digits[2] = 9 + 1 = 10`.  
   - Set `digits[2] = 0` and propagate the carry.  
3. Add the carry to the next digit: `digits[1] = 9 + 1 = 10`.  
   - Set `digits[1] = 0` and propagate the carry.  
4. Add the carry to the next digit: `digits[0] = 9 + 1 = 10`.  
   - Set `digits[0] = 0` and propagate the carry.  
5. Since all digits are now `0`, create a new array `[1, 0, 0, 0]`.  

---

## Complexity Analysis

- **Time Complexity**: \(O(n)\)  
  The algorithm processes each digit at most once, resulting in linear complexity.

- **Space Complexity**: \(O(n)\)  
  In the worst case (all digits are 9), an additional array of size \(n + 1\) is created.

---

## Example Outputs

### Test Cases

| Input          | Output           |
|-----------------|------------------|
| `[1, 2, 3]`    | `[1, 2, 4]`      |
| `[9, 9, 9]`    | `[1, 0, 0, 0]`   |
| `[9]`          | `[1, 0]`         |
| `[1, 9, 9]`    | `[2, 0, 0]`      |

---

