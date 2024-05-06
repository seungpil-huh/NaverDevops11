package com.jspProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspProject.util.DBUtil;

import java.sql.*;

@WebServlet("/LoginRegisterServlet")
public class LoginRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (action == null || username == null || password == null) {
            response.sendRedirect("loginRegister.jsp?error=InvalidInput");
            return;
        }

        if (password.length() < 8) {
            response.sendRedirect("loginRegister.jsp?error=PasswordShort");
            return;
        }

        try (Connection conn = DBUtil.getConnection()) {
            if ("register".equals(action)) {
                String email = request.getParameter("email");
                if (email == null) {
                    response.sendRedirect("loginRegister.jsp?error=InvalidEmail");
                    return;
                }

                // Check if username or email already exists
                PreparedStatement checkStmt = conn.prepareStatement("SELECT * FROM tb_user WHERE username = ? OR email = ?");
                checkStmt.setString(1, username);
                checkStmt.setString(2, email);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    response.sendRedirect("loginRegister.jsp?error=UserExists");
                    return;
                }

                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tb_user (username, password, email) VALUES (?, SHA2(?, 256), ?)");
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setString(3, email);
                int result = pstmt.executeUpdate();
                if (result > 0) {
                    response.sendRedirect("loginRegister.jsp?success=RegistrationSuccess");
                } else {
                    response.sendRedirect("loginRegister.jsp?error=DatabaseError");
                }
            } else if ("login".equals(action)) {
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM tb_user WHERE username = ? AND password = SHA2(?, 256)");
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    response.sendRedirect("category.jsp");
                } else {
                    response.sendRedirect("loginRegister.jsp?error=InvalidLogin");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("loginRegister.jsp?error=DatabaseError");
        }
    }
}
