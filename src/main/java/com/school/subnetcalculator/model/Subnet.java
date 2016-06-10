package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import com.googlecode.ipv6.IPv6NetworkMask;
import com.school.subnetcalculator.model.ipv4.IPv4Address;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
import com.school.subnetcalculator.model.ipv4.IPv4NetworkMask;

import java.util.ArrayList;
import java.util.List;

public class Subnet {
    private String name;
    private IPv6Network ipv6Network;
    private int hostCount;

    public IPv4Network getIpv4Network() {
        return ipv4Network;
    }

    public void setIpv4Network(IPv4Network ipv4Network) {
        this.ipv4Network = ipv4Network;
    }

    private IPv4Network ipv4Network;
    private Department department;
    private List<Host> hosts;


    public Subnet(IPv6Address networkAddress, IPv6NetworkMask networkMask) {
        this.ipv6Network = IPv6Network.fromAddressAndMask(networkAddress, networkMask);
    }

    public Subnet(IPv6Address networkAddress, IPv6NetworkMask networkMask, Department department) {
        this.ipv6Network = IPv6Network.fromAddressAndMask(networkAddress, networkMask);
        this.department = department;
    }

    public Subnet(IPv4Address networkAddress, IPv4NetworkMask networkMask) {
        this.ipv4Network = IPv4Network.fromAddressAndMask(networkAddress, networkMask);
    }

    public Subnet(IPv4Address networkAddress, IPv4NetworkMask networkMask, Department department) {
        this.ipv4Network = IPv4Network.fromAddressAndMask(networkAddress, networkMask);
        this.department = department;
    }

    public Subnet() {
        // TODO: If given an ipv4 address, don't select first and last IP as host.
    }

    public List<Host> getHosts() {
        if(hosts == null) {
            hosts = new ArrayList<>();
        }
        return hosts;
    }


    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }


    public void setIpv6Network(IPv6Network ipv6Network) {
        this.ipv6Network = ipv6Network;
    }

    public Department getDepartment() {
        return department;
    }

    public void removeHostFromList(Host host) {
        getHosts().remove(host);
    }

    @Override
    public String toString() {
        if (ipv6Network != null) {
            return this.ipv6Network.toString();
        } else {
            return this.ipv4Network.toString();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHostCount() {
        return hostCount;
    }

    public void setHostCount(int hostCount) {
        this.hostCount = hostCount;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addHostToHostList(Host host) {
        getHosts().add(host);
    }
}
