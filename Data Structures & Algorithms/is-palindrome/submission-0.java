class Solution {
    public boolean isPalindrome(String s) {

        //return reverseString1(s);
        // return reverseString2(s);
        return twoPointer(s);
            
        
    }

    public boolean twoPointer(String s){
        for(int i=0,j=s.length()-1;i<j;){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            char low = Character.toLowerCase(s.charAt(i));
            char high = Character.toLowerCase(s.charAt(j));
            if(low != high) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean reverseString2(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean reverseString1(String s){
        StringBuilder sb = new StringBuilder();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
