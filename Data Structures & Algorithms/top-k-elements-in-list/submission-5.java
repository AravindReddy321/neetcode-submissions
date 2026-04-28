class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> m = new HashMap<>();
        List<List<Integer>> l = new ArrayList<>();
        int[] res = new int[k];
        for(int num : nums){
            m.put(num, m.getOrDefault(num,0)+1);
        }
        for(int i=0;i<=nums.length;i++){
            l.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            l.get(e.getValue()).add(e.getKey());
        }
        int z=0;
        for(int i=l.size()-1;i>=0;i--){
            for(int j : l.get(i)){
                if(z==k) break;
                res[z++] = j;
            }
        }
        return res;
        
    }
}
