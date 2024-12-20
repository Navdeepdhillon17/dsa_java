
# Roman to Integer Conversion



## Problem Statement
Convert a Roman numeral string to its corresponding integer value. Roman numerals are represented by the following characters:



| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |



### Special Rules
In Roman numerals, a smaller numeral placed before a larger numeral indicates subtraction (e.g., `IV = 4`, `IX = 9`). Otherwise, the numerals are added together (e.g., `VI = 6`, `XII = 12`).



---



## Algorithm
1. **Define Mapping**:  
   Use a helper method `romanValue(char ch)` to return the integer value of a given Roman numeral character.



2. **Iterate Through the String**:  
   Loop through the characters of the Roman numeral string.



3. **Subtractive Notation**:  
   - If the current numeral is smaller than the next numeral, subtract its value from the total.  
   - Otherwise, add its value to the total.  



4. **Edge Case Handling**:  
   Ensure out-of-bounds access is avoided by checking `(i + 1) < length` before accessing the next character.



5. **Return the Result**:  
   After iterating through the string, return the computed sum.



---



## Code Implementation
```java
public class Solution {
    public int romanValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }



    public int romanToInt(String s) {
        int length = s.length();
        int sum = 0;



        for (int i = 0; i < length; i++) { // Corrected loop condition
            char ch1 = s.charAt(i);
            if (i + 1 < length && romanValue(ch1) < romanValue(s.charAt(i + 1))) {
                sum -= romanValue(ch1);
            } else {
                sum += romanValue(ch1);
            }
        }



        return sum;
    }
}



```

---



## Explanation of Key Parts



### `romanValue` Method
- Maps Roman numeral characters to their integer values using a `switch` statement.
- Provides clarity and efficiency in mapping Roman numerals to integers.



### Subtractive Notation Check
- `(i + 1) < length`: Ensures safe access to the next character to avoid out-of-bounds errors.
- `romanValue(currentChar) < romanValue(s.charAt(i + 1))`: Identifies subtractive cases where the current numeral is smaller than the next numeral.



### Main `for` Loop
- Iterates through the Roman numeral string.
- Adds or subtracts the current numeral's value based on whether it forms part of a subtractive combination.



---



## Example Walkthroughs



### Example 1: Input `"III"`
1. Initialize `sum = 0`.
2. Process each character:
   - `I (1)`: Add 1 → `sum = 1`.
   - `I (1)`: Add 1 → `sum = 2`.
   - `I (1)`: Add 1 → `sum = 3`.
3. Output: `3`.



---



### Example 2: Input `"IV"`
1. Initialize `sum = 0`.
2. Process each character:
   - `I (1)`: Check next numeral `V (5)`. Since `1 < 5`, subtract `1 → sum = -1`.
   - `V (5)`: Add 5 → `sum = 4`.
3. Output: `4`.



---



### Example 3: Input `"MCMXCIV"`
1. Initialize `sum = 0`.
2. Process each character:
   - `M (1000)`: Add 1000 → `sum = 1000`.
   - `C (100)`: Check next numeral `M (1000)`. Since `100 < 1000`, subtract `100 → sum = 900`.
   - `M (1000)`: Add 1000 → `sum = 1900`.
   - `X (10)`: Check next numeral `C (100)`. Since `10 < 100`, subtract `10 → sum = 1890`.
   - `C (100)`: Add 100 → `sum = 1990`.
   - `I (1)`: Check next numeral `V (5)`. Since `1 < 5`, subtract `1 → sum = 1989`.
   - `V (5)`: Add 5 → `sum = 1994`.
3. Output: `1994`.



---



## Complexity Analysis



1. **Time Complexity**: \( O(n) \)  
   The algorithm processes each character in the string exactly once.



2. **Space Complexity**: \( O(1) \)  
   No additional data structures are used, and the space usage is constant.
