package tests;

import com.setimoart.MyArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {
    private MyArray arr;

    @BeforeClass
    public static void setupClass() {
//        MyArray arr;
    }

    @BeforeEach
    public void setUp() {
        arr = new MyArray();
        arr.add(2);
        arr.add(3);
        arr.add(9);
        arr.add(13);
        arr.add(66);
        arr.add(5);
    }


    @Test
    void size() {
        assertEquals(arr.size(), 6);
        arr.deleteByIndex(2);
        assertEquals(arr.size(), 5);
    }

    @Test
    void add() {
        arr.add(10);
        assertEquals(arr.size(),7);

    }

    @Test
    void get() {
        Exception ex1 = assertThrows(IndexOutOfBoundsException.class,() -> arr.get(6));
        String expectedEx1 = "Index is out of bounds";

        assertEquals(expectedEx1, ex1.getMessage());

        int res = arr.get(5);
        assertEquals(res, 5);
        res = arr.get(3);
        assertEquals(res, 13);
    }

    @Test
    void deleteByIndex() {

        Exception ex1 = assertThrows(IndexOutOfBoundsException.class,() -> arr.deleteByIndex(6));
        String expectedEx1 = "Index is out of bounds";

        assertEquals(expectedEx1, ex1.getMessage());

        assertEquals(arr.get(2), 9);
        arr.deleteByIndex(2);
        assertEquals(arr.get(2), 13);
        arr.deleteByIndex(0);
        assertEquals(arr.get(0), 3);
    }

    @Test
    void deleteByValue() {
        assertEquals(arr.get(3), 13);
        arr.deleteByValue(13);
        assertEquals(arr.get(3), 66);
        assertFalse(() -> arr.deleteByValue(23));
        assertTrue(() -> arr.deleteByValue(5));

    }

    @Test
    void insertValueAtIndex() {
        Exception ex1 = assertThrows(IndexOutOfBoundsException.class, () -> arr.insertValueAtIndex(15,6));
        String expectedEx1 = "Index is out of bounds";

        assertEquals(expectedEx1, ex1.getMessage());

        arr.insertValueAtIndex(15, 4);
        assertEquals(arr.get(4), 15);
    }

    @Test
    void getSlice() {

        Exception ex1 = assertThrows(IndexOutOfBoundsException.class, () -> arr.getSlice(2, 6));
        Exception ex2 = assertThrows(IndexOutOfBoundsException.class, () -> arr.getSlice(-1, 3));
        String expectedEx1 = "This range is out of bounds";
        String expectedEx2 = "Index must be greater than or equal to Zero";

        assertEquals(expectedEx1, ex1.getMessage());
        assertEquals(expectedEx2, ex2.getMessage());

        int[] res = arr.getSlice(2,2);
        assertEquals(res[0], 9);
        assertEquals(res[1], 13);
        assertEquals(res.length, 2);
    }

    @Test
    void clear() {
        assertEquals(arr.size(), 6);
        arr.clear();
        assertEquals(arr.size(), 0);
    }

    @Test
    void testToString() {
        String expextedStr = "[2, 3, 9, 13, 66, 5]";
        assertEquals(expextedStr, arr.toString());
    }
}