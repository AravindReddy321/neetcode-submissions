class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resMap = new HashMap<Integer, Integer>();
        int[] resArr = new int[2];
        for(int i=0;i<nums.length;i++){
            if(resMap.containsKey(target-nums[i])){
                resArr[0] = resMap.get(target-nums[i]);
                resArr[1] = i;
                break;
            }
            resMap.put(nums[i],i);
        }
        return resArr;
    }
}
