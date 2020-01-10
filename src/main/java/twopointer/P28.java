package twopointer;

public class P28 {

    public int strStr(String haystack, String needle) {
        int length = needle.length();
        for (int i = 0; i + length <= haystack.length(); i ++) {
            if (haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }


}
