package com.school.subnetcalculator.mapper;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import com.school.subnetcalculator.model.Host;
import com.school.subnetcalculator.model.Network;
import com.school.subnetcalculator.model.Subnet;
import com.school.subnetcalculator.model.ipv4.IPv4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class NetworkMapperTest
{

    @Test
    public void testNetworkListToJsonObject() throws UnknownHostException
    {
        IPv6Network ipv6ExampleNetwork = IPv6Network.fromString("2001:0db8:85a3:0000:0000:8a2e:0370:7334/48");
        IPv6Address iPv6ExampleAddress = IPv6Address.fromString("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
        IPv4Address iPv4ExampleAddress = IPv4Address.fromString("192.168.178.1");

        Host host1 = new Host();
        host1.setDescription("This is the computer of Jonah.");
        host1.setIpv6Address(iPv6ExampleAddress);
        host1.setIpv4Address(iPv4ExampleAddress);

        Host host2 = new Host();
        host2.setDescription("This is the computer of Thies.");
        host2.setIpv6Address(iPv6ExampleAddress);
        host2.setIpv4Address(iPv4ExampleAddress);

        List<Host> hosts = new ArrayList<>();
        hosts.add(host1);
        hosts.add(host2);

        Subnet subnet = new Subnet();
        subnet.setHosts(hosts);
        subnet.setIpv6Network(ipv6ExampleNetwork);

        List<Subnet> subnetList = new ArrayList<>();
        subnetList.add(subnet);

        Network network = new Network();
        network.setSubnetList(subnetList);

        List<Network> networkList = new ArrayList<>();
        networkList.add(network);

        JSONObject jsonObject = NetworkMapper.makeJsonObjectFromNetworkList(networkList);
        Assert.assertNotNull(jsonObject);
    }

}
