class Solution {
    public int lengthOfLongestSubstring(String s) {
        /* this is wrong
        int[] arr = new int[127];
        int unique=0,res=0;
        for(int i=0;i< s.length();i++){
            if (arr[s.charAt(i)]==0){
                arr[s.charAt(i)]=i+1;
                unique++;
                res=Math.max(unique,res);
                arr[s.charAt(i)]++;
            }else{
                i=arr[s.charAt(i)];
                arr[s.charAt(i)]=0;
                unique=1;
            }
            print(String.valueOf(i));
        }
        return res;*/
        return twoPointerWay(s);
    }

    int twoPointerWay(String s){
        int l=0,r=0,res=0;
        int[] a = new int[127];
        while(r<s.length()){
            if(a[s.charAt(r)]==0){
                a[s.charAt(r)]++;
                res=Math.max(res,r-l+1);
                r++;
            }else{
                while(l<r && a[s.charAt(r)]>0){
                    a[s.charAt(l)]--;
                    l++;
                } 
            }
        }
        return res;
    }

    void print(String s){
        System.out.println(s);
    }
}
