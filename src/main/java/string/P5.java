package string;


import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

/**
 *  Given a string s, find the longest palindromic substring in s. 
 *  You may assume that the maximum length of s is 1000.
 *  
 *  Example- input:"babcd" output: "bab"
 */
public class P5 extends TestCase {
	
	public String solution(String s) {
		// 只取index，中间避免subString操作，可减少所需时间
		int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
    }
	
	private int expandAroundCenter(String s, int left, int right) {
	    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	        left--;
	        right++;
	    }
	    return right - left - 1;
	}


	// region test
	public void test() {
		String str = "babcd";
		Assertions.assertThat(new P5().solution(str)).isEqualTo("bab");
	}
	// endregion
}
