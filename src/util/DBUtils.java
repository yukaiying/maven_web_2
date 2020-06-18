package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static Connection con;
    static {
        Properties properties = new Properties();
        InputStream input = DBUtils.class.getClass().getResourceAsStream("/db.properties");
        try {
            properties.load(input);
            Class.forName(properties.getProperty("jdbc.driver"));
            con = DriverManager.getConnection(properties.getProperty("jdbc.url"),properties.getProperty("jdbc.username"),properties.getProperty("jdbc.password"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        return con;
    }

    public static void closeCon(Connection con){
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
