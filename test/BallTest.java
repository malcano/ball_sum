package test;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;
import src.Ball;
import sol.BallSol;

public class BallTest {

    // fixed test
    @Test
    public void fixedTest0() {
        assertEquals(1, Ball.bounceBall(2.0, 0.5, 1.0));
    }

    @Test
    public void fixedTest1() {
        assertEquals(3, Ball.bounceBall(3.0, 0.66, 1.5));
    }

    @Test
    public void fixedTest2() {
        assertEquals(15, Ball.bounceBall(30.0, 0.66, 1.5));
    }

    @Test
    public void fixedTest3() {
        assertEquals(21, Ball.bounceBall(30, 0.75, 1.5));
    }

    @Test
    public void fixedTest4() {
        assertEquals(3, Ball.bounceBall(30, 0.4, 10));
    }

    @Test
    public void fixedTest5() {
        assertEquals(3, Ball.bounceBall(40, 0.4, 10));
    }

    @Test
    public void fixedTest6() {
        assertEquals(-1, Ball.bounceBall(10, 0.6, 10));
    }

    @Test
    public void fixedTest7() {
        assertEquals(-1, Ball.bounceBall(40, 1, 10));
    }

    @Test
    public void fixedTest8() {
        assertEquals(-1, Ball.bounceBall(-5, 0.66, 1.5));
    }

    @Test
    public void fixedTest9() {
        assertEquals(-1, Ball.bounceBall(5, -1, 1.5));
    }

    // random test
    @Test
    public void randomTest() {
        Random rnd = new Random();
        double[] someheights = new double[] { 12, 10.5, 144, 233, 15.25, 61, 98, 15.9, 25.8, 41.8, 67,
                109, 17, 28, 46, 7.5, 12.20, 19, 3, 5,
                83, 13, 21, 35.5, 57, 92, 14,
                24, 39, 6.5 };
        double[] someBounces = new double[] { 0.6, 0.6, 0.6, 0.6, 0.6, 1.1, 9, 1, 0.6, 0.6, 0.6,
                0.75, 0.75, 0.75, 0.75, 0.75, 12.20, 0.75, 0.75,
                0.83, 0.13, 0.21, 0.35, 0.57, 0.9, 0.14,
                0.24, 0.39, 0.65, 0.65 };
        double[] somewin = new double[] { 1.5, 1.5, 1.44, 2.33, 1, 6.1, 9.8, 1.9, 2.8, 4.8, 3,
                1.09, 1.7, 2.8, 46, 7.5, 12.20, 1.9, 3, 5,
                0.83, 1.3, 2.1, 3.5, 0.57, 0.92, 1.4,
                2.4, 3.9, 6.5 };

        for (int k = 0; k < 10; k++) {
            int rn = rnd.nextInt(29);
            double f1 = someheights[rn];
            double f2 = someBounces[rn];
            double f3 = somewin[rn];

            System.out.println("Random test " + k);
            assertEquals(BallSol.bounceBall(f1, f2, f3), Ball.bounceBall(f1, f2, f3));
        }
    }
}