package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;
import java.net.InetAddress;

public class Host
{
    private String description;
    private InetAddress ipv4Address;
    private IPv6Address iPv6Address;


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public InetAddress getIpv4Address()
    {
        return ipv4Address;
    }


    public void setIpv4Address(InetAddress ipv4Address)
    {
        this.ipv4Address = ipv4Address;
    }


    public IPv6Address getIpv6Address()
    {
        return iPv6Address;
    }


    public void setIpv6Address(IPv6Address iPv6Address)
    {
        this.iPv6Address = iPv6Address;

    }
}
