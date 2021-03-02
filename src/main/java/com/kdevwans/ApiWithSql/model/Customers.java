package com.kdevwans.ApiWithSql.model;

import javax.persistence.*;

@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int custId;
    private String custName;
    private String CustEmail;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String custEmail) {
        CustEmail = custEmail;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", CustEmail='" + CustEmail + '\'' +
                '}';
    }
}
