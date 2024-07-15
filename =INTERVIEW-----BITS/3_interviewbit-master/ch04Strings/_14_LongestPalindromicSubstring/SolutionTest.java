package _14_LongestPalindromicSubstring;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SolutionTest {
    
    /** Test method for {@link _14_LongestPalindromicSubstring.Solution } */
    Solution solution;

    @Rule
    public Timeout globalTimeout = new Timeout(200);

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
        String s = "abb";
        String actual = solution.longestPalindrome(s);
        String expected = "bb";
        assertEquals(expected, actual);
    }

    @Test
    public void Test2() {
        String s = "abdbbbbdba";
        String actual = solution.longestPalindrome(s);
        String expected = "abdbbbbdba";
        assertEquals(expected, actual);
    }

    @Test
    public void Test3() {
        String s = "abdbabbdba";
        String actual = solution.longestPalindrome(s);
        String expected = "abdba";
        assertEquals(expected, actual);
    }

}
