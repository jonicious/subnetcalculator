package main.com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Network;

import java.net.InetAddress;
import java.util.List;

public class Subnet {
    // TODO: missing IPv4Network thing
    private IPv6Network ipv6Subnet;
    private List<Host> hosts;


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

    public IPv6Network getIpv6Subnet() {
        return ipv6Subnet;
    }

    public void setIpv6Subnet(IPv6Network ipv6Subnet) {
        this.ipv6Subnet = ipv6Subnet;
    }
}
