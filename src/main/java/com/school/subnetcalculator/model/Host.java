package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;

import java.net.Inet4Address;

public class Host
{
    private String description;
    private Inet4Address ipv4Address;
    private IPv6Address ipv6Address;


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public Inet4Address getIpv4Address()
    {
        return ipv4Address;
    }


    public void setIpv4Address(Inet4Address ipv4Address)
    {
        this.ipv4Address = ipv4Address;
    }


    public IPv6Address getIpv6Address() {
        return ipv6Address;
    }

    public void setIpv6Address(IPv6Address ipv6Address) {
        this.ipv6Address = ipv6Address;
    }
}
