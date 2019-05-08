package assignment;

import org.junit.Assert;
import org.junit.Test;

public class KnapSackTest {
    @Test
    public void shouldKnapsak() {
        int result = new Knapsack().solve(new int[]{2, 5, 1, 9}, new int[]{5, 7, 3, 9}, 14);
        Assert.assertEquals(result, 11);
    }
}