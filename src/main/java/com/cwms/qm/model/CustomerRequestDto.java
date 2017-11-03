package com.cwms.qm.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by duanzonglong on 2017/8/3.
 */
@XmlRootElement(name = "customer")
public class CustomerRequestDto
{
    private String country;
    
    private String province;
    
    private String city;
    
    private String district;
    
    private String street;
    
    private String zipcode;
    
    private String contactor;
    
    private String customerCode;
    
    private String customerName;
    
    private String phone;
    
    private String email;
    
    private String personalPhone;
    
    private String fax;

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getContactor()
    {
        return contactor;
    }

    public void setContactor(String contactor)
    {
        this.contactor = contactor;
    }

    public String getCustomerCode()
    {
        return customerCode;
    }

    public void setCustomerCode(String customerCode)
    {
        this.customerCode = customerCode;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPersonalPhone()
    {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone)
    {
        this.personalPhone = personalPhone;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }
}
