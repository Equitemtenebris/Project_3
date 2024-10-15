package com.example;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class);  // Мок для Feline
        cat = new Cat(felineMock);  // Инъектируем мок в Cat
    }

    @Test
    public void getSound_shouldReturnMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood_shouldReturnPredatorFood() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));  // Мокируем поведение метода eatMeat
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
