import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // store result in set.
        Arrays.sort(nums);
        Set<List<Integer>>resultHai= new HashSet<>();
        for(int i=0;i<nums.length-2;i++)
        {
            int numberOne= 0-nums[i];
            Set<Integer> sethai= new HashSet<>();
            for(int j=i+1;j<nums.length;j++)
            {
                int numberTwo= numberOne-nums[j];
                if(sethai.contains(numberTwo))
                {
                    List<Integer>listHai= Arrays.asList(nums[i],nums[j],numberTwo);
                    resultHai.add(listHai);
                }
                sethai.add(nums[j]);
            }
        }
       return new ArrayList<>(resultHai);

    }
}

/* using two pointer concept :
 * 
 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // solving using 2 pointer concept.
        // first sort the nums array:
        Arrays.sort(nums);
        List<List<Integer>>resultHai= new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            // suppose we have [1,1,2,4], here 1 and 1 will yeild same
            // result, so we only consider 1st 1, skip 2nd 1.
            //example: 1,2,4 for 1st and 1,2,4 for second 1 is same
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int l=i+1;
            int r= nums.length-1;
            while(l<r)
            {
                int result= nums[i]+nums[l]+nums[r];
                if(result==0)
                {
                   resultHai.add(Arrays.asList(nums[i],nums[l++],nums[r--]));
                   while (l < r && nums[l] == nums[l - 1])
            ++l;
          while (l < r && nums[r] == nums[r + 1])
            --r;
                }
                else if(result<0)
                {
                    l++;
                }
                else{
                   r--;
                }
            }
        }
        return resultHai;
    }
}
 */