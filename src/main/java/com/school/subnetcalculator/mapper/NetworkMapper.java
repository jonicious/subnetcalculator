package com.school.subnetcalculator.mapper;

import com.googlecode.ipv6.IPv6Network;
import com.school.subnetcalculator.model.Network;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkMapper
{
    public static Network makeNetworkFromObject(JSONObject object)
    {
        Network network = new Network();

        try
        {
            // TODO: Add IPv4 object.getString("ipv4NetworkAddress");
            String ipv6NetworkAddress = object.getString("ipv6NetworkAddress");
            network.setIpv6Network(IPv6Network.fromString(ipv6NetworkAddress));
            network.setSubnetList(SubnetMapper.makeSubnetListFromJsonArray(object.getJSONArray("subnetList")));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return network;
    }


    public static List<Network> makeNetworkListFormObject(JSONObject object)
    {
        List<Network> networks = new ArrayList<>();
        try
        {
            JSONArray networkList = object.getJSONArray("networkList");
            for (int i = 0; i < networkList.length(); i++)
            {
                networks.add(makeNetworkFromObject(networkList.getJSONObject(i)));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return networks;
    }

}
