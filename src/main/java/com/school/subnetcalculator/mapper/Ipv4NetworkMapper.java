package com.school.subnetcalculator.mapper;

import com.school.subnetcalculator.model.ipv4.IPv4Address;
import com.school.subnetcalculator.model.ipv4.IPv4Network;
import com.school.subnetcalculator.model.ipv4.IPv4NetworkMask;
import org.json.JSONException;
import org.json.JSONObject;

public class Ipv4NetworkMapper
{
    public static IPv4Network makeIpv4NetworkFromJsonObject(JSONObject object) throws JSONException
    {
        JSONObject ipv4NetworkAddressObject = object.getJSONObject("networkAddress");
        JSONObject ipv4NetworkMaskObject = object.getJSONObject("networkMask");

        IPv4Address iPv4Address = IPv4Address.fromString(ipv4NetworkAddressObject.getString("address"));
        IPv4NetworkMask iPv4NetworkMask = IPv4NetworkMask.fromPrefixLength(ipv4NetworkMaskObject.getInt("prefixLength"));

        return IPv4Network.fromAddressAndMask(iPv4Address, iPv4NetworkMask);
    }
}
