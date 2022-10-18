package test;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import src.Sum;
import sol.SumSol;

public class SumTest {

  // fixed test
  @Test
  public void testEmptyArray() throws Exception {
    assertEquals("Empty arrays should have a max of 0", 0, Sum.maxSubsequence(new int[]{}));
  }
  @Test
  public void testExampleArray() throws Exception {
    assertEquals("Example array should have a max of 6", 6, Sum.maxSubsequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
  @Test
  public void testNegativeExampleArray() throws Exception {
    assertEquals("Example array with all negative values should have a max of 0", 0, Sum.maxSubsequence(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
  }  
  @Test
  public void testCompleteArray() throws Exception {
    assertEquals("Should work on this too", 155, Sum.maxSubsequence(new int[]{7, 4, 11, -11, 39, 36, 10, -6, 37, -10, -32, 44, -26, -34, 43, 43}));
  }
  
  // random test
  @Test
  public void testRandomArrays() throws Exception {
    for(int i = 0; i < 50; i++) {
      int[] rand = SumSol.randArr((int)(Math.random() * 10 + 50));
      assertEquals("Random array solution not as expected: ", SumSol.maxSubsequence(rand), Sum.maxSubsequence(rand));
    }
  }
  
}