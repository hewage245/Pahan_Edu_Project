package com.example.PahanaEduProject.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bills")
public class Bill {
    @Id
    private String id;
    private int billID;
    private int accountNumber;
    private double totalAmount;
    private Date date;

    public Bill() {}
    public Bill(int billID, int accountNumber, double totalAmount, Date date) {
        this.billID = billID;
        this.accountNumber = accountNumber;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    // Getters & Setters
    public String getId() { return id; }
    public int getBillID() { return billID; }
    public void setBillID(int billID) { this.billID = billID; }
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
