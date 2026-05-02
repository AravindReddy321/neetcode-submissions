class Solution {
    public int[] twoSum(int[] nums, int target) {
        // return hashMapMethod(nums, t);
        return twoPointerList(nums, target);
    }

    public int[] twoPointerList(int[] nums, int t){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(new ArrayList<>(Arrays.asList(nums[i],i)));
        }
        list.sort((a,b)->a.get(0)-b.get(0));
        System.out.println(list);
        int l=0,r=list.size()-1;
        while(l<r){
            int sum = list.get(l).get(0) + list.get(r).get(0);
            if(t < sum) r--;
            else if( t > sum) l++;
            else return new int[]{ Math.min(list.get(l).get(1), list.get(r).get(1)),
            Math.max(list.get(l).get(1), list.get(r).get(1))};
        }
        return new int[0];
    }


    public int[] hashMapMethod(int[] nums, int t){
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                return new int[]{m.get(nums[i]),i};
            }
            m.put(t-nums[i],i);
        }
        return new int[] {};
    }
}
