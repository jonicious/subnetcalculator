package com.school.subnetcalculator.mapper;

import com.school.subnetcalculator.model.Network;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkMapper
{
    public static List<Network> makeNetworkFromObject(JSONObject object)
    {

        try
        {
            JSONArray networkList = object.getJSONArray("networkList");

            for (int i = 0; i < networkList.length(); i++)
            {
                JSONObject jsonObject = networkList.getJSONObject(i);
                String networkAddress = jsonObject.getString("networkAddress");
                String globalNetworkAddress = jsonObject.getString("globalNetworkAddress");
                String globalSubnetMask = jsonObject.getString("globalSubnetMask");
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
