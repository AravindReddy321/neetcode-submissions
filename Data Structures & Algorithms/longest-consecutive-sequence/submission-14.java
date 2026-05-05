class Solution {
    public int longestConsecutive(int[] nums) {
        // Set<Integer> s = new HashSet<>();
        // for(int num :  nums){
        //     s.add(num);
        // }
        // int res=0;
        // for(int num : s){
        //     if(s.contains(num-1)) continue;
        //     int temp = num;
        //     int counter = 1;
        //     while(s.contains(++temp)) counter++;
        //     res=Math.max(res,counter);
        // }
        // return res;
        // 2,2,2,3,4,5
        Arrays.sort(nums);
        int res=0;
        int i=0;
        int curr=0;
        int counter =0;
        while(i<nums.length){
            if(curr!=nums[i]){
                counter=0;
                curr=nums[i];
            }
            while(i<nums.length && nums[i]==curr){
                i++;
            }
            counter++;
            curr++;
            res=Math.max(res,counter);
        }

        return res;
    }
}
