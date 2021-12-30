package com.revature.bookshelf.loginservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;
    // TODO: Look into if @Indexed(unique = true) and or @Field is required
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    // Switching to mongoDB so requires different annotations? or none?
    // TODO: Look into annotations if required for List<String>
    private List<String> authorities;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
