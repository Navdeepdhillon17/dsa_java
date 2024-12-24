// 16. Group Anagrams
class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
//            System.out.print(Arrays.toString(chars) + " ");
            String sortedString = new String(chars);
//            System.out.print(sortedString + " ");
            if(!ans.containsKey(sortedString)){
                ans.put(sortedString, new ArrayList<>());
                ans.get(sortedString).add(s);
            }else{
                ans.get(sortedString).add(s);
            }
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anargrams = groupAnagrams(strs);
        for(List<String> s: anargrams){
            System.out.print(s + " ");
        }
    }
}
