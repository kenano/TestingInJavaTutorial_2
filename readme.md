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