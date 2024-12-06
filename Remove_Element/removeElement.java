class Solution {
    public int removeElement(int[] nums, int val) {
       int k = 0;
       for(int i = 0; i <nums.length; i++){
           if(nums[i] != val){
               nums[k] = nums[i];
               k++;
           }
       }
       return k;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        Solution obj = new Solution();
        int newLength = obj.removeElement(nums, val);
        for(int i=0; i<newLength; i++){
            System.out.print(nums[i] + " ");
        }
    }
    }