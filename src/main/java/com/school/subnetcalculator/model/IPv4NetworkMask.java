package com.school.subnetcalculator.model;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

public class IPv4NetworkMask
{
    private final int prefixLength;

    IPv4NetworkMask(int prefixLength) {
        if(prefixLength < 0 || prefixLength > 32) {
            throw new IllegalArgumentException("prefix length should be in interval [0, 32]");
        }

        this.prefixLength = prefixLength;
    }

    public static IPv4NetworkMask fromAddress(final InetAddress iPv4Address) throws SocketException
    {
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(iPv4Address);
        int prefixLength = networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();

        return new IPv4NetworkMask(prefixLength);
    }

    public static IPv4NetworkMask fromPrefixLength(int prefixLength)
    {
        return new IPv4NetworkMask(prefixLength);
    }

    @Override
    public String toString()
    {
        return "" + prefixLength;
    }

}
