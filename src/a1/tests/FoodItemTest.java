package a1.tests;

import cmpt213.assignment1.foodexpdatestracker.FoodItem;

import static org.junit.jupiter.api.Assertions.*;

class FoodItemTest {

    @org.junit.jupiter.api.Test
    void testToString1() {
        FoodItem test1 = new FoodItem("Apple", "Tim Apple", 1.00);
        assertEquals("Food: Apple\nNotes: Tim Apple\nPrice: 1.0\nExpiry date: 2021-09-23", test1.toString());
    }

    @org.junit.jupiter.api.Test
    void testToString2() {
        assertThrows(IllegalArgumentException.class, () -> new FoodItem("", "Tim Apple", 1.00));
    }
}