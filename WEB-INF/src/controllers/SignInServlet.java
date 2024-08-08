package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

import models.User;

@WebServlet("/signin.do")
public class SignInServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        String forwardURL = "signin.jsp";
        String email = request.getParameter("eml");
        String password = request.getParameter("pwd");

        User user = new User();
        boolean result = user.signInUser(email, password);
        if(result){
            session.setAttribute("email", email);
            // forwardURL = "dashboard.jsp";
            forwardURL = "verification.jsp";
        }
        request.getRequestDispatcher(forwardURL).forward(request,response);
    }
}
