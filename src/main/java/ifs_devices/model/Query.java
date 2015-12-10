/**
 *
 * @author sanmlk
 */
package ifs_devices.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Query {

    static ArrayList<Employee> GetFeeds(Connection connection) throws Exception {
        System.out.println("Query");
        ArrayList<Employee> empdata = new ArrayList<Employee>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
//                emp.setId(rs.getInt("id"));
//                emp.setName(rs.getString("name"));
//                emp.setAge(rs.getInt("age"));
                emp.setUsername(rs.getString("username"));
                emp.setPid(rs.getString("product_Area_ID"));
                emp.setSubpid(rs.getString("sub_Product_Area_ID"));
                empdata.add(emp);
            }
            return empdata;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Request addRequest(Request request, Connection connection) throws SQLException {
        System.out.println("Inside the Query");
        String Device_name = request.getDevice_name();
        String Type = request.getType();
        String Platform = request.getPlatform();
        String OS = request.getOS();
        String Priority = request.getPriority();
        String Size = request.getSize();
        String Resolution = request.getResolution();
        String Location = request.getLocation();
        String SPA = request.getSPA();
        String Request_Status = request.getRequest_Status();
        String Project = request.getProject();
        String URL = request.getURL();
        String UserName = request.getUserName();
        String Comment = request.getComment();

        String query = "INSERT INTO add_request"
                + " (device_Name, type, platform, OS, size, resolution, username, sub_Product_Area, request_Status, priority, location, comments, url, project)"
                + " VALUES ('" + Device_name + "','" + Type + "','" + Platform + "','" + OS + "','" + Size + "','" + Resolution + "','" + UserName + "','" + SPA + "','" + Request_Status + "','" + Priority + "','" + Location + "','" + Comment + "','" + URL + "','" + Project + "')";
        //db set auto increment
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("erro" + e);
        }

        return request;
    }

    public static Request getRequest(Connection connection) throws Exception {
        System.out.println("Query");
        Request req = new Request();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM add_request");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                req.setDevice_name(rs.getString("device_Name"));
                req.setType(rs.getString("type"));
                req.setPlatform(rs.getString("platform"));
                req.setOS(rs.getString("OS"));
                req.setSize(rs.getString("size"));
                req.setResolution(rs.getString("resolution"));
                req.setUserName(rs.getString("username"));
                req.setSPA(rs.getString("sub_Product_Area"));
                req.setRequest_Status(rs.getString("request_Status"));
                req.setPriority(rs.getString("priority"));
                req.setLocation(rs.getString("location"));
                req.setComment(rs.getString("comments"));
                req.setURL(rs.getString("url"));
                req.setProject(rs.getString("project"));

            }
            return req;
        } catch (Exception e) {
            throw e;
        }
    }

    static ArrayList<DeviceList> GetAllDevices(Connection connection) throws Exception {

        ArrayList<DeviceList> devicedata = new ArrayList<DeviceList>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT a.name, a.type, a.platform, a.image_no, a.OS, a.size, a.resolution, a.URL, b.location, c.sub_Product_Area_ID, c.sub_Product_Area_name, d.device_ID, d.username FROM device_model a JOIN device b ON (a.model_ID = b.model_ID) JOIN sub_product_area c ON (b.sub_Product_Area_ID = c.sub_Product_Area_ID) JOIN borrow_device d ON (b.device_ID = d.device_ID)");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DeviceList devicels = new DeviceList();

                devicels.setName(rs.getString("name"));
                devicels.setType(rs.getString("type"));
                devicels.setPlatform(rs.getString("platform"));
                devicels.setImage_no(rs.getInt("image_no"));
                devicels.setOS(rs.getString("OS"));
                devicels.setSub_Product_Area_ID(rs.getString("sub_Product_Area_ID"));
                devicels.setSub_Product_Area_name(rs.getString("sub_Product_Area_name"));
                devicels.setDevice_ID(rs.getString("device_ID"));
                devicels.setUsername(rs.getString("username"));
                devicels.setSize(rs.getString("size"));
                devicels.setResolution(rs.getString("resolution"));
                devicels.setURL(rs.getString("URL"));
                devicels.setLocation(rs.getString("location"));
                devicedata.add(devicels);
            }
            return devicedata;
        } catch (Exception e) {
            throw e;
        }
    }
}
