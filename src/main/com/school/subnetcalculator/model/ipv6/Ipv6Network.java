package main.com.school.subnetcalculator.model.ipv6;

import main.com.school.subnetcalculator.model.Network;
import java.net.Inet6Address;

public class Ipv6Network extends Network
{
    private Inet6Address subnetMask;
    private Inet6Address globalPrefix;
    private Inet6Address globalNetworkAddress;
}
