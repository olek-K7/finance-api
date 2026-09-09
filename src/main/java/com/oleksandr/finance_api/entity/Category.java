package com.oleksandr.finance_api.entity;
import jakarta.persistence.*;

// Tells JPA that this Java Object represents a table in the DB
@Entity
@Table(
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(columnNames={"user_id", "name"})
        })
public class Category{
    // 0. --- Constructor ---
    public Category(){

    }
    // 1. --- ATTRIBUTES ---
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    // FK
    // Many categories belong to 1 user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false)
    private String name;

    // 2. --- METHODS ---
    // Getters and Setters
    // id
    public Long getId(){return this.id;}
    // user
    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}
    // name
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
