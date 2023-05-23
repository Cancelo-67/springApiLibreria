package com.example.apilibreria.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "usercustom")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private Boolean admin;

    public User(String username, String password, Boolean admin) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }
}
