package com.login.val;
import java.sql.*;

import com.login.gettersetter.GetterSetter;

public class LoginVal {
    public String authenticateUser(GetterSetter getterSetter) {
        //compare the user's inputs with those in the database
        String email = getterSetter.getEmail();
        String password = getterSetter.getPassword();

        String emailInDB = "";
        String passwordInDB = "";
        String roleInDB = "";

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:10827/db1",
                            "user1", "127.0.0.1");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM LOGIN_APP_USERS;" );
            while(rs.next()) {
                emailInDB = rs.getString("email");
                passwordInDB = rs.getString("password");
                roleInDB = rs.getString("role");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }

        if(email.equals(emailInDB) && password.equals(passwordInDB) && roleInDB.equals("Admin")) {
            return "Admin";
        }
        else if(email.equals(emailInDB) && password.equals(passwordInDB) && roleInDB.equals("Student")){
            return "Student";
        }else {
            return "Invalid Credentials";
        }
    }
}
