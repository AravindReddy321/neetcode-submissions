class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> s = new HashSet<Integer>();
        for(int num : nums){
            s.add(num);
        }
        int l =0;
        for(int num : s){
            if(s.contains(num-1)) continue;
            int cur =1;
            while(s.contains(num+1)){
                cur++;
                num = num+1;
            }
            if( l < cur) l=cur;
        }
        return l;
        
    }
}
