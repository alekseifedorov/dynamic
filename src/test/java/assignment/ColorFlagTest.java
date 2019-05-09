package assignment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorFlagTest {

    @Test
    public void color() {
        int result = new ColorFlag().color(
                new char[][]{
                        {'a', 'a', 'a', 'a'},
                        {'b', 'b', 'a', 'a'},
                        {'b', 'b', 'a', 'a'},
                        {'a', 'a', 'a', 'c'}
                });

        Assert.assertEquals(result, 3);
    }

    @Test
    public void color2() {
        int result = new ColorFlag().color(
                new char[][]{
                        {'a', 'a', 'a', 'a', 'a', 'b'},
                        {'b', 'b', 'a', 'a', 'a', 'b'},
                        {'b', 'b', 'a', 'a', 'a', 'c'},
                        {'a', 'a', 'a', 'c', 'a', 'c'}
                });

        Assert.assertEquals(5, result);
    }
}