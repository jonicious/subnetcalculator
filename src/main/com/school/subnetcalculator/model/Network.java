package main.com.school.subnetcalculator.model;

import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

public class Network
{
    private InetAddress networkAddress;
    private List<Subnet> subnetList;


    public Network()
    {

    }


    public Network(InetAddress networkAddress, String subnetMask)
    {
        this.networkAddress = networkAddress;

        // TODO: Check format of subnetMask
    }


    public InetAddress getNetworkAddress()
    {
        return networkAddress;
    }


    public void setNetworkAddress(InetAddress networkAddress)
    {
        this.networkAddress = networkAddress;
    }


    public List<Subnet> getSubnetList()
    {
        return subnetList;
    }


    public void setSubnetList(List<Subnet> subnetList)
    {
        this.subnetList = subnetList;
    }


    public void addSubnet(Subnet subnet)
    {
        this.subnetList.add(subnet);
    }


    public void removeSubnetFromList(Subnet subnet)
    {
        this.subnetList.remove(subnet);
    }


    public List<Subnet> getCalculatedSubnetList(int subnetCount)
    {
        // TODO: Of some host count.
        return Collections.emptyList();
    }

}
