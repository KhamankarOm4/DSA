class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i =0;i<nums.length && nums[i]<=0;i++){

            if(i==0 || nums[i]!=nums[i-1]){
                tsum(i,nums,result);
            }

        }
        return result;
    }

    public void tsum(int i,int[] nums,List<List<Integer>> result){
        int left = i+1;
        int right = nums.length-1;

        while(left<right){
                int sum = nums[i]+nums[right]+nums[left];

            if(sum<0){
                left=left+1;
            }else if(sum>0){
                right=right-1;
            }else{
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                 left++;
                right--;
             while (left < right && nums[left] == nums[left - 1]) left++;
            while (left < right && nums[right] == nums[right + 1]) right--;
            }

           
        }
    }
}