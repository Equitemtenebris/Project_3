package com.example;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void getKittensShouldReturnOneByDefault() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void getKittensWithSpecificCountShouldReturnCorrectValue() {
        int kittens = feline.getKittens(3);
        assertEquals(3, kittens);
    }

    @Test
    public void eatMeatShouldReturnPredatorFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamilyShouldReturnFelineFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }
}
