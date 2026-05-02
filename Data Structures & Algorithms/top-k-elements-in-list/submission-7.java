class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // return bucketSort(nums,k);
        // return minHeap(nums, k);
        return customSort(nums, k);
        
    }

    int[] customSort(int[] nums, int k){
        Arrays.sort(nums);
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int count=0;
        int[] res = new int[k];
        for(int i=0;i<nums.length;i++){
            count++;
            if((i+1)<nums.length && nums[i]==nums[i+1]) continue;
            p.offer(new int[]{count,nums[i]});
            if(p.size()>k){
                p.poll();
            }
            count =0;
        }
        for(int i=k-1;i>=0;i--){
            res[i]=p.poll()[1];
        }
        return res;
        
    }


    int[] minHeap(int[] nums, int k){
        Map<Integer,Integer> m = new HashMap<>();
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] res = new int[k];
        for(int num : nums){
            m.put(num, m.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            p.offer(new int[]{e.getValue(),e.getKey()});
            if(p.size()>k){
                p.poll();
            }
        }
        for(int i=0;i<k;i++){
            res[i]=p.poll()[1];
        }
        return res;
    }

    int[] bucketSort(int[] nums, int k){
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
