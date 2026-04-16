class Solution {
    public int longestConsecutive(int[] nums) {

         System.out.println("before sorting "+Arrays.toString(nums));

        int low=0,high = nums.length;
        nums = quickSort(nums,low,high);

        System.out.println("after sorting "+Arrays.toString(nums));

        int seqCount = nums.length >0 ? 1:0;
        int maxSeqCount = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1] == 1 ){
                seqCount++;
            }else if(nums[i] - nums[i-1]==0){
                continue;
            }else if(nums[i] - nums[i-1] != 1 || nums[i] - nums[i-1] !=0){
                maxSeqCount = maxSeqCount > seqCount ? maxSeqCount : seqCount;
                seqCount = 1;
            }
        }
        maxSeqCount = maxSeqCount > seqCount ? maxSeqCount : seqCount;
        System.out.println("longest consec seq "+maxSeqCount);

        //return maxSeqCount;

        Set<Integer> numSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            numSet.add(nums[i]);
        }
        int seqCount2 = nums.length >0 ? 1:0;
        int maxSeqCount2 = 0;
        for(int i : numSet){
            while(numSet.contains(i+1)){
                System.out.println("i "+i);
                seqCount2++;
                System.out.println("seqcount2 "+seqCount2);
                i++;
            }
            maxSeqCount2 = maxSeqCount2 > seqCount2 ? maxSeqCount2 : seqCount2;
            seqCount2 = 1;
        }
        //maxSeqCount2 = maxSeqCount2 > seqCount2 ? maxSeqCount2 : seqCount2;
        System.out.println("longest consec seq2 "+maxSeqCount2);

        return maxSeqCount2;
        
    }

    public static int[] quickSort(int[] a,int low,int high){
        // System.out.println("low "+low);
        // System.out.println("high "+high);

        if(high <= low){
            return a;
        }

        int wall=low;
        for(int i=low;i<high-1;i++){
            if(a[i] < a[high-1]){

                int temp = a[wall];
                a[wall] = a[i];
                a[i] =temp;
                wall++;
            }
        }
        int temp = a[high-1];
        a[high-1] = a[wall];
        a[wall] = temp;

        a = quickSort(a, low, wall);
        a = quickSort(a, wall+1, high);

        return a;
    }

}
