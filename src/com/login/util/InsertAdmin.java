package com.login.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertAdmin {

    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/db1",
                            "user1", "127.0.0.1");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO LOGIN_APP_USERS (EMAIL,PASSWORD,ROLE) "
                    + "VALUES ('admin1@gmail.com','mypassword', 'Admin' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO LOGIN_APP_USERS (EMAIL,PASSWORD,ROLE) "
                    + "VALUES ('student1@gmail.com','mypassword', 'Student' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO LOGIN_APP_USERS (EMAIL,PASSWORD,ROLE) "
                    + "VALUES ('student2@gmail.com','mypassword', 'Student' );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Record created successfully");
    }

}
