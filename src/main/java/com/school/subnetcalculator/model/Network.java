package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import com.googlecode.ipv6.IPv6NetworkMask;

import java.util.*;

public class Network {
    // TODO: missing IPv4Network thing
    private IPv6Network ipv6Network;
    private List<Subnet> subnetList = new ArrayList<>();


    public Network(IPv6Address networkAddress, IPv6NetworkMask subnetMask) {
        this.ipv6Network = IPv6Network.fromAddressAndMask(networkAddress, subnetMask);
    }

    public Network() {
        // TODO: repeat the above for IPv4
    }

    @Override
    public String toString() {
        return this.ipv6Network.toString();
    }


    public List<Subnet> getSubnetList() {
        return subnetList;
    }


    public void setSubnetList(List<Subnet> subnetList) {
        this.subnetList = subnetList;
    }


    public void addSubnet(Subnet subnet) {
        this.subnetList.add(subnet);
    }


    public void removeSubnetFromList(Subnet subnet) {
        this.subnetList.remove(subnet);
    }


    public List<Subnet> getCalculatedSubnetList(int subnetCount) {
        // TODO: Of some host count.
        return Collections.emptyList();
    }


    public IPv6Network getIpv6Network() {
        return ipv6Network;
    }


    public void setIpv6Network(IPv6Network ipv6Network) {
        this.ipv6Network = ipv6Network;
    }
}
