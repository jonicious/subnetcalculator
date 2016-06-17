package com.school.subnetcalculator.model;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import com.googlecode.ipv6.IPv6NetworkMask;
import com.school.subnetcalculator.model.ipv4.IPv4Address;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
import com.school.subnetcalculator.model.ipv4.IPv4NetworkMask;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private IPv6Network ipv6Network;
    private IPv4Network ipv4Network;
    private List<Subnet> subnetList = new ArrayList<>();


    public Network(IPv6Address networkAddress, IPv6NetworkMask subnetMask) {
        this.ipv6Network = IPv6Network.fromAddressAndMask(networkAddress, subnetMask);
    }

    public Network(IPv4Address networkAddress, IPv4NetworkMask subnetMask) {
        this.ipv4Network = IPv4Network.fromAddressAndMask(networkAddress, subnetMask);
    }

    public Network() {

    }

    @Override
    public String toString() {
        if (ipv6Network != null) {
            return this.ipv6Network.toString();
        } else {
            return this.ipv4Network.toString();
        }
    }


    public List<Subnet> getSubnetList() {
        return subnetList;
    }


    public void setSubnetList(List<Subnet> subnetList) {
        this.subnetList = subnetList;
    }

    public int getSubnetsAddressCount() {
        int hostcount = 0;

        for(Subnet subnet : subnetList) {
            hostcount += subnet.getIpv4Network().getSnUtils().getInfo().getAddressCount();
        }

        return hostcount;
    }

    public void addSubnet(Subnet subnet) throws Exception {

        if(subnet.getIpv4Network() != null)
        {
            int subnetCount = subnet.getIpv4Network().getSnUtils().getInfo().getAddressCount() + getSubnetsAddressCount();
            if (subnetCount < ipv4Network.adressCount())
            {
                System.out.println(subnetCount);
                this.subnetList.add(subnet);
            }
            else
            {
                throw new Exception("Subnets overreach the network mask limit");
            }
        } else {
            this.subnetList.add(subnet);
        }
    }


    public void removeSubnetFromList(Subnet subnet) {
        this.subnetList.remove(subnet);
    }

    public void setIpv6Network(IPv6Network ipv6Network) {
        this.ipv6Network = ipv6Network;
    }

    public void setIpv4Network(IPv4Network ipv4Network) {
        this.ipv4Network = ipv4Network;
    }


}
