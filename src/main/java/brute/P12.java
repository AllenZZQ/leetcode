package brute;

import junit.framework.TestCase;
import util.NotSolved;
import util.Tuple;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
 * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
 * IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction
 * is used:
 *
 *     I can be placed before V (5) and X (10) to make 4 and 9.
 *     X can be placed before L (50) and C (100) to make 40 and 90.
 *     C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999
 */

@NotSolved
public class P12 extends TestCase {

    public String intToRoman(int num) {
        String result = "";
        int i = 0;
        while (num > 0) {
            int x = num % 10;
            num = num / 10;
            result = getRoman(x, getChararcter(i ++)) + result;
        }
        return result;
    }

    public Tuple.ThreeTuple<String, String, String> getChararcter(int i) {
        if (i == 0) {
            return Tuple.tuple("I", "V", "X");
        } else if (i == 1) {
            return Tuple.tuple("X", "L", "C");
        } else if (i == 2) {
            return Tuple.tuple("C", "D", "M");
        } else {
            return Tuple.tuple("M", "N", "V");
        }
    }

    public String getRoman(int x, Tuple.ThreeTuple<String, String, String> tuple) {
        String a = tuple.first;
        String b = tuple.second;
        String c = tuple.third;
        if (x == 0) {
            return "";
        }
        if (x <= 3) {
            return repeat(a, x);
        }
        if (x == 4) {
            return a + b;
        }
        if (x == 5) {
            return b;
        }
        if (x <= 8) {
            return b + repeat(a, x - 5);
        }
        if (x == 9) {
            return a + c;
        }
        return null;
    }

    public String repeat(String x, int num) {
        String result = x;
        for (int i = 2; i <= num; i ++) {
            result += x;
        }
        return result;
    }


    public void test() {
        System.out.println(intToRoman(58));
    }

}
