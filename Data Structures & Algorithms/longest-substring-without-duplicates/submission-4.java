class Solution {
    public int lengthOfLongestSubstring(String s) {
        return twoPointer(s);
    }

    int twoPointer(String s){
        int l=0,r=0,res=0;
        int[] a = new int[127];
        while(r<s.length()){
            if(a[s.charAt(r)]!=0){
                while(l<=r && a[s.charAt(r)]!=0){
                    a[s.charAt(l)]--;
                    l++;
                }
                // if(l==r) r++;
            }
            a[s.charAt(r)]++;
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
