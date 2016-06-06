package com.school.subnetcalculator.model;

import java.net.InetAddress;
import java.util.List;

public class Subnet
{
    private InetAddress networkAddress;
    private InetAddress subnetMask;
    private List<Host> hosts;


    public Subnet()
    {
        // TODO: If given an IPv4 address, don't select first and last IP as host.
    }


    public InetAddress getNetworkAddress()
    {
        return networkAddress;
    }


    public void setNetworkAddress(InetAddress networkAddress)
    {
        this.networkAddress = networkAddress;
    }


    public InetAddress getSubnetMask()
    {
        return subnetMask;
    }


    public void setSubnetMask(InetAddress subnetMask)
    {
        this.subnetMask = subnetMask;
    }


    public List<Host> getHosts()
    {
        return hosts;
    }


    public void setHosts(List<Host> hosts)
    {
        this.hosts = hosts;
    }


    public void addIpAddress(Host host)
    {
        this.hosts.add(host);
    }


    public void addMultipleHosts(List<Host> hosts)
    {
        this.hosts.addAll(hosts);
    }

}
