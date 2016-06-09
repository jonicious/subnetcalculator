package com.school.subnetcalculator.model;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPv4Address
{
    private InetAddress inetAddress;

    IPv4Address(String address) throws Exception {
        try {
            this.inetAddress = InetAddress.getByName(address);
        } catch(UnknownHostException e) {
            throw new Exception("Not a valid IPv4 Adress");
        }
    }

    public static IPv4Address fromString(String adress) throws Exception {
        return new IPv4Address(adress);
    }

    @Override
    public String toString() {
        return this.inetAddress.toString();
    }
}
