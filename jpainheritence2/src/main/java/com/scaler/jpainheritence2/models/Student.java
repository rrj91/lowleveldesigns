package com.scaler.jpainheritence2.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends User{
    private String batchName;
    private double psp;

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "batchName='" + batchName + '\'' +
                ", psp=" + psp +
                "} " + super.toString();
    }
}
