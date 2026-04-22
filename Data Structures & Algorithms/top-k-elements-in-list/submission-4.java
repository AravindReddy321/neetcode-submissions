class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //return sortingAlgo(nums, k);
        return minHeap(nums,k);
    }

    public int[] bucketSort(int[] nums, int k){
        Map<Integer, Integer> m = new HashMap<>();
        for(int num : nums){
            m.put(num, m.getOrDefault(m,0)+1);
        }
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<nums.length+1;i++){
            l.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            l.get(e.getValue()).add(e.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i=l.size()-1;i>=0;i--){
            for(int j:l.get(i)){
                if(index == k) return res;
                res[index++] = j;
            }
        }
        return res;
    }

    public int[] minHeap(int[] nums, int k){
        Map<Integer, Integer> m = new HashMap<Integer,Integer>();
        for(int num : nums){
            m.put(num, m.getOrDefault(num,0)+1);
        }
        // main step - min heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            //if(heap.size() == k) heap.poll();
            heap.offer(new int[]{e.getValue(), e.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = heap.poll()[1];
        }
        return res;
    }

    public int[] sortingAlgo(int[] nums, int k){
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        List<List<Integer>> l = new ArrayList<>();
        int[] r = new int[k];
        for(int num : nums){
            m.put(num, m.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            List<Integer> iL = new ArrayList<>();
            iL.add(e.getValue());
            iL.add(e.getKey());
            l.add(iL);
        }
        //main step - custom sorting
        l.sort( (a,b) -> b.get(0)-a.get(0));
        for(int i=0;i<k;i++){
            r[i] = l.get(i).get(1);
        }
        return r;
    }
}
