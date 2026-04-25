class Solution {
    public int maxArea(int[] heights) {
        // return twoPointer(heights);
        return twoPointer2(heights);
    }

    int twoPointer2(int[] heights){
        int l=0,r=heights.length-1;
        int max=0;
        while(l<r){
            int currArea = Math.min(heights[l],heights[r])*(r-l);
            max = Math.max(max,currArea);
            if(heights[l]<heights[r]) l++;
            else r--;
        }
        return max;
    }

















    int twoPointer(int[] heights){
        int l=0,r=heights.length-1;
        int max=0;
        while(l<r){
            int min=0;
            boolean minLeft=false,minRight=false;
            if(heights[l]<heights[r]){
                min=heights[l];
                minLeft=true;
            }else{
                min=heights[r];
                minRight=true;
            }
            int newA = (r-l)*min;
            max = max > newA ? max : newA;
            if(minRight) r--;
            else if(minLeft) l++;
        }
        return max;
    }
}
