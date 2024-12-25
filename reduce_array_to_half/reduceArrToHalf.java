//17. Reduce array size to half
class Solution {
    public static int minSetSize(int[] arr) {
    int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
                map.put(i, map.getOrDefault(i, 0) +1);
        }
        List<Integer> freq = new ArrayList<>(map.values());
        freq.sort((a, b) -> b - a);
        int removeValues = 0;
        int removeCount = 0;
        for(int f:freq){
            removeValues += f;
            removeCount ++;
            if(removeValues >= n/2){
                break;
            }
        }
        return removeCount;
    }
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7};
        int m = minSetSize(arr);
        System.out.println(m);
    }
}
