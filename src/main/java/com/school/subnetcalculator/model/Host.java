package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;
import com.school.subnetcalculator.model.ipv4.IPv4Address;

public class Host {
    private String description;
    private IPv4Address ipv4Address;
    private IPv6Address iPv6Address;

    public Host(IPv4Address addr, String description) {
        this.ipv4Address = addr;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public Host() {
    }

    public IPv4Address getIpv4Address() {
        return ipv4Address;
    }


    public void setIpv4Address(IPv4Address ipv4Address) {
        this.ipv4Address = ipv4Address;
    }


    public IPv6Address getIpv6Address() {
        return iPv6Address;
    }


    public void setIpv6Address(IPv6Address iPv6Address) {
        this.iPv6Address = iPv6Address;

    }

    @Override
    public String toString() {
        if(iPv6Address != null) {
            return this.iPv6Address.toString();
        } else {
            return this.ipv4Address.toString();
        }
    }
}
