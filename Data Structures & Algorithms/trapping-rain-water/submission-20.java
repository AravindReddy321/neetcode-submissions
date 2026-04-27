class Solution {
    public int trap(int[] height) {
        // return prefSuffix(height);
        //return twoPointer(height);
        return stackWay(height);
    }
    int stackWay(int[] height){
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int res=0;
        for(int i=1;i<height.length;i++){
            while(!s.isEmpty() && height[s.peek()] < height[i]){
                int floor = height[s.pop()];
                if(!s.isEmpty()){
                    int rightWall = height[i];
                    int leftWall = height[s.peek()];
                    int distance = i-s.peek()-1;
                    res += (Math.min(leftWall,rightWall) - floor)*(distance);
                }
            }
            s.push(i);
        }
        return res;
    }
    
    int twoPointer(int[] height){
        int l=0,r=height.length-1;
        int leftMax=height[l],rightMax=height[r];
        int res=0;
        while(l<r){
            if(leftMax<rightMax){
                l++;
                res += Math.max(leftMax-height[l],0);
                leftMax=Math.max(leftMax,height[l]);
                //l++;
                //res += leftMax-height[l];
            }else{
                r--;
                res += Math.max(rightMax-height[r],0);
                rightMax=Math.max(rightMax,height[r]);
                //r--;
                // res += rightMax-height[r];
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
