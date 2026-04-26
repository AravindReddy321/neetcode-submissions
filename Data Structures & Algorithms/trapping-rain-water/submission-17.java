class Solution {
    public int trap(int[] height) {
        return twoPointer(height);
    }

    int twoPointer(int[] height){
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int res=0;

        prefix[0]=height[0];
        for(int i=1;i<height.length;i++){
            prefix[i]=Math.max(height[i],prefix[i-1]);
        }

        suffix[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            suffix[i]=Math.max(height[i],suffix[i+1]);
        }
        
        for(int i=0;i<height.length;i++){
            //int area = Math.min(prefix[i], suffix[i])-height[i];
            //res += Math.max(area,0);
            res += Math.min(prefix[i], suffix[i])-height[i];
        }
        return res;
    }
}
