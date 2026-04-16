class Solution {
    public int trap(int[] height) {
        int lWall = height[0];
        int rWall = height[height.length-1];
        int sum=0;
        for(int left=0,right=height.length-1;left<right;){
            if( rWall >= lWall) {
                if(lWall >= height[left+1]){
                    sum+=lWall - height[left+1];
                }
                if(lWall < height[left+1]){
                    lWall = height[left+1];
                }
                left++;
            }else if(lWall > rWall){
                //if( rWall >0){
                    if(rWall >= height[right-1]){
                        sum+=rWall - height[right-1];
                    }
                    if(rWall < height[right-1]){
                        rWall = height[right-1];
                    }
                //}
                right--;
            }
            // System.out.println("left"+left);
            // System.out.println("right "+right);
            // System.out.println("lwall "+lWall);
            // System.out.println("rwall "+rWall);
            // System.out.println("sum "+sum);
        }
        // System.out.println("sum "+sum);
        return sum;
    }
}
