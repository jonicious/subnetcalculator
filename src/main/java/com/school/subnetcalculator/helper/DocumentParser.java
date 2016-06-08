package com.school.subnetcalculator.helper;

import com.school.subnetcalculator.mapper.NetworkMapper;
import com.school.subnetcalculator.model.Network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;
import org.json.JSONObject;

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

        return null;
    }


    public static void exportToFile(List<Network> networkList, String exportFileName)
    {
        JSONObject jsonObject = NetworkMapper.makeJsonObjectFromNetworkList(networkList);

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(exportFileName), "utf-8")))
        {
            writer.write(jsonObject.toString());
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
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
