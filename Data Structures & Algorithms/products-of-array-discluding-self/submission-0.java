class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] prod = new int[nums.length];
        prefix[0] = 1;
        prefix[1] = nums[0];
        for(int i=2 ; i<nums.length; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }
        suffix[nums.length-1] = 1;
        suffix[nums.length-2] = nums[nums.length-1];
        for(int i=nums.length-3; i>=0 ; i--){
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        for(int i=0; i<nums.length; i++){
            prod[i] = prefix[i] * suffix[i];
        }

        return prod;
        
    }
}  
