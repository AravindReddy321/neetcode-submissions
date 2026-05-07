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

        // return sorting(nums);
        return stream(nums);
    }

    public int stream(int[] nums){
        if(nums.length == 0) return 0;
        int[] nums1 = new int[nums.length-1];
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            nums1[i]=nums[i];
            s.add(nums1[i]);
        }
        int res=0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int n : s){
            if(s.contains(n-1)) continue;
            int curr=0,i=n;
            while(s.contains(i)){
                i++;curr++;
            }
            res=Math.max(res,curr);
            m.put(n,curr);
            m.put(i-1,curr);
        }
        int newNum = nums[nums.length-1];
        int left = m.getOrDefault(newNum-1,0);
        int right = m.getOrDefault(newNum+1,0);
        if(!s.contains(newNum)){
            // if(left>0 && right >0){
                m.put(newNum-left,left+1+right);
                m.put(newNum+right,left+1+right);
                res=Math.max(res,left+1+right);
            // }else if(left >0){
            //     m.put(newNum-left,left+1);
            //     m.put(newNum,left+1);
            //     res=Math.max(res,left+1);
            // }
            // else if(right >0){
            //     m.put(newNum,right+1);
            //     m.put(newNum+right,right+1);
            //     res=Math.max(res,right+1);
            // }else{
            //     m.put(newNum,1);
            //     res=Math.max(res,1);
            // }
            s.add(newNum);
        }
        return res;
    }

    public int sorting(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int res=0;
        int i=0;
        int curr=nums[0];
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
