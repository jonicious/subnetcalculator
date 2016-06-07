package com.school.subnetcalculator.helper;

import java.math.BigInteger;

public class Converter {

    /**
     * @param decimalString string representation of unsigned integer
     * @return binaryString
     * @throws IllegalArgumentException
     */
    public static String convertDecimalToBinary(String decimalString) throws IllegalArgumentException {
        if (decimalString.length() > 0) {
            Integer decimal = Integer.parseUnsignedInt(decimalString, 10);
            return Integer.toBinaryString(decimal);
        } else {
            throw new IllegalArgumentException("decimal input is empty");
        }
    }


    public static String convertHexadecimalToBinary(String hexadecimalString) {
        if (hexadecimalString.length() > 0) {
            BigInteger hexadecimal = new BigInteger(hexadecimalString, 16);
            return hexadecimal.toString(2);
        } else {
            throw new IllegalArgumentException("hexadecimal input is empty");
        }
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
        if(binaryString.length() > 0) {
            BigInteger binary = new BigInteger(binaryString, 2);
            return binary.toString(16);
        } else {
            throw new IllegalArgumentException("binary input is empty");
        }
    }
}
