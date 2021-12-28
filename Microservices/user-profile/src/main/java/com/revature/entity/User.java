package com.revature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private ObjectId id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
   // @ElementCollection(fetch = FetchType.EAGER)
    //@CollectionTable(name = "user_roles",foreignKey = @ForeignKey(name="user_id"))
   // private List<String> authorities;
}
