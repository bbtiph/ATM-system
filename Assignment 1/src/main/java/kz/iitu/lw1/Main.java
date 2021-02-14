package kz.iitu.lw1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner in = new Scanner(System.in);

            System.out.println("+********* A T M **********+\n" +
                               "| Welcome:                 |\n" +
                               "| Please enter your PIN:   |\n" +
                               "PIN: ");
            String pin = in.next();

            System.out.println("| Please enter you account:|\n" +
                               "Account: ");
            String account = in.next();
            System.out.println("+**************************+\n\n");
            Bank bank = context.getBean("bank", Bank.class);
            bank.checkPin(account,pin);

            context.close();
    }
}
