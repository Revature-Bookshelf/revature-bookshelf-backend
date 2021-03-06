package com.revature.bookshelf.loginservice.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;
    private List<AddressDTO> addresses;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmailVerificationToken()
    {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken)
    {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus()
    {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus)
    {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public List<AddressDTO> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses)
    {
        this.addresses = addresses;
    }
}
