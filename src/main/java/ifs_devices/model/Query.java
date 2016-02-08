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

    public static Request addRequest(Request request, Connection connection) throws SQLException {
        System.out.println("Query - for add a new request");
        String Device_name = request.getDevice_name();
        String Type = request.getType();
        String Platform = request.getPlatform();
        String OS = request.getOS();
        String Priority = request.getPriority();
        String Size = request.getSize();
        String Resolution = request.getResolution();
        String Location = request.getLocation();
        String SPA = request.getSPA();
        String PA = request.getPA();
        String Request_Status = request.getRequest_Status();
        String Project = request.getProject();
        String URL = request.getURL();
        String UserName = request.getUserName();
        String Comment = request.getComment();
        String Date = request.getDate();
        String R_Comment = request.getReject_comment();

        String query = "INSERT INTO device"
                + " (device_Name, type, platform, os, size, resolution, username, sub_Product_Area, product_Area, request_Status, priority, location, comments, url, project, requested_Date, reject_comment)"
                + " VALUES ('" + Device_name + "','" + Type + "','" + Platform + "','" + OS + "','" + Size + "','" + Resolution + "','" + UserName + "','" + SPA + "','" + PA + "','" + Request_Status + "','" + Priority + "','" + Location + "','" + Comment + "','" + URL + "','" + Project + "','" + Date + "','" + R_Comment + "')";
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

    public static Request updateRequest(Request request, Connection connection) throws SQLException {
        System.out.println("Query - for update a request");
        int Id = request.getId();
        String Device_name = request.getDevice_name();
        String Type = request.getType();
        String Platform = request.getPlatform();
        String OS = request.getOS();
        String Priority = request.getPriority();
        String Size = request.getSize();
        String Resolution = request.getResolution();
        String Location = request.getLocation();
        String SPA = request.getSPA();
        String PA = request.getPA();
        String Request_Status = request.getRequest_Status();
        String Project = request.getProject();
        String URL = request.getURL();
        String UserName = request.getUserName();
        String Comment = request.getComment();
        String Date = request.getDate();
        String R_Comment = request.getReject_comment();
        String device_ID = request.getDevice_ID();

        String query = "UPDATE device SET"
                + " device_Name = '" + Device_name + "', type = '" + Type + "', platform = '" + Platform + "', OS = '" + OS + "', size = '" + Size + "', resolution = '" + Resolution + "', username = '" + UserName + "', product_Area = '" + PA + "', sub_Product_Area = '" + SPA + "', request_Status = '" + Request_Status + "', priority = '" + Priority + "', location = '" + Location + "', comments = '" + Comment + "', url = '" + URL + "', project = '" + Project + "', requested_Date = '" + Date + "',device_ID = '" + device_ID + "', reject_comment = '" + R_Comment + "' WHERE request_ID = " + Id;

        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return request;
    }

    public static Edit_Mode editDetails(Edit_Mode edit_Mode, Connection connection) throws SQLException {
        System.out.println("Query - for edit details of available device");
        String device_ID = edit_Mode.getDevice_ID();
        String device_Name = edit_Mode.getDevice_Name();
        String product_Area = edit_Mode.getProduct_Area();
        String sub_Product_Area = edit_Mode.getSub_Product_Area();
        String resolution = edit_Mode.getResolution();
        String size = edit_Mode.getSize();
        String os = edit_Mode.getOs();
        String url = edit_Mode.getUrl();
        String location = edit_Mode.getLocation();
        String type = edit_Mode.getType();
        String platform = edit_Mode.getPlatform();
        int request_ID = edit_Mode.getRequest_ID();

        String query = "UPDATE device SET"
                + " device_ID = '" + device_ID + "', device_Name = '" + device_Name + "', product_Area = '" + product_Area + "', sub_Product_Area = '" + sub_Product_Area + "', resolution = '" + resolution + "'," + " size = '" + size + "', os = '" + os + "', url = '" + url + "', location = '" + location + "', type = '" + type + "'," + " platform = '" + platform + "' WHERE request_ID = " + request_ID;

        System.out.println(query);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return edit_Mode;
    }

    public static ArrayList<Request> getRequest(Connection connection) throws Exception {
        System.out.println("Query - for get all requests");
        ArrayList<Request> requests = new ArrayList<Request>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM device where request_Status != 'Available'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Request req = new Request();
                req.setId(rs.getInt("request_ID"));
                req.setDevice_name(rs.getString("device_Name"));
                req.setType(rs.getString("type"));
                req.setPlatform(rs.getString("platform"));
                req.setOS(rs.getString("os"));
                req.setSize(rs.getString("size"));
                req.setResolution(rs.getString("resolution"));
                req.setUserName(rs.getString("username"));
                req.setPA(rs.getString("product_Area"));
                req.setSPA(rs.getString("sub_Product_Area"));
                req.setRequest_Status(rs.getString("request_Status"));
                req.setPriority(rs.getString("priority"));
                req.setLocation(rs.getString("location"));
                req.setComment(rs.getString("comments"));
                req.setURL(rs.getString("url"));
                req.setProject(rs.getString("project"));
                req.setDate(rs.getString("requested_Date"));
                req.setReject_comment(rs.getString("reject_comment"));
                requests.add(req);
            }
            return requests;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String deleteRequest(int reqId, Connection connection) throws SQLException {
        System.out.println("Query - for delete rejected request");
        int request_ID = reqId;
        String query = "DELETE FROM device WHERE request_ID = " + request_ID;
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return "Successfull!!!";
    }

    public static BorrowDevice addBorrowRequest(BorrowDevice borrowRequest, Connection connection) throws SQLException {
        System.out.println("Inside the addBorrowRequest Query");

        String transaction_Mode = borrowRequest.getTransaction_Mode();
        String color = borrowRequest.getColor();
        String transaction_Type = borrowRequest.getTransaction_Type();
        String username = borrowRequest.getUsername();
        String device_ID = borrowRequest.getDevice_ID();
        String from_Date = borrowRequest.getFrom_Date();
        String to_Date = borrowRequest.getTo_Date();

        String query = "INSERT INTO borrow_device"
                + " (transaction_Mode, color, transaction_Type, username, device_ID, from_Date, to_Date)"
                + " VALUES ('" + transaction_Mode + "','" + color + "','" + transaction_Type + "','" + username + "','" + device_ID + "','" + from_Date + "','" + to_Date + "')";

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
        System.out.println("GetBorrowDevice Query");
        BorrowDevice borrowreq = new BorrowDevice();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM borrow_device");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                borrowreq.setTransaction_ID(rs.getInt("transaction_ID"));
                borrowreq.setTransaction_Mode(rs.getString("transaction_Mode"));
                borrowreq.setColor(rs.getString("color"));
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

    public static ArrayList<BorrowDevice> getBookedDates(String id, Connection connection) throws Exception {
        System.out.println(" getBookedDate Query");

        ArrayList<BorrowDevice> bookreq = new ArrayList<BorrowDevice>();
        try {

            PreparedStatement ps = connection.prepareStatement("SELECT transaction_Mode, from_Date, to_Date,username FROM borrow_device WHERE device_ID =" + id + " AND ((transaction_Mode = 'booked' AND to_date >= CURDATE()) OR (transaction_Mode = 'unavailable' AND to_date >= CURDATE())) ORDER BY from_Date ASC");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BorrowDevice bookedreq = new BorrowDevice();
//               bookreq.setTransaction_ID(rs.getInt("transaction_ID"));
                bookedreq.setTransaction_Mode(rs.getString("transaction_Mode"));
//                bookreq.setTransaction_Type(rs.getString("transaction_Type"));
                bookedreq.setUsername(rs.getString("username"));
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

            PreparedStatement ps = connection.prepareStatement("SELECT b.`request_ID`,b.`device_ID`,b.`sub_Product_Area`,b.`product_Area`,b.location,b.comments,b.`device_Name`,b.image_no,b.`type`,b.platform,b.`os`,b.`size`,b.resolution,b.`url`,b.`request_Status`,d.`transaction_ID`,IFNULL(d.`transaction_Mode`,\"available\") AS `transaction_Mode`,IFNULL(d.`color`,\"green\") AS `color`,d.`transaction_Type`,d.username,d.`device_ID`,d.`from_Date`,d.`to_Date` FROM device b LEFT JOIN borrow_device d ON (b.device_ID = d.device_ID and CURDATE() between from_Date and to_Date) WHERE b.`request_Status`='Available' GROUP BY b.`device_ID` ORDER BY d.`transaction_Mode` DESC ");

//            PreparedStatement ps = connection.prepareStatement("SELECT a.device_ID,a.sub_Product_Area,a.product_Area,a.location,a.comments,a.device_Name,a.image_no,a.type,a.platform,a.os,a.size,a.resolution,a.url,b.`transaction_ID`,IFNULL(b.`transaction_Mode`,\"available\") AS `transaction_Mode`,IFNULL(b.`color`,\"green\") AS `color`,b.`transaction_Type`,b.username,b.`device_ID`,b.`from_Date`,b.`to_Date` FROM device a LEFT JOIN borrow_device b ON (a.device_ID = b.device_ID and CURDATE() between from_Date and to_Date) GROUP BY a.`device_ID` ORDER BY b.`transaction_Mode` DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DeviceList devicels = new DeviceList();

//                devicels.setName(rs.getString("name"));
                devicels.setDevice_Name(rs.getString("device_Name"));
                devicels.setType(rs.getString("type"));
                devicels.setPlatform(rs.getString("platform"));
                devicels.setImage_no(rs.getInt("image_no"));
//                devicels.setOS(rs.getString("OS"));
                devicels.setOs(rs.getString("os"));
//                devicels.setSub_Product_Area_ID(rs.getString("sub_Product_Area_ID"));
//                devicels.setSub_Product_Area_name(rs.getString("sub_Product_Area_name"));
                devicels.setSub_Product_Area(rs.getString("sub_Product_Area"));
//                devicels.setProduct_Area_name(rs.getString("product_Area_name"));
                devicels.setProduct_Area(rs.getString("product_Area"));
                devicels.setDevice_ID(rs.getString("device_ID"));
                devicels.setUsername(rs.getString("username"));
                devicels.setSize(rs.getString("size"));
                devicels.setResolution(rs.getString("resolution"));
//                devicels.setURL(rs.getString("URL"));
                devicels.setUrl(rs.getString("url"));
                devicels.setLocation(rs.getString("location"));
                devicels.setTransaction_Mode(rs.getString("transaction_Mode"));
                devicels.setColor(rs.getString("color"));

                devicels.setTransaction_ID(rs.getInt("transaction_ID"));
                devicels.setRequest_ID(rs.getInt("request_ID"));
                devicedata.add(devicels);
            }
            return devicedata;
        } catch (Exception e) {
            throw e;
        }
    }

    static ArrayList<DeviceList> GetAllSearchedDevices(String val, Connection connection) throws Exception {
        System.out.println("Inside the Query");
        ArrayList<DeviceList> Searcheddevicedata = new ArrayList<DeviceList>();
        try {
//            PreparedStatement ps = connection.prepareStatement("SELECT b.`device_ID`,b.`sub_Product_Area`,b.`product_Area`,b.location,b.comments,b.`device_Name`,b.image_no,b.`type`,b.platform,b.`os`,b.`size`,b.resolution,b.`url`,b.`request_Status`,d.`transaction_ID`,IFNULL(d.`transaction_Mode`,\"available\") AS `transaction_Mode`,IFNULL(d.`color`,\"green\") AS `color`,d.`transaction_Type`,d.username,d.`device_ID`,d.`from_Date`,d.`to_Date` FROM device b LEFT JOIN borrow_device d ON (b.device_ID = d.device_ID and to_Date >= CURDATE()) WHERE b.`sub_Product_Area` LIKE" + val +  "OR b.`product_Area`LIKE" + val + "OR b.location LIKE" + val + "OR b.`device_Name`LIKE" + val + "OR b.`type`LIKE" + val + "OR b.platform LIKE" + val + "OR b.`os` LIKE" + val + "OR b.`request_Status` LIKE" + val + "OR b.`device_ID` LIKE" + val + "ORDER BY d.`transaction_Mode` DESC");
            PreparedStatement ps = connection.prepareStatement("SELECT b.`device_ID`,b.`sub_Product_Area`,b.`product_Area`,b.location,b.comments,b.`device_Name`,b.image_no,b.`type`,b.platform,b.`os`,b.`size`,b.resolution,b.`url`,b.`request_Status`,d.`transaction_ID`, IF(b.`request_Status` = 'Confirmed', \"Not available\", IF(b.`request_Status` = 'In Progress', \"Not available\", IF(b.`request_Status` = 'Rejected', \"Not available\", IF(b.`request_Status` = 'Requested', \"Not available\", IFNULL(d.`transaction_Mode`,\"available\"))))) AS `transaction_Mode`, IF(b.`request_Status` = 'Confirmed', \"white\", IF(b.`request_Status` = 'In Progress', \"white\", IF(b.`request_Status` = 'Rejected', \"white\", IF(b.`request_Status` = 'Requested', \"white\", IFNULL(d.`color`,\"green\"))))) AS `color`, d.`transaction_Type`,d.username,d.`device_ID`,d.`from_Date`,d.`to_Date` FROM device b LEFT OUTER JOIN borrow_device d ON (b.device_ID = d.device_ID and CURDATE() <= to_Date) WHERE b.`sub_Product_Area` LIKE ('%'" + val + "'%') OR b.`product_Area`LIKE ('%'" + val + "'%') OR b.location LIKE ('%'" + val + "'%') OR b.`device_Name`LIKE ('%'" + val + "'%')OR b.`type`LIKE ('%'" + val + "'%') OR b.platform LIKE ('%'" + val + "'%') OR b.`os` LIKE ('%'" + val + "'%') OR b.`request_Status` LIKE ('%'" + val + "'%') OR b.`device_ID` LIKE ('%'" + val + "'%') ORDER BY d.`transaction_Mode` DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DeviceList Searcheddevicels = new DeviceList();

//                Searcheddevicels.setName(rs.getString("name"));
                Searcheddevicels.setDevice_Name(rs.getString("device_Name"));
                Searcheddevicels.setType(rs.getString("type"));
                Searcheddevicels.setPlatform(rs.getString("platform"));
                Searcheddevicels.setImage_no(rs.getInt("image_no"));
                Searcheddevicels.setOs(rs.getString("os"));
                Searcheddevicels.setSub_Product_Area(rs.getString("sub_Product_Area"));
                Searcheddevicels.setProduct_Area(rs.getString("product_Area"));
                Searcheddevicels.setDevice_ID(rs.getString("device_ID"));
                Searcheddevicels.setUsername(rs.getString("username"));
                Searcheddevicels.setSize(rs.getString("size"));
                Searcheddevicels.setResolution(rs.getString("resolution"));
                Searcheddevicels.setUrl(rs.getString("url"));
                Searcheddevicels.setLocation(rs.getString("location"));
                Searcheddevicels.setTransaction_Mode(rs.getString("transaction_Mode"));
                Searcheddevicels.setColor(rs.getString("color"));
                Searcheddevicels.setTransaction_ID(rs.getInt("transaction_ID"));
                Searcheddevicels.setRequest_Status(rs.getString("request_Status"));
                Searcheddevicels.setFrom_Date(rs.getString("from_Date"));
                Searcheddevicels.setTo_Date(rs.getString("to_date"));
                Searcheddevicedata.add(Searcheddevicels);

            }
            return Searcheddevicedata;
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
        String color = updateDevice.getColor();
        String transaction_Type = updateDevice.getTransaction_Type();
        int transaction_ID = updateDevice.getTransaction_ID();

        String query = "UPDATE borrow_device SET transaction_Mode = 'unavailable', color = 'red', transaction_Type = 'return' WHERE transaction_ID = " + transaction_ID;
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

        String query1 = "INSERT INTO returned_devices ( transaction_ID, transaction_Mode, color, transaction_Type, username, device_ID, from_Date, to_Date, returned_Date ) SELECT transaction_ID, transaction_Mode, color, transaction_Type, username, device_ID, from_Date, to_Date, CURDATE() FROM borrow_device WHERE transaction_ID = " + id + "";
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
