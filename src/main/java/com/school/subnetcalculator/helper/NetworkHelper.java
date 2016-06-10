package com.school.subnetcalculator.helper;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6NetworkMask;
import com.school.subnetcalculator.model.Department;
import com.school.subnetcalculator.model.Network;
import com.school.subnetcalculator.model.Subnet;
import com.school.subnetcalculator.model.ipv4.IPv4Address;
import com.school.subnetcalculator.model.ipv4.IPv4NetworkMask;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class NetworkHelper {
    private static boolean isIPv6Address(String netAddress) {
        return netAddress.contains(":");
    }

    public static Network generateNetwork(String netAddress, String prefixLength, String subnetMask) {
        if (NetworkHelper.isIPv6Address(netAddress)) {
            List netData = NetworkHelper.getPreparedIPv6NetworkData(netAddress, prefixLength, subnetMask);
            if (netData != null) {
                return new Network(IPv6Address.fromString(netData.get(0).toString()), IPv6NetworkMask.fromPrefixLength(Integer.parseInt(netData.get(1).toString())));
            }
        } else {
            List netData = NetworkHelper.getPreparedIPv4NetworkData(netAddress, prefixLength, subnetMask);
            if (netData != null) {
                return new Network(IPv4Address.fromString(netData.get(0).toString()), IPv4NetworkMask.fromPrefixLength(Integer.parseInt(netData.get(1).toString())));
            }
        }

        return null;
    }

    public static Subnet generateSubnet(String netAddress, String prefixLength, String subnetMask, Department department) {
        if (NetworkHelper.isIPv6Address(netAddress)) {
            List netData = NetworkHelper.getPreparedIPv6NetworkData(netAddress, prefixLength, subnetMask);
            if (netData != null) {
                return new Subnet(IPv6Address.fromString(netData.get(0).toString()), IPv6NetworkMask.fromPrefixLength(Integer.parseInt(netData.get(1).toString())), department);
            }
        } else {
            List netData = NetworkHelper.getPreparedIPv4NetworkData(netAddress, prefixLength, subnetMask);
            if (netData != null) {
                return new Subnet(IPv4Address.fromString(netData.get(0).toString()), IPv4NetworkMask.fromPrefixLength(Integer.parseInt(netData.get(1).toString())), department);
            }
        }

        return null;
    }

    private static List getPreparedIPv6NetworkData(String netAddress, String prefixLength, String subnetMask) {
        List<String> dataList = new ArrayList<>();

        IPv6Address createdAddress = IPv6Address.fromString(netAddress);
        IPv6NetworkMask createdMask = null;

        if (prefixLength != null && !prefixLength.isEmpty()) {
            createdMask = IPv6NetworkMask.fromPrefixLength(Integer.parseUnsignedInt(prefixLength, 10));
        } else if (subnetMask != null && !subnetMask.isEmpty()) {
            createdMask = IPv6NetworkMask.fromAddress(IPv6Address.fromString(subnetMask));
        }

        if (createdMask != null) {
            dataList.add(createdAddress.toString());
            dataList.add(createdMask.toString());

            return dataList;
        }

        return null;
    }

    private static List getPreparedIPv4NetworkData(String netAddress, String prefixLength, String subnetMask) {
        List<String> dataList = new ArrayList<>();

        IPv4Address createdAddress = IPv4Address.fromString(netAddress);
        IPv4NetworkMask createdMask = null;

        if (prefixLength != null && !prefixLength.isEmpty()) {
            createdMask = IPv4NetworkMask.fromPrefixLength(Integer.parseUnsignedInt(prefixLength, 10));
        } else if (subnetMask != null && !subnetMask.isEmpty()) {
            try {
                createdMask = IPv4NetworkMask.fromAddress(subnetMask);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        if (createdMask != null) {
            dataList.add(createdAddress.toString());
            dataList.add(createdMask.toString());
        }

        return dataList;
    }
}
