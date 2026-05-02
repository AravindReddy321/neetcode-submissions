class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return String.valueOf(sb);
    }

    public List<String> decode(String str) {
        List<String> l = new ArrayList<String>();
        char[] ch= str.toCharArray();
        int prevStart =0;
        for(int i=prevStart;i<ch.length;i++){
            if(ch[i]=='#'){
                int len = Integer.valueOf(str.substring(prevStart,i));
                // System.o
                l.add(str.substring(i+1,i+1+len));
                prevStart=i+1+len;
                i=prevStart;
            }
        }
        return l;
    }
}
