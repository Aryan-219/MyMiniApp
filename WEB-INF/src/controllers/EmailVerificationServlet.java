package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;

@WebServlet("verify.do")
public class EmailVerificationServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        String verificationEmail 
        = "<h1>Welcome to ISRDC Mini App Project</h1>"+
        "<br><br><h2>Click over the email verification link</h2>"+
        "<br><br><a href='http://localhost:8080/83_mini_app/evf.do?email="+email+"&vcode="+vCode+"'>The Verification Link</a>";

        Properties props = new Properties();

        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.host","smtp-mail.outlook.com");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");

        Session s = Session.getInstance(props,new EmailAuthentication());

        MimeMessage mm = new MimeMessage(s);

        try {
            mm.setFrom("aryanagrawal2002@outlookcom");
            mm.setRecipients(Message.RecipientType.TO,email);
            mm.setSubject("From Aryan");
            mm.setContent(verificationEmail, "text/html");
        } catch (MessagingException e) {
            e.printStackTrace();
            
        }
    }
}

class EmailAuthentication extends Authenticator{
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication("aryanagrawal2002@outlook.com","Aryan@21");
    }
}
