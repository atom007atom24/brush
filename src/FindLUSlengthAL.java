import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class FindLUSlengthAL {
	/**
	 *
	 * @param strs
	 * @return
	 */

	public int findLUSlength(String[] strs) {
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
		int len = strs.length;
		int ret = -1;
		for( int i=0;i<len;i++){
			boolean flag = true;
			for(int j = 0;j<len;j++) {
				if(i == j){
					continue;
				}
				if (isSubScequence(strs[i], strs[j])) {
					flag = false;
					break;
				}
			}
			if(flag){
				ret = Math.max(ret,strs[i].length());
			}
		}
		return ret;
	}

	/**
	 * a是否是b的子序列
	 * @param a
	 * @param b
	 * @return 是返回true,不是返回false
	 */
	public boolean isSubScequence(String a,String b){
		if(a.length()>b.length()){
			return false;
		}
		int i=0,j=0;
		//只需要a的每一位字符出现顺序与b中一致，即可
		while (i<a.length() && j<b.length()){
			while( j<b.length() && a.charAt(i) != b.charAt(j) ){
				j++;
			}
			if(j <b.length()) {
				i++;
				j++;
			}
		}
		if(i != a.length() ){
			return false;
		}
		return true;
	}
}
