package test;

import app.FizzBuzz;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FizzBuzzTest {
    private static FizzBuzz fizzBuzz;
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final Integer[] multipleThreeList = new Integer[]{3, 6, 9, 12};
    private static final Integer[] multipleFiveList = new Integer[]{5, 10, 20};
    private static final Integer[] multipleBothList = new Integer[]{15, 30, 60};
    private static final Integer[] randomNumbers = new Integer[]{1, 4, 8, 13};
    private static final int NEGATIVE_NUMBER = -20;
    private static final String expectedErrorMSG = "Number must be greater than 0";

    @BeforeClass
    public static void globalSetup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testMultipleThree() {
        for (Integer number : multipleThreeList) {
            Assert.assertEquals(FIZZ, fizzBuzz.computeFizzBuzz(number));
        }
    }

    @Test
    public void testMultipleFive() {
        for (Integer number : multipleFiveList) {
            Assert.assertEquals(BUZZ, fizzBuzz.computeFizzBuzz(number));
        }
    }

    @Test
    public void testMultipleThreeAndFive() {
        for (Integer number : multipleBothList) {
            Assert.assertEquals((FIZZ + BUZZ), fizzBuzz.computeFizzBuzz(number));
        }
    }

    @Test
    public void testRandom() {
        for (Integer number : randomNumbers) {
            Assert.assertEquals(String.valueOf(number), fizzBuzz.computeFizzBuzz(number));
        }
    }

    @Test
    public void testThrowException() {
        Exception ex = new Exception();

        try {
            fizzBuzz.computeFizzBuzz(NEGATIVE_NUMBER);
        } catch (Exception e) {
            ex = e;
        }
        String realErrorMsg = ex.getMessage();

        Assert.assertEquals(IllegalArgumentException.class, ex.getClass());
        Assert.assertEquals(expectedErrorMSG, realErrorMsg);
    }
}
