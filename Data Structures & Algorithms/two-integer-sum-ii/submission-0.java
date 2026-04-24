class Solution {
    public int[] twoSum(int[] numbers, int target) {
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
