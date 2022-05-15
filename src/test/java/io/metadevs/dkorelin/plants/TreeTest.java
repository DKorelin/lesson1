package io.metadevs.dkorelin.plants;

import org.junit.jupiter.api.Test;

import static io.metadevs.dkorelin.plants.TreeResource.FOOD;
import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void testEquals() {
        Tree testTree1 = new Tree("apple",25,false, FOOD);
        Tree testTree2 = new Tree("apple",25,false, FOOD);
        assertEquals(testTree1, testTree2);
    }
    @Test
    void testNotEquals() {
        Tree testTree1 = new Tree("apple",25,false, FOOD);
        Tree testTree2 = new Tree("apple",25,false, FOOD,"most of people like it");
        assertNotEquals(testTree1, testTree2);
    }

    @Test
    void testHashCode() {
        Tree testTree1 = new Tree("apple",25,false, FOOD);
        Tree testTree2 = new Tree("apple",25,false, FOOD);
        assertEquals(testTree1.hashCode(), testTree2.hashCode());
    }
}