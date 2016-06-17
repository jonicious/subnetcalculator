package com.school.subnetcalculator.mapper;

import com.googlecode.ipv6.IPv6Network;
import com.school.subnetcalculator.model.Subnet;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
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
            if (object.has("ipv4Network"))
            {
                IPv4Network iPv4Network = Ipv4NetworkMapper.makeIpv4NetworkFromJsonObject(object.getJSONObject("ipv4Network"));
                subnet.setIpv4Network(iPv4Network);
            }

            if (object.has("ipv6Network"))
            {
                IPv6Network iPv6Network = Ipv6NetworkMapper.makeIpv6NetworkFromJsonObject(object.getJSONObject("ipv6Network"));
                subnet.setIpv6Network(iPv6Network);
            }

            if (object.has("hosts")) {
                subnet.setHosts(HostMapper.makeHostListFromObject(object.getJSONArray("hosts")));
            }

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
