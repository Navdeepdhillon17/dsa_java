class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();
            Arrays.sort(nums);
            int n = nums.length;
                for(int k = 0; k<n-2; k++){
                    int i = k+1, j = n -1;
                while(i<j){
                    int sum = nums[k] + nums[i] + nums[j];
                    if(sum == 0 ){
                      result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                      i++;
                      j--;

                  }else if(sum<0){
                      i++;
                  }else{
                      j--;
                  }
                }
            }
            return new ArrayList<>(result);
        }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> t = threeSum(arr);
        System.out.println("The resultant pair is: ");
        System.out.println(t);
    }
}
