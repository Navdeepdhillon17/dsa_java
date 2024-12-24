# Group Anagrams Solution

## Problem Description
Given an array of strings `strs`, the goal is to group the strings that are anagrams of each other. Anagrams are words or phrases formed by rearranging the letters of another, such as "eat" and "tea."

### Example:
**Input**:  
`strs = ["eat", "tea", "tan", "ate", "nat", "bat"]`

**Output**:  
`[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]`

---

## How the Solution Works

### Key Idea:
1. Anagrams will have the **same sorted sequence of characters**.  
   For example:
   - `"eat"`, `"tea"`, and `"ate"` will all become `"aet"` when sorted.
   - `"tan"` and `"nat"` will become `"ant"`.

2. We can use a **HashMap** to group strings by their sorted representation:
   - **Key**: The sorted string.
   - **Value**: A list of all strings that match the sorted string.

---

### Code Walkthrough:
```java
class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray(); // Convert string to char array
            Arrays.sort(chars);            // Sort the char array
            String sortedString = new String(chars); // Convert back to string
            
            // If the sorted string is not already in the map, add it
            if(!ans.containsKey(sortedString)){
                ans.put(sortedString, new ArrayList<>()); // Create a new list
                ans.get(sortedString).add(s);            // Add the original string to the list
            } else {
                ans.get(sortedString).add(s); // Add to existing list
            }
        }
        return new ArrayList<>(ans.values()); // Convert map values to a list of lists
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anargrams = groupAnagrams(strs);
        for(List<String> s: anargrams){
            System.out.print(s + " "); // Print the grouped anagrams
        }
    }
}
```

---

### Dry Run of the Code:

#### Input:
`strs = ["eat", "tea", "tan", "ate", "nat", "bat"]`

#### Step-by-Step Execution:

1. **Initialize a HashMap**:  
   `ans = {}`

2. **Iterate through each string in `strs`:**

   - **String**: `"eat"`  
     - Convert to char array: `['e', 'a', 't']`  
     - Sort: `['a', 'e', 't']`  
     - Convert back to string: `"aet"`  
     - Add to map:  
       `ans = {"aet": ["eat"]}`  

   - **String**: `"tea"`  
     - Convert to char array: `['t', 'e', 'a']`  
     - Sort: `['a', 'e', 't']`  
     - Convert back to string: `"aet"`  
     - Add to existing list:  
       `ans = {"aet": ["eat", "tea"]}`  

   - **String**: `"tan"`  
     - Convert to char array: `['t', 'a', 'n']`  
     - Sort: `['a', 'n', 't']`  
     - Convert back to string: `"ant"`  
     - Add to map:  
       `ans = {"aet": ["eat", "tea"], "ant": ["tan"]}`  

   - **String**: `"ate"`  
     - Convert to char array: `['a', 't', 'e']`  
     - Sort: `['a', 'e', 't']`  
     - Convert back to string: `"aet"`  
     - Add to existing list:  
       `ans = {"aet": ["eat", "tea", "ate"], "ant": ["tan"]}`  

   - **String**: `"nat"`  
     - Convert to char array: `['n', 'a', 't']`  
     - Sort: `['a', 'n', 't']`  
     - Convert back to string: `"ant"`  
     - Add to existing list:  
       `ans = {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"]}`  

   - **String**: `"bat"`  
     - Convert to char array: `['b', 'a', 't']`  
     - Sort: `['a', 'b', 't']`  
     - Convert back to string: `"abt"`  
     - Add to map:  
       `ans = {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"], "abt": ["bat"]}`  

3. **Final Map State**:  
   `ans = {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"], "abt": ["bat"]}`

4. **Return Result**:  
   Convert `ans.values()` to a list of lists:  
   `result = [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]`

---

### Output:
`[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]`

---

Here’s a clearer explanation of the **time complexity** and why we converted the string to a char array:

---

### **Why Convert the String to a Char Array?**

We converted each string into a character array because sorting a string directly isn't possible in Java. To sort the characters in a string, we must first:

1. Convert the string to a character array using `toCharArray()`.
   - For example, `"eat"` becomes `['e', 'a', 't']`.

2. Sort the character array using `Arrays.sort(chars)`.
   - After sorting, `['e', 'a', 't']` becomes `['a', 'e', 't']`.

3. Convert the sorted character array back into a string using `new String(chars)`.
   - After conversion, `['a', 'e', 't']` becomes `"aet"`.

This sorted string acts as a **key** in the HashMap, ensuring that all anagrams share the same key. For example:
   - `"eat"`, `"tea"`, and `"ate"` will all produce the key `"aet"`.

---

### **Time Complexity Analysis**

#### Step 1: **Sorting Each String**
- Sorting a string of length \( k \) (average length of strings in `strs`) takes \( O(k \log k) \).  
- Since we need to sort all \( n \) strings, this step has a complexity of:
  \[
  O(n \cdot k \log k)
  \]

#### Step 2: **HashMap Operations**
- For each string, we either:
  1. **Check if the key exists** in the HashMap: \( O(1) \) on average, due to efficient hashing.
  2. **Insert the string** into the corresponding list in the map: \( O(1) \) for adding to an ArrayList.

- This operation is performed \( n \) times, so the total cost is:
  \[
  O(n)
  \]

#### Step 3: **Returning the Results**
- Extracting the values from the HashMap and converting them into a list is proportional to the number of strings:
  \[
  O(n)
  \]

---

### **Total Time Complexity**

Adding up the costs:
1. Sorting all strings: \( O(n \cdot k \log k) \)
2. HashMap operations: \( O(n) \)
3. Returning the result: \( O(n) \)

Since \( O(n \cdot k \log k) \) dominates the other terms, the total time complexity is:
\[
O(n \cdot k \log k)
\]

---

### **Space Complexity Analysis**

1. **HashMap Storage**:
   - The HashMap stores \( n \) keys, each of size \( k \), along with the strings in the lists.
   - Total storage: \( O(n \cdot k) \).

2. **Temporary Char Arrays**:
   - For each string, we create a temporary character array for sorting. This requires \( O(k) \) space per string.
   - Since we process one string at a time, the space used is not cumulative.

3. **Final Result List**:
   - The output is a list of lists, which also requires \( O(n \cdot k) \) space.

Total space complexity:
\[
O(n \cdot k)
\]

---

### **Summary**

- **Why Convert Strings to Char Arrays?**
  - Sorting is necessary to group anagrams by a common key, and sorting requires the input to be a character array.

- **Time Complexity**: \( O(n \cdot k \log k) \)  
- **Space Complexity**: \( O(n \cdot k) \)
