import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsAL {

    /*
        GroupAnagramsAL groupAnagramsAL = new GroupAnagramsAL();
        String []str = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        List<List<String>> retList = groupAnagramsAL.groupAnagrams(str);
        System.out.println(String.valueOf(retList));
     */

    /**
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for (int i=0; i < strs.length; i++) {
            char []chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if(hashMap.containsKey(str)){
                List<String> strList = hashMap.get(str);
                strList.add(strs[i]);
            }else{
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                hashMap.put(str,strList);
            }
        }
        return new ArrayList<>(hashMap.values());
    }
    /**
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for (int i=0; i < strs.length; i++) {
            String intStr = str2int(strs[i]);
            if(hashMap.containsKey(intStr)){
                List<String> strList = hashMap.get(intStr);
                strList.add(strs[i]);
            }else{
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                hashMap.put(intStr,strList);
                ret.add(strList);
            }
        }
        return ret;
    }

    /**
     * 将字符串的各个字母用数字数组表示，第一位表示a出现的次数，第二位表示b出现的次数
     * @param str
     * @return
     */
    public String str2int(String str){
        int []result = new int[26];
        int len = str.length();
        for (int i = 0; i < len; i++){
            int tmp = str.charAt(i) - 'a';
            result[tmp]++;
        }
        StringBuilder resultSB = new StringBuilder("");
        for (int i = 0;i <26;i++){
            resultSB.append(result[i]);
            resultSB.append("#");
        }
        return resultSB.toString();
    }

}
