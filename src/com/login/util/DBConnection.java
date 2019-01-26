package com.login.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/db1";
        String username = "user1";
        String password = "127.0.0.1";
        try
        {
            try
            {
                Class.forName("org.postgresql.Driver");
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Post establishing a DB connection - "+con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }
}
