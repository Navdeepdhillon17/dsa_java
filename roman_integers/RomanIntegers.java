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
