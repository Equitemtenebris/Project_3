package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline felineMock;
    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        // Создаем мок для Feline
        felineMock = mock(Feline.class);

        // Создаем объекты Lion для самца и самки
        lionMale = new Lion("Самец", felineMock);
        lionFemale = new Lion("Самка", felineMock);
    }

    @Test
    public void lionShouldHaveManeIfMale() {
        assertTrue(lionMale.doesHaveMane());
    }

    @Test
    public void lionShouldNotHaveManeIfFemale() {
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test
    public void getKittensShouldReturnCorrectValue() {
        when(felineMock.getKittens()).thenReturn(2);
        assertEquals(2, lionMale.getKittens());
        verify(felineMock, times(1)).getKittens(); // Проверяем вызов метода у мока
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = lionMale.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(felineMock, times(1)).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void lionConstructorShouldThrowExceptionForInvalidSex() throws Exception {
        new Lion("Некорректное значение", felineMock);
    }
}
