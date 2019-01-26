package com.login.val;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.login.gettersetter.GetterSetter;
import com.login.util.DBConnection;

public class LoginVal {
    public String authenticateUser(GetterSetter getterSetter) {

        String email = getterSetter.getEmail();
        String password = getterSetter.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String emailInDB = "kimanimbuguah@gmail.com";
        String passwordInDB = "127.0.0.1";
        String roleInDB = "Student";

        if(email.equals(emailInDB) && password.equals(passwordInDB) && roleInDB.equals("Admin")) {
            return "Admin";
        }
        else if(email.equals(emailInDB) && password.equals(passwordInDB) && roleInDB.equals("Student")){
            return "Student";
        }else {
            return "Invalid credentials";
        }


//        try {
//            con = DBConnection.createConnection();
//            statement = con.createStatement();
//            resultSet = statement.executeQuery("select email,password,role from users");
//
//            while(resultSet.next())
//            {
//                emailInDB = resultSet.getString("email");
//                passwordInDB = resultSet.getString("password");
//                roleInDB = resultSet.getString("role");
//
//                if(email.equals(emailInDB) && password.equals(passwordInDB) && roleInDB.equals("Admin"))
//                    return "Admin";
//                else if(email.equals(emailInDB) && password.equals(passwordInDB) && roleInDB.equals("Student"))
//                    return "Student";
//            }
//        }
//        catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
    }
}
