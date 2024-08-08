package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

import java.io.IOException;

import models.User;
@WebServlet("/signup.do")
public class SignUpServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
        rd.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String forwardURL = "signup.jsp";
        String username = request.getParameter("unm");
        String email = request.getParameter("eml");
        String password = request.getParameter("pwd");

        User user = new User(username, email, password);
        boolean result = user.signUpUser();
        if(result){
            forwardURL= "signin.jsp";
        }
        request.getRequestDispatcher(forwardURL).forward(request, response);
    }
}