package com.oleksandr.finance_api.entity;
import java.util.ArrayList;
import java.util.List;

import com.oleksandr.finance_api.repository.UserRepository;
import jakarta.persistence.*;

// Entity tells JPA that this Java object represents a table in the DB
@Entity
// Represents table called "users"
@Table(name="users")
public class User{
    // 0. --- CONSTRUCTOR ---
    // Constructor required by JPA
    public User(){
    }

    // 1. --- ATTRIBUTES ---
    // Primary Key, Value is generated and autoincremented by DB
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    // This attribute corresponds to "user_id" column
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "password_hash")
    private String passwordHash;

    // User..<1,n>.Account
    // 1 User owns many Accounts
    @OneToMany(mappedBy="user")
    private List<Account> accounts = new ArrayList<>();

    // User..<1,n>.Category
    // 1 User owns many Categories
    @OneToMany(mappedBy="user")
    private List<Category> categories = new ArrayList<>();

    // 2. --- METHODS ---
    // Getters and Setters
    // id
    public Long getId(){return this.id;}
    // name
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    // email
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    // passwordHash
    public String getPasswordHash(){return passwordHash;}
    public void setPasswordHash(String passwordHash){this.passwordHash = passwordHash;}
    // lists
    public List<Account> getAccounts(){return accounts;}
    public List<Category> getCategories(){return categories;}

}