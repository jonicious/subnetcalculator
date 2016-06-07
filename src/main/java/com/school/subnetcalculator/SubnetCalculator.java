package com.school.subnetcalculator;

import com.school.subnetcalculator.view.SubnetCalculatorFrame;
import java.awt.Dimension;
import java.io.IOException;

public class SubnetCalculator
{
    public static void main(String args[]) throws IOException
    {
        SubnetCalculatorFrame subnetCalculatorFrame = new SubnetCalculatorFrame();
        subnetCalculatorFrame.setPreferredSize(new Dimension(400, 400));
        subnetCalculatorFrame.setVisible(true);
    }
}
