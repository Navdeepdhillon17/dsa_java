# Remove Duplicates from Sorted Array

## Problem Description
The task is to remove duplicates from a sorted array in **place** such that each unique element appears only once, and return the count of unique elements. The first `k` elements of the array should contain the unique elements, where `k` is the number of unique elements.  
The problem emphasizes **in-place modification**, meaning no additional space should be used for a new array.

### Example Input and Output:
- **Input:** `nums = [1, 1, 2, 3, 3]`  
- **Output:** `3`  
  - Modified array: `[1, 2, 3, _, _]` (`_` indicates leftover elements that are no longer relevant).

---

## Solution Explanation

### Key Insights:
1. Since the array is sorted, duplicates are grouped together.
2. This allows us to use a **two-pointer approach** to solve the problem efficiently in one pass.

### Steps to Solve:
1. **Initialization:**
   - Start with a pointer `index = 1`, which represents the next position to store a unique element.
   - The first element is always unique, so `index` starts at 1.
   
2. **Traversal:**
   - Loop through the array starting from the second element (`i = 1`).
   - For each element, compare it with the previous one (`nums[i] != nums[i - 1]`).
   - If the current element is unique:
     - Assign it to the position pointed to by `index` (`nums[index] = nums[i]`).
     - Increment `index` to prepare for the next unique element.

3. **Return Result:**
   - At the end of the loop, `index` contains the count of unique elements.
   - The first `index` elements of the array now hold the unique numbers in sorted order.

---

## Code
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1; // Start at 1 since the 0th element is always unique
        for (int i = 1; i < nums.length; i++) { // Traverse the array
            if (nums[i] != nums[i - 1]) { // Check if the current element is unique
                nums[index] = nums[i]; // Place unique number at the `index`
                index++; // Increment the index pointer
            }
        }
        return index; // Return the count of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 6, 6};
        Solution obj = new Solution();
        int uniqueCount = obj.removeDuplicates(nums); // Call the method
        System.out.println("Number of unique elements: " + uniqueCount);

        // Print the modified array
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
```

---

## Key Concept: In-Place Modification
### What Does `nums[index] = nums[i]` Do?
1. **Pointer (`index`):**
   - The `index` acts as a pointer to the next position where a unique element should be stored.
2. **Changing the Array in Place:**
   - Arrays in Java are passed **by reference**, so modifying `nums[index]` directly changes the original array in memory.
   - For example:
     - Input: `nums = [1, 1, 2, 3]`
     - If `nums[1] = nums[2]`, the array becomes `[1, 2, 2, 3]`.

---

## Dry Run

### Input: `nums = [1, 1, 2, 3, 3, 4]`

| Step | `i`  | `nums[i]` | `nums[i - 1]` | `index` | Array State (`nums`)           | Notes                          |
|------|-------|-----------|---------------|---------|--------------------------------|--------------------------------|
| Init | -     | -         | -             | 1       | `[1, 1, 2, 3, 3, 4]`          | Start with `index = 1`.       |
| 1    | 1     | 1         | 1             | 1       | `[1, 1, 2, 3, 3, 4]`          | Duplicate, skip.              |
| 2    | 2     | 2         | 1             | 2       | `[1, 2, 2, 3, 3, 4]`          | Unique, update `nums[1]=2`.   |
| 3    | 3     | 3         | 2             | 3       | `[1, 2, 3, 3, 3, 4]`          | Unique, update `nums[2]=3`.   |
| 4    | 4     | 3         | 3             | 3       | `[1, 2, 3, 3, 3, 4]`          | Duplicate, skip.              |
| 5    | 5     | 4         | 3             | 4       | `[1, 2, 3, 4, 3, 4]`          | Unique, update `nums[3]=4`.   |

### Final Result:
- **Unique Elements Count (`index`):** `4`
- **Modified Array:** `[1, 2, 3, 4, _, _]` (values beyond `index` are irrelevant).

---

## Complexity Analysis
1. **Time Complexity:**
   - O(n), where `n` is the size of the array. This is because we only traverse the array once.

2. **Space Complexity:**
   - O(1). No extra space is used; the array is modified in place.

---

## Notes
- This approach avoids creating a new array and makes the solution more efficient.
- The use of `index` as a pointer helps in understanding how we manage unique elements within the same array.
- **Pointers and In-Place Changes:** These concepts are fundamental in programming to save space and optimize performance.

---
