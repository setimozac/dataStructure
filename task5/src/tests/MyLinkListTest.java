package tests;

import com.setimoart.MyLinkList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MyLinkListTest {

    MyLinkList<String> arr;

    @BeforeEach
    public void setUp() {
        arr = new MyLinkList<>();
        arr.addToFront("1");
        arr.addToFront("2");
        arr.addToFront("3");
    }

    @Test
    public void getSize() {
        Assertions.assertEquals(3, arr.getSize());
    }

    @Test
    public void addToFront() {
        arr.addToFront("4");
        Assertions.assertEquals(4, arr.getSize());
        Assertions.assertEquals("4",arr.toArray().get(0));

        arr.addToFront("5");
        Assertions.assertEquals(5, arr.getSize());
        Assertions.assertEquals("5",arr.toArray().get(0));
    }

    @Test
    public void addToEnd() {
        arr.addToEnd("4");
        Assertions.assertEquals(4, arr.getSize());
        Assertions.assertEquals("4",arr.toArray().get(3));

        arr.addToEnd("5");
        Assertions.assertEquals(5, arr.getSize());
        Assertions.assertEquals("5",arr.toArray().get(4));
    }

    @Test
    public void get() {

        Assertions.assertEquals("3", arr.get(0));
        Assertions.assertEquals("2", arr.get(1));
        Assertions.assertEquals("1", arr.get(2));
//
        Exception ex = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arr.get(3));
        Assertions.assertEquals("index out of bound", ex.getMessage());
    }

    @Test
    public void insertValueAtIndex() {
    }

    @Test
    public void deleteByIndex() {
    }

    @Test
    public void deleteByValue() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void toArray() {
    }
}