import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstringAL {
	/**
	 * 用set存储，可以删除相应字符
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		if( s == null){
			return 0;
		}
		if(s.length() < 2){
			return s.length();
		}
		//借助set存储无重复的字符
		HashSet<Character> hashSet = new HashSet<>();
		int len = s.length();
		int beginIndex = 0;
		int ret = 0;
		boolean firstContain = true;
		for (int i=0;i<len;i++){
			while (hashSet.contains(s.charAt(i))){
				//包含重复字符
				if(firstContain) {
					ret = Math.max(ret,i-beginIndex);
					firstContain = false;
				}
				hashSet.remove(s.charAt(beginIndex));
				beginIndex++;
			}
			firstContain = true;
			hashSet.add(s.charAt(i));
		}
		ret = Math.max(ret,len-beginIndex);
		return ret;
	}
	/**
	 *
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s) {
		if( s == null){
			return 0;
		}
		if(s.length() < 2){
			return s.length();
		}
		//借助hashmap存储无重复的字符
		HashMap<Character,String> hashMap = new HashMap<>();
		int ret = 0;
		char[] chars = s.toCharArray();
		int beginIndex = 0;
		for (int i=0;i<chars.length;i++){
			if (hashMap.containsKey(chars[i])){
				//遇到重复字符串了
				int length = i-beginIndex;
				ret = Math.max(ret, length);
				String value = hashMap.get(chars[i]);
				int lastCharIndex = Integer.valueOf(value.substring(value.lastIndexOf("#")+1,value.length()));
				beginIndex = Math.max(beginIndex,lastCharIndex+1);
				String indexValue = "#"+i;
				hashMap.put(chars[i],value+indexValue);
			}else{
				String value = "#"+i;
				hashMap.put(chars[i],value);
			}
		}
		//循环退出后，获取最终的值
		int length = chars.length-beginIndex;
		ret = Math.max(ret, length);
		return ret;
	}
}
