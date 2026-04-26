class Solution {
    public int trap(int[] height) {
        return twoPointer(height);
    }

    int twoPointer(int[] height){
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int res=0;

        int lmax=height[0];
        for(int i=0;i<height.length;i++){
            lmax=Math.max(height[i],lmax);
            prefix[i]=lmax;
        }

        int rmax=height[height.length-1];
        for(int i=height.length-1;i>=0;i--){
            rmax=Math.max(height[i],rmax);
            suffix[i]=rmax;
        }
        
        for(int i=0;i<height.length;i++){
            //int area = 
            res += Math.min(prefix[i], suffix[i])-height[i];
            //res += Math.max(area,0);
        }
        return res;
    }
}
