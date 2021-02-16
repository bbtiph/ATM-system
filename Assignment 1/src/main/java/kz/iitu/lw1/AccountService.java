package kz.iitu.lw1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class AccountService {
    @Value("jdbc:mysql://localhost:3306/atm")
    private String dbUrl;
    @Value("root")
    private String dbUsername;
    @Value("")
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

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);



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


    public void destroy() throws SQLException {
        this.closeConnections();
    }

    public void closeConnections() throws SQLException {
        connection.close();
        System.out.println("UserService.closeConnections");
    }
}
