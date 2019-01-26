package com.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.gettersetter.GetterSetter;
import com.login.val.LoginVal;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        String email = request.getParameter("email");

        GetterSetter getterSetter =  new GetterSetter();

        getterSetter.setEmail(email);
        getterSetter.setPassword(password);

        LoginVal loginVal = new LoginVal();


        try {
            String userValidate = loginVal.authenticateUser(getterSetter);

            if(userValidate.equals("Student")) {
                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", email); //setting session attribute
                request.setAttribute("userName", email);
                request.getRequestDispatcher("student.jsp").forward(request, response);
            }else if(userValidate.equals("Admin")) {
                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", email); //setting session attribute
                request.setAttribute("userName", email);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }else  {
                System.out.println("Error message = " + userValidate);
                request.setAttribute("errMessage", userValidate);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        }catch (IOException e1) {
            e1.printStackTrace();
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

