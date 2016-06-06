package main.com.school.subnetcalculator.helper;

public class Converter {

    /**
     * @param decimalString string representation of unsigned integer
     * @return binaryString
     * @throws IllegalArgumentException
     */
    public static String convertDecimalToBinary(String decimalString) throws IllegalArgumentException {
        if(decimalString.length() > 0) {
            Integer decimal = Integer.parseUnsignedInt(decimalString, 10);
            return Integer.toBinaryString(decimal);
        } else {
            throw new IllegalArgumentException("decimal input is empty");
        }
    }


    public static String convertHexadecimalToBinary(String hexadecimalString) {
        return null;
    }


    /**
     * @param binaryString string representation of a binary integer
     * @return decimalString
     * @throws IllegalArgumentException
     */
    public static String convertBinaryToDecimal(String binaryString) throws IllegalArgumentException {
        if (binaryString.length() > 0) {
            Integer decimalInt = Integer.parseInt(binaryString, 2);
            return decimalInt.toString();
        } else {
            throw new IllegalArgumentException("binary input is empty");
        }
    }


    public static String convertBinaryToHexadecimal(String binaryString) {
        return null;
    }
}
