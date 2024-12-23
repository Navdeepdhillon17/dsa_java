// 15. Find First and Last Position of Element in Sorted Array
public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = searchLeft(nums, target);
        int[] result = {-1, -1};
        result[0] = firstIndex;
        int lastIndex = searchRight(nums, target);
        result[1] = lastIndex;
        return result;
    }
    public static int searchLeft(int[] nums, int target){
        int index = -1, left = 0, right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                index = mid;
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{ // if nums[mid] > target
                right = mid -1;
            }
        }
        return index;
    }
    public static int searchRight(int[] nums, int target){
        int index = -1, left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                index = mid;
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else { // nums[mid] < target
                left = mid+1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] result = searchRange(nums, target);
        for(int i: result){
            System.out.println(i);
        }
    }
}
