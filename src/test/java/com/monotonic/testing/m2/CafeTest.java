package com.monotonic.testing.m2;

import org.junit.Test;

import static com.monotonic.testing.m2.CoffeeType.Espresso;
import static com.monotonic.testing.m2.CoffeeType.Latte;
import static org.junit.Assert.assertEquals;

public class CafeTest {

    //use constants to increase readability
    public static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    @Test
    public void canBrewEspresso() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        Coffee coffee = cafe.brew(Espresso);

        // then
        //the first parameter is a diagnostic used when a test fails
        assertEquals("Wrong amount of beans", ESPRESSO_BEANS, coffee.getBeans());
        assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
        assertEquals("Wrong coffee type", Espresso, coffee.getType());
    }



    @Test
    public void brewingEspressoConsumesBeans() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        cafe.brew(Espresso);

        // then
        assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        // given
        Cafe cafe = cafeWithBeans();

        //this is a latte with the required amount of milk. Dont hard code the value
//        cafe.restockMilk(227);
        cafe.restockMilk(Latte.getRequiredMilk());

        // when
        Coffee coffee = cafe.brew(Latte);

        // then
//        assertEquals(Latte, coffee.getType());

        // a better version of the above will have a diagnostic message.
        assertEquals("Wrong coffee type.", Latte, coffee.getType());

    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk() {
        // given
        Cafe cafe = new Cafe();

        // when
        //dont use hard coded value. harder to read.
//        cafe.restockMilk(0);
        cafe.restockMilk(NO_MILK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans() {
        // given
        Cafe cafe = new Cafe();

        // when
        //dont use hard coded value. harder to read.
        cafe.restockBeans(0);
        cafe.restockBeans(NO_BEANS);
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequireMilk() {
        // given
        Cafe cafe = cafeWithBeans();

        // when
        cafe.brew(Latte);
    }

    //the contents of this method were previously in 3 of thr above test methods.
    // using a method extractor refactor IntelliJ can detect other occurrences of the below code block and
    // convert them to the below method call.
    private Cafe cafeWithBeans() {
        Cafe cafe = new Cafe();
        //dont use magic numbers
//        cafe.restockBeans(7);
        cafe.restockBeans(ESPRESSO_BEANS);
        return cafe;
    }

}
