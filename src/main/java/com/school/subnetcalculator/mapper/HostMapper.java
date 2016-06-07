package com.school.subnetcalculator.mapper;

import com.googlecode.ipv6.IPv6Address;
import com.school.subnetcalculator.model.Host;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostMapper
{
    public static Host makeHostFromObject(JSONObject object)
    {
        Host host = new Host();
        try
        {
            host.setDescription(object.getString("description"));
            // TODO: Add IPv4 object.getString("ipv4Address");
            String ipv6AddressString = object.getString("ipv6Address");
            host.setIpv6Address(IPv6Address.fromString(ipv6AddressString));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return host;
    }


    public static List<Host> makeHostListFromObject(JSONArray hostsArray)
    {
        List<Host> hosts = new ArrayList<>();

        try
        {
            for (int i = 0; i < hostsArray.length(); i++)
            {
                hosts.add(makeHostFromObject(hostsArray.getJSONObject(i)));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return hosts;
    }
}
