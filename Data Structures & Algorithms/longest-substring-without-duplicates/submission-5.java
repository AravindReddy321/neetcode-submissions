class Solution {
    public int lengthOfLongestSubstring(String s) {
        // return twoPointer(s);
        return slidingWindow(s);
    }

    int slidingWindow(String s){
        int l=0,res=0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for(int r=0;r<s.length();r++){
            if(m.containsKey(s.charAt(r))){
                l=Math.max(l,m.get(s.charAt(r))+1);
            }
            m.put(s.charAt(r),r);
            res=Math.max(res,r-l+1);
        }
        return res;
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
            }
            a[s.charAt(r)]++;
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
