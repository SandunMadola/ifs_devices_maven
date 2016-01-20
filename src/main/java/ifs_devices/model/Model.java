package ifs_devices.model;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author sanmlk
 */
public class Model {

    public ArrayList<Employee> GetFeeds() throws Exception {
        System.out.println("Inside the Model");
        ArrayList<Employee> feeds = null;
        try {
            //Database database = new Database();
            //Connection connection = database.Get_Connection();
            Connection connection = Database.Get_Connection();
            //Query select_sql = new Query();
            //feeds = select_sql.GetFeeds(connection);
            feeds = Query.GetFeeds(connection);

        } catch (Exception e) {
            throw e;
        }
        return feeds;
    }

    public Request addRequest(Request request) throws Exception {
        System.out.println("Inside the model");
        Request req = null;
        try {
            Connection connection = Database.Get_Connection();
            req = Query.addRequest(request, connection);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return req;
    }

    public ArrayList<Request> GetRequest() {
        System.out.println("Inside the model");
        ArrayList<Request> req = null;
        try {
            Connection connection = Database.Get_Connection();
            req = Query.getRequest(connection);
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return req;
    }

    public Request updateRequest(Request request) throws Exception {
        System.out.println("Inside the model");
        Request req = null;
        try {
            Connection connection = Database.Get_Connection();
            req = Query.updateRequest(request, connection);
        } catch (Exception e) {
            System.out.println("erro" + e);
        }

        return req;
    }

    public BorrowDevice addBorrowRequest(BorrowDevice borrowRequest) throws Exception {
        System.out.println("Inside the model");
        BorrowDevice borrowreq = null;
        try {
            Connection connection = Database.Get_Connection();
            borrowreq = Query.addBorrowRequest(borrowRequest, connection);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return borrowreq;
    }

    public BorrowDevice GetBorrowRequest() {
        System.out.println("Inside the GetBorrowRequest() model");
        
        BorrowDevice borrowreq = null;
        try {
            Connection connection = Database.Get_Connection();
            borrowreq = Query.getBorrowRequest(connection);
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return borrowreq;
    }

    public ArrayList<BorrowDevice> GetbookedDates(String id) {
        System.out.println("Inside the GetbookedDates() model");
        ArrayList<BorrowDevice> bookreq = null;
        
        try {
            Connection connection = Database.Get_Connection();
            bookreq = Query.getBookedDates(id,connection);
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return bookreq;
    }
    
    public ArrayList<DeviceList> GetAllDevices() throws Exception {

        ArrayList<DeviceList> allDevices = null;
        try {
            Connection connection = Database.Get_Connection();
            allDevices = Query.GetAllDevices(connection);
        } catch (Exception e) {
            throw e;
        }
        return allDevices;
    }

    public ArrayList<DeviceList> GetAllSearchedDevices() throws Exception {

        ArrayList<DeviceList> allSearchedDevices = null;
        try {
            Connection connection = Database.Get_Connection();
            allSearchedDevices = Query.GetAllSearchedDevices(connection);
        } catch (Exception e) {
            throw e;
        }
        return allSearchedDevices;
    }
    
    public String deleteTransaction(int id) throws Exception {
        System.out.println("Inside the model");
        String del = null;
        try {
            Connection connection = Database.Get_Connection();
            del = Query.deleteTransaction(id, connection);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return del;
    }
    
    public BorrowDevice updateDevice(BorrowDevice updateDevice) throws Exception {
        System.out.println("Inside the model");
        BorrowDevice update = null;
        try {
            Connection connection = Database.Get_Connection();
            update = Query.updateDevice(updateDevice, connection);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return update;
    }

  public String returnDeviceTransaction(int id) throws Exception {
        System.out.println("Inside the model");
        String ret = null;
        try {
            Connection connection = Database.Get_Connection();
            ret = Query.returnDeviceTransaction(id, connection);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return ret;
    }
    
}
