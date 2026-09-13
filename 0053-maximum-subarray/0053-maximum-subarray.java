class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            currentSum+=nums[i];
            maxSum=Math.max(currentSum,maxSum);

            if(currentSum<0)
            {
                currentSum=0;
            }

        }

        return maxSum;
    }
}