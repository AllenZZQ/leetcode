import junit.framework.TestCase;

import java.math.BigDecimal;

public class Test extends TestCase {

    public void test_01() {
        double d = 10000000.0;
        System.out.println(d);
        BigDecimal b = BigDecimal.valueOf(10000000.0);
        System.out.println(b.stripTrailingZeros().toPlainString());
        System.out.println(b.toString());

    }
}
