/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs_devices.model;

import java.util.*;
import java.text.*;
/**
 *
 * @author nedilk
 */
public class BorrowDevice {
    
    private int transaction_ID;
    private String transaction_Mode;
    private String transaction_Type;
    private String username;
    private String device_ID;
    private String from_Date;
    private String to_Date;

    public int getTransaction_ID() {
        return transaction_ID;
    }

    public String getTransaction_Mode() {
        return transaction_Mode;
    }

    public String getTransaction_Type() {
        return transaction_Type;
    }

    public String getUsername() {
        return username;
    }

    public String getDevice_ID() {
        return device_ID;
    }

    

    public void setTransaction_ID(int transaction_ID) {
        this.transaction_ID = transaction_ID;
    }

    public void setTransaction_Mode(String transaction_Mode) {
        this.transaction_Mode = transaction_Mode;
    }

    public void setTransaction_Type(String transaction_Type) {
        this.transaction_Type = transaction_Type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDevice_ID(String device_ID) {
        this.device_ID = device_ID;
    }

    public String getFrom_Date() {
        return from_Date;
    }

    public String getTo_Date() {
        return to_Date;
    }

    public void setFrom_Date(String from_Date) {
        this.from_Date = from_Date;
    }

    public void setTo_Date(String to_Date) {
        this.to_Date = to_Date;
    }

    
    
}
