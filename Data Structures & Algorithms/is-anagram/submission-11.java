class Solution {
    public boolean isAnagram(String s, String t) {
        // return frequencyWay(s,t);
        // return sortingWay(s,t);
        return onlineWay(s,t);
    }

    public boolean onlineWay(String s, String t){
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        int nonZeroIndex=0;
        for(int i=0;i<s.length();i++){
            
            if(count[s.charAt(i)-'a'] == 0) nonZeroIndex++;
            count[s.charAt(i)-'a']++;
            if(count[s.charAt(i)-'a'] == 0) nonZeroIndex--;

            if(count[t.charAt(i)-'a'] == 0) nonZeroIndex++;
            count[t.charAt(i)-'a']--;
            if(count[t.charAt(i)-'a'] == 0) nonZeroIndex--;

        }
        
        return nonZeroIndex==0;
    }

    public boolean sortingWay(String s, String t){
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }

    public boolean frequencyWay(String s, String t){
        if(s.length() != t.length()) return false;
        char[] chArr = new char[26];
        for(int i=0;i<s.length();i++){
            chArr[s.charAt(i)-'a']++;
            chArr[t.charAt(i)-'a']--;
        }
        for(int i=0;i<chArr.length;i++){
            if(chArr[i]!=0) return false;
        }
        return true;
    }
}
