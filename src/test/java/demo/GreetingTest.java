package demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingTest {

    @Test
    public void getId() {
        Greeting greeting = new Greeting(12, "User");
        assertEquals(12, greeting.getId());
    }

    @Test
    public void getContent() {
        Greeting greeting = new Greeting(12, "User");
        assertEquals("User", greeting.getContent());
    }
}