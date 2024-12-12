// 8: Single Number
public class Solution {
    public static int singleNumber(int[] arr){
        HashMap <Integer, Integer> map = new HashMap<>();
        int singleValue = 0;
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0) +1);
        }
        for(int i: arr){
            if(map.get(i) == 1){
                singleValue = i;
            }
        }
        return singleValue;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int s = singleNumber(nums);
        System.out.println(s);
    }
}
