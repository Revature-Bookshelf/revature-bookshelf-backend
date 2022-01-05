package com.revature.bookshelf.loginservice.model.ui;

import java.util.List;

public class UserRest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressesRest> addresses;

    public String getUserId()
    {
        return id;
    }

    public void setUserId(String userId)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<AddressesRest> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(List<AddressesRest> addresses)
    {
        this.addresses = addresses;
    }
}
