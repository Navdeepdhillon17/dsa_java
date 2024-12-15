// 10: Plus one
public class Solution {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i>=0; i--){
            digits[i] += 1;
            if(digits[i] < 10){
                return digits;
            }
                digits[i] = 0;

        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;


    }

    public static void main(String[] args) {
        int[] arr = {9};
        int[] arr2 = {1,2,3,4};
        int[] ans = plusOne(arr2);
        System.out.println(Arrays.toString(ans));
    }
}
