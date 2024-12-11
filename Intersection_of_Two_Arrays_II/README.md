# Intersection of Two Arrays II 

## Problem Description
Given two integer arrays `nums1` and `nums2`, we are tasked with finding the intersection of the two arrays. The intersection represents the elements that are present in both arrays, where each element in the intersection appears as many times as it appears in **both** arrays.

### Example:
**Input:**
```plaintext
nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
```

**Output:**
```plaintext
[2, 2]
```

---

## Why Use HashMap and ArrayList?

### **HashMap**
- A `HashMap` is used to **store the frequency** of elements in the first array (`nums1`).
- Using a `HashMap` allows us to efficiently look up the frequency of any number in constant time (O(1)).
- By storing the count of each number, we can easily check if a number exists in both arrays and track how many times it appears.

### **ArrayList**
- An `ArrayList` is used to store the elements that are part of the intersection of the two arrays.
- `ArrayList` is a flexible collection that allows dynamic resizing and easy insertion of elements.
- After finding the intersection, we convert the `ArrayList` into an array (as required) and return it.

---

## Explanation of Code

### **Step-by-Step Explanation:**

1. **Initialize a HashMap and ArrayList:**
   ```java
   HashMap<Integer, Integer> map = new HashMap<>();
   ArrayList<Integer> list = new ArrayList<>();
   ```
   - `map`: Stores the frequency of each element in `nums1`.
   - `list`: Stores the intersection of elements (the result).

2. **First Loop - Populate the HashMap with Frequencies:**
   ```java
   for (int n1 : nums1) {
       map.put(n1, map.getOrDefault(n1, 0) + 1);
   }
   ```
   - **For each element in `nums1`**, we update the frequency of that element in the `map`.
   - **`map.getOrDefault(n1, 0)`**: This retrieves the current count of the element `n1` in the `map`. If it doesn't exist, it defaults to `0`. We then add 1 to the count.

3. **Second Loop - Find the Intersection:**
   ```java
   for (int n2 : nums2) {
       if (map.containsKey(n2) && map.get(n2) > 0) {
           list.add(n2);
           map.put(n2, map.get(n2) - 1); // Decrease the count in map
       }
   }
   ```
   - **For each element in `nums2`**, we check:
     1. **If the element exists in the `map`** (i.e., it appeared in `nums1`).
     2. **If the element's frequency is greater than 0**, If the frequency is 0 or the element does not exist in the map, it means:
          - Either the element has already been used (we've already added it to the intersection) or it was never in nums1.
   - If both conditions are true, we add the element to the `list` and **decrease its frequency** in the `map` to prevent it from being added again.

4. **Convert ArrayList to Array and Return:**
   ```java
   int[] arr = new int[list.size()];
   for (int i = 0; i < list.size(); i++) {
       arr[i] = list.get(i);
   }
   return arr;
   ```
   - The `ArrayList` is converted into an array (`arr`), as the expected return type is an array.
   - We then return the array containing the intersection of `nums1` and `nums2`.

---

## Dry Run Example

### Input:
```plaintext
nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
```

### First Loop (Populating the HashMap):
- **Initial `map`:** `{}` (empty)
- **Iteration 1:** `n1 = 1`, `map = {1 -> 1}`
- **Iteration 2:** `n1 = 2`, `map = {1 -> 1, 2 -> 1}`
- **Iteration 3:** `n1 = 2`, `map = {1 -> 1, 2 -> 2}`
- **Iteration 4:** `n1 = 1`, `map = {1 -> 2, 2 -> 2}`

### Second Loop (Finding Intersection):
- **Initial `list`:** `[]` (empty)
- **Iteration 1:** `n2 = 2`, `map.containsKey(2) = true`, `map.get(2) = 2 > 0`
  - Add `2` to `list`, update `map = {1 -> 2, 2 -> 1}`
  - `list = [2]`
- **Iteration 2:** `n2 = 2`, `map.containsKey(2) = true`, `map.get(2) = 1 > 0`
  - Add `2` to `list`, update `map = {1 -> 2, 2 -> 0}`
  - `list = [2, 2]`

### Final Result:
- **Return value (`arr`):** `[2, 2]`

---

## How to Use the Solution

1. **Create an instance of the `Solution` class:**
   ```java
   Solution obj = new Solution();
   ```

2. **Call the `intersect` method with two integer arrays as arguments:**
   ```java
   int[] result = obj.intersect(nums1, nums2);
   ```

3. **Process or print the resulting intersection array:**
   ```java
   for (int j : result) {
       System.out.print(j + " ");
   }
   ```

---

## Time and Space Complexity

- **Time Complexity:** O(m + n), where:
  - `m` is the length of `nums1`.
  - `n` is the length of `nums2`.
  - We iterate through both arrays once.
- **Space Complexity:** O(m), where `m` is the number of unique elements in `nums1`, since we store the counts in a `HashMap`.



