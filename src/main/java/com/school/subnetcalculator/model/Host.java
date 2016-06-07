package com.school.subnetcalculator.model;

import java.net.Inet4Address;

public class Host
{
    private String description;
    private Inet4Address ipv4Address;


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


}
