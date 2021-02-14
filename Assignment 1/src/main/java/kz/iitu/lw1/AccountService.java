package kz.iitu.lw1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.*;

public class AccountService {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    Connection connection = null;

    public AccountService() throws SQLException {
    }
    //Factory method!!!!!!!
    public static AccountService getAccountService() throws SQLException {
        return new AccountService();
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void init() {
        this.createDbConnection();
    }

    public void createDbConnection() {

        try {

            // Load the MySQL JDBC driver

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);


            // Create a connection to the database

            String serverName = "localhost";

            String schema = "test";

            String url = "jdbc:mysql://" + serverName +  "/" + schema;

            String username = "username";

            String password = "password";

            connection = DriverManager.getConnection(url, username, password);



            System.out.println("Successfully Connected to the database!");


        } catch (ClassNotFoundException e) {

            System.out.println("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {

            System.out.println("Could not connect to the database " + e.getMessage());
        }

    }

    public Connection getConnection(){
        return connection;
    }

    connection.close();
    public void destroy() {
        this.closeConnections();
    }

    public void closeConnections() {
        System.out.println("UserService.closeConnections");
    }
}
