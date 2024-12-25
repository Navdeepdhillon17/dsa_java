
# **Reduce Array Size to Half**

## **Problem Statement**
You are given an integer array `arr`. Your task is to find the minimum size of a set of integers that can be removed such that at least half of the integers in the array are removed.

### **Example 1**
**Input**:  
`arr = [3,3,3,3,5,5,5,2,2,7]`

**Output**:  
`2`

**Explanation**:  
By removing the integers `{3, 7}`, the array size reduces to 5, which is half of the original size (`10/2 = 5`).

---

## **Solution Approach**

### **Key Observations**
1. **High-Frequency Elements**: To minimize the set size, we prioritize removing integers with the highest frequency first.
2. **Frequency Counting**: We need to know how many times each integer appears in the array.
3. **Sorting Frequencies**: Sorting the frequencies in descending order allows us to easily select the most frequent elements first.
4. **Early Termination**: Stop once at least half of the array has been removed.

---

## **Steps**

### **Step 1: Frequency Count**
We use a `HashMap` to count the frequency of each integer in the array.

#### Code:
```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int i : arr) {
    map.put(i, map.getOrDefault(i, 0) + 1);
}
```

#### Example:
For `arr = [3,3,3,3,5,5,5,2,2,7]`, the `map` will contain:
```
map = {3=4, 5=3, 2=2, 7=1}
```

---

### **Step 2: Extract Frequencies**
Extract the values (frequencies) from the `HashMap` into a list. 

#### Code:
```java
List<Integer> freq = new ArrayList<>(map.values());
```

#### Example:
For `map = {3=4, 5=3, 2=2, 7=1}`, the `freq` list will be:
```
freq = [4, 3, 2, 1]
```

---

### **Step 3: Sort Frequencies in Descending Order**
We sort the list of frequencies in descending order so that we process the most frequent elements first.

#### Code:
```java
freq.sort((a, b) -> b - a);
```

#### Example:
After sorting:
```
freq = [4, 3, 2, 1]
```

---

### **Step 4: Remove Elements**
Iterate through the sorted list of frequencies, summing the counts until we remove at least half of the array.

#### Code:
```java
int removeValues = 0;
int removeCount = 0;
for (int f : freq) {
    removeValues += f;
    removeCount++;
    if (removeValues >= arr.length / 2) {
        break;
    }
}
```

#### Example Walkthrough:
For `arr = [3,3,3,3,5,5,5,2,2,7]`:
- Original size: `n = 10`, Target: `n / 2 = 5`.
- Iteration 1: Remove `4` (frequency of `3`):
  ```
  removeValues = 4, removeCount = 1
  ```
- Iteration 2: Remove `3` (frequency of `5`):
  ```
  removeValues = 7, removeCount = 2
  ```
  - `removeValues >= 5`, so stop.

---

### **Step 5: Return the Result**
The final result is the count of distinct integers removed (`removeCount`).

---

## **Code**
```java
// Reduce Array Size to Half
import java.util.*;

class Solution {
    public static int minSetSize(int[] arr) {
        int n = arr.length;

        // Step 1: Frequency Count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Step 2: Extract Frequencies
        List<Integer> freq = new ArrayList<>(map.values());

        // Step 3: Sort Frequencies in Descending Order
        freq.sort((a, b) -> b - a);

        // Step 4: Remove Elements
        int removeValues = 0;
        int removeCount = 0;
        for (int f : freq) {
            removeValues += f;
            removeCount++;
            if (removeValues >= n / 2) {
                break;
            }
        }

        // Step 5: Return the Result
        return removeCount;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        int result = minSetSize(arr);
        System.out.println(result);  // Output: 2
    }
}
```

---

## **Dry Run**

### Input:
`arr = [3,3,3,3,5,5,5,2,2,7]`

### Execution:
1. **Frequency Count**:
   ```
   map = {3=4, 5=3, 2=2, 7=1}
   ```
2. **Extract Frequencies**:
   ```
   freq = [4, 3, 2, 1]
   ```
3. **Sort Frequencies**:
   ```
   freq = [4, 3, 2, 1]
   ```
4. **Remove Elements**:
   - Iteration 1: Remove `4` (frequency of `3`):
     ```
     removeValues = 4, removeCount = 1
     ```
   - Iteration 2: Remove `3` (frequency of `5`):
     ```
     removeValues = 7, removeCount = 2
     ```
     - `removeValues >= n / 2` (7 >= 5), so stop.

### Output:
```
Result = 2
```

---

## **Time Complexity**
Let's break down the time complexity calculation for the problem step by step, analyzing each operation and how it contributes to the overall complexity.

---

### **1. Frequency Count**
We iterate through the array `arr` to count the frequency of each integer.

#### Code:
```java
for (int i : arr) {
    map.put(i, map.getOrDefault(i, 0) + 1);
}
```

#### Analysis:
- Each iteration of the loop processes one element of the array.
- The `HashMap` operations (`put` and `getOrDefault`) are O(1) on average because `HashMap` is implemented as a hash table.
- Since the loop runs `n` times (where `n` is the length of the array), the time complexity for this step is:

**O(n)**

---

### **2. Extract Frequencies**
We extract the frequency values from the `HashMap` into a `List`.

#### Code:
```java
List<Integer> freq = new ArrayList<>(map.values());
```

#### Analysis:
- The `map.values()` operation is O(k), where `k` is the number of unique integers in the array. This is because `values()` retrieves all the values from the `HashMap` and stores them in a collection.
- Creating the `ArrayList` from these values is also O(k) since it simply copies the collection.
- Therefore, the time complexity for this step is:

**O(k)**

---

### **3. Sort Frequencies**
We sort the list of frequencies in descending order.

#### Code:
```java
freq.sort((a, b) -> b - a);
```

#### Analysis:
- Sorting a list of size `k` takes **O(k log k)** using the Timsort algorithm (used by Java's `Collections.sort()` or `List.sort()`).
- The comparison `(a, b) -> b - a` used for sorting does not affect the overall complexity since each comparison is O(1).
- Thus, the time complexity for this step is:

**O(k log k)**

---

### **4. Removing Elements**
We iterate through the sorted list of frequencies to remove elements until at least half of the array is removed.

#### Code:
```java
int removeValues = 0;
int removeCount = 0;
for (int f : freq) {
    removeValues += f;
    removeCount++;
    if (removeValues >= n / 2) {
        break;
    }
}
```

#### Analysis:
- In the worst case, we may need to process all `k` frequencies (e.g., if each frequency is very small).
- Since the loop iterates over the sorted list of size `k`, the time complexity is:

**O(k)**

---

### **Combining All Steps**
Now, we combine the time complexities of all the steps:

1. Frequency Count: **O(n)**
2. Extract Frequencies: **O(k)**
3. Sort Frequencies: **O(k log k)**
4. Removing Elements: **O(k)**

The overall time complexity is dominated by the sorting step, as it grows faster than the other terms when `k` is large.

### **Final Time Complexity:**
**O(n + k log k)**

---

### **Why This Makes Sense**
1. **`n` (Array Size):** We need to examine all elements in the array to determine their frequencies, so `O(n)` is unavoidable.
2. **`k` (Unique Elements):** Sorting and processing the unique elements depends on the number of distinct integers in the array. If `k` is much smaller than `n` (e.g., a small range of integers), the sorting cost will be much less significant compared to the frequency count.

Thus, the algorithm efficiently balances these factors.
---

## **Why Each Step Was Used**
1. **`HashMap`**: To efficiently count frequencies.
2. **`ArrayList`**: To sort and process frequencies.
3. **Sorting in Descending Order**: To ensure high-frequency elements are removed first.
4. **Loop for Removal**: To find the minimum number of distinct integers to remove.

--- 

## **Output**
For `arr = [3,3,3,3,5,5,5,2,2,7]`:
```
2
```
