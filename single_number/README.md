```markdown
# Single Number Solution in Java

## Problem Statement

Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.

You must implement the solution with a time complexity better than \(O(n^2)\).

### Example

Input: `nums = [4,1,2,1,2]`  
Output: `4`

---

## Implementation

### Language

Java

### Solution Approach

1. Use a `HashMap` to count the frequency of each number in the array.
2. Iterate over the array to find the number with a frequency of 1.

### Code

```java
import java.util.HashMap;

public class Solution {
    public static int singleNumber(int[] arr){
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

## Time Complexity

- **First Loop:** \(O(n)\) to populate the `HashMap`.
- **Second Loop:** \(O(n)\) to find the single number.
- **Overall Time Complexity:** \(O(n)\).

## Space Complexity

- The `HashMap` uses \(O(n)\) additional space to store the frequency of numbers.

---

## Notes

- The solution assumes valid input where exactly one number appears only once.
- To make the solution more efficient, consider alternative approaches like using XOR for \(O(1)\) space complexity.
``` 
