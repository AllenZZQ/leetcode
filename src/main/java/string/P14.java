package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * find the longest common prefix string amongst an array of strings. 
 */
public class P14 {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String shortest = Collections.min(Arrays.asList(strs), Comparator.comparing(String::length));
		int len = shortest.length();
		while (len > 0) {
			if (hasCommonPrefix(strs, shortest, len)) {
				break;
			}
			len--;
		}
		return shortest.substring(0, len);

	}

	private boolean hasCommonPrefix(String[] strs, String shortest, int i) {
		String str = shortest.substring(0, i);
		for (String s : strs) {
			if (!s.startsWith(str)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] str = new String[] { "a" };
		new P14().longestCommonPrefix(str);
	}
}
