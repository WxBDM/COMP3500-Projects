import org.junit.*;

import static org.junit.Assert.assertEquals;
public class FinderTest {

    @Test
    public void test_ifEmpty() {
        System.out.print("Testing if it's empty;");
        Finder find = new Finder();
        int[] expected = {};
        int[] actual = find.getArray();
        Assert.assertNotSame(expected, actual);
        System.out.println(" test_ifEmpty passed.");
    }

    @Test
    public void test_ifNull() {
        System.out.print("Testing if null;");
        Finder find = new Finder();
        int[] actual = find.getArray();
        Assert.assertNotNull(actual);
        System.out.println(" test_ifNull passed.");
    }
}
