class Solution {
    public int longestConsecutive(int[] nums) {

         System.out.println("before sorting "+Arrays.toString(nums));

        int low=0,high = nums.length;
        nums = quickSort(nums,low,high);

        //System.out.println("after sorting "+Arrays.toString(nums));

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
        //System.out.println("longest consec seq "+maxSeqCount);

        return maxSeqCount;
        
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
