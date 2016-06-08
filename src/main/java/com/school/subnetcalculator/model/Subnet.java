package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import com.googlecode.ipv6.IPv6NetworkMask;

import java.util.List;

public class Subnet {
    // TODO: missing IPv4Network thing
    private IPv6Network ipv6Network;
    private List<Host> hosts;


    public Subnet(IPv6Address networkAddress, IPv6NetworkMask networkMask) {
        this.ipv6Network = IPv6Network.fromAddressAndMask(networkAddress, networkMask);
    }

    public Subnet() {
        // TODO: If given an IPv4 address, don't select first and last IP as host.
    }

    public List<Host> getHosts() {
        return hosts;
    }


    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }


    public void addIpAddress(Host host) {
        this.hosts.add(host);
    }


    public void addMultipleHosts(List<Host> hosts) {
        this.hosts.addAll(hosts);
    }


    public IPv6Network getIpv6Network()
    {
        return ipv6Network;
    }


    public void setIpv6Network(IPv6Network ipv6Network)
    {
        this.ipv6Network = ipv6Network;
    }

    @Override
    public String toString() {
        return this.ipv6Network.toString();
    }
}
