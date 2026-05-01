class Solution {
    public boolean isAnagram(String s, String t) {
        String[] strs = {s,t};
        Map<String,List<String>> m = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s1 = Arrays.toString(ch);
            System.out.println(s1);
            if(!m.containsKey(s1)){
                m.put(s1,new ArrayList<>());
            }
            m.get(s1).add(str);
        }
        for(Map.Entry<String,List<String>> e : m.entrySet()){
            return e.getValue().size() == 2;
        }
        return false;
    }
}
