class Solution {

    public String encode(List<String> strs) {
        if(strs == null) return null;
        StringBuilder sb = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for(String str : strs){
            sizes.add(str.length());
        }
        for(int size : sizes){
            sb.append(size).append(",");
        }
        sb.append("#");
        for(String str : strs){
            sb.append(str);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        if(str == null) return null;
        if(str.length()==0) return new ArrayList<>();
        System.out.println(str.length()+" "+str);
        int index =0;
        List<Integer> sizeList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        while(str.charAt(index) != '#'){
            StringBuilder sb = new StringBuilder();
            while(str.charAt(index) != ','){
                sb.append(str.charAt(index));
                index++;
            }
            sizeList.add(Integer.parseInt(sb.toString()));
            index++;
        }
        index++;
        int i=0;
        while(i < sizeList.size()){
            int currSize = sizeList.get(i);
            strList.add(str.substring(index, (index+currSize)));
            index += currSize;
            i++;
        }

        return strList;
        

    }
}