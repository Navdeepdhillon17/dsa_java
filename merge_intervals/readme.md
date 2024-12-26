# Merge intervals

## **Problem Description**
The goal is to merge overlapping intervals in a 2D array where each interval is represented as `[start, end]`. After merging, the resulting intervals should be non-overlapping and cover all input intervals.

### Example:
**Input:**
```text
[[1,3], [2,6], [8,10], [15,18]]
```

**Output:**
```text
[[1,6], [8,10], [15,18]]
```

---

## **Solution Explanation**
This solution sorts the intervals based on their start times and then iterates through them to merge overlapping intervals. The merged intervals are stored in a new array which is then returned.

### Algorithm Steps:
1. **Sort the intervals**: Sort the array based on the start times of each interval.
2. **Initialize the result array**: Create a temporary array (`newArr`) to store merged intervals.
3. **Iterate through the intervals**:
   - If the current interval overlaps with the last merged interval, update the end time of the last interval.
   - Otherwise, add the current interval to the result array.
4. **Finalize the result**: Copy the valid merged intervals to the final output array (`result`).
5. **Return the result**.

---

## **Code**
```java
class Solution {
    public static int[][] merge(int[][] arr) {
        if(arr.length <= 1)
            return arr;

        int[][] newArr = new int[arr.length][2];
        int k = 0;

        // Step 1: Sort intervals by start times
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize the first interval
        newArr[k] = arr[0];

        // Step 3: Iterate and merge intervals
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= newArr[k][1]) { // Overlapping intervals
                newArr[k][1] = Math.max(arr[i][1], newArr[k][1]);
            } else { // No overlap, move to next interval
                k++;
                newArr[k] = arr[i];
            }
        }

        // Step 4: Prepare the final result array
        int[][] result = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            result[i] = newArr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr2 = {{1, 3}};
        int[][] arr3 = {{1, 4}, {5, 6}};

        System.out.println("Merged intervals:");
        int[][] mergedArr1 = merge(arr1);
        for (int[] interval : mergedArr1) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
```

---

### Detailed Dry Run and Time Complexity Calculation

---

### **Dry Run of Code**
**Input Array:**  
```java
arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}}
```

---

#### **Step 1: Sorting**
The intervals are sorted based on their start times using:
```java
Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
```

- The sorted array remains the same for this input since the intervals are already sorted:
  ```java
  arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}}
  ```

---

#### **Step 2: Initialization**
- Create an array `newArr` of the same size:
  ```java
  newArr = {{0, 0}, {0, 0}, {0, 0}, {0, 0}}
  ```
- Initialize `k = 0` and set the first interval in `newArr`:
  ```java
  newArr[0] = {1, 3};
  ```

---

#### **Step 3: Iteration and Merging**
##### **Iteration 1 (`i = 1`):**
- Compare `arr[1] = {2, 6}` with `newArr[0] = {1, 3}`:
  - Condition: \( arr[1][0] \leq newArr[0][1] \), i.e., \( 2 \leq 3 \) (True).
  - Merge:
    ```java
    newArr[0][1] = max(3, 6) = 6;
    ```
  - `newArr = {{1, 6}, {0, 0}, {0, 0}, {0, 0}}`

##### **Iteration 2 (`i = 2`):**
- Compare `arr[2] = {8, 10}` with `newArr[0] = {1, 6}`:
  - Condition: \( arr[2][0] \leq newArr[0][1] \), i.e., \( 8 \leq 6 \) (False).
  - No merge; increment `k`:
    ```java
    k = 1;
    newArr[1] = arr[2] = {8, 10};
    ```
  - `newArr = {{1, 6}, {8, 10}, {0, 0}, {0, 0}}`

##### **Iteration 3 (`i = 3`):**
- Compare `arr[3] = {15, 18}` with `newArr[1] = {8, 10}`:
  - Condition: \( arr[3][0] \leq newArr[1][1] \), i.e., \( 15 \leq 10 \) (False).
  - No merge; increment `k`:
    ```java
    k = 2;
    newArr[2] = arr[3] = {15, 18};
    ```
  - `newArr = {{1, 6}, {8, 10}, {15, 18}, {0, 0}}`

---

#### **Step 4: Finalizing the Result**
- Create the final result array with size `k + 1`:
  ```java
  result = {{1, 6}, {8, 10}, {15, 18}};
  ```

---

#### **Output**
The merged intervals are:
```java
[1, 6]
[8, 10]
[15, 18]
```

---

### **Time Complexity Analysis**

#### **1. Sorting**
- Sorting the array of intervals is the most time-consuming operation:
  - Time complexity: \(O(n \log n)\), where \(n\) is the number of intervals.

#### **2. Merging**
- We iterate through the sorted intervals once:
  - For each interval, we compare and either merge or move to the next slot in `newArr`.
  - Time complexity: \(O(n)\).

#### **3. Copying Result**
- Copying the merged intervals to the `result` array takes:
  - Time complexity: \(O(n)\).

#### **Overall Time Complexity**
- The dominant term is \(O(n \log n)\) from sorting:
  - **Total Time Complexity: \(O(n \log n)\).**

---

### **Space Complexity Analysis**

#### **1. Temporary Storage**
- The `newArr` array is of size \(n\):
  - Space complexity: \(O(n)\).

#### **2. Result Storage**
- The `result` array is of size \(k + 1\) (\(k \leq n - 1\)):
  - Space complexity: \(O(n)\).

#### **Overall Space Complexity**
- Since the input array is sorted in place (constant space), the additional space used is for the `newArr` and `result` arrays:
  - **Total Space Complexity: \(O(n)\).**

---

### **Key Observations**
- Sorting ensures intervals are processed in increasing order, which simplifies merging.
- The algorithm is efficient for large inputs because its complexity is dominated by the \(O(n \log n)\) sorting step.

---

## **Key Points**
- Sorting ensures that intervals are processed in the correct order.
- The `k` pointer tracks the position in the result array (`newArr`).
- Overlapping intervals are merged by updating the end time of the last interval.
- Non-overlapping intervals are directly added to the result array.

### Complexity:
- **Time Complexity**: \(O(n \log n)\) due to sorting, where \(n\) is the number of intervals.
- **Space Complexity**: \(O(n)\) for the result array.
