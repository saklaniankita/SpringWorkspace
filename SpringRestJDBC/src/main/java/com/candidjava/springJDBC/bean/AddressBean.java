package com.candidjava.springJDBC.bean;

import java.math.BigDecimal;

public class AddressBean
{
    private String city;
    private String state;
    private long pincode;
     
    //****************************************
     
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public String getState()
    {
        return state;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public long getPincode()
    {
        return pincode;
    }
    public void setPincode(long pincode)
    {
        this.pincode = pincode;
    }
 
     
}