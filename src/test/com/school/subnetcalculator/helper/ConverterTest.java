package test.com.school.subnetcalculator.helper;

import main.com.school.subnetcalculator.helper.Converter;
import org.junit.Assert;
import org.junit.Test;

import java.util.IllegalFormatCodePointException;

public class ConverterTest {

    @Test
    public void convertDecimalToBinary() throws Exception {
        String binaryTwelve = Converter.convertDecimalToBinary("12");
        Assert.assertEquals("1100", binaryTwelve);

        String binaryTwoHundred = Converter.convertDecimalToBinary("200");
        Assert.assertEquals("11001000", binaryTwoHundred);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertDecimalToBinaryException() throws Exception {
        Converter.convertDecimalToBinary("");
    }

    @Test
    public void convertHexadecimalToBinary() throws Exception {

    }

    @Test
    public void convertBinaryToDecimal() throws Exception {
        String resultTwelve = Converter.convertBinaryToDecimal("1100");
        Assert.assertEquals("12", resultTwelve);

        String resultTwoHundred = Converter.convertBinaryToDecimal("11001000");
        Assert.assertEquals("200", resultTwoHundred);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertBinaryToDecimalException() throws Exception {
        Converter.convertBinaryToDecimal("");
    }

    @Test
    public void convertBinaryToHexadecimal() throws Exception {

    }

}
