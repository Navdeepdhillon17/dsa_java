
# Single Number Solution in Java

## Description

This program solves the **Single Number** problem, which requires finding the unique number in an array where every other number appears twice. The solution uses a `HashMap` to count the frequency of each number and then identifies the unique number by checking for a frequency of 1.

---

## Problem Statement

Given a non-empty array of integers `nums`, every element appears twice except for one. Find the single number.

### Example

Input: `nums = [4, 1, 2, 1, 2]`  
Output: `4`

---

## Implementation

### Language

Java

### Solution Approach

1. **HashMap for Frequency Counting**:
   - Use a `HashMap` to store numbers as keys and their frequencies as values.
   - Iterate through the array and populate the `HashMap`:
     - If the number exists in the `HashMap`, increment its frequency.
     - Otherwise, add the number to the `HashMap` with an initial frequency of 1.

2. **Finding the Unique Number**:
   - Iterate through the array again to find the number with a frequency of `1` in the `HashMap`.

---

### Code

```java
import java.util.HashMap;

public class Solution {
    public static int singleNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int singleValue = 0;

        // Count frequencies of numbers
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Find the single number
        for (int i : arr) {
            if (map.get(i) == 1) {
                singleValue = i;
            }
        }

        return singleValue;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int s = singleNumber(nums);
        System.out.println(s); // Output: 4
    }
}
```

---

## How Loops Work

1. **First Loop**:  
   - **Purpose**: Build a `HashMap` where each key is a number from the array and its value is the count of occurrences.
   - **Logic**:
     - For each number in the array:
       - Check if it exists in the `HashMap` using `map.getOrDefault(num, 0)`.
       - Increment its count by 1.
       - If it doesn’t exist, initialize its count to 1.

2. **Second Loop**:  
   - **Purpose**: Find the number with a frequency of `1`.
   - **Logic**:
     - Iterate over the array again.
     - For each number, check its frequency in the `HashMap` using `map.get(num)`.
     - If the frequency is `1`, assign it to `singleValue` and stop further checks.

---

## Dry Run of the Code

Let’s dry run the code with `nums = [4, 1, 2, 1, 2]`.

### **Step 1: First Loop (Build the `HashMap`)**

| Step | Current Number | `HashMap` State                | Action                                  |
|------|----------------|---------------------------------|-----------------------------------------|
| 1    | `4`            | `{4=1}`                        | Add `4` to the map with count `1`.      |
| 2    | `1`            | `{4=1, 1=1}`                   | Add `1` to the map with count `1`.      |
| 3    | `2`            | `{4=1, 1=1, 2=1}`              | Add `2` to the map with count `1`.      |
| 4    | `1`            | `{4=1, 1=2, 2=1}`              | Increment count of `1` to `2`.          |
| 5    | `2`            | `{4=1, 1=2, 2=2}`              | Increment count of `2` to `2`.          |

At the end of the first loop, the `HashMap` is:
```java
{4=1, 1=2, 2=2}
```

### **Step 2: Second Loop (Find the Unique Number)**

| Step | Current Number | `map.get(num)` | Action                    |
|------|----------------|----------------|---------------------------|
| 1    | `4`            | `1`            | Found! Set `singleValue = 4`. |
| 2    | `1`            | `2`            | Skip (frequency is not `1`). |
| 3    | `2`            | `2`            | Skip (frequency is not `1`). |
| 4    | `1`            | `2`            | Skip (frequency is not `1`). |
| 5    | `2`            | `2`            | Skip (frequency is not `1`). |

The unique number (`singleValue`) is `4`.

---


## Complexity Analysis

- **First Loop**: \(O(n)\) to populate the `HashMap`.
- **Second Loop**: \(O(n)\) to find the single number.
- **Overall Time Complexity**: \(O(n)\).

- **Space Complexity**: \(O(n)\) for the `HashMap`.

---

### Notes

1. This solution assumes valid input, where exactly one number appears only once.
2. If the input may be invalid, consider adding error handling to avoid unexpected results.
