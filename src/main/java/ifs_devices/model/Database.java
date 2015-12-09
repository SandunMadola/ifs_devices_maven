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
        String url = "jdbc:mysql://localhost:3306/ifs_devices";
        String user = "root";
        String password = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

}

//    public static void main(String[] args) {
//        Connection connection = null;
//
//        Statement selectStmt = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
//
//            /*insertStmt = connection.createStatement();
//             insertStmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (1,'Lokesh','Gupta',5)");
//             insertStmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (2,'howtodoinjava','com',5)");*/
//            selectStmt = connection.createStatement();
//            ResultSet rs = selectStmt.executeQuery("SELECT * FROM employee");
//            while (rs.next()) {
//                System.out.println(rs.getString(1));    //First Column
//                System.out.println(rs.getString(2));    //Second Column
//                System.out.println(rs.getString(3));    //Third Column
//                
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                selectStmt.close();
//                connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}