package com.oleksandr.finance_api.entity;
import com.oleksandr.finance_api.entity.enums.AccountType;
import jakarta.persistence.*;

// Entity tells JPA that this Java object represents a table in the DB
@Entity
@Table(
        name = "accounts",
        uniqueConstraints={
                //UNIQUE(user_id, name) -> 1 user can't have 2 accounts named the same way
                @UniqueConstraint(columnNames={"user_id","name"})
        })
public class Account{
    // 0. --- Constructor ---
    public Account(){

    }
    // 1. --- ATTRIBUTES ---
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    // FOREIGN KEY
    // Account..<n,1>..User
    // Many accounts belong to 1 user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // This Account has a reference to a User object

    @Column(nullable = false)
    // How to tell UNIQUE(user_id, name)?
    private String name;

    //Tell JPA how to store the enum
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType type;

    // 2. --- METHODS ---
    // Getters and setters

    // id
    public Long getId(){return this.id;}
    // name
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    // user
    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}
    // type
    public AccountType getType(){return this.type;}
    public void setType(AccountType type){this.type=type;}
}

