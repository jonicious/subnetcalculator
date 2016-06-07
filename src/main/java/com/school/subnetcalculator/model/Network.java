package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Network;
import java.util.Collections;
import java.util.List;

public class Network
{
    // TODO: missing IPv4Network thing
    private IPv6Network ipv6Network;
    private List<Subnet> subnetList;


    public Network()
    {

    }


    public List<Subnet> getSubnetList()
    {
        return subnetList;
    }


    public void setSubnetList(List<Subnet> subnetList)
    {
        this.subnetList = subnetList;
    }


    public void addSubnet(Subnet subnet)
    {
        this.subnetList.add(subnet);
    }


    public void removeSubnetFromList(Subnet subnet)
    {
        this.subnetList.remove(subnet);
    }


    public List<Subnet> getCalculatedSubnetList(int subnetCount)
    {
        // TODO: Of some host count.
        return Collections.emptyList();
    }


    public IPv6Network getIpv6Network()
    {
        return ipv6Network;
    }


    public void setIpv6Network(IPv6Network ipv6Network)
    {
        this.ipv6Network = ipv6Network;
    }
}
