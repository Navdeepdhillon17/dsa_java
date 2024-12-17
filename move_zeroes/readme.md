# Move Zeroes - Java Implementation

## Problem Statement

Given an integer array `nums`, move all `0`'s to the **end** of the array while maintaining the **relative order** of the non-zero elements.  
You **must do this in-place** without using extra space for another array.

### Example:

#### Example 1:
**Input**:  
`nums = [0, 1, 0, 3, 12]`  

**Output**:  
`[1, 3, 12, 0, 0]`  

#### Example 2:
**Input**:  
`nums = [0]`  

**Output**:  
`[0]`

---

## Approach

We solve the problem using a two-step **in-place** algorithm with \(O(n)\) time complexity, where \(n\) is the length of the array.

### Steps:

1. **First Pass**: Move all non-zero elements to the beginning of the array.
    - Use a variable `lastNonZeroIndex` to track the position where the next non-zero element should be placed.
    - Iterate through the array:
        - If the current element is non-zero:
            - Place it at the position `lastNonZeroIndex`.
            - Increment `lastNonZeroIndex`.
        - This ensures that all non-zero elements are moved to the start while maintaining their relative order.

2. **Second Pass**: Fill the remaining positions in the array with `0`.
    - Starting from `lastNonZeroIndex` to the end of the array, set each element to `0`.

---

## Code Implementation

```java
public class Solution {
    public static void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0; // Tracks the position to place the next non-zero element
        
        // First Pass: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != lastNonZeroIndex) {
                    nums[lastNonZeroIndex] = nums[i];
                }
                lastNonZeroIndex++;
            }
        }
        
        // Second Pass: Fill the remaining positions with 0
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
        
        printArr(nums);
    }

    public static void printArr(int[] arr) {
        System.out.println("The result is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums2 = {0};

        System.out.println("Test Case 1:");
        moveZeroes(nums);

        System.out.println("Test Case 2:");
        moveZeroes(nums2);
    }
}
```

---

## Explanation of Code

1. **Initialization**:
   - `lastNonZeroIndex` is initialized to `0`. It keeps track of the next position to place a non-zero element.

2. **First For-Loop**:
   - Iterate through the array.
   - When a non-zero element is encountered:
     - Place it at the position `lastNonZeroIndex`.
     - Increment `lastNonZeroIndex`.
   - The condition `if (i != lastNonZeroIndex)` ensures we don't perform unnecessary writes when the current element is already in the correct position.

3. **Second For-Loop**:
   - Once all non-zero elements are placed, iterate from `lastNonZeroIndex` to the end of the array.
   - Fill each position with `0`.

4. **Output**:
   - The method `printArr` prints the array in a readable format.

---

## Complexity Analysis

- **Time Complexity**: \(O(n)\)
    - The array is traversed twice: once to move non-zero elements and once to fill zeros.
    - Both passes take linear time relative to the array size.

- **Space Complexity**: \(O(1)\)
    - No extra space is used apart from a few variables (`lastNonZeroIndex`).

---

## Example Execution

### Input:
```java
int[] nums = {0, 1, 0, 3, 12};
```

### Execution:

- **First Pass**:
    - Non-zero elements (`1, 3, 12`) are moved to the front.
    - Array after the first pass: `[1, 3, 12, 3, 12]`

- **Second Pass**:
    - Remaining positions are set to `0`.
    - Final Array: `[1, 3, 12, 0, 0]`

### Output:
```
The result is: 
1 3 12 0 0
```

---

## Edge Cases

1. **All Zeroes**:
   - Input: `[0, 0, 0]`
   - Output: `[0, 0, 0]`

2. **No Zeroes**:
   - Input: `[1, 2, 3]`
   - Output: `[1, 2, 3]`

3. **Single Element**:
   - Input: `[0]`
   - Output: `[0]`

4. **Mixed Case**:
   - Input: `[0, 1, 0, 3, 12]`
   - Output: `[1, 3, 12, 0, 0]`

---

