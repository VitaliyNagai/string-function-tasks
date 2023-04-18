package io.github.vitaliynagai.string.function.tasks;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.github.vitaliynagai.string.function.tasks.StringFunctions.printIndexOfTheSameSymbolsInStringArray;

public class StringFunctionsTest {
    @Test
    public void checkRegularArrayOfStrings() {
        String[] arrayOfStrings = {"qwe", "wqe", "qwee", "a", "a"};

        String finalResultString = printIndexOfTheSameSymbolsInStringArray(arrayOfStrings);
        Assert.assertEquals(finalResultString, "a = 3; 4; eqw = 0; 1; ");
    }

    @Test
    public void checkTheSameElementsInArrayOfStrings() {
        String[] arrayOfStrings = {"qwe", "wqe", "eqw"};

        String finalResultString = printIndexOfTheSameSymbolsInStringArray(arrayOfStrings);
        Assert.assertEquals(finalResultString, "eqw = 0; 1; 2; ");
    }
}