class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] inverseList = new ArrayList[nums.length+1];

        // for(int i=0;i<nums.length;i++){
        //     if(!freqMap.containsKey(nums[i])){
        //         freqMap.put(nums[i],0);
        //     }
        //     freqMap.put(nums[i],freqMap.get(nums[i])+1);
        // }
        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0)+1);
        }

        // for(int i : freqMap.keySet()){
        //     if(inverseList[freqMap.get(i)] == null){
        //         inverseList[freqMap.get(i)]=new ArrayList<>();
        //     }
        //     inverseList[freqMap.get(i)].add(i);
        // }

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            if(inverseList[entry.getValue()] == null){
                inverseList[entry.getValue()]=new ArrayList<>();
            }
            inverseList[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        for(int i=inverseList.length-1,j=0;i>=0;i--){
            if(inverseList[i] == null || inverseList[i].size() == 0){
                continue;
            }else{
                for(int z : inverseList[i]){
                    result[j++] = z;
                    if(k==j){
                        break;
                    }
                }
                if(k==j){
                    break;
                }
            }
        }
        System.out.println("result "+Arrays.toString(result));
        return result;
    }
}
