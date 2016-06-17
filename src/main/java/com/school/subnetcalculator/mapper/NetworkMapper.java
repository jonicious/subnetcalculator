package com.school.subnetcalculator.mapper;

import com.google.gson.Gson;
import com.googlecode.ipv6.IPv6Network;
import com.school.subnetcalculator.model.Network;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
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

            if (object.has("ipv4Network"))
            {
                JSONObject ipv4NetworkObject = object.getJSONObject("ipv4Network");
                IPv4Network iPv4Network = Ipv4NetworkMapper.makeIpv4NetworkFromJsonObject(ipv4NetworkObject);
                network.setIpv4Network(iPv4Network);
            }

            if (object.has("ipv6Network"))
            {
                JSONObject ipv6NetworkObject = object.getJSONObject("ipv6Network");
                IPv6Network iPv6Network = Ipv6NetworkMapper.makeIpv6NetworkFromJsonObject(ipv6NetworkObject);
                network.setIpv6Network(iPv6Network);
            }

            network.setSubnetList(SubnetMapper.makeSubnetListFromJsonArray(object.getJSONArray("subnetList")));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return network;
    }


    public static JSONObject makeJsonObjectFromNetworkList(List<Network> networkList)
    {
        JSONObject jsonObject = new JSONObject();

        try
        {
            Gson gson = new Gson();
            jsonObject.put("networkList", gson.toJsonTree(networkList));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return jsonObject;

    }


    public static List<Network> makeNetworkListFormObject(JSONObject object)
    {
        List<Network> networks = new ArrayList<>();
        try
        {
            String networkListString = object.getString("networkList");
            JSONArray networkList = new JSONArray(networkListString);

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
