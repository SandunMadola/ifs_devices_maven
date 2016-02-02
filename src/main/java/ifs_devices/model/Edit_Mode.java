package ifs_devices.model;

/**
 *
 * @author sanmlk
 */
public class Edit_Mode {

    private String device_ID;
    private String device_Name;
    private String product_Area;
    private String sub_Product_Area;
    private String resolution;
    private String size;
    private String os;
    private String url;
    private String location;
    private String type;
    private String platform;
    private int request_ID;

    public int getRequest_ID() {
        return request_ID;
    }

    public void setRequest_ID(int request_ID) {
        this.request_ID = request_ID;
    }

    public String getDevice_ID() {
        return device_ID;
    }

    public void setDevice_ID(String device_ID) {
        this.device_ID = device_ID;
    }

    public String getDevice_Name() {
        return device_Name;
    }

    public void setDevice_Name(String device_Name) {
        this.device_Name = device_Name;
    }

    public String getProduct_Area() {
        return product_Area;
    }

    public void setProduct_Area(String product_Area) {
        this.product_Area = product_Area;
    }

    public String getSub_Product_Area() {
        return sub_Product_Area;
    }

    public void setSub_Product_Area(String sub_Product_Area) {
        this.sub_Product_Area = sub_Product_Area;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
