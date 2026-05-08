class Solution {
    public boolean hasDuplicate(int[] nums) {
        // return sorting(nums);
        // return hashSetLengthWay(nums);
        return hashSetContainsWay(nums);
    }

    public boolean hashSetContainsWay(int[] nums){
        Set<Integer> s = new HashSet<>();
        for(int num : nums){
            if(s.contains(num)) return true;
            s.add(num);
        }
        return false;
    }

    public boolean hashSetLengthWay(int[] nums){
        Set<Integer> s = new HashSet<>();
        for(int num:nums){
            s.add(num);
        }
        return s.size()!=nums.length;
    }

    public boolean sorting(int[] nums){
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i])
                return true;
        }
        return false;
    }

}