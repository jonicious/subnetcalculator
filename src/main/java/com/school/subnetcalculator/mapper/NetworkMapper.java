package com.school.subnetcalculator.mapper;

import com.google.gson.Gson;
import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import com.googlecode.ipv6.IPv6NetworkMask;
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
            // TODO: Add ipv4 object.getString("ipv4NetworkAddress");
            JSONObject ipv6NetworkObject = object.getJSONObject("ipv6Network");

            JSONObject ipv6AddressObject = ipv6NetworkObject.getJSONObject("address");
            Long ipv6AddressHighBits = ipv6AddressObject.getLong("highBits");
            Long ipv6AddressLowBits = ipv6AddressObject.getLong("lowBits");
            IPv6Address iPv6Address = IPv6Address.fromLongs(ipv6AddressHighBits, ipv6AddressLowBits);

            JSONObject ipv6NetworkMaskObject = ipv6NetworkObject.getJSONObject("networkMask");
            int ipv6NetworkMaskPrefixLength = ipv6NetworkMaskObject.getInt("prefixLength");
            IPv6NetworkMask ipv6NetworkMask = IPv6NetworkMask.fromPrefixLength(ipv6NetworkMaskPrefixLength);

            network.setIpv6Network(IPv6Network.fromAddressAndMask(iPv6Address, ipv6NetworkMask));
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
