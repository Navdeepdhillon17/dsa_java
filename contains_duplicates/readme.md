# Contains Duplicate Problem Solution

## Problem Statement
The task is to determine if a given array contains any duplicate elements. If any value appears at least twice in the array, return `true`. Otherwise, return `false`.

---

## Approach and Explanation

### Why This Approach?
To efficiently check for duplicates in an array, we use a **HashSet**, a data structure that supports:
1. **Fast lookups**: Checking if an element exists in the set is an \(O(1)\) operation on average.
2. **No duplicate values**: A HashSet automatically avoids storing duplicate values.

Using a HashSet allows us to iterate through the array once, making the solution efficient with a time complexity of \(O(n)\), where \(n\) is the number of elements in the array.

---

### What is a HashSet?
A **HashSet** in Java is part of the `java.util` package. It stores elements in an unordered way and ensures that there are no duplicate values. The key features of a HashSet are:
- **Fast operations**: Adding, removing, or checking for the existence of an element is quick.
- **Uniqueness**: Only one instance of any given value can exist in a HashSet.

---

### Code Explanation

```java
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
       HashSet<Integer> set = new HashSet<>();  // Create a HashSet to store unique elements.
       for (int num : nums) {                   // Loop through each element in the array.
           if (set.contains(num)) {             // Check if the element already exists in the set.
               return true;                     // If yes, a duplicate is found; return true.
           }
           set.add(num);                        // Otherwise, add the element to the set.
       }
       return false;                            // If no duplicates are found, return false.
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};                // Example input with no duplicates.
        int[] nums2 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2, 6};  // Example input with duplicates.
        
        System.out.println(containsDuplicate(nums));    // Output: false
        System.out.println(containsDuplicate(nums2));   // Output: true
    }
}
```

---

### Dry Run of the Code

#### Input: `nums = {1, 2, 3}`

1. Initialize `set` as an empty HashSet.
2. Loop through each element:
   - **Element 1**: `set.contains(1)` → `false`, so add `1` to `set`. `set = {1}`.
   - **Element 2**: `set.contains(2)` → `false`, so add `2` to `set`. `set = {1, 2}`.
   - **Element 3**: `set.contains(3)` → `false`, so add `3` to `set`. `set = {1, 2, 3}`.
3. End of loop. No duplicates found. Return `false`.

#### Input: `nums2 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2, 6}`

1. Initialize `set` as an empty HashSet.
2. Loop through each element:
   - **Element 1**: `set.contains(1)` → `false`, so add `1` to `set`. `set = {1}`.
   - **Element 1** (again): `set.contains(1)` → `true`. A duplicate is found. Return `true`.

---

## Complexity Analysis

- **Time Complexity**: \(O(n)\)
  - Adding an element to a HashSet or checking its presence is \(O(1)\) on average.
  - The loop iterates through all \(n\) elements in the array.
- **Space Complexity**: \(O(n)\)
  - The HashSet stores up to \(n\) unique elements in the worst case.

---

## Why HashSet Works Well for This Problem
- **Efficiency**: Avoids nested loops, reducing time complexity from \(O(n^2)\) (in a brute-force approach) to \(O(n)\).
- **Readability**: The logic is clear and concise, making the code easy to understand and maintain.

---

## Example Outputs
```java
Input: {1, 2, 3}
Output: false

Input: {1, 1, 1, 3, 3, 4, 3, 2, 4, 2, 6}
Output: true
```
