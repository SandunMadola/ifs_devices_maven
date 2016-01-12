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
import java.util.Date;
import java.util.List;


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
        String Date = request.getDate();

        String query = "INSERT INTO add_request"
                + " (device_Name, type, platform, OS, size, resolution, username, sub_Product_Area, request_Status, priority, location, comments, url, project, date)"
                + " VALUES ('" + Device_name + "','" + Type + "','" + Platform + "','" + OS + "','" + Size + "','" + Resolution + "','" + UserName + "','" + SPA + "','" + Request_Status + "','" + Priority + "','" + Location + "','" + Comment + "','" + URL + "','" + Project + "','" + Date + "')";
        //db set auto increment
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return request;
    }

    public static ArrayList<Request> getRequest(Connection connection) throws Exception {
        System.out.println("Query");
        ArrayList<Request> requests = new ArrayList<Request>();        
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM add_request");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Request req = new Request();
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
                req.setDate(rs.getString("date"));
                requests.add(req);
            }
            return requests;
        } catch (Exception e) {
            throw e;
        }
    }

    public static BorrowDevice addBorrowRequest(BorrowDevice borrowRequest, Connection connection) throws SQLException {
        System.out.println("Inside the addBorrowRequest Query");

        
        String transaction_Mode = borrowRequest.getTransaction_Mode();
        String transaction_Type = borrowRequest.getTransaction_Type();
        String username = borrowRequest.getUsername();
        String device_ID = borrowRequest.getDevice_ID();
        String from_Date = borrowRequest.getFrom_Date();
        String to_Date = borrowRequest.getTo_Date();

        String query = "INSERT INTO borrow_device"
                + " (transaction_Mode, transaction_Type, username, device_ID, from_Date, to_Date)"
                + " VALUES ('" + transaction_Mode + "','" + transaction_Type + "','" + username + "','" + device_ID + "','" + from_Date + "','" + to_Date + "')";
        
  
        //db set auto increment
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return borrowRequest;
    }

    public static BorrowDevice getBorrowRequest(Connection connection) throws Exception {
        System.out.println(" GetBorrowDevice Query");
        BorrowDevice borrowreq = new BorrowDevice();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM borrow_device");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                borrowreq.setTransaction_ID(rs.getInt("transaction_ID"));
                borrowreq.setTransaction_Mode(rs.getString("transaction_Mode"));
                borrowreq.setTransaction_Type(rs.getString("transaction_Type"));
                borrowreq.setUsername(rs.getString("username"));
                borrowreq.setDevice_ID(rs.getString("device_ID"));
                borrowreq.setFrom_Date(rs.getString("from_Date"));
                borrowreq.setTo_Date(rs.getString("to_date"));
//                borrowreq.setFrom_Date(rs.getDate(1) != null) ? rs.getDate(1).toLocalDate() : null;
              
            }
            return borrowreq;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<BorrowDevice>  getBookedDates(String id, Connection connection) throws Exception {
        System.out.println(" getBookedDate Query");
       
        ArrayList<BorrowDevice> bookreq  = new ArrayList<BorrowDevice>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT from_Date, to_Date FROM borrow_device WHERE device_ID ="+ id + " AND transaction_Mode = 'orange' AND from_Date >= CURDATE() <= to_Date");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BorrowDevice bookedreq = new BorrowDevice();
//               bookreq.setTransaction_ID(rs.getInt("transaction_ID"));
//                bookreq.setTransaction_Mode(rs.getString("transaction_Mode"));
//                bookreq.setTransaction_Type(rs.getString("transaction_Type"));
//                bookreq.setUsername(rs.getString("username"));
//                bookreq.setDevice_ID(rs.getString("device_ID"));
                bookedreq.setFrom_Date(rs.getString("from_Date"));
                bookedreq.setTo_Date(rs.getString("to_date"));
//                borrowreq.setFrom_Date(rs.getDate(1) != null) ? rs.getDate(1).toLocalDate() : null;
                bookreq.add(bookedreq);

            }
            return bookreq;
        } catch (Exception e) {
            throw e;
        }
    }
    
    static ArrayList<DeviceList> GetAllDevices(Connection connection) throws Exception {

        ArrayList<DeviceList> devicedata = new ArrayList<DeviceList>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT b.`device_ID`,b.`model_ID`,b.`sub_Product_Area_ID`,b.`product_Area_ID`,b.location,b.comments,a.`model_ID`,a.`name`,a.image_no,a.`type`,a.platform,a.`OS`,a.`size`,a.resolution,a.`count`,a.`URL`,c.`sub_Product_Area_ID`,c.`sub_Product_Area_name`,c.`product_Area_ID`,d.`transaction_ID`,IFNULL(d.`transaction_Mode`,\"green\") AS `transaction_Mode`,d.`transaction_Type`,d.username,d.`device_ID`,d.`from_Date`,d.`to_Date` FROM device b LEFT OUTER JOIN device_model a ON (b.`model_ID`=a.`model_ID`) LEFT JOIN sub_product_area c ON (b.sub_Product_Area_ID = c.sub_Product_Area_ID) LEFT JOIN borrow_device d ON (b.device_ID = d.device_ID and CURDATE() between from_Date and to_Date) GROUP BY b.`device_ID` ORDER BY d.`transaction_Mode` DESC");

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
                devicels.setTransaction_Mode(rs.getString("transaction_Mode"));
                devicedata.add(devicels);
                devicels.setTransaction_ID(rs.getInt("transaction_ID"));
            }
            return devicedata;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static String deleteTransaction(int id, Connection connection) throws SQLException {
        System.out.println("Inside the Query");
        String query = "DELETE FROM borrow_device WHERE transaction_ID = " + id + "";
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return "SUCCESS!!!";
    }
    
    public static BorrowDevice updateDevice(BorrowDevice updateDevice, Connection connection) throws SQLException {
        System.out.println("Inside the Query");
        
        String transaction_Mode = updateDevice.getTransaction_Mode();
        String transaction_Type = updateDevice.getTransaction_Type();
        int transaction_ID = updateDevice.getTransaction_ID();
     
        String query = "UPDATE borrow_device SET transaction_Mode = 'red', transaction_Type = 'return' WHERE transaction_ID = " + transaction_ID;
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return updateDevice;
    }
    
   public static String returnDeviceTransaction(int id, Connection connection) throws SQLException {
        System.out.println("Inside the Query");
        
        String query1 = "INSERT INTO returned_devices ( transaction_ID, transaction_Mode, transaction_Type, username, device_ID, from_Date, to_Date, returned_Date ) SELECT transaction_ID, transaction_Mode, transaction_Type, username, device_ID, from_Date, to_Date, CURDATE() FROM borrow_device WHERE transaction_ID = " + id + "";
        String query2 = "DELETE FROM borrow_device WHERE transaction_ID = " + id + "";
        System.out.println(query1);
        System.out.println(query2);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return "SUCCESS!!!";
    }
    
}
