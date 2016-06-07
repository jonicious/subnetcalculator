package main;

import java.awt.Dimension;
import main.com.school.subnetcalculator.view.SubnetCalculatorFrame;

public class SubnetCalculator
{
    public static void main(String args[]) {
        SubnetCalculatorFrame subnetCalculatorFrame = new SubnetCalculatorFrame();
        subnetCalculatorFrame.setPreferredSize(new Dimension(400, 400));
        subnetCalculatorFrame.setVisible(true);
    }
}
