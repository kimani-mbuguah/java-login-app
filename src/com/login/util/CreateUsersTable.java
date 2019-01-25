package com.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.login.util.DBConnection;

public class CreateUsersTable {

    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/db1",
                            "user1", "127.0.0.1");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE users " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " EMAIL            TEXT     NOT NULL, " +
                    " USERNAME        TEXT, " +
                    " PASSWORD         CHAR (50)," +
                    " ROLE           TEXT    NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}
