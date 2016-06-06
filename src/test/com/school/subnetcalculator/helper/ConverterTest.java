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

        String binaryZero = Converter.convertDecimalToBinary("");
        Assert.assertEquals("0", binaryZero);
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

        String resultZero = Converter.convertBinaryToDecimal("");
        Assert.assertEquals("0", resultZero);
    }

    @Test
    public void convertBinaryToHexadecimal() throws Exception {

    }

}
