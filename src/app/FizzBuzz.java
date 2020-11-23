package app;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String ERROR_MSG = "Number must be greater than 0";

    public String computeFizzBuzz(int number) throws IllegalArgumentException{
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_MSG);
        }

        boolean isThreeMultiple = number % 3 == 0;
        boolean isFiveMultiple = number % 5 == 0;

        if (isThreeMultiple && isFiveMultiple) {
            return FIZZ + BUZZ;
        } else if (isThreeMultiple) {
            return FIZZ;
        } else if (isFiveMultiple) {
            return BUZZ;
        } else {
            return String.valueOf(number);
        }
    }
}

