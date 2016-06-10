package com.school.subnetcalculator.helper;

import com.school.subnetcalculator.model.Subnet;
import com.school.subnetcalculator.model.ipv4.IPv4Address;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
import com.school.subnetcalculator.model.ipv4.IPv4NetworkMask;

import java.util.*;

public class VLSM {
    public static List<Subnet> calculateSubnets(String networkAddress, Map<String, Integer> subnets) {
        Map<String, Integer> sortedSubnets = sortMap(subnets);
        List<Subnet> output = new ArrayList<>();

        int currentIp = findFirstIp(networkAddress);

        for (String key : sortedSubnets.keySet()) {
            Subnet subnet = new Subnet();
            subnet.setName(key);

            int neededSize = sortedSubnets.get(key);
            int networkMaskPrefix = calculateNeededPrefixLength(neededSize);
            subnet.setIpv4Network(IPv4Network.fromAddressAndMask(IPv4Address.fromString(convertIpToQuartet(currentIp)), IPv4NetworkMask.fromPrefixLength(networkMaskPrefix)));

            int allocatedSize = findUsableHosts(networkMaskPrefix);
            subnet.setHostCount(allocatedSize);

//            subnet.broadcast = convertIpToQuartet(currentIp + allocatedSize + 1);
//            String firstUsableHost = convertIpToQuartet(currentIp + 1);
//            String lastUsableHost = convertIpToQuartet(currentIp + allocatedSize);
//            subnet.range = firstUsableHost + " - " + lastUsableHost;

            output.add(subnet);

            // add two because network and broadcast address
            currentIp += allocatedSize + 2;
        }

        return output;
    }

    private static Map<String, Integer> sortMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    private static int convertQuartetToBinaryString(String ipAddress) {
        String[] ip = ipAddress.split("\\.|/");

        int octet1 = Integer.parseInt(ip[0]);
        int octet2 = Integer.parseInt(ip[1]);
        int octet3 = Integer.parseInt(ip[2]);
        int octet4 = Integer.parseInt(ip[3]);

        int output = octet1;
        output = (output << 8) + octet2;
        output = (output << 8) + octet3;
        output = (output << 8) + octet4;

        return output;
    }

    private static String convertIpToQuartet(int ipAddress) {
        int octet1 = (ipAddress >> 24) & 255;
        int octet2 = (ipAddress >> 16) & 255;
        int octet3 = (ipAddress >> 8) & 255;
        int octet4 = ipAddress & 255;

        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }

    private static int findFirstIp(String majorNetwork) {
        String[] ip = majorNetwork.split("/");
        int mask = Integer.parseInt(ip[1]); // parse CIDR mask
        int offset = Integer.SIZE - mask;
        int majorAddress = convertQuartetToBinaryString(majorNetwork);

        return (majorAddress >> offset) << offset;
    }

    private static int calculateNeededPrefixLength(int neededSize) {
        int highestBit = Integer.highestOneBit(neededSize);
        int position = (int) (Math.log(highestBit) / Math.log(2));
        return Integer.SIZE - (position + 1);   // +1 because position starts with 0
    }

    private static int findUsableHosts(int mask) {
        return (int) Math.pow(2, Integer.SIZE - mask) - 2;
    }

    private static String toDecMask(int mask) {
        if (mask == 0) {
            return "0.0.0.0";
        }
        int allOne = -1;    // '255.255.255.255'
        int shifted = allOne << (Integer.SIZE - mask);

        return convertIpToQuartet(shifted);
    }
}
