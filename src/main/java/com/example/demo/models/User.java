package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User extends BaseModel {

    @NotBlank
    @Size(min = 3, max = 25)
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 3, max = 25)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 25)
    private String lastName;

    @NotBlank
    @Size(min = 5, max = 90)
    private String password;

    private String resetToken;
}
