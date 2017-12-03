#Pluralsight Intro to Java testing

## Writing good tests - Live coding
    - In the Cafe class brew() method will create a bad instance of the Coffee class. This will allow for testing
    when tests fail.
    
### Diagnostic messages

The 3 parameter assertEquals() allows for a message to be displayed when tests fail.

    assertEquals("Wrong coffee type", Espresso, coffee.getType());
    
### Do repeat Yourself
In CafeTest use the helper method cafeWithBeans() to set up the tests. This is better then repeating this code in
each test method.

### Remove magic numbers
Hard coded values replaced with constants.

## Before and After annotations
JUnit will run these blocks of code before each test (or all tests)

    	 @Before                 // Before each test method runs
    	 @After                  // After each test method runs
    	 @BeforeClass            // Before all tests in the class
    	 @AfterClass             // After all tests in the class
    	 
Before/After class should be annotating static methods.

Since a cafe will always be created before a test, its instantiation is being moved to the "before" annotated method.    	 
    	 