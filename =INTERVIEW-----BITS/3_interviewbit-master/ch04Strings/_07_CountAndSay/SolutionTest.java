package _07_CountAndSay;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SolutionTest {

    /** Test method for {@link _07_CountAndSay.Solution } */
    Solution solution;

    @Rule
    public Timeout globalTimeout = new Timeout(20);

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void Test1() {
        String actual = solution.countAndSay(1);
        String expected = "1";
        assertEquals(expected, actual);
    }

    @Test
    public void Test2() {
        String actual = solution.countAndSay(2);
        String expected = "11";
        assertEquals(expected, actual);
    }

    @Test
    public void Test3() {
        String actual = solution.countAndSay(3);
        String expected = "21";
        assertEquals(expected, actual);
    }

    @Test
    public void Test4() {
        String actual = solution.countAndSay(4);
        String expected = "1211";
        assertEquals(expected, actual);
    }

    @Test
    public void Test5() {
        String actual = solution.countAndSay(5);
        String expected = "111221";
        assertEquals(expected, actual);
    }

}
