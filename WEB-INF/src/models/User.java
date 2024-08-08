package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class User {
    private int userId;
    private String userName;
    private String email;
    private String password;

    public User() {

    }

    public User(int userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;

    }

    public User(String userName, String email, String password) {

        this.userName = userName;
        this.email = email;
        this.password = password;

    }

    public boolean signUpUser() {
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp?user=root&password=1234");

            String query = "insert into users (user_name, password, email) value (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, email);

            int x = ps.executeUpdate();

            if (x == 1) {
                flag = true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean signInUser(String email, String password) {
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp?user=root&password=1234");
            String query = "select password from users where email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,email);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                String pwd = rs.getString(1);
                if(pwd.equals(password)){
                    flag = true;
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
