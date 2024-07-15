package _02_SpiralMatrix;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SolutionTest {

    /** Test method for {@link _02_SpiralMatrix.Solution } */
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
        List<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        ArrayList<Integer> actual = solution.spiralOrder(A);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 6,
                9, 8, 7, 4, 5));
        assertEquals(expected, actual);
    }

    @Test
    public void Test2() {
        List<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        A.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        ArrayList<Integer> actual = solution.spiralOrder(A);
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 8, 7, 6, 5));
        assertEquals(expected, actual);
    }

    @Test
    public void Test3() {
        List<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1)));
        A.add(new ArrayList<>(Arrays.asList(2)));
        A.add(new ArrayList<>(Arrays.asList(3)));
        ArrayList<Integer> actual = solution.spiralOrder(A);
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 2, 3));
        assertEquals(expected, actual);
    }

    @Test
    public void Test4() {
        List<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 2)));
        A.add(new ArrayList<>(Arrays.asList(3, 4)));
        A.add(new ArrayList<>(Arrays.asList(5, 6)));
        ArrayList<Integer> actual = solution.spiralOrder(A);
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 2, 4, 6, 5, 3));
        assertEquals(expected, actual);
    }

}
