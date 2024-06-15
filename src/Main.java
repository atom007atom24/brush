import java.util.*;

public class Main {
    public static void main(String[] args) {
        int []nums = new int[]{1,2,3,7,9};
        int target=9;
        int []ret = TwoSumAL.twoSum(nums,target);
        System.out.println(ret[0]+","+ret[1]);
        /*String []str = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        List<List<String>> retList = groupAnagrams(str);
            System.out.println(String.valueOf(retList));*/

    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> numHashMap = new HashMap<Integer, List<Integer>>();
        for (int i=0; i<nums.length;i++){
            List<Integer> indexList = new ArrayList<>();
            if( !numHashMap.containsKey(nums[i])){
                indexList.add(i);
            }else{
                indexList = numHashMap.get(nums[i]);
                indexList.add(i);
            }
            numHashMap.put(nums[i],indexList);
        }
        for(int j : numHashMap.keySet()){
            if(j >= target){
                continue;
            }
            int k = target-j;
            if(numHashMap.containsKey(k)){
                if(j != k) {
                    return new int[]{numHashMap.get(j).get(0), numHashMap.get(k).get(0)};
                }else{
                    if(numHashMap.get(j).size()>1){
                        return new int[]{numHashMap.get(j).get(0),numHashMap.get(j).get(1)};
                    }
                }
            }
        }
        return new int[2];
    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     * @param strs
     * @return
     */
    /*public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i=0; i < strs.length; i++) {
            String orderedStr = str2Int(strs[i]);
            if(hashMap.containsKey(orderedStr)){
                int index= hashMap.get(orderedStr);
                List<String> strList = ret.get(index);
                strList.add(strs[i]);
            }else{
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                ret.add(strList);
                hashMap.put(orderedStr,ret.size()-1);
            }
        }
        return ret;
    }*/
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        for (int i=0; i < strs.length; i++) {
            boolean flag = true;
            String tmp = strs[i];
            for(List<String> strList : ret){
                String str = strList.get(0);
                if(str.length() != tmp.length()){
                    continue;
                }else{
                    if (isAnagrams(str,tmp)){
                        strList.add(tmp);
                        flag=false;
                        break;
                    }
                }
            }
            if(flag) {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(tmp);
                ret.add(tmpList);
            }
        }
        return ret;

    }

    /**
     * 判断是否是异位词
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isAnagrams(String str1, String str2){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            int value1 = 1;
            if (hashMap.containsKey(str1.charAt(i))) {
                value1 = hashMap.get(str1.charAt(i))+1;
            }
            hashMap.put(str1.charAt(i),value1);
            int value2 = -1;
            if (hashMap.containsKey(str2.charAt(i))) {
                value2 = hashMap.get(str2.charAt(i))-1;
            }
            hashMap.put(str2.charAt(i),value2);
        }
        for(int value: hashMap.values()){
            if(value != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 将str转换为26个数字的字符串，按照从大到小排序。如果a出现1次，那么第1位为1，如果b出现2次，那么第2位为2
     * @param str
     * @return
     */
    public static int[] str2Int (String str){
        int []result = new int[26];
        int len = str.length();
        for (int i=0;i<len;i++){
            int j = str.charAt(i) - 'a';
            result[j]++;
        }
        return result;
    }

}