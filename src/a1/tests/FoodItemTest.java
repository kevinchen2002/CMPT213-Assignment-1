package a1.tests;

import cmpt213.assignment1.foodexpdatestracker.FoodItem;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FoodItemTest {

    @org.junit.jupiter.api.Test
    void testToString1() {
        FoodItem test1 = new FoodItem("Apple", "Tim Apple", 1.00, LocalDateTime.now());
        System.out.println(test1);
        assertEquals("Food: Apple\nNotes: Tim Apple\nPrice: 1.0\nExpiry date: 2021-09-23\nThis food is already expired!", test1.toString());
    }

    @org.junit.jupiter.api.Test
    void testToString2() {
        LocalDateTime newDateTime = LocalDateTime.now();
        newDateTime = newDateTime.plusDays(1);
        FoodItem test2 = new FoodItem("Apple2", "Tim Apple", 1.00, newDateTime);
        System.out.println(test2);
    }

    @org.junit.jupiter.api.Test
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> new FoodItem("", "Tim Apple", 1.00, LocalDateTime.now()));
    }
}