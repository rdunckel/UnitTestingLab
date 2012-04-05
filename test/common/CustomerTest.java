/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author rdunckel
 */
public class CustomerTest {

    private Customer instance;

    public CustomerTest() {
    }

    @Before
    public void setUp() {
        instance = new Customer();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * The state string being set should be two characters in length.
     */
    @Test
    public void stateShoulBeTwoChars() {
        String state = "MI";
        try {
            instance.setState(state);
        } catch(IllegalArgumentException iae) {
            fail("test failed due to iae");
        }

        int expResult = 2;
        int result = instance.getState().length();
        assertEquals(expResult, result);
    }

    /**
     * The state string being set should not be more than two characters in
     * length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void stateShouldNotBeMoreThanTwoChars() {
        String state = "Michigan";
        instance.setState(state);

    }

    /**
     * The state string being set should not be less than two characters in
     * length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void stateShouldNotBeLessThanTwoChars() {
        String state = "M";
        instance.setState(state);

    }

    /**
     * The state string should not accept null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void stateShouldNotBeNull() {
        String state = null;
        instance.setState(state);
    }

    /**
     * Two customers are equal if they have the same phone number.
     */
    @Test
    public void objectsAreEqualIfPhoneNumberIsSame() {
        Customer c1 = new Customer("Customer1", "444-444-4444");
        Customer c2 = new Customer("Customer2", "444-444-4444");

        assertEquals(c1, c2);

    }

    /**
     * Two customers are not equal if they have different phone numbers.
     */
    @Test
    public void objectsAreNotEqualIfPhoneNumberIsDifferent() {
        Customer c1 = new Customer("Customer1", "444-444-4444");
        Customer c2 = new Customer("Customer2", "344-444-4444");

        assertFalse(c1.equals(c2));

    }
}
