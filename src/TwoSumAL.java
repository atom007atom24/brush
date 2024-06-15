import java.util.HashMap;

public class TwoSumAL {
    /**
     int []nums = new int[]{1,2,3,7,9};
     int target=9;
     int []ret = TwoSumAL.twoSum(nums,target);
     System.out.println(ret[0]+","+ret[1]);
     */
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //跟之前的比较，一是只需遍历一次就完成了比对，二是防止找到的值就是本身的值
            int tmp = target - nums[i];
            if (hashMap.containsKey(tmp)) {
                return new int[]{hashMap.get(tmp), i};
            } else {
                hashMap.put(nums[i], i);
            }

        }
        return new int[]{-1, -1};
    }
}
