// 7: Intersection of Two Arrays II
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int n1 : nums1) {
            map.put(n1, map.getOrDefault(n1, 0) +1);
        }
        for (int n2 : nums2) {
          if(map.containsKey(n2) && map.get(n2)>0){
              list.add(n2);
              map.put(n2, map.get(n2)-1);
          }
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i< list.size(); i++){
            arr[i] = list.get(i);
        }
      
        return arr;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        Solution obj = new Solution();
        int[] result = obj.intersect(nums1, nums2);
        System.out.println("The intersected elements are: ");
        for(int j: result){
            System.out.print(j+ " ");
        }

    }
}
