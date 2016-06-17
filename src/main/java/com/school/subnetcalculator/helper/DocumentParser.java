package com.school.subnetcalculator.helper;

import com.school.subnetcalculator.mapper.NetworkMapper;
import com.school.subnetcalculator.model.Network;
import org.json.JSONObject;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class DocumentParser
{
    public static List<Network> importFromFile(String fileName)
    {
        try
        {
            String jsonData = readFile(fileName);
            JSONObject object = new JSONObject(jsonData);
            return NetworkMapper.makeNetworkListFormObject(object);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }


    public static void exportToFile(List<Network> networkList, String exportFileName)
    {
        JSONObject jsonObject = NetworkMapper.makeJsonObjectFromNetworkList(networkList);

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(exportFileName, false), "utf-8")))
        {
            writer.write(jsonObject.toString());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
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
