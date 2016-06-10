package com.school.subnetcalculator.helper;

import com.school.subnetcalculator.model.Department;
import com.school.subnetcalculator.model.Subnet;
import com.school.subnetcalculator.model.ipv4.IPv4Address;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
import com.school.subnetcalculator.model.ipv4.IPv4NetworkMask;

import java.util.*;

public class VLSM {
    public static List<Subnet> calculateSubnets(String networkAddress, Map<Department, Integer> subnets) {
        Map<Department, Integer> sortedSubnets = sortMap(subnets);
        List<Subnet> output = new ArrayList<>();

        int currentIp = getFirstIPv4(networkAddress);

        for (Department key : sortedSubnets.keySet()) {
            Subnet subnet = new Subnet();
            subnet.setDepartment(key);

            int neededSize = sortedSubnets.get(key);
            int networkMaskPrefix = calculateNeededPrefixLength(neededSize);
            subnet.setIpv4Network(IPv4Network.fromAddressAndMask(IPv4Address.fromString(convertAddressToString(currentIp)), IPv4NetworkMask.fromPrefixLength(networkMaskPrefix)));

            int allocatedSize = findUsableHosts(networkMaskPrefix);
            subnet.setHostCount(allocatedSize);

//            subnet.broadcast = convertAddressToString(currentIp + allocatedSize + 1);
//            String firstUsableHost = convertAddressToString(currentIp + 1);
//            String lastUsableHost = convertAddressToString(currentIp + allocatedSize);
//            subnet.range = firstUsableHost + " - " + lastUsableHost;

            output.add(subnet);

            // add two because network and broadcast address
            currentIp += allocatedSize + 2;
        }

        return output;
    }

    private static Map<Department, Integer> sortMap(Map<Department, Integer> map) {
        List<Map.Entry<Department, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<Department, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<Department, Integer> entry : entries) {
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

    private static String convertAddressToString(int ipAddress) {
        int octet1 = (ipAddress >> 24) & 255;
        int octet2 = (ipAddress >> 16) & 255;
        int octet3 = (ipAddress >> 8) & 255;
        int octet4 = ipAddress & 255;

        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }

    private static int getFirstIPv4(String majorNetwork) {
        String[] ip = majorNetwork.split("/");
        int mask = Integer.parseInt(ip[1]);
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
}
