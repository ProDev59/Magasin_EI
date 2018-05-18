package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUsers {

    private static String url = "jdbc:hsqldb:file:users";
    private static String user = "sa";
    private static String passwd = "";
    private static Connection connect;

    public static Connection getInstance(){
        if(connect == null){
            try {
                Class.forName("org.hsqldb.jdbcDriver").newInstance();
                connect = DriverManager.getConnection(url, user,  passwd);
            } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return connect;

    }

}