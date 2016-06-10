package com.school.subnetcalculator.model.ipv4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPv4Address {
    private InetAddress address;

    private IPv4Address(String address) {
        try {
            this.address = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static IPv4Address fromString(String address) {
        return new IPv4Address(address);
    }

    public InetAddress getAddress() {
        return address;
    }

    public boolean equals(IPv4Address address1, IPv4Address address2) {
        boolean equals = address1.toString() == address2.toString();
        return equals;
    }

    @Override
    public String toString() {
        return this.address.getHostAddress();
    }
}
