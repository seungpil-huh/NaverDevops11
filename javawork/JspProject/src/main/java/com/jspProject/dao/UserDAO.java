package com.jspProject.dao;

import com.jspProject.dto.UserDTO;
import com.jspProject.util.DBUtil;

import java.sql.*;

public class UserDAO {

    public static UserDTO getUserInfo(String username) {
        String sql = "SELECT * FROM tb_user WHERE username = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new UserDTO(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getDouble("point"),
                    rs.getString("nickname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
