package e.exercise;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PrimalityTestTest {
    @Test
    public void whenSomeKnownSamples() {
        PrimalityTest test = new PrimalityTest();
        assertTrue(test.isPrime(2));
        assertTrue(test.isPrime(3));
        assertFalse(test.isPrime(4));
        assertTrue(test.isPrime(5));
        assertFalse(test.isPrime(6));
        assertTrue(test.isPrime(7));
        assertFalse(test.isPrime(92));
        assertFalse(test.isPrime(93));
        assertTrue(test.isPrime(97));
        assertTrue(test.isPrime(101));
        assertTrue(test.isPrime(103));
        assertFalse(test.isPrime(105));
        assertTrue(test.isPrime(107));
    }
}
