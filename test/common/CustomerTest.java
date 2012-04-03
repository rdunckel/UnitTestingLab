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
    
    public CustomerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Two customers are equal if they have the same phone number.
     */
    @Test
    public void twoObjectsAreEqualIfThePhoneNumberIsTheSame() {
        Customer c1 = new Customer("Customer1", "444-444-4444");
        Customer c2 = new Customer("Customer2", "444-444-4444");
        
        assertEquals(c1, c2);
        
    }
    
    @Test
    public void twoObjectsAreNotEqualIfThePhoneNumberIsDifferent() {
        Customer c1 = new Customer("Customer1", "444-444-4444");
        Customer c2 = new Customer("Customer2", "344-444-4444");
        
        assertNotSame(c1, c2);
        
    }
}
