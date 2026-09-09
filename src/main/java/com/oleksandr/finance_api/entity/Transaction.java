package com.oleksandr.finance_api.entity;
import com.oleksandr.finance_api.entity.enums.TransactionType;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction{
    // 0. --- Constructor ---
    public Transaction(){

    }
    // 1. --- ATTRIBUTES ---
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    // FOREIGN KEYS
    // Many Transactions belong to 1 Account
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    // Many Transactions belong to 1 Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private BigDecimal amount; //BigDecimal - standard for money

    private String description;
    private String merchant;

    @Column(nullable = false)
    private LocalDate transactionDate;

    //Tell JPA how to store the enum
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    // 2. --- METHODS ---
    // Getters and Setters

    // id
    public Long getId(){return this.id;}
    // account
    public Account getAccount(){return this.account;}
    public void setAccount(Account account){this.account = account;}
    // category
    public Category getCategory(){return this.category;}
    public void setCategory(Category category){this.category = category;}
    // amount
    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}
    // merchant
    public String getMerchant() {return merchant;}
    public void setMerchant(String merchant) {this.merchant = merchant;}
    // description
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    // transactionDate
    public LocalDate getTransactionDate() {return transactionDate;}
    public void setTransactionDate(LocalDate transactionDate) {this.transactionDate = transactionDate;}
    // type
    public TransactionType getType() {return type;}
    public void setType(TransactionType type) {this.type = type;}
}