/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.model;

/**
 *
 * @author nedilk
 */
public class DeviceList {
    
    private int model_ID;
    private String name;
    private String type;
    private String platform;
    private int image_no;
    private String OS;
    private String size;
    private String resolution;
    private int count;
    private String URL;
    private String sub_Product_Area_ID;
    private String sub_Product_Area_name;
    private String device_ID;
    private String username;
    private String location;
    private String transaction_Mode;
    private int transaction_ID;
    

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

   
    public int getModel_ID() {
        return model_ID;
    }

    public String getOS() {
        return OS;
    }

    public String getSize() {
        return size;
    }

    public String getResolution() {
        return resolution;
    }

    public int getCount() {
        return count;
    }

    public String getURL() {
        return URL;
    }

    public void setModel_ID(int model_ID) {
        this.model_ID = model_ID;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getSub_Product_Area_ID() {
        return sub_Product_Area_ID;
    }

    public void setSub_Product_Area_ID(String sub_Product_Area_ID) {
        this.sub_Product_Area_ID = sub_Product_Area_ID;
    }

    public String getSub_Product_Area_name() {
        return sub_Product_Area_name;
    }

    public void setSub_Product_Area_name(String sub_Product_Area_name) {
        this.sub_Product_Area_name = sub_Product_Area_name;
    }

    public int getImage_no() {
        return image_no;
    }

    public void setImage_no(int image_no) {
        this.image_no = image_no;
    }

    public String getDevice_ID() {
        return device_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setDevice_ID(String device_ID) {
        this.device_ID = device_ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTransaction_Mode() {
        return transaction_Mode;
    }

    public void setTransaction_Mode(String transaction_Mode) {
        this.transaction_Mode = transaction_Mode;
    }

    public int getTransaction_ID() {
        return transaction_ID;
    }

    public void setTransaction_ID(int transaction_ID) {
        this.transaction_ID = transaction_ID;
    }
    
}
