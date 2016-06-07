package com.school.subnetcalculator.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import com.school.subnetcalculator.mapper.NetworkMapper;
import com.school.subnetcalculator.model.Network;
import org.json.JSONObject;

public class DocumentParser
{
    public static List<Network> importFromFile(String fileName)
    {
        try
        {
            String jsonData = readFile(fileName);
            JSONObject object = new JSONObject(jsonData);
            return NetworkMapper.makeNetworkFromObject(object);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }


    static String readFile(String fileName)
    {
        String result = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null)
            {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}