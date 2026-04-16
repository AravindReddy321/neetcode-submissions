class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<Integer>();

        for(int i=0;i<nums.length;i++){
            numSet.add(nums[i]);
        }

        int longCon = 0;
        for(int i=0;i<nums.length;i++){
            if(numSet.contains(nums[i]-1)) continue;
            int z=nums[i];
            int currSeqCount = 0;
            while(numSet.contains(z)){
                currSeqCount++;
                z++;
            }
            longCon = longCon > currSeqCount ? longCon : currSeqCount;
        }

        return longCon;
        
    }
}
