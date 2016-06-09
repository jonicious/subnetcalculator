package com.school.subnetcalculator.helper;

import com.school.subnetcalculator.model.Network;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class DocumentParserTest
{
    @Test
    public void testReadFile()
    {
        String result = DocumentParser.readFile("test.json");
        Assert.assertTrue(result.contains("networkList"));
    }


    @Test
    public void testImportFromFile()
    {
        List<Network> networks = DocumentParser.importFromFile("test.json");
        Assert.assertTrue(networks.size() == 4);
        Assert.assertTrue(networks.get(0).getSubnetList().size() == 0);
    }
}
