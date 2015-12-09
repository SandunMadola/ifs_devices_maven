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
            System.out.println("erro" + e);
        }

        return req;
    }
}
