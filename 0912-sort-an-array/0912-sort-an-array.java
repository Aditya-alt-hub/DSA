class Solution {

    public int[] MergeArray(int[] left,int[] right)
    {
        int i=0;
        int j=0;
        int k=0;
        int[] mergedArray = new int[left.length+right.length];

        while(i<left.length && j<right.length)
        {
            if(left[i]<right[j])
            {
                mergedArray[k++]=left[i++];
            }
            else
            {
                mergedArray[k++]=right[j++];
            }
        }
        while(i<left.length)
        {
            mergedArray[k++]=left[i++];
        }
        while(j<right.length)
        {
            mergedArray[k++]=right[j++];
        }

        return mergedArray;
    }

    public int[] MergeSort(int[] nums,int start,int end)
    {
        if(start==end)
        {
            return new int[]{nums[start]};
        }

        int mid=start+(end-start)/2;
        int[] left = MergeSort(nums,start,mid);
        int[] right= MergeSort(nums,mid+1,end);

        return MergeArray(left,right);
    }

    public int[] sortArray(int[] nums) {
        return MergeSort(nums,0,nums.length-1);
    }
}