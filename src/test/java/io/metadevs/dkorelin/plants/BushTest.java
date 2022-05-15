package io.metadevs.dkorelin.plants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BushTest {

    @Test
    void testEquals() {
        Bush testBush1 = new Bush("coffee", 7,true);
        Bush testBush2 = new Bush("coffee", 7,true);
        assertEquals(testBush1, testBush2);
    }
    @Test
    void testNotEquals() {
        Bush testBush1 = new Bush("coffee", 7,true);
        Bush testBush2 = new Bush("coffee", 7,true,"most of people like it");
        assertNotEquals(testBush1, testBush2);
    }

    @Test
    void testHashCode() {
        Bush testBush1 = new Bush("coffee", 7,true);
        Bush testBush2 = new Bush("coffee", 7,true);
        assertEquals(testBush1.hashCode(), testBush2.hashCode());
    }
}