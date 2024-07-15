package _20_Hotel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SolutionTest {
    
    /** Test method for {@link _20_Hotel.Solution } */
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
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 6, 8));
        int K = 1;
        boolean actual = solution.hotel(arrive, depart, K);
        assertTrue(!actual);
    }

    @Test
    public void Test2() {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 4, 8));
        int K = 1;
        boolean actual = solution.hotel(arrive, depart, K);
        assertTrue(actual);
    }

    @Test
    public void Test3() {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 3, 6));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 4, 8));
        int K = 2;
        boolean actual = solution.hotel(arrive, depart, K);
        assertTrue(actual);
    }

    @Test
    public void Test4() {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 3, 3, 6));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 4, 5, 8));
        int K = 2;
        boolean actual = solution.hotel(arrive, depart, K);
        assertTrue(actual);
    }

    @Test
    public void Test5() {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 3, 3, 6));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 4, 5, 8));
        int K = 6;
        boolean actual = solution.hotel(arrive, depart, K);
        assertTrue(actual);
    }

    @Test
    public void Test6() {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 3, 4));
        int K = 1;
        boolean actual = solution.hotel(arrive, depart, K);
        assertTrue(actual);
    }

}
