package com.school.subnetcalculator.model.ipv4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPv4NetworkMask {
    private final int prefixLength;

    private IPv4NetworkMask(int prefixLength) {
        if (prefixLength < 0 || prefixLength > 32) {
            throw new IllegalArgumentException("prefix length should be in interval [0, 32]");
        }

        this.prefixLength = prefixLength;
    }

    public static IPv4NetworkMask fromAddress(String networkMaskAdress) throws UnknownHostException {
        InetAddress inetNetworkMaskAdress = InetAddress.getByName(networkMaskAdress);
        byte[] netmaskBytes = inetNetworkMaskAdress.getAddress();
        int cidr = 0;
        boolean zero = false;
        for(byte b : netmaskBytes){
            int mask = 0x80;

            for(int i = 0; i < 8; i++){
                int result = b & mask;
                if(result == 0){
                    zero = true;
                }else if(zero){
                    throw new IllegalArgumentException("Invalid netmask.");
                } else {
                    cidr++;
                }
                mask >>>= 1;
            }
        }
        return new  IPv4NetworkMask(cidr);
    }

    public static IPv4NetworkMask fromPrefixLength(int prefixLength) {
        return new IPv4NetworkMask(prefixLength);
    }

    @Override
    public String toString() {
        return "" + prefixLength;
    }

}
