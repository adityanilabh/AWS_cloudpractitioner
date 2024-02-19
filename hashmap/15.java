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
