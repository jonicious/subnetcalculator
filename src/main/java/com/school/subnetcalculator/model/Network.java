package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import com.googlecode.ipv6.IPv6NetworkMask;
import com.school.subnetcalculator.model.ipv4.IPv4Address;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
import com.school.subnetcalculator.model.ipv4.IPv4NetworkMask;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private IPv6Network ipv6Network;
    private IPv4Network ipv4Network;
    private List<Subnet> subnetList = new ArrayList<>();


    public Network(IPv6Address networkAddress, IPv6NetworkMask subnetMask) {
        this.ipv6Network = IPv6Network.fromAddressAndMask(networkAddress, subnetMask);
    }

    public Network(IPv4Address networkAddress, IPv4NetworkMask subnetMask) {
        this.ipv4Network = IPv4Network.fromAddressAndMask(networkAddress, subnetMask);
    }

    public Network() {

    }

    @Override
    public String toString() {
        if (ipv6Network != null) {
            return this.ipv6Network.toString();
        } else {
            return this.ipv4Network.toString();
        }
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

    public void setIpv6Network(IPv6Network ipv6Network) {
        this.ipv6Network = ipv6Network;
    }


}
