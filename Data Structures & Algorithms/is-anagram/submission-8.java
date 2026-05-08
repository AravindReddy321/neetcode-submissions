class Solution {
    public boolean isAnagram(String s, String t) {
        return frequencyWay(s,t);
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
