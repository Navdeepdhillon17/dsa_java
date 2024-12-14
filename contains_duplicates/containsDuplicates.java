// 9: Contains duplicate
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
       HashSet <Integer> set = new HashSet<>();
       for(int num : nums){
        if(set.contains(num)){
            return true;
        }
        set.add(num);
       }
       return false;

    }
    public static void main(String[] args) {
      int[]  nums = {1,2,3};
      int[] nums2 = {1,1,1,3,3,4,3,2,4,2,6};
      boolean dup = containsDuplicate(nums2);
        System.out.println(dup);
    }
}
