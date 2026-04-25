class Solution {
    public int trap(int[] height) {
        return twoPointer(height);
    }

    int twoPointer(int[] height){
        Map<Integer,Integer> prefix = new HashMap<>();
        Map<Integer,Integer> suffix = new HashMap<>();
        int res=0;
        for(int i=0;i<height.length;i++){
            int l=0,r=i;
            while(l<r){
                prefix.put(i,Math.max(prefix.getOrDefault(i,0), height[l++]));
            }
            l=i+1;
            r=height.length;
            while(l<r){
                suffix.put(i,Math.max(suffix.getOrDefault(i,0), height[l++]));
            }
        }
        for(int i=0;i<height.length;i++){
            int area = Math.min(prefix.getOrDefault(i,0), suffix.getOrDefault(i,0))-height[i];
            res += Math.max(area,0);
        }
        return res;
    }
}
