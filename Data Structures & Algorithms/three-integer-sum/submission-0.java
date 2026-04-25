class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return twoPointer(nums);
    }
    public List<List<Integer>> twoPointer(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum = nums[l]+nums[r]+nums[i];
                if(0 < sum) r--;
                else if( 0>sum) l++;
                else {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                    while (l < r && nums[r] == nums[r+ 1]) {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
