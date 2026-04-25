class Solution {
    public int maxArea(int[] heights) {
        return twoPointer(heights);
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
