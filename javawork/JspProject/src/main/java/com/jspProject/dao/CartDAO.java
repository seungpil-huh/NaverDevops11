package com.jspProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.jspProject.util.DBUtil;

public class CartDAO {
    public static boolean addToCart(int userId, int productId, int quantity) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO tb_cart (user_id, item_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, productId);
            pstmt.setInt(3, quantity);
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
