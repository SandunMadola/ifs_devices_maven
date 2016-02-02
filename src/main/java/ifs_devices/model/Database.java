/**
 *
 * @author sanmlk
 */
package ifs_devices.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static Connection Get_Connection() throws Exception {
        System.out.println("Database page");
        Connection connection = null; 
        
        String url;
        url = "jdbc:mysql://localhost:3306/devices_ifs";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }                                 
    }
}
