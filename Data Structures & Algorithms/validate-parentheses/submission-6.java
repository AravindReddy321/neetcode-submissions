class Solution {
    public boolean isValid(String s) {
        // Stack<Character> st = new Stack<>();
        // Map<Character, Character> m = new HashMap<>();
        // m.put(')','(');
        // m.put('}','{');
        // m.put(']','[');
        // if(s.isEmpty()) return false;
        // for(int i=0;i<s.length();i++){
        //     if(!st.isEmpty() && m.containsKey(s.charAt(i))){
        //         if( st.pop() != m.get(s.charAt(i))) return false;
        //     }else{
        //         st.push(s.charAt(i));
        //     }
        // }
        // return st.isEmpty();
        return stackWay(s);
    }

    public boolean stackWay(String s){
        Map<Character,Character> m = new HashMap<>();
        m.put(')','(');
        m.put(']','[');
        m.put('}','{');
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && m.containsKey(c)){
                if(m.get(c) != st.pop()) return false;
            }else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
