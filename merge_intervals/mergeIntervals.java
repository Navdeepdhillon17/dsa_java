// 18. Merge Intervals
 class Solution {
    public static int[][] merge(int[][] arr) {
        if(arr.length <= 1)
            return arr;
        int[][] newArr = new int[arr.length][2];
        int k = 0;
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        newArr[k] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= newArr[k][1]) {
                newArr[k][1] = Math.max(arr[i][1], newArr[k][1]);
            } else {
                k++;
                newArr[k] = arr[i];
            }
        }
        int[][] result = new int[k+1][2];
        for (int i = 0; i <= k; i++) {
            result[i] = newArr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 3},
                {2,6},
                {8,10},
                {15, 18}};
        int[][] arr2 = {{1,3}};
        int[][] arr3 = {{1,4},{5,6}};
        System.out.println("Merged intervals:");
        int[][] mergedArr1 = merge(arr2);
        for (int[] interval : mergedArr1) {
            System.out.println(Arrays.toString(interval));
        }
    }
 }
