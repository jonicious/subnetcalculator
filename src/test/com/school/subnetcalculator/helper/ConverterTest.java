package test.com.school.subnetcalculator.helper;

import main.com.school.subnetcalculator.helper.Converter;
import org.junit.Assert;
import org.junit.Test;

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
        String binaryTwoA = Converter.convertHexadecimalToBinary("2A");
        Assert.assertEquals("101010", binaryTwoA);

        String binaryLargeNumber = Converter.convertHexadecimalToBinary("2AAFFEEEEFF329920FE");
        String expectedBinaryString = "10101010101111111111101110111011101111111100110010100110010010000011111110";
        Assert.assertEquals(expectedBinaryString, binaryLargeNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertHexadecimalToBinaryException() throws Exception {
        Converter.convertHexadecimalToBinary("");
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
        String resultTwoA = Converter.convertBinaryToHexadecimal("101010");
        Assert.assertEquals("2a", resultTwoA);

        String requestedBinaryString = "10101010101111111111101110111011101111111100110010100110010010000011111110";
        String resultLargeNumber = Converter.convertBinaryToHexadecimal(requestedBinaryString);
        Assert.assertEquals("2aaffeeeeff329920fe", resultLargeNumber);

    }

}
