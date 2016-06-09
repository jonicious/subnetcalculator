package com.school.subnetcalculator.model;

public class IPv4Network
{
    private IPv4Address networkAddress;
    private IPv4Address broadcastAddress;
    private IPv4NetworkMask networkMask;

    IPv4Network(IPv4Address address, IPv4NetworkMask networkMask) {
        this.networkAddress = address;
        this.networkMask = networkMask;
    }

    public static IPv4Network fromAddressAndMask(IPv4Address address, IPv4NetworkMask networkMask)
    {
        return new IPv4Network(address, networkMask);
    }

    private static String parseNetworkAddress(String string)
    {
        return string.substring(0, string.indexOf('/'));
    }

    public String getNetworkAdress() {
        return this.networkAddress.toString();
    }

    public String getBroadcastAdress() {
        return this.broadcastAddress.toString();
    }
}
