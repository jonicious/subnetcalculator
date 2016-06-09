package com.school.subnetcalculator.model;

import java.util.List;

public class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isUsedBySubnet(List<Subnet> subnetList) {
        return subnetList.stream().anyMatch(subnet -> subnet.getDepartment().getName().equals(this.getName()));
    }

    @Override
    public String toString() {
        return this.name;
    }
}
