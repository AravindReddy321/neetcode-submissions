class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int num :  nums){
            s.add(num);
        }
        int res=0;
        for(int num : s){
            if(s.contains(num-1)) continue;
            int temp = num;
            int counter = 0;
            while(s.contains(temp++)) counter++;
            res=Math.max(res,counter);
        }
        return res;
    }
}
