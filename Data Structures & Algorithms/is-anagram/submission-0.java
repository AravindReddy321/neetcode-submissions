class Solution {
    public boolean isAnagram(String s, String t) {
        // String s = "racecare";
        // String t = "carracee";

        if(s.length() != t.length()){
            System.out.println("not anagram"); 
            return false;
        }

        char[] sCharArray = s.toLowerCase().toCharArray();
        char[] tCharArray = t.toLowerCase().toCharArray();
        char sMinChar = sCharArray[0];
        char sMaxChar = sCharArray[0];
        char tMinChar = tCharArray[0];
        char tMaxChar = tCharArray[0];
        for(int i=0;i<sCharArray.length;i++){
            sMinChar = sMinChar < sCharArray[i] ? sMinChar : sCharArray[i];
            sMaxChar = sMaxChar > sCharArray[i] ? sMaxChar : sCharArray[i];
            tMinChar = tMinChar < tCharArray[i] ? tMinChar : tCharArray[i];
            tMaxChar = tMaxChar > tCharArray[i] ? tMaxChar : tCharArray[i];
        }
        if(sMaxChar != tMaxChar || sMinChar != tMinChar){
            System.out.println("not anagram");
            return false;
        }
        int sSize = sMaxChar - sMinChar+1;
        int[] sBucketArray = new int[sSize];
        int[] tBucketArray = new int[sSize];
        for(int i=0;i<sCharArray.length;i++){
            sBucketArray[sCharArray[i]-sMinChar] = sBucketArray[sCharArray[i]-sMinChar]+1;
            tBucketArray[tCharArray[i]-tMinChar] = ++tBucketArray[tCharArray[i]-tMinChar];
        }
        System.out.println("sBucketArray "+Arrays.toString(sBucketArray));
        System.out.println("tBucketArray "+Arrays.toString(tBucketArray));
        boolean isAnagaram = false;
        for(int i=0;i<sSize;i++){
            if(sBucketArray[i]!=tBucketArray[i]){
                break;
            }
            if(i==sSize-1){
                isAnagaram = true;
            }
        }
        System.out.println("isAnagaram :"+isAnagaram);
        return isAnagaram;
    }
}
