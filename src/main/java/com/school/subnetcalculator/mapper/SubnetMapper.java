package com.school.subnetcalculator.mapper;

import com.googlecode.ipv6.IPv6Network;
import com.school.subnetcalculator.model.Subnet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubnetMapper
{
    public static Subnet makeSubnetFromObject(JSONObject object)
    {
        Subnet subnet = new Subnet();
        try
        {
            String ipv6SubnetAddressString = object.getString("ipv6SubnetAddress");
            subnet.setIpv6Network(IPv6Network.fromString(ipv6SubnetAddressString));
            subnet.setHosts(HostMapper.makeHostListFromObject(object.getJSONArray("hosts")));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return subnet;
    }


    public static List<Subnet> makeSubnetListFromJsonArray(JSONArray array)
    {
        ArrayList<Subnet> subnetList = new ArrayList<>();

        for (int i = 0; i < array.length(); i++)
        {
            try
            {
                subnetList.add(makeSubnetFromObject(array.getJSONObject(i)));
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }

        return subnetList;
    }
}