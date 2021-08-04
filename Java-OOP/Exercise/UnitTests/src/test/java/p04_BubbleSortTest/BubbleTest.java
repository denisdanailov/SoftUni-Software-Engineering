package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] numbers = { 3, 44, 38, 5, 47, 16};

        Bubble.sort(numbers);
        int[] expectedSortedArray = {3,5,16,38,44,47};

        Assert.assertEquals(numbers.length, expectedSortedArray.length);
        Assert.assertArrayEquals(numbers, expectedSortedArray);
    }
}
