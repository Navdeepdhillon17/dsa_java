# Four Sum Solution

## Problem Statement

Given an array of integers `nums` and an integer `target`, find all unique quadruplets `[nums[i], nums[j], nums[left], nums[right]]` such that:

```
nums[i] + nums[j] + nums[left] + nums[right] == target
```

### Example:

**Input:**
```java
int[] arr = {1, 0, -1, 0, -2, 2};
int target = 0;
```

**Output:**
```java
[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
```

### Constraints:
- The answer must be returned as a list of lists, where each list represents a quadruplet.
- All quadruplets should be unique.

---

## Approach

### 1. **Sorting the Array**
The first step is to sort the input array. Sorting helps in efficiently finding quadruplets and prevents duplicate quadruplets.

### 2. **Iterating through the Array**
We use two pointers (`i` and `j`) to select the first two elements of the quadruplet. The next two elements are found using a two-pointer technique with `left` and `right` pointers. By iterating through all combinations of `i` and `j`, we can find all possible quadruplets.

- **`i`**: The first element in the quadruplet.
- **`j`**: The second element in the quadruplet.
- **`left`**: The third element, starting from `j + 1`.
- **`right`**: The fourth element, starting from the end of the array.

### 3. **Two-Pointer Technique**
For each pair of `i` and `j`, we adjust the `left` and `right` pointers to find two other elements that sum up to the target value:

- If the sum of the four numbers equals the target, we add the quadruplet to the result.
- If the sum is greater than the target, we move the `right` pointer leftward to reduce the sum.
- If the sum is less than the target, we move the `left` pointer rightward to increase the sum.

### 4. **Skipping Duplicates**
To avoid duplicate quadruplets, we ensure that we skip over duplicate values for `i`, `j`, `left`, and `right` by checking adjacent values.

### 5. **Return the Result**
Finally, we return the list of unique quadruplets that sum up to the target.

---

## Code Implementation

```java
import java.util.*;

class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array
        
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate 'i'
            
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicate 'j'
                
                int left = j + 1, right = n - 1; // Step 2: Initialize left and right pointers
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; // Calculate the sum
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right])); // Found a quadruplet
                        
                        // Skip duplicate 'left' and 'right'
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--; // Reduce sum by moving the right pointer left
                    } else {
                        left++; // Increase sum by moving the left pointer right
                    }
                }
            }
        }
        return result; // Return the list of quadruplets
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(arr, target);
        System.out.println(result); // Output the result
    }
}
```

---

## Dry Run of the Code

Let's go through a dry run with the following example:

**Input:**
```java
arr = {1, 0, -1, 0, -2, 2}
target = 0
```

### Step-by-Step Execution:

1. **Input Array:**
   ```
   nums = [1, 0, -1, 0, -2, 2]
   target = 0
   ```

2. **Sorting the Array:**
   ```
   nums = [-2, -1, 0, 0, 1, 2]
   ```

3. **Outer Loop (`i` loop):**

   - `i = 0`, `nums[i] = -2`.

4. **Inner Loop (`j` loop):**

   - `j = 1`, `nums[j] = -1`.

   **Two-pointer search for the remaining two numbers (`left` and `right`):**

   - `left = 2`, `right = 5`.
   - Calculate sum: `-2 + (-1) + 0 + 2 = -1` (sum < target), move `left` to `3`.

   - `left = 3`, `right = 5`.
   - Calculate sum: `-2 + (-1) + 0 + 2 = -1` (sum < target), move `left` to `4`.

   - `left = 4`, `right = 5`.
   - Calculate sum: `-2 + (-1) + 1 + 2 = 0` (sum == target), add `[-2, -1, 1, 2]` to the result.
   
   - Skip duplicates by moving `left` and `right` pointers.

5. **Continue for `j = 2`:**

   - `i = 0`, `j = 2`.

   **Two-pointer search:**

   - `left = 3`, `right = 5`.
   - Calculate sum: `-2 + 0 + 0 + 2 = 0` (sum == target), add `[-2, 0, 0, 2]` to the result.

   - Skip duplicates.

6. **Continue for `j = 3`:**

   - `i = 0`, `j = 3`.

   **Two-pointer search:**

   - `left = 4`, `right = 5`.
   - Calculate sum: `-2 + 0 + 1 + 2 = 1` (sum > target), move `right` to `4`.

7. **Outer Loop (`i = 1`):**

   - Now, `i = 1` (`nums[i] = -1`).

8. **Inner Loop (`j` loop):**

   - `j = 2`.

   **Two-pointer search:**

   - `left = 3`, `right = 5`.
   - Calculate sum: `-1 + 0 + 0 + 2 = 1` (sum > target), move `right` to `4`.

   - `left = 3`, `right = 4`.
   - Calculate sum: `-1 + 0 + 0 + 1 = 0` (sum == target), add `[-1, 0, 0, 1]` to the result.

9. **Final Output:**

   The result list contains the following quadruplets:
   ```java
   [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
   ```

---

## Time Complexity:

- Sorting the array takes \(O(n \log n)\).
- The two nested loops (`i` and `j`) iterate at most \(O(n^2)\).
- The two-pointer technique inside the inner loop runs in \(O(n)\).
Thus, the overall time complexity is \(O(n^3)\), where \(n\) is the number of elements in the input array.

## Space Complexity:

- The space complexity is \(O(k)\), where \(k\) is the number of quadruplets found. The space complexity is mainly determined by the result list.

---

## Conclusion

This approach efficiently finds all unique quadruplets that sum up to the target using sorting, two-pointer technique, and duplicate skipping. It ensures that no duplicate quadruplets are included in the result list.
