package tests;

import com.setimoart.Main;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionTestTest {

    @Test
    public void testLowerHi() {
        int outPut = Main.lowerHi("hihihih");

        Assert.assertEquals(outPut, 3);
    }

    @Test
    public void testXToy() {
        String outPut = Main.xToy("CCCCxRxY");

        Assert.assertEquals("CCCCyRyY", outPut);
    }

    @Test
    public void testPower() {

        int result = Main.power(2, 3);

        Assert.assertEquals(8, result);
    }
}