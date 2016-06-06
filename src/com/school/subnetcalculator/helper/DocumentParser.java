package com.school.subnetcalculator.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import main.com.school.subnetcalculator.model.Network;
import org.json.JSONArray;
import org.json.JSONObject;

public class DocumentParser
{
    public static Network importFromFile(String fileName)
    {
        try
        {
            String jsonData = readFile(fileName);
            JSONObject jobj = new JSONObject(jsonData);
            JSONArray jarr = new JSONArray(jobj.getJSONArray("keywords").toString());
            System.out.println("Name: " + jobj.getString("name"));
            for (int i = 0; i < jarr.length(); i++)
            {
                System.out.println("Keyword: " + jarr.getString(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;

    }


    private static String readFile(String fileName)
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
