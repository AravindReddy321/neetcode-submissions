class Solution {
    public int trap(int[] height) {
        // return prefSuffix(height);
        return twoPointer(height);
    }
    
    int twoPointer(int[] height){
        int l=0,r=height.length-1;
        int leftMax=height[l],rightMax=height[r];
        int res=0;
        while(l<r){
            if(leftMax<rightMax){
                res += Math.max(leftMax-height[l],0);
                l++;
                leftMax=Math.max(leftMax,height[l]);
            }else{
                res += Math.max(rightMax-height[r],0);
                r--;
                rightMax=Math.max(rightMax,height[r]);
            }
        }
        return res;
    }

    int prefSuffix(int[] height){
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
