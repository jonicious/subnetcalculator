package com.school.subnetcalculator.model.ipv4;

import org.apache.commons.net.util.SubnetUtils;

public class IPv4Network {
    private IPv4Address networkAddress;
    private IPv4NetworkMask networkMask;
    private SubnetUtils snUtils;

    private IPv4Network(IPv4Address address, IPv4NetworkMask networkMask) {
        this.networkAddress = address;
        this.networkMask = networkMask;
        this.snUtils = new SubnetUtils(this.networkAddress.toString() + "/" + this.networkMask.toString());
    }

    public static IPv4Network fromAddressAndMask(IPv4Address address, IPv4NetworkMask networkMask) {
        return new IPv4Network(address, networkMask);
    }

    private static IPv4Network fromString(String networkString) throws IllegalArgumentException {
        if (networkString.indexOf('/') >= 0) {
            IPv4Address netAddress = IPv4Address.fromString(networkString.substring(0, networkString.indexOf('/')));
            IPv4NetworkMask netMask = IPv4NetworkMask.fromPrefixLength(Integer.parseUnsignedInt(networkString.substring(1, networkString.indexOf('/')), 10));
            return new IPv4Network(netAddress, netMask);
        }

        throw new IllegalArgumentException("input string is of invalid format");
    }

    public String getNetworkAdress() {
        return this.networkAddress.toString();
    }

    public IPv4Address getLastAddress() {
        return IPv4Address.fromString(snUtils.getInfo().getBroadcastAddress());
    }

    public IPv4Address getFirstAddress() {
        return IPv4Address.fromString(snUtils.getInfo().getAddress());
    }

    public int adressCount() {
        return  snUtils.getInfo().getAddressCount();
    }


    @Override
    public String toString() {
        return this.getCIDRNotation();
    }

    public String getCIDRNotation() {
        return this.networkAddress.toString() + "/" + this.networkMask.toString();
    }

    public SubnetUtils getSnUtils() {
        return snUtils;
    }
}
