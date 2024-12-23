# Find First and Last Position of Element in Sorted Array

This program finds the starting and ending positions of a target value in a sorted array using **binary search**. If the target value is not found, it returns `[-1, -1]`.

---

## Problem Description

### Input
1. **Sorted Array**: The input array is in **non-decreasing order**, meaning each element is greater than or equal to the previous one. For example, `[1, 2, 2, 3, 4, 5]`.
2. **Target Value**: The value to search for in the array.

### Output
An array containing:
1. **First Position**: The first occurrence of the target value.
2. **Last Position**: The last occurrence of the target value.
   - If the target is not found, return `[-1, -1]`.

---

## Code

```java
public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = searchLeft(nums, target);
        int[] result = {-1, -1};
        result[0] = firstIndex;
        int lastIndex = searchRight(nums, target);
        result[1] = lastIndex;
        return result;
    }

    public static int searchLeft(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (nums[mid] == target) {
                index = mid;
                right = mid - 1; // Search left for earlier occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    public static int searchRight(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (nums[mid] == target) {
                index = mid;
                left = mid + 1; // Search right for later occurrences
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 6, 7, 8};
        int target = 6;
        int[] result = searchRange(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
```

---

## Explanation of Binary Search

1. **Binary Search Formula**: 
   ```java
   int mid = left + (right - left) / 2;
   ```
   - This avoids potential overflow compared to `(left + right) / 2`.
   - Binary search divides the search range in half, ensuring an \( O(\log n) \) time complexity.

2. **Non-Decreasing Order**:
   - The input array is sorted such that each element is either equal to or greater than the previous one.
   - Example: `[1, 2, 2, 3, 4, 4, 5]`.

3. **Two Searches**:
   - `searchLeft`: Finds the smallest index where `nums[index] == target`.
   - `searchRight`: Finds the largest index where `nums[index] == target`.

---

## Dry Run

### Input
**Array:** `[1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 6, 7, 8]`  
**Target:** `6`

### Execution Steps

#### `searchLeft(nums, target)`

1. **Initial State**:  
   `left = 0`, `right = 12`, `index = -1`

2. **Iteration 1**:  
   - `mid = 6`  
   - `nums[mid] = 5` < `6` → Move `left` to `mid + 1 = 7`.

3. **Iteration 2**:  
   - `mid = 9`  
   - `nums[mid] = 6` = `6` → Update `index = 9`.  
   - Move `right` to `mid - 1 = 8`.

4. **Iteration 3**:  
   - `mid = 7`  
   - `nums[mid] = 6` = `6` → Update `index = 7`.  
   - Move `right` to `mid - 1 = 6`.

5. **Exit Condition**:  
   `left > right` → Return `index = 7`.

#### `searchRight(nums, target)`

1. **Initial State**:  
   `left = 0`, `right = 12`, `index = -1`

2. **Iteration 1**:  
   - `mid = 6`  
   - `nums[mid] = 5` < `6` → Move `left` to `mid + 1 = 7`.

3. **Iteration 2**:  
   - `mid = 9`  
   - `nums[mid] = 6` = `6` → Update `index = 9`.  
   - Move `left` to `mid + 1 = 10`.

4. **Iteration 3**:  
   - `mid = 11`  
   - `nums[mid] = 7` > `6` → Move `right` to `mid - 1 = 10`.

5. **Iteration 4**:  
   - `mid = 10`  
   - `nums[mid] = 6` = `6` → Update `index = 10`.  
   - Move `left` to `mid + 1 = 11`.

6. **Exit Condition**:  
   `left > right` → Return `index = 10`.

### Final Result
`firstIndex = 7`, `lastIndex = 10` → `result = [7, 10]`.

---

## Complexity Analysis

### Time Complexity
1. **Binary Search**: Each search runs in \( O(\log n) \) because the problem size halves at each iteration.
2. **Total**: Two binary searches → \( O(\log n) + O(\log n) = O(\log n) \).

### Space Complexity
1. The program uses only variables (`left`, `right`, `mid`, etc.).
2. No additional memory → \( O(1) \).

---

## Example Outputs

### Example 1
**Input:**  
`nums = [1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 6, 7, 8]`, `target = 6`  
**Output:**  
`[7, 10]`

### Example 2
**Input:**  
`nums = [5, 7, 7, 8, 8, 10]`, `target = 8`  
**Output:**  
`[3, 4]`

### Example 3
**Input:**  
`nums = [5, 7, 7, 8, 8, 10]`, `target = 6`  
**Output:**  
`[-1, -1]`
