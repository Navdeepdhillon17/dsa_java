// 11. Move zeroes
public class  Solution {
    public static void moveZeroes(int[] nums) {
      int lastNonZeroIndex = 0;
      for(int i = 0; i<nums.length; i++){
          if(nums[i] != 0){
             if(i != lastNonZeroIndex){
                nums[lastNonZeroIndex] = nums[i];
             }
              lastNonZeroIndex++;
          }
      }
      for(int i = lastNonZeroIndex; i<nums.length; i++){
          nums[i] = 0;
      }
        printArr(nums);
    }
    public static void printArr(int[] arr){
        System.out.println("the result is: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] nums2 = {0};
        moveZeroes(nums);

    }
}
