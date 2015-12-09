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
        int Priority = request.getPriority();
        int Size = request.getSize();
        String Resolution = request.getResolution();
        String Location = request.getLocation();
        String SPA = request.getSPA();
        String Project = request.getProject();
        String URL = request.getURL();
        String UserName = request.getUserName();
        String Comment = request.getComment();
        
        String query = "INSERT INTO employee (name,age) VALUES ('" + Device_name + "'," + Size + ")";
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("erro" + e);
        }

        return request;
    }
}
