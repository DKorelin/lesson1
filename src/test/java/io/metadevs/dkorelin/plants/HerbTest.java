package io.metadevs.dkorelin.plants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerbTest {

    @Test
    void testEquals() {
        Herb testHerb1 = new Herb("chamomile",10);
        Herb testHerb2 = new Herb("chamomile",10);
        assertEquals(testHerb1, testHerb2);
    }
    @Test
    void testNotEquals() {
        Herb testHerb1 = new Herb("chamomile",10);
        Herb testHerb2 = new Herb("chamomile",10,"most of people like it with tea");
        assertNotEquals(testHerb1, testHerb2);
    }

    @Test
    void testHashCode() {
        Herb testHerb1 = new Herb("chamomile",10);
        Herb testHerb2 = new Herb("chamomile",10);
        assertEquals(testHerb1.hashCode(), testHerb2.hashCode());
    }
}