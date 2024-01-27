class 1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        HashMap<Integer,Integer>IndexOfNumber= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
           int number1=nums[i];
           int number2=target-number1;
           if(IndexOfNumber.containsKey(number2))
           {
               result[0]=IndexOfNumber.get(number2);
               result[1]=i;
               return result;
           }
           IndexOfNumber.put(number1,i);

        }
        return result;
    }
}