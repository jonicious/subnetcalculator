package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;
import java.net.Inet4Address;

public class Host {
    private String description;
    private Inet4Address ipv4Address;
    private IPv6Address ipv6address;


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Inet4Address getIpv4Address() {
        return ipv4Address;
    }


    public void setIpv4Address(Inet4Address ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    public IPv6Address getIpv6address() {
        return ipv6address;
    }

    public void setIpv6address(IPv6Address ipv6address) {
        this.ipv6address = ipv6address;
    }
}
