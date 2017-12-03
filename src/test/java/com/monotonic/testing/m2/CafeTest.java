package com.monotonic.testing.m2;

import org.junit.*;

import static com.monotonic.testing.m2.CoffeeType.Espresso;
import static com.monotonic.testing.m2.CoffeeType.Latte;
import static org.junit.Assert.assertEquals;

public class CafeTest {

    //use constants to increase readability
    public static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    private Cafe cafe;

    //region junit helper methods

    /*
     * These methods are invoked before all/individual junit test(s).
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Before
    public void before() {
        System.out.println("before");

        //we will always need to instantiate a cafe fore a test.
        cafe = new Cafe();
    }

    @After
    public void after() {
        System.out.println("after");
    }
    //endregion


    @Test
    public void canBrewEspresso() {
        // given
//        Cafe cafe = cafeWithBeans();
        withBeans();

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
//        Cafe cafe = cafeWithBeans();
        withBeans();

        // when
        cafe.brew(Espresso);

        // then
        assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        // given
//        Cafe cafe = cafeWithBeans();
        withBeans();

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
        withBeans();

        // when
        cafe.brew(Latte);
    }

    //the contents of this method were previously in 3 of thr above test methods.
    // using a method extractor refactor IntelliJ can detect other occurrences of the below code block and
    // convert them to the below method call.
    // Since cafe will be created in before method, this will be refactored to "withBeans()"
//    private Cafe cafeWithBeans() {
//        Cafe cafe = new Cafe();
//        //dont use magic numbers
////        cafe.restockBeans(7);
//        cafe.restockBeans(ESPRESSO_BEANS);
//        return cafe;
//    }

    private void withBeans() {

        //is this code really necessary? Maybe not. JUnit will always create cafe in the annotated
        //before method. Since this class is only to be used with JUnit it should be fine.
        if (cafe == null) {
            System.out.print("Cafe shouldnt be null, use before");
            return;
        }

        cafe.restockBeans(ESPRESSO_BEANS);
    }

}
