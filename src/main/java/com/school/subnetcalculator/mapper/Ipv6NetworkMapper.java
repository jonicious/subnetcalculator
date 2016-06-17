package com.school.subnetcalculator.mapper;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6Network;
import com.googlecode.ipv6.IPv6NetworkMask;
import org.json.JSONException;
import org.json.JSONObject;

public class Ipv6NetworkMapper
{
    public static IPv6Network makeIpv6NetworkFromJsonObject(JSONObject object) throws JSONException
    {
        JSONObject ipv6AddressObject = object.getJSONObject("address");
        Long ipv6AddressHighBits = ipv6AddressObject.getLong("highBits");
        Long ipv6AddressLowBits = ipv6AddressObject.getLong("lowBits");
        IPv6Address iPv6Address = IPv6Address.fromLongs(ipv6AddressHighBits, ipv6AddressLowBits);

        JSONObject ipv6NetworkMaskObject = object.getJSONObject("networkMask");
        int ipv6NetworkMaskPrefixLength = ipv6NetworkMaskObject.getInt("prefixLength");
        IPv6NetworkMask ipv6NetworkMask = IPv6NetworkMask.fromPrefixLength(ipv6NetworkMaskPrefixLength);

        return IPv6Network.fromAddressAndMask(iPv6Address, ipv6NetworkMask);

    }
}
