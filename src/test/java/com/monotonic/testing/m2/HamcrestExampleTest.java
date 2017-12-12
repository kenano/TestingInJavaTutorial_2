package com.monotonic.testing.m2;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HamcrestExampleTest {

    @Test
    public void mapShouldContainValue()
    {
        Map<String, Integer> values = getValues();
        Assert.assertThat(values, Matchers.hasKey("B"));

        //this shows what happens when a test fails. The diagnostic message shown is more descriptive.
//        Assert.assertThat(values, Matchers.hasKey("C"));
    }


    private Map<String, Integer> getValues() {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        return map;
    }


    @Test
    public void listOrderingIsIrrelevant()
    {
        List<Integer> numbers = getNumbers();

        Assert.assertThat(numbers, Matchers.hasItem(5));
    }

    private List<Integer> getNumbers() {
        return Arrays.asList(1, 2, 3, 5, 4);
    }
}
