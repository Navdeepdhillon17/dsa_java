## **Remove Element**

### **Problem Description**
The task is to remove all occurrences of a specific value `val` from an array `nums`, modifying it **in-place**, and returning the new length of the array. The order of elements can change, and elements beyond the returned length can be left untouched.

---

### **Example**
#### Input:
```plaintext
nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2
```

#### Output:
```plaintext
nums = [0, 1, 3, 0, 4, 0, 4, 2], newLength = 5
```

#### Explanation:
1. The first `newLength = 5` elements of the array (`nums[0]` to `nums[4]`) represent the valid portion: `[0, 1, 3, 0, 4]`.
2. The elements beyond the new length (`nums[5]` to `nums[7]`) remain as they were but are no longer relevant to the problem.

---

### **How Does It Work In-Place?**
The solution modifies the array directly:
1. It **iterates through the array** with a loop.
2. A pointer `k` is used to track the position where the next valid (non-`val`) element should go.
3. When an element not equal to `val` is found:
   - It is **copied to the position `k`**.
   - The pointer `k` is incremented.
4. At the end of the loop:
   - The first `k` elements in `nums` contain all the valid elements.
   - The rest of the array (`nums[k]` to `nums[nums.length - 1]`) remains unchanged but irrelevant.

---

### **Dry Run**
#### Input:
```plaintext
nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2
```

#### Execution:
1. **Initial State:**
   ```
   nums = [0, 1, 2, 2, 3, 0, 4, 2]
   val = 2, k = 0
   ```

2. **Iteration 1 (i = 0):**
   - `nums[0]` = 0 (not equal to `val`).
   - Copy `nums[0]` to `nums[k]` (same position here).
   - Increment `k` to 1.
   ```
   nums = [0, 1, 2, 2, 3, 0, 4, 2], k = 1
   ```

3. **Iteration 2 (i = 1):**
   - `nums[1]` = 1 (not equal to `val`).
   - Copy `nums[1]` to `nums[k]`.
   - Increment `k` to 2.
   ```
   nums = [0, 1, 2, 2, 3, 0, 4, 2], k = 2
   ```

4. **Iteration 3 (i = 2):**
   - `nums[2]` = 2 (equal to `val`).
   - Skip this element, `k` remains 2.
   ```
   nums = [0, 1, 2, 2, 3, 0, 4, 2], k = 2
   ```

5. **Iteration 4 (i = 3):**
   - `nums[3]` = 2 (equal to `val`).
   - Skip this element, `k` remains 2.
   ```
   nums = [0, 1, 2, 2, 3, 0, 4, 2], k = 2
   ```

6. **Iteration 5 (i = 4):**
   - `nums[4]` = 3 (not equal to `val`).
   - Copy `nums[4]` to `nums[k]`.
   - Increment `k` to 3.
   ```
   nums = [0, 1, 3, 2, 3, 0, 4, 2], k = 3
   ```

7. **Iteration 6 (i = 5):**
   - `nums[5]` = 0 (not equal to `val`).
   - Copy `nums[5]` to `nums[k]`.
   - Increment `k` to 4.
   ```
   nums = [0, 1, 3, 0, 3, 0, 4, 2], k = 4
   ```

8. **Iteration 7 (i = 6):**
   - `nums[6]` = 4 (not equal to `val`).
   - Copy `nums[6]` to `nums[k]`.
   - Increment `k` to 5.
   ```
   nums = [0, 1, 3, 0, 4, 0, 4, 2], k = 5
   ```

9. **Iteration 8 (i = 7):**
   - `nums[7]` = 2 (equal to `val`).
   - Skip this element, `k` remains 5.
   ```
   nums = [0, 1, 3, 0, 4, 0, 4, 2], k = 5
   ```

10. **Final State:**
    ```
    nums = [0, 1, 3, 0, 4, 0, 4, 2], k = 5
    ```

---

### **Code**
```java
class Solution {
    public int removeElement(int[] nums, int val) {
       int k = 0; // Pointer to track valid elements
       for (int i = 0; i < nums.length; i++) {
           if (nums[i] != val) {
               nums[k] = nums[i]; // Place valid element at position k
               k++; // Increment valid element pointer
           }
       }
       return k; // Return new length
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        Solution obj = new Solution();
        int newLength = obj.removeElement(nums, val);

        // Print valid portion of the array
        System.out.print("New Length: " + newLength + "\nModified Array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
```

---

### **Output**
For the input `nums = [0, 1, 2, 2, 3, 0, 4, 2]` and `val = 2`, the program outputs:
```plaintext
New Length: 5
Modified Array: 0 1 3 0 4
```

---

### **Key Takeaways**
1. **In-Place Modification:**
   - The valid elements (`nums[i] != val`) are copied to the front of the array.
   - The rest of the array remains unchanged but irrelevant.

2. **Efficiency:**
   - **Time Complexity:** O(n) – Each element is processed once.
   - **Space Complexity:** O(1) – No extra space is used.

### **Efficiency**

- **Time Complexity: O(n)**  
  The solution iterates through the array once, checking each element and moving valid elements to the front. Each element is processed in constant time, so the overall time complexity is linear.

- **Space Complexity: O(1)**  
  The algorithm modifies the array in-place, using only a few extra variables (`k` and loop counters), so it doesn't require additional space.

- **Why Efficient?**  
  - **In-Place:** The array is modified directly without needing extra space for another array.
  - **Single Pass:** The solution processes each element only once, making it fast and optimal for large arrays.

---

This should keep the explanation simple and easy to understand for your README!

3. **Elements Beyond `k`:**
   - The array beyond the returned length remains as it was but is ignored in the result.
