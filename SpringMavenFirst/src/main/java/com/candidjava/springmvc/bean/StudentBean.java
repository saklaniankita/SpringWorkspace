package com.candidjava.springmvc.bean;

import java.util.List;

public class StudentBean {
 
    private int regno;
    private String sname;  //sname
    private List<String> course;
    private AddressBean addressBean;
     
    public int getRegno() {
        return regno;
    }
    public void setRegno(int regno) {
        this.regno = regno;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public List<String> getCourse() {
        return course;
    }
    public void setCourse(List<String> course) {
        this.course = course;
    }
    public AddressBean getAddressBean() {
        return addressBean;
    }
    public void setAddressBean(AddressBean addressBean) {
        this.addressBean = addressBean;
    }
 
     
}