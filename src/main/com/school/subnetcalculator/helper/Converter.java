package main.com.school.subnetcalculator.helper;

public class Converter {

    public static String convertDecimalToBinary(String decimalString) {
        if(decimalString.length() > 0) {
            Integer decimal = Integer.parseUnsignedInt(decimalString, 10);
            return Integer.toBinaryString(decimal);
        } else {
            return "0";
        }
    }


    public static String convertHexadecimalToBinary(String hexadecimalString) {
        return null;
    }


    public static String convertBinaryToDecimal(String binaryString) {
        if (binaryString.length() > 0) {
            Integer decimalInt = Integer.parseInt(binaryString, 2);
            return decimalInt.toString();
        } else {
            return "0";
        }
    }


    public static String convertBinaryToHexadecimal(String binaryString) {
        return null;
    }
}
