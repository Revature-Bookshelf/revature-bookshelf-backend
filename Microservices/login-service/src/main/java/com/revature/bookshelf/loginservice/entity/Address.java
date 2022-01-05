package com.revature.bookshelf.loginservice.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "addresses")
@Data
public class Address  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;
    private String addressId;
    private String city;
    private String country;
    private String streetName;
    private String postalCode;
    private String type;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User userDetails;
    public User getUserDetails()
    {
        return userDetails;
    }

    public void setUserDetails(User userDetails)
    {
        this.userDetails = userDetails;
    }
}
