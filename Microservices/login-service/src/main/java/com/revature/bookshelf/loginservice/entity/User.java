package com.revature.bookshelf.loginservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {

    @Id
    private int id;
    // TODO: Look into if @Indexed(unique = true) and or @Field is required
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    // Switching to mongoDB so requires different annotations? or none?
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_roles", foreignKey = @ForeignKey(name = "user_id"))

    // TODO: Look into annotations if required for List<String>
    private List<String> authorities;
}
