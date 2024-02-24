import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // the idea is to create a hashset and store elements
        HashSet<Integer>set= new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        // now count the number:
        // here one algorithm to node: 
        /* the following loop can also be used in other hashing based algorithn.
        */
        int longestIncreasing=0;
        for(int num: nums)
        {
            if(!set.contains(num-1))
            {
                int currentlongest=1;
                int number=num;
                while(set.contains(number+1))
                {
                    number++;
                    currentlongest++;
                }
                longestIncreasing= Math.max(currentlongest,longestIncreasing);

            }
        }
      return longestIncreasing;
    }
}