# Fibonacci Number Finder

This Java program calculates the \( n \)-th Fibonacci number using a recursive approach. The Fibonacci sequence is defined as:
- \( F(0) = 0 \)
- \( F(1) = 1 \)
- \( F(n) = F(n-1) + F(n-2) \), for \( n > 1 \).

---

## **Code Explanation**
### Code:
```java
public class Solution {
    public static int fib(int n){
        if(n==0) return 0;  // Base case 1
        else if (n==1) return 1;  // Base case 2
        return fib(n-1) + fib(n-2);  // Recursive case
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));  // Output the 4th Fibonacci number
    }
}
```

---

### **Step-by-Step Dry Run**
Given \( n = 4 \), let’s trace how the program works:


### **Recursive Calls**
1. \( F(4) = F(3) + F(2) \)  
2. \( F(3) = F(2) + F(1) \)  
3. \( F(2) = F(1) + F(0) \)  

---

### **Returning Values**
- \( F(0) = 0 \)  
- \( F(1) = 1 \)  


---

### **Output**
The program prints:
```
3
```

### **Detailed Dry Run of Fibonacci Program**


---

### **Call Tree for \( n = 4 \)**

The recursive call tree structure for \( \text{fib}(4) \) is as follows:

```
fib(4)
├── fib(3)
│   ├── fib(2)
│   │   ├── fib(1) → 1
│   │   └── fib(0) → 0
│   └── fib(1) → 1
└── fib(2)
    ├── fib(1) → 1
    └── fib(0) → 0
```

---


### **Step-by-Step Execution**

We begin with \( F(4) \) and resolve each call recursively.

---

#### **Initial Call**
1. \( F(4) \):  
   - Calls \( F(3) \) and \( F(2) \).  
   - Value: \( F(4) = F(3) + F(2) \).  

---

#### **Resolving \( F(3) \)**
2. \( F(3) \):  
   - Calls \( F(2) \) and \( F(1) \).  
   - Value: \( F(3) = F(2) + F(1) \).  

---

#### **Resolving \( F(2) \) Inside \( F(3) \)**
3. \( F(2) \):  
   - Calls \( F(1) \) and \( F(0) \).  
   - Value: \( F(2) = F(1) + F(0) \).  

4. \( F(1) = 1 \) (Base case).  
5. \( F(0) = 0 \) (Base case).  

6. Substitute values:  
   - \( F(2) = 1 + 0 = 1 \).  

---

#### **Resolving \( F(1) \) Inside \( F(3) \)**
7. \( F(1) = 1 \) (Base case).  

8. Substitute values:  
   - \( F(3) = F(2) + F(1) = 1 + 1 = 2 \).  

---

#### **Resolving \( F(2) \) Inside \( F(4) \)**
9. \( F(2) \):  
   - Calls \( F(1) \) and \( F(0) \) (similar to previous calculation).  
   - \( F(2) = 1 + 0 = 1 \).  

---

#### **Final Calculation for \( F(4) \)**
10. Substitute values:  
    - \( F(4) = F(3) + F(2) = 2 + 1 = 3 \).  

---


### **Dry Run Table**

| Step | Call          | Base Case | Recursive Calls       | Returned Value |
|------|---------------|-----------|-----------------------|----------------|
| 1    | fib(4)        | No        | fib(3), fib(2)        | 3              |
| 2    | fib(3)        | No        | fib(2), fib(1)        | 2              |
| 3    | fib(2)        | No        | fib(1), fib(0)        | 1              |
| 4    | fib(1)        | Yes       | None                  | 1              |
| 5    | fib(0)        | Yes       | None                  | 0              |
| 6    | fib(1)        | Yes       | None                  | 1              |
| 7    | fib(2)        | No        | fib(1), fib(0)        | 1              |
| 8    | fib(1)        | Yes       | None                  | 1              |
| 9    | fib(0)        | Yes       | None                  | 0              |

---



## **Conclusion**
- The recursive solution is simple but inefficient for large \( n \) due to exponential time complexity.
- For practical applications, consider **dynamic programming** or **iterative approaches** to optimize performance.
