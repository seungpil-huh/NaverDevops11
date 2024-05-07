package com.jspProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspProject.util.DBUtil;

import java.sql.*;

@WebServlet("/LoginRegisterServlet")
public class LoginRegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");

	    // 로그인 액션 시에는 nickname 필드를 확인하지 않아야 함
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
	            String nickname = request.getParameter("nickname");
	            if (email == null || nickname == null) {
	                response.sendRedirect("loginRegister.jsp?error=InvalidInput");
	                return;
	            }

	            // 사용자 이름, 이메일 또는 닉네임이 이미 존재하는지 확인
	            PreparedStatement checkStmt = conn.prepareStatement("SELECT * FROM tb_user WHERE username = ? OR email = ? OR nickname = ?");
	            checkStmt.setString(1, username);
	            checkStmt.setString(2, email);
	            checkStmt.setString(3, nickname);
	            ResultSet rs = checkStmt.executeQuery();
	            if (rs.next()) {
	                response.sendRedirect("loginRegister.jsp?error=UserExists");
	                return;
	            }

	            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tb_user (username, password, email, point, nickname) VALUES (?, SHA2(?, 256), ?, ?, ?)");
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);
	            pstmt.setString(3, email);
	            pstmt.setDouble(4, 10000000);
	            pstmt.setString(5, nickname);
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
	            	// 세션 생성 및 사용자 정보 저장
	                HttpSession session = request.getSession();
	                session.setAttribute("userId", rs.getInt("id"));
	                session.setAttribute("username", rs.getString("username"));
	                session.setAttribute("nickname", rs.getString("nickname"));
	                session.setAttribute("point", rs.getDouble("point"));
	                
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
