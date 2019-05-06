package assignment;

import org.junit.Assert;
import org.junit.Test;

public class MyTest {
    @Test
     public void shouldFindCommonText() {
        String first = "From fairest creatures we desire increase that thereby beauty rose might never die";
        String second = "Making a famine where abundance lies we desire increase to eat the world due, by the grave and thee";
        CommonText solution = new CommonText();
        String result = solution.find(first, second);
        Assert.assertEquals(result, "we desire increase");
     }
}
