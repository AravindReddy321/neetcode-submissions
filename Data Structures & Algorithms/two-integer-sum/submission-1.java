class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] result = new int[2];

        for(int i=0;i<nums.length;i++){
            if(numsMap.get(target-nums[i]) != null){
                result[0] = numsMap.get(target-nums[i]);
                result[1] = i;
                break;
            }
            numsMap.put(nums[i], i);
        }

        return result;
    }
}
