class Solution {
    public int[] twoSum(int[] numbers, int target) {

        //return hashTable(numbers,target);
        return twoPointer(numbers, target);
        
    }

    public int[] twoPointer(int[] nums, int t){
        int l=0,r=nums.length-1;
        while(l<r){
            int sum = nums[l]+nums[r];
            if(sum == t){
                return new int[] {l+1,r+1};
            }else if(sum < t){
                l++;
            }else{
                r--;
            }
        }
        return new int[0];
    }

    public int[] hashTable(int[] numbers,int target){
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<numbers.length;i++){
            if(m.containsKey(numbers[i])){
                res[0] =m.get(numbers[i]);
                res[1] =i+1;
                return res;
            }
            m.put(target-numbers[i],i+1);
        }
        return res;
    }
}
