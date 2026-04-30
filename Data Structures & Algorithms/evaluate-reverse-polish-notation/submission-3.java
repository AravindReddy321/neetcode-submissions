class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s1 = new Stack<>();
        int i=0;
        for(String s : tokens){
            if(s.equals("*")) {   s1.push(s1.pop() * s1.pop()); }
            else if(s.equals("/") ) {   int x= s1.pop(); s1.push(  s1.pop()/x); }
            else if(s.equals("+")) {   s1.push(s1.pop() + s1.pop()); }
            else if(s.equals("-") ) {   int x= s1.pop(); s1.push( s1.pop()-x); }
            else s1.push(Integer.valueOf(s));
        }
        return s1.peek();

    }
}
