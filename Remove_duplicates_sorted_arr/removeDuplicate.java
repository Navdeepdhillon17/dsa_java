class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 4, 5, 6, 6 };
        Solution obj = new Solution();
        int uniqueCount = obj.removeDuplicates(nums);
        System.out.println("Number of unique elements: " + uniqueCount);

    }

}
