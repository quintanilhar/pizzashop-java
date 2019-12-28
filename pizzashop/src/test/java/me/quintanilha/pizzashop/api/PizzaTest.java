package me.quintanilha.pizzashop.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PizzaTest {

    @Test
    public void getters() {
        Pizza pizza = new Pizza(10, "Pepperoni");

        assertEquals(10, pizza.id());
        assertEquals("Pepperoni", pizza.name());
    }

    @Test
    public void empty() {
        Pizza pizza = new Pizza();

        assertEquals(0, pizza.id());
        assertNull(pizza.name());
    }
}
