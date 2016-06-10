package com.school.subnetcalculator;

import com.school.subnetcalculator.helper.VLSM;
import com.school.subnetcalculator.model.Subnet;
import com.school.subnetcalculator.model.ipv4.IPv4Address;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
import com.school.subnetcalculator.model.ipv4.IPv4NetworkMask;
import com.school.subnetcalculator.view.SubnetCalculatorFrame;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubnetCalculator {

    public static void main(String args[]) throws IOException {

        IPv4Network mainNet = IPv4Network.fromAddressAndMask(IPv4Address.fromString("192.168.178.0"), IPv4NetworkMask.fromPrefixLength(24));
        String majorNetwork = mainNet.getCIDRNotation();

        Map<String, Integer> subnets = new HashMap<>();
        subnets.put("A", 50);
        subnets.put("B", 30);
        subnets.put("C", 62);
        subnets.put("D", 10);

        List<Subnet> output = VLSM.calculateSubnets(majorNetwork, subnets);

        for (Subnet subnet : output) {
            System.out.println(subnet.getIpv4Network().toString());
        }


        new SubnetCalculatorFrame();
    }
}
