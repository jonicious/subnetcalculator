package test.com.school.subnetcalculator.helper;

import main.com.school.subnetcalculator.helper.Converter;
import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void convertDecimalToBinary() throws Exception {
        String resultTwelve = Converter.convertDecimalToBinary("12");
        Assert.assertEquals("1100", resultTwelve);

        String resultTwoHundred = Converter.convertDecimalToBinary("200");
        Assert.assertEquals("11001000", resultTwoHundred);

        String resultZero = Converter.convertDecimalToBinary("");
        Assert.assertEquals("0", resultZero);
    }

    @Test
    public void convertHexadecimalToBinary() throws Exception {

    }

    @Test
    public void convertBinaryToDecimal() throws Exception {

    }

    @Test
    public void convertBinaryToHexadecimal() throws Exception {

    }

}
